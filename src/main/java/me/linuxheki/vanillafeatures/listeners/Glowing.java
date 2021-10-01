package me.linuxheki.vanillafeatures.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Glowing implements Listener {
    @EventHandler
    public static void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        Entity entity = event.getRightClicked();
        if (item == null) {return;}

        if ((item.getType() == Material.GLOW_INK_SAC) || (item.getType() == Material.GLOW_BERRIES)) {
            if (entity instanceof LivingEntity) {
                if (!((LivingEntity) entity).hasPotionEffect(PotionEffectType.GLOWING)) {
                    int amount = item.getAmount();
                    item.setAmount(amount-1);

                    ((LivingEntity) entity).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 1200, 0));
                }
            }
        }
    }

    @EventHandler
    public static void onEat(FoodLevelChangeEvent event) {
        ItemStack food = event.getItem();
        HumanEntity entity = event.getEntity();
        if (food == null) {return;}

        if (food.getType() == Material.GLOW_BERRIES) {
            entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 0));
        }
    }
}
