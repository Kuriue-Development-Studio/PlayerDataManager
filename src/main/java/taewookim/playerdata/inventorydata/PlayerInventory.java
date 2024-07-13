package taewookim.playerdata.inventorydata;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import taewookim.CustomInventory;
import taewookim.PlayerData;
import taewookim.playerdata.PlayerDataType;
import taewookim.playerdata.slotbardata.SlotBarData;
import util.ItemList;

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

    public void moveToSlotBar(PlayerData playerdata, int invslot, int barslot) {
        ItemStack i = inv.getItem(invslot);
        inv.setItem(invslot, ItemList.air);
        ((SlotBarData)playerdata.getData(PlayerDataType.SlotBar))
                .getInventory().setItem(barslot, i);
    }

    public ItemStack getItem(int slot) {
        return inv.getItem(slot);
    }

    public void setItem(int slot, ItemStack item) {
        inv.setItem(slot, item);
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
