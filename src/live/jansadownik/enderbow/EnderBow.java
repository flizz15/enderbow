package live.jansadownik.enderbow;

import live.jansadownik.enderbow.commands.EnderBowCommandExecutor;
import live.jansadownik.enderbow.commands.SuperEnderBowCommand;
import live.jansadownik.enderbow.config.ConfigParser;
import live.jansadownik.enderbow.listeners.ArrowDamageEntityListener;
import live.jansadownik.enderbow.listeners.ArrowHitListener;
import live.jansadownik.enderbow.listeners.ArrowLaunchListener;
import live.jansadownik.enderbow.recipes.EnderBowRecipe;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnderBow extends JavaPlugin {
    @Override
    public void onEnable() {
        ConfigParser configParser = new ConfigParser(this);

        getCommand("enderbow").setExecutor(new EnderBowCommandExecutor(this));
        getCommand("superenderbow").setExecutor(new SuperEnderBowCommand(this));

        getServer().getPluginManager().registerEvents(new ArrowLaunchListener(this), this);
        getServer().getPluginManager().registerEvents(new ArrowHitListener(), this);
        getServer().getPluginManager().registerEvents(new ArrowDamageEntityListener(), this);

        Bukkit.addRecipe(new EnderBowRecipe().getEnderBowRecipe());

        configParser.setupConfig();
    }
}
