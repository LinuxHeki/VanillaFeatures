package me.linuxheki.vanillafeatures.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class ItemManager {

    public static void createRecipes() {
        ShapedRecipe bundles = new ShapedRecipe(NamespacedKey.minecraft("bundle"), new ItemStack(Material.BUNDLE));
        bundles.shape("SRS", "R R", "RRR");
        bundles.setIngredient('S', Material.STRING);
        bundles.setIngredient('R', Material.RABBIT_HIDE);

        ShapedRecipe spectralArrows = new ShapedRecipe(NamespacedKey.minecraft("squid_arrows"), new ItemStack(Material.SPECTRAL_ARROW, 1));
        spectralArrows.shape(" I ", "IAI", " I ");
        spectralArrows.setIngredient('I', Material.GLOW_INK_SAC);
        spectralArrows.setIngredient('A', Material.ARROW);

        Bukkit.getServer().addRecipe(bundles);
        Bukkit.getServer().addRecipe(spectralArrows);
    }

}
