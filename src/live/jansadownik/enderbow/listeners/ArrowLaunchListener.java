package live.jansadownik.enderbow.listeners;

import live.jansadownik.enderbow.Messages;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class ArrowLaunchListener implements Listener {

    @EventHandler
    public void onArrowLaunch(EntityShootBowEvent event) {
        if (event.getEntity() instanceof Player)
            if (event.getBow().getEnchantmentLevel(Enchantment.ARROW_INFINITE) == 2) {
                if (!event.getEntity().hasPermission("enderbow.use.enderbow")) {
                    event.setCancelled(true);
                    event.getEntity().sendMessage(Messages.PlayerNotHavePermission);
                    return;
                }
                Entity arrowToLaunch = event.getProjectile();
                arrowToLaunch.setVelocity(arrowToLaunch.getVelocity().multiply(1.2));
                event.setProjectile(arrowToLaunch);
            }
    }
}
