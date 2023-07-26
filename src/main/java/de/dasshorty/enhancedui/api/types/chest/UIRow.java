package de.dasshorty.enhancedui.api.types.chest;

import lombok.Getter;

public enum UIRow {

  ROW_1(9),
  ROW_2(18),
  ROW_3(27),
  ROW_4(36),
  ROW_5(45),
  ROW_6(54);

  @Getter
  final int slots;
  UIRow(int slots) {
    this.slots = slots;
  }

  /**
   * @param origin The Row that should be checked
   * @param parent The Row that is below the origin row
   * @return if the origin has more or same rows than the parent
   * */
  public static boolean isParentFrom(UIRow origin, UIRow parent) {

    if (origin == parent)
      return true;

    return origin.slots > parent.slots;
  }
}
