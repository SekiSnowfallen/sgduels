package com.akabex86.listeners;

import com.akabex86.utils.PlayerUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event_InventoryInteractions {
    public static void onInventoryClick(InventoryClickEvent e){
        if(e.getWhoClicked() instanceof Player p){
            if(PlayerUtils.isInventoryLocked(p)){
                e.setCancelled(true);
            }
        }
    }
    public static void onInventoryDrag(InventoryDragEvent e){
        if(e.getWhoClicked() instanceof Player p){
            if(PlayerUtils.isInventoryLocked(p)){
                e.setCancelled(true);
            }
        }
    }
}
