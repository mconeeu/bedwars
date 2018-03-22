/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.methods.Messenger;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class PlayerBedEnterListener implements Listener{

    @EventHandler
    public void PlayerBedEnter(final org.bukkit.event.player.PlayerBedEnterEvent e) {
        e.setCancelled(true);
        Messenger.sendSimpleMessage(e.getPlayer(), "§7Nicht schlafen! Pass lieber auf dein Bett auf!");
    }
}
