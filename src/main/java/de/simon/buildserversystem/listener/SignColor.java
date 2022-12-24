package de.simon.buildserversystem.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignColor implements Listener {

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        String[] lines = event.getLines();
        for (int i = 0; i <= 3; i++)
            event.setLine(i, ChatColor.translateAlternateColorCodes('&', lines[i]));
    }
}
