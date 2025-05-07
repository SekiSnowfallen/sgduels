package com.akabex86.main;

import com.akabex86.arena.ArenaBuilder;
import com.akabex86.arena.ArenaTracker;
import com.akabex86.commands.*;
import com.akabex86.listeners.Event_HeartBeat;
import com.akabex86.listeners._EventLoader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public static Main main;
    Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        //TODO create a messages.yml file for editing if it doesn't exist already.
        super.onEnable();
        main = this;

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null){
            //TODO REFERRING TO https://github.com/PlaceholderAPI/PlaceholderAPI/wiki/Hook-into-PlaceholderAPI
            getLogger().warning("PlaceholderAPI not found! Plugin messaging might be inconsistent");
        }

        loadConfig();
        loadCommands();
        loadListeners();

        logger.log(Level.INFO,"=========[SGDUELS]=========");
        ArrayList<String> IDs = ArenaBuilder.listArenas();
        int i = IDs.size();
        for(String s:IDs){
            ArenaTracker.freeArenas.add(s);
            logger.log(Level.INFO,"Loading arena into cache: "+s);
        }
        logger.log(Level.INFO,"Finished loading arenas!");
        logger.log(Level.INFO,"=========[SGDUELS]=========");
        logger.log(Level.INFO,"SGDUELS is ready!");
    }
    @Override
    public void onDisable() {
        super.onDisable();
        logger.log(Level.INFO,"SGDUELS deactivated!");
    }
    private void loadListeners(){
        new _EventLoader(this);
        Event_HeartBeat.beat();
    }
    private void loadCommands(){
        _CommandLoader.loadCommands();
    }
    private void loadConfig(){
        //TODO setup config

        //Config.createMainFolder();
        //Config.createFolder("kits");
        //Config.createFolder("userdata");
    }
}
