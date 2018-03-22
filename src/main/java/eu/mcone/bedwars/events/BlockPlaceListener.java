/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.achievements.Achievements;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.UUID;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void BlockPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        Player p = e.getPlayer();

        /* Check if the is in the Hasmap */
        isInHaspmap(p, 1);

        /* Get the Placed Block of the Player and Check the Achievement */
        getBlocks(p.getUniqueId(), p);

        if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {
            if (e.getBlock().getType() == Material.HARD_CLAY || e.getBlock().getType() == Material.ENDER_STONE || e.getBlock().getType() == Material.GLOWSTONE || e.getBlock().getType() == Material.IRON_BLOCK || e.getBlock().getType() == Material.GLASS || e.getBlock().getType() == Material.TNT || e.getBlock().getType() == Material.CHEST || e.getBlock().getType() == Material.ENDER_CHEST || p.getGameMode() == GameMode.CREATIVE) {
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
            }
        } else {
            e.setCancelled(true);
        }
    }

    private static void isInHaspmap(Player p, int anzahl) {
        if (Achievements.gebaut.get(p) != null) {
            Achievements.gebaut.put(p, 1);
        } else {
            Achievements.gebaut.put(p, Achievements.gebaut.get(p) + 1);
        }
    }

    private static void getBlocks(UUID uuid, Player p) {
        if (Achievements.gebaut.get(p) == 350) {
            long timestamp = System.currentTimeMillis() / 1000;
            Achievements.insertAchievement(uuid, p, "Builder", "Baue 350 Blöcke in einer Runde", 15, timestamp);
        }
    }
}
