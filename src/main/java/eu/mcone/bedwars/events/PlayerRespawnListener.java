/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener{
	
	@EventHandler
	public void PlayerRespawn(org.bukkit.event.player.PlayerRespawnEvent e){
		Player p = e.getPlayer();
		if(Gamestatehandler.getCurrentState() instanceof Lobbystate) {
			e.setRespawnLocation(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));
		}else if(Gamestatehandler.getCurrentState() instanceof Ingamestate) {
			if (Utils.rot.contains(p.getUniqueId()) && Utils.canRespawnRot) {
				e.setRespawnLocation(Factory.getConfigLocation("Team.Rot", Utils.yCfgTeam));
			} else if (Utils.gelb.contains(p.getUniqueId()) && Utils.canRespawnGelb) {
				e.setRespawnLocation(Factory.getConfigLocation("Team.Gelb", Utils.yCfgTeam));
			} else if (Utils.Lila.contains(p.getUniqueId()) && Utils.canRespawnLila) {
				e.setRespawnLocation(Factory.getConfigLocation("Team.Lila", Utils.yCfgTeam));
			} else if (Utils.blau.contains(p.getUniqueId()) && Utils.canRespawnBlau) {
				e.setRespawnLocation(Factory.getConfigLocation("Team.Blau", Utils.yCfgTeam));
			}else{
				if(Utils.rot.contains(p.getUniqueId())){
                 Utils.rot.remove(p.getUniqueId());
                 Utils.playing.remove(p);
				}else if(Utils.gelb.contains(p.getUniqueId())){
					Utils.gelb.remove(p.getUniqueId());
					Utils.playing.remove(p);
				}else if(Utils.Lila.contains(p.getUniqueId())){
					Utils.Lila.remove(p.getUniqueId());
					Utils.playing.remove(p);
				}else if(Utils.blau.contains(p.getUniqueId())){
					Utils.blau.remove(p.getUniqueId());
					Utils.playing.remove(p);
				}
			}
		 }else if(Gamestatehandler.getCurrentState() == null) {
			 e.setRespawnLocation(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));
		 }
	}
}
