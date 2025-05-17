package com.akabex86.listeners;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class Event_BlockPlace {
    public static void onBlockPlace(BlockPlaceEvent e){

        Player p = e.getPlayer();

        if(!p.getGameMode().equals(GameMode.CREATIVE)){
            e.setCancelled(true);
        }

        ItemStack itemInHand = e.getItemInHand();
        if(itemInHand.getType() == Material.TNT){
            int amount = itemInHand.getAmount();
            if(amount <= 1){
                p.getInventory().setItem(e.getHand(),null);

            }else{
                itemInHand.setAmount(amount-1);
                p.getInventory().setItem(e.getHand(),itemInHand);
            }
            Location tntSpawnLocation =  e.getBlock().getLocation().add(0.5,0.2,0.5);
            p.getWorld().spawnEntity(tntSpawnLocation, EntityType.PRIMED_TNT);
            double soundRadius = 15.0;
            for (Player all:Bukkit.getOnlinePlayers()){
                if(all.getLocation().distanceSquared(tntSpawnLocation) <= soundRadius*soundRadius){
                    all.playSound(tntSpawnLocation, Sound.ENTITY_TNT_PRIMED, 1, 1);
                    all.playSound(tntSpawnLocation, Sound.ENTITY_CREEPER_HURT, 1, 1);
                }
            }
            e.setCancelled(true);
        }
    }
}
