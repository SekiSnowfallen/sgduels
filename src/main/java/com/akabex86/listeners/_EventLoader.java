package com.akabex86.listeners;

import com.akabex86.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.*;

public class _EventLoader implements Listener {


    public _EventLoader(Main plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler public void onCommandSend(PlayerCommandSendEvent e){
        Event_CommandBlacklist.onCommandSend(e);
    }
    @EventHandler public void onGamemodeChange(PlayerGameModeChangeEvent e){
        Event_GamemodeChange.onGamemodeChange(e);
    }
    @EventHandler public void onBlockBreak(BlockBreakEvent e){
        Event_BlockBreak.onBlockBreak(e);
    }
    @EventHandler public void onBlockPlace(BlockPlaceEvent e){
        Event_BlockPlace.onBlockPlace(e);
    }
    @EventHandler public void onEntityExplode(EntityExplodeEvent e){
        Event_EntityExplode.onExplode(e);
    }
    @EventHandler public void onEntityDamage(EntityDamageEvent e){
        Event_EntityDamage.onDamage(e);
    }
    @EventHandler public void onEntityDamageByEntity(EntityDamageByEntityEvent e){
        Event_EntityDamageByEntity.onDamage(e);
    }
    @EventHandler public void onJoin(PlayerJoinEvent e){
        Event_Join.onJoin(e);
    }
    @EventHandler public void onLeave(PlayerQuitEvent e){
        Event_Leave.onLeave(e);
    }
    @EventHandler public void onFoodLevelChange(FoodLevelChangeEvent e){
        Event_FoodLevelChange.onFoodLevelChange(e);
    }
}
