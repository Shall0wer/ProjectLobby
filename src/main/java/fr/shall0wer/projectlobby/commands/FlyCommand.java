package fr.shall0wer.projectlobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)){
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("céleste.fly") || player.hasPermission("staff.fly")){
            if(player.getAllowFlight()){
                player.setAllowFlight(false);
                player.setFlying(false);
                player.sendMessage("§b§lVOL §8§l❙ §fVol §cdésactivé§f.");
            } else {
                player.setAllowFlight(true);
                player.setFlying(true);
                player.sendMessage("§b§lVOL §8§l❙ §fVol §aactivé§f.");
            }
        }
        return false;
    }
}
