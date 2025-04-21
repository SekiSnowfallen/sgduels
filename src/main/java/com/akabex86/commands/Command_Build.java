package com.akabex86.commands;

import com.akabex86.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Build implements CommandExecutor {
    public Command_Build(Main main) {

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            /*
            if(Utils.editMode.contains(p)){
                Utils.editMode.remove(p);
                Inventory.lock(p);
                p.sendMessage("�eDu kannst nicht mehr bauen!");
                InventoryLoader.loadLobbyInv(p);
            }else{
                Utils.editMode.add(p);
                Inventory.unlock(p);
                p.sendMessage("�eDu kannst jetzt bauen!");
                InventoryLoader.loadCreativeInv(p);
            }
             */
        }else{
            System.out.println("Fehler: Der Befehl kann nur von einem Spieler genutzt werden!");
        }
        return true;
    }
}
