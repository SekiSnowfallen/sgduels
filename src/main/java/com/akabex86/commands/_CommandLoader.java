package com.akabex86.commands;

import com.akabex86.main.Main;

public class _CommandLoader {

    static Main main = Main.main;
    public static void loadCommands(){
        Command_Arena are = new Command_Arena(main);
        Command_Sgduels sgd = new Command_Sgduels(main);
        Command_Spectate spec = new Command_Spectate(main);
        Command_World wrld = new Command_World(main);

        main.getCommand("arena").setExecutor(are);
        main.getCommand("sgduels").setExecutor(sgd);
        main.getCommand("spectate").setExecutor(spec);
        main.getCommand("world").setExecutor(wrld);

    }
}
