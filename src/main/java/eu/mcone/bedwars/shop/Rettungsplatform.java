/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.shop;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.main.bedwars;
import org.bukkit.*;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;

public class Rettungsplatform implements Listener {

    public static ArrayList<Player> schutz = new ArrayList<>();

    @EventHandler
    public void PlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {
            if (p.getItemInHand().getType() == Material.BLAZE_ROD && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                if (p.getItemInHand().getAmount() == 1) {
                    p.getInventory().remove(p.getItemInHand());
                }
                p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);

                final Location loc_1 = p.getLocation().add(0.0, -1.0, 0.0);
                final Location loc_2 = p.getLocation().add(1.0, -1.0, 0.0);
                final Location loc_3 = p.getLocation().add(-1.0, -1.0, 0.0);

                final Location loc_4 = p.getLocation().add(0.0, -1.0, 1.0);
                final Location loc_5 = p.getLocation().add(0.0, -1.0, -1.0);

                final Location loc_6 = p.getLocation().add(1.0, -1.0, 1.0);
                final Location loc_7 = p.getLocation().add(-1.0, -1.0, -1.0);

                final Location loc_8 = p.getLocation().add(-1.0, -1.0, 1.0);
                final Location loc_9 = p.getLocation().add(1.0, -1.0, -1.0);


                loc_1.getBlock().setType(Material.SLIME_BLOCK);
                loc_2.getBlock().setType(Material.SLIME_BLOCK);
                loc_3.getBlock().setType(Material.SLIME_BLOCK);
                loc_4.getBlock().setType(Material.SLIME_BLOCK);
                loc_5.getBlock().setType(Material.SLIME_BLOCK);
                loc_6.getBlock().setType(Material.SLIME_BLOCK);
                loc_7.getBlock().setType(Material.SLIME_BLOCK);
                loc_8.getBlock().setType(Material.SLIME_BLOCK);
                loc_9.getBlock().setType(Material.SLIME_BLOCK);

                Firework f = (Firework) e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);

                FireworkMeta fm = f.getFireworkMeta();
                fm.addEffect(FireworkEffect.builder()
                        .flicker(false)
                        .trail(true)
                        .with(Type.STAR)
                        .withColor(Color.GREEN, Color.WHITE)
                        .withFade(Color.LIME)
                        .build());
                fm.setPower(3);
                f.setFireworkMeta(fm);

                Rettungsplatform.schutz.add(p);
                Bukkit.getScheduler().scheduleSyncDelayedTask(bedwars.getInstance(), (Runnable) new Runnable() {
                    @Override
                    public void run() {
                        Rettungsplatform.schutz.remove(p);
                    }
                }, 30L);
            }
        }
    }
}
