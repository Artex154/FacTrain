package be.artex.factrain.api.items;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public abstract class Item {
    public abstract ItemStack getStack();
    public abstract UUID getID();
    public abstract void onClick(PlayerInteractEvent event);
}
