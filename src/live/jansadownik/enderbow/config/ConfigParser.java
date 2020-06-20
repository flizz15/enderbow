package live.jansadownik.enderbow.config;

import live.jansadownik.enderbow.EnderBow;

public class ConfigParser {
    String CommandNoSuchPlayer = "No such player on the server";
    String CommandTypePlayerName = "Type targeted Player name!";
    String PlayerNotHavePermission = "You don't have permission!";
    String PlayerNotHaveEnderPearl = "You don't have ender pearl!";

    EnderBow plugin;

    public ConfigParser(EnderBow plugin) {
        this.plugin = plugin;
    }

    public void setupConfig() {
        plugin.getConfig().addDefault("messages.CommandNoSuchPlayer", CommandNoSuchPlayer);
        plugin.getConfig().addDefault("messages.CommandTypePlayerName", CommandTypePlayerName);
        plugin.getConfig().addDefault("messages.PlayerNotHavePermission", PlayerNotHavePermission);
        plugin.getConfig().addDefault("messages.PlayerNotHaveEnderPearl", PlayerNotHaveEnderPearl);
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }
}
