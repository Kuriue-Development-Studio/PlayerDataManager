package taewookim.playerdata.slotbardata;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import taewookim.PlayerData;
import taewookim.PlayerDataManager;
import taewookim.playerdata.Data;
import taewookim.playerdata.PlayerDataType;
import taewookim.playerdata.inventorydata.InventoryData;
import taewookim.playerdata.inventorydata.PlayerInventory;
import util.ItemList;

import java.io.File;
import java.util.Map;

public class SlotBarData extends Data {

    private final SlotBarInventory slotbar;

    public SlotBarData(PlayerData playerdata) {
        super(playerdata);
        slotbar = new SlotBarInventory();
    }

    public SlotBarInventory getInventory() {
        return slotbar;
    }

    @Override
    public void save(String uuid) {
        File file = getFile(uuid);
        YamlConfiguration config = getConfig(uuid);
        slotbar.save(config);
        try{
            config.save(file);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void takeByInventory(int invslot, int barslot) {
        slotbar.takeByInventory(playerdata, invslot, barslot);
    }

    @Override
    public void load(String uuid) {
        slotbar.load(getConfig(uuid));
    }
}
