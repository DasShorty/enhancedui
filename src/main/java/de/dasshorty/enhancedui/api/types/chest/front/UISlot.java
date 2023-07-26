package de.dasshorty.enhancedui.api.types.chest.front;

import de.dasshorty.enhancedui.api.types.chest.UIRow;
import lombok.Getter;

@Getter
public enum UISlot {

  SLOT_0(UIRow.ROW_1, 0),
  SLOT_1(UIRow.ROW_1, 1),
  SLOT_2(UIRow.ROW_1, 2),
  SLOT_3(UIRow.ROW_1, 3),
  SLOT_4(UIRow.ROW_1, 4),
  SLOT_5(UIRow.ROW_1, 5),
  SLOT_6(UIRow.ROW_1, 6),
  SLOT_7(UIRow.ROW_1, 7),
  SLOT_8(UIRow.ROW_1, 8),
  SLOT_9(UIRow.ROW_2, 9), // 1
  SLOT_10(UIRow.ROW_2, 10),
  SLOT_11(UIRow.ROW_2, 11),
  SLOT_12(UIRow.ROW_2, 12),
  SLOT_13(UIRow.ROW_2, 13),
  SLOT_14(UIRow.ROW_2, 14),
  SLOT_15(UIRow.ROW_2, 15),
  SLOT_16(UIRow.ROW_2, 16),
  SLOT_17(UIRow.ROW_2, 17),
  SLOT_18(UIRow.ROW_3, 18), // 2
  SLOT_19(UIRow.ROW_3, 19),
  SLOT_20(UIRow.ROW_3, 20),
  SLOT_21(UIRow.ROW_3, 21),
  SLOT_22(UIRow.ROW_3, 22),
  SLOT_23(UIRow.ROW_3, 23),
  SLOT_24(UIRow.ROW_3, 24),
  SLOT_25(UIRow.ROW_3, 25),
  SLOT_26(UIRow.ROW_3, 26),
  SLOT_27(UIRow.ROW_4, 27), // 3
  SLOT_28(UIRow.ROW_4, 28),
  SLOT_29(UIRow.ROW_4, 29),
  SLOT_30(UIRow.ROW_4, 30),
  SLOT_31(UIRow.ROW_4, 31),
  SLOT_32(UIRow.ROW_4, 32),
  SLOT_33(UIRow.ROW_4, 33),
  SLOT_34(UIRow.ROW_4, 34),
  SLOT_35(UIRow.ROW_4, 35),
  SLOT_36(UIRow.ROW_5, 36), // 4
  SLOT_37(UIRow.ROW_5, 37),
  SLOT_38(UIRow.ROW_5, 38),
  SLOT_39(UIRow.ROW_5, 39),
  SLOT_40(UIRow.ROW_5, 40),
  SLOT_41(UIRow.ROW_5, 41),
  SLOT_42(UIRow.ROW_5, 42),
  SLOT_43(UIRow.ROW_5, 43),
  SLOT_44(UIRow.ROW_5, 44),
  SLOT_45(UIRow.ROW_6, 45), // 5
  SLOT_46(UIRow.ROW_6, 46),
  SLOT_47(UIRow.ROW_6, 47),
  SLOT_48(UIRow.ROW_6, 48),
  SLOT_49(UIRow.ROW_6, 49),
  SLOT_50(UIRow.ROW_6, 50),
  SLOT_51(UIRow.ROW_6, 51),
  SLOT_52(UIRow.ROW_6, 52),
  SLOT_53(UIRow.ROW_6, 53); // 6

  private final UIRow parent;
  private final int slot;

  UISlot(UIRow parent, int slot) {
    this.parent = parent;
    this.slot = slot;
  }
}
