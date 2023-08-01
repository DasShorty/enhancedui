package de.dasshorty.enhancedui.api.types.chest.animated;

import de.dasshorty.enhancedui.api.exception.OutOfInventoryException;
import de.dasshorty.enhancedui.api.item.UIAction;
import de.dasshorty.enhancedui.api.item.UIItem;
import de.dasshorty.enhancedui.api.UISlot;
import de.dasshorty.enhancedui.api.exception.AnimatedUpdateException;
import de.dasshorty.enhancedui.api.types.chest.ChestUI;
import de.dasshorty.enhancedui.api.UIRow;
import lombok.val;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public abstract class AnimatedChestUI extends ChestUI {
  protected final List<UIRow> animatedRows;
  private final Map<Integer, UIItem> updatedItems = new HashMap<>();
  private final List<UIItem> items;

  public AnimatedChestUI(Component uiTitle, UIRow slots, List<UIRow> animatedRows, List<UIItem> items, Player opener) {
    super(uiTitle, slots, opener);
    this.animatedRows = animatedRows;
    this.items = items;
  }

  private void animate(AnimateDirection direction, Consumer<Void> onAnimationTick) {
    moveItems(itemsMap, direction);
  }

  @Override
  public boolean animated() {
    return true;
  }

  private void moveItems(Map<UIItem, UIAction> itemsMap, AnimateDirection direction) {

    val uiItems = itemsMap.keySet();

    uiItems.forEach(uiItem -> {
      switch (direction) {
        case UP -> moveItemUp(uiItem);
        case DOWN -> moveItemDown(uiItem);
        case LEFT -> moveItemLeft(uiItem);
        case RIGHT -> moveItemRight(uiItem);
      }

      updateItems();
      try {
        refreshInventory();
      } catch (OutOfInventoryException e) {
        throw new RuntimeException(e);
      }

    });

  }

  @Override
  public void open(Player player) {
    player.openInventory(getInventory());
  }

  private void moveItemLeft(UIItem item) {

    val inventoryRows = rows.getRow();
    val currentSlot = item.getCurrentSlot().getSlot();

    val newSlotId = currentSlot - inventoryRows;
    if (newSlotId < 0)

      updatedItems.put(-item.getCurrentSlot().getSlot(), item);

    else

      updatedItems.put(newSlotId, item);


  }

  private void moveItemRight(UIItem item) {
    val inventoryRows = rows.getRow();
    val currentSlot = item.getCurrentSlot().getSlot();

    val newSlotId = currentSlot + inventoryRows;
    if (newSlotId < rows.getSlots() - 1)

      updatedItems.put(-item.getCurrentSlot().getSlot(), item);

    else

      updatedItems.put(newSlotId, item);
  }

  private void updateItems() {

    updatedItems.forEach((integer, item) -> {

      if (integer < 0) {

        itemsMap.remove(item);

      } else {

        val uiAction = itemsMap.get(item);
        val uiSlot = UISlot.fromSlotId(integer);

        if (uiSlot.isPresent()) {

          item.setCurrentSlot(uiSlot.get());
          itemsMap.put(item, uiAction);

        } else
          try {

            throw new AnimatedUpdateException(item);

          } catch (AnimatedUpdateException e) {

            throw new RuntimeException(e);

          }


      }

    });

  }

  private void moveItemDown(UIItem item) {

    if (item.getCurrentSlot().getSlot() <= rows.getSlots() - 9)

      updatedItems.put(-item.getCurrentSlot().getSlot(), item);

    else

      updatedItems.put(item.getCurrentSlot().getSlot() - 9, item);

  }

  private void moveItemUp(UIItem item) {

    if (item.getCurrentSlot().getSlot() >= 8)

      updatedItems.put(-item.getCurrentSlot().getSlot(), item);

    else

      updatedItems.put(item.getCurrentSlot().getSlot() - 9, item);

  }

}
