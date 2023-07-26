package de.dasshorty.enhancedui.api.types.chest.front;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;


@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UIItem {

  private final ItemStack itemStack;
  @Getter
  private final UISlot originSlot;
  @Getter
  private Component displayText;
  @Getter
  private List<Component> displayLore;

  public ItemStack buildItem() {

    ItemMeta meta = itemStack.getItemMeta();
    meta.displayName(displayText);
    meta.lore(displayLore);

    itemStack.setItemMeta(meta);

    return itemStack;
  }


}
