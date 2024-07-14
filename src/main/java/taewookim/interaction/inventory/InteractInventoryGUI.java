package taewookim.interaction.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import taewookim.CustomInventory;
import taewookim.PlayerData;
import taewookim.PlayerDataManager;
import taewookim.playerdata.PlayerDataType;
import taewookim.playerdata.inventorydata.InventoryData;
import taewookim.playerdata.inventorydata.PlayerInventory;
import taewookim.playerdata.slotbardata.SlotBarData;
import taewookim.playerdata.slotbardata.SlotBarInventory;
import util.ItemList;

public class InteractInventoryGUI extends CustomInventory {

    private int invslot;

    public InteractInventoryGUI(int invslot) {
        super(4, "핫바 슬롯을 바꾸시겠습니까?");
        this.invslot = invslot;
        for(int i = 0; i<27; i++) {
            inv.setItem(i, ItemList.black);
        }
    }

    @Override
    protected void onOpen(InventoryOpenEvent inventoryOpenEvent) {
        if(inventoryOpenEvent.getPlayer() instanceof Player p) {
            PlayerData playerdata = PlayerDataManager.getPlayerData(p);
            PlayerInventory inventorydata = ((InventoryData) playerdata.getData(PlayerDataType.Inventory)).getInventory();
            SlotBarInventory slotbardata = ((SlotBarData) playerdata.getData(PlayerDataType.SlotBar)).getInventory();
            inv.setItem(13, inventorydata.getItem(invslot));
            for(int i = 27; i<36; i++) {
                ItemStack item = slotbardata.getItem(i-27);
                inv.setItem(i, item==null||item.getType().equals(Material.AIR)?ItemList.x:item);
            }
        }else {
            inventoryOpenEvent.setCancelled(true);
        }
    }

    @Override
    protected void onClose(InventoryCloseEvent inventoryCloseEvent) {

    }

    @Override
    protected void onClickBotton(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);
    }

    @Override
    protected void onClickOutside(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);
    }

    @Override
    protected void onClick(InventoryClickEvent inventoryClickEvent) {
        inventoryClickEvent.setCancelled(true);
        int slot = inventoryClickEvent.getSlot();
        switch(slot) {
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                PlayerData playerdata = PlayerDataManager.getPlayerData((Player) inventoryClickEvent.getWhoClicked());
                PlayerInventory inventorydata = ((InventoryData) playerdata.getData(PlayerDataType.Inventory)).getInventory();
                inventorydata.moveToSlotBar(playerdata, invslot, slot-27);
                break;
        }
    }

    @Override
    protected void onDrag(InventoryDragEvent inventoryDragEvent) {
        inventoryDragEvent.setCancelled(true);
    }
}
