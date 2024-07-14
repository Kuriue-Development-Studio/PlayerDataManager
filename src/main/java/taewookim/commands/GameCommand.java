package taewookim.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import taewookim.PlayerDataManager;
import taewookim.playerdata.PlayerDataType;
import taewookim.playerdata.gamedata.GameData;

public class GameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player p) {
            GameData data = (GameData) PlayerDataManager.getPlayerData(p).getData(PlayerDataType.Game);
            data.setGameing(!data.isGameing());
        }
        return false;
    }
}
