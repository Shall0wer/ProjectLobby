package fr.shall0wer.projectlobby.managers;

import fr.mrcubee.finder.plugin.PluginFinder;
import fr.shall0wer.projectlobby.listeners.PlayerCancelListeners;
import fr.shall0wer.projectlobby.listeners.PlayerChatListener;
import fr.shall0wer.projectlobby.listeners.PlayerJoinListener;
import fr.shall0wer.projectlobby.listeners.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {

    public static void registers() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), (Plugin) PluginFinder.INSTANCE.findPlugin());
        pm.registerEvents(new PlayerCancelListeners(), (Plugin) PluginFinder.INSTANCE.findPlugin());
        pm.registerEvents(new PlayerQuitListener(), (Plugin) PluginFinder.INSTANCE.findPlugin());
        pm.registerEvents(new PlayerChatListener(), (Plugin) PluginFinder.INSTANCE.findPlugin());
    }
}
