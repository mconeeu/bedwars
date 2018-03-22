package eu.mcone.bedwars.listener;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Ingamestate;
import eu.mcone.bedwars.methods.Utils;
import eu.mcone.coresystem.bukkit.player.CorePlayer;
import eu.mcone.coresystem.bukkit.scoreboard.Scoreboard;
import eu.mcone.coresystem.lib.util.RandomString;
import org.bukkit.scoreboard.Team;

public class Tablist extends Scoreboard {

    @Override
    public void setPlayerTeams(CorePlayer p, org.bukkit.scoreboard.Scoreboard sb) {
        if (Gamestatehandler.getCurrentState() instanceof Ingamestate) {
            if (Utils.blau.contains(p.getUuid())) {
                Team t = sb.registerNewTeam(100 + new RandomString(6).nextString());
                t.setPrefix("§8[§9Blau§8] §7");
                t.addEntry(!p.isNicked() ? p.getName() : p.getNickname());
            } else if (Utils.rot.contains(p.getUuid())) {
                Team t = sb.registerNewTeam(200 + new RandomString(6).nextString());
                t.setPrefix("§8[§cRot§8] §7");
                t.addEntry(!p.isNicked() ? p.getName() : p.getNickname());
            } else if( Utils.gelb.contains(p.getUuid())) {
                Team t = sb.registerNewTeam(300 + new RandomString(6).nextString());
                t.setPrefix("§8[§eGelb§8] §7");
                t.addEntry(!p.isNicked() ? p.getName() : p.getNickname());
            } else if(Utils.Lila.contains(p.getUuid())){
                Team t = sb.registerNewTeam(400 + new RandomString(6).nextString());
                t.setPrefix("§8[§5Lila§8] §7");
                t.addEntry(!p.isNicked() ? p.getName() : p.getNickname());
            }
        }
    }
}
