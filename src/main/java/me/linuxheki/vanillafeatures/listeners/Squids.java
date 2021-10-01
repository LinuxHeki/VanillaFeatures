package me.linuxheki.vanillafeatures.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Squids implements Listener {
    @EventHandler
    public static void onDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();

        if (entity.getType() == EntityType.SQUID) {
            Random random = new Random();
            int randomNumber = random.nextInt(3);
            if (randomNumber == 1) {

                Entity attacker = event.getDamager();
                if (attacker instanceof LivingEntity) {
                    ((LivingEntity) attacker).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
                }
            }

        } else if (entity.getType() == EntityType.GLOW_SQUID) {
            Random random = new Random();
            int randomNumber = random.nextInt(3);

            if (randomNumber == 1) {
                Entity attacker = event.getDamager();
                if (attacker instanceof LivingEntity) {
                    ((LivingEntity) attacker).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
                    ((LivingEntity) attacker).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 0));
                }
            }
        }
    }
}
