package com.akabex86.listeners;

import com.akabex86.arena.ArenaTracker;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Event_Death {
    public static void onDeath(PlayerDeathEvent e){

        e.getEntity();
        Player dead = e.getEntity();

        if(dead.getKiller() != null){
            Player killer = dead.getKiller();
            //ARE THE PLAYERS KILLING EACH OTHER IN A GAME
            if(ArenaTracker.inGamePlaying.contains(dead)&&ArenaTracker.inGamePlaying.contains(killer)){
                //TODO WRITE STUFF HERE
            }
        }
        e.setDeathMessage(null);
    }
}
