/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.gamestate;

import java.util.ArrayList;

public class Gamestatehandler {

	private static Gamestate current;
	private static ArrayList<Gamestate> states = new ArrayList<>();
	
	public Gamestatehandler(){
		states.add(new Lobbystate());
		states.add(new Ingamestate());
		states.add(new Endstate());
	}
	
	public static void setGameState(int id){
		if(current != null) current.end();
			current = states.get(id); 
			current.init();
		}
	
	public static Gamestate getCurrentState(){
	    return current;	
	}
}