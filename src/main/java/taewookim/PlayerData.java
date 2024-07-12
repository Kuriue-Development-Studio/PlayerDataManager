package taewookim;

import org.bukkit.entity.Player;
import taewookim.playerdata.Data;
import taewookim.playerdata.PlayerDataType;

import java.util.HashMap;
import java.util.Map;

public class PlayerData {

    private final Player p;
    private final Map<PlayerDataType, Data> datalist = new HashMap<>();

    public PlayerData(Player p) {
        this.p = p;
        for(PlayerDataType type : PlayerDataType.values()) {
            datalist.put(type, type.getData());
        }
    }

    public Data getData(PlayerDataType type) {
        return datalist.get(type);
    }

    public void load() {
        String uuid = p.getUniqueId().toString();
        for(Map.Entry<PlayerDataType, Data> entry : datalist.entrySet()) {
            entry.getValue().load(uuid);
        }
    }

    public void save() {
        String uuid = p.getUniqueId().toString();
        for(Map.Entry<PlayerDataType, Data> entry : datalist.entrySet()) {
            entry.getValue().save(uuid);
        }
    }

}
