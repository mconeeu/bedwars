/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */


package eu.mcone.bedwars.cmd;

import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Messenger;
import eu.mcone.bedwars.methods.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class set_cmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            Messenger.sendNotUsingConsole();
            return false;
        }

        Player p = (Player) sender;

        if (p.hasPermission("bedwars.set") || p.hasPermission("system.bedwars.*") || p.hasPermission("system.*")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("lobby")) {
                    Factory.createConfigLocation(p.getLocation(), "Lobby", Utils.CfgLobby, Utils.yCfgLobby);
                    Messenger.sendSimpleMessage(p, "§7Der Spawn die §fLobby §7wurde gesetzt!");

                } else if (args[0].equalsIgnoreCase("spectator")) {
                    Factory.createConfigLocation(p.getLocation(), "Spectator", Utils.CfgLobby, Utils.yCfgLobby);
                    Messenger.sendSimpleMessage(p, "§7Der Spawn die §fSpectator §7wurde gesetzt!");

                } else if (args[0].equalsIgnoreCase("holo")) {
                    Factory.createConfigLocation(p.getLocation(), "Holo", Utils.CfgLobby, Utils.yCfgLobby);
                    Messenger.sendSimpleMessage(p, "§7Du hast das §fHologramm §7gesetzt!");

                } else {
                    Messenger.sendBedwarsHelp(p);
                }

            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("team")) {
                    if (args[1].equalsIgnoreCase("Blau") || args[1].equalsIgnoreCase("Rot") || args[1].equalsIgnoreCase("Gelb") || args[1].equalsIgnoreCase("Lila")) {
                        Factory.createConfigLocation(p.getLocation(), "Team." + args[1], Utils.CfgTeam, Utils.yCfgTeam);
                        Messenger.sendSimpleMessage(p, "§7Du hast denn Team spawn §c" + args[1] + " §7gesetzt");
                    } else {
                        Messenger.sendSimpleMessage(p, "§cBitte benutze §7/setspawn team <Blau,Rot,Gelb,Lila>");
                    }

                } else if (args[0].equalsIgnoreCase("villager")) {
                    try {
                        int plase = Integer.parseInt(args[0]);
                        Factory.createConfigLocation(p.getLocation(), "Villager." + plase, Utils.CfgVillager, Utils.yCfgVillager);
                        Messenger.sendSimpleMessage(p, "§7Du hast den Villager spawn gesetzt §f" + plase);
                    } catch (NumberFormatException e) {
                        p.sendMessage("§cBitte gib eine gültige Zahl an!");
                    }
                } else {
                    Messenger.sendBedwarsHelp(p);
                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("spawner")) {
                    if (args[1].equalsIgnoreCase("gold") || args[1].equalsIgnoreCase("iron") || args[1].equalsIgnoreCase("bronze")) {
                        try {
                            String spawner_type = args[1].replaceAll("Gold", "gold").replaceAll("Iron", "iron").replaceAll("Bronze", "bronze");
                            int platz = Integer.parseInt(args[2]);

                            Factory.createConfigLocation(p.getLocation(), "Spawner." + spawner_type + "." + platz, Utils.CfgSpawner, Utils.yCfgSpawner);
                            Messenger.sendSimpleMessage(p, "§7Du hast einen §c" + spawner_type + " §7Spawner mit der ID §c" + platz + " §7gesetzt.");

                        } catch (NumberFormatException e) {
                            Messenger.sendSimpleMessage(p, "§cBitte gib eine gültige Zahl an!");
                        }
                    } else {
                        Messenger.sendSimpleMessage(p, "§cBitte benutze /setspawner <gold/iron/bronze> ID");
                    }
                } else if (args[0].equalsIgnoreCase("team")) {
                    if (args[1].equalsIgnoreCase("bed")) {
                        if (args[2].equalsIgnoreCase("close")) {
                            clearFormBedArray(p);

                            Messenger.sendSimpleMessage(p, "§7Du kannst jetzt keine betten mehr setzen");
                        } else if (args[2].equalsIgnoreCase("Blau")) {
                            clearFormBedArray(p);

                            Utils.SetBedBlau.add(p.getName());
                            Messenger.sendSimpleMessage(p, "§7Du kannst jetzt mit einen §fRechtsklick §7auf das Bett die Location setzten (§3Blau§7)");
                        } else if (args[2].equalsIgnoreCase("Rot")) {
                            clearFormBedArray(p);

                            Utils.SetBedRot.add(p.getName());
                            Messenger.sendSimpleMessage(p, "§7Du kannst jetzt mit einen §fRechtsklick §7auf das Bett die Location setzten (§cRot§7)");
                        } else if (args[2].equalsIgnoreCase("Gelb")) {
                            clearFormBedArray(p);

                            Utils.SetBedGelb.add(p.getName());
                            Messenger.sendSimpleMessage(p, "§7Du kannst jetzt mit einen §fRechtsklick §7auf das Bett die Location setzten (§eGelb§7)");
                        } else if (args[2].equalsIgnoreCase("Lila")) {
                            clearFormBedArray(p);
                            Utils.SetBedLila.add(p.getName());
                            Messenger.sendSimpleMessage(p, "§7Du kannst jetzt mit einen §fRechtsklick §7auf das Bett die Location setzten (§5Lila§7)");
                        } else {
                            Messenger.sendBedwarsHelp(p);
                        }

                    } else {
                        Messenger.sendSimpleMessage(p, "§cBitte benutze §7/setspawn team bed <Blau,Rot,Gelb,Lila>");
                    }
                } else {
                    Messenger.sendSimpleMessage(p, "§cBitte benutze §7/setspawn team bed <Blau,Rot,Gelb,Lila>");
                }
            } else {
                Messenger.sendBedwarsHelp(p);
            }

        } else {
            Messenger.sendNoPerms(p);
        }
        return false;
    }

    private void clearFormBedArray(Player p) {
        Utils.SetBedRot.remove(p.getName());
        Utils.SetBedGelb.remove(p.getName());
        Utils.SetBedBlau.remove(p.getName());
        Utils.SetBedLila.remove(p.getName());
    }

}

