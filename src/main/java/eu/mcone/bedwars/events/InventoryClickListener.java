/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.events;

import eu.mcone.bedwars.gamestate.Gamestatehandler;
import eu.mcone.bedwars.gamestate.Lobbystate;
import eu.mcone.bedwars.gamevoting.Ressourcevoting;
import eu.mcone.bedwars.gamevoting.Voting_utils;
import eu.mcone.bedwars.tempkits.Tempkits;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener{

    @EventHandler
    public void InventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null) {
            System.out.println("Item == null");
            return;
        }

        if(Gamestatehandler.getCurrentState() instanceof Lobbystate) {
            /* Interact method for the Tempkits Inventory */
            Tempkits.kitinventoryinteract(p, e);

            /* InventoryClick method for the Ressource Voting Inventory  */
            Ressourcevoting.RegisterRessourceInventory(p, e);

            if(e.getClickedInventory().getName().equals("§f§oVoting")) {
                e.setCancelled(true);
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§eRessource Voting")) {
                    Ressourcevoting.createRessourceVotingInv(p);
                }
            } else if(e.getClickedInventory().getName().equals("§f§oRessource Voting"))   {
                if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§czurück")) {
                    Voting_utils.Createvotinginv(p);
                }
            }
        }
    }
}
