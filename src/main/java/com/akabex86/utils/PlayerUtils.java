package com.akabex86.utils;

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
        invlock.add(p.getName().toLowerCase());
    }
    public static void unlockInventory(Player p){
        invlock.remove(p.getName().toLowerCase());
    }
    public static boolean isInventoryLocked(Player p){
        return invlock.contains(p.getName().toLowerCase());
    }
    public static boolean isInventoryLocked(String name){
        return invlock.contains(name.toLowerCase());
    }
    // GODMODE
    public static void setGod(Player p){
        god.add(p.getName().toLowerCase());
    }
    public static void unGod(Player p){
        god.remove(p.getName().toLowerCase());
    }
    public static boolean isGod(Player p){
        return god.contains(p.getName().toLowerCase());
    }
    public static boolean isGod(String name){
        return god.contains(name.toLowerCase());
    }
    //=======================================================
}
