/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.gamevoting;

import eu.mcone.bedwars.api.Itemmanager;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.spawner.Spawner;
import eu.mcone.coresystem.bukkit.util.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class Ressourcevoting {

    public static void Votingevaluate() {
        if (Voting_utils.Gold.size() > Voting_utils.No_Gold.size() || Voting_utils.Gold.size() == Voting_utils.No_Gold.size()) {
            Voting_utils.ressource = Boolean.TRUE;

            bedwars.sh.startSpawner(Spawner.BRONZE);
            bedwars.sh.startSpawner(Spawner.IRON);
            bedwars.sh.startSpawner(Spawner.GOLD);

            System.out.println("Gold Thread: TRUE");

        } else if (Voting_utils.Gold.size() < Voting_utils.No_Gold.size()) {
            Voting_utils.ressource = Boolean.FALSE;

            bedwars.sh.startSpawner(Spawner.BRONZE);
            bedwars.sh.startSpawner(Spawner.IRON);

            System.out.println("Gold Thread: FALSE");
        } else {
            System.out.println("Valuate voting Error on Class RessourceVoting");
        }
    }

    public static void createRessourceVotingInv(Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, "§f§oRessource Voting");

        for (int i = 0; i <= 26; i++) {
            inv.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 0, 1, "§r", false));
        }

        /* Voting for Gold */
        int Ressource_yesgold = Voting_utils.Gold.size();
        inv.setItem(11, Itemmanager.CreateItemwithID(266, 0, 1, "§8» §6Gold", "", "§f§oSpieler §8» §7" + Ressource_yesgold, ""));

        /* Voting for No Gold */
        int Ressource_nogold = Voting_utils.No_Gold.size();
        inv.setItem(15, Itemmanager.CreateItemwithID(265, 0, 1, "§8» §7Kein §6Gold", "", "§f§oSpieler §8» §7" + Ressource_nogold, ""));

        inv.setItem(18, ItemFactory.createItem(Material.BARRIER, 0, 1, "§czurück", false));

        p.openInventory(inv);
    }

    public static void RegisterRessourceInventory(Player p, InventoryClickEvent e) {
        if (!(e.getCurrentItem() == null)) {
            if (e.getClickedInventory().getName().equals("§f§oRessource Voting")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §6Gold")) {
                    if (Voting_utils.Gold.containsKey(p.getUniqueId())) {
                        p.sendMessage(Utils.prefix + "§7Du hast bereits für Gold gevotet.");
                    } else {
                        if (Voting_utils.No_Gold.containsKey(p.getUniqueId())) {
                            Voting_utils.No_Gold.remove(p.getUniqueId(), 1);

                            int old_size = Voting_utils.Gold.size();
                            int new_size = old_size + 1;

                            UpdateInventory(e);
                            Voting_utils.Gold.put(p.getUniqueId(), new_size);

                            p.sendMessage(Utils.prefix + "§7Du hast für §6Gold §7gevotet");
                        } else {

                            int old_size = Voting_utils.Gold.size();
                            int new_size = old_size + 1;

                            Voting_utils.Gold.put(p.getUniqueId(), new_size);
                            UpdateInventory(e);

                            p.sendMessage(Utils.prefix + "§7Du hast für §6Gold §7gevotet");
                        }
                    }

                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Kein §6Gold")) {
                    if (Voting_utils.No_Gold.containsKey(p.getUniqueId())) {
                        p.sendMessage(Utils.prefix + "§7Du hast bereits für Kein Gold gevotet");
                    } else {
                        if (Voting_utils.Gold.containsKey(p.getUniqueId())) {
                            Voting_utils.Gold.remove(p.getUniqueId(), 1);

                            int old_size = Voting_utils.No_Gold.size();
                            int new_size = old_size + 1;

                            Voting_utils.No_Gold.put(p.getUniqueId(), new_size);
                            UpdateInventory(e);

                            p.sendMessage(Utils.prefix + "§7Du hast für §6Kein Gold §7gevotet");
                        } else {
                            int old_size = Voting_utils.No_Gold.size();
                            int new_size = old_size + 1;

                            Voting_utils.No_Gold.put(p.getUniqueId(), new_size);
                            UpdateInventory(e);

                            p.sendMessage(Utils.prefix + "§7Du hast für §6Kein Gold §7gevotet");
                        }
                    }
                }
            }
        }
    }

    private static void UpdateInventory(InventoryClickEvent e) {
        e.getClickedInventory().setItem(11, Itemmanager.CreateItemwithID(266, 0, 1, "§8» §6Gold", "", "§f§oSpieler §8» §7" + Voting_utils.Gold.size(), ""));
        e.getClickedInventory().setItem(15, Itemmanager.CreateItemwithID(265, 0, 1, "§8» §7Kein §6Gold", "", "§f§oSpieler §8» §7" + Voting_utils.No_Gold.size(), ""));

    }
}
