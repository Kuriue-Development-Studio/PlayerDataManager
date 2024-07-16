package taewookim.playerdata.slotbardata;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import taewookim.CustomInventory;
import taewookim.PlayerData;
import taewookim.playerdata.PlayerDataType;
import taewookim.playerdata.inventorydata.InventoryData;
import taewookim.playerdata.inventorydata.PlayerInventory;
import util.ItemList;

public class SlotBarInventory extends CustomInventory {
    public SlotBarInventory() {
        super(1, "슬롯바");
    }

    public void load(YamlConfiguration config) {
        for(String key : config.getKeys(false)) {
            inv.setItem(Integer.valueOf(key), config.getItemStack(key));
        }
    }

    public void save(YamlConfiguration config) {
        for(int i = 0; i<9; i++) {
            config.set(i+"", inv.getItem(i));
        }
    }

    public void takeByInventory(PlayerData playerdata, int invslot, int barslot) {
        PlayerInventory inv = ((InventoryData)playerdata.getData(PlayerDataType.Inventory))
                .getInventory();
        ItemStack item = inv.getItem(invslot);
        inv.setItem(invslot, ItemList.air);
        inv.addItem(getItem(barslot));
        setItem(barslot, item);
    }

    @Override
    protected void onOpen(InventoryOpenEvent inventoryOpenEvent) {

    }

    @Override
    protected void onClose(InventoryCloseEvent inventoryCloseEvent) {

    }

    @Override
    protected void onClickBotton(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    protected void onClickOutside(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    protected void onClick(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    protected void onDrag(InventoryDragEvent inventoryDragEvent) {

    }
}
