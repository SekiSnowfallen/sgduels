package com.akabex86.player;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryLoader {
    public enum InventoryType{
        LOBBY,
        ARENA,
        CREATIVE,
        SPECTATOR,
    }
    public static void loadInventory(Player p, InventoryType type){
        PlayerInventory inv = p.getInventory();
        inv.clear();
        inv.setHelmet(null);
        inv.setChestplate(null);
        inv.setLeggings(null);
        inv.setBoots(null);
        p.getActivePotionEffects().clear();
        p.setFireTicks(0);
        p.setHealthScale(20.0);
        p.setHealth(20.0);
        p.setFoodLevel(20);
        p.setExp(0.0F);
        p.setLevel(0);
        switch (type){
            case LOBBY:
                //DUELING SWORD
                ItemStack duelSword = new ItemStack(Material.IRON_SWORD, 1);
                ItemMeta duelSwordMeta = duelSword.getItemMeta();
                duelSwordMeta.setDisplayName("§eDuel Blade");

                List<String> duelSwordLore = new ArrayList<>();
                duelSwordLore.add("§7Hit the player you");
                duelSwordLore.add("§7want to challenge");
                duelSwordLore.add("§7for a duel.");

                duelSwordMeta.setLore(duelSwordLore);
                duelSword.setItemMeta(duelSwordMeta);

                //LEAVE ITEM
                ItemStack leaveItem = new ItemStack(Material.SLIME_BALL, 1);
                ItemMeta leaveItemMeta = leaveItem.getItemMeta();
                leaveItemMeta.setDisplayName("§aLeave Game");

                List<String> leaveItemLore = new ArrayList<>();
                leaveItemLore.add("§cAre you sure");
                leaveItemLore.add("§cyou want that?");
                leaveItemLore.add("§c:(");

                leaveItemMeta.setLore(leaveItemLore);
                leaveItem.setItemMeta(leaveItemMeta);

                inv.setItem(4,duelSword);
                inv.setItem(8,leaveItem);

            case ARENA:
                //Do nothing. The player doesn't need items.
            case CREATIVE:
                //Do nothing. Add Buildmode specific items here.
            default:
                p.sendMessage("§cThis inventory has not been set up yet.");
        }
    }
}
