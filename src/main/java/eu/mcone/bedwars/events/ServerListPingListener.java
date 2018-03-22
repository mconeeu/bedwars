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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPingListener implements Listener{

    @EventHandler
    public void ServerListPing(org.bukkit.event.server.ServerListPingEvent e) {
        if(Gamestatehandler.getCurrentState() instanceof Lobbystate){
            e.setMotd(Utils.prefix + "§fLobby §7Phase");
        }else if(Gamestatehandler.getCurrentState() instanceof Ingamestate){
            e.setMotd(Utils.prefix + "§fInGame §7Phase");
        }else{
            e.setMotd(Utils.prefix + "§4Server Restart");
        }
    }
}
