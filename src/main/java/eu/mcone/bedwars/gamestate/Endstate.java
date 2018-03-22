/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.gamestate;

import eu.mcone.bedwars.countdown.Endcountdown;

public class Endstate extends Gamestate{

	private Endcountdown countdown;
	
	@Override
	public void init() {
		countdown = new Endcountdown();
	}

	@Override
	public void end() {}
	
	public Endcountdown getCountdown(){
		return countdown;
	}
}
