package at.cracki.freshticket.listener;

import at.cracki.freshticket.main.FreshTicket;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitHandler implements Listener {

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(FreshTicket.booleansettings.get("JoinMessage")) {
            event.setJoinMessage(FreshTicket.messages.get("PlayerJoinMessage")
                    .replace("%player%", player.getName()));
        }
    }

    @EventHandler
    public void handlePlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(FreshTicket.booleansettings.get("QuitMessage")) {
            event.setQuitMessage(FreshTicket.messages.get("PlayerQuitMessage")
                    .replace("%player%", player.getName()));
        }
    }
}
