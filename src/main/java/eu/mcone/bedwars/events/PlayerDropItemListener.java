/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.gamestate.Lobbystate;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener{

	@EventHandler
	public void PlayerDropItem(org.bukkit.event.player.PlayerDropItemEvent e){
	 if(Gamestatehandler.getCurrentState() instanceof Lobbystate){
	 	e.setCancelled(true);
	 }else if(Gamestatehandler.getCurrentState() instanceof Ingamestate){
	 	e.setCancelled(false);
	 }
  }
}
