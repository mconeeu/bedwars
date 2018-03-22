/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.team;

import eu.mcone.bedwars.api.Title;
import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.gamevoting.Ressourcevoting;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.tempkits.Tempkits;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Teamlistener implements Listener {

    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (Gamestatehandler.getCurrentState() instanceof Lobbystate) {
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getItemMeta() != null) {
                    if (e.getInventory().getName().equals("§f§oRessource Voting")) {
                        e.setCancelled(true);
                    } else if (e.getInventory().getName().equals("§f§oWähle dein Team")) {
                        e.setCancelled(true);
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§3Blau")) {
                            if (Utils.blau.size() == 0) {

                                Teaminventory.SetTeam(e, "Blau");

                                p.sendMessage(Utils.prefix + "Du bist nun in Team §3Blau!");
                                Title.sendActionBar(p, Utils.prefix + "Du bist nun in Team §3Blau!");
                                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1, 1);
                                p.updateInventory();


                            } else if (Utils.blau.size() >= 1) {

                                p.sendMessage(Utils.prefix + "Dieses Team ist momentan Voll!");
                                Title.sendActionBar(p, Utils.prefix + "Dieses Team ist momentan Voll!");

                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, 1);

                                p.updateInventory();
                            } else {
                                System.out.println("Error in Class Team_Listener: team blue");
                            }

                        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cRot")) {
                            if (Utils.rot.size() == 0) {

                                Teaminventory.SetTeam(e, "Rot");

                                p.sendMessage(Utils.prefix + "Du bist nun in Team §cRot!");
                                Title.sendActionBar(p, Utils.prefix + "Du bist nun in Team §cRot!");

                                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1, 1);

                                p.updateInventory();

                            } else if (Utils.rot.size() >= 1) {

                                p.sendMessage(Utils.prefix + "Dieses Team ist momentan Voll!");
                                Title.sendActionBar(p, Utils.prefix + "Dieses Team ist momentan Voll!");

                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, 1);

                                p.updateInventory();
                            } else {
                                System.out.println("Error in Class Team_Listener: team red");
                            }
                        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§eGelb")) {
                            if (Utils.gelb.size() == 0) {

                                Teaminventory.SetTeam(e, "Gelb");

                                p.sendMessage(Utils.prefix + "Du bist nun in Team §eGelb!");
                                Title.sendActionBar(p, Utils.prefix + "Du bist nun in Team §eGelb!");

                                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1, 1);

                            } else if (Utils.gelb.size() >= 1) {

                                p.sendMessage(Utils.prefix + "Dieses Team ist momentan Voll!");
                                Title.sendActionBar(p, Utils.prefix + "Dieses Team ist momentan Voll!");
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, 1);

                                p.updateInventory();
                            } else {
                                System.out.println("Error in Class Team_Listener: team yellow");
                            }
                        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§5Lila")) {
                            if (Utils.Lila.size() == 0) {

                                Teaminventory.SetTeam(e, "Lila");

                                p.sendMessage(Utils.prefix + "Du bist nun in Team §5Lila!");

                                Title.sendActionBar(p, Utils.prefix + "Du bist nun in Team §5Lila!");
                                p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1, 1);

                                p.updateInventory();


                            } else if (Utils.Lila.size() >= 1) {

                                p.sendMessage(Utils.prefix + "Dieses Team ist momentan Voll!");
                                Title.sendActionBar(p, Utils.prefix + "Dieses Team ist momentan Voll!");
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1, 1);

                                p.updateInventory();
                            } else {
                                System.out.println("Error in Class Team_Listener: team purple");
                            }
                        }
                    } else if (e.getInventory().getName().equals("§f§oAchievements")) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}
