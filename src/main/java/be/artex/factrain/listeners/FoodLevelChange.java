package be.artex.factrain.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener {
    @EventHandler
    public static void foodLevelChangeEvent(FoodLevelChangeEvent e) {
        if (e.getEntity().getType().equals(EntityType.PLAYER))
            e.setCancelled(true);
    }

}
