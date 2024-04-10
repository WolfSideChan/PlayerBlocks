package pt.playerblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static pt.playerblock.PlayerBlock.*;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {

        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (cmd.getName().equalsIgnoreCase("blocos")) {
            if (args.length == 0) {
                p.sendMessage("");
                p.sendMessage("§eBlocos quebrados: " + getPlayerManager().getPlayer(p.getName()).getQuantidade());
                p.sendMessage("");
                return true;
            }
        }

        return false;
    }
}
