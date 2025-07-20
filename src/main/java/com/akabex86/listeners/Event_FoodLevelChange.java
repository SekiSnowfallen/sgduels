package com.akabex86.listeners;

import com.akabex86.arena.ArenaTracker;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Event_FoodLevelChange {
    public static void onFoodLevelChange(FoodLevelChangeEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if(ArenaTracker.godMode.contains(p)){
                //e.setCancelled(true);
                e.setFoodLevel(20);
            }
        }

    }
}
