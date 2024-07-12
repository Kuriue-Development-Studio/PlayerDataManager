package taewookim.playerdata.inventorydata;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import taewookim.CustomInventory;

public class PlayerInventory extends CustomInventory {

    public PlayerInventory() {
        super(6, "인벤토리");
    }

    public void load(YamlConfiguration config) {
        for(String key : config.getKeys(false)) {
            inv.setItem(Integer.valueOf(key), config.getItemStack(key));
        }
    }

    public void save(YamlConfiguration config) {
        for(int i = 0; i<54; i++) {
            config.set(i+"", inv.getItem(i));
        }
    }

    @Override
    public void onOpen(InventoryOpenEvent inventoryOpenEvent) {

    }

    @Override
    public void onClose(InventoryCloseEvent inventoryCloseEvent) {

    }

    @Override
    public void onClickBotton(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);
    }

    @Override
    public void onClickOutside(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    public void onClick(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);
    }

    @Override
    public void onDrag(InventoryDragEvent inventoryDragEvent) {
        inventoryDragEvent.setCancelled(true);
    }
}
