package me.linuxheki.vanillafeatures.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

public class Lightning implements Listener {
    @EventHandler
    public static void onStrike(LightningStrikeEvent event) {
        if ((event.isCancelled()) || (event.getCause().name() == "TRIDENT")) {return;}

        LightningStrike lightning = event.getLightning();
        Location location = lightning.getLocation();
        int coords = location.getBlockY() - 1;
        location.setY(coords);

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        Block block = location.getBlock();
        Material material = block.getType();

        String[] otherBlocks = {"IRON_BLOCK", "GOLD_BLOCK", "LIGHTNING_ROD", "WATER"};
        String[] copperBlocks = {"COPPER_BLOCK", "EXPOSED_COPPER", "WEATHERED_COPPER", "OXIDIZED_COPPER", "CUT_COPPER", "EXPOSED_CUT_COPPER", "WEATHERED_CUT_COPPER", "OXIDIZED_CUT_COPPER", "WAXED_COPPER_BLOCK", "WAXED_EXPOSED_COPPER", "WAXED_WEATHERED_COPPER", "WAXED_OXIDIZED_COPPER", "WAXED_CUT_COPPER", "WAXED_EXPOSED_CUT_COPPER", "WAXED_WEATHERED_CUT_COPPER", "WAXED_OXIDIZED_CUT_COPPER"};
        String[] copperSlabs = {"EXPOSED_CUT_COPPER_SLAB", "WEATHERED_CUT_COPPER_SLAB", "OXIDIZED_CUT_COPPER_SLAB", "WAXED_CUT_COPPER_SLAB", "WAXED_EXPOSED_CUT_COPPER_SLAB", "WAXED_WEATHERED_CUT_COPPER_SLAB", "WAXED_OXIDIZED_CUT_COPPER_SLAB"};
        String[] copperStairs = {"EXPOSED_CUT_COPPER_STAIRS", "WEATHERED_CUT_COPPER_STAIRS", "OXIDIZED_CUT_COPPER_STAIRS", "WAXED_CUT_COPPER_STAIRS", "WAXED_EXPOSED_CUT_COPPER_STAIRS", "WAXED_WEATHERED_CUT_COPPER_STAIRS", "WAXED_OXIDIZED_CUT_COPPER_STAIRS"};

        for (String metalBlock : otherBlocks) {
            if (Material.valueOf(metalBlock) == material) {return;}
        }
        for (String metalBlock : copperBlocks) {
            if (Material.valueOf(metalBlock) == material) {return;}
        }
        for (String metalBlock : copperSlabs) {
            if (Material.valueOf(metalBlock) == material) {return;}
        }
        for (String metalBlock : copperStairs) {
            if (Material.valueOf(metalBlock) == material) {return;}
        }

        Entity entity = lightning;

        World world = location.getWorld();
        world.createExplosion(x, y, z, 2, true, true, entity);

    }
}