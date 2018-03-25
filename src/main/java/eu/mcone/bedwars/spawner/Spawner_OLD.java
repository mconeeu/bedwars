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
import org.bukkit.*;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Spawner_OLD implements Listener{

    private static int Gold;
    private static int Iron;
    private static int Bronze;

    public void Spawner(){}

    private Location getConfigLocationNoWorld(String path, YamlConfiguration cfg){
    	
    		double x = cfg.getDouble(path + ".X");
    		double y = cfg.getDouble(path + ".y");
    		double z = cfg.getDouble(path +".Z");
    		
    		return new Location(Bukkit.getWorld(bedwars.cfgSetup.getString("Bedwars-World-Name-Map")), x, y, z);
	}


	private void Gold(){
        Gold = Bukkit.getScheduler().scheduleSyncRepeatingTask(bedwars.getPlugin(), new Runnable(){
            @Override
            public void run() {
                int i = 1;
                if(Gamestatehandler.getCurrentState() instanceof Ingamestate){
                    while (i <= 6) {
                        try{
                        	if(i == 6) {
                        		i = 1;
                        		System.out.println("GoldThread: Reset Integer");
                        		return;
                        	}else {
	                        	if(!(Factory.isLocationNull("Spawner.gold." + i, Utils.yCfgSpawner))){
	                        		for(Player all : Bukkit.getOnlinePlayers()) { 
	                        			all.getWorld().dropItemNaturally(getConfigLocationNoWorld("Spawner.gold." + i, Utils.yCfgSpawner), new ItemStack(Material.GOLD_INGOT));

	                        			Particle test = new Particle(EnumParticle.SPELL_WITCH, getConfigLocationNoWorld("Spawner.gold." + i, Utils.yCfgSpawner), 2, 2, 2, 5, 100);
	                        			test.sendToAll(all);
	                        			
	                        		}
	                           	}else {
	                           		for(Player all : Bukkit.getOnlinePlayers()) {
	                           			all.sendMessage(Utils.prefix + "§cEs ist eine fehler beim Spawnen der Items aufgetreten");
	                           			Bukkit.getConsoleSender().sendMessage(Utils.prefix + "§cEs ist eine fehler beim Spawnen der Items aufgetreten");
	                           		}
	                           		
	                           		StopAllThreads();	                           		
	                           		
	                           		return;
	                           	}
                        	}                        	
                        }catch(Exception e){
                        	e.printStackTrace();
                         }
                        
                        i++;
                    }
                }
           }
        }, 0, bedwars.cfgSetup.getInt("Bedwars-Spawner-Gold"));
    }

	private void Iron(){
        Iron = Bukkit.getScheduler().scheduleSyncRepeatingTask(bedwars.getPlugin(), new Runnable(){
            @Override
            public void run() {
                int i = 1;
                if(Gamestatehandler.getCurrentState() instanceof Ingamestate){
                	while (i <= 6) {
                        try{
                        	if(i == 6) {
                        		i = 1;
                        		System.out.println("IronThread: Reset Integer");
                        		return;
                        	}else {
	                        	if(!(Factory.isLocationNull("Spawner.iron." + i, Utils.yCfgSpawner))){
	                        		for(Player all : Bukkit.getOnlinePlayers()) { 
	                        			all.getWorld().dropItemNaturally(getConfigLocationNoWorld("Spawner.iron." + i, Utils.yCfgSpawner), new ItemStack(Material.IRON_INGOT));

	                        			Particle test = new Particle(EnumParticle.SMOKE_NORMAL, getConfigLocationNoWorld("Spawner.iron." + i, Utils.yCfgSpawner), 1, 1, 1, 1, 20);
	                        			test.sendToAll(all);
	                        			
	                        		}
	                           	} else {
	                           		for(Player all : Bukkit.getOnlinePlayers()) {
	                           			all.sendMessage(Utils.prefix + "§cEs ist eine fehler beim Spawnen der Items aufgetreten");
	                           			Bukkit.getConsoleSender().sendMessage(Utils.prefix + "§cEs ist eine fehler beim Spawnen der Items aufgetreten");
	                           		}
	                           		
	                           		StopAllThreads();	                           		
	                           		
	                           		return;
	                           	}
                        	}                        	
                        }catch(Exception e){
                        	e.printStackTrace();
                         }
                        
                        i++;
                    }
                }
            }
        }, 0, bedwars.cfgSetup.getInt("Bedwars-Spawner-Eisen"));
    }

	private void Bronze(){
        Bronze = Bukkit.getScheduler().scheduleSyncRepeatingTask(bedwars.getPlugin(), new Runnable(){
            @Override
            public void run() {
                int i = 1;
                if(Gamestatehandler.getCurrentState() instanceof Ingamestate){
                	while (i <= 6) {
                        try{
                        	if(i == 6) {
                        		i = 1;
                        		System.out.println("BronzeThread: Reset Integer");
                        		return;
                        	}else {
	                        	if(!(Factory.isLocationNull("Spawner.bronze." + i, Utils.yCfgSpawner))){
	                        		for(Player all : Bukkit.getOnlinePlayers()) { 
	                        			all.getWorld().dropItemNaturally(getConfigLocationNoWorld("Spawner.bronze." + i, Utils.yCfgSpawner), new ItemStack(Material.CLAY_BRICK));

	                        			Particle test = new Particle(EnumParticle.SPELL_WITCH, getConfigLocationNoWorld("Spawner.bronze." + i, Utils.yCfgSpawner), 2, 2, 2, 5, 100);
	                        			test.sendToAll(all);

	                        		}
	                           	} else {
	                           		for(Player all : Bukkit.getOnlinePlayers()) {
	                           			all.sendMessage(Utils.prefix + "§cEs ist eine fehler beim Spawnen der Items aufgetreten");
	                           			Bukkit.getConsoleSender().sendMessage(Utils.prefix + "§cEs ist eine fehler beim Spawnen der Items aufgetreten");
	                           		}
	                           		
	                           		StopAllThreads();	                           		
	                           		
	                           		return;
	                           	}
                        	}                        	
                        }catch(Exception e){
                        	e.printStackTrace();
                         }
                        
                        i++;
                    }
                }
            }
        }, 0, bedwars.cfgSetup.getInt("Bedwars-Spawner-Bronze"));
    }

	public void StartAllThreads() {
    	Gold();
    	Iron();
    	Bronze();
    	System.out.println("Spawner: Start all Threads");
    }

	public void StartBronzeThread() {
    	Bronze();
    	System.out.println("Spawner: Start Bronze Thread");
    }

	public void StartIronThread() {
    	Iron();
    	System.out.println("Spawner: Start Iron Thread");
    }

	public void StartGoldThread() {
    	Gold();
    	System.out.println("Spawner: Start Gold Thread");
    }

	public void StopAllThreads() {
    	Bukkit.getScheduler().cancelTask(Gold);
    	Bukkit.getScheduler().cancelTask(Iron);
    	Bukkit.getScheduler().cancelTask(Bronze);
    	System.out.println("Spawner: KILL all running Threads");
    }

	public void StopThreadGold(){
        Bukkit.getScheduler().cancelTask(Gold);     
        System.out.println("Spawner: KILL Gold Thread");
    }

	public void StopThreadIron() {
    	Bukkit.getScheduler().cancelTask(Iron);  
    	System.out.println("Spawner: KILL Iron Thread");
    }

	public void StopThreadBronze() {
    	Bukkit.getScheduler().cancelTask(Bronze);  
    	System.out.println("Spawner: KILL Bronze Thread");
    }
}
