package de.dasshorty.enhancedui.api.background;

import de.dasshorty.enhancedui.api.item.UIItem;

import java.util.List;

public record UIBackground(BackgroundType type, List<UIItem> backgroundItems) {



  public enum BackgroundType {
    FULL,
    NONE,
    SELF
  }

}
