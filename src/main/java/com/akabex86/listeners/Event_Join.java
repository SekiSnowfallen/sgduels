package com.akabex86.listeners;

import com.akabex86.arena.ArenaTracker;
import com.akabex86.player.InventoryLoader;
import com.akabex86.utils.PlayerUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

public class Event_Join {
    public static void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        //e.setJoinMessage(null); deprecated
        e.joinMessage(Component.empty());
        InventoryLoader.loadInventory(p, InventoryLoader.InventoryType.LOBBY);
        PlayerUtils.setGod(p);
        PlayerUtils.lockInventory(p);
        PlayerUtils.clearPotionEffects(p);
        //TODO UPDATE SCOREBOARDS/ACTIONBAR
        //TODO TELEPORT PLAYER TO SPAWN
        p.sendMessage("\n" +
                "§e§lIFHeroes\n" +
                "§eYou are now playing SGDuels\n" +
                "§l§e");
        //TODO DELAYED SCHEDULER TP TELEPORT PLAYER TO SPAWN AGAIN

    }
}
