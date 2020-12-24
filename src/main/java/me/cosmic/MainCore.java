package me.cosmic;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class MainCore extends JavaPlugin implements Listener {

    private static Plugin plugin;


    @Override
    public void onEnable() {
        plugin = this;
        registerEvents(this, new Gamemodes());

        getCommand("gamemodegui").setExecutor(new OPPCoreCommands());

    }


    @Override
    public void onDisable() {
        plugin=null;
    }


    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }


    public static Plugin getPlugin() {
        return plugin;
    }
}
