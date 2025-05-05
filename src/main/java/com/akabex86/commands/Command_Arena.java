package com.akabex86.commands;

import java.util.ArrayList;
import java.util.HashMap;

import com.akabex86.main.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Arena implements CommandExecutor {
    public Command_Arena(Main main) {

    }
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
                if(args.length == 1){
                    if(args[0].equalsIgnoreCase("list")) {
                        //list all registered Arenas
                        return true;
                    }

                    if(args[0].equalsIgnoreCase("info")) {
                        //show cache/info of current arena
                        return true;
                    }
                    if(args[0].equalsIgnoreCase("clear")) {
                        //clear cache
                        return true;
                    }
                    if(args[0].equalsIgnoreCase("save")) {
                        //list Arenas
                        return true;
                    }
                    //show help if args[0] is invalid
                    showHelp(p);
                    return true;
                }
                /*if(args.length == 1){
                    }else if(args[0].equalsIgnoreCase("list")){
                        List<String> IDs = ArenaBuilder.listArenas();
                        int i = IDs.size();
                        p.sendMessage("§6Derzeit sind (§e"+i+"§6) Arenas geladen!");
                        if(IDs.size() != 0){
                            for(String ID:IDs){
                                ArenaBuilder a = ArenaBuilder.loadArena(ID);
                                //p.sendMessage("§7- §eID:§6"+ID+" §8[§7"+a.getName()+"§7 von §7"+a.getAuthor()+"§8§r");
                            }
                        }
                    }else if(args[0].equalsIgnoreCase("status")){
                        if(ID.get(p.getName()) == null){p.sendMessage("�7ID: �c-");}else{p.sendMessage("�7ID: �a"+ID.get(p.getName()));}
                        if(name.get(p.getName()) == null){p.sendMessage("�7NAME: �c-");}else{p.sendMessage("�7NAME: �a"+name.get(p.getName()));}
                        if(author.get(p.getName()) == null){p.sendMessage("�7AUTHOR: �c-");}else{p.sendMessage("�7AUTHOR: �a"+author.get(p.getName()));}
                        if(spawn.get(p.getName()) == null){p.sendMessage("�7SPAWN: �c-");}else{p.sendMessage("�7SPAWN: �a"+ Utils.locationToString(spawn.get(p.getName())));}
                        if(p1.get(p.getName()) == null){p.sendMessage("�7P1: �c-");}else{p.sendMessage("�7P1: �a"+Utils.locationToString(p1.get(p.getName())));}
                        if(p2.get(p.getName()) == null){p.sendMessage("�7P2: �c-");}else{p.sendMessage("�7P2: �a"+Utils.locationToString(p2.get(p.getName())));}
                        if(d1.get(p.getName()) == null){p.sendMessage("�7D1: �c-");}else{p.sendMessage("�7D1: �a"+Utils.locationToString(d1.get(p.getName())));}
                        if(d2.get(p.getName()) == null){p.sendMessage("�7D2: �c-");}else{p.sendMessage("�7D2: �a"+Utils.locationToString(d2.get(p.getName())));}
                        if(chests.containsKey(p.getName()))p.sendMessage("�7Chests: �r"+chests.get(p.getName()).size());

                    }else if(args[0].equalsIgnoreCase("clear")){
                        ID.remove(p.getName());
                        name.remove(p.getName());
                        author.remove(p.getName());
                        spawn.remove(p.getName());
                        p1.remove(p.getName());
                        p2.remove(p.getName());
                        d1.remove(p.getName());
                        d2.remove(p.getName());
                        chests.remove(p.getName());
                        p.sendMessage("�6Arena Cache geleert!");
                    }else if(args[0].equalsIgnoreCase("save")){
                        if(ID.get(p.getName()) == null||name.get(p.getName()) == null||
                                author.get(p.getName()) == null||spawn.get(p.getName()) == null||
                                p1.get(p.getName()) == null||p2.get(p.getName()) == null||
                                d1.get(p.getName()) == null||d2.get(p.getName()) == null){

                            p.sendMessage("�cFolgende parameter m�ssen noch gesetzt werden:");
                            if(ID.get(p.getName()) == null){p.sendMessage("�c- ID");}
                            if(name.get(p.getName()) == null){p.sendMessage("�c- NAME");}
                            if(author.get(p.getName()) == null){p.sendMessage("�c- AUTHOR");}
                            if(spawn.get(p.getName()) == null){p.sendMessage("�c- SPAWN");}
                            if(p1.get(p.getName()) == null){p.sendMessage("�c- P1");}
                            if(p2.get(p.getName()) == null){p.sendMessage("�c- P2");}
                            if(d1.get(p.getName()) == null){p.sendMessage("�c- D1");}
                            if(d2.get(p.getName()) == null){p.sendMessage("�c- D2");}
                        }else{
                            Arena.createArena(ID.get(p.getName()),
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
                            p.sendMessage("�6Arena gespeichert!");
                        }
                    }else if(args[0].equalsIgnoreCase("setspawn")){
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
                    if(args[0].equalsIgnoreCase("load")){
                        ArrayList<String> IDs = Arena.ArenaList();
                        String called_ID = args[1];
                        if ((IDs.contains(called_ID)) && (called_ID != null)){
                            Arena a = Arena.loadArena(called_ID);
                            ID.put(p.getName(), a.getID());
                            name.put(p.getName(), a.getName());
                            author.put(p.getName(), a.getAuthor());
                            spawn.put(p.getName(), a.getSpawnLoc());
                            p1.put(p.getName(), a.getP1Loc());
                            p2.put(p.getName(), a.getP2Loc());
                            d1.put(p.getName(), a.getDM1Loc());
                            d2.put(p.getName(), a.getDM2Loc());
                            if (a.getChests() != null){
                                if(chests.containsKey(p.getName())){
                                    chests.get(p.getName()).clear();
                                    chests.get(p.getName()).addAll(a.getChests());
                                }else{
                                    ArrayList<String> cst = new ArrayList<>();
                                    chests.put(p.getName(), cst);
                                    chests.get(p.getName()).clear();
                                    chests.get(p.getName()).addAll(a.getChests());
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
                            p.sendMessage("�6Arena geladen! �8[�7" + called_ID + "�8]");
                        }else{
                            p.sendMessage("�6Unbekannte Arena ID! �8[�7" + called_ID + "�8]");
                        }
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
        p.sendMessage("§6/arena help §8- §eShows this page!");
        p.sendMessage("§6/arena list §8- §eShows a list of all arenas!");

        //p.sendMessage("§6/arena editor §8- §eEnable Editmode");
        p.sendMessage("§6/arena info §8- §eDisplay currently cached arena");
        p.sendMessage("§6/arena clear §8- §eArenacache bereinigen");
        p.sendMessage("§6/arena save §8- §eArena Speichern!");
        p.sendMessage("§6/arena setspawn §8- §eArena Spawn setzen!");
        p.sendMessage("§6/arena setp1 §8- §eSpieler1 Spawnpunkt setzen!");
        p.sendMessage("§6/arena setp2 §8- §eSpieler2 Spawnpunkt setzen!");
        p.sendMessage("§6/arena setd1 §8- §eDeathmatch1 Spawn setzen!");
        p.sendMessage("§6/arena setd2 §8- §eDeathmatch2 Spawn setzen!");
        p.sendMessage("§6/arena addchest §8- §eTruhe hinzufügen!");
        p.sendMessage("§6/arena delchest §8- §eTruhe entfernen!");

        p.sendMessage("§6/arena load <arenaid> §8- §eArena aus Arenaliste laden!");
        p.sendMessage("§6/arena setid <id>§8- §eArenaid setzen!");
        p.sendMessage("§6/arena setname <name>§8- §eArenanamen setzen!");
        p.sendMessage("§6/arena setauthor <author>§8- §eAuthor setzen!");

        p.sendMessage("§6/arena tp <id>§8- §eTeleportiere in eine Arena!");
        p.sendMessage("§6/arena leave§8- §eTeleportiere zurück zum Spawn!");

    }
}
