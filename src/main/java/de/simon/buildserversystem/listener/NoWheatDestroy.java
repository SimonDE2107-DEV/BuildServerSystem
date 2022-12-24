package de.simon.buildserversystem.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class NoWheatDestroy implements Listener {

    @EventHandler
    public void onWheatDestroy(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL && event.getClickedBlock().getType() == Material.LEGACY_SOIL) {
            event.setCancelled(true);
        }
    }
}