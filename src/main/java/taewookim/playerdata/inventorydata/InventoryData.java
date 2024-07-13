package taewookim.playerdata.inventorydata;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import taewookim.PlayerData;
import taewookim.PlayerDataManager;
import taewookim.playerdata.Data;
import taewookim.playerdata.PlayerDataType;
import taewookim.playerdata.slotbardata.SlotBarData;
import util.ItemList;

import java.io.File;

public class InventoryData extends Data {

    private final PlayerInventory inventory;

    public InventoryData(PlayerData playerdata) {
        super(playerdata);
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

    public void moveToSlotBar(int invslot, int barslot) {
        inventory.moveToSlotBar(playerdata, invslot, barslot);
    }

    @Override
    public void load(String uuid) {
        inventory.load(getConfig(uuid));
    }
}
