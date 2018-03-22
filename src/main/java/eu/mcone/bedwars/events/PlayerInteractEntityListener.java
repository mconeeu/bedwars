/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.shop.Shopmanager;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntityListener implements Listener {

    @EventHandler
    public void PlayerInteractEntity(org.bukkit.event.player.PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        if (e.getRightClicked().getType() == EntityType.VILLAGER) {
            e.setCancelled(true);
            Shopmanager.openShopInv(p);
        }
    }
}
