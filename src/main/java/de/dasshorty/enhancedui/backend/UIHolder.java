package de.dasshorty.enhancedui.backend;

import de.dasshorty.enhancedui.UIReference;
import de.dasshorty.enhancedui.types.chest.ChestUI;
import lombok.val;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.HashMap;
import java.util.Map;

public class UIHolder implements Listener {

  private Map<Player, UIReference> openUIs = new HashMap<>();

  public synchronized void open(UIReference reference, Player player) {
    openUIs.put(player, reference);
    reference.open(player);
  }

  public boolean isPlayerInUI(Player player) {
    return openUIs.containsKey(player);
  }

  public UIReference getUi(Player player) {
    if (!isPlayerInUI(player))
      return null;

    return openUIs.get(player);
  }

  @EventHandler
  public void onInventoryClose(InventoryCloseEvent event) {

    if (!(event.getPlayer() instanceof Player player))
      return;

    if (!isPlayerInUI(player))
      return;

    val uiReference = getUi(player);

    switch (uiReference.type()) {
      case CHEST -> {

        val ui = (ChestUI) uiReference;

        if (event.getInventory().getHolder() == ui.getInventory().getHolder())
          openUIs.remove(player);


      }
    }

  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {

    if (!(event.getWhoClicked() instanceof Player player))
      return;

    if (!isPlayerInUI(player))
      return;

    val uiReference = getUi(player);


    switch (uiReference.type()) {
      case CHEST -> {

        val ui = (ChestUI) uiReference;

        if (event.getInventory().getHolder() != ui.getInventory().getHolder())
          return;

        if (event.getClickedInventory() == null)
          return;

        if (!ui.allowItemMovementInOtherInventories())
          if (event.getClickedInventory().getHolder() != ui.getInventory().getHolder())
            return;

        ui.getItemsMap().forEach((uiItem, uiAction) -> {

          if (uiItem.getCurrentSlot().getSlot() != event.getSlot())
            return;

          event.setCancelled(uiAction.onItemClick(player, uiItem, event.getClick()));

        });

      }
    }

  }

}
