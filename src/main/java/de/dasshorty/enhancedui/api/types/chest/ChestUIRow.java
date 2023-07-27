package de.dasshorty.enhancedui.api.types.chest;

import lombok.Getter;

@Getter
public enum ChestUIRow {

  ROW_1(9, 1),
  ROW_2(18, 2),
  ROW_3(27, 3),
  ROW_4(36, 4),
  ROW_5(45, 5),
  ROW_6(54, 6);

  final int slots;
  final int row;

  ChestUIRow(int slots, int row) {
    this.slots = slots;
    this.row = row;
  }

  /**
   * @param origin The Row that should be checked
   * @param parent The Row that is below the origin row
   * @return if the origin has more or same rows than the parent
   */
  public static boolean isParentFrom(ChestUIRow origin, ChestUIRow parent) {

    if (origin == parent)
      return true;

    return origin.slots > parent.slots;
  }
}
