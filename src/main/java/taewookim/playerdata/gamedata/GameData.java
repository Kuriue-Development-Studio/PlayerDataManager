package taewookim.playerdata.gamedata;

import org.bukkit.configuration.file.YamlConfiguration;
import taewookim.PlayerData;
import taewookim.playerdata.Data;

import java.io.File;

public class GameData extends Data {

    private boolean isGameing = true;

    public GameData(PlayerData playerdata) {
        super(playerdata);
    }

    public void setGameing(boolean isgameing) {
        isGameing = isgameing;
    }

    public boolean isGameing() {
        return isGameing;
    }

    @Override
    public void save(String uuid) {
        File file = getFile(uuid);
        YamlConfiguration config = getConfig(uuid);
        config.set("isGameing", isGameing);
        try{
            config.save(file);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(String uuid) {
        YamlConfiguration config = getConfig(uuid);
        if(config.isSet("isGameing")) {
            isGameing = config.getBoolean("isGameing");
        }else {
            isGameing = true;
        }
    }
}
