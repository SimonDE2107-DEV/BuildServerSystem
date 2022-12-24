package de.simon.buildserversystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class NoWeatherChange implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        //  Returns: true if the weather is being set to raining, false otherwise
        if (!event.toWeatherState()) {
            return;
        }
        event.setCancelled(true);
        event.getWorld().setWeatherDuration(0);
        event.getWorld().setThundering(false);
    }
}
