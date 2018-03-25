/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.gamestate;

import eu.mcone.bedwars.gamevoting.Ressourcevoting;
import eu.mcone.bedwars.listener.Objective;
import eu.mcone.bedwars.listener.Tablist;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.countdown.Endcountdown;
import eu.mcone.bedwars.tempkits.Tempkits;
import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.scoreboard.CoreScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Ingamestate extends Gamestate {

    private Endcountdown endCountdown;

    @Override
    public void init() {
        Utils.RemoveEnt();

        Utils.HasTeam();

        for (Player p : Bukkit.getOnlinePlayers()) {

            Utils.CheckSystem();

            Utils.checkteamsizes();

            Ressourcevoting.Votingevaluate();

            CoreSystem.getCorePlayer(p).setScoreboard(new Tablist());
            CoreSystem.getCorePlayer(p).getScoreboard().setNewObjective(new Objective());

            p.getInventory().remove(Material.BLAZE_POWDER);
            p.getInventory().remove(Material.SLIME_BALL);
            p.getInventory().remove(Material.NETHER_STAR);
            p.getInventory().remove(Material.BED);
            p.getInventory().remove(Material.CHEST);
            p.getInventory().remove(Material.BOOK);
            p.updateInventory();

            /* Set the Temp-Kit for the Player */
            Tempkits.setkit(p);

            for(Player all : Utils.playing){
                if (Utils.blau.contains(all.getUniqueId())) {
                    all.teleport(Factory.getConfigLocation("Team.Blau", Utils.yCfgTeam));
                    System.out.println("telepor player " + all.getName() + " to team blue");
                }

                if (Utils.rot.contains(all.getUniqueId())) {
                    all.teleport(Factory.getConfigLocation("Team.Rot", Utils.yCfgTeam));
                    System.out.println("telepor player " + all.getName() + " to team red");
                }

                if (Utils.gelb.contains(all.getUniqueId())) {
                    all.teleport(Factory.getConfigLocation("Team.Gelb", Utils.yCfgTeam));
                    System.out.println("telepor player " + all.getName() + " to team yellow");
                }

                if (Utils.Lila.contains(all.getUniqueId())) {
                    all.teleport(Factory.getConfigLocation("Team.Lila", Utils.yCfgTeam));
                    System.out.println("telepor player " + all.getName() + " to team purple");
                }
            }

            p.playSound(p.getLocation(), Sound.ANVIL_USE, 1, 1);
        }
        endCountdown = new Endcountdown();
    }

    @Override
    public void end() {
        try {
            if(endCountdown != null) {
                endCountdown.start();
            } else {
                System.err.println("Error Endstate == null");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

