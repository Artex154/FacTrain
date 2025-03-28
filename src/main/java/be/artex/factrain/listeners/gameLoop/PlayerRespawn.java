package be.artex.factrain.listeners.gameLoop;

import be.artex.factrain.Stacks;
import be.artex.factrain.api.Runs;
import be.artex.factrain.listeners.items.PlayerInteract;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        player.setGameMode(GameMode.ADVENTURE);

        player.getInventory().setItem(4, Stacks.PLAY);
    }

    @EventHandler
    public void onPlayerDie(PlayerDeathEvent e) {
        e.getDrops().clear();
        e.getEntity().getInventory().clear();

        if (e.getEntity().getKiller() == null) {
            return;
        }

        e.getEntity().getKiller().getInventory().clear();
        PlayerInteract.prepareGear(Runs.getPlayerRuns(e.getEntity().getKiller()));

        e.getEntity().getKiller().setHealth(e.getEntity().getKiller().getMaxHealth());
    }
}
