package be.artex.factrain.items.swords;

import be.artex.factrain.Main;
import be.artex.factrain.api.items.sword.SwordItem;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class ZeusSword extends SwordItem {
    public static final ArrayList<UUID> playerWithSpeed = new ArrayList<>();

    @Override
    public void onHit(EntityDamageByEntityEvent e) {
        Player damager = (Player) e.getDamager();

        Random random = new Random();

        if (random.nextInt(5) == 1) {
            e.getEntity().getLocation().getWorld().strikeLightning(e.getEntity().getLocation());

            damager.removePotionEffect(PotionEffectType.SPEED);
            damager.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));

            playerWithSpeed.add(damager.getUniqueId());

            Bukkit.getScheduler().runTaskLater(Main.PLUGIN, () -> {
                if (playerWithSpeed.contains(damager.getUniqueId())) {
                    damager.removePotionEffect(PotionEffectType.SPEED);
                    damager.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                    playerWithSpeed.remove(damager.getUniqueId());
                }
            }, 60);

            if (!(e.getEntity() instanceof Player))
                return;

            Player damaged = (Player) e.getEntity();

            if ((damaged.getHealth() - 3) < 0)
                damaged.setHealth(1);
            else
                damaged.setHealth(damaged.getHealth() - 3);

            Bukkit.getScheduler().runTaskLater(Main.PLUGIN, () -> {
                //if (playerWithSpeed.contains(damager.getUniqueId())) {
                    damager.removePotionEffect(PotionEffectType.SPEED);
                    damager.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                    playerWithSpeed.remove(damager.getUniqueId());
                //}
            }, 60);
        }

    }

    @Override
    public ItemStack getStack() {
        return ItemBuilder.create(Material.DIAMOND_SWORD)
                .displayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Lame de Zeus")
                .setLore(ChatColor.DARK_GRAY + "iuJNGhErtUQipoKEtLNe", " ", ChatColor.GOLD + "Fire Aspect 2" + ChatColor.DARK_GRAY + ", " + ChatColor.RED + "Sharpness 5",
                        " ", ChatColor.GRAY + "Vous avez" + ChatColor.AQUA + " 20% " + ChatColor.GRAY + "de chance de faire apparaitre un " + ChatColor.YELLOW + "éclair" + ChatColor.GRAY + ".",
                        ChatColor.GRAY + "L'" + ChatColor.YELLOW + "éclair " + ChatColor.GRAY + "fait un " + ChatColor.RED + "1 coeur" + ChatColor.GRAY + " de" + ChatColor.RED + " dégat " + ChatColor.GRAY + "en plus.")
                .addEnchant(Enchantment.FIRE_ASPECT, 2)
                .addEnchant(Enchantment.DAMAGE_ALL, 5)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                .build();
    }

    @Override
    public UUID getID() {
        return UUID.randomUUID();
    }

    @Override
    public void onClick(PlayerInteractEvent event) {

    }
}
