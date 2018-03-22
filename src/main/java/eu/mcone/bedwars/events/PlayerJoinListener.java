/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.api.Itemmanager;
import eu.mcone.bedwars.api.Title;
import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.hologramm.PlayerHoloListener;
import eu.mcone.bedwars.listener.Objective;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.coresystem.bukkit.CoreSystem;
import eu.mcone.coresystem.bukkit.player.CorePlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;

public class PlayerJoinListener implements Listener{

	@EventHandler
	public void PlayerJoin(org.bukkit.event.player.PlayerJoinEvent e){
		e.setJoinMessage(null);
		Player p = e.getPlayer();

		if(Utils.playing.size() >= Lobbystate.MAX_PLAYERS + 1){
			p.kickPlayer(Utils.prefix + "§cDer Server Ist Voll!");
		}

		p.setMaxHealth(20);
		p.setLevel(0);
		p.setGameMode(GameMode.SURVIVAL);
		p.getInventory().clear();
		p.getInventory().setHelmet(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setBoots(null);
		p.setHealth(20);
		p.getPlayer().getActivePotionEffects().clear();
		p.setFoodLevel(20);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);

		CoreSystem.getCorePlayer(p).getScoreboard().setNewObjective(new Objective());

		if(Gamestatehandler.getCurrentState() instanceof Lobbystate){
			Lobbystate ls = (Lobbystate) Gamestatehandler.getCurrentState();

			for(Player p1 : Bukkit.getOnlinePlayers()){
				PlayerHoloListener.Holo(p1);
			}

			Utils.playing.add(p);
			Bukkit.broadcastMessage(Utils.prefix + "§7Der Spieler §f" + p.getDisplayName() + " §7ist beigetreten. §7[§f" + Utils.playing.size() + "§7/§f" + Lobbystate.MAX_PLAYERS + "§7]");
			Title.sendTitle(p, 25, 25, 25, "§cBedwars §8»", p.getName() + " §7ist beigetreten. §7[§f" + Utils.playing.size() + "§7/§f" + Lobbystate.MAX_PLAYERS + "§7]");
			
			p.getInventory().setItem(0, Itemmanager.CreateItemwithMaterial(Material.BED, 0, 1, "§f§oTeam auswählen", null));
			p.getInventory().setItem(8, Itemmanager.CreateItemwithMaterial(Material.SLIME_BALL, 0, 1, "§f§oLobby", null));
			p.getInventory().setItem(7, Itemmanager.CreateItemwithMaterial(Material.NETHER_STAR, 0, 1, "§f§oAchievements", null));
			p.getInventory().setItem(6, Itemmanager.CreateItemwithMaterial(Material.CHEST, 0, 1, "§f§oTemp-Kits", null));
			p.getInventory().setItem(5, Itemmanager.CreateItemwithMaterial(Material.BOOK, 0, 1, "§f§oVoting", null));
			
			if(p.hasPermission("bedwars.start") || p.hasPermission("system.*")){
				p.getInventory().setItem(1, Itemmanager.CreateItemwithMaterial(Material.BLAZE_POWDER, 0, 1, "§f§oStart", null));
			}
			
			if(Utils.CfgLobby.exists()) {
				p.teleport(Factory.getConfigLocation("Lobby", Utils.yCfgLobby));
			}else {
				p.sendMessage(Utils.prefix + "§cDer Lobby Spawn wurde noch nicht gestezt!");
			}
			
			if(Utils.playing.size() >= Lobbystate.MIN_PLAYERS){
				if(!(ls.getCountdown().isRunning)){
					ls.getCountdown().StopIdle();
					ls.getCountdown().start();
				}
			}
			
			if(Utils.playing.size() < Lobbystate.MIN_PLAYERS){
				if(!(ls.getCountdown().isIdling)){
					ls.getCountdown().idle();
				}
			}
		}

		if(Gamestatehandler.getCurrentState() instanceof Ingamestate){
			if(p.hasPermission("system.bedwars.full.join") || p.hasPermission("system.bedwars.*") || p.hasPermission("system.*")){
				e.setJoinMessage(null);
				for(Player all : Bukkit.getOnlinePlayers()){
					Utils.spectating.add(p);
					all.hidePlayer(p);

					p.setGameMode(GameMode.SPECTATOR);
					p.getInventory().setItem(8, Itemmanager.CreateItemwithMaterial(Material.SLIME_BALL, 0, 1, "§3Lobby", null));
					p.sendMessage(Utils.prefix + "§7Du bist nun im Spectator modus!");
					Title.sendTitle(p, 25, 25, 25, "§cBedwars §8»", "§7Du bist nun im Spectator modus!");
				}
			}else{
				p.sendMessage(Utils.prefix + "§cDiese runde ist leider schon ingame");
			}
		}
		
	}
}

