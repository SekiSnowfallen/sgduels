package com.akabex86.listeners;

import com.akabex86.arena.ArenaTracker;
import com.akabex86.utils.PlayerUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class Event_EntityDamageByEntity {
    public static void onDamage(EntityDamageByEntityEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        Player target = (Player) e.getEntity();

        if(PlayerUtils.isGod(target)){
            e.setCancelled(true);
        }
        if(!(e.getDamager() instanceof Player)) return;
        Player attacker = (Player) e.getDamager();

        if(ArenaTracker.editors.contains(attacker) || ArenaTracker.editors.contains(target)){
            e.setCancelled(true);
            return;
        }
        ItemStack item = attacker.getInventory().getItemInMainHand();
        if(item == null || item.getType() == Material.AIR || item.getItemMeta() == null) return;

        String displayName = item.getItemMeta().getDisplayName();
        if(displayName == null || !displayName.equalsIgnoreCase("§eDuel Blade")) return;

    }
}
