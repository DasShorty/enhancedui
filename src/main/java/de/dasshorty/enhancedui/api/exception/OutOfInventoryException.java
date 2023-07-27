package de.dasshorty.enhancedui.api.exception;

import de.dasshorty.enhancedui.api.UIReference;
import de.dasshorty.enhancedui.api.types.chest.ChestUIRow;
import de.dasshorty.enhancedui.api.UIItem;

public class OutOfInventoryException extends Throwable {
  public OutOfInventoryException(UIReference reference, UIItem item, ChestUIRow inventoryRow) {
    super(reference.type() + " | illegal item! specified item slot is higher then the inventory size. Item requires size of " + item.getOriginSlot().getParent().name() + " instead got " + inventoryRow.name());
  }
}
