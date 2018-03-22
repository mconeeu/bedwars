/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */


package eu.mcone.bedwars.achievements;


import eu.mcone.bedwars.api.Itemmanager;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.util.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class Achievements {

    /* Achievement List */
    //Fair-Play, Schreibe nach einer Runde 'GG' in den Chat! (15 Coins) Fertig
    //Builder, Baue 350 Blöcke in einer Runde (15 Coins) Fertig
    //In die Lüfte, Baue dich bis zur Welt-Granze in die Luft! (15 Coins) Fertig
    //Gnadenloser Killer, Bringe 50 Spieler in einem Spiel um! (50 Coins) Fertig
    //Der Gewinner, Gewinne dein erstes Spiel! (25 Coins) Fertig

    //Erster Kill, Bringe einen Spieler als erstest um! (15 Coins)
    //TheTwinsterMode, Baue alle Betten in einem Spiel ab! (100 Coins) Fertig
    //Rusher, Baue als erster in der Runde ein Bett ab! (50 Coins) Fertig
    //Erster Tote, Sterbe zum ersten mal! (15 Coins) Fertig

    public static HashMap<Player, Integer> gebaut = new HashMap<>();
    public static HashMap<Player, Integer> betten = new HashMap<>();
    public static HashMap<Player, Integer> gekillt = new HashMap<>();
    public static HashMap<Player, Integer> cantBreakBlocks = new HashMap<>();
    public static HashMap<Player, Integer> EnderPearls = new HashMap<>();


    public static void CreateTableAchievements() {
        CoreSystem.mysql1.update("CREATE TABLE IF NOT EXISTS `bedwars-achievements` (`id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, `uuid` varchar(100), `achievements` varchar(100) NOT NULL, `coins` int(100) NOT NULL, `timestamp` varchar(255) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
    }

    private static boolean getAchievements(UUID uuid, String achievement) {
        CoreSystem.mysql1.select("SELECT * FROM `bedwars-achievements` WHERE uuid ='" + uuid + "' AND achievements ='" + achievement + "'", rs -> {
            try {

                if (rs.next()) {
                    return rs.getString("achievements") != null;
                }

                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        });
        return false;
    }

    public static void insertAchievement(UUID uuid, Player p, String achievement, String AchievementMessage, int coins, long timestamp) {
        if (getAchievements(uuid, achievement)) {
        } else {
            CoreSystem.mysql1.update("INSERT INTO `bedwars-achievements` (id, uuid, achievements, coins, timestamp) VALUES (NULL, '" + p.getUniqueId() + "', '" + achievement + "', '" + coins + "', '" + timestamp + "')");

            p.sendMessage("");
            p.sendMessage("§7§l§ksdfghjklqqwertzuioyxcmvnblgjdaiwjskadadfe");
            p.sendMessage(Utils.prefix + "§7Achievement §c" + achievement);
            p.sendMessage(Utils.prefix + "§7" + AchievementMessage);
            p.sendMessage(Utils.prefix + "§7Coins: §c" + coins);
            p.sendMessage("§7§l§ksdfghjklqqwertzuioyxcmvnblgjdaiwjskadadfe");
            p.sendMessage("");

            bedwars.coinsapi.addCoins(p.getUniqueId(), coins);
        }
    }

    public static void CreateAchievementsInv(Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, "§f§oAchievements");

        for (int i = 0; i <= 26; i++) {
            inv.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 0, 1, "§r", false));
        }

        if (getAchievements(p.getUniqueId(), "Fair-Play")) {
            inv.setItem(0, Itemmanager.CreateItemwithID(351, 10, 1, "§aFair-Play", "§aFreigeschalten", "§7Schreibe nach einer Runde 'GG' in den Chat!", "§715 Coins"));
        } else {
            inv.setItem(0, Itemmanager.CreateItemwithID(351, 8, 1, "§cFair-Play", "§cNicht Freigeschalten", "§7Schreibe nach einer Runde 'GG' in den Chat!", "§715 Coins"));
        }

        if (getAchievements(p.getUniqueId(), "Builder")) {
            inv.setItem(1, Itemmanager.CreateItemwithID(351, 10, 1, "§aBuilder", "§aFreigeschalten", "§7Baue 350 Blöcke in einer Runde", "§715 Coins"));
        } else {
            inv.setItem(1, Itemmanager.CreateItemwithID(351, 8, 1, "§cBuilder", "§cNicht Freigeschalten", "§7Baue 350 Blöcke in einer Runde", "§715 Coins"));
        }

        if (getAchievements(p.getUniqueId(), "In die Lüfte")) {
            inv.setItem(2, Itemmanager.CreateItemwithID(351, 10, 1, "§aIn die Lüfte", "§aFreigeschalten", "§7Baue dich bis zur Welt-Granze in die Luft!", "§715 Coins"));
        } else {
            inv.setItem(2, Itemmanager.CreateItemwithID(351, 8, 1, "§cIn die Lüfte", "§cNicht Freigeschalten", "§7Baue dich bis zur Welt-Granze in die Luft!", "§715 Coins"));
        }

        if (getAchievements(p.getUniqueId(), "Gnadenloser Killer")) {
            inv.setItem(3, Itemmanager.CreateItemwithID(351, 10, 1, "§aGnadenloser Killer", "§aFreigeschalten", "§7Bringe 50 Spieler in einem Spiel um!", "§750 Coins"));
        } else {
            inv.setItem(3, Itemmanager.CreateItemwithID(351, 8, 1, "§cGnadenloser Killer", "§cNicht Freigeschalten", "§7Bringe 50 Spieler in einem Spiel um!", "§750 Coins"));
        }

        if (getAchievements(p.getUniqueId(), "Erster Kill")) {
            inv.setItem(4, Itemmanager.CreateItemwithID(351, 10, 1, "§aErster Kill", "§aFreigeschalten", "§7Bringe einen Spieler als erstest um!", "§715 Coins"));
        } else {
            inv.setItem(4, Itemmanager.CreateItemwithID(351, 8, 1, "§cErster Kill", "§cNicht Freigeschalten", "§7Bringe einen Spieler als erstest um!", "§715 Coins"));
        }

        if (getAchievements(p.getUniqueId(), "TheTwinsterMode")) {
            inv.setItem(5, Itemmanager.CreateItemwithID(351, 10, 1, "§aTheTwinsterMode", "§aFreigeschalten", "§7Baue alle Betten in einem Spiel ab!", "§7100 Coins"));
        } else {
            inv.setItem(5, Itemmanager.CreateItemwithID(351, 8, 1, "§cTheTwinsterMode", "§cNicht Freigeschalten", "§7Baue alle Betten in einem Spiel ab!", "§7100 Coins"));
        }

        if (getAchievements(p.getUniqueId(), "Der Gewinner")) {
            inv.setItem(6, Itemmanager.CreateItemwithID(351, 10, 1, "§aDer Gewinner", "§aFreigeschalten", "§7Gewinne dein erstes Spiel!", "§725 Coins"));
        } else {
            inv.setItem(6, Itemmanager.CreateItemwithID(351, 8, 1, "§cDer Gewinner", "§cNicht Freigeschalten", "§7Gewinne dein erstes Spiel!", "§725 Coins"));
        }

        if (getAchievements(p.getUniqueId(), "Rusher")) {
            inv.setItem(7, Itemmanager.CreateItemwithID(351, 10, 1, "§aRusher", "§aFreigeschalten", "§7Baue als erster in der Runde ein Bett ab!", "§750 Coins"));
        } else {
            inv.setItem(7, Itemmanager.CreateItemwithID(351, 8, 1, "§cRusher", "§cNicht Freigeschalten", "§7Baue als erster in der Runde ein Bett ab!", "§750 Coins"));
        }

        if (getAchievements(p.getUniqueId(), "Erster Tote")) {
            inv.setItem(8, Itemmanager.CreateItemwithID(351, 10, 1, "§aErster Tote", "§aFreigeschalten", "§7Sterbe zum ersten mal!", "§715 Coins"));
        } else {
            inv.setItem(8, Itemmanager.CreateItemwithID(351, 8, 1, "§cErster Tote", "§cNicht Freigeschalten", "§7Sterbe zum ersten mal!", "§715 Coins"));
        }

        p.openInventory(inv);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
    }
}
