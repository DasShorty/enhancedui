package de.dasshorty.enhancedui.test;

import de.dasshorty.enhancedui.api.UIRow;
import de.dasshorty.enhancedui.api.UISlot;
import de.dasshorty.enhancedui.api.background.UIBackground;
import de.dasshorty.enhancedui.api.exception.OutOfInventoryException;
import de.dasshorty.enhancedui.api.item.UIItem;
import de.dasshorty.enhancedui.api.types.chest.ChestUI;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ImplUI extends ChestUI {
  public ImplUI(Component uiTitle, Player opener) {
    super(uiTitle, UIRow.CHEST_ROW_1, opener);
    setBackground(new UIBackground(UIBackground.BackgroundType.FULL, List.of(new UIItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), UISlot.SLOT_0))));
  }

  @Override
  public boolean allowItemMovementInOtherInventories() {
    return false;
  }

  @Override
  protected void initItems(Player opener) throws OutOfInventoryException {

    item(new UIItem(new ItemStack(Material.CHEST), UISlot.SLOT_0), (clicker, clickedItem, action) -> {

      clicker.sendMessage(Component.text("Clicked chest!"));

      return true;
    });

    item(new UIItem(new ItemStack(Material.GLASS_PANE), UISlot.SLOT_4), (clicker, clickedItem, action) -> {

      clicker.sendMessage(Component.text("Clicked pane!"));

      return true;
    });

  }
}
