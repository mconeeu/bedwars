/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.main;

import eu.mcone.bedwars.gamestate.Gamestate;
import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.listener.Worldborder;
import eu.mcone.bedwars.methods.Factory;
import eu.mcone.bedwars.methods.Messenger;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.bedwars.achievements.Achievements;
import eu.mcone.bedwars.spawner.Spawner;
import eu.mcone.coresystem.bukkit.api.CoinsAPI;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class bedwars extends JavaPlugin {

    public static Worldborder wb;
    public static Spawner spawner;
    private static bedwars plugin;

    private static File fConf = new File("plugins/MCONE-Bedwars/Setup", "config.yml");
    public static FileConfiguration cfgConf = YamlConfiguration.loadConfiguration(fConf);

    private static File fSetup = new File("plugins/MCONE-Bedwars/Setup", "setup.yml");
    public static FileConfiguration cfgSetup = YamlConfiguration.loadConfiguration(fSetup);

    public static CoinsAPI coinsapi;

    @Override
    public void onEnable() {
        plugin = this;

        spawner = new Spawner();

        wb = new Worldborder(Factory.getConfigLocation("Lobby", Utils.yCfgLobby), 250);

        /* Create the table `Bedwars-Achievements` */
        Achievements.CreateTableAchievements();

        /* Remove all Entity's */
        Utils.RemoveEnt();

        /* Create new GameStateHandler */
        new Gamestatehandler();

        /* Chance the Gamestate to LobbyState */
        Gamestatehandler.setGameState(Gamestate.LOBBY_STATE);

        /* Create the Config File */
        createConfigFile();

        /* Create the Setup File */
        createSetupFile();

        /* Register all Commands and Events */
        Utils.init();

       Messenger.sendSimpleConsoleMessage("§f§l\n" +
                            "       __  ____________  _  ______\n" +
                            "      /  |/  / ___/ __ \\/ |/ / __/\n" +
                            "     / /|_/ / /__/ /_/ /    / _/  \n" +
                            "    /_/  /_/\\___/\\____/_/|_/___/  \n" +
                            "             ___  _______ _      _____   ___  ____\n" +
                            "            / _ )/ __/ _ \\ | /| / / _ | / _ \\/ __/\n" +
                            "           / _  / _// // / |/ |/ / __ |/ , _/\\ \\  \n" +
                            "          /____/___/____/|__/|__/_/ |_/_/|_/___/  \n" +
                            "    ");

        Messenger.sendSimpleConsoleMessage("§7Plugin Name: §c" + this.getDescription().getName());
        Messenger.sendSimpleConsoleMessage("§7Author: §c" + this.getDescription().getAuthors());
        Messenger.sendSimpleConsoleMessage("§7Version: §c" + this.getDescription().getVersion());

        /* Check all Locations (Lobby, Villager, Item_Spawner, Team, Team_Bed) */
        Utils.checkLocations();
    }

    //Config.yml
    private void createConfigFile() {
        if (!(fConf.exists())) {
            try {
                fConf.createNewFile();
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(Utils.prefix + "§cEs ist ein Fehler beim Erstellen der Config.yml aufgetreten");
                e.printStackTrace();
            }
        }

        cfgConf.options().header(""
                + "Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved" +
                "\nCurrent version: " + this.getDescription().getVersion());
        cfgConf.options().copyDefaults(true);

        //12 Teams
        cfgConf.addDefault("Bedwars-Chat-Lobby-Spielverderber", "&8[&7SV&8] &8Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-Spieler", "&8[&fS&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-Premium", "&8[&6P&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-Premium+", "&8[&6P+&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-YouTuber", "&8[&5YT&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-Team", "&7[&fTeam&7] &7Player &8>> &7Nachrichtt");
        cfgConf.addDefault("Bedwars-Chat-Lobby-JrSupporter", "&8[&aJrSup&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-Moderator", "&8[&2Mod&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-SrModerator", "&8[&2SrMod&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-Supporter", "&8[&aSup&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-Builder", "&8[&eB&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-Developper", "&8[&bDev&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Lobby-Admin", "&8[&cA&8] &7Player &8>> &7Nachricht");

        //8 Teams
        cfgConf.addDefault("Bedwars-Chat-Ingame-Rot", "&8[&cRot&8] &8Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Ingame-Gelb", "&8[&eGelb&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Ingame-Blau", "&8[&3Blau&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Ingame-Lila", "&8[&5Lila&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Ingame-Gruen", "&8[&6&2Grün&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Ingame-Schwarz", "&8[&0Schwarz&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Ingame-Gold", "&7[&6Gold&7] &7Player &8>> &7Nachrichtt");
        cfgConf.addDefault("Bedwars-Chat-Ingame-Grau", "&8[&7Grau&8] &7Player &8>> &7Nachricht");
        cfgConf.addDefault("Bedwars-Chat-Ingame-Weiss", "&8[&fWeiß&8] &7Player &8>> &7Nachricht");
        try {
            cfgConf.save(fConf);
            cfgConf.load(fConf);
        } catch (IOException | InvalidConfigurationException e) {
            Messenger.sendSimpleConsoleMessage("§cEs ist ein Fehler beim Speichern der Config aufgetreten (Config.yml)");
            e.printStackTrace();
        }
    }

    public void loadConfigFile() {
        try {
            FileConfiguration cfg = cfgConf;
            cfg.options().copyDefaults(true);

            cfg.save(fConf);
        } catch (FileNotFoundException e) {
            Messenger.sendSimpleConsoleMessage("§cDas File konnte nicht gefunden werden, §cBitte Lösche die Datei und probiere es erneut (Config.yml)");
            e.printStackTrace();
        } catch (IOException e) {
            Messenger.sendSimpleConsoleMessage("§cEs ist ein Fehler beim Laden der Config aufgetreten (Config.yml)");
            e.printStackTrace();
        }
    }

    //Setup.yml
    private void createSetupFile() {
        if (!(fSetup.exists())) {
            try {
                fSetup.createNewFile();
            } catch (IOException e) {
                Messenger.sendSimpleConsoleMessage("§cEs ist ein Fehler beim Erstellen der Setup.yml aufgetreten");
                e.printStackTrace();
            }
        }

        cfgSetup.options().header(""
                + "Plugin Entwickler: TwinsterHD aka Dominik L."
                + "\nVersion: " + this.getDescription().getVersion()
                + "\nMomnetan nur 4x1 Maps Möglich"
                + "\n"
                + "\nSpawner intervall (scheduler)"
                + "\n20 Bukkit Tick's = 1 Sekunde"
                + "\n20 * 2 = 2 Sekunden"
                + "\n40 = 2 Sekunden"
                + ""
                + "\nBronze = 18 Tick's"
                + "\nEisen = 135 Tick's"
                + "\nGold = 550 Tick's");
        cfgSetup.options().copyDefaults(true);

        cfgSetup.addDefault("Bedwars-World-Name-Map", "world");
        cfgSetup.addDefault("Bedwars-World-Name-Lobby", "world");

        cfgSetup.addDefault("Bedwars-Bordersize-map", 145);

        cfgSetup.addDefault("Bedwars-Lobby-Size-Min", 2);
        cfgSetup.addDefault("Bedwars-Lobby-Size-Max", 4);

        cfgSetup.addDefault("Bedwars-Lobby-Map-Name", "&f&lTest");
        cfgSetup.addDefault("Bedwars-Lobby-Map-Size", "&f&l1&7x&f&l4");

        cfgSetup.addDefault("Bedwars-Spawner-Bronze", 18);
        cfgSetup.addDefault("Bedwars-Spawner-Eisen", 138);
        cfgSetup.addDefault("Bedwars-Spawner-Gold", 550);
        try {

            cfgSetup.save(fSetup);
            cfgSetup.load(fSetup);
        } catch (IOException | InvalidConfigurationException e) {
            Messenger.sendSimpleConsoleMessage( "§cEs ist ein Fehler beim Speichern der Config aufgetreten (Setup.yml)");
            e.printStackTrace();
        }
        saveConfig();
    }

    public void loadSetupFile() {
        try {
            FileConfiguration cfg = cfgSetup;
            cfg.options().copyDefaults(true);

            cfg.save(fSetup);
            //cfg.load(fSetup);
        } catch (FileNotFoundException e) {
            Messenger.sendSimpleConsoleMessage("§cDas File konnte nicht gefunden werden, §cBitte Lösche die Datei und probiere es erneut (Setup.yml)");
            e.printStackTrace();
        } catch (IOException e) {
            Messenger.sendSimpleConsoleMessage("§cEs ist ein Fehler beim Laden der Config aufgetreten (Setup.yml)");
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        spawner.StopAllThreads();

        /* Remove all Entity's */
        Utils.RemoveEnt();

        Messenger.sendSimpleConsoleMessage("§7plugin wurde §cdeaktiviert");
    }

    public static bedwars getPlugin() {

        return plugin;
    }

    public static bedwars getInstance() {
        return plugin;
    }
}
