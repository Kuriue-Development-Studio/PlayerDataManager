package taewookim;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;
import taewookim.commands.InventoryCommand;

public class DataManagerPlugin extends JavaPlugin {

    public void loadCommand(String cmd, Object object) {
        Bukkit.getPluginCommand(cmd).setExecutor((CommandExecutor) object);
        Bukkit.getPluginCommand(cmd).setTabCompleter((TabCompleter) object);
    }

    public void loadCommands() {
        loadCommand("inventory", new InventoryCommand());
    }

    public void onEnable() {
        loadCommands();
        Bukkit.getPluginManager().registerEvents(new Events(), this);
    }

    public void onDisable() {
        PlayerDataManager.saveAll();
    }

}
