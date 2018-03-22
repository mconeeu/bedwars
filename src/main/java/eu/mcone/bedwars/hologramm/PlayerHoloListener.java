/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.hologramm;

import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.api.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PlayerHoloListener implements Listener{

    private static StatsAPI stats = CoreSystem.statsBedwars;

    public static void Holo(final Player p) {
        String[] Text = { "§7» §c§lBedwars",
                            "§7Stats von §f" + p.getName(),
                            "§r",
                            "§7Platz: §f" + stats.getUserRanking(p.getUniqueId()),
                            "§7K.D: §f" + stats.getKD(p.getUniqueId()),
                            "§r",
                            "§7Kills: §f" + stats.getKills(p.getUniqueId()),
                            "§7Tode: §f" + stats.getDeaths(p.getUniqueId()),
                            "§r",
                            "§7Abgebaute Betten: §f" + stats.getGoals(p.getUniqueId()),
                            "§7Wins: §f" + stats.getWins(p.getUniqueId()),
                            "§7Lose: §f" + stats.getLoses(p.getUniqueId())};
        PlayerHolograms holo = new PlayerHolograms(Text, Factory.getConfigLocation("Holo", Utils.yCfgLobby));
        holo.showPlayer(p);
    }
}
