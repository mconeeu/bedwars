/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.gamevoting.Voting_utils;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.team.Teaminventory;
import eu.mcone.bedwars.tempkits.Tempkits;
import eu.mcone.bedwars.achievements.Achievements;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void PlayerInteract(org.bukkit.event.player.PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getItem() != null) {
            if (e.getItem().getType().equals(Material.BED)) {
                Teaminventory.openInventory(p);
                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
            } else if (e.getItem().getType().equals(Material.BLAZE_POWDER)) {
                p.performCommand("start");
            } else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || (e.getAction().equals(Action.RIGHT_CLICK_AIR))) {
                if (e.getItem().getType().equals(Material.SLIME_BALL)) {
                    if (p.getItemInHand().getItemMeta().getDisplayName().equals("§f§oLobby")) {
                        ByteArrayOutputStream b = new ByteArrayOutputStream();
                        DataOutputStream out = new DataOutputStream(b);

                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("Lobby-1");
                        } catch (IOException ex) {
                            p.sendMessage(Utils.prefix + "§7Die Lobby konnte §cnicht §7erreicht werden...  §c(Melde dies Bitte einen Admin oder Developer => TwinsterHD)");
                        }

                        p.sendMessage(Utils.prefix + "§7Du wirst zur Lobby verbunden....");
                        p.sendPluginMessage(bedwars.getPlugin(), "BungeeCord", b.toByteArray());
                    }
                } else if (e.getItem().getType().equals(Material.NETHER_STAR)) {
                    if (p.getItemInHand().getItemMeta().getDisplayName().equals("§f§oAchievements")) {
                        Achievements.CreateAchievementsInv(p);
                    }
                } else if (e.getItem().getType().equals(Material.CHEST)) {
                    if (p.getItemInHand().getItemMeta().getDisplayName().equals("§f§oTemp-Kits")) {
                        Tempkits.createkitinv(p);
                    }
                } else if (e.getItem().getType().equals(Material.BOOK)) {
                    if (p.getItemInHand().getItemMeta().getDisplayName().equals("§f§oVoting")) {
                        Voting_utils.Createvotinginv(p);
                    }
                }
            }
        }

        try {
            if(e.getClickedBlock() != null){
                if (e.getClickedBlock().getType().equals(Material.STAINED_GLASS)) {
                    if (Utils.SetBedBlau.contains(p.getName())) {
                        p.sendMessage(Utils.prefix + "§7Du hast die §fBett Location §7von Team §3Blau §7gesetzt!");

                        Factory.createConfigLocation(e.getClickedBlock().getLocation(), "Teambed.Blau", Utils.CfgBed, Utils.yCfgBed);
                        saveConfig();
                    } else if (Utils.SetBedRot.contains(p.getName())) {
                        p.sendMessage(Utils.prefix + "§7Du hast die §fBett Location §7von Team §cRot §7gesetzt!");

                        Factory.createConfigLocation(e.getClickedBlock().getLocation(), "Teambed.Rot", Utils.CfgBed, Utils.yCfgBed);
                        saveConfig();

                    } else if (Utils.SetBedGelb.contains(p.getName())) {
                        p.sendMessage(Utils.prefix + "§7Du hast die §fBett Location §7von Team §eGelb §7gesetzt!");

                        Factory.createConfigLocation(e.getClickedBlock().getLocation(), "Teambed.Gelb", Utils.CfgBed, Utils.yCfgBed);
                        saveConfig();

                    } else if (Utils.SetBedLila.contains(p.getName())) {
                        p.sendMessage(Utils.prefix + "§7Du hast die §fBett Location §7von Team §5Lila §7gesetzt!");

                        Factory.createConfigLocation(e.getClickedBlock().getLocation(), "Teambed.Lila", Utils.CfgBed, Utils.yCfgBed);
                        saveConfig();
                    }
                }
            }
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }
    }

    private void saveConfig(){
        try {
            Utils.yCfgBed.save(Utils.CfgBed);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
