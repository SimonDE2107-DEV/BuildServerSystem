package de.simon.buildserversystem.util;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

public class HologramManager {
    static String textString = "";
    static Location loc = null;
    static ArmorStand Hologram = null;

    public HologramManager(Location location, String text) {
        textString = text;
        loc = location;
    }

    public static void spawnHolo() {
        Hologram = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
        Hologram.setCustomName(textString);
        Hologram.setCustomNameVisible(true);
        Hologram.setGravity(false);
        Hologram.setVisible(false);
    }

    public static void deleteHolo() {
        // remove holo only if holo exists
        if (Hologram != null) {
            Hologram.remove();
        }
    }
}