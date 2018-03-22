/*
 * Copyright (c) 2017 - 2018 Dominik L., Rufus Maiwald and the MC ONE Minecraftnetwork. All rights reserved
 * You are not allowed to decompile the code
 *
 */

package eu.mcone.bedwars.shop;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ShopClick implements Listener {

    @EventHandler
    public void InventotyClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals("§7▶ §bShop")) {
            e.setCancelled(true);

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Blöcke")) {
                Shopmanager.openShopBlöcke(p);
            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §2Spitzhacke")) {
                e.setCancelled(true);
                Shopmanager.openShopSpitzhacke(p);

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §cSchwerter")) {
                e.setCancelled(true);
                Shopmanager.openShopSchwert(p);

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §9Rüstung")) {
                e.setCancelled(true);
                Shopmanager.openShopRüstung(p);

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §eBogen")) {
                e.setCancelled(true);
                Shopmanager.openShopBogen(p);

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                e.setCancelled(true);
                Shopmanager.openShopKisten(p);

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §bEssen")) {
                e.setCancelled(true);
                Shopmanager.openShopEssen(p);

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §5Tränke")) {
                e.setCancelled(true);
                Shopmanager.openShopTränke(p);

            } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §3Spezial")) {
                e.setCancelled(true);
                Shopmanager.openShopSpezial(p);
            }
        }

        /*
         * Inventory: Blöcke
         */
        if (e.getCurrentItem() != null) {
            if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §2Spitzhacke")) {
                    Shopmanager.openShopSpitzhacke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §cSchwerter")) {
                    Shopmanager.openShopSchwert(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §9Rüstung")) {
                    Shopmanager.openShopRüstung(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §eBogen")) {
                    Shopmanager.openShopBogen(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §5Tränke")) {
                    Shopmanager.openShopTränke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §3Spezial")) {
                    Shopmanager.openShopSpezial(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Blöcke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §bEssen")) {
                    Shopmanager.openShopEssen(p);
                }
            }

            /*
             * Spitzhacken
             */

            if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Blöcke")) {
                    Shopmanager.openShopBlöcke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §cSchwerter")) {
                    Shopmanager.openShopSchwert(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §9Rüstung")) {
                    Shopmanager.openShopRüstung(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §eBogen")) {
                    Shopmanager.openShopBogen(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §5Tränke")) {
                    Shopmanager.openShopTränke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §3Spezial")) {
                    Shopmanager.openShopSpezial(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §2Spitzhacke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §bEssen")) {
                    Shopmanager.openShopEssen(p);
                }
            }

            /*
             * Schwerter
             */

            if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §2Spitzhacke")) {
                    Shopmanager.openShopSpitzhacke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Blöcke")) {
                    Shopmanager.openShopBlöcke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §9Rüstung")) {
                    Shopmanager.openShopRüstung(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §eBogen")) {
                    Shopmanager.openShopBogen(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §5Tränke")) {
                    Shopmanager.openShopTränke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §3Spezial")) {
                    Shopmanager.openShopSpezial(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §cSchwerter")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §bEssen")) {
                    Shopmanager.openShopEssen(p);
                }
            }

            /*
             * Rüstung
             */

            if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §2Spitzhacke")) {
                    Shopmanager.openShopSpitzhacke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §cSchwerter")) {
                    Shopmanager.openShopSchwert(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Blöcke")) {
                    Shopmanager.openShopBlöcke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §eBogen")) {
                    Shopmanager.openShopBogen(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §5Tränke")) {
                    Shopmanager.openShopTränke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §3Spezial")) {
                    Shopmanager.openShopSpezial(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §9Rüstung")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §bEssen")) {
                    Shopmanager.openShopEssen(p);
                }
            }

            /*
             * Bogen
             */

            if (e.getInventory().getName().equals("§7▶ §eBogen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §2Spitzhacke")) {
                    Shopmanager.openShopSpitzhacke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §eBogen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §cSchwerter")) {
                    Shopmanager.openShopSchwert(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §eBogen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §9Rüstung")) {
                    Shopmanager.openShopRüstung(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §eBogen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Blöcke")) {
                    Shopmanager.openShopBlöcke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §eBogen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §eBogen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §5Tränke")) {
                    Shopmanager.openShopTränke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §eBogen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §3Spezial")) {
                    Shopmanager.openShopSpezial(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §eBogen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §eBogen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §bEssen")) {
                    Shopmanager.openShopEssen(p);
                }
            }

            /*
             * Kisten
             */

            if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §2Spitzhacke")) {
                    Shopmanager.openShopSpitzhacke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §cSchwerter")) {
                    Shopmanager.openShopSchwert(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §9Rüstung")) {
                    Shopmanager.openShopRüstung(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §eBogen")) {
                    Shopmanager.openShopBogen(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Blöcke")) {
                    Shopmanager.openShopBlöcke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §5Tränke")) {
                    Shopmanager.openShopTränke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §3Spezial")) {
                    Shopmanager.openShopSpezial(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §6Kisten")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §bEssen")) {
                    Shopmanager.openShopEssen(p);
                }
            }

            /*
             * Essen
             */

            if (e.getInventory().getName().equals("§7▶ §bEssen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §2Spitzhacke")) {
                    Shopmanager.openShopSpitzhacke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §bEssen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §cSchwerter")) {
                    Shopmanager.openShopSchwert(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §bEssen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §9Rüstung")) {
                    Shopmanager.openShopRüstung(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §bEssen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §eBogen")) {
                    Shopmanager.openShopBogen(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §bEssen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §bEssen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §5Tränke")) {
                    Shopmanager.openShopTränke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §bEssen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §3Spezial")) {
                    Shopmanager.openShopSpezial(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §bEssen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §bEssen")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Blöcke")) {
                    Shopmanager.openShopBlöcke(p);
                }
            }

            /*
             * Tränke
             */

            if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §2Spitzhacke")) {
                    Shopmanager.openShopSpitzhacke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §cSchwerter")) {
                    Shopmanager.openShopSchwert(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §9Rüstung")) {
                    Shopmanager.openShopRüstung(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §eBogen")) {
                    Shopmanager.openShopBogen(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Blöcke")) {
                    Shopmanager.openShopBlöcke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §3Spezial")) {
                    Shopmanager.openShopSpezial(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §5Tränke")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §bEssen")) {
                    Shopmanager.openShopEssen(p);
                }
            }

            /*
             *Spezial
             */

            if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §2Spitzhacke")) {
                    Shopmanager.openShopSpitzhacke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §cSchwerter")) {
                    Shopmanager.openShopSchwert(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §9Rüstung")) {
                    Shopmanager.openShopRüstung(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §eBogen")) {
                    Shopmanager.openShopBogen(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §5Tränke")) {
                    Shopmanager.openShopTränke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Blöcke")) {
                    Shopmanager.openShopBlöcke(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §6Kisten")) {
                    Shopmanager.openShopKisten(p);
                }
            }

            if (e.getInventory().getName().equals("§7▶ §3Spezial")) {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7▶ §bEssen")) {
                    Shopmanager.openShopEssen(p);
                }
            }
        }
    }

}
