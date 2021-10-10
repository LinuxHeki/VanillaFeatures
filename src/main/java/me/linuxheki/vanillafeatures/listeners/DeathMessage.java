package me.linuxheki.minecube.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessage implements Listener {
    @EventHandler
    public static void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Location location = event.getEntity().getLocation();
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        player.sendMessage("You died at x: " + x + ", y: " + y + ", z: " + z);
    }
}