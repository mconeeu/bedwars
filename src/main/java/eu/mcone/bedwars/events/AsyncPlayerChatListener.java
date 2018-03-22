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
import eu.mcone.bedwars.main.bedwars;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener{

    @SuppressWarnings("unlikely-arg-type")
	@EventHandler
    public void onChat(org.bukkit.event.player.AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String message = e.getMessage();
        if(Utils.spectating.contains(p.getName())){
            e.setCancelled(true);
            p.sendMessage(Utils.prefix + "§7Du kannst Leider denn chat nicht benutzen da du Spectator bist");
        }else if(Gamestatehandler.getCurrentState() instanceof Lobbystate){
            if(p.hasPermission("group.Admin")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Admin").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Developer")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Developer").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Builder")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Builder").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.SrModerator")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-SrModerator").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Moderator")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Moderator").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.JrSupporter")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Supporter").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Supporter")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Supporter").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Team")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Team").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.YouTuber")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-YouTuber").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Premium+")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Premium+").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Premium")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Premium").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Spieler")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Spieler").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Spielverderber")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Spielverderber").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else{
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Spieler").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }
        }else if(Gamestatehandler.getCurrentState() instanceof Ingamestate){
            if (message.startsWith("@all")) {
                for(Player all : Bukkit.getOnlinePlayers()){
                    if (Utils.blau.contains(p.getUniqueId())) {
                        all.sendMessage("§8[§bAll§8] " + bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Blau").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()).replaceAll("@all", ""));
                        e.setCancelled(true);
                    }else if (Utils.rot.contains(p.getUniqueId())) {
                        all.sendMessage("§8[§bAll§8] " + bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Rot").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()).replaceAll("@all", ""));
                        e.setCancelled(true);
                    }else if (Utils.gelb.contains(p.getUniqueId())) {
                        all.sendMessage("§8[§bAll§8] " + bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Gelb").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()).replaceAll("@all", ""));
                        e.setCancelled(true);
                    }else if (Utils.Lila.contains(p.getUniqueId())) {
                        all.sendMessage("§8[§bAll§8] " + (bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Lila").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()).replaceAll("@all", "")));
                        e.setCancelled(true);
                    }
                }
            }else{
                if(Utils.rot.contains(p.getUniqueId())){
                    for(Player all : Utils.rotchat){
                        all.sendMessage(bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Rot").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
                        e.setCancelled(true);
                    }
                }else if(Utils.Lila.contains(p.getUniqueId())){
                    for(Player all : Utils.Lilachat){
                        all.sendMessage(bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Lila").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
                        e.setCancelled(true);
                    }
                }else if(Utils.gelb.contains(p.getUniqueId())){
                    for(Player all : Utils.gelbchat){
                        all.sendMessage(bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Gelb").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
                        e.setCancelled(true);
                    }
                }else if(Utils.blau.contains(p.getUniqueId())){
                    for(Player all : Utils.blauchat){
                        all.sendMessage(bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Blau").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
                        e.setCancelled(true);
                    }
                }else if(Utils.Schwarz.contains(p.getUniqueId())){
                    for(Player all : Utils.Schwarzchat){
                        all.sendMessage(bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Schwarz").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
                        e.setCancelled(true);
                    }
                }else if(Utils.grün.contains(p.getUniqueId())){
                    for(Player all : Utils.grünchat){
                        all.sendMessage(bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Grün").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
                        e.setCancelled(true);
                    }
                }else if(Utils.Gold.contains(p.getUniqueId())){
                    for(Player all : Utils.Goldchat){
                     all.sendMessage(bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Gold").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
                     e.setCancelled(true);
                    }
                }else if(Utils.weiß.contains(p.getUniqueId())){
                    for(Player all : Utils.weißchat){
                     all.sendMessage(bedwars.cfgConf.getString("Bedwars-Chat-Ingame-Weiß").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
                     e.setCancelled(true);
                    }
                }
            }
        }else if(Gamestatehandler.getCurrentState() instanceof Endstate){
        	System.out.println("Debug-3");
            if(p.hasPermission("group.Admin")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Admin").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Developer")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Developer").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Builder")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Builder").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.SrModerator")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-SrModerator").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Moderator")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Moderator").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.JrSupporter")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Supporter").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Supporter")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Supporter").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Team")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Team").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.YouTuber")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-YouTuber").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Premium+")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Premium+").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Premium")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Premium").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Spieler")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Spieler").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else if(p.hasPermission("group.Spielverderber")){
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Spielverderber").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }else{
                e.setFormat(bedwars.cfgConf.getString("Bedwars-Chat-Lobby-Spieler").replaceAll("&", "§").replaceAll(">>", "»").replaceAll("Player", p.getName()).replaceAll("Nachricht", e.getMessage()));
            }
            
        	if(message.startsWith("GG") || message.startsWith("gg") || message.startsWith("Gg") || message.startsWith("gG")) {
        		long timestamp= System.currentTimeMillis() / 1000;
        		Achievements.insertAchievement(p.getUniqueId(), p, "Fair-Play", "Schreibe nach einer Runde 'GG' in den Chat!", 15, timestamp);
        	}
        }
       
    }
}
