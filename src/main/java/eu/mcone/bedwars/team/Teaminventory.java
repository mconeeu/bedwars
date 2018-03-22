/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.team;

import eu.mcone.bedwars.api.Itemmanager;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Teaminventory implements Listener {

	public static ArrayList<UUID> key_blau = new ArrayList<>();
	public static ArrayList<UUID> key_gelb = new ArrayList<>();
	public static ArrayList<UUID> key_lila = new ArrayList<>();
	public static ArrayList<UUID> key_rot = new ArrayList<>();

	public static HashMap<String, Player> blau = new HashMap<>();
	public static HashMap<String, Player> gelb = new HashMap<>();
	public static HashMap<String, Player> lila = new HashMap<>();
	public static HashMap<String, Player> rot = new HashMap<>();

	public static void openInventory(Player p) {

		Inventory inv = Bukkit.createInventory(null, 27, "§f§oWähle dein Team");

		for (int i = 0; i <= 26; i++) {
			inv.setItem(i, Itemmanager.CreateItemwithMaterial(Material.STAINED_GLASS_PANE, 0, 1, "§r", null));
		}

		if (getValueFromKey(blau, "Blau") == null) {
			inv.setItem(10, Itemmanager.CreateItemwithID(35, 11, 1, "§3Blau", "", "§f§oSpieler §8» §7?", ""));
		} else {
			inv.setItem(10, Itemmanager.CreateItemwithID(35, 11, 1, "§3Blau", "",
					"§f§oSpieler §8» §7" + getValueFromKey(blau, "Blau").getName(), ""));
		}

		if (getValueFromKey(rot, "Rot") == null) {
			inv.setItem(12, Itemmanager.CreateItemwithID(35, 14, 1, "§cRot", "", "§f§oSpieler §8» §7?", ""));
		} else {
			inv.setItem(12, Itemmanager.CreateItemwithID(35, 14, 1, "§cRot", "",
					"§f§oSpieler §8» §7" + getValueFromKey(rot, "Rot").getName(), ""));
		}

		if (getValueFromKey(gelb, "Gelb") == null) {
			inv.setItem(14, Itemmanager.CreateItemwithID(35, 4, 1, "§eGelb", "", "§f§oSpieler §8» §7?", ""));
		} else {
			inv.setItem(14, Itemmanager.CreateItemwithID(35, 4, 1, "§eGelb", "",
					"§f§oSpieler §8» §7" + getValueFromKey(gelb, "Gelb").getName(), ""));
		}

		if (getValueFromKey(lila, "Lila") == null) {
			inv.setItem(16, Itemmanager.CreateItemwithID(35, 10, 1, "§5Lila", "", "§f§oSpieler §8» §7?", ""));
		} else {
			inv.setItem(16, Itemmanager.CreateItemwithID(35, 10, 1, "§5Lila", "",
					"§f§oSpieler §8» §7" + getValueFromKey(lila, "Lila").getName(), ""));
		}

		p.openInventory(inv);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
	}

	public static void SetTeam(InventoryClickEvent e, String team) {
		if (e.getClickedInventory().getName().equals("§f§oWähle dein Team")) {
			e.setCancelled(true);

			Player p = (Player) e.getWhoClicked();

			if (key_blau.contains(p.getUniqueId())) {
				/* Blau */
				Utils.playing.remove(p.getPlayer());
				Utils.blau.remove(p.getUniqueId());
				Utils.blauchat.remove(p);
				
				key_blau.remove(p.getUniqueId());
				blau.remove("Blau", p);
				
				System.out.println("remove player: " + p.getName() + " from the blue Array");
				
			} else if (key_rot.contains(p.getUniqueId())) {
				/* Rot */
				Utils.playing.remove(p.getPlayer());
				Utils.rot.remove(p.getUniqueId());
				Utils.rotchat.remove(p);
				
				key_rot.remove(p.getUniqueId());
				rot.remove("Rot", p);
				
				System.out.println("remove player: " + p.getName() + " from the red Array");
				
			} else if (key_gelb.contains(p.getUniqueId())) {
				/* Gelb */
				Utils.playing.remove(p.getPlayer());
				Utils.gelb.remove(p.getUniqueId());
				Utils.gelbchat.remove(p);
				
				key_gelb.remove(p.getUniqueId());
				gelb.remove("Gelb", p);
				
				System.out.println("remove player: " + p.getName() + " from the yellow Array");
				
			} else if (key_lila.contains(p.getUniqueId())) {
				/* Lila */
				Utils.playing.remove(p.getPlayer());
				Utils.Lila.remove(p.getUniqueId());
				Utils.Lilachat.remove(p);
				
				key_lila.remove(p.getUniqueId());
				lila.remove("Lila", p);
			
				System.out.println("remove player: " + p.getName() + " from the purple Array");
				
			}

			setPlayerInArray(team, p);

			if (getValueFromKey(blau, "Blau") == null) {
				e.getClickedInventory().setItem(10,
						Itemmanager.CreateItemwithID(35, 11, 1, "§3Blau", "", "§f§oSpieler §8» §7?", ""));
			} else {
				e.getClickedInventory().setItem(10, Itemmanager.CreateItemwithID(35, 11, 1, "§3Blau", "",
						"§f§oSpieler §8» §7" + getValueFromKey(blau, "Blau").getName(), ""));
			}

			if (getValueFromKey(rot, "Rot") == null) {
				e.getClickedInventory().setItem(12,
						Itemmanager.CreateItemwithID(35, 14, 1, "§cRot", "", "§f§oSpieler §8» §7?", ""));
			} else {
				e.getClickedInventory().setItem(12, Itemmanager.CreateItemwithID(35, 14, 1, "§cRot", "",
						"§f§oSpieler §8» §7" + getValueFromKey(rot, "Rot").getName(), ""));
			}

			if (getValueFromKey(gelb, "Gelb") == null) {
				e.getClickedInventory().setItem(14,
						Itemmanager.CreateItemwithID(35, 4, 1, "§eGelb", "", "§f§oSpieler §8» §7?", ""));
			} else {
				e.getClickedInventory().setItem(14, Itemmanager.CreateItemwithID(35, 4, 1, "§eGelb", "",
						"§f§oSpieler §8» §7" + getValueFromKey(gelb, "Gelb").getName(), ""));
			}

			if (getValueFromKey(lila, "Lila") == null) {
				e.getClickedInventory().setItem(16,
						Itemmanager.CreateItemwithID(35, 10, 1, "§5Lila", "", "§f§oSpieler §8» §7?", ""));
			} else {
				e.getClickedInventory().setItem(16, Itemmanager.CreateItemwithID(35, 10, 1, "§5Lila", "",
						"§f§oSpieler §8» §7" + getValueFromKey(lila, "Lila").getName(), ""));
			}
		}
	}

	private static Player getValueFromKey(HashMap map, String key) {
		if (!(map.get(key) == null)) {
			Player value = (Player) map.get(key);
			return value;
		} else {
			return null;
		}
	}

	public static void ClearFromArray(Player p) {
		if (key_blau.contains(p.getUniqueId())) {
			/* Blau */
			Utils.blau.remove(p.getUniqueId());
			Utils.blauchat.remove(p);
			
			key_blau.remove(p.getUniqueId());
			blau.remove("Blau", p);
			
			System.out.println("remove player: " + p.getName() + " from the blue array");
		} else if (key_rot.contains(p.getUniqueId())) {
			/* Rot */
			Utils.rot.remove(p.getUniqueId());
			Utils.rotchat.remove(p);
			
			key_rot.remove(p.getUniqueId());
			rot.remove("Rot", p);
			
			System.out.println("remove player: " + p.getName() + " from the red array");
		} else if (key_gelb.contains(p.getUniqueId())) {
			/* Gelb */
			Utils.gelb.remove(p.getUniqueId());
			Utils.gelbchat.remove(p);
			
			key_gelb.remove(p.getUniqueId());
			gelb.remove("Gelb", p);
			
			System.out.println("remove player: " + p.getName() + " from the yellow array");
		} else if (key_lila.contains(p.getUniqueId())) {
			/* Lila */
			Utils.Lila.remove(p.getUniqueId());
			Utils.Lilachat.remove(p);
			
			key_lila.remove(p.getUniqueId());
			lila.remove("Lila", p);
		
			System.out.println("remove player: " + p.getName() + " from the purple array");
		}
	}

	private static void setPlayerInArray(String team, Player p) {
		if (team.equalsIgnoreCase("Blau") || team.equalsIgnoreCase("blau")) {
			Utils.blau.add(p.getUniqueId());
			Utils.blauchat.add(p);
			
			key_blau.add(p.getUniqueId());
			blau.put("Blau", p);			

			System.out.println("Add Player " + p.getName() + " to the blue array");
		} else if (team.equalsIgnoreCase("Rot") || team.equalsIgnoreCase("rot")) {			
			Utils.rot.add(p.getUniqueId());
			Utils.rotchat.add(p);
			
			key_rot.add(p.getUniqueId());
			rot.put("Rot", p);			

			System.out.println("Add Player " + p.getName() + " to the red array");
		} else if (team.equalsIgnoreCase("Gelb") || team.equalsIgnoreCase("gelb")) { 			
			Utils.gelb.add(p.getUniqueId());
			Utils.gelbchat.add(p);
			
			key_gelb.add(p.getUniqueId());
			gelb.put("Gelb", p);

			System.out.println("Add Player " + p.getName() + " to the yellow array");
		} else if (team.equalsIgnoreCase("Lila") || team.equalsIgnoreCase("lila")) {			
			Utils.Lila.add(p.getUniqueId());
			Utils.Lilachat.add(p);
			
			key_lila.add(p.getUniqueId());
			lila.put("Lila", p);
			
			System.out.println("Add Player " + p.getName() + " to the purple array");
		} else {
			System.out.println("Error");
		}
	}
}
