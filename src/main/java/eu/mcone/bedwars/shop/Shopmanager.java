/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.shop;

import eu.mcone.coresystem.bukkit.util.ItemFactory;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;

public class Shopmanager implements Listener {

    public static void openShopInv(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §bShop");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }

        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));

        p.openInventory(inv);
    }

    public static void openShopBlöcke(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §6Blöcke");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }

        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));


        //Sandstone
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§c§l1 Bronze");
        inv.setItem(20, ItemFactory.createItem(Material.STAINED_CLAY, 1, 1, "§bSnadstone", lore,  false));

        //Endstone
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§c§l4 Bronze");
        inv.setItem(21, ItemFactory.createItem(Material.ENDER_STONE, 1, 1, "§bEndstone", lore,  false));

        //Glowstone
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("§c§l1 Bronze");
        inv.setItem(22, ItemFactory.createItem(Material.GLOWSTONE, 1, 1, "§bGlowstone", lore,  false));

        //Eisen
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("§c§l4 Eisen");
        inv.setItem(23, ItemFactory.createItem(Material.IRON_BLOCK, 1, 1, "§bEisen block", lore,  false));

        //Glas
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("§c§l1 Bronze");
        inv.setItem(24, ItemFactory.createItem(Material.GLASS, 1, 1, "§bGlas", lore,  false));

        p.openInventory(inv);
    }

    public static void openShopSpitzhacke(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §2Spitzhacke");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }

        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));

        //Holz Spitzhacke
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§c§l4 Bronze");
        inv.setItem(21, ItemFactory.createEnchantedItem(Material.WOOD_PICKAXE, Enchantment.DURABILITY, 1,1, 1, "§bHolz Spitzhacke",  lore,false));

        //Stein Spitzhacke
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§c§l2 Eisen");
        inv.setItem(22, ItemFactory.createEnchantedItem(Material.STONE_PICKAXE, Enchantment.DURABILITY, 2,1, 1, "§bStein Spitzhacke",  lore1,false));

        //Eisen Spitzhacke
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("§c§l2 Gold");

        HashMap<Enchantment, Integer> enchantments = new HashMap<>();
        enchantments.put(Enchantment.DURABILITY, 1);
        enchantments.put(Enchantment.DIG_SPEED, 1);
        inv.setItem(23, ItemFactory.createEnchantedItem(Material.WOOD_PICKAXE, enchantments,1, 1, "§bEisen Spitzhacke",  lore2,false));

        p.openInventory(inv);
    }

    public static void openShopSchwert(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §cSchwerter");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }

        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));

        //Knockback Stick
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§c§l8 Bronze");

        HashMap<Enchantment, Integer> enchantments = new HashMap<>();
        enchantments.put(Enchantment.DURABILITY, 1);
        enchantments.put(Enchantment.KNOCKBACK, 1);
        inv.setItem(20, ItemFactory.createEnchantedItem(Material.STICK, enchantments,1, 1, "§bKnockback Sticke",  lore ,false));

        //Holz Schwert-1
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§c§l3 Eisen");
        inv.setItem(21, ItemFactory.createEnchantedItem(Material.WOOD_SWORD, Enchantment.DURABILITY,1,1, 1, "§bHolz Schwert Lv.1",  lore1 ,false));

        //Holz Schwert-2
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("§c§l7 Eisen");

        HashMap<Enchantment, Integer> enchantments1 = new HashMap<>();
        enchantments1.put(Enchantment.DURABILITY, 1);
        enchantments1.put(Enchantment.DAMAGE_ALL, 1);

        inv.setItem(22, ItemFactory.createEnchantedItem(Material.WOOD_SWORD, enchantments1,1, 1, "§bHolz Schwert Lv.2",  lore2 ,false));

        //Holz Schwert-3
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("§c§l11 Eisen");

        HashMap<Enchantment, Integer> enchantments2 = new HashMap<>();
        enchantments2.put(Enchantment.DURABILITY, 1);
        enchantments2.put(Enchantment.DAMAGE_ALL, 2);

        inv.setItem(23, ItemFactory.createEnchantedItem(Material.WOOD_SWORD, enchantments2,1, 1, "§bHolz Schwert Lv.3",  lore3 ,false));

        //Eisen-Schwert
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("§c§l6 Gold");

        HashMap<Enchantment, Integer> enchantments3 = new HashMap<>();
        enchantments3.put(Enchantment.DURABILITY, 1);
        enchantments3.put(Enchantment.DAMAGE_ALL, 3);

        inv.setItem(24, ItemFactory.createEnchantedItem(Material.WOOD_SWORD, enchantments3,1, 1, "§bEisen Schwert",  lore4 ,false));

        p.openInventory(inv);
    }

    public static void openShopRüstung(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §9Rüstung");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }

        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));

        //Leder Helm
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§c§l4 Bronze");

        inv.setItem(18, ItemFactory.createEnchantedItem(Material.LEATHER_HELMET, Enchantment.DURABILITY,1,1, 1, "§bLeder Helm",  lore ,false));


        //Leder Hose
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§c§l4 Bronze");

        inv.setItem(19, ItemFactory.createEnchantedItem(Material.LEATHER_CHESTPLATE, Enchantment.DURABILITY,1,1, 1, "§bLeder Brustplatte",  lore1 ,false));

        //Leder Hose
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("§c§l4 Bronze");

        inv.setItem(20, ItemFactory.createEnchantedItem(Material.LEATHER_LEGGINGS, Enchantment.DURABILITY,1,1, 1, "§bLeder Hose",  lore2 ,false));

        //Leder Schuhe
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("§c§l4 Bronze");

        inv.setItem(21, ItemFactory.createEnchantedItem(Material.LEATHER_BOOTS, Enchantment.DURABILITY,1,1, 1, "§bLeder Schuhe",  lore3 ,false));

        //Ketten Brustzpanzer Lv.1
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("§c§l4 Eisen");

        inv.setItem(23, ItemFactory.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, Enchantment.DURABILITY,1,1, 1, "§bKetten Brustzpanzer Lv.1",  lore4 ,false));


        //Ketten Brustzpanzer Lv.2
        ArrayList<String> lore5 = new ArrayList<>();
        lore5.add("§c§l8 Eisen");

        HashMap<Enchantment, Integer> enchantments = new HashMap<>();
        enchantments.put(Enchantment.DURABILITY, 1);
        enchantments.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        inv.setItem(24, ItemFactory.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, enchantments,1, 1, "§bKetten Brustzpanzer Lv.2",  lore5 ,false));

        //Ketten Brustzpanzer Lv.2
        ArrayList<String> lore6 = new ArrayList<>();
        lore6.add("§c§l11 Eisen");

        HashMap<Enchantment, Integer> enchantments1 = new HashMap<>();
        enchantments1.put(Enchantment.DURABILITY, 1);
        enchantments1.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

        inv.setItem(25, ItemFactory.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, enchantments1,1, 1, "§bKetten Brustzpanzer Lv.3",  lore6 ,false));

        //Ketten Brustzpanzer Lv.2
        ArrayList<String> lore7 = new ArrayList<>();
        lore7.add("§c§l15 Eisen");

        HashMap<Enchantment, Integer> enchantments2 = new HashMap<>();
        enchantments2.put(Enchantment.DURABILITY, 1);
        enchantments2.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        enchantments2.put(Enchantment.THORNS, 1);

        inv.setItem(26, ItemFactory.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, enchantments2,1, 1, "§bKetten Brustzpanzer Lv.4",  lore7 ,false));

        p.openInventory(inv);
    }

    public static void openShopBogen(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §eBogen");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }

        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));

        //Bogen Lv.1
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§c§l4 Gold");

        HashMap<Enchantment, Integer> enchantments = new HashMap<>();
        enchantments.put(Enchantment.DURABILITY, 1);
        enchantments.put(Enchantment.ARROW_INFINITE, 1);

        inv.setItem(20, ItemFactory.createEnchantedItem(Material.BOW, enchantments,1, 1, "§bBogen Lv.1",  lore ,false));

        //Bogen Lv.2
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§c§l8 Gold");

        HashMap<Enchantment, Integer> enchantments1 = new HashMap<>();
        enchantments1.put(Enchantment.ARROW_KNOCKBACK, 1);
        enchantments1.put(Enchantment.ARROW_INFINITE, 1);

        inv.setItem(21, ItemFactory.createEnchantedItem(Material.BOW, enchantments1,1, 1, "§bBogen Lv.2",  lore1 ,false));

        //Bogen Lv.3
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("§c§l13 Gold");

        HashMap<Enchantment, Integer> enchantments2 = new HashMap<>();
        enchantments2.put(Enchantment.ARROW_KNOCKBACK, 1);
        enchantments2.put(Enchantment.ARROW_INFINITE, 1);
        enchantments2.put(Enchantment.ARROW_DAMAGE, 1);

        inv.setItem(22, ItemFactory.createEnchantedItem(Material.BOW, enchantments2,1, 1, "§bBogen Lv.3",  lore2 ,false));

        //Pfeil
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("§c§l1 Gold");

        inv.setItem(24, ItemFactory.createItem(Material.ARROW, 1,1 ,"§bPfeil", lore3, false));

        p.openInventory(inv);
    }

    public static void openShopKisten(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §6Kisten");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }

        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));

        //Holz Kiste
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§c§l4 Eisen");

        inv.setItem(21, ItemFactory.createItem(Material.CHEST, 1,1 ,"§bHolz Kiste", lore, false));

        //Ender Kiste
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§c§l2 Gold");

        inv.setItem(23, ItemFactory.createItem(Material.ENDER_CHEST, 1,1 ,"§bEnder Kiste", lore1, false));

        p.openInventory(inv);
    }

    public static void openShopEssen(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §bEssen");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }


        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));

        //Steak
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§c§l2 Bronze");

        inv.setItem(20, ItemFactory.createItem(Material.COOKED_BEEF, 1,1 ,"§bSteak", lore1, false));

        //Suppe
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("§c§l4 Bronze");

        inv.setItem(21, ItemFactory.createItem(Material.RABBIT_STEW, 1,1 ,"§bSuppe", lore2, false));

        //Brot
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("§c§l2 Bronze");

        inv.setItem(22, ItemFactory.createItem(Material.BREAD, 1,1 ,"§bBrot", lore3, false));

        //Gold Apfel
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("§c§l2 Gold");

        inv.setItem(24, ItemFactory.createItem(Material.GOLDEN_APPLE, 1,1 ,"§bGold Apfel", lore4, false));

        p.openInventory(inv);
    }

    public static void openShopTränke(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §5Tränke");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }

        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));

        //Schnellichkeit
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("§c§l6 Eisen");

        inv.setItem(19, ItemFactory.createItem(Material.POTION, 8194,1 ,"§bSchnellichkeit.", lore4, false));

        //Heilung Lv.1
        ArrayList<String> lore5 = new ArrayList<>();
        lore5.add("§c§l8 Eisen");

        inv.setItem(21, ItemFactory.createItem(Material.POTION, 8261,1 ,"§bHeilung Lv.1", lore5, false));

        //Heilung Lv.2
        ArrayList<String> lore6 = new ArrayList<>();
        lore6.add("§c§l12 Eisen");

        inv.setItem(23, ItemFactory.createItem(Material.POTION, 8229,1 ,"§bHeilung Lv.2", lore6, false));

        //Stärke
        ArrayList<String> lore7 = new ArrayList<>();
        lore7.add("§c§l8 Gold");

        inv.setItem(25, ItemFactory.createItem(Material.POTION, 8201,1 ,"§bStärke", lore7, false));

        p.openInventory(inv);
    }

    public static void openShopSpezial(Player p) {
        Inventory inv = org.bukkit.Bukkit.createInventory(null, 36, "§7▶ §3Spezial");

        for (int i = 0; i <= 35; i++) {
            inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 0, "", false));
        }

        inv.setItem(9, ItemFactory.createItem(Material.STAINED_CLAY, 0, 0, "§7▶ §6Blöcke", false));
        inv.setItem(10, ItemFactory.createItem(Material.WOOD_PICKAXE, 0, 0, "§7▶ §2Spitzhacke", false));
        inv.setItem(11, ItemFactory.createItem(Material.WOOD_SWORD, 0, 0, "§7▶ §cSchwerter", false));
        inv.setItem(12, ItemFactory.createItem(Material.CHAINMAIL_CHESTPLATE, 0, 0, "§7▶ §9Rüstung", false));
        inv.setItem(13, ItemFactory.createItem(Material.BOW, 0, 0, "§7▶ §eBogen", false));
        inv.setItem(14, ItemFactory.createItem(Material.CHEST, 0, 0, "§7▶ §6Kisten", false));
        inv.setItem(15, ItemFactory.createItem(Material.COOKED_BEEF, 0, 0, "§7▶ §bEssen", false));
        inv.setItem(16, ItemFactory.createItem(Material.POTION, 0, 0, "§7▶ §5Tränke", false));
        inv.setItem(17, ItemFactory.createItem(Material.ENDER_PEARL, 0, 0, "§7▶ §3Spezial", false));

        //Angel
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("§c§l8 Eisen");

        inv.setItem(20, ItemFactory.createItem(Material.FISHING_ROD, 0,1 ,"§bAngel", lore1, false));

        //brige
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("§c§l3 Eisen");

        inv.setItem(21, ItemFactory.createItem(Material.SNOW_BALL, 0,16 ,"§bSchneebälle", lore2, false));

        //warpowder
        ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("§c§l5 Eisen");

        inv.setItem(22, ItemFactory.createItem(Material.getMaterial(289), 0,1,"§bWarp Powder", lore3, false));

        //Rettungsplattform
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("§c§l3 Gold");

        inv.setItem(23, ItemFactory.createItem(Material.BLAZE_ROD, 0,1,"§bRettungsplattform", lore4, false));

        //Feuerzeug
        ArrayList<String> lore5 = new ArrayList<>();
        lore5.add("§c§l12 Gold");

        inv.setItem(24, ItemFactory.createItem(Material.ENDER_PEARL, 0,1,"§bEnderperl", lore5, false));

        p.openInventory(inv);
    }

}
