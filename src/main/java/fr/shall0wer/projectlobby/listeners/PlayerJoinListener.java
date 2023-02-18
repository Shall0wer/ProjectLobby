package fr.shall0wer.projectlobby.listeners;

import com.nametagedit.plugin.NametagEdit;
import fr.shall0wer.core.IPlayer.IPlayerInfos;
import fr.shall0wer.core.database.DatabaseManager;
import fr.shall0wer.core.database.PlayerInteract;
import fr.shall0wer.core.utils.Title;
import fr.shall0wer.projectlobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) throws IOException {
        e.setJoinMessage(null);
        Player player = e.getPlayer();
        IPlayerInfos playerInfos = new IPlayerInfos(player.getName());

        if(!playerInfos.hasAccount()){
            playerInfos.createAccount();
            player.sendMessage("§6§m+-----------------------------------+" +
                    "\n§r " +
                    "\n    §fBienvenue sur §6SERVEUR§f, §b" + player.getName() + " §f!" +
                    "\n§r " +
                    "\n§6§m+-----------------------------------+");
            Title.sendTitle(player, 20, 60, 30, "§f✽ §6Bienvenue sur SERVEUR §f✽", "§f§oBons jeux sur nos serveurs !");
        }

        player.teleport(new Location(Bukkit.getWorld("world"), -234.5, 92.01, -523.5, -90, 0));

        if(player.hasPermission("staff.fly")){
            player.setAllowFlight(true);
            player.setFlying(true);
        }

        Main.getInstance().getScoreboardManager().onLogin(player);
        for(Player players : Bukkit.getOnlinePlayers()){
            NametagEdit.getApi().setPrefix(players, playerInfos.getRank());
            if(players.hasPermission("staff")){
                NametagEdit.getApi().setSuffix(players, "§a ✔");
            }
        }

        if(playerInfos.isModActive()){
            return;
        }

        if(player.hasPermission("ange.joinmessage") || player.hasPermission("staff.joinmessage")){
            Bukkit.broadcastMessage(playerInfos.getRank().replace("&", "§") + player.getName() + "§6 vient de rejoindre le lobby !");
        }

        PlayerInteract.setItems(player, "lobby");
        player.getInventory().setHeldItemSlot(0);
        player.setGameMode(GameMode.ADVENTURE);


    }
}
