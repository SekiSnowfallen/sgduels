package com.akabex86.listeners;

import com.akabex86.utils.PlayerUtils;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class Event_DropAndPickup {
    public static void onDrop(PlayerDropItemEvent e){
        if(PlayerUtils.isInventoryLocked(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    public static  void onPickup(PlayerAttemptPickupItemEvent e){
        if(PlayerUtils.isInventoryLocked(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
