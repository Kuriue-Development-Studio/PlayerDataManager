package taewookim.playerdata;

import taewookim.PlayerData;
import taewookim.playerdata.gamedata.GameData;
import taewookim.playerdata.inventorydata.InventoryData;
import taewookim.playerdata.slotbardata.SlotBarData;

public enum PlayerDataType {

    Inventory(InventoryData.class),
    SlotBar(SlotBarData.class),
    Game(GameData.class),
    ;

    private final Class<? extends Data> clz;

    PlayerDataType(Class<? extends Data> clz) {
        this.clz = clz;
    }

    public Data getData(PlayerData playerdata) {
        try{
            return clz.getConstructor(PlayerData.class).newInstance(playerdata);
        }catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
