/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.listener.Objective;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.achievements.Achievements;
import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.api.StatsAPI;
import eu.mcone.coresystem.lib.gamemode.Gamemode;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scoreboard.DisplaySlot;

import java.util.ArrayList;
import java.util.UUID;

public class BlockBreakListener implements Listener {

    private static ArrayList<Integer> betten = new ArrayList<>();
    private StatsAPI stats = new StatsAPI(Gamemode.BEDWARS, CoreSystem.mysql2);

    @EventHandler
    public void BlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block b = e.getBlock();

        if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {
            if (Utils.acceptedBlocks.contains(b)) {
                    e.setCancelled(false);
            } else {
                e.setCancelled(true);
            }

            if (b.getType().equals(Material.STAINED_GLASS)) {
                if (e.getBlock().getLocation().equals(Factory.getConfigLocation("Teambed.Blau", Utils.yCfgBed))) {

                    if (!Utils.canRespawnBlau) {
                        p.sendMessage(Utils.prefix + "§cDiese Bett wurde bereits abgebaut");
                        e.setCancelled(true);
                    } else if (Utils.spectating.contains(p)) {
                        p.sendMessage(Utils.prefix + "§cDu kannst dieses Bett nicht abauen, da du ein Spectator bist");
                        e.setCancelled(true);
                    } else {
                        if (Utils.blau.contains(p.getUniqueId())) {
                            e.setCancelled(true);
                            p.sendMessage(Utils.prefix + "§7Du kannst dein eigenes Bett nicht abgebaut!");
                        } else {
                            Utils.canRespawnBlau = false;

                            stats.addGoal(p.getUniqueId(), 1);

                            /* Add killed bed for the Game */
                            betten.add(betten.size() + 1);

                            /* Check if the Player is in the Hasmap */
                            isInHasMap(p, 1);

                            /* Check the killed bed's */
                            getBett(p.getUniqueId(), p);

                            p.sendMessage(Utils.prefix + "§7Du hast das Bett von Team §3Blau §7abgebaut");

                            for (Player all : Utils.blauchat) {
                                all.sendMessage(Utils.prefix + "§cDEIN Bett wurde abgebaut");
                            }

                            for (Player all : Utils.playing) {
                                CoreSystem.getCorePlayer(all).getScoreboard().setNewObjective(new Objective());
                                all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 10);
                                e.getBlock().getDrops().clear();
                                all.sendMessage(Utils.prefix + "§7Das Bett von Team §3Blau §7wurde von §c" + p.getName() + " §7abgebaut!");
                            }
                        }
                    }

                } else if (e.getBlock().getLocation().equals(Factory.getConfigLocation("Teambed.Rot", Utils.yCfgBed))) {

                    if (!Utils.canRespawnRot) {
                        p.sendMessage(Utils.prefix + "§cDiese Bett wurde bereits abgebaut");
                        e.setCancelled(true);
                    } else if (Utils.spectating.contains(p)) {
                        p.sendMessage(Utils.prefix + "§cDu kannst dieses Bett nicht abauen, da du ein Spectator bist");
                        e.setCancelled(true);
                    } else {
                        if (Utils.rot.contains(p.getUniqueId())) {

                            p.sendMessage(Utils.prefix + "§7Du kannst dein eigenes Bett nicht abbauen!");
                            e.setCancelled(true);
                        } else {
                            Utils.canRespawnRot = false;

                            stats.addGoal(p.getUniqueId(), 1);

                            /* Add killed bed for the Game */
                            betten.add(betten.size() + 1);

                            /* Check if the Player is in the Hasmap */
                            isInHasMap(p, 1);

                            /* Check the killed bed's */
                            getBett(p.getUniqueId(), p);

                            p.sendMessage(Utils.prefix + "§7Du hast das Bett von Team §cRot §7abgebaut");

                            for (Player all : Utils.rotchat) {
                                all.sendMessage(Utils.prefix + "§cDEIN Bett wurde abgebaut");
                            }

                            for (Player all : Utils.playing) {
                                CoreSystem.getCorePlayer(p).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                                all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 10);
                                e.getBlock().getDrops().clear();
                                all.sendMessage(Utils.prefix + "§7Das Bett von Team §cRot §7wurde von §c" + p.getName() + " §7abgebaut!");
                            }
                        }
                    }

                } else if (e.getBlock().getLocation().equals(Factory.getConfigLocation("Teambed.Gelb", Utils.yCfgBed))) {

                    if (!Utils.canRespawnGelb) {
                        p.sendMessage(Utils.prefix + "§cDiese Bett wurde bereits abgebaut");
                        e.setCancelled(true);
                    } else if (Utils.spectating.contains(p)) {
                        p.sendMessage(Utils.prefix + "§cDu kannst dieses Bett nicht abauen, da du ein Spectator bist");
                        e.setCancelled(true);
                    } else {
                        if (Utils.gelb.contains(p.getUniqueId())) {

                            p.sendMessage(Utils.prefix + "§7Du kannst dein eigenes Bett nicht abbauen!");
                            e.setCancelled(true);
                        } else {
                            Utils.canRespawnGelb = false;

                            stats.addGoal(p.getUniqueId(), 1);

                            /* Add killed bed for the Game */
                            betten.add(betten.size() + 1);

                            /* Check if the Player is in the Hasmap */
                            isInHasMap(p, 1);

                            /* Check the killed bed's */
                            getBett(p.getUniqueId(), p);

                            p.sendMessage(Utils.prefix + "§7Du hast das Bett von Team §eGelb §7abgebaut");

                            for (Player all : Utils.gelbchat) {
                                all.sendMessage(Utils.prefix + "§cDEIN Bett wurde abgebaut");
                            }

                            for (Player all : Utils.playing) {
                                CoreSystem.getCorePlayer(p).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                                all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 10);
                                e.getBlock().getDrops().clear();
                                all.sendMessage(Utils.prefix + "§7Das Bett von Team §eGelb §7wurde von §c" + p.getName() + " §7abgebaut!");
                            }
                        }
                    }

                } else if (e.getBlock().getLocation().equals(Factory.getConfigLocation("Teambed.Lila", Utils.yCfgBed))) {

                    if (!Utils.canRespawnLila) {
                        p.sendMessage(Utils.prefix + "§cDiese Bett wurde bereits abgebaut");
                        e.setCancelled(true);
                    } else if (Utils.spectating.contains(p)) {
                        p.sendMessage(Utils.prefix + "§cDu kannst dieses Bett nicht abauen, da du ein Spectator bist");
                        e.setCancelled(true);
                    } else {
                        if (Utils.Lila.contains(p.getUniqueId())) {
                            p.sendMessage(Utils.prefix + "§7Du kannst dein eigenes Bett nicht abbauen!");
                            e.setCancelled(true);
                        } else {
                            Utils.canRespawnLila = false;

                            stats.addGoal(p.getUniqueId(), 1);

                            /* Add killed bed for the Game */
                            betten.add(betten.size() + 1);

                            /* Check if the Player is in the Hasmap */
                            isInHasMap(p, 1);

                            /* Check the killed bed's */
                            getBett(p.getUniqueId(), p);

                            p.sendMessage(Utils.prefix + "§7Du hast das Bett von Team §5Lila §7abgebaut");

                            for (Player all : Utils.Lilachat) {
                                all.sendMessage(Utils.prefix + "§cDEIN Bett wurde abgebaut");
                            }

                            for (Player all : Utils.playing) {
                                CoreSystem.getCorePlayer(p).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                                all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 10);
                                e.getBlock().getDrops().clear();
                                all.sendMessage(Utils.prefix + "§7Das Bett von Team §5Lila §7wurde von §c" + p.getName() + " §7abgebaut!");
                            }
                        }
                    }
                } else {
                    p.sendMessage(Utils.prefix + "§cDie Bett Location konnte nicht gefunden werden, bitte melde dies einem MCONE Teamitglied");
                }

            }
        }
    }

    private static boolean isInHasMap(Player p, int anzahl) {
        if (Achievements.betten.get(p) == null) {
            Achievements.betten.put(p, anzahl);
            return false;
        } else {
            Achievements.betten.put(p, Achievements.betten.get(p) + anzahl);
            return true;
        }
    }

    private static void getBett(UUID uuid, Player p) {

        if (betten.size() == 1 && Achievements.betten.get(p) == 1) {
            long timestamp = System.currentTimeMillis() / 1000;
            Achievements.betten.put(p, +1);
            Achievements.insertAchievement(uuid, p, "Rusher", "Baue als erster in der Runde ein Bett ab!", 50, timestamp);
        } else {
            if (betten.size() == 3 && Achievements.betten.get(p) == 3) {
                long timestamp = System.currentTimeMillis() / 1000;
                Achievements.insertAchievement(uuid, p, "TheTwinsterMode", "Baue alle Betten in einem Spiel ab!", 100, timestamp);
            }
        }
    }

    @EventHandler
    public void BlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (e.getBlock().getType() == Material.HARD_CLAY || e.getBlock().getType() == Material.ENDER_STONE || e.getBlock().getType() == Material.GLOWSTONE || e.getBlock().getType() == Material.IRON_BLOCK || e.getBlock().getType() == Material.GLASS || e.getBlock().getType() == Material.TNT || e.getBlock().getType() == Material.CHEST || e.getBlock().getType() == Material.ENDER_CHEST || e.getBlock().getType() == Material.SANDSTONE || p.getGameMode() == GameMode.CREATIVE) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
}
