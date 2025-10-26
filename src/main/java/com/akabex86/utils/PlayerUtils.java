package com.akabex86.utils;

import com.akabex86.main.Main;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class PlayerUtils {

    //=======================================================
    //   DYNAMIC PLAYER PARAMS (INITIALIZED ON FIRST USE
    private static List<String> invlock = new ArrayList<>();
    private static List<String> god = new ArrayList<>();
    //=======================================================

    public static void clearPotionEffects(Player p){
        for(PotionEffect e:p.getActivePotionEffects()){
            p.removePotionEffect(e.getType());
        }
    }
    public static void playSound(Player p, Sound s){
        p.playSound(p.getLocation(),s,1.0F,1.0F);
    }

    //=======================================================
    //            MINIGAME SPECIFIC GETTERS AND SETTERS
    //TODO move all player parameters here for simplicity!

    // INVLOCK
    public static void lockInventory(Player p){
        Main.main.getLogger().info("Added Player "+p.getName().toLowerCase()+" to list (invlock)");
        if(!invlock.contains(p.getName().toLowerCase()))invlock.add(p.getName().toLowerCase());
    }
    public static void unlockInventory(Player p){
        Main.main.getLogger().info("Removed Player "+p.getName().toLowerCase()+" from list (invlock)");
        invlock.remove(p.getName().toLowerCase());
    }
    public static boolean isInventoryLocked(Player p){
        Main.main.getLogger().info("Requested Player "+p.getName().toLowerCase()+" from list (invlock)");
        return invlock.contains(p.getName().toLowerCase());
    }
    public static boolean isInventoryLocked(String name){
        Main.main.getLogger().info("Requested Player "+name.toLowerCase()+" from list (invlock)");
        return invlock.contains(name.toLowerCase());
    }
    // GODMODE
    public static void setGod(Player p){
        Main.main.getLogger().info("Added Player "+p.getName().toLowerCase()+" to list (god)");
        if(!god.contains(p.getName().toLowerCase()))god.add(p.getName().toLowerCase());
    }
    public static void unGod(Player p){
        Main.main.getLogger().info("Removed Player "+p.getName().toLowerCase()+" from list (god)");
        god.remove(p.getName().toLowerCase());
    }
    public static boolean isGod(Player p){
        Main.main.getLogger().info("Requested Player "+p.getName().toLowerCase()+" from list (god)");
        return god.contains(p.getName().toLowerCase());
    }
    public static boolean isGod(String name){
        Main.main.getLogger().info("Requested Player "+name.toLowerCase()+" from list (god)");
        return god.contains(name.toLowerCase());
    }
    //=======================================================
    // DEBUG PARAM
    public static void logData(){
        Main.main.getLogger().info("logging PlayerUtils: ");
        for(String str:god){
            Main.main.getLogger().info("god contains "+str);
        }
        for(String str:invlock){
            Main.main.getLogger().info("invlock contains "+str);
        }
    }
}
