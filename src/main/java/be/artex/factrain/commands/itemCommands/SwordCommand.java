package be.artex.factrain.commands.itemCommands;

import be.artex.factrain.Stacks;
import be.artex.factrain.api.items.Items;
import be.artex.factrain.api.items.sword.SwordItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Stack;

public class SwordCommand implements CommandExecutor {
    public static Inventory inventory = Bukkit.createInventory(null, 27, "Swords");

    public static Inventory prepareSwordInv() {
        ItemStack border = Stacks.BORDER();

        inventory.setItem(0, border);
        inventory.setItem(1, border);
        inventory.setItem(7, border);
        inventory.setItem(8, border);
        inventory.setItem(9, border);
        inventory.setItem(17, border);
        inventory.setItem(18, border);
        inventory.setItem(19, border);
        inventory.setItem(25, border);
        inventory.setItem(26, border);

        int s = 9;

        for (SwordItem item : Items.registeredSwordItems) {
            s++;
            inventory.setItem(s, item.getStack());
        }

        return inventory;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        prepareSwordInv();

        Player player = (Player) sender;

        player.openInventory(inventory);

        return true;
    }
}
