package de.dasshorty.enhancedui.types.anvil;

import de.dasshorty.enhancedui.UIReference;
import de.dasshorty.enhancedui.UIType;
import de.dasshorty.enhancedui.item.UIAction;
import de.dasshorty.enhancedui.item.UIItem;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import oshi.util.tuples.Pair;

import java.util.HashMap;
import java.util.Map;

public abstract class AnvilUI implements InventoryHolder, UIReference {

  private final Inventory inventory;
  private final Component displayText;
  @Getter
  private final Map<Integer, Pair<UIItem, UIAction>> itemMap = new HashMap<>();

  public AnvilUI(Component displayText, Player player) {
    this.inventory = Bukkit.createInventory(this, InventoryType.ANVIL, displayText);
    this.displayText = displayText;

    initItems();
    open(player);
  }

  private void refreshInventory() {

    itemMap.forEach((integer, pair) -> {
      inventory.setItem(integer, pair.getA().buildItem());
    });

  }

  public abstract void initItems();

  /**
   * @param item item slot can be ignored
   */
  public void setFirstItem(UIItem item, UIAction action) {
    itemMap.put(0, new Pair<>(item, action));
  }

  /**
   * @param item item slot can be ignored
   */
  public void setSecondItem(UIItem item, UIAction action) {
    itemMap.put(1, new Pair<>(item, action));
  }

  /**
   * @param item item slot can be ignored
   */
  public void setThirdItem(UIItem item, UIAction action) {
    itemMap.put(2, new Pair<>(item, action));
  }

  @Override
  public Component displayText() {
    return displayText;
  }

  @Override
  public UIType type() {
    return UIType.ANVIL;
  }

  @Override
  public void open(Player player) {
    refreshInventory();
    player.openInventory(inventory);
  }

  @Override
  public @NotNull Inventory getInventory() {
    return inventory;
  }
}
