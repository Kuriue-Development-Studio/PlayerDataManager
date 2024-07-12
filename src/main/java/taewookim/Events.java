package taewookim;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.WorldSaveEvent;

public class Events implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent e) {
        PlayerDataManager.createPlayerData(e.getPlayer());
    }

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        PlayerDataManager.savePlayerData(e.getPlayer());
    }

    @EventHandler
    public void save(WorldSaveEvent e) {
        if(e.getWorld().getName().equalsIgnoreCase("world")) {
            PlayerDataManager.saveAll();
        }
    }

}
