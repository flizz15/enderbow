package live.jansadownik.enderbow.listeners;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class ArrowHitListener implements Listener {
    @EventHandler
    public boolean onArrowHit(ProjectileHitEvent event) {
        if (event.getEntity() == null) return false;
        if (event.getEntity() instanceof Arrow) {
            if (event.getEntity().getShooter() instanceof Player) {
                Player p = (Player) event.getEntity().getShooter();
                Arrow arrow = (Arrow) event.getEntity();

                if (arrow.getCustomName() != null) {
                    if (arrow.getCustomName().equals("EnderBowArrow")) {
                        arrow.remove();
                        Location arrowLocation = arrow.getLocation();
                        p.playSound(arrowLocation, Sound.ENDERMAN_TELEPORT, 10, 1);
                        p.teleport(arrowLocation, PlayerTeleportEvent.TeleportCause.ENDER_PEARL);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
