package com.akabex86.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.akabex86.arena.ArenaBuilder;
import com.akabex86.main.Main;
import com.akabex86.utils.Converters;
import it.unimi.dsi.fastutil.Hash;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Arena implements CommandExecutor {
    public Command_Arena(Main main) {

    }
    //TEMPORARY SOLUTION (Per-player EDITOR CACHE)
    public static HashMap<String,String> ID = new HashMap<>();
    public static HashMap<String,String> name = new HashMap<>();
    public static HashMap<String,String> author = new HashMap<>();
    public static HashMap<String,Location> spawn = new HashMap<>();
    public static HashMap<String,Location> p1 = new HashMap<>();
    public static HashMap<String,Location> p2 = new HashMap<>();
    public static HashMap<String,Location> d1 = new HashMap<>();
    public static HashMap<String,Location> d2 = new HashMap<>();
    public static HashMap<String, ArrayList<String>> chests = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;

            if(p.hasPermission("SGDuels.admin")){
                if(args.length == 0){
                    showHelp(p);
                    return true;
                }
                if(args[0].equalsIgnoreCase("list")) {
                    //list all registered Arenas
                    List<String> IDs = ArenaBuilder.listArenas();
                    int i = IDs.size();
                    p.sendMessage("§6There are currently (§e"+i+"§6) arenas loaded!");
                    if(IDs.size() != 0){
                        for(String ID:IDs){
                            ArenaBuilder a = ArenaBuilder.loadArena(ID);
                            p.sendMessage("§7- §eID:§6"+ID+" §8[§7"+a.getMapName()+"§7 von §7"+a.getMapAuthor()+"§8§r");
                        }
                    }
                    return true;
                }
                if(args[0].equalsIgnoreCase("status")) {
                    p.sendMessage("§e§lARENA EDITOR §8§l- §6§lSTATUS");
                    if(ID.get(p.getName()) == null){p.sendMessage("§7ID: §c-");}else{p.sendMessage("§7ID: §a"+ID.get(p.getName()));}
                    if(name.get(p.getName()) == null){p.sendMessage("§7NAME: §c-");}else{p.sendMessage("§7NAME: §a"+name.get(p.getName()));}
                    if(author.get(p.getName()) == null){p.sendMessage("§7AUTHOR: §c-");}else{p.sendMessage("§7AUTHOR: §a"+author.get(p.getName()));}

                    if(spawn.get(p.getName()) == null){p.sendMessage("§7SPAWN: §c-");}else{p.sendMessage("§7SPAWN: §a"+ Converters.locationToString(spawn.get(p.getName())));}
                    if(p1.get(p.getName()) == null){p.sendMessage("§7P1: §c-");}else{p.sendMessage("§7P1: §a"+Converters.locationToString(p1.get(p.getName())));}
                    if(p2.get(p.getName()) == null){p.sendMessage("§7P2: §c-");}else{p.sendMessage("§7P2: §a"+Converters.locationToString(p2.get(p.getName())));}
                    if(d1.get(p.getName()) == null){p.sendMessage("§7D1: §c-");}else{p.sendMessage("§7D1: §a"+Converters.locationToString(d1.get(p.getName())));}
                    if(d2.get(p.getName()) == null){p.sendMessage("§7D2: §c-");}else{p.sendMessage("§7D2: §a"+Converters.locationToString(d2.get(p.getName())));}
                    if(chests.containsKey(p.getName()))p.sendMessage("§7Chests: §r"+chests.get(p.getName()).size());
                    return true;
                }
                if(args[0].equalsIgnoreCase("save")) {
                    if(ID.get(p.getName()) == null||name.get(p.getName()) == null||
                            author.get(p.getName()) == null||spawn.get(p.getName()) == null||
                            p1.get(p.getName()) == null||p2.get(p.getName()) == null||
                            d1.get(p.getName()) == null||d2.get(p.getName()) == null){

                        p.sendMessage("§cThe following parameters still need to be set:");
                        if(ID.get(p.getName()) == null){p.sendMessage("§c- ID");}
                        if(name.get(p.getName()) == null){p.sendMessage("§c- NAME");}
                        if(author.get(p.getName()) == null){p.sendMessage("§c- AUTHOR");}
                        if(spawn.get(p.getName()) == null){p.sendMessage("§c- SPAWN");}
                        if(p1.get(p.getName()) == null){p.sendMessage("§c- P1");}
                        if(p2.get(p.getName()) == null){p.sendMessage("§c- P2");}
                        if(d1.get(p.getName()) == null){p.sendMessage("§c- D1");}
                        if(d2.get(p.getName()) == null){p.sendMessage("§c- D2");}
                    }else {
                        ArenaBuilder.createArena(ID.get(p.getName()),
                                name.get(p.getName()),
                                author.get(p.getName()),
                                spawn.get(p.getName()),
                                p1.get(p.getName()),
                                p2.get(p.getName()),
                                d1.get(p.getName()),
                                d2.get(p.getName()),
                                chests.get(p.getName()));

                        ID.remove(p.getName());
                        name.remove(p.getName());
                        author.remove(p.getName());
                        spawn.remove(p.getName());
                        p1.remove(p.getName());
                        p2.remove(p.getName());
                        d1.remove(p.getName());
                        d2.remove(p.getName());
                        chests.remove(p.getName());
                        p.sendMessage("§6Arena saved!");
                    }
                    return true;
                }
                if(args[0].equalsIgnoreCase("load")) {
                    if(args.length == 1){
                        p.sendMessage("§6/arena load <§cid§6>");
                        return true;
                    }
                    ArrayList<String> IDs = ArenaBuilder.listArenas();
                    String called_ID = args[1];
                    if ((IDs.contains(called_ID)) && (called_ID != null)){
                        ArenaBuilder a = ArenaBuilder.loadArena(called_ID);
                        ID.put(p.getName(), a.getID());
                        name.put(p.getName(), a.getMapName());
                        author.put(p.getName(), a.getMapAuthor());
                        spawn.put(p.getName(), a.getSpawn());
                        p1.put(p.getName(), a.getPlayerSpawn(1));
                        p2.put(p.getName(), a.getPlayerSpawn(2));
                        d1.put(p.getName(), a.getDeathmatchSpawn(1));
                        d2.put(p.getName(), a.getDeathmatchSpawn(2));

                        if (a.getCrates() != null){
                            if(chests.containsKey(p.getName())){
                                chests.get(p.getName()).clear();
                                chests.get(p.getName()).addAll(a.getCrates());
                            }else{
                                ArrayList<String> cst = new ArrayList<>();
                                chests.put(p.getName(), cst);
                                chests.get(p.getName()).clear();
                                chests.get(p.getName()).addAll(a.getCrates());
                            }
                        }else{
                            if(chests.containsKey(p.getName())){
                                chests.get(p.getName()).clear();
                            }else{
                                ArrayList<String> cst = new ArrayList<>();
                                chests.put(p.getName(), cst);
                                chests.get(p.getName()).clear();
                            }
                            chests.clear();
                        }
                        p.sendMessage("§6Arena loaded successfully! §8[§7" + called_ID + "§8]");
                    }else{
                        p.sendMessage("§6Unknown arena ID! §8[§c" + called_ID + "§8]");
                    }
                    return true;
                }
                if(args[0].equalsIgnoreCase("clear")) {
                    ID.remove(p.getName());
                    name.remove(p.getName());
                    author.remove(p.getName());
                    spawn.remove(p.getName());
                    p1.remove(p.getName());
                    p2.remove(p.getName());
                    d1.remove(p.getName());
                    d2.remove(p.getName());
                    chests.remove(p.getName());
                    p.sendMessage("§6cleared arena from cache. \n§6You can load a new one with /arena load <ID> or create a new one by adding the values manually.");
                    return true;
                }
                if(args[0].equalsIgnoreCase("set")) {

                    return true;
                }
                //show help if args[0] is invalid
                showHelp(p);
                return true;

                /*if(args.length == 1){
                if(args[0].equalsIgnoreCase("setspawn")){
                        spawn.put(p.getName(), p.getLocation());
                        p.sendMessage("�6Arena �eSpawn �6gesetzt!");
                    }else if(args[0].equalsIgnoreCase("setp1")){
                        p1.put(p.getName(), p.getLocation());
                        p.sendMessage("�6Arena �eP1 �6gesetzt!");
                    }else if(args[0].equalsIgnoreCase("setp2")){
                        p2.put(p.getName(), p.getLocation());
                        p.sendMessage("�6Arena �eP2 �6gesetzt!");
                    }else if(args[0].equalsIgnoreCase("setd1")){
                        d1.put(p.getName(), p.getLocation());
                        p.sendMessage("�6Arena �eD1 �6gesetzt!");
                    }else if(args[0].equalsIgnoreCase("setd2")){
                        d2.put(p.getName(), p.getLocation());
                        p.sendMessage("�6Arena �eD2 �6gesetzt!");
                    }else if(args[0].equalsIgnoreCase("addchest")){
                        if(chests.containsKey(p.getName())){
                            chests.get(p.getName()).add(Utils.LocationToString(p.getLocation().getBlock().getLocation()));
                        }else{
                            ArrayList<String> cst = new ArrayList<>();
                            chests.put(p.getName(), cst);
                            chests.get(p.getName()).add(Utils.LocationToString(p.getLocation().getBlock().getLocation()));
                        }
                        p.sendMessage("�6Truhe hinzugef�gt!");
                    }else if(args[0].equalsIgnoreCase("delchest")){
                        if(chests.containsKey(p.getName())){
                            if(chests.get(p.getName()).contains(Utils.LocationToString(p.getLocation().getBlock().getLocation()))){
                                chests.get(p.getName()).remove(Utils.LocationToString(p.getLocation().getBlock().getLocation()));
                                p.sendMessage("�6Truhe entfernt!");
                            }else{
                                p.sendMessage("�6Keine Truhe gefunden!");
                            }
                        }else{
                            p.sendMessage("�6Keine Truhe gefunden!");
                        }
                    }else if(args[0].equalsIgnoreCase("leave")){
                        Spawn.Teleport(p);
                        p.sendMessage("�6Verlasse Arena!...");
                    }else{
                        showHelp(p);
                    }
                }else if(args.length == 2){
                    }else if(args[0].equalsIgnoreCase("setid")){
                        ID.put(p.getName(), args[1]);
                        p.sendMessage("�6Arena �eID �6gesetzt! �8[�7"+args[1]+"�8]");
                    }else if(args[0].equalsIgnoreCase("setname")){
                        name.put(p.getName(), args[1]);
                        p.sendMessage("�6Arena �eNAME �6gesetzt! �8[�7"+args[1]+"�8]");
                    }else if(args[0].equalsIgnoreCase("setauthor")){
                        author.put(p.getName(), args[1]);
                        p.sendMessage("�6Arena �eAUTHOR �6gesetzt! �8[�7"+args[1]+"�8]");
                    }else if(args[0].equalsIgnoreCase("tp")||args[0].equalsIgnoreCase("teleport")||args[0].equalsIgnoreCase("warp")){
                        ArrayList<String> IDs = Arena.ArenaList();
                        String called_ID = args[1];
                        if ((IDs.contains(called_ID)) && (called_ID != null)){
                            Arena a = Arena.loadArena(called_ID);
                            p.teleport(a.getSpawnLoc());
                            p.sendMessage("�6Teleportiere zur Arena... �8[�e" + called_ID + "�8]");
                        }else{
                            p.sendMessage("�6Unbekannte Arena ID �8[�e" + called_ID + "�8]");
                        }
                    }else{
                        showHelp(p);
                    }
                }else{
                    showHelp(p);
                }
            */
            }
            showHelp(p);
        }else{
            System.out.println("Error: Only players can use that command!");
        }
        return true;
    }

    private void showHelp(Player p){
        p.sendMessage("§e§lARENA EDITOR §8§l- §6§lHELP");
        p.sendMessage("§6/arena help §8- §eShows this page");
        p.sendMessage("§6/arena list §8- §eShows a list of all arenas");
        p.sendMessage("\n");
        p.sendMessage("§6/arena status §8- §eDisplay currently cached arena");
        p.sendMessage("§6/arena save §8- §eSave cached arena data");
        p.sendMessage("§6/arena load <arenaid> §8- §eLoad arena from list");
        p.sendMessage("§6/arena clear §8- §ePurge cached arena data");
        p.sendMessage("\n");
        p.sendMessage("§6/arena setid <id>§8- §eSet arena ID");
        p.sendMessage("§6/arena setname <name>§8- §eSet the name of the map");
        p.sendMessage("§6/arena setauthor <author>§8- §eSet the map author");
        p.sendMessage("§6/arena setspawn §8- §eSet arena spawn");
        p.sendMessage("§6/arena setp1 §8- §eSet spawn for player 1");
        p.sendMessage("§6/arena setp2 §8- §eSet spawn for player 2");
        p.sendMessage("§6/arena setd1 §8- §eSet deathmatch spawn for player 1");
        p.sendMessage("§6/arena setd2 §8- §eSet deathmatch spawn for player 2");
        p.sendMessage("§6/arena addchest §8- §eAdd chest where you're standing on");
        p.sendMessage("§6/arena delchest §8- §eDelete chest where you're standing on");
        p.sendMessage("\n");
        p.sendMessage("§6/arena tp <id>§8- §eTeleport to the arena spawn");
        p.sendMessage("§6/arena leave§8- §eTeleport back to sgduels lobby");

    }
}
