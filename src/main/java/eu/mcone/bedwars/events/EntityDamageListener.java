/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.shop.Rettungsplatform;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void EntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (Gamestatehandler.getCurrentState() instanceof Lobbystate) {
            if (e.getEntity() instanceof Player) {
                e.setCancelled(true);
            }
        } else if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {
            if (Utils.spectating.contains(e.getEntity())) {
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }

    @EventHandler
    public void EntityDamage(org.bukkit.event.entity.EntityDamageEvent e) {
        if (Gamestatehandler.getCurrentState() instanceof Lobbystate) {
            if (e.getEntity() instanceof Player) {
                if (e.getCause().equals(org.bukkit.event.entity.EntityDamageEvent.DamageCause.DROWNING)) {
                    e.setCancelled(true);
                }

                if (e.getCause().equals(org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL)) {
                    e.setCancelled(true);
                }

                if (e.getCause().equals(org.bukkit.event.entity.EntityDamageEvent.DamageCause.LAVA)) {
                    e.setCancelled(true);
                }
            }
        } else if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {
            if (Utils.spectating.contains(e.getEntity())) {
                e.setCancelled(true);
            } else if(e.getCause().equals(org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL) && Rettungsplatform.schutz.contains(e.getEntity())){
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }

}
