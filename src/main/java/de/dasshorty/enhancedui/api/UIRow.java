package de.dasshorty.enhancedui.api;

import lombok.Getter;

@Getter
public enum UIRow {

  CHEST_ROW_1(9, 1, UIType.CHEST),
  CHEST_ROW_2(18, 2, UIType.CHEST),
  CHEST_ROW_3(27, 3, UIType.CHEST),
  CHEST_ROW_4(36, 4, UIType.CHEST),
  CHEST_ROW_5(45, 5, UIType.CHEST),
  CHEST_ROW_6(54, 6, UIType.CHEST);

  final int slots;
  final int row;
  private final UIType type;

  UIRow(int slots, int row, UIType type) {
    this.slots = slots;
    this.row = row;
    this.type = type;
  }

  /**
   * @param origin The Row that should be checked
   * @param parent The Row that is below the origin row
   * @return if the origin has more or same rows than the parent
   */
  public static boolean isParentFrom(UIRow origin, UIRow parent) {

    if (origin == parent)
      return true;

    return origin.slots > parent.slots;
  }
}
