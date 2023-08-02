package de.dasshorty.enhancedui;

import lombok.Getter;

import java.util.Optional;

@Getter
public enum UISlot {

  SLOT_0(UIRow.CHEST_ROW_1, 0),
  SLOT_1(UIRow.CHEST_ROW_1, 1),
  SLOT_2(UIRow.CHEST_ROW_1, 2),
  SLOT_3(UIRow.CHEST_ROW_1, 3),
  SLOT_4(UIRow.CHEST_ROW_1, 4),
  SLOT_5(UIRow.CHEST_ROW_1, 5),
  SLOT_6(UIRow.CHEST_ROW_1, 6),
  SLOT_7(UIRow.CHEST_ROW_1, 7),
  SLOT_8(UIRow.CHEST_ROW_1, 8),
  SLOT_9(UIRow.CHEST_ROW_2, 9), // 1
  SLOT_10(UIRow.CHEST_ROW_2, 10),
  SLOT_11(UIRow.CHEST_ROW_2, 11),
  SLOT_12(UIRow.CHEST_ROW_2, 12),
  SLOT_13(UIRow.CHEST_ROW_2, 13),
  SLOT_14(UIRow.CHEST_ROW_2, 14),
  SLOT_15(UIRow.CHEST_ROW_2, 15),
  SLOT_16(UIRow.CHEST_ROW_2, 16),
  SLOT_17(UIRow.CHEST_ROW_2, 17),
  SLOT_18(UIRow.CHEST_ROW_3, 18), // 2
  SLOT_19(UIRow.CHEST_ROW_3, 19),
  SLOT_20(UIRow.CHEST_ROW_3, 20),
  SLOT_21(UIRow.CHEST_ROW_3, 21),
  SLOT_22(UIRow.CHEST_ROW_3, 22),
  SLOT_23(UIRow.CHEST_ROW_3, 23),
  SLOT_24(UIRow.CHEST_ROW_3, 24),
  SLOT_25(UIRow.CHEST_ROW_3, 25),
  SLOT_26(UIRow.CHEST_ROW_3, 26),
  SLOT_27(UIRow.CHEST_ROW_4, 27), // 3
  SLOT_28(UIRow.CHEST_ROW_4, 28),
  SLOT_29(UIRow.CHEST_ROW_4, 29),
  SLOT_30(UIRow.CHEST_ROW_4, 30),
  SLOT_31(UIRow.CHEST_ROW_4, 31),
  SLOT_32(UIRow.CHEST_ROW_4, 32),
  SLOT_33(UIRow.CHEST_ROW_4, 33),
  SLOT_34(UIRow.CHEST_ROW_4, 34),
  SLOT_35(UIRow.CHEST_ROW_4, 35),
  SLOT_36(UIRow.CHEST_ROW_5, 36), // 4
  SLOT_37(UIRow.CHEST_ROW_5, 37),
  SLOT_38(UIRow.CHEST_ROW_5, 38),
  SLOT_39(UIRow.CHEST_ROW_5, 39),
  SLOT_40(UIRow.CHEST_ROW_5, 40),
  SLOT_41(UIRow.CHEST_ROW_5, 41),
  SLOT_42(UIRow.CHEST_ROW_5, 42),
  SLOT_43(UIRow.CHEST_ROW_5, 43),
  SLOT_44(UIRow.CHEST_ROW_5, 44),
  SLOT_45(UIRow.CHEST_ROW_6, 45), // 5
  SLOT_46(UIRow.CHEST_ROW_6, 46),
  SLOT_47(UIRow.CHEST_ROW_6, 47),
  SLOT_48(UIRow.CHEST_ROW_6, 48),
  SLOT_49(UIRow.CHEST_ROW_6, 49),
  SLOT_50(UIRow.CHEST_ROW_6, 50),
  SLOT_51(UIRow.CHEST_ROW_6, 51),
  SLOT_52(UIRow.CHEST_ROW_6, 52),
  SLOT_53(UIRow.CHEST_ROW_6, 53); // 6

  private final UIRow parent;
  private final int slot;

  UISlot(UIRow parent, int slot) {
    this.parent = parent;
    this.slot = slot;
  }

  public static Optional<UISlot> fromSlotId(int slot) {
    for (UISlot value : values()) {

      if (value.getSlot() != slot)
        continue;

      return Optional.of(value);

    }

    return Optional.empty();
  }
}
