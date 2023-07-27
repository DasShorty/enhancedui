package de.dasshorty.enhancedui.api.exception;

import de.dasshorty.enhancedui.api.UIItem;

public class AnimatedUpdateException extends Throwable {
  public AnimatedUpdateException(UIItem item) {
    super("Item from origin slot " + item.getCurrentSlot().getSlot() + " can't be animated!");
  }
}
