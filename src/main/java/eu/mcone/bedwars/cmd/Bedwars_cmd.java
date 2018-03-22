/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */


package eu.mcone.bedwars.cmd;

import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.methods.Messenger;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bedwars_cmd implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;

			if(p.hasPermission("system.bedwars.sendhelp") || p.hasPermission("system.bedwars.*")) {
				if(args[0].equalsIgnoreCase("set")) {
					Messenger.sendBedwarsHelp(p);
				} else if(args[0].equalsIgnoreCase("info")){
					Messenger.sendSimpleMessage(p, "");
					Messenger.sendSimpleMessage(p,"§7§m ------§c§lBedwars§7§m------");
					Messenger.sendSimpleMessage(p,"§7Entwickelt von TwinsterHD und Rufi");
					Messenger.sendSimpleMessage(p,"§7Dieses Plugin befindet sich noch in der Beta Phase.");
					Messenger.sendSimpleMessage(p,"§7Soltten irgendwelche Bugs oder Fehler auftreten melde diese bitte dem McOne.eu Team.");
					Messenger.sendSimpleMessage(p,"§7§lCurrent V. " + bedwars.getPlugin().getDescription().getVersion() + " §7§lBeta");
					Messenger.sendSimpleMessage(p,"§7§m ------§c§lBedwars§7§m------");
					Messenger.sendSimpleMessage(p, "");
				} else {
					Messenger.sendSimpleMessage(p, "§7Bitte benutze /bw <set/info>");
				}
			} else {
				p.sendMessage(Utils.prefix + "§7§m ------§c§lBedwars§7§m------");
				p.sendMessage("§8» §7Entwickelt von TwinsterHD und Rufi");
				p.sendMessage("§8» §7Dieses Plugin befindet sich noch in der Beta Phase.");
				p.sendMessage("§8» §7Soltten irgendwelche Bugs oder Fehler auftreten melde diese bitte dem McOne.eu Team.");
				p.sendMessage("§8» §7§lV. " + bedwars.getPlugin().getDescription().getVersion() + " §7§lBeta");
				p.sendMessage(Utils.prefix + "§7§m ------§c§lBedwars§7§m------");
			}
		}else { Messenger.sendNotUsingConsole(); }
		return false;
	}

}
