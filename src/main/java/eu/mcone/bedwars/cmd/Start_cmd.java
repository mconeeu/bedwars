/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */


package eu.mcone.bedwars.cmd;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.methods.Messenger;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Start_cmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            Messenger.sendNotUsingConsole();
            return false;
        }

        Player p = (Player) sender;
        if (p.hasPermission("system.bedwars.start") || p.hasPermission("system.bedwars.*") || p.hasPermission("system.*")) {
            if (cmd.getName().equalsIgnoreCase("start")) {
                    if (args.length == 0) {

                        if (Gamestatehandler.getCurrentState() instanceof Lobbystate) {
                            Lobbystate ls = (Lobbystate) Gamestatehandler.getCurrentState();
                            if (ls.getCountdown().getSeconds() > 5) {
                                ls.getCountdown().setSeconds(5);
                                p.sendMessage(Utils.prefix + "§7Der Spielstart wurde §fbeschleunigt");
                                return false;
                            } else {
                                p.sendMessage(Utils.prefix + "§cDas Spiel startet bereits");
                                return true;
                            }

                        } else {
                            p.sendMessage(Utils.prefix + "§7Du kannst den Countdown nur in der Lobby phase verkürzen!");
                            return false;
                        }

                    } else {
                        p.sendMessage(Utils.prefix + "§cBitte benutze: /start");
                        return false;
                    }
                }
        } else { Messenger.sendNoPerms(p); }
        return false;
    }

}
