package com.akabex86.listeners;

import com.akabex86.arena.ArenaTracker;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;

public class Event_EntityDamage {
    public static void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if(ArenaTracker.godMode.contains(p)){
                e.setCancelled(true);
            }
        }
    }
}
