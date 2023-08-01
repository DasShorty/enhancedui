package de.dasshorty.enhancedui;

import de.dasshorty.enhancedui.api.backend.UIHolder;
import de.dasshorty.enhancedui.test.ImplUI;
import lombok.val;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class EnhancedUI extends JavaPlugin implements CommandExecutor {

  private UIHolder holder;

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

    if (!(sender instanceof Player player))
      return true;

    holder.open(new ImplUI(Component.text("Title"), player), player);

    return true;
  }

  @Override
  public void onEnable() {

    holder = new UIHolder();

    val pluginManager = Bukkit.getPluginManager();
    pluginManager.registerEvents(holder, this);

    getCommand("ui").setExecutor(this);

  }

  @Override
  public void onDisable() {


  }
}
