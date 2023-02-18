package fr.shall0wer.projectlobby.scoreboard;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import fr.shall0wer.core.IPlayer.IPlayerInfos;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Proxy;
import java.util.UUID;

/*
 * This file is part of SamaGamesAPI.
 *
 * SamaGamesAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SamaGamesAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SamaGamesAPI.  If not, see <http://www.gnu.org/licenses/>.
 */
public class PersonalScoreboard {
    private Player player;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;

    PersonalScoreboard(Player player){
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "Lobby");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){}

    public void setLines(String ip){
        objectiveSign.setDisplayName("§6§lSERVEUR");
        IPlayerInfos playerInfos = new IPlayerInfos(player.getName());

        objectiveSign.setLine(0, "§1 ");
        objectiveSign.setLine(1, "§fJoueur: §b" + player.getName());
        objectiveSign.setLine(2, "  §e▪ §fGrade: " + (playerInfos.getRank().equals("§7") ? "§7Auncu" : playerInfos.getRank()));
        objectiveSign.setLine(3, "  §3▪ §fComètes: §3" + playerInfos.getCometes());
        objectiveSign.setLine(4, "  §6▪ §fÉtoiles: §6" + playerInfos.getEtoiles());
        objectiveSign.setLine(5, "§2 ");
        objectiveSign.setLine(6, "§fConnectés: §b" + CloudNetDriver.getInstance().getServicesRegistry().getServices(Proxy.class).size());
        objectiveSign.setLine(7, "§fServeur: §b" + player.getServer().getServerName());
        objectiveSign.setLine(8, "§9 ");
        objectiveSign.setLine(9, ip);

        objectiveSign.updateLines();
    }

    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}