package com.akabex86.commands;


import com.akabex86.main.Main;
import com.akabex86.utils.PlayerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Debug implements CommandExecutor {

    public Command_Debug(Main main){

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if(!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player)sender;
        if(args.length == 1){
            p.sendMessage("§c§lDEBUG - DYNAMIC VARIABLES FOR "+args[0].toUpperCase());
            p.sendMessage("§cisInventoryLocked §8= §7"+PlayerUtils.isInventoryLocked(args[0]));
            p.sendMessage("§cisGod §8= §7"+PlayerUtils.isGod(args[0]));
            return true;
        }
        p.sendMessage("§c§lDEBUG - DYNAMIC VARIABLES FOR "+p.getName().toUpperCase());
        p.sendMessage("§cisInventoryLocked §8= §7"+PlayerUtils.isInventoryLocked(p));
        p.sendMessage("§cisGod §8= §7"+PlayerUtils.isGod(p));

        return true;
    }
}
