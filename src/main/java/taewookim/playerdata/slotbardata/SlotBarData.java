package taewookim.playerdata.slotbardata;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import taewookim.playerdata.Data;
import taewookim.playerdata.inventorydata.PlayerInventory;

import java.io.File;
import java.util.Map;

public class SlotBarData extends Data {

    private final SlotBarInventory slotbar;

    public SlotBarData() {
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

    @Override
    public void load(String uuid) {
        slotbar.load(getConfig(uuid));
    }
}
