/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.shop;

import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.coresystem.bukkit.util.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class Warppowder implements Listener{

    private static List<String> list = new ArrayList<>();
    BukkitTask i;

    @EventHandler
    public void PlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.getMaterial(289)) {
            if (Warppowder.list.contains(p.getName())) {
                return;
            }
            if (p.getItemInHand().getAmount() == 1) {
                p.getInventory().remove(p.getItemInHand());
            }
            p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
            Warppowder.list.add(p.getName());
            this.i = Bukkit.getScheduler().runTaskLater(bedwars.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
               
                   spawnEffect();
                   
                   if(Utils.rot.contains(p.getUniqueId())){
                        p.teleport(Factory.getConfigLocation("Team.Rot", Utils.yCfgTeam));
                        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 2, 2);
                   }else if(Utils.gelb.contains(p.getUniqueId())){
                       p.teleport(Factory.getConfigLocation("Team.Gelb", Utils.yCfgTeam));
                       p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 2, 2);
                   }else if(Utils.blau.contains(p.getUniqueId())){
                       p.teleport(Factory.getConfigLocation("Team.Blau", Utils.yCfgTeam));
                       p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 2, 2);
                   }else if(Utils.Lila.contains(p.getUniqueId())){
                       p.teleport(Factory.getConfigLocation("Team.Lila", Utils.yCfgTeam));
                       p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 2, 2);
                   }
                  Warppowder.list.remove(p.getName());
                }
            }, 60L);
        }
    }
    
    private void spawnEffect() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(bedwars.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                try {
                    if (Warppowder.list.size() != 0) {
                        for (final String all : Warppowder.list) {
                            final Player a = Bukkit.getPlayer(all);
                            a.getWorld().playEffect(a.getLocation(), Effect.LAVADRIP, 1);
                            a.getWorld().playEffect(a.getLocation(), Effect.LAVADRIP, 1);
                            a.getWorld().playEffect(a.getLocation(), Effect.LAVADRIP, 1);
                            a.getWorld().playEffect(a.getLocation(), Effect.LAVADRIP, 1);
                        }
                    }
                }catch (Exception ex) {ex.printStackTrace();}
            }
        }, 0L, 10L);
    }

    @EventHandler
    public void PlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if ((e.getFrom().getX() != e.getTo().getX() || e.getFrom().getZ() != e.getTo().getZ()) && Warppowder.list.contains(p.getName())) {
            this.i.cancel();
            p.sendMessage(String.valueOf(Utils.prefix + "§7Teleportvorgang §cabgebrochen§7, bewege dich bitte nicht!"));
            Warppowder.list.remove(p.getName());
            p.getInventory().addItem(ItemFactory.createItem(Material.getMaterial(289), 0, 1, "§8» §7Warp Powder", false));
        }
    }
}
