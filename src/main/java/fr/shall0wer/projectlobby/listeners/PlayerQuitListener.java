package fr.shall0wer.projectlobby.listeners;

import fr.shall0wer.projectlobby.Main;
import fr.shall0wer.projectlobby.commands.AdminCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage(null);
        if(AdminCommand.bypassList.contains(event.getPlayer().getUniqueId())){
            AdminCommand.bypassList.remove(event.getPlayer().getUniqueId());
        }
        player.setAllowFlight(false);
        player.setFlying(false);
        Main.getInstance().getScoreboardManager().onLogout(player);
    }
}
