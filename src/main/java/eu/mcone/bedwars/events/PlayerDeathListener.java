/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.api.Title;
import eu.mcone.bedwars.gamestate.Gamestate;
import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.tempkits.Tempkits;
import eu.mcone.bedwars.achievements.Achievements;
import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.api.StatsAPI;
import eu.mcone.coresystem.lib.gamemode.Gamemode;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.DisplaySlot;

import java.util.ArrayList;
import java.util.UUID;

public class PlayerDeathListener implements Listener {

    private static ArrayList<Integer> roundkills = new ArrayList<>();
    private StatsAPI stats = new StatsAPI(Gamemode.BEDWARS, CoreSystem.mysql2);

    @SuppressWarnings("unlikely-arg-type")

    @EventHandler
    public void PlayerDeath(org.bukkit.event.entity.PlayerDeathEvent e) {
        Player victim = e.getEntity().getPlayer();
        Entity killerEN = e.getEntity().getPlayer().getKiller();
        Player killer = (Player) killerEN;

        e.setDeathMessage(null);

        if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {

            /* Has bed or has no Bed */
            if (!(Utils.spectating.contains(victim.getName()))) {
                if (Utils.rot.contains(victim.getUniqueId())) {
                    if (Utils.canRespawnRot) {
                        stats.addDeaths(victim.getUniqueId(), 1);

                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(victim.getUniqueId(), victim, "Erster Tote", "Sterbe zum ersten mal!", 15, timestamp);

                        victim.getInventory().clear();
                        victim.getInventory().setHelmet(null);
                        victim.getInventory().setChestplate(null);
                        victim.getInventory().setLeggings(null);
                        victim.getInventory().setBoots(null);
                        victim.setLevel(1);
                        victim.getActivePotionEffects().clear();
                        victim.setFoodLevel(20);
                        victim.spigot().respawn();

                        /* Clear all drops from the Player */
                        e.getDrops().clear();

                        /* Set the Kit for the Player */
                        Tempkits.setkit(victim);

                        /* Send the Death message */
                        for (Player all : Utils.playing) all.sendMessage(Utils.getKillmessage(killer, victim));

                        if (killer != null) {
                            /* Check if the Player is in the Hasmap */
                            isInHasmap(killer);

                            /* Add the new Round kill */
                            roundkills.add(roundkills.size() + 1);

                            /* Check the Achievement */
                            getKills(killer, killer.getUniqueId());

                            /* Check if is the First kill for the Player */
                            isfirstkiller(killer, killer.getUniqueId());
                        }
                    } else {
                        stats.addLose(victim.getUniqueId(), 1);
                        stats.addDeaths(victim.getUniqueId(), 1);

                        Utils.rot.remove(victim.getUniqueId());
                        Utils.playing.remove(victim);
                        Utils.spectating.add(victim);

                        /* Get the Winner of the Round */
                        getWinner(victim, killer);

                        for (Player all : Bukkit.getOnlinePlayers()) {
                            CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                        }

                        victim.sendMessage(Utils.prefix + "§7Du bist gestorben und somit aus dem Spiel ausgeschieden");
                        Title.sendTitle(victim, 25, 25, 25, "§cBedwars §8»", "§7Du bist ausgeschieden!");

                        for (Player all : Bukkit.getOnlinePlayers()) {
                            CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                            all.hidePlayer(victim);
                        }

                        victim.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        victim.setGameMode(GameMode.SPECTATOR);
                    }
                } else if (Utils.gelb.contains(victim.getUniqueId())) {
                    if (Utils.canRespawnGelb) {
                        stats.addDeaths(victim.getUniqueId(), 1);

                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(victim.getUniqueId(), victim, "Erster Tote", "Sterbe zum ersten mal!", 15, timestamp);

                        victim.getInventory().clear();
                        victim.getInventory().setHelmet(null);
                        victim.getInventory().setChestplate(null);
                        victim.getInventory().setLeggings(null);
                        victim.getInventory().setBoots(null);
                        victim.setLevel(1);
                        victim.getActivePotionEffects().clear();
                        victim.setFoodLevel(20);
                        victim.spigot().respawn();

                        /* Clear all drops from the Player */
                        e.getDrops().clear();

                        /* Set the Kit for the Player */
                        Tempkits.setkit(victim);

                        /* Send the Death message */
                        for (Player all : Utils.playing) all.sendMessage(Utils.getKillmessage(killer, victim));

                        if (killer != null) {
                            /* Check if the Player is in the Hasmap */
                            isInHasmap(killer);

                            /* Add the new Round kill */
                            roundkills.add(roundkills.size() + 1);

                            /* Check the Achievement */
                            getKills(killer, killer.getUniqueId());

                            /* Check if is the First kill the Player */
                            isfirstkiller(killer, killer.getUniqueId());
                        }
                    } else {
                        stats.addLose(victim.getUniqueId(), 1);
                        stats.addDeaths(victim.getUniqueId(), 1);

                        Utils.gelb.remove(victim.getUniqueId());
                        Utils.playing.remove(victim);
                        Utils.spectating.add(victim);

                        /* Get the Winner of the Round */
                        getWinner(victim, killer);

                        victim.sendMessage(Utils.prefix + "§7Du bist gestorben und somit aus dem Spiel ausgeschieden");
                        Title.sendTitle(victim, 25, 25, 25, "§cBedwars §8»", "§7Du bist ausgeschieden!");

                        for (Player all : Bukkit.getOnlinePlayers()) {
                            CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                            all.hidePlayer(victim);
                        }

                        victim.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        victim.setGameMode(GameMode.SPECTATOR);
                    }
                } else if (Utils.blau.contains(victim.getUniqueId())) {
                    if (Utils.blau.contains(victim.getUniqueId()) && Utils.canRespawnBlau) {
                        stats.addDeaths(victim.getUniqueId(), 1);

                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(victim.getUniqueId(), victim, "Erster Tote", "Sterbe zum ersten mal!", 15, timestamp);

                        victim.getInventory().clear();
                        victim.getInventory().setHelmet(null);
                        victim.getInventory().setChestplate(null);
                        victim.getInventory().setLeggings(null);
                        victim.getInventory().setBoots(null);
                        victim.setLevel(1);
                        victim.getActivePotionEffects().clear();
                        victim.setFoodLevel(20);
                        victim.spigot().respawn();

                        /* Clear all drops from the Player */
                        e.getDrops().clear();

                        /* Set the Kit for the Player */
                        Tempkits.setkit(victim);

                        /* Send the Death message */
                        for (Player all : Utils.playing) all.sendMessage(Utils.getKillmessage(killer, victim));

                        if (killer != null) {
                            /* Check if the Player is in the Hasmap */
                            isInHasmap(killer);

                            /* Add the new Round kill */
                            roundkills.add(roundkills.size() + 1);

                            /* Check the Achievement */
                            getKills(killer, killer.getUniqueId());

                            /* Check if is the First kill the Player */
                            isfirstkiller(killer, killer.getUniqueId());
                        }
                    } else {
                        stats.addLose(victim.getUniqueId(), 1);
                        stats.addDeaths(victim.getUniqueId(), 1);

                        Utils.blau.remove(victim.getUniqueId());
                        Utils.playing.remove(victim);
                        Utils.spectating.add(victim);

                        /* Get the Winner of the Round */
                        getWinner(victim, killer);

                        victim.sendMessage(Utils.prefix + "§7Du bist gestorben und somit aus dem Spiel ausgeschieden");
                        Title.sendTitle(victim, 25, 25, 25, "§cBedwars §8»", "§7Du bist ausgeschieden!");

                        for (Player all : Bukkit.getOnlinePlayers()) {
                            CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                            all.hidePlayer(victim);
                        }

                        victim.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        victim.setGameMode(GameMode.SPECTATOR);
                    }
                } else if (Utils.Lila.contains(victim.getUniqueId())) {
                    if (Utils.canRespawnLila) {
                        stats.addDeaths(victim.getUniqueId(), 1);

                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(victim.getUniqueId(), victim, "Erster Tote", "Sterbe zum ersten mal!", 15, timestamp);

                        victim.getInventory().clear();
                        victim.getInventory().setHelmet(null);
                        victim.getInventory().setChestplate(null);
                        victim.getInventory().setLeggings(null);
                        victim.getInventory().setBoots(null);
                        victim.setLevel(1);
                        victim.getActivePotionEffects().clear();
                        victim.setFoodLevel(20);
                        victim.spigot().respawn();

                        /* Clear all drops from the Player */
                        e.getDrops().clear();

                        /* Set the Kit for the Player */
                        Tempkits.setkit(victim);

                        /* Send the Death message */
                        for (Player all : Utils.playing) all.sendMessage(Utils.getKillmessage(killer, victim));

                        if (killer != null) {
                            /* Check if the Player is in the Hasmap */
                            isInHasmap(killer);

                            /* Add the new Round kill */
                            roundkills.add(roundkills.size() + 1);

                            /* Check the Achievement */
                            getKills(killer, killer.getUniqueId());

                            /* Check if is the First kill the Player */
                            isfirstkiller(killer, killer.getUniqueId());
                        }
                    } else {
                        stats.addDeaths(victim.getUniqueId(), 1);

                        Utils.Lila.remove(victim.getUniqueId());
                        Utils.playing.remove(victim);
                        Utils.spectating.add(victim);

                        /* Get the Winner of the Round */
                        getWinner(victim, killer);

                        victim.sendMessage(Utils.prefix + "§7Du bist gestorben und somit aus dem Spiel ausgeschieden");
                        Title.sendTitle(victim, 25, 25, 25, "§cBedwars §8»", "§7Du bist ausgeschieden!");

                        for (Player all : Bukkit.getOnlinePlayers()) {
                            CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                            all.hidePlayer(victim);
                        }

                        victim.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        victim.setGameMode(GameMode.SPECTATOR);
                    }
                }
            } else {
                Bukkit.broadcastMessage(Utils.prefix + "§cEin fehler ist aufgetreten, bitte melde dies unverzüglich einem MCONE Teammitglieder)");
            }


        }
    }

    @SuppressWarnings("unlikely-arg-type")
    private void getWinner(Player victim, Player killer) {

        if (killer == null) {

            /* Winntection Rot, Blau, Gelb, Lila for Player == null */
            if (Utils.rot.size() == 1 && Utils.gelb.size() == 0 && Utils.Lila.size() == 0 && Utils.blau.size() == 0) {
                if (Utils.rot.size() == 1 && Utils.playing.size() == 1) {
                    Gamestatehandler.setGameState(Gamestate.END_STATE);
                    Gamestatehandler.getCurrentState().end();

                    for (Player rot : Utils.rotchat) {
                        stats.addWin(rot.getUniqueId(), 1);
                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        all.showPlayer(all);

                        Utils.spectating.remove(all);
                        Utils.playing.remove(all);

                        CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

                        all.getInventory().clear();
                        all.getInventory().setHelmet(null);
                        all.getInventory().setChestplate(null);
                        all.getInventory().setLeggings(null);
                        all.getInventory().setBoots(null);
                        all.setHealth(20);
                        all.getActivePotionEffects().clear();
                        all.setFoodLevel(20);
                        all.setGameMode(GameMode.ADVENTURE);
                        all.spigot().respawn();

                        all.sendMessage(Utils.prefix + "§7Team §cRot §7Hat das Spiel gewonnen!");
                        Title.sendTitle(all, 25, 25, 25, "§cBedwars §8»", "§7Team §cRot §7hat das Spiel gewonnen");
                    }

                    for (Player all : Utils.rotchat) {
                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(all.getUniqueId(), all, "Der Gewinner", "Gewinne dein erstes Spiel!", 25, timestamp);
                    }
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("§cEin fehler ist aufgetreten, bitte melde dies unverzüglich einem MCONE Teammitgliedern");
                        all.sendMessage("§cKlasse: Death");
                        all.sendMessage("§cZeile: 335");
                    }
                }

            } else if (Utils.gelb.size() == 1 && Utils.rot.size() == 0 && Utils.Lila.size() == 0 && Utils.blau.size() == 0) {
                if (Utils.gelb.size() == 1 && Utils.playing.size() == 1) {

                    Gamestatehandler.setGameState(Gamestate.END_STATE);
                    Gamestatehandler.getCurrentState().end();

                    for (Player gelb : Utils.gelbchat) {
                        stats.addWin(gelb.getUniqueId(), 1);
                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        all.showPlayer(all);

                        Utils.spectating.remove(all);
                        Utils.playing.remove(all);

                        CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

                        all.getInventory().clear();
                        all.getInventory().setHelmet(null);
                        all.getInventory().setChestplate(null);
                        all.getInventory().setLeggings(null);
                        all.getInventory().setBoots(null);
                        all.setHealth(20);
                        all.getActivePotionEffects().clear();
                        all.setFoodLevel(20);
                        all.setLevel(0);
                        all.setGameMode(GameMode.ADVENTURE);
                        all.spigot().respawn();

                        all.sendMessage(Utils.prefix + "§7Team §eGelb §7Hat das Spiel gewonnen!");
                        Title.sendTitle(all, 25, 25, 25, "§cBedwars §8»", "§7Team §eGelb §7hat das Spiel gewonnen");
                    }

                    for (Player all : Utils.gelbchat) {
                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(all.getUniqueId(), all, "Der Gewinner", "Gewinne dein erstes Spiel!", 25, timestamp);
                    }
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("§cEin fehler ist aufgetreten, bitte melde dies unverzüglich einem MCONE Teammitglieder");
                        all.sendMessage("§cKlasse: Death");
                        all.sendMessage("§cZeile: 373");
                    }
                }

            } else if (Utils.blau.size() == 1 && Utils.gelb.size() == 0 && Utils.Lila.size() == 0 && Utils.rot.size() == 0) {
                if (Utils.blau.size() == 1 && Utils.playing.size() == 1) {

                    Gamestatehandler.setGameState(Gamestate.END_STATE);
                    Gamestatehandler.getCurrentState().end();

                    for (Player blau : Utils.blauchat) {
                        stats.addWin(blau.getUniqueId(), 1);
                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        all.showPlayer(all);

                        Utils.spectating.remove(all);
                        Utils.playing.remove(all);

                        CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

                        all.getInventory().clear();
                        all.getInventory().setHelmet(null);
                        all.getInventory().setChestplate(null);
                        all.getInventory().setLeggings(null);
                        all.getInventory().setBoots(null);
                        all.setHealth(20);
                        all.getActivePotionEffects().clear();
                        all.setFoodLevel(20);
                        all.setGameMode(GameMode.ADVENTURE);
                        all.spigot().respawn();

                        all.sendMessage(Utils.prefix + "§7Team §9Blau §7Hat das Spiel gewonnen!");
                        Title.sendTitle(all, 25, 25, 25, "§cBedwars §8»", "§7Team §9Blau §7hat das Spiel gewonnen");
                    }

                    for (Player all : Utils.blauchat) {
                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(all.getUniqueId(), all, "Der Gewinner", "Gewinne dein erstes Spiel!", 25, timestamp);
                    }
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("§cEin fehler ist aufgetreten, bitte melde dies unverzüglich einem MCONE Teammitgliedern");
                        all.sendMessage("§cKlasse: Death");
                        all.sendMessage("§cZeile: 410");
                    }
                }

            } else if (Utils.Lila.size() == 1 && Utils.gelb.size() == 0 && Utils.rot.size() == 0 && Utils.blau.size() == 0) {
                if (Utils.Lila.size() == 1 && Utils.playing.size() == 1) {

                    Gamestatehandler.setGameState(Gamestate.END_STATE);
                    Gamestatehandler.getCurrentState().end();

                    for (Player lila : Utils.Lilachat) {
                        stats.addWin(lila.getUniqueId(), 1);
                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        all.showPlayer(all);

                        Utils.spectating.remove(all);
                        Utils.playing.remove(all);

                        CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

                        all.getInventory().clear();
                        all.getInventory().setHelmet(null);
                        all.getInventory().setChestplate(null);
                        all.getInventory().setLeggings(null);
                        all.getInventory().setBoots(null);
                        all.setHealth(20);
                        all.getActivePotionEffects().clear();
                        all.setFoodLevel(20);
                        all.setGameMode(GameMode.ADVENTURE);
                        all.spigot().respawn();

                        all.sendMessage(Utils.prefix + "§7Team §5Lila §7Hat das Spiel gewonnen!");
                        Title.sendTitle(all, 25, 25, 25, "§cBedwars §8»", "§7Team §5Lila §7hat das Spiel gewonnen");
                    }

                    for (Player all : Utils.Lilachat) {
                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(all.getUniqueId(), all, "Der Gewinner", "Gewinne dein erstes Spiel!", 25, timestamp);
                    }
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("§cEin fehler ist aufgetreten, bitte melde dies unverzüglich einem MCONE Teammitglieder");
                        all.sendMessage("§cKlasse: Death");
                        all.sendMessage("§cZeile: 447");
                    }
                }
            } else {
                System.out.println("Debug message");
                System.out.println(victim.getName());

                System.out.println("Playing size: " + Utils.playing.size());
                System.out.println("Team Blau size: " + Utils.blau.size());
                System.out.println("Team Rot size: " + Utils.rot.size());
                System.out.println("Team Gelb size: " + Utils.gelb.size());
                System.out.println("Team Lila size: " + Utils.Lila.size());
            }

        } else {

            /* Check if the Player is in the Hasmap */
            isInHasmap(killer);

            /* Add the new Round kill */
            roundkills.add(roundkills.size() + 1);

            /* Check the Achievement */
            getKills(killer, killer.getUniqueId());

            /* Winntection Rot, Blau, Gelb, Lila */
            if (Utils.rot.size() == 1 && Utils.gelb.size() == 0 && Utils.Lila.size() == 0 && Utils.blau.size() == 0) {
                if (Utils.rot.size() == 1 && Utils.playing.size() == 1) {

                    Gamestatehandler.setGameState(Gamestate.END_STATE);
                    Gamestatehandler.getCurrentState().end();

                    for (Player rot : Utils.rotchat) {
                        stats.addWin(rot.getUniqueId(), 1);
                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        all.showPlayer(all);

                        Utils.spectating.remove(all);
                        Utils.playing.remove(all);

                        CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

                        all.getInventory().clear();
                        all.getInventory().setHelmet(null);
                        all.getInventory().setChestplate(null);
                        all.getInventory().setLeggings(null);
                        all.getInventory().setBoots(null);
                        all.setHealth(20);
                        all.getActivePotionEffects().clear();
                        all.setFoodLevel(20);
                        all.setLevel(0);
                        all.setGameMode(GameMode.ADVENTURE);
                        all.spigot().respawn();

                        all.sendMessage(Utils.prefix + "§7Team §cRot §7Hat das Spiel gewonnen!");
                        Title.sendTitle(all, 25, 25, 25, "§cBedwars §8»", "§7Team §cRot §7hat das Spiel gewonnen");
                    }

                    for (Player all : Utils.rotchat) {
                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(all.getUniqueId(), all, "Der Gewinner", "Gewinne dein erstes Spiel!", 25, timestamp);
                    }
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("§cEin fehler ist aufgetreten, bitte melde dies unverzüglich einem MCONE Teammitglieder");
                        all.sendMessage("§cKlasse: Death");
                        all.sendMessage("§cZeile: 499");
                    }
                }

            } else if (Utils.gelb.size() == 1 && Utils.rot.size() == 0 && Utils.Lila.size() == 0 && Utils.blau.size() == 0) {
                if (Utils.gelb.size() == 1 && Utils.playing.size() == 1) {

                    Gamestatehandler.setGameState(Gamestate.END_STATE);
                    Gamestatehandler.getCurrentState().end();

                    for (Player gelb : Utils.gelbchat) {
                        stats.addWin(gelb.getUniqueId(), 1);
                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        all.showPlayer(all);

                        Utils.spectating.remove(all);
                        Utils.playing.remove(all);

                        CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

                        all.getInventory().clear();
                        all.getInventory().setHelmet(null);
                        all.getInventory().setChestplate(null);
                        all.getInventory().setLeggings(null);
                        all.getInventory().setBoots(null);
                        all.setHealth(20);
                        all.getActivePotionEffects().clear();
                        all.setFoodLevel(20);
                        all.setLevel(0);
                        all.setGameMode(GameMode.ADVENTURE);
                        all.spigot().respawn();

                        all.sendMessage(Utils.prefix + "§7Team §eGelb §7Hat das Spiel gewonnen!");
                        Title.sendTitle(all, 25, 25, 25, "§cBedwars §8»", "§7Team §eGelb §7hat das Spiel gewonnen");
                    }

                    for (Player all : Utils.gelbchat) {
                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(all.getUniqueId(), all, "Der Gewinner", "Gewinne dein erstes Spiel!", 25, timestamp);
                    }
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("§cEin fehler ist aufgetreten, bitte melde dies unverzüglich einem MCONE Teammitglieder");
                        all.sendMessage("§cKlasse: Death");
                        all.sendMessage("§cZeile: 537");
                    }
                }

            } else if (Utils.blau.size() == 1 && Utils.gelb.size() == 0 && Utils.Lila.size() == 0 && Utils.rot.size() == 0) {
                if (Utils.blau.size() == 1 && Utils.playing.size() == 1) {

                    Gamestatehandler.setGameState(Gamestate.END_STATE);
                    Gamestatehandler.getCurrentState().end();

                    for (Player blau : Utils.blauchat) {
                        stats.addWin(blau.getUniqueId(), 1);
                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        all.showPlayer(all);

                        Utils.spectating.remove(all);
                        Utils.playing.remove(all);

                        CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

                        all.getInventory().clear();
                        all.getInventory().setHelmet(null);
                        all.getInventory().setChestplate(null);
                        all.getInventory().setLeggings(null);
                        all.getInventory().setBoots(null);
                        all.setHealth(20);
                        all.getActivePotionEffects().clear();
                        all.setFoodLevel(20);
                        all.setGameMode(GameMode.ADVENTURE);
                        all.spigot().respawn();

                        all.sendMessage(Utils.prefix + "§7Team §9Blau §7Hat das Spiel gewonnen!");
                        Title.sendTitle(all, 25, 25, 25, "§cBedwars §8»", "§7Team §9Blau §7hat das Spiel gewonnen");
                    }

                    for (Player all : Utils.blauchat) {
                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(all.getUniqueId(), all, "Der Gewinner", "Gewinne dein erstes Spiel!", 25, timestamp);
                    }
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("§cEin fehler ist aufgetreten, bitte melde dies unverzüglich einem MCONE Teammitglied");
                        all.sendMessage("§cKlasse: Death");
                        all.sendMessage("§cZeile: 576");
                    }
                }

            } else if (Utils.Lila.size() == 1 && Utils.gelb.size() == 0 && Utils.rot.size() == 0 && Utils.blau.size() == 0) {
                if (Utils.Lila.size() == 1 && Utils.playing.size() == 1) {

                    Gamestatehandler.setGameState(Gamestate.END_STATE);
                    Gamestatehandler.getCurrentState().end();

                    for (Player lila : Utils.Lilachat) {
                        stats.addWin(lila.getUniqueId(), 1);
                    }

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

                        all.showPlayer(all);

                        Utils.spectating.remove(all);
                        Utils.playing.remove(all);

                        CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();

                        all.getInventory().clear();
                        all.getInventory().setHelmet(null);
                        all.getInventory().setChestplate(null);
                        all.getInventory().setLeggings(null);
                        all.getInventory().setBoots(null);
                        all.setHealth(20);
                        all.getActivePotionEffects().clear();
                        all.setFoodLevel(20);
                        all.setGameMode(GameMode.ADVENTURE);
                        all.spigot().respawn();

                        all.sendMessage(Utils.prefix + "§7Team §5Lila §7Hat das Spiel gewonnen!");
                        Title.sendTitle(all, 25, 25, 25, "§cBedwars §8»", "§7Team §5Lila §7hat das Spiel gewonnen");
                    }

                    for (Player all : Utils.Lilachat) {
                        long timestamp = System.currentTimeMillis() / 1000;
                        Achievements.insertAchievement(all.getUniqueId(), all, "Der Gewinner", "Gewinne dein erstes Spiel!", 25, timestamp);
                    }
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage("§cEin fehler ist aufgetreten, bitte melde dies unverzüglich einem MCONE Teammitglied");
                        all.sendMessage("§cKlasse: Death");
                        all.sendMessage("§cZeile: 615");
                    }
                }
            }
        }
    }

    private static void isInHasmap(Player p) {
        if (!(p == null)) {
            if (Achievements.gekillt.get(p) == null) {
                Achievements.gekillt.put(p, 1);
            } else {
                Achievements.gekillt.put(p, Achievements.gekillt.get(p) + 1);
            }
        }
    }

    private static void isfirstkiller(Player p, UUID uuid) {
        if (!(p == null)) {
            if (roundkills.size() == 1 && Achievements.gekillt.get(p) == 1) {
                long timestamp = System.currentTimeMillis() / 1000;
                Achievements.insertAchievement(uuid, p, "Erster Kill", "Bringe einen Spieler als erstest um!", 15, timestamp);
            }
        }
    }

    private static void getKills(Player p, UUID uuid) {
        if (!(p == null)) {
            if (Achievements.gekillt.get(p) == 50) {
                long timestamp = System.currentTimeMillis() / 1000;
                Achievements.insertAchievement(uuid, p, "Gnadenloser Killer", "Bringe 50 Spieler in einem Spiel um!", 50, timestamp);
            }
        }
    }
}
