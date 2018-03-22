/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.gamestate;

public abstract class Gamestate {

	public static final int LOBBY_STATE = 0;
	public static final int INGAME_STATE = 1;
	public static final int END_STATE = 2;
	
	public abstract void init();
	public abstract void end();
	
}