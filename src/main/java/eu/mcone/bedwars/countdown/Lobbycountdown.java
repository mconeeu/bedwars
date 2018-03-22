/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.countdown;

import eu.mcone.bedwars.api.Title;
import eu.mcone.bedwars.gamestate.Gamestate;
import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Lobbycountdown extends Countdown {

    private int seconds = 60;
    private int taskID;
    private int idleID;
    public boolean isIdling = false, isRunning = false;

    @Override
    public void start() {
        isRunning = true;
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(bedwars.getPlugin(), new Runnable() {

            @Override
            public void run() {
                for (Player a : Utils.playing) a.setLevel(seconds);
                switch (seconds) {
                    case 60:
                    case 30:
                    case 15:
                    case 10:
                    case 5:
                    case 3:
                    case 2:
                        Bukkit.broadcastMessage(Utils.prefix + "§7Das Spiel beginnt in §f" + seconds + "§7 Sekunden");
                        for (Player a : Utils.playing)
                            Title.sendActionBar(a, Utils.prefix + "§7Das Spiel beginnt in §f" + seconds + "§7 Sekunden");
                        for (Player a : Utils.playing) a.playSound(a.getLocation(), Sound.LEVEL_UP, 1, 1);
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Utils.prefix + "§7Das Spiel beginnt in §f" + seconds + "§7 Sekunden");
                        for (Player a : Utils.playing)
                            Title.sendActionBar(a, Utils.prefix + "§7Das Spiel beginnt in §f" + seconds + "§7 Sekunden");
                        for (Player a : Utils.playing) a.playSound(a.getLocation(), Sound.LEVEL_UP, 1, 1);
                        break;
                    case 0:
                        if (Lobbystate.MIN_PLAYERS < 1) {
                            for (Player all : Utils.playing)
                                all.sendMessage(Utils.prefix + "§cEs sind nicht genügend Spieler online!");
                            seconds = 60;
                            return;
                        } else {
                            Gamestatehandler.setGameState(Gamestate.INGAME_STATE);
                        }

                        break;
                    default:
                        break;
                }
                seconds--;
            }

        }, 0, 20);

    }

    public void idle() {
        isIdling = true;
        idleID = Bukkit.getScheduler().scheduleSyncRepeatingTask(bedwars.getPlugin(), new Runnable() {

            @Override
            public void run() {

                int missing = Lobbystate.MIN_PLAYERS - Utils.playing.size();
                for (Player a : Utils.playing)
                    Title.sendActionBar(a, Utils.prefix + "§7Es fehlt noch §f" + missing + " §7Spieler um das Spiel zu starten");
                Bukkit.broadcastMessage(Utils.prefix + "§7Es fehlt noch §f" + missing + " §7Spieler um das Spiel zu starten");

            }

        }, 0, 300);
    }

    public void StopIdle() {
        isIdling = false;
        Bukkit.getScheduler().cancelTask(idleID);
    }

    public void StopCountdown() {
        isRunning = false;
        Bukkit.getScheduler().cancelTask(taskID);
        seconds = 60;

    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void stop() {
        isIdling = false;
        isRunning = false;
        seconds = 60;
        Bukkit.getScheduler().cancelTask(taskID);
        Bukkit.getScheduler().cancelTask(idleID);
    }

}
