/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.listener;

import eu.mcone.bedwars.gamestate.Endstate;
import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.coresystem.bukkit.player.CorePlayer;
import eu.mcone.coresystem.bukkit.scoreboard.CoreObjective;
import eu.mcone.coresystem.bukkit.scoreboard.MainScoreboard;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;

public class Objective extends CoreObjective {

    public Objective() {
        super(DisplaySlot.SIDEBAR, "Main", "Bedwars");
    }

    @Override
    public void register() {
        org.bukkit.scoreboard.Objective o = bukkit();

        o.setDisplayName("§7» §c§lBedwars");
        reload();
    }

    @Override
    public void reload() {
        org.bukkit.scoreboard.Objective o = bukkit();
        Scoreboard sb = getScoreboard();
        CorePlayer p = getPlayer();

        if (Gamestatehandler.getCurrentState() instanceof Lobbystate) {

            o.getScore("§7Map:").setScore(10);
            o.getScore(bedwars.cfgSetup.getString("Bedwars-Lobby-Map-Name").replaceAll("&", "§").replaceAll(">>", "»")).setScore(9);
            o.getScore("").setScore(8);
            o.getScore("§7Teams:").setScore(7);
            o.getScore(bedwars.cfgSetup.getString("Bedwars-Lobby-Map-Size").replaceAll("&", "§").replaceAll(">>", "»")).setScore(6);
            o.getScore("§r").setScore(5);
            o.getScore("§f§lMCONE.EU").setScore(4);


            p.bukkit().setScoreboard(sb);
        } else if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {

            if (Utils.canRespawnBlau == true) {
                o.getScore("§2❤ §3Blau").setScore(Utils.blau.size());
            } else {
                o.getScore("§4❤ §3Blau").setScore(Utils.blau.size());
            }

            if (Utils.canRespawnRot == true) {
                o.getScore("§2❤ §cRot").setScore(Utils.rot.size());
            } else {
                o.getScore("§4❤ §cRot").setScore(Utils.rot.size());
            }

            if (Utils.canRespawnGelb == true) {
                o.getScore("§2❤ §eGelb").setScore(Utils.gelb.size());
            } else {
                o.getScore("§4❤ §eGelb").setScore(Utils.gelb.size());
            }

            if (Utils.canRespawnLila == true) {
                o.getScore("§2❤ §5Lila").setScore(Utils.Lila.size());
            } else {
                o.getScore("§4❤ §5Lila").setScore(Utils.Lila.size());
            }

            p.bukkit().setScoreboard(sb);
        } else if (Gamestatehandler.getCurrentState() instanceof Lobbystate) {

            o.getScore("§7Map:").setScore(10);
            o.getScore(bedwars.cfgSetup.getString("Bedwars-Lobby-Map-Name").replaceAll("&", "§").replaceAll(">>", "»")).setScore(9);
            o.getScore("").setScore(8);
            o.getScore("§7Teams:").setScore(7);
            o.getScore(bedwars.cfgSetup.getString("Bedwars-Lobby-Map-Size").replaceAll("&", "§").replaceAll(">>", "»")).setScore(6);
            o.getScore("§r").setScore(5);
            o.getScore("§f§lMCONE.EU").setScore(4);


            p.bukkit().setScoreboard(sb);
        } else if (Gamestatehandler.getCurrentState() instanceof Endstate) {
            o.getScore("").setScore(10);
            o.getScore("§7» §f§lMCONE.EU").setScore(9);


            p.bukkit().setScoreboard(sb);
        } else if (Utils.spectating.contains(p.getUuid())) {

            o.getScore("").setScore(10);
            o.getScore("§7» §f§lMCONE.EU").setScore(9);

            p.bukkit().setScoreboard(sb);
        }
    }
}
