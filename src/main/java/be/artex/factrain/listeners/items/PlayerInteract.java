package be.artex.factrain.listeners.items;

import be.artex.factrain.Stacks;
import be.artex.factrain.api.Run;
import be.artex.factrain.api.items.Item;
import be.artex.factrain.api.items.Items;
import be.artex.factrain.commands.itemCommands.SwordCommand;

import be.raft.crafty.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class PlayerInteract implements Listener {
    public static void prepareGear(Run run) {
        Player player = run.getPlayer();
        PlayerInventory playerInv = run.getPlayer().getInventory();

        ItemStack potionItem = new ItemStack(Material.POTION);
        Potion potion = new Potion(PotionType.INSTANT_HEAL, 2);
        ItemStack[] armorContents = {
                ItemBuilder.create(Material.DIAMOND_BOOTS)
                        .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .addEnchant(Enchantment.DURABILITY, 3)
                        .build(),
                ItemBuilder.create(Material.DIAMOND_LEGGINGS)
                        .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .addEnchant(Enchantment.DURABILITY, 3)
                        .build(),
                ItemBuilder.create(Material.DIAMOND_CHESTPLATE)
                        .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .addEnchant(Enchantment.DURABILITY, 3)
                        .build(),
                ItemBuilder.create(Material.DIAMOND_HELMET)
                        .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4)
                        .addEnchant(Enchantment.DURABILITY, 3)
                        .build()
        };


        playerInv.setArmorContents(armorContents);

        potion.setSplash(true);
        potion.apply(potionItem);

        playerInv.addItem(run.getSword().getStack());
        playerInv.addItem(run.getBow().getStack());

        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(new ItemStack(Material.GOLDEN_APPLE, 16));
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(potionItem);
        playerInv.addItem(new ItemStack(Material.ARROW));

        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1, false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, false, false));
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getItem() == null)
            return;

        if (e.getItem().equals(Stacks.PLAY)) {
            e.getPlayer().openInventory(SwordCommand.prepareSwordInv());
            return;
        }

        for (Item item : Items.registeredItems) {
            if (item.getStack().equals(e.getItem())) {
                item.onClick(e);
                break;
            }
        }
    }
}
