package live.jansadownik.enderbow.commands;

import live.jansadownik.enderbow.items.ItemEnderBow;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EnderBowCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("enderbow")) {
            Player p;
            if (commandSender instanceof Player) {
                p = (Player) commandSender;
            } else { // sender is console
                if (args != null) {
                    p = Bukkit.getPlayerExact(args[0]);
                    if (p == null) return true; // player offline/no player
                } else {
                    commandSender.sendMessage("Usage: /enderbow [player]"); // no player provided
                    return true;
                }
            }

            ItemStack enderBow = new ItemEnderBow().getEnderBow();
            p.getInventory().addItem(enderBow);
            return true;
        }
        return false;
    }
}
