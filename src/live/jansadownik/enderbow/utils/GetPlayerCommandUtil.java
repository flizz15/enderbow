package live.jansadownik.enderbow.utils;

import live.jansadownik.enderbow.EnderBow;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetPlayerCommandUtil {
    EnderBow plugin;

    CommandSender sender;
    String[] args;

    private String warning = "";
    private Player p = null;

    public GetPlayerCommandUtil(EnderBow plugin, CommandSender sender, String[] args) {
        this.plugin = plugin;

        this.sender = sender;
        this.args = args;
    }

    public Player getPlayer() {
        if (args.length == 0)
            if (getCommandExecutor().equals("player")) {
                p = (Player) sender;
            } else {
                warning = plugin.getConfig().getString("messages.CommandTypePlayerName");
            }
        else {
            p = Bukkit.getPlayerExact(args[0]);
            if (p == null) warning = plugin.getConfig().getString("messages.CommandNoSuchPlayer");
        }
        return p;
    }

    public String getWarning() {
        return warning;
    }

    public String getCommandExecutor() {
        if (sender instanceof Player)
            return "player";
        else
            return "console";
    }
}
