package com.akabex86.commands;

import com.akabex86.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Sgduels implements CommandExecutor {
    public Command_Sgduels(Main main) {

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            /*
            if(args.length == 0){
                //Utils.showHelp(p);
            }else if(args.length == 1){
                if(args[0].equalsIgnoreCase("debug")){
                    if(p.hasPermission("SGDuels.admin")){
                        p.sendMessage("�aDebug infos:");
                        if(Request.getAsked(p).size() != 0){
                            p.sendMessage("�6Eigene Herausforderungen:");
                            for(String s:Request.getAsked(p)){
                                p.sendMessage("�8- �e"+s);
                            }
                        }
                        p.sendMessage("�3Arenas:");
                        for(String ID:Arena.ArenaList()){
                            if(Arena.FreeArenas.contains(ID)){
                                p.sendMessage("�8- �7"+ID+" �a(Frei)");
                            }else{
                                p.sendMessage("�8- �7"+ID+" �c(Ingame)");
                            }
                        }
                        p.sendMessage("�2Spieler:");
                        for(Player all:Bukkit.getOnlinePlayers()){
                            if(Arena.inGameP.contains(all)){
                                if(Arena.inGameDead.contains(all)){
                                    p.sendMessage("�8- �7"+all.getName()+" �a(Ingame) �7�oGestorben�r");
                                }else{
                                    p.sendMessage("�8- �7"+all.getName()+" �a(Ingame)");
                                }
                            }else{
                                p.sendMessage("�8- �7"+all.getName()+" �r(Lobby)");
                            }
                        }
                    }else{
                        Utils.showHelp(p);
                    }
                }else if(args[0].equalsIgnoreCase("setspawn")){
                    Spawn.setSpawn(p.getLocation());
                    p.sendMessage("�6Spawn Gesetzt!");
                }else{
                    Utils.showHelp(p);
                }
            }else if(args.length == 2){
                if(args[0].equalsIgnoreCase("ask")){
                    Player pto = Bukkit.getPlayer(args[1]);
                    if(pto == null){
                        p.sendMessage(Messages.SGD_Ask_Offline);
                    }else{
                        if(p == pto){
                            p.sendMessage(Messages.SGD_Ask_Self);
                        }else{
                            if(Request.getAsked(p).contains(pto.getName())){
                                p.sendMessage(Messages.Damage_Accepted);
                            }else{
                                p.sendMessage(Messages.Damage_Challenge_SELF(pto));
                                Request.ask(p, pto);
                            }
                        }
                    }
                }else if(args[0].equalsIgnoreCase("revoke")){
                    Player pto = Bukkit.getPlayer(args[1]);
                    if(pto == null){
                        p.sendMessage(Messages.SGD_Ask_Offline);
                    }else{
                        if(Request.getAsked(p).contains(pto.getName())){
                            p.sendMessage(Messages.Interact_Revoke_SELF(pto));
                            pto.sendMessage(Messages.Interact_Revoke_OTHERS(p));

                            Utils.playSound(p, Sound.NOTE_BASS);
                            Utils.playSound(pto, Sound.NOTE_BASS);

                            Request.revoke(p, pto);
                        }
                    }
                }else{
                    Utils.showHelp(p);				}
            }else{
                Utils.showHelp(p);
            }
                 */
        }else{
            System.out.println("Fehler: Der Befehl kann nur von einem Spieler genutzt werden!");
        }
        return true;
    }
}
