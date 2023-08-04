package de.dasshorty.enhancedui;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public interface UIReference {

  Component displayText();

  UIType type();

  /**
   * @return if true items can be moved in other inventories that the player has open
   * */
  boolean allowItemMovementInOtherInventories();

  void open(Player player);

}
