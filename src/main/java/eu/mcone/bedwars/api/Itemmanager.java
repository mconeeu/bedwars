/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.api;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;


public class Itemmanager implements Listener {

    public static ItemStack CreateItemwithID(int id, int subid, int amount, String DisplayName, String lore, String lore2, String lore3) {

        @SuppressWarnings("deprecation")
        ItemStack is = new ItemStack(id, amount, (short) subid);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(DisplayName);
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add(lore);
        lore1.add(lore2);
        lore1.add(lore3);
        im.setLore(lore1);
        is.setItemMeta(im);
        return is;
    }


    public static ItemStack CreateItemwithMaterial(Material m, int subid, int amount, String DisplayName, ArrayList<String> lore) {
        ItemStack is = new ItemStack(m, amount, (short) subid);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(DisplayName);
        im.setLore(lore);
        is.setItemMeta(im);
        return is;

    }

    public static ItemStack createItem(Material material, int subid, int i, String displayname) {
        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta mitem = item.getItemMeta();
        mitem.setDisplayName(displayname);
        item.setItemMeta(mitem);

        return item;
    }

    public static ItemStack createItem(Material material, int subid, String displayname, int anzahl) {
        ItemStack item = new ItemStack(material, 1, (short) subid);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayname);
        item.setAmount(anzahl);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getSkull(String name) {
        @SuppressWarnings("deprecation")
        ItemStack skull = new ItemStack(397, 1, (short) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setDisplayName(name);
        meta.setOwner(name);
        skull.setItemMeta(meta);
        return skull;

    }

    public static ItemStack createHead(String owner, String displayname, String lore) {

        @SuppressWarnings("deprecation")
        ItemStack item = new ItemStack(397, 1, (short) 3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName(displayname);
        meta.setOwner(owner);
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add(lore);
        meta.setLore(lore1);
        item.setItemMeta(meta);
        return item;


    }

    public static ItemStack createLeatherBoots(Color color, String displayname) {

        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setDisplayName(displayname);
        meta.setColor(color);
        item.setItemMeta(meta);
        return item;

    }
}
