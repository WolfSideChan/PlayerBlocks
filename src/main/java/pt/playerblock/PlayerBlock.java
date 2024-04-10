package pt.playerblock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pt.playerblock.commands.MainCommand;
import pt.playerblock.entity.PlayerManager;
import pt.playerblock.listeners.PlayerEvents;
import pt.playerblock.utils.MYSQL;

public class PlayerBlock extends JavaPlugin {

    private static MYSQL mysql;
    private static PlayerManager playerManager;
    private static PlayerBlock instance;

    @Override
    public void onEnable() {
        instance = this;


        mysql = new MYSQL("root", "vertrigo", "localhost", 3306, "playerblocks");
        mysql.openConnection();

        playerManager = new PlayerManager();

        register();
    }

    @Override
    public void onDisable() {
        mysql.closeConnection();
    }

    public void register() {
        getCommand("blocos").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
    }

    public static PlayerBlock getInstance() {
        return instance;
    }
    public static PlayerManager getPlayerManager() {
        return playerManager;
    }
    public static MYSQL getMysql() {
        return mysql;
    }


}