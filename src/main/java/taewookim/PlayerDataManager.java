package taewookim;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerDataManager {

    private static final Map<Player, PlayerData> playerdatas = new HashMap<>();

    public static PlayerData getPlayerData(Player p) {
        return playerdatas.get(p);
    }

    public static void createPlayerData(Player p) {
        PlayerData playerdata = new PlayerData(p);
        playerdata.load();
        playerdatas.put(p, playerdata);
    }

    public static void savePlayerData(Player p) {
        getPlayerData(p).save();
    }

    public static void saveAll() {
        for(Map.Entry<Player, PlayerData> entry : playerdatas.entrySet()) {
            entry.getValue().save();
        }
    }

    public static void removePlayerData(Player p) {
        savePlayerData(p);
        playerdatas.remove(p);
    }

}
