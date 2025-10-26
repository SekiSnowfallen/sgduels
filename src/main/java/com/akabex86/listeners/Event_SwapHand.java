package com.akabex86.listeners;

import com.akabex86.utils.PlayerUtils;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class Event_SwapHand {
    public static void onPlayerSwapItem(PlayerSwapHandItemsEvent e){
        if(PlayerUtils.isInventoryLocked(e.getPlayer())){
            e.setCancelled(true);
        }
    }
}
