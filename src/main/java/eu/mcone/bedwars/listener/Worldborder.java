package eu.mcone.bedwars.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;

public class Worldborder {

    private Location loc;
    private WorldBorder wb;
    private int size;

    public Worldborder(Location loc, int size) {
        this.loc = loc;
        this.size = size;
        wb = Bukkit.getWorld(loc.getWorld().getUID()).getWorldBorder();
        wb.setCenter(loc);
        wb.setSize(size);
        wb.setWarningDistance(10);
    }

    public void update(Location loc, int new_size) {
        wb.reset();
        wb.setCenter(loc);
        wb.setSize(new_size);
        wb.setWarningDistance(10);
    }

    public void update(Location loc) {
        wb.reset();
        wb.setCenter(loc);
        wb.setSize(size);
        wb.setWarningDistance(10);
    }

    public int getSize() {
        return size;
    }

    public WorldBorder getWb() {
        return wb;
    }

    public Location getLoc() {
        return loc;
    }
}
