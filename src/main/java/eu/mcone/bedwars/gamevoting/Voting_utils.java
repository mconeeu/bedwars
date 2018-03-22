/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.gamevoting;

import eu.mcone.bedwars.api.Itemmanager;
import eu.mcone.coresystem.bukkit.util.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Voting_utils {	
	
	public static HashMap<UUID, Integer> Gold = new HashMap<>();
	public static HashMap<UUID, Integer> No_Gold = new HashMap<>();
	
	/* True = Mit Gold, false = Ohne Gold */
	public static Boolean ressource = null;
	
	/* Unused */
//	public static ArrayList<Integer> Ressourcen_yesiron = new ArrayList<>();
//	public static ArrayList<Integer> Ressourcen_noiron = new ArrayList<>();

	public static void Createvotinginv(Player p) {
		Inventory inv = Bukkit.createInventory(null, 45, "§f§oVoting");

		for (int i = 0; i <= 44; i++) {
			inv.setItem(i, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 7, 1, "§8//MCONE//", false));
		}

		/* Coming soon */
		ArrayList<String> coming_soon = new ArrayList<>();
		coming_soon.add("§7Dieses feature ist noch in Arbeit");

		/* Ressource beschreibung */
		ArrayList<String> ressource_lore = new ArrayList<>();
		ressource_lore.add("§7Hier kannst du darüber abstimmen,");
		ressource_lore.add("§7ob in der Runde §6Gold §aAKTIVIERT! §7oder §cDEAKTIVIERT §7sein soll.");

		/* Inventar beschreibung */
		ArrayList<String> beschreibung_lore = new ArrayList<>();
		beschreibung_lore.add("§7Hier kannst du darüber abstimmen");
		beschreibung_lore.add("§7welche features in der Bedwars Runde,");
		beschreibung_lore.add("§aAKTIVIERT §7oder §cDEAKTIVIERT §7sein sollen.");
		beschreibung_lore.add("");
		beschreibung_lore.add("§7Es gibt diese Voting Kategorien:");
		beschreibung_lore.add("  §8» §7Ressourcen Voting");
		beschreibung_lore.add("  §8» §7Map Voting (In Arbeit)");
		beschreibung_lore.add("");
		beschreibung_lore.add("§6Hast du selbst noch ideen für eine Voting Kategorie?");
		beschreibung_lore.add("§6wenn ja, dann kannst du uns diese einfach,");
		beschreibung_lore.add("§6auf unserem TS oder auf mcone.eu mitteilen.");

		/* Seitenleiste */
		inv.setItem(0, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 0, 1, "§8//MCONE//", false));
		inv.setItem(9, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 0, 1, "§8//MCONE//", false));
		inv.setItem(18, ItemFactory.createItem(Material.STAINED_GLASS_PANE, 0, 1, "§8//MCONE//", false));

		inv.setItem(27, ItemFactory.createItem(Material.EMPTY_MAP, 0, 1, "§cComing soon", coming_soon,false));
		inv.setItem(36, ItemFactory.createItem(Material.BOOK, 0, 1, "§eRessource Voting", ressource_lore, false));

		inv.setItem(22, ItemFactory.createItem(Material.EMPTY_MAP, 0, 1, "§cVoting", beschreibung_lore, false));

		p.openInventory(inv);
	}
}
