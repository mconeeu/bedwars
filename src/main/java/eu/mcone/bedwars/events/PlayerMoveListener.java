/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.gamestate.Endstate;
import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.achievements.Achievements;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.methods.Factory;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
public class PlayerMoveListener implements Listener {

    @EventHandler
    public void PlayerMove(org.bukkit.event.player.PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (p.getLocation().getY() >= 240) {
            long timestamp = System.currentTimeMillis() / 1000;
            Achievements.insertAchievement(p.getUniqueId(), p, "In die Lüfte", "Baue dich bis zur Welt-Grenze in die Luft", 15, timestamp);
        }

        if (p.getLocation().getY() <= 10) {
            if (Utils.spectating.contains(p)) {
                p.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));
            } else if (Gamestatehandler.getCurrentState() instanceof Lobbystate) {
                p.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));
            } else if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {
                p.setHealth(0.0D);
                p.spigot().respawn();
            } else if (Gamestatehandler.getCurrentState() instanceof Endstate) {
                p.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));
            }
        }
    }
}
