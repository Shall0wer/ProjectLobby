package fr.shall0wer.projectlobby;

import fr.shall0wer.projectlobby.commands.*;
import fr.shall0wer.projectlobby.managers.ListenerManager;
import fr.shall0wer.projectlobby.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public final class Main extends JavaPlugin {

    public static Main INSTANCE;

    /**
     * Scoreboard
     */
    private ScoreboardManager scoreboardManager;
    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    public void onEnable() {
        INSTANCE = this;
        ListenerManager.registers();

        getCommand("test").setExecutor(new TestCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("admin").setExecutor(new AdminCommand());
        getCommand("fly").setExecutor(new FlyCommand());

        scheduledExecutorService = Executors.newScheduledThreadPool(16);
        executorMonoThread = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager();
        debugScoreboardReload();

        // new AutoMessages().runTaskTimer(this, 10 * 60 * 20L, 10 * 60 * 20L);
    }

    @Override
    public void onDisable() {
        getScoreboardManager().onDisable();
    }

    public static Main getInstance() {
        return INSTANCE;
    }
    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ScheduledExecutorService getExecutorMonoThread() {
        return executorMonoThread;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    public void debugScoreboardReload(){
        for(Player players : Bukkit.getOnlinePlayers()){
            getScoreboardManager().onLogin(players);
        }
    }

}
