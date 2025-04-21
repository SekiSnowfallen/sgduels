package com.akabex86.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Converters {
    //This method contains a few helper classes.

    //Makes a time (Integer) look better than just 12384613897561385713641
    public static String timeFormat(int i){
        int mm = i/60;
        int ss = i % 60;
        String tf = mm+":"+ss;
        return tf;
    }
    public static Location stringToLocation(String locString){
        String[] locStringSplit = locString.split("\\,");

        double x = Double.parseDouble(locStringSplit[0]);
        double y = Double.parseDouble(locStringSplit[1]);
        double z = Double.parseDouble(locStringSplit[2]);

        float j = Float.parseFloat(locStringSplit[3]);
        float p = Float.parseFloat(locStringSplit[4]);

        String w = locStringSplit[5];

        return new Location(Bukkit.getWorld(w),x,y,z,j,p);
    }
    public static String locationToString(Location loc){
        String x = String.valueOf(loc.getX());
        String y = String.valueOf(loc.getY());
        String z = String.valueOf(loc.getZ());

        String j = String.valueOf(loc.getYaw());
        String p = String.valueOf(loc.getPitch());

        String w = loc.getWorld().getName();

        String spc = ",";

        return x+spc+y+spc+z+spc+j+spc+p+spc+w;
    }


}
