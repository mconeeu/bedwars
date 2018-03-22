/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.gamestate;

import eu.mcone.bedwars.main.bedwars;
import eu.mcone.bedwars.countdown.Lobbycountdown;

public class Lobbystate extends Gamestate{

	public static final int MIN_PLAYERS = bedwars.cfgSetup.getInt("Bedwars-Lobby-Size-Min");
	public static final int MAX_PLAYERS = bedwars.cfgSetup.getInt("Bedwars-Lobby-Size-Max");
	
	private Lobbycountdown countdown;
	
	@Override
	public void init() {
		countdown = new Lobbycountdown();
	}

	@Override
	public void end() {}
	
	public Lobbycountdown getCountdown(){
		return countdown;
	}
}
