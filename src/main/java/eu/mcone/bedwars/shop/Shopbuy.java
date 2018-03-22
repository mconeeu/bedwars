/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.shop;

import eu.mcone.bedwars.api.Itemmanager;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.coresystem.bukkit.util.ItemFactory;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Shopbuy implements Listener{

    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        /*
         * Buy Items: Blöcke
         */

        //Sandstone
        if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bSandstone")) {
                e.setCancelled(true);
                 Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK, 1, p, Material.SANDSTONE, 0, 1, "", Sound.CHICKEN_EGG_POP);
                }
            }

        //Endstone
        if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bEndstone")) {
                e.setCancelled(true);
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK, 4, p, Material.ENDER_STONE, 0, 1, "", Sound.CHICKEN_EGG_POP);
            }
        }

        //Glowstone
        if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bGlowstone")) {
                e.setCancelled(true);
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK, 1, p, Material.GLOWSTONE, 0, 4, "", Sound.CHICKEN_EGG_POP);
            }
        }

        //Eisen
        if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bEisen")) {
                e.setCancelled(true);
                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT, 4, p, Material.IRON_BLOCK, 0, 1, "", Sound.CHICKEN_EGG_POP);
            }
        }

        //Glas
        if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bGlas")) {
                e.setCancelled(true);
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK, 1, p, Material.GLASS, 0, 4, "", Sound.CHICKEN_EGG_POP);
            }
        }

        /*
         * Buy Items: Spitzhacken
         */

        //Holz Spitzhacke
        if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bHolz Spitzhacke")) {
                e.setCancelled(true);
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK,4, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.WOOD_PICKAXE, Enchantment.DURABILITY, 1, 0, 1, "§éHolz Spitzhacke", false));
            }
        }

        //Stein Pitzhacke
        if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bStein Spitzhacke")) {
                e.setCancelled(true);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,2, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.STONE_PICKAXE, Enchantment.DURABILITY, 2, 0, 1, "§eStein Spitzhacke", false));
            }
        }

        //Eisen Pitzhacke
        if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bEisen Spitzhacke")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.DIG_SPEED, 1);
                enchantments.put(Enchantment.DURABILITY, 1);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,2, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.IRON_PICKAXE, enchantments, 0, 1, "§eEisen Spitzhacke", false));
            }
        }

        /*
         * Buy Items: Schwerter
         */

        //Knockback Stick
        if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bKnockback Stick")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.DURABILITY, 1);
                enchantments.put(Enchantment.KNOCKBACK, 1);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK,8, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.STICK, enchantments, 0, 1, "§5Knockback stick", false));
            }
        }

        //Holz Schwert Lv.1
        if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bHolz Schwert Lv.1")) {

                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,3, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.WOOD_SWORD, Enchantment.DURABILITY, 1,0, 1, "§bHolz Schwert Lv.1", false));
            }
        }

        //Holz Schwert Lv.2
        if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bHolz Schwert Lv.2")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.DIG_SPEED, 1);
                enchantments.put(Enchantment.DAMAGE_ALL, 1);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,7, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.WOOD_SWORD, enchantments,0, 1, "§bHolz Schwert Lv.2", false));
            }
        }

        //Holz Schwert Lv.3
        if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bHolz Schwert Lv.3")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.DURABILITY, 1);
                enchantments.put(Enchantment.DAMAGE_ALL, 1);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,11, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.WOOD_SWORD, enchantments,0, 1, "§bHolz Schwert Lv.3", false));
        }
        }

        //Eisen Schwert
        if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bEisen Schwert")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.DURABILITY, 1);
                enchantments.put(Enchantment.DAMAGE_ALL, 3);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,6, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.IRON_SWORD, enchantments,0, 1, "§bEisen Schwert", false));
            }
        }

        /*
         * Buy Items: Rüstung
         */

        //Leader Helm
        if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bLeder Helm")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK,4, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.LEATHER_HELMET, Enchantment.DURABILITY, 1,0, 1, "§bLeder Helm", false));
            }
        }

        //Leader Brustpanzer
        if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bLeder Brustpanzer")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK,4, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.LEATHER_CHESTPLATE, Enchantment.DURABILITY, 1,0, 1, "§bLeder Brustpanzer", false));
            }
        }

        //Leader Hose
        if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bLeder Hose")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK,4, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.LEATHER_LEGGINGS, Enchantment.DURABILITY, 1,0, 1, "§bLeder Hose", false));
            }
        }

        //Leader Hose
        if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bLeder Schuhe")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK,4, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.LEATHER_BOOTS, Enchantment.DURABILITY, 1,0, 1, "§bLeder Schuhe", false));
            }
        }

        //Ketten Brustzpanzer Lv.1
        if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bKetten Brustzpanzer Lv.1")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,4, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, Enchantment.DURABILITY, 1,0, 1, "§bKetten Brustzpanzer Lv.1", false));
            }
        }

        //Ketten Brustzpanzer Lv.2
        if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bKetten Brustzpanzer Lv.2")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.DURABILITY, 1);
                enchantments.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,8, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, enchantments, 0, 1, "§bKetten Brustzpanzer Lv.2", false));
            }
        }

        //Ketten Brustzpanzer Lv.3
        if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bKetten Brustzpanzer Lv.3")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.DURABILITY, 1);
                enchantments.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,11, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, enchantments, 0, 1, "§bKetten Brustzpanzer Lv.3", false));
            }
        }

        //Ketten Brustzpanzer Lv.3
        if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bKetten Brustzpanzer Lv.4")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.DURABILITY, 1);
                enchantments.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                enchantments.put(Enchantment.THORNS, 1);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,15, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.CHAINMAIL_CHESTPLATE, enchantments, 0, 1, "§bKetten Brustzpanzer Lv.4", false));
            }
        }

        /*
         * Buy Items: Bögen
         */

        //Bogen Lv.1
        if (e.getInventory().getName().equals("§7▶ §eBogen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bBogen Lv.1")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,4, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.BOW, Enchantment.ARROW_INFINITE, 1, 0, 1, "§bBogen Lv.1", false));
            }
        }

        //Bogen Lv.2
        if (e.getInventory().getName().equals("§7▶ §eBogen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bBogen Lv.2")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.ARROW_KNOCKBACK, 1);
                enchantments.put(Enchantment.ARROW_INFINITE, 1);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,8, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.BOW, enchantments, 0, 1, "§bBogen Lv.2", false));
            }
        }

        //Bogen Lv.3
        if (e.getInventory().getName().equals("§7▶ §eBogen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bBogen Lv.3")) {

                HashMap<Enchantment, Integer> enchantments = new HashMap<>();
                enchantments.put(Enchantment.ARROW_KNOCKBACK, 1);
                enchantments.put(Enchantment.ARROW_INFINITE, 1);
                enchantments.put(Enchantment.ARROW_DAMAGE, 1);

                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,13, p, Sound.CHICKEN_EGG_POP, ItemFactory.createEnchantedItem(Material.BOW, enchantments, 0, 1, "§bBogen Lv.3", false));
            }
        }

        //Pfeil
        if (e.getInventory().getName().equals("§7▶ §eBogen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bPfeil")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,1, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.ARROW, 1, 1, "§bPfeil", false));
            }
        }

        /*
         * Buy Items: Kisten
         */

        //Holz Kiste
        if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bHolz Kiste")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,4, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.CHEST, 1, 1, "§bHolz Kiste", false));
            }
        }

        //Ender Kiste
        if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bEnder Kiste")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,2, p, Sound.CHICKEN_EGG_POP,  ItemFactory.createItem(Material.ENDER_CHEST, 1, 1, "§bEnder Kiste", false));
            }
        }

        /*
         * Buy Items: Essen
         */

        //Steak
        if (e.getInventory().getName().equals("§7▶ §bEssen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bSteak")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK,2, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.COOKED_BEEF, 1, 1, "§bSteak", false));
            }
        }

        //Suppe
        if (e.getInventory().getName().equals("§7▶ §bEssen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bSuppe")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK,4, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.RABBIT_STEW, 1, 1, "§bSuppe", false));
            }
        }

        //Brot
        if (e.getInventory().getName().equals("§7▶ §bEssen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals( "§bBrot")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.CLAY_BRICK,2, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.BREAD, 1, 1, "§bBrot", false));
            }
        }

        //Gold Apfel
        if (e.getInventory().getName().equals("§7▶ §bEssen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bGold Apfel")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,2, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.GOLDEN_APPLE, 1, 1, "§bGold Apfel", false));
            }
        }

        /*
         * Buy Items: Tränke
         */

        //Schnellichkeit
        if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bSchnellichkeit")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT, 6, p, Material.POTION, 8194, 1, "§bSchnellichkeit", Sound.CHICKEN_EGG_POP);
            }
        }

        //Heilung Lv.1
        if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bHeilung Lv.1")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT, 8, p, Material.POTION, 8261, 1, "§bHeilung Lv.1", Sound.CHICKEN_EGG_POP);
            }
        }

        //Heilung Lv.2
        if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bHeilung Lv.2")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT, 12, p, Material.POTION, 8229, 1, "§bHeilung Lv.2", Sound.CHICKEN_EGG_POP);
            }
        }

        //Stärke
        if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§bStärke")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT, 8, p, Material.POTION, 8201, 1, "§bStärke", Sound.CHICKEN_EGG_POP);
            }
        }

        /*
         * Buy Items: Spezial
         */

        //Angel
        if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName() .equals( "§bAngel")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,8, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.FISHING_ROD, 1, 1, "§bAngel", false));
            }
        }

        //Warp Powder
        if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName() .equals( "§bWarp Powder")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,5, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.getMaterial(289), 1, 1, "§bWarp Powder", false));
            }
        }

        //Warp Powder
        if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName() .equals( "§bSchneebälle")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.IRON_INGOT,3, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.SNOW_BALL, 1, 1, "§bSchneebälle", false));
            }
        }

        //Rettungsplattform
        if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName() .equals( "§bRettungsplattform")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,3, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.BLAZE_ROD, 1, 1, "§bRettungsplattform", false));
            }
        }

        //Enderperl
        if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName() .equals( "§bEnderpearl")) {
                Shopbuy.removeInventoryItems(p.getInventory(), Material.GOLD_INGOT,12, p, Sound.CHICKEN_EGG_POP, ItemFactory.createItem(Material.ENDER_PEARL, 1, 1, "§bEnderpearl", false));
            }
        }
    }

    private static void removeInventoryItems(Inventory inv, Material type, int amount, Player p, Material additem, int subid, int anzahl, String name, Sound playsound) {
        for (ItemStack is : inv.getContents()) {
            if (is != null && is.getType() == type) {
                if (!(is.getAmount() >= amount)) {
                    p.sendMessage(Utils.prefix + "§cDu hast nicht genügen Ressourcen um dieses Item kaufen zu können!");
                    break;
                } else {
                    int newamount = is.getAmount() - amount;
                    if (newamount > 0) {
                        is.setAmount(newamount);
                        p.getInventory().addItem(Itemmanager.createItem(additem, subid, anzahl, name));
                        p.playSound(p.getLocation(), playsound, 1, 1);
                        break;
                    } else {
                        inv.remove(is);
                        amount = -newamount;
                        if (amount == 0)
                            break;
                    }
                }
            }
        }
    }

    private static void removeInventoryItems(Inventory inv, Material type, int amount, Player p, Sound playsound, ItemStack itemstack) {
        for (ItemStack is : inv.getContents()) {
            if (is != null && is.getType() == type) {
                if (!(is.getAmount() >= amount)) {
                    p.sendMessage(Utils.prefix + "§cDu hast nicht genügen Ressourcen um dieses Item kaufen zu können!");
                    break;
                } else {
                    int newamount = is.getAmount() - amount;
                    p.playSound(p.getLocation(), playsound, 1, 1);
                    p.getInventory().addItem(itemstack);
                    p.updateInventory();
                    if (newamount > 0) {
                        is.setAmount(newamount);
                        break;
                    } else {
                        inv.remove(is);
                        amount = -newamount;
                        if (amount == 0)
                            break;
                    }
                }
            }
        }
    }
}
