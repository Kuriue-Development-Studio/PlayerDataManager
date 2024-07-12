package taewookim.playerdata.inventorydata;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import taewookim.playerdata.Data;

import java.io.File;

public class InventoryData extends Data {

    private final PlayerInventory inventory;

    public InventoryData() {
        inventory = new PlayerInventory();
    }

    public PlayerInventory getInventory() {
        return inventory;
    }

    @Override
    public void save(String uuid) {
        File file = getFile(uuid);
        YamlConfiguration config = getConfig(uuid);
        inventory.save(config);
        try{
            config.save(file);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(String uuid) {
        inventory.load(getConfig(uuid));
    }
}
