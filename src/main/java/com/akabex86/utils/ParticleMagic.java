package com.akabex86.utils;

import com.akabex86.main.Main;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.awt.*;

public class ParticleMagic {
    //ALL PARTICLES ARE SPAWNED CLIENT SIDE ONLY!
    public static void spawnColoredParticle(Player p, Location loc, Color c){
        org.bukkit.Color col = org.bukkit.Color.fromRGB(c.getRed(),c.getGreen(),c.getBlue());
        Particle.DustOptions dust = new Particle.DustOptions(col,1.0F);

        p.spawnParticle(Particle.REDSTONE,loc,1,dust);

    }
    public static void spawnColoredParticle(Player p, Location loc) {
        spawnColoredParticle(p,loc,Color.white);
    }
    public static void drawLine(Player p,Location start, Location end, Color c){
        double distance = start.distance(end);
        double spacing = 0.1;

        //Calculate direction vector between start & end
        double dx = (end.getX()-start.getX())/distance;
        double dy = (end.getY()-start.getY())/distance;
        double dz = (end.getZ()-start.getZ())/distance;

        //Spawn particles alonng the line
        for(double i=0;i<=distance;i+=spacing){
            //Calculate the next particle position
            double x = start.getX()+(dx*i);
            double y = start.getY()+(dy*i);
            double z = start.getZ()+(dz*i);
            Location temp = new Location(start.getWorld(),x,y,z);
            spawnColoredParticle(p,temp,c);
        }
    }
    public static void drawLine(Player p, Location start, Location end){
        drawLine(p,start,end,Color.white);
    }
    public static void highlightBlock(Player p, Block b, Color c, double scale){
        Location loc = b.getLocation();
        //double scale = 1.0;
        //BOTTOM SQUARE
        drawLine(p,loc,new Location(loc.getWorld(),loc.getX()+scale,loc.getY(),loc.getZ()),c);
        drawLine(p,loc,new Location(loc.getWorld(),loc.getX(),loc.getY(),loc.getZ()+scale),c);
        drawLine(p,new Location(loc.getWorld(),loc.getX(),loc.getY(),loc.getZ()+scale),new Location(loc.getWorld(),loc.getX()+scale,loc.getY(),loc.getZ()+scale),c);
        drawLine(p,new Location(loc.getWorld(),loc.getX()+scale,loc.getY(),loc.getZ()+scale),new Location(loc.getWorld(),loc.getX()+scale,loc.getY(),loc.getZ()),c);
        //PILLARS
        drawLine(p,loc,new Location(loc.getWorld(),loc.getX(),loc.getY()+scale,loc.getZ()),c);
        drawLine(p,new Location(loc.getWorld(),loc.getX(),loc.getY(),loc.getZ()+scale),new Location(loc.getWorld(),loc.getX(),loc.getY()+scale,loc.getZ()+scale),c);
        drawLine(p,new Location(loc.getWorld(),loc.getX()+scale,loc.getY(),loc.getZ()),new Location(loc.getWorld(),loc.getX()+scale,loc.getY()+scale,loc.getZ()),c);
        drawLine(p,new Location(loc.getWorld(),loc.getX()+scale,loc.getY(),loc.getZ()+scale),new Location(loc.getWorld(),loc.getX()+scale,loc.getY()+scale,loc.getZ()+scale),c);
        //TOP SQUARE (OFFSET == 0.9 up on y axis
        drawLine(p,new Location(loc.getWorld(),loc.getX(),loc.getY()+scale,loc.getZ()),new Location(loc.getWorld(),loc.getX()+scale,loc.getY()+scale,loc.getZ()),c);
        drawLine(p,new Location(loc.getWorld(),loc.getX(),loc.getY()+scale,loc.getZ()),new Location(loc.getWorld(),loc.getX(),loc.getY()+scale,loc.getZ()+scale),c);
        drawLine(p,new Location(loc.getWorld(),loc.getX(),loc.getY()+scale,loc.getZ()+scale),new Location(loc.getWorld(),loc.getX()+scale,loc.getY()+scale,loc.getZ()+scale),c);
        drawLine(p,new Location(loc.getWorld(),loc.getX()+scale,loc.getY()+scale,loc.getZ()+scale),new Location(loc.getWorld(),loc.getX()+scale,loc.getY()+scale,loc.getZ()),c);
    }
    public static void  highlightBlock(Player p, Block b, Color c){
        highlightBlock(p,b,c,1.0);
    }public static void  highlightBlock(Player p, Block b){
        highlightBlock(p,b,Color.white);
    }
}
