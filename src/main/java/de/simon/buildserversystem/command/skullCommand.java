package de.simon.buildserversystem.command;

import de.simon.buildserversystem.BuildServerSystem;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class skullCommand implements CommandExecutor, Listener {
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(BuildServerSystem.ONLY_INGAME);
            return false;
        }
        Player player = (Player) sender;
        if (player.hasPermission("buildserversystem.skull")) {
            if (args.length == 1) {
                ItemStack item = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
                skullMeta.setOwner(args[0]);
                item.setItemMeta(skullMeta);

                player.playSound(player.getLocation(), Sound.ENTITY_SKELETON_DEATH, 3.0F, 2.0F);
                player.getInventory().addItem(item);
            } else {
                player.sendMessage(BuildServerSystem.USAGE + "/skull [Player]");
            }
        } else {
            player.sendMessage(BuildServerSystem.NO_PERMISSIONS);
        }
        return true;
    }
}