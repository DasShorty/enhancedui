package de.dasshorty.enhancedui.background;

import de.dasshorty.enhancedui.item.UIItem;

import java.util.List;

public record UIBackground(BackgroundType type, List<UIItem> backgroundItems) {



  public enum BackgroundType {
    FULL,
    NONE,
    SELF
  }

}
