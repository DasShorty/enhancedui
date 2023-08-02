package de.dasshorty.enhancedui.exception;

import de.dasshorty.enhancedui.UIReference;
import de.dasshorty.enhancedui.UIRow;
import de.dasshorty.enhancedui.item.UIItem;

public class OutOfInventoryException extends Throwable {
  public OutOfInventoryException(UIReference reference, UIItem item, UIRow inventoryRow) {
    super(reference.type() + " | illegal item! specified item slot is higher then the inventory size. Item requires size of " + item.getOriginSlot().getParent().name() + " instead got " + inventoryRow.name());
  }
}
