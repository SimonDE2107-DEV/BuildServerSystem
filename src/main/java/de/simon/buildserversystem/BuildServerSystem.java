package de.simon.buildserversystem;

import de.simon.buildserversystem.command.blocksCommand;
import de.simon.buildserversystem.command.holoCommand;
import de.simon.buildserversystem.command.skullCommand;
import de.simon.buildserversystem.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BuildServerSystem extends JavaPlugin {

    public static String PREFIX = "§6Build§eServer §8✘ §7";
    public static String ERROR = PREFIX + "§4§lERROR§8: §7";
    public static String USAGE = ERROR + "Usage§8: §7";
    public static String NO_PERMISSIONS = ERROR + "You aren't allowed to use this command.";
    public static String ONLY_INGAME = ERROR + "This command is only usable ingame";

    public static BuildServerSystem plugin;

    @Override
    public void onEnable() {
        plugin = this;
        registerCommand();
        registeListener();
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    void registerCommand () {
        getCommand("blocks").setExecutor(new blocksCommand());
        getCommand("holo").setExecutor(new holoCommand());
        getCommand("skull").setExecutor(new skullCommand());
    }

    void registeListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new AntiMobSpawn(), this);
        pluginManager.registerEvents(new JoinQuit(), this);
        pluginManager.registerEvents(new NoWeatherChange(), this);
        pluginManager.registerEvents(new NoWheatDestroy(), this);
        pluginManager.registerEvents(new SignColor(), this);
    }
}
