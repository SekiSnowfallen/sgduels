package com.akabex86.listeners;

import com.akabex86.commands.Command_Arena;
import com.akabex86.commands.Command_Sgduels;
import com.akabex86.main.Main;
import com.akabex86.utils.Converters;
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
                    if(Command_Arena.chests.containsKey(p.getName()))
                        for(String crate_loc:Command_Arena.chests.get(p.getName())){
                            ParticleMagic.highlightBlock(p, Converters.stringToLocation(crate_loc).getBlock(), Color.GREEN);
                        }
                }
            }
        },20,20);
    }
}
