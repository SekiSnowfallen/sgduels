package com.akabex86.listeners;

import com.akabex86.player.InventoryLoader;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class Event_GamemodeChange {
    public static void onGamemodeChange(PlayerGameModeChangeEvent e){
        Player p = e.getPlayer();
        GameMode newgm = e.getNewGameMode();
        if(newgm.name().equalsIgnoreCase("CREATIVE")){
            InventoryLoader.loadInventory(p, InventoryLoader.InventoryType.CREATIVE);
        }
        if(p.getGameMode().name().equalsIgnoreCase("CREATIVE")){
            InventoryLoader.loadInventory(p, InventoryLoader.InventoryType.LOBBY);
        }
    }
}
