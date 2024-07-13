package taewookim.playerdata;

import org.bukkit.configuration.file.YamlConfiguration;
import taewookim.PlayerData;
import taewookim.PlayerDataManager;

import java.io.File;

public abstract class Data {

    protected final PlayerData playerdata;

    public Data(PlayerData playerdata) {
        this.playerdata = playerdata;
    }

    public final String getFileLoc(String uuid) {
        return "/" + uuid + "/" + this.getClass().getSimpleName() + ".yml";
    }

    public final File getFile(String uuid) {
        return new File(getFileLoc(uuid));
    }

    public final YamlConfiguration getConfig(String uuid) {
        return YamlConfiguration.loadConfiguration(getFile(uuid));
    }

    public abstract void save(String uuid);

    public abstract void load(String uuid);

}
