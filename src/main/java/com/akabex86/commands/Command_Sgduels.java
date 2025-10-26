package com.akabex86.commands;

import com.akabex86.arena.ArenaBuilder;
import com.akabex86.arena.ArenaTracker;
import com.akabex86.main.Main;
import com.akabex86.player.Request;
import com.akabex86.utils.PlayerUtils;
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
        if(!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player)sender;
        if(args.length == 0){
            showHelp(p);
            return true;
        }
        if (args[0].equalsIgnoreCase("debug")){
            if(!p.hasPermission("SGDuels.admin")){
                showHelp(p);
                return true;
            }
            p.sendMessage("§aShowing debug information...");
            //TODO SHOW MORE DEBUG INFO
            //p.sendMessage("§6Currently challenging:");
            //TODO ADD THE PLAYERS IM CHALLENGING HERE (Method needs general fixing)
            p.sendMessage("§6Currently challenged by:");
            if(!Request.getAsked(p).isEmpty()){
                for(String s:Request.getAsked(p)){
                    p.sendMessage("§8- §e"+s);
                }
            }else{
                p.sendMessage("§cnone.");
            }
            p.sendMessage("§6Registered Arenas:");
            for(String ID: ArenaBuilder.listArenas()){
                if(ArenaTracker.freeArenas.contains(ID)){
                    p.sendMessage("§8- §7"+ID+" §aWaiting for players...");
                }else{
                    p.sendMessage("§8- §7"+ID+" §cIngame");
                }
            }
            return true;
        }
        if (args[0].equalsIgnoreCase("setspawn")){
            //TODO MAKE SETSPAWN COMMAND (BUILD CLASSES)
            return true;
        }
        if (args[0].equalsIgnoreCase("ask")){
            Player target = Bukkit.getPlayer(args[1]);
            if (target != null) {
                if(p == target){
                    p.sendMessage("§cBruh. Yo stoopid?");
                    return true;
                }
                Request.ask(p,target);
                return true;
            }
            p.sendMessage("§cPlayer not found.");
            return true;
        }
        if (args[0].equalsIgnoreCase("revoke")){
            //revoke challenge

            return true;
        }


            /*
            if(args.length == 0){
                //Utils.showHelp(p);
            }else if(args.length == 1){
                if(args[0].equalsIgnoreCase("setspawn")){
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
        return true;
    }
    private void showHelp(Player p){
        p.sendMessage("§e§lSGDuels §8§l- §6§lHELP");
        p.sendMessage("§6Hit Players with your §e§lDuel Blade§r§6 in order to challenge");
        p.sendMessage("§6them to a Duel or to §aaccept§6 challenges.");
        p.sendMessage("§6 §r");
        p.sendMessage("§6Right click to §ccancel§6 a pending challenge.");
        p.sendMessage("§6 §r");
        //TODO ADD CONTENT THROUGH PERMISIONS
        PlayerUtils.playSound(p,Sound.BLOCK_NOTE_BLOCK_PLING);
    }
}
