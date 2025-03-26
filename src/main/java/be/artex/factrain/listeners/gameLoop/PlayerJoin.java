package be.artex.factrain.listeners.gameLoop;

import be.artex.factrain.Stacks;
import be.raft.crafty.item.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        World world = Bukkit.getWorlds().get(0);

        player.getInventory().clear();

        for (PotionEffect pe : player.getActivePotionEffects()) {
            player.getActivePotionEffects().remove(pe);
        }

        player.getInventory().setItem(4, Stacks.PLAY);

        player.teleport(new Location(Bukkit.getWorlds().get(0), 0, 122, 0));
        player.setGameMode(GameMode.ADVENTURE);

        world.getWorldBorder().setCenter(0, 0);
        world.getWorldBorder().setSize(140);
    }
}
