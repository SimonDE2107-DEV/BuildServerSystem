package de.simon.buildserversystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class AntiMobSpawn implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void ifCreatureSpawns(CreatureSpawnEvent event) {
        // allow to spawn creatures if they are manually spawned
        if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CHUNK_GEN || event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL) {
            event.setCancelled(true);
        }
    }
}