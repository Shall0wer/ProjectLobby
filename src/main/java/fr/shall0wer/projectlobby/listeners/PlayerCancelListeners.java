package fr.shall0wer.projectlobby.listeners;

import fr.shall0wer.core.Main;
import fr.shall0wer.core.gui.lobby.MainGui;
import fr.shall0wer.projectlobby.commands.AdminCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerCancelListeners implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            switch (event.getMaterial()){
                case COMPASS:
                    if (event.getItem().getItemMeta().getDisplayName().startsWith("§6Menu Principal")) {
                        Main.getGuiManager().open(event.getPlayer(), MainGui.class);
                    }
                    break;
                default: break;
            }
        }
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        if(!AdminCommand.bypassList.contains(event.getPlayer().getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event){
        if(!AdminCommand.bypassList.contains(event.getPlayer().getUniqueId())){
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            if(!AdminCommand.bypassList.contains(event.getEntity().getUniqueId())){
                event.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void onBuild(BlockPlaceEvent event){
        if(!AdminCommand.bypassList.contains(event.getPlayer().getUniqueId())){
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        if(!AdminCommand.bypassList.contains(event.getPlayer().getUniqueId())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodLose(FoodLevelChangeEvent event){
        if(event.getEntity() instanceof Player){
            event.setCancelled(true);
        }
    }
}
