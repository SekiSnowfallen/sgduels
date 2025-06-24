package com.akabex86.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PlayerUtils {

    public static void clearPotionEffects(Player p){
        for(PotionEffect e:p.getActivePotionEffects()){
            p.removePotionEffect(e.getType());
        }
    }
    public static void playSound(Player p, Sound s){
        p.playSound(p.getLocation(),s,1.0F,1.0F);
    }

}
