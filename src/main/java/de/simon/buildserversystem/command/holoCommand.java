package de.simon.buildserversystem.command;

import de.simon.buildserversystem.BuildServerSystem;
import de.simon.buildserversystem.util.HologramManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class holoCommand implements CommandExecutor {

    private String usage = BuildServerSystem.USAGE + "/holo remove || /holo create [text ...]";


    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(BuildServerSystem.ONLY_INGAME);
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("buildserversystem.holo")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("remove")) {
                    HologramManager.deleteHolo();
                } else {
                    player.sendMessage(this.usage);
                }
            } else if (args.length >= 2) {
                if (args[0].equalsIgnoreCase("create")) {
                    String text = "";
                    for (int i = 1; i < args.length; i++) {
                        text = text + " " + args[i];
                    }
                    text = text.replaceFirst(" ", "");
                    text = text.replace('&', '§');
                    Location loc = player.getLocation().subtract(0.0D, 1.0D, 0.0D);
                    new HologramManager(loc, text);
                    HologramManager.spawnHolo();
                } else {
                    player.sendMessage(this.usage);
                }
            } else {
                player.sendMessage(this.usage);
            }
        } else {
            player.sendMessage(BuildServerSystem.NO_PERMISSIONS);
        }
        return true;
    }
}