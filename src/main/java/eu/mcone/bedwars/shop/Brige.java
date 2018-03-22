/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.shop;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Brige implements Listener{

    @EventHandler
    public void PlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if(Gamestatehandler.getCurrentState() instanceof Ingamestate){
            if (p.getItemInHand().getType() == Material.EMERALD && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)){
                    if (p.getItemInHand().getAmount() == 1) {
                        p.getInventory().remove(p.getItemInHand());
                    }
                p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);

                    if(p.getLocation().getYaw() <= 140 || p.getLocation().getYaw() <= -140){
                        p.sendMessage("§4§lGERADE AUS");
                        //Gerade aus
                        final Location loc1 = p.getLocation().add(0.0, 0.0, -1.0);
                        final Location loc2 = p.getLocation().add(0.0, 0.0, -2.0);
                        final Location loc3 = p.getLocation().add(0.0, 0.0, -3.0);
                        final Location loc4 = p.getLocation().add(0.0, 1.0, -4.0);
                        final Location loc5 = p.getLocation().add(0.0, 1.0, -5.0);
                        final Location loc6 = p.getLocation().add(0.0, 1.0, -6.0);
                        final Location loc7 = p.getLocation().add(0.0, 2.0, -7.0);
                        final Location loc8 = p.getLocation().add(0.0, 2.0, -8.0);
                        final Location loc9 = p.getLocation().add(0.0, 2.0, -9.0);
                        final Location loc10 = p.getLocation().add(0.0, 3.0, -10.0);
                        final Location loc11 = p.getLocation().add(0.0, 3.0, -11.0);
                        final Location loc12 = p.getLocation().add(0.0, 3.0, -12.0);
                        loc1.getBlock().setType(Material.SANDSTONE);
                        loc2.getBlock().setType(Material.SANDSTONE);
                        loc3.getBlock().setType(Material.SANDSTONE);
                        loc4.getBlock().setType(Material.SANDSTONE);
                        loc5.getBlock().setType(Material.SANDSTONE);
                        loc6.getBlock().setType(Material.SANDSTONE);
                        loc7.getBlock().setType(Material.SANDSTONE);
                        loc8.getBlock().setType(Material.SANDSTONE);
                        loc9.getBlock().setType(Material.SANDSTONE);
                        loc10.getBlock().setType(Material.SANDSTONE);
                        loc11.getBlock().setType(Material.SANDSTONE);
                        loc12.getBlock().setType(Material.SANDSTONE);

                        Rettungsplatform.schutz.add(p);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(bedwars.getInstance(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                Rettungsplatform.schutz.remove(p);
                            }
                        }, 30L);

                    }else if(p.getLocation().getYaw() <= -133 || p.getLocation().getYaw() <= -48){
                        p.sendMessage("§4§lRECHTS");
                        //Rechts
                        final Location loc1 = p.getLocation().add(-1.0, 0.0, 0.0);
                        final Location loc2 = p.getLocation().add(-2.0, 0.0, 0.0);
                        final Location loc3 = p.getLocation().add(-3.0, 0.0, 0.0);
                        final Location loc4 = p.getLocation().add(-4.0, 1.0, 0.0);
                        final Location loc5 = p.getLocation().add(-5.0, 1.0, 0.0);
                        final Location loc6 = p.getLocation().add(-6.0, 1.0, 0.0);
                        final Location loc7 = p.getLocation().add(-7.0, 2.0, 0.0);
                        final Location loc8 = p.getLocation().add(-8.0, 2.0, 0.0);
                        final Location loc9 = p.getLocation().add(-9.0, 2.0, 0.0);
                        final Location loc10 = p.getLocation().add(-10.0, 3.0, 0.0);
                        final Location loc11 = p.getLocation().add(-11.0, 3.0, 0.0);
                        final Location loc12 = p.getLocation().add(-12.0, 3.0, 0.0);
                        loc1.getBlock().setType(Material.SANDSTONE);
                        loc2.getBlock().setType(Material.SANDSTONE);
                        loc3.getBlock().setType(Material.SANDSTONE);
                        loc4.getBlock().setType(Material.SANDSTONE);
                        loc5.getBlock().setType(Material.SANDSTONE);
                        loc6.getBlock().setType(Material.SANDSTONE);
                        loc7.getBlock().setType(Material.SANDSTONE);
                        loc8.getBlock().setType(Material.SANDSTONE);
                        loc9.getBlock().setType(Material.SANDSTONE);
                        loc10.getBlock().setType(Material.SANDSTONE);
                        loc11.getBlock().setType(Material.SANDSTONE);
                        loc12.getBlock().setType(Material.SANDSTONE);

                        Rettungsplatform.schutz.add(p);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(bedwars.getInstance(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                Rettungsplatform.schutz.remove(p);
                            }
                        }, 30L);

                    }else if(p.getLocation().getYaw() <= -46 || p.getLocation().getYaw() <= 44){
                        p.sendMessage("§4§lHINTEN");
                        //Hinten
                        final Location loc1 = p.getLocation().add(0.0, 0.0, -1.0);
                        final Location loc2 = p.getLocation().add(0.0, 0.0, -2.0);
                        final Location loc3 = p.getLocation().add(0.0, 0.0, -3.0);
                        final Location loc4 = p.getLocation().add(0.0, 1.0, -4.0);
                        final Location loc5 = p.getLocation().add(0.0, 1.0, -5.0);
                        final Location loc6 = p.getLocation().add(0.0, 1.0, -6.0);
                        final Location loc7 = p.getLocation().add(0.0, 2.0, -7.0);
                        final Location loc8 = p.getLocation().add(0.0, 2.0, -8.0);
                        final Location loc9 = p.getLocation().add(0.0, 2.0, -9.0);
                        final Location loc10 = p.getLocation().add(0.0, 3.0, -10.0);
                        final Location loc11 = p.getLocation().add(0.0, 3.0, -11.0);
                        final Location loc12 = p.getLocation().add(0.0, 3.0, -12.0);
                        loc1.getBlock().setType(Material.SANDSTONE);
                        loc2.getBlock().setType(Material.SANDSTONE);
                        loc3.getBlock().setType(Material.SANDSTONE);
                        loc4.getBlock().setType(Material.SANDSTONE);
                        loc5.getBlock().setType(Material.SANDSTONE);
                        loc6.getBlock().setType(Material.SANDSTONE);
                        loc7.getBlock().setType(Material.SANDSTONE);
                        loc8.getBlock().setType(Material.SANDSTONE);
                        loc9.getBlock().setType(Material.SANDSTONE);
                        loc10.getBlock().setType(Material.SANDSTONE);
                        loc11.getBlock().setType(Material.SANDSTONE);
                        loc12.getBlock().setType(Material.SANDSTONE);

                        Rettungsplatform.schutz.add(p);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(bedwars.getInstance(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                Rettungsplatform.schutz.remove(p);
                            }
                        }, 30L);
                    }else if(p.getLocation().getYaw() <= 45 || p.getLocation().getYaw() <= 135){
                        p.sendMessage("§4§lLINKS");
                        //Links
                        final Location loc1 = p.getLocation().add(1.0, 0.0, 0.0);
                        final Location loc2 = p.getLocation().add(2.0, 0.0, 0.0);
                        final Location loc3 = p.getLocation().add(3.0, 0.0, 0.0);
                        final Location loc4 = p.getLocation().add(4.0, 1.0, 0.0);
                        final Location loc5 = p.getLocation().add(5.0, 1.0, 0.0);
                        final Location loc6 = p.getLocation().add(6.0, 1.0, 0.0);
                        final Location loc7 = p.getLocation().add(7.0, 2.0, 0.0);
                        final Location loc8 = p.getLocation().add(8.0, 2.0, 0.0);
                        final Location loc9 = p.getLocation().add(9.0, 2.0, 0.0);
                        final Location loc10 = p.getLocation().add(10.0, 3.0, 0.0);
                        final Location loc11 = p.getLocation().add(11.0, 3.0, 0.0);
                        final Location loc12 = p.getLocation().add(12.0, 3.0, 0.0);
                        loc1.getBlock().setType(Material.SANDSTONE);
                        loc2.getBlock().setType(Material.SANDSTONE);
                        loc3.getBlock().setType(Material.SANDSTONE);
                        loc4.getBlock().setType(Material.SANDSTONE);
                        loc5.getBlock().setType(Material.SANDSTONE);
                        loc6.getBlock().setType(Material.SANDSTONE);
                        loc7.getBlock().setType(Material.SANDSTONE);
                        loc8.getBlock().setType(Material.SANDSTONE);
                        loc9.getBlock().setType(Material.SANDSTONE);
                        loc10.getBlock().setType(Material.SANDSTONE);
                        loc11.getBlock().setType(Material.SANDSTONE);
                        loc12.getBlock().setType(Material.SANDSTONE);

                        Rettungsplatform.schutz.add(p);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(bedwars.getInstance(), (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                Rettungsplatform.schutz.remove(p);
                            }
                        }, 30L);
                    }else{
                        for(Player all : Bukkit.getOnlinePlayers()){
                            all.sendMessage(Utils.prefix + "§cEs ist ein fehler beim ausführen der Brige aufgetreten, Bitte Kontaktiere einen §bDeveloper §7(TwinsterHD) §coder Admin");
                        }
                    }
            }
        }
    }
}
