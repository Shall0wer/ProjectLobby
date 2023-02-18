package fr.shall0wer.projectlobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST) @Deprecated
    public void onPlayerChat(PlayerChatEvent event){
        if(event.isCancelled()) return;
    }
}
