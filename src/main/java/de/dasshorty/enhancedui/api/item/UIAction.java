package de.dasshorty.enhancedui.api.item;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

public interface UIAction {

  boolean onItemClick(Player clicker, UIItem clickedItem, ClickType action);

}
