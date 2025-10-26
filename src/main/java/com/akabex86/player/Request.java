package com.akabex86.player;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Request {
    private static HashMap<String, ArrayList<String>>challenges = new HashMap<>();

    public static void ask(Player attacker, Player target){
        ArrayList<String> players = getAsked(attacker);
        if(!players.contains(target.getName()))players.add(target.getName());
        challenges.put(attacker.getName(),players);
    }
    public static void revoke (Player attacker, Player target){
        ArrayList<String> players = getAsked(attacker);
        if(players.contains(target.getName())){
            players.remove(target.getName());
            challenges.put(attacker.getName(),players);
            //TODO REMOVE THIS DEBUG LINE - THIS ENTIRE CLASS STILL NEEDS TESTING
            System.out.println("SGD LOG: Removed "+target.getName()+" from "+attacker.getName()+"'s list.");
        }
    }



    public static ArrayList<String> getAsked(Player p){
        ArrayList<String> players = challenges.get(p.getName());
        if(players == null) return new ArrayList<>();
        return players;
    }
}
