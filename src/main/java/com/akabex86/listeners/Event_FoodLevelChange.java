package com.akabex86.listeners;

import com.akabex86.arena.ArenaTracker;
import com.akabex86.utils.PlayerUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Event_FoodLevelChange {
    public static void onFoodLevelChange(FoodLevelChangeEvent e){
        if(e.getEntity() instanceof Player p){
            if(PlayerUtils.isGod(p)){
                e.setFoodLevel(20);
            }
        }

    }
}
