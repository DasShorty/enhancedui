package de.dasshorty.enhancedui.exception;

import de.dasshorty.enhancedui.item.UIItem;

public class AnimatedUpdateException extends Throwable {
  public AnimatedUpdateException(UIItem item) {
    super("Item from origin slot " + item.getCurrentSlot().getSlot() + " can't be animated!");
  }
}
