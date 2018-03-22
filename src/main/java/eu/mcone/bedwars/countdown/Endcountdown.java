/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.countdown;

import eu.mcone.bedwars.api.Title;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Endcountdown extends Countdown {

    private static int taskID;
    private int sconds = 30;

    @Override
    public void start() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(bedwars.getInstance(), new Runnable() {

            @Override
            public void run() {
                switch (sconds) {
                    case 30:
                    case 20:
                    case 10:
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                    case 1:
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.sendMessage(Utils.prefix + "§cDer Server startet in §f" + sconds + " §cSekunden neu!");
                            Title.sendTitle(all, 2, 5, 2, Utils.prefix, "§cRestart in §7" + sconds + " §cSekunden");
                        }
                        break;

                    case 0:
                        for (Player a : Bukkit.getOnlinePlayers()) {
                            a.kickPlayer(Utils.prefix + "§cDas Spiel ist beendet!");
                        }

                        Bukkit.shutdown();
                        break;

                    default:
                        break;
                }
                sconds--;
            }

        }, 0, 20);
    }

    @Override
    public void stop() {
        Bukkit.getScheduler().cancelTask(taskID);
    }

}

