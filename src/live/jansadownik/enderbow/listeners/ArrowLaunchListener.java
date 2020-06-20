package live.jansadownik.enderbow.listeners;

import live.jansadownik.enderbow.EnderBow;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class ArrowLaunchListener implements Listener {
    EnderBow plugin;

    public ArrowLaunchListener(EnderBow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onArrowLaunch(EntityShootBowEvent event) {
        if (event.getEntity() instanceof Player)
            if (event.getBow().getEnchantmentLevel(Enchantment.ARROW_INFINITE) == 2) {
                Player p = (Player) event.getEntity();

                if (!p.hasPermission("enderbow.use.enderbow")) {
                    event.setCancelled(true);
                    p.sendMessage(plugin.getConfig().getString("messages.PlayerNotHavePermission"));
                    return;
                }

                if (!p.hasPermission("enderbow.bypass.use.enderpearl")) {
                    if (!p.getInventory().contains(Material.ENDER_PEARL)) {
                        event.setCancelled(true);
                        p.sendMessage(plugin.getConfig().getString("messages.PlayerNotHaveEnderPearl"));
                        return;
                    } else {
                        p.getInventory().removeItem(new ItemStack(Material.ENDER_PEARL, 1));
                        p.updateInventory();
                    }
                }

                Entity arrowToLaunch = event.getProjectile();
                arrowToLaunch.setCustomName("EnderBowArrow");
                arrowToLaunch.setVelocity(arrowToLaunch.getVelocity().multiply(1.2));
                event.setProjectile(arrowToLaunch);
            }
    }
}
