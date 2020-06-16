package live.jansadownik.enderbow.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ArrowDamageEntityListener implements Listener {
    @EventHandler
    public void onEventDamageEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager().getCustomName() != null)
            if (event.getDamager().getCustomName().equals("EnderBowArrow"))
                event.setCancelled(true);
        }
}
