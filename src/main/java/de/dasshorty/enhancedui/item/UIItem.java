package de.dasshorty.enhancedui.item;

import de.dasshorty.enhancedui.UISlot;
import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;


@Setter
public class UIItem {

  private final ItemStack itemStack;
  @Getter
  private final UISlot originSlot;
  @Getter
  private UISlot currentSlot;
  @Getter
  private Component displayText;
  @Getter
  private List<Component> displayLore;

  public UIItem(ItemStack itemStack, UISlot originSlot) {
    this.itemStack = itemStack;
    this.originSlot = originSlot;
    this.currentSlot = originSlot;
  }

  public ItemStack buildItem() {

    if (itemStack == null)
      throw new IllegalStateException("item stack can't be nul!");

    ItemMeta meta = itemStack.getItemMeta();
    meta.displayName(displayText);
    meta.lore(displayLore);

    itemStack.setItemMeta(meta);

    return itemStack;
  }


}
