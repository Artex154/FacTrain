package be.artex.factrain;

import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Stacks {
    public static ItemStack BORDER() {
        ItemStack border = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
        ItemMeta itemMeta = border.getItemMeta();
        itemMeta.setDisplayName(" ");
        border.setItemMeta(itemMeta);

        return border;
    }

    public static final ItemStack PLAY = ItemBuilder.create(Material.DIAMOND_AXE)
            .displayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Jouer")
            .build();
}
