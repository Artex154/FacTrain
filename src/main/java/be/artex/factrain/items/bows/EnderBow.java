package be.artex.factrain.items.bows;

import be.artex.factrain.api.items.bow.BowItem;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class EnderBow extends BowItem {
    private static HashMap<UUID, Boolean> playersMode = new HashMap<>();

    @Override
    public ItemStack getStack() {
        return ItemBuilder.create(Material.BOW)
                .displayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Arc de l'Ender")
                .setLore(ChatColor.DARK_GRAY + "aUIplMoKmLLghvBNaOmK", " ",
                        ChatColor.GOLD + "Flame" + ChatColor.DARK_GRAY + ", " + ChatColor.RED + "Power 5" + ChatColor.DARK_GRAY + ", " + ChatColor.DARK_PURPLE + "Infinity" + ChatColor.DARK_GRAY + ", " + ChatColor.LIGHT_PURPLE + "Punch 2", " ",
                        ChatColor.GRAY + "En faisant un " + ChatColor.AQUA + "Sneak Clic Gauche" + ChatColor.GRAY + ", vous" + ChatColor.GREEN + " Activerez" + ChatColor.GRAY + " ou" + ChatColor.RED + " Désactiverez" + ChatColor.GRAY + ", le mode " + ChatColor.DARK_PURPLE + "Ender" + ChatColor.GRAY + ".",
                        ChatColor.GRAY + "Avec le mode " + ChatColor.DARK_PURPLE + "Ender" + ChatColor.GRAY + ", qaund vous tirez, vous faites apparaitre une" + ChatColor.DARK_PURPLE + " Ender Pearl" + ChatColor.GRAY + ".", " ")
                .addEnchant(Enchantment.ARROW_DAMAGE, 5)
                .addEnchant(Enchantment.ARROW_INFINITE, 1)
                .addEnchant(Enchantment.ARROW_FIRE, 1)
                .addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                .build();
    }

    @Override
    public UUID getID() {
        return UUID.randomUUID();
    }

    @Override
    public void onClick(PlayerInteractEvent event) {
        if (!(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)))
            return;

        Player player = event.getPlayer();

        if (!player.isSneaking())
            return;

        UUID playerUUID = player.getUniqueId();

        if (playersMode.get(playerUUID) == null) {
            playersMode.put(playerUUID, false);

            player.sendMessage(ChatColor.GRAY + "Le mode " + ChatColor.DARK_PURPLE + "Ender" + ChatColor.GRAY + " de votre " + getStack().getItemMeta().getDisplayName() + ChatColor.GRAY + " a été" + ChatColor.RED + " Désactivé" + ChatColor.GRAY + ".");

            player.playSound(player.getLocation(), Sound.WOOD_CLICK, 100f, 1f);

            return;
        }

        if (playersMode.get(playerUUID)) {
            playersMode.put(playerUUID, false);

            player.sendMessage(ChatColor.GRAY + "Le mode " + ChatColor.DARK_PURPLE + "Ender" + ChatColor.GRAY + " de votre " + getStack().getItemMeta().getDisplayName() + ChatColor.GRAY + " a été" + ChatColor.RED + " Désactivé" + ChatColor.GRAY + ".");
            player.playSound(player.getLocation(), Sound.WOOD_CLICK, 100f, 1f);
        } else {
            playersMode.put(playerUUID, true);

            player.sendMessage(ChatColor.GRAY + "Le mode " + ChatColor.DARK_PURPLE + "Ender" + ChatColor.GRAY + " de votre " + getStack().getItemMeta().getDisplayName() + ChatColor.GRAY + " a été" + ChatColor.GREEN + " Activé" + ChatColor.GRAY + ".");
            player.playSound(player.getLocation(), Sound.WOOD_CLICK, 100f, 1f);
        }
    }

    @Override
    public void onArrowShot(EntityShootBowEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PLAYER))
            return;

        Player player = (Player) event.getEntity();

        if (playersMode.get(player.getUniqueId()) == null || playersMode.get(player.getUniqueId())) {
            event.setProjectile(null);
            event.getEntity().launchProjectile(EnderPearl.class);
        }
    }
}
