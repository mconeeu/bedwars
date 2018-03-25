/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.spawner;

import eu.mcone.bedwars.api.Particle;
import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Utils;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpawnerIron extends Spawner {

    private int ThreadID;

    @Override
    public void start() {
        ThreadID = Bukkit.getScheduler().scheduleSyncRepeatingTask(bedwars.getPlugin(), SpawnerIron::run, 10, bedwars.cfgSetup.getInt("Bedwars-Spawner-Eisen"));
    }

    private static void run() {
        int i = 1;
        if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {
            while (i <= 6) {
                try {
                    if (i == 6) {
                        i = 1;
                        break;
                    } else {
                        if (!(Factory.isLocationNull("Spawner.iron." + i, Utils.yCfgSpawner))) {
                            Location loc = Factory.getConfigLocation("Spawner.iron." + i, Utils.yCfgSpawner);
                            loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.IRON_INGOT));

                            for (Player all : Bukkit.getOnlinePlayers()) {
                                Particle test = new Particle(EnumParticle.SPELL_WITCH, loc, 2, 2, 2, 5, 100);
                                test.sendToAll(all);
                            }
                        }
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                i++;
            }
        }
    }

    @Override
    public void end() {
        if(ThreadID != 0) {
            Bukkit.getScheduler().cancelTask(ThreadID);
        } else {
            System.err.println("Can't not Cancel Thread Spawner Iron!");
        }
    }

    @Override
    public int getThread() {
        return ThreadID;
    }
}
