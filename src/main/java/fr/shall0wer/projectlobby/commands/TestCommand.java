package fr.shall0wer.projectlobby.commands;

import fr.mrcubee.sign.gui.SignGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class TestCommand implements CommandExecutor {

    private final Plugin plugin;

    public TestCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        SignGUI signGui = SignGUI.create(plugin); // DANS UN EVENT -> PLUGIN FINDER cf. MrCubee discord
        signGui.open(player, lines -> player.sendMessage(args[0]),
                args);
        return false;
    }
}
