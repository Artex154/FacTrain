package be.artex.factrain.commands.itemCommands;

import be.artex.factrain.Stacks;
import be.artex.factrain.api.items.Items;
import be.artex.factrain.api.items.bow.BowItem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BowCommand implements CommandExecutor {
    public static Inventory inventory = Bukkit.createInventory(null, 27, "bows");

    public static Inventory prepareBowInv() {
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

        int v = 9;

        for (BowItem item : Items.registeredBowItems) {
            v++;
            inventory.setItem(v, item.getStack());
        }

        return inventory;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        prepareBowInv();

        ((Player) sender).openInventory(inventory);

        return true;
    }
}
