package taewookim.playerdata.inventorydata;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import taewookim.CustomInventory;
import taewookim.PlayerData;
import taewookim.interaction.inventory.InteractInventoryGUI;
import taewookim.playerdata.PlayerDataType;
import taewookim.playerdata.slotbardata.SlotBarData;
import util.ItemList;

import java.util.HashMap;

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

    public boolean addItem(ItemStack i) {
        if(i==null) {
            return true;
        }
        if(hasEnoughSpace(inv.getStorageContents(), i)) {
            inv.addItem(i);
            return true;
        }
        return false;
    }

    public static boolean hasEnoughSpace(ItemStack[] content, ItemStack... item) {
        Inventory inv = Bukkit.createInventory(null, content.length);
        inv.setContents(content);
        HashMap<Integer, ItemStack> leftover = new HashMap<>();
        leftover.putAll(inv.addItem(item));
        return leftover.isEmpty();
    }

    public void moveToSlotBar(PlayerData playerdata, int invslot, int barslot) {
        ItemStack i = inv.getItem(invslot);
        inv.setItem(invslot, ItemList.air);
        SlotBarData bardata = ((SlotBarData)playerdata.getData(PlayerDataType.SlotBar));
        addItem(bardata.getInventory().getItem(barslot));
        bardata.getInventory().setItem(barslot, i);
    }

    @Override
    public void onOpen(InventoryOpenEvent inventoryOpenEvent) {
        if(!(inventoryOpenEvent.getPlayer() instanceof Player)) {
            inventoryOpenEvent.setCancelled(true);
        }
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
        inventoryClickEvent.setCancelled(true);
    }

    @Override
    public void onClick(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);
        ItemStack i = inventoryClickEvent.getCurrentItem();
        if(i!=null&&!i.getType().equals(Material.AIR)) {
            new InteractInventoryGUI(inventoryClickEvent.getSlot()).openPlayer((Player) inventoryClickEvent.getWhoClicked());
        }
    }

    @Override
    public void onDrag(InventoryDragEvent inventoryDragEvent) {
        inventoryDragEvent.setCancelled(true);
    }
}
