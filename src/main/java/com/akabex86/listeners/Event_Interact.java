package com.akabex86.listeners;

import com.akabex86.player.Request;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class Event_Interact {
    public static void onPlayerInteractEntity(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        if(e.getRightClicked() instanceof Player target){
            Request.revoke(p,target);
        }
    }
}
