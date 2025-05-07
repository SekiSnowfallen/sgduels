package com.akabex86.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

public class Event_BlockBreak {
    public static void onBlockBreak(BlockBreakEvent e){

        Player p = e.getPlayer();

        if(!p.getGameMode().equals(GameMode.CREATIVE)){
            e.setCancelled(true);
        }
    }
}
