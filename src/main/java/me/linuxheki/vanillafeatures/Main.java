package me.linuxheki.vanillafeatures;

import me.linuxheki.minecube.listeners.DeathMessage;
import me.linuxheki.vanillafeatures.items.ItemManager;
import me.linuxheki.vanillafeatures.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        ItemManager.createRecipes();
        enableListenerPlugins();

        getLogger().info("Plugin has started and it's working!");
    }

    public void enableListenerPlugins() {
        if (getConfig().getBoolean("Lightning")) {getServer().getPluginManager().registerEvents(new Lightning(), this);}
        if (getConfig().getBoolean("Squids")) {getServer().getPluginManager().registerEvents(new Squids(), this);}
        if (getConfig().getBoolean("Glowing")) {getServer().getPluginManager().registerEvents(new Glowing(), this);
        if (getConfig().getBoolean("Drops")) {getServer().getPluginManager().registerEvents(new Drops(), this);}
        if (getConfig().getBoolean("DeathMessage")) {getServer().getPluginManager().registerEvents(new DeathMessage(), this);}
        }
    }
}
