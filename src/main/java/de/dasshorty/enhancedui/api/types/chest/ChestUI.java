package de.dasshorty.enhancedui.api.types.chest;

import de.dasshorty.enhancedui.api.UIReference;
import de.dasshorty.enhancedui.api.UIRow;
import de.dasshorty.enhancedui.api.UISlot;
import de.dasshorty.enhancedui.api.UIType;
import de.dasshorty.enhancedui.api.background.UIBackground;
import de.dasshorty.enhancedui.api.exception.OutOfInventoryException;
import de.dasshorty.enhancedui.api.item.UIAction;
import de.dasshorty.enhancedui.api.item.UIItem;
import lombok.Getter;
import lombok.val;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ChestUI implements InventoryHolder, UIReference {

  @Getter
  protected final Map<UIItem, UIAction> itemsMap = new HashMap<>();
  protected final UIRow rows;
  private final Component uiTitle;
  private final Inventory inventory;
  private UIBackground background;

  public ChestUI(Component uiTitle, UIRow slots, Player opener) {
    this.uiTitle = uiTitle;
    this.rows = slots;
    this.inventory = Bukkit.createInventory(this, slots.getSlots(), uiTitle);

    background = new UIBackground(UIBackground.BackgroundType.NONE, List.of());

    try {
      initItems(opener);
    } catch (OutOfInventoryException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void open(Player player) {
    try {
      refreshInventory();
    } catch (OutOfInventoryException e) {
      throw new RuntimeException(e);
    }
    player.openInventory(inventory);
  }

  protected abstract void initItems(Player opener) throws OutOfInventoryException;

  public void setBackground(UIBackground background) {
    this.background = background;
  }

  protected void refreshInventory() throws OutOfInventoryException {
    itemsMap.forEach((item, uiAction) -> this.inventory.setItem(item.getOriginSlot().getSlot(), item.buildItem()));

    for (int i = 0; i < this.rows.getSlots(); i++) {

      val item = inventory.getItem(i);

      if (background.type() == UIBackground.BackgroundType.NONE)
        continue;

      if (item == null) {

        switch (background.type()) {
          case FULL -> {

            val uiItem = background.backgroundItems().get(0);
            item(new UIItem(uiItem.buildItem(), UISlot.fromSlotId(i).get()), (clicker, clickedItem, action) -> true);

          }
          case SELF -> {

            if (background.backgroundItems().size() < this.rows.getSlots()) {

              if (i != 0) {

                val uiItem = background.backgroundItems().get(0);
                item(new UIItem(uiItem.buildItem(), UISlot.fromSlotId(i).get()), (clicker, clickedItem, action) -> true);

              }

              throw new IllegalArgumentException("Not enough items for a self background in the list. Required: " + this.rows.getSlots() + " got: " + background.backgroundItems().size() + " items");

            } else {
              val uiItem = background.backgroundItems().get(i);
              item(new UIItem(uiItem.buildItem(), UISlot.fromSlotId(i).get()), (clicker, clickedItem, action) -> true);
            }

          }
        }

      }

    }
  }

  public void item(UIItem item, UIAction click) throws OutOfInventoryException {

    if (!UIRow.isParentFrom(rows, item.getOriginSlot().getParent()))
      throw new OutOfInventoryException(this, item, rows);

    itemsMap.put(item, click);
  }

  @Override
  public boolean animated() {
    return false;
  }

  @Override
  public @NotNull Inventory getInventory() {
    return inventory;
  }

  @Override
  public Component displayText() {
    return uiTitle;
  }

  @Override
  public UIType type() {
    return UIType.CHEST;
  }
}
