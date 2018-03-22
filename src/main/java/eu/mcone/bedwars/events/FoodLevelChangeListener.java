/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.gamestate.Endstate;
import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener{
	
	@EventHandler
	public void FoodLevelChange(org.bukkit.event.entity.FoodLevelChangeEvent e){
		if(Gamestatehandler.getCurrentState() instanceof Lobbystate || Gamestatehandler.getCurrentState() instanceof Endstate){
			e.setCancelled(true);
		}
	}
}

