package be.artex.factrain.listeners.items;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class PlayerItemDamage implements Listener {
    @EventHandler
    public void onPlayerItemDamage(PlayerItemDamageEvent event) {
        event.setDamage(0);
    }
}
