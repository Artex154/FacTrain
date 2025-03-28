package be.artex.factrain.items.bows;

import be.artex.factrain.api.items.bow.BowItem;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class CupidonBow extends BowItem {
    @Override
    public ItemStack getStack() {
        return ItemBuilder.create(Material.BOW)
                .displayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Arc du Cupidon")
                .setLore(ChatColor.DARK_GRAY + "nJkhEYtiPmLOngAErtMn", " ",
                        ChatColor.GOLD + "Flame" + ChatColor.DARK_GRAY + ", " + ChatColor.RED + "Power 5" + ChatColor.DARK_GRAY + ", " + ChatColor.DARK_PURPLE + "Infinity" + ChatColor.DARK_GRAY + ", " + ChatColor.LIGHT_PURPLE + "Punch 4", " ")
                .addEnchant(Enchantment.ARROW_DAMAGE, 5)
                .addEnchant(Enchantment.ARROW_INFINITE, 1)
                .addEnchant(Enchantment.ARROW_FIRE, 1)
                .addEnchant(Enchantment.ARROW_KNOCKBACK, 4, true)
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
    public void onArrowShot(EntityShootBowEvent event) {

    }
}
