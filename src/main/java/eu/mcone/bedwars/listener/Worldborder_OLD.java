/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.listener;

import eu.mcone.bedwars.methods.Messenger;
import org.bukkit.Location;

import java.util.HashMap;

public class Worldborder_OLD {

    private String id;
    private HashMap<String, Location> location1 = new HashMap<>();
    private HashMap<String, Location> location2 = new HashMap<>();

    public Worldborder_OLD(String id) {
       this.id = id;
    }

    public Location getFromTwoPoints() {
        int yTop = 0;
        int yBottom = 0;

        int xTop = 0;
        int xBottom = 0;

        int zTop = 0;
        int zBottom = 0;

        if(location1.containsKey(id) && location2.containsKey(id)) {
            if(location1.get(id).getBlockY() >= location2.get(id).getBlockY()) {
                yTop = location1.get(id).getBlockY();
                yBottom = location2.get(id).getBlockY();
            } else {
                yTop = location2.get(id).getBlockY();
                yBottom = location1.get(id).getBlockY();
            }

            if(location1.get(id).getBlockX() >= location2.get(id).getBlockX()) {
                xTop = location1.get(id).getBlockX();
                xBottom = location2.get(id).getBlockX();
            } else {
                xTop = location2.get(id).getBlockX();
                xBottom = location1.get(id).getBlockX();
            }

            if(location1.get(id).getBlockZ() >= location2.get(id).getBlockZ()) {
                zTop = location1.get(id).getBlockZ();
                zBottom = location2.get(id).getBlockZ();
            } else {
                zTop = location2.get(id).getBlockZ();
                zBottom = location1.get(id).getBlockZ();
            }

            for(int x = xBottom; x < xTop; x++) {
                for(int y = yBottom; y < yTop; y++) {
                    for(int z = zBottom; z < zTop; z++) {
                        return new Location(location1.get(id).getWorld(), x, y, z);
                    }
                }
            }
        } else {
            Messenger.sendWarnToConsole("Worldborder: There is no location for the id '" + id + "'");
        }
        return null;
    }

    public void addLocation1(Location loc) {
        location1.put(id, loc);
    }

    public void addLocation2(Location loc) {
        location2.put(id, loc);
    }

    public void removeLocation1() {
        location1.remove(id);
    }

    public void removeLocation2() {
        location2.remove(id);
    }

    public Location getLocation1(){
        return location1.get(id);
    }

    public Location getLocation2(){
        return location1.get(id);
    }

    public String getId() {
        return id;
    }
}
