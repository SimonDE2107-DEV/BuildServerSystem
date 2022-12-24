package de.simon.buildserversystem.command;

import de.simon.buildserversystem.BuildServerSystem;
import de.simon.buildserversystem.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;


public class blocksCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(BuildServerSystem.ONLY_INGAME);
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("buildserversystem.blocks")) {
            if (args.length == 0) {
                Inventory inventory = Bukkit.createInventory(null, 1 * 9, "§cBlocks");
                inventory.addItem(new ItemBuilder(Material.SPAWNER, 1, "").build());
                inventory.addItem(new ItemBuilder(Material.DRAGON_EGG, 1, "").build());
                inventory.addItem(new ItemBuilder(Material.BARRIER, 1, "").build());
                inventory.addItem(new ItemBuilder(Material.LIGHT, 1, "").build());
                inventory.addItem(new ItemBuilder(Material.STRUCTURE_VOID, 1, "").build());
                player.openInventory(inventory);
            } else {
                player.sendMessage(BuildServerSystem.USAGE + "/blocks");
            }
        } else {
            player.sendMessage(BuildServerSystem.NO_PERMISSIONS);
        }
        return true;
    }
}