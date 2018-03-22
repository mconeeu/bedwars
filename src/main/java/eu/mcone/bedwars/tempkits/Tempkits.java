/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.tempkits;

import eu.mcone.coresystem.bukkit.api.*;
import java.util.*;

import eu.mcone.coresystem.bukkit.util.ItemFactory;
import org.bukkit.entity.*;
import org.bukkit.event.inventory.*;
import org.bukkit.*;
import eu.mcone.bedwars.api.*;
import org.bukkit.enchantments.*;
import org.bukkit.inventory.*;

public class Tempkits
{
    private static CoinsAPI coinsAPI;
    public static ArrayList<Player> kit_rusher = new ArrayList<>();
    public static ArrayList<Player> kit_builder = new ArrayList<>();
    public static ArrayList<Player> kit_knock = new ArrayList<>();
    public static ArrayList<Player> kit_mlg = new ArrayList<>();

    public static void kitinventoryinteract(final Player p, final InventoryClickEvent e) {
        if (e.getInventory().getName().equals("§f§oTemp-Kits")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lKit Rusher")) {
                if (Tempkits.kit_builder.contains(p) || Tempkits.kit_knock.contains(p) || Tempkits.kit_mlg.contains(p)) {
                    p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast dir bereits ein Kit f\u00fcr diese Runde gekauft!");
                    p.closeInventory();
                } else if (Tempkits.kit_rusher.contains(p)) {
                    p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast bereits dieses Kit gekauft");
                    p.closeInventory();
                } else {
                    if (CoinsAPI.getCoins(p.getUniqueId()) >= 50) {
                        CoinsAPI.removeCoins(p.getUniqueId(), 50);
                        Tempkits.kit_rusher.add(p);
                        p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§7Du hast dir das §c§lKit Rusher §7einmalig f\u00fcr diese Runde gekauft");
                        p.closeInventory();
                    }
                    else {
                        p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast nicht gen\u00fcgend Coins um dir das Kit zu kaufen!");
                        p.closeInventory();
                    }
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§e§lKit Builder")) {
                if (Tempkits.kit_rusher.contains(p) || Tempkits.kit_knock.contains(p) || Tempkits.kit_mlg.contains(p)) {
                    p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast dir bereits ein Kit f\u00fcr diese Runde gekauft!");
                    p.closeInventory();
                } else if (Tempkits.kit_builder.contains(p)) {
                    p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast bereits dieses Kit gekauft");
                    p.closeInventory();
                } else {
                    if (CoinsAPI.getCoins(p.getUniqueId()) >= 15) {
                        CoinsAPI.removeCoins(p.getUniqueId(), 15);
                        Tempkits.kit_builder.add(p);
                        p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§7Du hast dir das §e§lKit Builder §7einmalig für diese Runde gekauft");
                        p.closeInventory();
                    }
                    else {
                        p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast nicht genügend Coins um dir das Kit zu kaufen!");
                        p.closeInventory();
                    }
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5§lKit Knock")) {
                if (Tempkits.kit_builder.contains(p) || Tempkits.kit_rusher.contains(p) || Tempkits.kit_mlg.contains(p)) {
                    p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast dir bereits ein Kit für diese Runde gekauft!");
                    p.closeInventory();
                } else if (Tempkits.kit_knock.contains(p)) {
                    p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast bereits dieses Kit gekauft");
                    p.closeInventory();
                } else {
                    if (CoinsAPI.getCoins(p.getUniqueId()) >= 50) {
                        CoinsAPI.removeCoins(p.getUniqueId(), 50);
                        Tempkits.kit_knock.add(p);
                        p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§7Du hast dir das §5§lKit Knock §7einmalig für diese Runde gekauft");
                        p.closeInventory();
                    }
                    else {
                        p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast nicht genügend Coins um dir das Kit zu kaufen!");
                        p.closeInventory();
                    }
                }
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§f§lKit Mlg")) {
                if (Tempkits.kit_builder.contains(p) || Tempkits.kit_rusher.contains(p) || Tempkits.kit_rusher.contains(p)) {
                    p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast dir bereits ein Kit für diese Runde gekauft!");
                    p.closeInventory();
                }
                else if (Tempkits.kit_mlg.contains(p)) {
                    p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast bereits dieses Kit gekauft");
                    p.closeInventory();
                } else {
                    if (CoinsAPI.getCoins(p.getUniqueId()) >= 50) {
                        CoinsAPI.removeCoins(p.getUniqueId(), 50);
                        Tempkits.kit_mlg.add(p);
                        p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§7Du hast dir das §f§lKit Mlg §7einmalig für diese Runde gekauft");
                        p.closeInventory();
                    } else {
                        p.sendMessage("§8[§7§l!§8] §cBedwars §8» §7§cDu hast nicht genügend Coins um dir das Kit zu kaufen!");
                        p.closeInventory();
                    }
                }
            }
        }
    }

    public static void createkitinv(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§f§oTemp-Kits");
        for (int i = 0; i <= 26; ++i) {
            inv.setItem(i, Itemmanager.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 0, 1, "§r", null));
        }
        if (Tempkits.kit_rusher.contains(p)) {
            inv.setItem(10, Itemmanager.CreateItemwithID(351, 10, 1, "§c§lKit Rusher", "§aGekauft", "§7Items: §e16 Blöcke, 1 Spitzhacke, 1 Knockback Stick Lv.1", "§7Kosten §a50 Coins"));
            inv.setItem(12, Itemmanager.CreateItemwithID(166, 0, 1, "§e§lKit Builder", "", "§7Du hast dir bereits Das Kit §c§lRusher §7gekauft", ""));
            inv.setItem(14, Itemmanager.CreateItemwithID(166, 0, 1, "§5§lKit Knock", "", "§7Du hast dir bereits Das Kit §c§lRusher §7gekauft", ""));
            inv.setItem(16, Itemmanager.CreateItemwithID(166, 0, 1, "§f§lKit Mlg", "", "§7Du hast dir bereits Das Kit §c§lRusher §7gekauft", ""));
            p.openInventory(inv);
            return;
        }
        inv.setItem(10, Itemmanager.CreateItemwithID(351, 8, 1, "§c§lKit Rusher", "§cNicht Gekauft", "§7Items: §e16 Blöcke, 1 Spitzhacke, 1 Knockback Stick Lv.1", "§7Kosten §c50 Coins"));
        if (Tempkits.kit_builder.contains(p)) {
            inv.setItem(10, Itemmanager.CreateItemwithID(166, 0, 1, "§c§lKit Rusher", "", "§7Du hast dir bereits Das Kit §e§lBuilder §7gekauft", ""));
            inv.setItem(12, Itemmanager.CreateItemwithID(351, 10, 1, "§e§lKit Builder", "§aGekauft", "§7Items: §e32 Blöcke, 1 Spitzhacke", "§7Kosten §a15 Coins"));
            inv.setItem(14, Itemmanager.CreateItemwithID(166, 0, 1, "§5§lKit Knock", "", "§7Du hast dir bereits Das Kit §e§lBuilder §7gekauft", ""));
            inv.setItem(16, Itemmanager.CreateItemwithID(166, 0, 1, "§f§lKit Mlg", "", "§7Du hast dir bereits Das Kit §e§lBuilder §7gekauft", ""));
            p.openInventory(inv);
            return;
        }
        inv.setItem(12, Itemmanager.CreateItemwithID(351, 8, 1, "§e§lKit Builder", "§cNicht Gekauft", "§7Items: §e32 Blöcke, 1 Spitzhacke", "§7Kosten §c15 Coins"));
        if (Tempkits.kit_knock.contains(p)) {
            inv.setItem(10, Itemmanager.CreateItemwithID(166, 0, 1, "§c§lKit Rusher", "", "§7Du hast dir bereits Das Kit §5§lKnock §7gekauft", ""));
            inv.setItem(12, Itemmanager.CreateItemwithID(166, 0, 1, "§e§lKit Builder", "", "§7Du hast dir bereits Das Kit §5§lKnock §7gekauft", ""));
            inv.setItem(14, Itemmanager.CreateItemwithID(351, 10, 1, "§5§lKit Knock", "§aGekauft", "§7Items: §e1 Knockback Stick Lv.2", "§7Kosten §a50 Coins"));
            inv.setItem(16, Itemmanager.CreateItemwithID(166, 0, 1, "§f§lKit Mlg", "", "§7Du hast dir bereits Das Kit §5§lKnock §7gekauft", ""));
            p.openInventory(inv);
            return;
        }
        inv.setItem(14, Itemmanager.CreateItemwithID(351, 8, 1, "§5§lKit Knock", "§cNicht Gekauft", "§7Items: §e1 Knockback Stick Lv.2", "§7Kosten §c50 Coins"));
        if (Tempkits.kit_mlg.contains(p)) {
            inv.setItem(10, Itemmanager.CreateItemwithID(166, 0, 1, "§c§lKit Rusher", "", "§7Du hast dir bereits Das Kit §f§lMlg §7gekauft", ""));
            inv.setItem(12, Itemmanager.CreateItemwithID(166, 0, 1, "§e§lKit Builder", "", "§7Du hast dir bereits Das Kit §f§lMlg §7gekauft", ""));
            inv.setItem(14, Itemmanager.CreateItemwithID(166, 0, 1, "§5§lKit Knock", "", "§7Du hast dir bereits Das Kit §f§lMlg §7gekauft", ""));
            inv.setItem(16, Itemmanager.CreateItemwithID(351, 10, 1, "§f§lKit Mlg", "§aGekauft", "§7Items: §e16 Blöcke, 16 Cobwebs, 1 Knockback Stick Lv.1", "§7Kosten §a50 Coins"));
            p.openInventory(inv);
            return;
        }
        inv.setItem(16, Itemmanager.CreateItemwithID(351, 8, 1, "§f§lKit Mlg", "§cNicht Gekauft", "§7Items: §e16 Blöcke, 16 Cobwebs, 1 Knockback Stick Lv.1", "§7Kosten §c50 Coins"));
        p.openInventory(inv);
    }

    public static void setkit(final Player p) {
        if (Tempkits.kit_rusher.contains(p)) {
            p.getInventory().clear();

            p.getInventory().addItem(ItemFactory.createItem(Material.SANDSTONE, 0, 16, "§eBlöcke", false));
            p.getInventory().addItem(ItemFactory.createEnchantedItem(Material.WOOD_PICKAXE, Enchantment.DURABILITY, 1,0, 0, "§eSpitzhacke", false));
            p.getInventory().addItem(ItemFactory.createEnchantedItem(Material.STICK, Enchantment.KNOCKBACK, 1,0, 0, "§eKnockbackStick", false));
            p.updateInventory();
        }
        else if (Tempkits.kit_builder.contains(p)) {
            p.getInventory().clear();

            p.getInventory().addItem(ItemFactory.createItem(Material.SANDSTONE, 0, 32, "§eBlöcke", false));
            p.getInventory().addItem(ItemFactory.createEnchantedItem(Material.WOOD_PICKAXE, Enchantment.DURABILITY, 1,0, 0, "§eSpitzhacke", false));
            p.updateInventory();
        }
        else if (Tempkits.kit_knock.contains(p)) {
            p.getInventory().addItem(ItemFactory.createEnchantedItem(Material.STICK, Enchantment.KNOCKBACK, 2,0, 0, "§eKnockbackStick", false));
            p.updateInventory();
        }
        else if (Tempkits.kit_mlg.contains(p)) {
            p.getInventory().clear();

            p.getInventory().addItem(ItemFactory.createEnchantedItem(Material.STICK, Enchantment.KNOCKBACK, 1,0, 0, "§eKnockbackStick", false));
            p.getInventory().addItem(ItemFactory.createItem(Material.SANDSTONE, 0, 16, "§eBlöcke", false));
            p.getInventory().addItem(ItemFactory.createItem(Material.WEB, 0, 16, "§eCobwebs", false));
            p.updateInventory();
        }
    }
}