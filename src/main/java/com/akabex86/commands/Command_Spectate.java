package com.akabex86.commands;

import java.util.ArrayList;
import java.util.HashMap;

import com.akabex86.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Spectate implements CommandExecutor {
    public Command_Spectate(Main main) {

    }
    public static HashMap<String, ArrayList<String>> spectatorList = new HashMap<>();


    public static void addPlayer(String pName,String specName){
        if(spectatorList.containsKey(pName)){
            spectatorList.get(pName).add(specName);
            Player p = Bukkit.getPlayer(pName);
            Player spc = Bukkit.getPlayer(specName);
            spc.teleport(p);
        }else{
            ArrayList<String> spec = new ArrayList<>();
            spectatorList.put(pName, spec);
            spectatorList.get(pName).add(specName);
            Player p = Bukkit.getPlayer(pName);
            Player spc = Bukkit.getPlayer(specName);
            spc.teleport(p);
        }
    }
    /*
    public static void removePlayer(String pName,String specName){
        if(spectatorList.containsKey(pName)){
            if(Bukkit.getPlayer(specName)!= null){
                if(spectatorList.get(pName).contains(specName)){
                    Player spc = Bukkit.getPlayer(specName);
                    Spawn.Teleport(spc);
                    if(Utils.specMode.contains(spc)){
                        Utils.specMode.remove(spc);
                        spc.sendMessage(Messages.Prefix+"�7Du bist wieder am Spawn!");
                        InventoryLoader.loadLobbyInv(spc);
                    }
                    spectatorList.get(pName).remove(specName);
                }
            }
        }
    }
    public static void removePlayer_ALL(String specName){
        for(String pName:spectatorList.keySet()){
            if(spectatorList.containsKey(pName)){
                if(Bukkit.getPlayer(specName)!= null){
                    if(spectatorList.get(pName).contains(specName)){
                        Player spc = Bukkit.getPlayer(specName);
                        Spawn.Teleport(spc);
                        if(Utils.specMode.contains(spc)){
                            Utils.specMode.remove(spc);
                            spc.sendMessage(Messages.Prefix+"�7Du bist wieder am Spawn!");
                            InventoryLoader.loadLobbyInv(spc);
                        }
                        spectatorList.get(pName).remove(specName);
                    }
                }
            }
        }
    }
    public static void clear(String pName){
        if(spectatorList.containsKey(pName)){
            for(String specName:spectatorList.get(pName)){
                if(Bukkit.getPlayer(specName)!= null){
                    Player spc = Bukkit.getPlayer(specName);
                    Spawn.Teleport(spc);
                    if(Utils.specMode.contains(spc)){
                        Utils.specMode.remove(spc);
                        spc.sendMessage(Messages.Prefix+"�7Du bist wieder am Spawn!");
                        InventoryLoader.loadLobbyInv(spc);
                    }
                }
            }
            spectatorList.remove(pName);
        }
    }
    public static void teleportAll(String pName){
        if(spectatorList.containsKey(pName)){
            for(String specName:spectatorList.get(pName)){
                if(Bukkit.getPlayer(specName)!= null){
                    if(spectatorList.get(pName).contains(specName)){
                        Player p = Bukkit.getPlayer(pName);
                        Player spc = Bukkit.getPlayer(specName);
                        spc.teleport(p);
                    }
                }
            }
        }
    }
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            /*
            if(args.length == 1){
                if(!Arena.inGameP.contains(p)){
                    if(Bukkit.getPlayer(args[0])instanceof Player){
                        Player pto = Bukkit.getPlayer(args[0]);
                        if(Arena.inGameP.contains(pto)){
                            if(Arena.inGameDead.contains(pto)){
                                p.sendMessage(Messages.Prefix+"�cDer Spieler befindet sich in keiner Runde!");
                            }else{
                                if(Utils.specMode.contains(p)){

                                    p.sendMessage(Messages.Prefix+"�7Du bist wieder am Spawn!");
                                    removePlayer(pto.getName(), p.getName());
                                    InventoryLoader.loadLobbyInv(p);
                                }else{
                                    Utils.specMode.add(p);
                                    p.sendMessage(Messages.Prefix+"�7Du beobachtest nun "+args[0]);
                                    addPlayer(pto.getName(), p.getName());
                                    InventoryLoader.loadSpectatorInv(p);
                                }
                            }
                        }else{
                            p.sendMessage(Messages.Prefix+"�cDer Spieler befindet sich in keiner Runde!");
                        }
                    }else{
                        p.sendMessage(Messages.SGD_Ask_Offline);
                    }
                }else{
                    p.sendMessage(Messages.Prefix+"�cDu kannst dies nicht w�hrend eines Kampfes machen!");
                }
            }else if(args.length == 0){
                if(!Arena.inGameP.contains(p)){
                    if(Utils.specMode.contains(p)){

                        Utils.specMode.remove(p);
                        removePlayer_ALL(p.getName());

                    }else{
                        p.sendMessage(Messages.Prefix+"�7 Versuche es mit /spectate <spieler>");
                    }
                }else{
                    p.sendMessage(Messages.Prefix+"�cDu kannst dies nicht w�hrend eines Kampfes machen!");
                }
            }
            */
        }else{
            System.out.println("Fehler: Der Befehl kann nur von einem Spieler genutzt werden!");
        }
        return true;
    }
}
