package de.dasshorty.enhancedui.api;

import de.dasshorty.enhancedui.api.types.chest.ChestUIRow;
import lombok.Getter;

import java.util.Optional;

@Getter
public enum UISlot {

  SLOT_0(ChestUIRow.ROW_1, 0),
  SLOT_1(ChestUIRow.ROW_1, 1),
  SLOT_2(ChestUIRow.ROW_1, 2),
  SLOT_3(ChestUIRow.ROW_1, 3),
  SLOT_4(ChestUIRow.ROW_1, 4),
  SLOT_5(ChestUIRow.ROW_1, 5),
  SLOT_6(ChestUIRow.ROW_1, 6),
  SLOT_7(ChestUIRow.ROW_1, 7),
  SLOT_8(ChestUIRow.ROW_1, 8),
  SLOT_9(ChestUIRow.ROW_2, 9), // 1
  SLOT_10(ChestUIRow.ROW_2, 10),
  SLOT_11(ChestUIRow.ROW_2, 11),
  SLOT_12(ChestUIRow.ROW_2, 12),
  SLOT_13(ChestUIRow.ROW_2, 13),
  SLOT_14(ChestUIRow.ROW_2, 14),
  SLOT_15(ChestUIRow.ROW_2, 15),
  SLOT_16(ChestUIRow.ROW_2, 16),
  SLOT_17(ChestUIRow.ROW_2, 17),
  SLOT_18(ChestUIRow.ROW_3, 18), // 2
  SLOT_19(ChestUIRow.ROW_3, 19),
  SLOT_20(ChestUIRow.ROW_3, 20),
  SLOT_21(ChestUIRow.ROW_3, 21),
  SLOT_22(ChestUIRow.ROW_3, 22),
  SLOT_23(ChestUIRow.ROW_3, 23),
  SLOT_24(ChestUIRow.ROW_3, 24),
  SLOT_25(ChestUIRow.ROW_3, 25),
  SLOT_26(ChestUIRow.ROW_3, 26),
  SLOT_27(ChestUIRow.ROW_4, 27), // 3
  SLOT_28(ChestUIRow.ROW_4, 28),
  SLOT_29(ChestUIRow.ROW_4, 29),
  SLOT_30(ChestUIRow.ROW_4, 30),
  SLOT_31(ChestUIRow.ROW_4, 31),
  SLOT_32(ChestUIRow.ROW_4, 32),
  SLOT_33(ChestUIRow.ROW_4, 33),
  SLOT_34(ChestUIRow.ROW_4, 34),
  SLOT_35(ChestUIRow.ROW_4, 35),
  SLOT_36(ChestUIRow.ROW_5, 36), // 4
  SLOT_37(ChestUIRow.ROW_5, 37),
  SLOT_38(ChestUIRow.ROW_5, 38),
  SLOT_39(ChestUIRow.ROW_5, 39),
  SLOT_40(ChestUIRow.ROW_5, 40),
  SLOT_41(ChestUIRow.ROW_5, 41),
  SLOT_42(ChestUIRow.ROW_5, 42),
  SLOT_43(ChestUIRow.ROW_5, 43),
  SLOT_44(ChestUIRow.ROW_5, 44),
  SLOT_45(ChestUIRow.ROW_6, 45), // 5
  SLOT_46(ChestUIRow.ROW_6, 46),
  SLOT_47(ChestUIRow.ROW_6, 47),
  SLOT_48(ChestUIRow.ROW_6, 48),
  SLOT_49(ChestUIRow.ROW_6, 49),
  SLOT_50(ChestUIRow.ROW_6, 50),
  SLOT_51(ChestUIRow.ROW_6, 51),
  SLOT_52(ChestUIRow.ROW_6, 52),
  SLOT_53(ChestUIRow.ROW_6, 53); // 6

  private final ChestUIRow parent;
  private final int slot;

  UISlot(ChestUIRow parent, int slot) {
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
