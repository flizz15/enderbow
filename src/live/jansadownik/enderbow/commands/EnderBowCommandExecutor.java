package live.jansadownik.enderbow.commands;

import live.jansadownik.enderbow.EnderBow;
import live.jansadownik.enderbow.items.ItemEnderBow;
import live.jansadownik.enderbow.utils.GetPlayerCommandUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EnderBowCommandExecutor implements CommandExecutor {
    EnderBow plugin;

    public EnderBowCommandExecutor(EnderBow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("enderbow")) {
            GetPlayerCommandUtil playerValidator = new GetPlayerCommandUtil(plugin, commandSender, args);
            Player p = playerValidator.getPlayer();
            if (p == null) {
                commandSender.sendMessage(playerValidator.getWarning());
                return true;
            }
            if (playerValidator.getCommandExecutor().equals("player")) {
                if (!(p.hasPermission("enderbow.command.enderbow"))) {
                    commandSender.sendMessage(plugin.getConfig().getString("messages.PlayerNotHavePermission"));
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
