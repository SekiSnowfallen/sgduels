package com.akabex86.player;

import com.akabex86.arena.ArenaBuilder;
import com.akabex86.arena.ArenaTracker;
import com.akabex86.game.GameLoop;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;

public class Request {
    private static HashMap<String, ArrayList<String>>challenges = new HashMap<>();

    public static void ask(Player attacker, Player target){
        ArrayList<String> attackerList = getAsked(attacker);
        ArrayList<String> targetList = getAsked(target);

        if(targetList.contains(attacker.getName())){
            finalize(attacker,target);
            return;
        }
        if(!attackerList.contains(target.getName())){
            attackerList.add(target.getName());
            attacker.sendMessage("§eYou challenged §e§l"+target.getName()+" §eto a duel!");
            target.sendMessage("§e§l"+attacker.getName()+"§e challenged you to a duel!");
            System.out.println("SGD LOG: Added "+target.getName()+" to "+attacker.getName()+"'s list.");
        }
        challenges.put(attacker.getName(),attackerList);
    }
    public static void revoke (Player attacker, Player target){
        ArrayList<String> players = getAsked(attacker);
        if(players.contains(target.getName())){
            players.remove(target.getName());
            challenges.put(attacker.getName(),players);
            //TODO REMOVE THIS DEBUG LINE - THIS ENTIRE CLASS STILL NEEDS TESTING
            attacker.sendMessage("§eChallenge revoked.");
            target.sendMessage("§e"+attacker.getName()+" revoked the challenge.");
            System.out.println("SGD LOG: Removed "+target.getName()+" from "+attacker.getName()+"'s list.");
        }
    }
    public static ArrayList<String> getAsked(Player p){
        ArrayList<String> players = challenges.get(p.getName());
        if(players == null) return new ArrayList<>();
        return players;
    }

    private static void finalize (Player player1, Player player2){
        if(ArenaTracker.freeArenas.isEmpty()){
            //NO ARENAS AVAILABLE
            player1.sendMessage("§cThere are currently no free arenas, please try again.");
            player2.sendMessage("§cThere are currently no free arenas, please wait.");
            return;
        }
        player1.sendMessage("§eYou accepted the duel request by §e§l"+player2.getName());
        player2.sendMessage("§e§l"+player1.getName()+"§e accepted your request!");
        ArenaBuilder a = ArenaBuilder.loadArena(ArenaTracker.freeArenas.get(0));//TODO MAKE THIS RANDOM
        GameLoop loop = new GameLoop(5,10,10);//STARTS THE GAME WITH TEST PARAMS. DESIRED PARAMS ARE 5,180,600.
        loop.startGame(player1,player2,a);
    }
}
