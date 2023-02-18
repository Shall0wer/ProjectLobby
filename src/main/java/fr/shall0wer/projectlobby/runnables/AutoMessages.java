package fr.shall0wer.projectlobby.runnables;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.List;

public class AutoMessages extends BukkitRunnable {

    private File config_file = new File("/home/minecraft/DataBase/config.yml");
    private FileConfiguration config = YamlConfiguration.loadConfiguration(config_file);
    private List<String> messages = config.getStringList("messages");
    private int i = 0;

    @Override
    public void run() {
        if(messages.isEmpty()){
            cancel();
            return;
        }
        if(i >= messages.size()){
            i = 0;
        }
        Bukkit.broadcastMessage("§r \n" + messages.get(i).replace("\n", "\n§r ") + "\n §r");
        for(Player players : Bukkit.getOnlinePlayers()){
            players.playSound(players.getLocation(), Sound.SUCCESSFUL_HIT, 10, 1);
        }
        i++;
    }
}
