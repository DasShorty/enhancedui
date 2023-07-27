package de.dasshorty.enhancedui.api;

import net.minecraft.world.inventory.ClickAction;
import org.bukkit.entity.Player;

public interface UIAction {

  void onItemClick(Player clicker, UIItem clickedItem, ClickAction action);
  void onItemMove(Player clicker, UIItem clickedItem, ClickAction action);

}
