package fr.shall0wer.projectlobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class AdminCommand implements CommandExecutor {

    public static ArrayList<UUID> bypassList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)){
            return false;
        }

        Player player = (Player) sender;
        if(player.hasPermission("admin.admin")){
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("bypass")){
                    if(bypassList.contains(player.getUniqueId())){
                        bypassList.remove(player.getUniqueId());
                        player.sendMessage("§c§lADMIN §8§l❙ §fVous §cne pouvez plus §finterragir avec le lobby.");
                    } else {
                        bypassList.add(player.getUniqueId());
                        player.sendMessage("§c§lADMIN §8§l❙ §fVous §apouvez maintenant §finterragir avec le lobby.");
                    }
                    return true;
                }
            }
            player.sendMessage("§r \n§c§lADMIN §8§l❙ §fListe des commandes disponibles :" +
                    "\n§f- §c/§fadmin §cbypass §f» Permet de bypass les obligations du lobby." +
                    "\n§r ");
            return true;
        }
        player.sendMessage("§6§lSERVEUR §8§l❙ §fCommande introuvable.");
        return false;
    }
}
