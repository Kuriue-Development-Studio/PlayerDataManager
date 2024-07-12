package taewookim.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import taewookim.PlayerDataManager;
import taewookim.playerdata.PlayerDataType;
import taewookim.playerdata.inventorydata.InventoryData;

import java.util.List;

public class InventoryCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player p) {
            Player target = p;
            if(strings.length!=0) {
                target = Bukkit.getPlayer(strings[0]);
            }
            InventoryData invdata = (InventoryData) PlayerDataManager.getPlayerData(target).getData(PlayerDataType.Inventory);
            invdata.getInventory().openPlayer(p);
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
