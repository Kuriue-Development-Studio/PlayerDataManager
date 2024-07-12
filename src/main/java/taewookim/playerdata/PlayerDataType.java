package taewookim.playerdata;

import taewookim.playerdata.inventorydata.InventoryData;
import taewookim.playerdata.slotbardata.SlotBarData;

public enum PlayerDataType {

    Inventory(InventoryData.class),
    SlotBar(SlotBarData.class),
    ;

    private final Class<? extends Data> clz;

    PlayerDataType(Class<? extends Data> clz) {
        this.clz = clz;
    }

    public Data getData() {
        try{
            return clz.getConstructor().newInstance();
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
