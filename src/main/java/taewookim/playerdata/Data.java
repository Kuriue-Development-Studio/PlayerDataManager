package taewookim.playerdata;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public abstract class Data {

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
