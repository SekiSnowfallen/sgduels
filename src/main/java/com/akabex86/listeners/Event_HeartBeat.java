package com.akabex86.listeners;

import com.akabex86.main.Main;
import com.akabex86.utils.ParticleMagic;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.awt.*;

public class Event_HeartBeat {
    static int hb;
    //this method runs every second in order to update particles and other effects (can be sped up)
    public static void beat(){
        hb = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.main, new Runnable() {
            @Override
            public void run() {
                for(Player p:Bukkit.getOnlinePlayers()){
                    //testing
                    ParticleMagic.highlightBlock(p,p.getLocation().getBlock(), Color.ORANGE);
                }
            }
        },20,20);
    }
}
