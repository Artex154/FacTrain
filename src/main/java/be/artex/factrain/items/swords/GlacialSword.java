package be.artex.factrain.items.swords;

import be.artex.factrain.api.items.sword.SwordItem;
import be.raft.crafty.item.ItemBuilder;
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

import java.util.UUID;

public class GlacialSword extends SwordItem {
    @Override
    public void onHit(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player)
            ((Player) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 4*20, 0));
    }

    @Override
    public ItemStack getStack() {
        return ItemBuilder.create(Material.DIAMOND_SWORD)
                .displayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Lame Glaciale")
                .setLore(ChatColor.DARK_GRAY + "agJUoyDugHGFbzReKmLn", " ", ChatColor.GOLD + "Fire Aspect 2" + ChatColor.DARK_GRAY + ", " + ChatColor.RED + "Sharpness 5", " ", ChatColor.GRAY + "Permet de donner" + ChatColor.DARK_GRAY + " slowness " + ChatColor.GRAY + "en " + ChatColor.RED + "tappant" + ChatColor.GRAY + ".")
                .addEnchant(Enchantment.FIRE_ASPECT, 2)
                .addEnchant(Enchantment.DAMAGE_ALL, 5)
                .addEnchant(Enchantment.DURABILITY, 5, true)
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
