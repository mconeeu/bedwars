/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Messenger {

    public static void sendSimpleMessage(Player p, String msg){ p.sendMessage(Utils.prefix + msg); }

    public static void sendSimpleConsoleMessage(String msg){ Bukkit.getConsoleSender().sendMessage(Utils.prefix + msg); }

    public static void sendBedwarsHelp(Player p){
        sendSimpleMessage(p, "§7§m ------§c§lBedwars§7§m------");
        sendSimpleMessage(p, "§7Bitte benutze: §f/setspawn <Lobby/Spectator/holo>");
        sendSimpleMessage(p, "§7Bitte benutze: §f/setspawn villager <ID>");
        sendSimpleMessage(p, "§7Bitte benutze: §f/setspawn team <Blau,Rot,Gelb,Lila>");
        sendSimpleMessage(p, "§7Bitte benutze: §f/setspawn team bed <Blau,Rot,Gelb,Lila>");
        sendSimpleMessage(p, "§7Bitte benutze: §f/setspawn team bed close");
        sendSimpleMessage(p, "§7Bitte benutze §f/setspawner <gold/iron/bronze> ID");
        sendSimpleMessage(p, "§7§m ------§c§lBedwars§7§m------");
    }

    public static void sendNotUsingConsole(){ sendSimpleConsoleMessage("§cDu musst ein Spieler sein um diesen Befehl ausführen zu können."); }

    public static void sendNoPerms(Player p){ sendSimpleMessage(p, "§cDu haste keine berechtigung für diesen Befehl"); }

    public static void sendWarnToConsole(String msg) { System.err.print(msg); }
}
