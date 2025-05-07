package com.akabex86.listeners;

import org.bukkit.event.entity.EntityExplodeEvent;

public class Event_EntityExplode {
    public static void onExplode(EntityExplodeEvent e){
        e.blockList().clear();
    }
}
