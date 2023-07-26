package de.dasshorty.enhancedui.api.types.chest;

import de.dasshorty.enhancedui.api.UIReference;
import de.dasshorty.enhancedui.api.UIType;
import de.dasshorty.enhancedui.api.exception.OutOfInventoryException;
import de.dasshorty.enhancedui.api.types.chest.front.UIAction;
import de.dasshorty.enhancedui.api.types.chest.front.UIItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public abstract class UI implements InventoryHolder, UIReference {

  protected final Map<UIItem, UIAction> itemsMap = new HashMap<>();
  private final Component uiTitle;
  private final Inventory inventory;
  private final UIRow rows;

  public UI(Component uiTitle, UIRow slots, Player opener) {
    this.uiTitle = uiTitle;
    this.rows = slots;
    this.inventory = Bukkit.createInventory(this, slots.getSlots(), uiTitle);

    initItems(opener);
    refreshInventory();
  }

  protected abstract void initItems(Player opener);

  protected void refreshInventory() {
    itemsMap.forEach((item, uiAction) -> this.inventory.setItem(item.getOriginSlot().getSlot(), item.buildItem()));
  }


  public void item(UIItem item, UIAction click) throws OutOfInventoryException {

    if (!UIRow.isParentFrom(rows, item.getOriginSlot().getParent()))
      throw new OutOfInventoryException(this, item, rows);

    itemsMap.put(item, click);
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
