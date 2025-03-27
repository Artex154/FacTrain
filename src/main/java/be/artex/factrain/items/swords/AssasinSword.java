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

import java.util.UUID;

public class AssasinSword extends SwordItem {
    @Override
    public ItemStack getStack() {
        return ItemBuilder.create(Material.DIAMOND_SWORD)
                .displayName(ChatColor.RED + "" + ChatColor.BOLD + "Lame de l'Assasin")
                .setLore(ChatColor.DARK_GRAY + "uIoPMlkhJNBfGhBNaEhJ", " ", ChatColor.GOLD + "Fire Aspect 2" + ChatColor.DARK_GRAY + ", " + ChatColor.RED + "Sharpness 6")
                .addEnchant(Enchantment.FIRE_ASPECT, 2)
                .addEnchant(Enchantment.DAMAGE_ALL, 6, true)
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

    @Override
    public void onHit(EntityDamageByEntityEvent e) {

    }
}
