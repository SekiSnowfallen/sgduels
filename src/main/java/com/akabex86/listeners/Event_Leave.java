package com.akabex86.listeners;

import com.akabex86.player.Request;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class Event_Leave {
    public static void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.quitMessage(Component.empty());
        //todo clear player cache
        for(Player all: Bukkit.getOnlinePlayers()){
            Request.revoke(p,all);
            Request.revoke(all,p);
        }
    }
}
