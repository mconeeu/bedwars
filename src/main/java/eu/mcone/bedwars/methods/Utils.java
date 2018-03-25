/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.methods;

import eu.mcone.bedwars.cmd.*;
import eu.mcone.bedwars.events.*;
import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.shop.*;
import eu.mcone.bedwars.team.Teaminventory;
import eu.mcone.bedwars.team.Teamlistener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Utils {
	public final static String prefix = "§8[§7§l!§8] §cBedwars §8» §7";

	public static ArrayList<Material> acceptedBlocks = new ArrayList<>();
	public static ArrayList<Player> setBorder = new ArrayList<>();

	private static Boolean IsGameReady = true;

	public static ArrayList<Player> playing = new ArrayList<>();
	public static ArrayList<Player> spectating = new ArrayList<>();
	
	public static ArrayList<UUID> rot = new ArrayList<>();
	public static ArrayList<UUID> blau = new ArrayList<>();
	public static ArrayList<UUID> gelb = new ArrayList<>();
	public static ArrayList<UUID> Lila = new ArrayList<>();
	public static ArrayList<UUID> grün = new ArrayList<>();
	public static ArrayList<UUID> Schwarz = new ArrayList<>();
	public static ArrayList<UUID> Gold = new ArrayList<>();
	public static ArrayList<UUID> weiß = new ArrayList<>();

	public static ArrayList<Player> rotchat = new ArrayList<>();
	public static ArrayList<Player> blauchat = new ArrayList<>();
	public static ArrayList<Player> gelbchat = new ArrayList<>();
	public static ArrayList<Player> Lilachat = new ArrayList<>();
	public static ArrayList<Player> grünchat = new ArrayList<>();
	public static ArrayList<Player> Schwarzchat = new ArrayList<>();
	public static ArrayList<Player> Goldchat = new ArrayList<>();
	public static ArrayList<Player> weißchat = new ArrayList<>();

	public static ArrayList<String> SetBedBlau = new ArrayList<>();
	public static ArrayList<String> SetBedRot = new ArrayList<>();
	public static ArrayList<String> SetBedGelb = new ArrayList<>();
	public static ArrayList<String> SetBedLila = new ArrayList<>();
	public static ArrayList<String> SetBedGrün = new ArrayList<>();
	public static ArrayList<String> SetBedSchwarz = new ArrayList<>();
	public static ArrayList<String> SetBedGold = new ArrayList<>();
	public static ArrayList<String> SetBedWeiß = new ArrayList<>();
	
	public static boolean canRespawnRot = true;
	public static boolean canRespawnBlau = true;
	public static boolean canRespawnGelb = true;
	public static boolean canRespawnLila = true;
	public static boolean canRespawnGrün = true;
	public static boolean canRespawnschwarz = true;
	public static boolean canRespawnGold = true;
	public static boolean canRespawnWeiß = true;

	public static File CfgLobby = new File("plugins/MCONE-Bedwars/Spawns/Lobby.yml");
	public static YamlConfiguration yCfgLobby = YamlConfiguration.loadConfiguration(CfgLobby);

	public static File CfgTeam = new File("plugins/MCONE-Bedwars/Spawns/Team.yml");
	public static YamlConfiguration yCfgTeam = YamlConfiguration.loadConfiguration(CfgTeam);

	public static File CfgBed = new File("plugins/MCONE-Bedwars/Spawns/Teambed.yml");
	public static YamlConfiguration yCfgBed = YamlConfiguration.loadConfiguration(CfgBed);

	public static File CfgVillager = new File("plugins/MCONE-Bedwars/Spawns/Villager.yml");
	public static YamlConfiguration yCfgVillager = YamlConfiguration.loadConfiguration(CfgVillager);

	public static File CfgSpawner = new File("plugins/MCONE-Bedwars/Spawns/ItemSpawner.yml");
	public static YamlConfiguration yCfgSpawner = YamlConfiguration.loadConfiguration(CfgSpawner);
	
	public static void init(){
        PluginManager pm = Bukkit.getPluginManager();

		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(bedwars.getPlugin(), "BungeeCord");

		bedwars.getPlugin().getCommand("bw").setExecutor(new Bedwars_cmd());
        bedwars.getPlugin().getCommand("start").setExecutor(new Start_cmd());
		bedwars.getPlugin().getCommand("set").setExecutor(new set_cmd());

		pm.registerEvents(new InventoryClickListener(), bedwars.getPlugin());
		pm.registerEvents(new PlayerRespawnListener(), bedwars.getPlugin());
		pm.registerEvents(new BlockPlaceListener(), bedwars.getPlugin());
		pm.registerEvents(new FoodLevelChangeListener(), bedwars.getPlugin());
		pm.registerEvents(new PlayerMoveListener(), bedwars.getPlugin());
		pm.registerEvents(new BlockBreakListener(), bedwars.getPlugin());
		pm.registerEvents(new EntityDamageListener(), bedwars.getPlugin());
		pm.registerEvents(new PlayerDeathListener(), bedwars.getPlugin());
		pm.registerEvents(new PlayerDropItemListener(), bedwars.getPlugin());
		pm.registerEvents(new PlayerBedEnterListener(), bedwars.getPlugin());
		pm.registerEvents(new ServerListPingListener(), bedwars.getPlugin());
		pm.registerEvents(new BlockBreakListener(), bedwars.getPlugin());
		pm.registerEvents(new PlayerInteractListener(), bedwars.getPlugin());
		pm.registerEvents(new AsyncPlayerChatListener(), bedwars.getPlugin());
		pm.registerEvents(new PlayerInteractEntityListener(), bedwars.getPlugin());
		pm.registerEvents(new ShopClick(), bedwars.getPlugin());
		pm.registerEvents(new Shopmanager(), bedwars.getPlugin());
		pm.registerEvents(new Shopbuy(), bedwars.getPlugin());
		pm.registerEvents(new Rettungsplatform(), bedwars.getPlugin());
		pm.registerEvents(new Warppowder(), bedwars.getPlugin());
		pm.registerEvents(new Brige(), bedwars.getPlugin());
		pm.registerEvents(new PlayerJoinListener(), bedwars.getPlugin());
		pm.registerEvents(new PlayerQuitListener(), bedwars.getPlugin());
		pm.registerEvents(new Teamlistener(), bedwars.getPlugin());

		//Border.worldboarderMap();

		InitacceptedBlocks();
    }
	
	@SuppressWarnings("deprecation")
	public static void SpawnVillager() {
		if(Utils.CfgVillager.exists()) {
			Bukkit.getWorld("world").spawnCreature(Factory.getConfigLocationNoWorld("Villager.1", Utils.yCfgVillager), EntityType.VILLAGER);
			Bukkit.getWorld("world").spawnCreature(Factory.getConfigLocationNoWorld("Villager.2", Utils.yCfgVillager), EntityType.VILLAGER);
			Bukkit.getWorld("world").spawnCreature(Factory.getConfigLocationNoWorld("Villager.3", Utils.yCfgVillager), EntityType.VILLAGER);
			Bukkit.getWorld("world").spawnCreature(Factory.getConfigLocationNoWorld("Villager.4", Utils.yCfgVillager), EntityType.VILLAGER);
			
			IsGameReady = true;
		}else {
			IsGameReady = false;
			
			Bukkit.getConsoleSender().sendMessage("§cEs wurden noch keine Villager spawns Gesetzt");
		}
	}
	
	public static void CheckSystem() {
		GregorianCalendar cal = new GregorianCalendar();
        String time = (cal.get(Calendar.DAY_OF_MONTH)) + "." +
        		(cal.get(Calendar.MONTH)+ 1) + "." +
        		(cal.get(Calendar.YEAR)) + " " +
        		(cal.get(Calendar.HOUR_OF_DAY)) + ":" +
        		(cal.get(Calendar.MINUTE));
        
		System.out.println("----- system information -----");
		System.out.println("system current date: " + time);
		System.out.println("game ID: coming soon");
		System.out.println("playing size: " + playing.size());
		System.out.println("----- system file check -----");		
		System.out.println("lobby cfg exits: " +  Utils.CfgLobby.exists());
		System.out.println("spawner cfg exits: " +  Utils.CfgSpawner.exists());
		System.out.println("teambed cfg exits: " +  Utils.CfgBed.exists());
		System.out.println("team cfg exits: " +  Utils.CfgTeam.exists());
		System.out.println("villager cfg exits: " +  Utils.CfgVillager.exists());
		System.out.println("----- system arraylist check -----");
		System.out.println("blue Array (Chat): " + Utils.blauchat.size());
		System.out.println("red Array (Chat): " + Utils.rotchat.size());
		System.out.println("yellow Array (Chat): " + Utils.gelbchat.size());
		System.out.println("purple Array (Chat): " + Utils.Lilachat.size());
		System.out.println("-----");
		System.out.println("blue Array: " + Utils.blau.size());
		System.out.println("red Array: " + Utils.rot.size());
		System.out.println("yellow Array " + Utils.gelb.size());
		System.out.println("purple Array: " + Utils.Lila.size());
		System.out.println("----- team inventory arraylist check -----");
		System.out.println("blue array (Team_Key): " + Teaminventory.key_blau.size());
		System.out.println("red array (Team_Key): " + Teaminventory.key_rot.size());
		System.out.println("yellow array (Team_Key): " + Teaminventory.key_gelb.size());
		System.out.println("purple array (Team_Key): " + Teaminventory.key_lila.size());
		System.out.println("-----");
		System.out.println("blue array (team): " + Teaminventory.blau.size());
		System.out.println("red array (team): " + Teaminventory.rot.size());
		System.out.println("yellow array (team): " + Teaminventory.gelb.size());
		System.out.println("purple array (team): " + Teaminventory.lila.size());
		System.out.println("----- system check -----");
	}
	
	public static void checkteamsizes() {		
		if(blau.size() == 0) {
			canRespawnBlau = false;
		}
		
		if(rot.size() == 0) {
			canRespawnRot = false;
		}
		
		if(gelb.size() == 0) {
			canRespawnGelb = false;
		}
		
		if(Lila.size() == 0) {
			canRespawnLila = false;
		}
		
		if(grün.size() == 0) {
			canRespawnGrün = false;
		}
		
		if(Schwarz.size() == 0) {
			canRespawnschwarz = false;
		}
		
		if(Gold.size() == 0) {
			canRespawnGold = false;
		}
	}
	
	public static String getKillmessage(Player killer, Player p) {
		/* Check if killer != null */
		if(killer == null) {
			if(Utils.rot.contains(p.getUniqueId())){
				return Utils.prefix + "§c" + p.getName() + "§7 ist gestorben!";
			}else if(Utils.gelb.contains(p.getUniqueId())){
				return Utils.prefix + "§e" + p.getName() + "§7 ist gestorben!";
			}else if(Utils.Lila.contains(p.getUniqueId())){
				return Utils.prefix + "§5" + p.getName() + "§7 ist gestorben!";
			}else if(Utils.blau.contains(p.getUniqueId())){
				return Utils.prefix + "§3" + p.getName() + "§7 ist gestorben!";
			}
		}else {
			
			if(Utils.rot.contains(p.getUniqueId()) && Utils.gelb.contains(killer.getUniqueId())){
    			return Utils.prefix + "§c" + p.getName() + "§7 wurde von §e" + killer.getName() + " §7getötet";
            }else if(Utils.rot.contains(p.getUniqueId()) && Utils.Lila.contains(killer.getUniqueId())){
    			return Utils.prefix + "§e" + p.getName() + "§7 wurde von §5" + killer.getName() + " §7getötet";
            }else if(Utils.rot.contains(p.getUniqueId()) && Utils.blau.contains(killer.getUniqueId())){
    			return Utils.prefix + "§c" + p.getName() + "§7 wurde von §3" + killer.getName() + " §7getötet";
            }else if(Utils.gelb.contains(p.getUniqueId()) && Utils.rot.contains(killer.getUniqueId())){
                return Utils.prefix + "§e" + p.getName() + "§7 wurde von §c" + killer.getName() + " §7getötet";
            }else if(Utils.gelb.contains(p.getUniqueId()) && Utils.Lila.contains(killer.getUniqueId())){
    			return Utils.prefix + "§e" + p.getName() + "§7 wurde von §5" + killer.getName() + " §7getötet";
            }else if(Utils.gelb.contains(p.getUniqueId()) && Utils.blau.contains(killer.getUniqueId())){
    			return Utils.prefix + "§e" + p.getName() + "§7 wurde von §3" + killer.getName() + " §7getötet";
            }else if(Utils.Lila.contains(p.getUniqueId()) && Utils.blau.contains(killer.getUniqueId())){
    			return Utils.prefix + "§5" + p.getName() + "§7 wurde von §3" + killer.getName() + " §7getötet";
            }else if(Utils.Lila.contains(p.getUniqueId()) && Utils.rot.contains(killer.getUniqueId())){
    			return Utils.prefix + "§5" + p.getName() + "§7 wurde von §c" + killer.getName() + " §7getötet";
            }else if(Utils.Lila.contains(p.getUniqueId()) && Utils.gelb.contains(killer.getUniqueId())){
    			return Utils.prefix + "§5" + p.getName() + "§7 wurde von §e" + killer.getName() + " §7getötet";
            }else if(Utils.blau.contains(p.getUniqueId()) && Utils.gelb.contains(killer.getUniqueId())){
    			return Utils.prefix + "§3" + p.getName() + "§7 wurde von §e" + killer.getName() + " §7getötet";
            }else if(Utils.blau.contains(p.getUniqueId()) && Utils.Lila.contains(killer.getUniqueId())){
    			return Utils.prefix + "§3" + p.getName() + "§7 wurde von §5" + killer.getName() + " §7getötet";
            }else if(Utils.blau.contains(p.getUniqueId()) && Utils.rot.contains(killer.getUniqueId())){
    			return Utils.prefix + "§3" + p.getName() + "§7 wurde von §c" + killer.getName() + " §7getötet";
            }else {return Utils.prefix + "§cEs ist ein fehler aufgetreten Bitte kontaktiere einen Admin oder Developer => (TwinsterHD)"; }
			
		}
		
		return null;
	}

	public static void HasTeam() {
		System.out.println("check if all players have a team");
		
		for(Player p : Utils.playing){
			if(!(Lila.contains(p.getUniqueId()) || gelb.contains(p.getUniqueId()) || blau.contains(p.getUniqueId()) || rot.contains(p.getUniqueId()))) {
				if(Lila.size() == 0) {
					Lila.add(p.getUniqueId());
					Lilachat.add(p);
					
					p.sendMessage(prefix + "Du bist nun in Team §5Lila");
					System.out.println("set player " + p.getName() + " team purple");
				}else if(rot.size() == 0) {
	        		rot.add(p.getUniqueId());
	        		rotchat.add(p);
	        		
	        		p.sendMessage(prefix + "Du bist nun in Team §cRot");
	        		System.out.println("set player " + p.getName() + " team red");
	        	}else if(gelb.size() == 0) {
	        		gelb.add(p.getUniqueId());
	        		gelbchat.add(p);
	        		
	        		p.sendMessage(prefix + "Du bist nun in Team §eGelb");
	        		System.out.println("set player " + p.getName() + " team yellow");
	        	}else if(blau.size() == 0) {
	        		blau.add(p.getUniqueId());
	        		blauchat.add(p);
	        		
	        		p.sendMessage(prefix + "Du bist nun in Team §3Blau");
	        		System.out.println("set player " + p.getName() + " team blue");
	        	}
			}	
		}
	}

	private static void InitacceptedBlocks() {
		acceptedBlocks.add(Material.HARD_CLAY);
		acceptedBlocks.add(Material.ENDER_STONE);
		acceptedBlocks.add(Material.GLOWSTONE);
		acceptedBlocks.add(Material.IRON_BLOCK);
		acceptedBlocks.add(Material.GLASS);
		acceptedBlocks.add(Material.TNT);
		acceptedBlocks.add(Material.CHEST);
		acceptedBlocks.add(Material.ENDER_CHEST);
	}

	public static void RemoveEnt(){
		for(Entity ent : Bukkit.getWorld(Factory.getConfigLocation("Lobby", Utils.yCfgLobby).getWorld().getUID()).getEntities()) {
			if(!(ent instanceof Player)) {
				ent.remove();
			}
		}
	}
}
