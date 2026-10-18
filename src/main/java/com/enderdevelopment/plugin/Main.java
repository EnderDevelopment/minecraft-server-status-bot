package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ServerStatusPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("ServerStatusPlugin has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("serverstatus")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage("Server Status: Online");
                player.sendMessage("Players Online: " + Bukkit.getOnlinePlayers().size());
                return true;
            } else {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            }
        }
        return false;
    }
}