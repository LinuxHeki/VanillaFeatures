package me.linuxheki.vanillafeatures.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.inventory.ItemStack;

public class Drops implements Listener {
    @EventHandler
    public static void onDespawn(ItemDespawnEvent event) {
        Item item = event.getEntity();
        ItemStack itemStack = item.getItemStack();
        //FileConfiguration config = new Main().getConfig();

        String[] saplings = {"GRASS_BLOCK", "DIRT", "PODZOL", "COARSE_DIRT", "MYCELIUM", "ROOTED_DIRT", "MOSS_BLOCK"};
        String[] bamboo = {"GRASS_BLOCK", "DIRT", "PODZOL", "COARSE_DIRT", "MYCELIUM", "ROOTED_DIRT", "MOSS_BLOCK", "SAND", "RED_SAND"};
        String[] azalea = {"GRASS_BLOCK", "DIRT", "PODZOL", "COARSE_DIRT", "MYCELIUM", "ROOTED_DIRT", "MOSS_BLOCK", "CLAY"};

        switch (itemStack.getType().toString()) {
            case "ACACIA_SAPLING": drop(item, "ACACIA_SAPLING", saplings); break;
            case "BIRCH_SAPLING": drop(item, "BIRCH_SAPLING", saplings); break;
            case "DARK_OAK_SAPLING": drop(item, "DARK_OAK_SAPLING", saplings); break;
            case "JUNGLE_SAPLING": drop(item, "JUNGLE_SAPLING", saplings); break;
            case "OAK_SAPLING": drop(item, "OAK_SAPLING", saplings); break;
            case "SPRUCE_SAPLING": drop(item, "SPRUCE_SAPLING", saplings); break;

            case "BAMBOO": drop(item, "BAMBOO_SAPLING", bamboo); break;
            case "AZALEA": drop(item, "AZALEA", azalea); break;
            case "FLOWERING_AZALEA": drop(item, "FLOWERING_AZALEA", azalea); break;

            case "DANDELION": drop(item, "DANDELION", saplings); break;
            case "POPPY": drop(item, "POPPY", saplings); break;
            case "BLUE_ORCHID": drop(item, "BLUE_ORCHID", saplings); break;
            case "ALLIUM": drop(item, "ALLIUM", saplings); break;
            case "AZURE_BLUET": drop(item, "AZURE_BLUET", saplings); break;
            case "RED_TULIP": drop(item, "RED_TULIP", saplings); break;
            case "ORANGE_TULIP": drop(item, "ORANGE_TULIP", saplings); break;
            case "WHITE_TULIP": drop(item, "WHITE_TULIP", saplings); break;
            case "PINK_TULIP": drop(item, "PINK_TULIP", saplings); break;
            case "OXEYE_DAISY": drop(item, "OXEYE_DAISY", saplings); break;
            case "CORNFLOWER": drop(item, "CORNFLOWER", saplings); break;
            case "LILY_OF_THE_VALLEY": drop(item, "LILY_OF_THE_VALLEY", saplings);
            case "WITHER_ROSE": drop(item, "WITHER_ROSE", saplings); break;
        }
    }

    public static void drop(Item item, String place, String[] blockTypes) {
        Location location = item.getLocation();
        //Location location = new Location(location1.getWorld(), location1.getX(), location1.getY()+0.7, location1.getZ());
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        Location under = new Location(item.getWorld(), x, y-1, z);
        Block block = location.getBlock();
        Block underBlock = under.getBlock();

        for (String blockType : blockTypes) {
            if ((underBlock.getType() == Material.valueOf(blockType))) {
                block.setType(Material.valueOf(place));
            }
        }
    }
}
