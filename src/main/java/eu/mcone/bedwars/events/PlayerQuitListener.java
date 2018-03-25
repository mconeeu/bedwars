/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.api.Title;
import eu.mcone.bedwars.gamestate.*;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.api.StatsAPI;
import eu.mcone.coresystem.lib.gamemode.Gamemode;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;


public class PlayerQuitListener implements Listener {

    private StatsAPI stats = new StatsAPI(Gamemode.BEDWARS, CoreSystem.mysql2);

    @EventHandler
    public void PlayerQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Player p = e.getPlayer();

        if (Gamestatehandler.getCurrentState() instanceof Lobbystate) {
            Lobbystate ls = (Lobbystate) Gamestatehandler.getCurrentState();
            Utils.playing.remove(e.getPlayer());

            Bukkit.broadcastMessage(Utils.prefix + "§7Der Spieler §f" + p.getName() + " §7hat das Spiel verlassen §7[§f" + Utils.playing.size() + "§7/§f" + Lobbystate.MAX_PLAYERS + "§7]");

            if (Utils.rot.contains(p.getUniqueId())) {
                Utils.rot.remove(p.getUniqueId());
            } else if (Utils.gelb.contains(p.getUniqueId())) {
                Utils.gelb.remove(p.getUniqueId());
            } else if (Utils.Lila.contains(p.getUniqueId())) {
                Utils.Lila.remove(p.getUniqueId());
            } else if (Utils.blau.contains(p.getUniqueId())) {
                Utils.blau.remove(p.getUniqueId());
            }

            if (Utils.playing.size() < Lobbystate.MAX_PLAYERS) {
                if (ls.getCountdown().isRunning) {
                    ls.getCountdown().StopCountdown();
                    ls.getCountdown().idle();
                }
            }
        } else if (Gamestatehandler.getCurrentState() instanceof Ingamestate && (!Utils.spectating.contains(p))) {
            System.out.println("Player " + p.getName() + " left the game");

            stats.addLose(p.getUniqueId(), 1);
            stats.addDeaths(p.getUniqueId(), 1);

            if (Utils.rot.contains(p.getUniqueId()) && Utils.rot.size() == 1) {
                Utils.canRespawnRot = false;
                Utils.rot.remove(p.getUniqueId());
                Utils.rotchat.remove(p);

                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.sendMessage(Utils.prefix + "§7Team §cRot §7wurde vernichtet");
                    CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                    all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 10);
                    checkWin(all);
                }

            } else if (Utils.gelb.contains(p.getUniqueId()) && Utils.gelb.size() == 1) {
                Utils.canRespawnGelb = false;
                Utils.gelb.remove(p.getUniqueId());
                Utils.gelbchat.remove(p);

                for (Player all : Bukkit.getOnlinePlayers()) {

                    all.sendMessage(Utils.prefix + "§7Team §eGelb §7wurde vernichtet");
                    CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                    all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 10);
                    checkWin(all);
                }

            } else if (Utils.blau.contains(p.getUniqueId()) && Utils.blau.size() == 1) {
                Utils.canRespawnBlau = false;
                Utils.blau.remove(p.getUniqueId());
                Utils.blauchat.remove(p);

                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.sendMessage(Utils.prefix + "§7Team §9Blau §7wurde vernichtet");
                    CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                    all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 10);

                    checkWin(all);
                }

            } else if (Utils.Lila.contains(p.getUniqueId()) && Utils.Lila.size() == 1) {
                Utils.canRespawnLila = false;
                Utils.Lila.remove(p.getUniqueId());
                Utils.Lilachat.remove(p);

                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.sendMessage(Utils.prefix + "§7Team §5Lila §7wurde vernichtet");
                    CoreSystem.getCorePlayer(all).getScoreboard().getObjective(DisplaySlot.SIDEBAR).reload();
                    all.playSound(all.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 10);

                    checkWin(all);
                }
            }
        }
    }

    private void checkWin(Player all){
        if (Utils.canRespawnRot && Utils.rot.size() <= 1 && Utils.Lila.size() == 0 && Utils.gelb.size() == 0 && Utils.blau.size() == 0) {
            Gamestatehandler.setGameState(Gamestate.END_STATE);
            Gamestatehandler.getCurrentState().end();

            all.sendMessage(Utils.prefix + "§7Team §cRot §7Hat das Spiel gewonnen!");
            Title.sendTitle(all, 25, 25, 25, Utils.prefix, "§7Team §cRot §7Hat das Spiel gewonnen!");
            all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

            RemoveAll(all);
            all.setGameMode(GameMode.ADVENTURE);

        } else if (Utils.canRespawnGelb && (Utils.gelb.size() <= 1 && Utils.Lila.size() == 0 && Utils.rot.size() == 0 && Utils.blau.size() == 0)) {
            Gamestatehandler.setGameState(Gamestate.END_STATE);
            Gamestatehandler.getCurrentState().end();

            all.sendMessage(Utils.prefix + "§7Team §eGelb §7Hat das Spiel gewonnen!");
            Title.sendTitle(all, 25, 25, 25, Utils.prefix, "§7Team §eGelb §7Hat das Spiel gewonnen!");
            all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

            RemoveAll(all);
            all.setGameMode(GameMode.ADVENTURE);
        } else if (Utils.canRespawnBlau && Utils.blau.size() <= 1 && Utils.Lila.size() == 0 && Utils.gelb.size() == 0 && Utils.rot.size() == 0) {
            Gamestatehandler.setGameState(Gamestate.END_STATE);
            Gamestatehandler.getCurrentState().end();

            all.sendMessage(Utils.prefix + "§7Team §3Blau §7Hat das Spiel gewonnen!");
            Title.sendTitle(all, 25, 25, 25, Utils.prefix, "§7Team §3Balu §7Hat das Spiel gewonnen!");
            all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

            RemoveAll(all);
            all.setGameMode(GameMode.ADVENTURE);
        } else if (Utils.canRespawnLila && Utils.Lila.size() <= 1 && Utils.rot.size() == 0 && Utils.gelb.size() == 0 && Utils.blau.size() == 0) {
            Gamestatehandler.setGameState(Gamestate.END_STATE);
            Gamestatehandler.getCurrentState().end();

            all.sendMessage(Utils.prefix + "§7Team §5Lila §7Hat das Spiel gewonnen!");
            Title.sendTitle(all, 25, 25, 25, Utils.prefix, "§7Team §5Lila §7Hat das Spiel gewonnen!");
            all.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));

            RemoveAll(all);
            all.setGameMode(GameMode.ADVENTURE);
        }
    }

    /* Unused */
    private void getTeamAndRemove(Player p) {
        if (Utils.rot.contains(p.getUniqueId())) {
            System.out.println("Remove " + p.getName() + " from Array Red");
            Utils.rot.remove(p.getUniqueId());
            Utils.rotchat.remove(p);
        } else if (Utils.gelb.contains(p.getUniqueId())) {
            System.out.println("Remove " + p.getName() + " from Array Yellow");
            Utils.gelb.remove(p.getUniqueId());
            Utils.gelbchat.remove(p);
        } else if (Utils.blau.contains(p.getUniqueId())) {
            System.out.println("Remove " + p.getName() + " from Array Blue");
            Utils.blau.remove(p.getUniqueId());
            Utils.blauchat.remove(p);
        } else if (Utils.Lila.contains(p.getUniqueId())) {
            System.out.println("Remove " + p.getName() + " from Array Puple");
            Utils.Lila.remove(p.getUniqueId());
            Utils.Lilachat.remove(p);
        }
    }

    private void RemoveAll(Player p) {
        Utils.RemoveEnt();
        p.getInventory().clear();
        p.getInventory().setHelmet(null);
        p.getInventory().setChestplate(null);
        p.getInventory().setLeggings(null);
        p.getInventory().setBoots(null);
        p.setHealth(20);
        p.getPlayer().getActivePotionEffects().clear();
        p.setFoodLevel(20);
        p.setLevel(0);
    }
}
