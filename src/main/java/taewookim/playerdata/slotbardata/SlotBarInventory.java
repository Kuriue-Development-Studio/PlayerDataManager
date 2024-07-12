package taewookim.playerdata.slotbardata;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import taewookim.CustomInventory;

public class SlotBarInventory extends CustomInventory {
    public SlotBarInventory() {
        super(9, null);
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

    public ItemStack getItem(int slot) {
        return inv.getItem(slot);
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
