package live.jansadownik.enderbow.listeners;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;

public class ArrowHitListener implements Listener {
    @EventHandler
    public boolean onArrowHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            if (event.getEntity().getShooter() instanceof Player) {
                Player p = (Player) event.getEntity().getShooter();
                ItemStack itemInHand = p.getItemInHand();
                Arrow arrow = (Arrow) event.getEntity();

                if (itemInHand.getEnchantmentLevel(Enchantment.ARROW_INFINITE) == 2) {
                    arrow.remove();
                    Location arrowLocation = arrow.getLocation();
                    p.playSound(arrowLocation, Sound.ENDERMAN_TELEPORT, 10, 1);
                    p.teleport(arrowLocation, PlayerTeleportEvent.TeleportCause.ENDER_PEARL);
                }
                return true;
            }
        }
        return false;
    }
}
