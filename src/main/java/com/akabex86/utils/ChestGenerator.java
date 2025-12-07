package com.akabex86.utils;

import com.akabex86.arena.ArenaBuilder;
import com.akabex86.main.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.random.RandomGenerator;

public class ChestGenerator {
    public static void generateChests (ArenaBuilder targetArena){
        List<String> crates = targetArena.getCrates();
        //Temporary Loot pool for testing
        //TODO REMOVE THIS AFTER FULL RELEASE
        ItemStack stoneSword = new ItemStack(Material.STONE_SWORD,1);
        ItemStack leatherCap = new ItemStack(Material.LEATHER_HELMET,1);
        ItemStack leatherShirt = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemStack leatherPants = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS, 1);

        ItemStack cookedBeef = new ItemStack(Material.COOKED_BEEF,1);

        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE,2);

        ItemStack ironSword = new ItemStack(Material.IRON_SWORD, 1);

        //
            for(String crate:crates){
                Location loc = Converters.stringToLocation(crate);
                //TODO ADD RANDOM MECHANISM FOR CHEST GENERATION HERE.
                int i = RandomGenerator.getDefault().nextInt(5);
                Main.main.getLogger().log(Level.INFO,"Rng: "+i);//Test the RNG if it actually works.

            }
        return;
    }
}
