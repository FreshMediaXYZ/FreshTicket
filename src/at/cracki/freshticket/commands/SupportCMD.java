package at.cracki.freshticket.commands;

import at.cracki.freshticket.inventories.support.SupportGUI;
import at.cracki.freshticket.main.FreshTicket;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Command that opens the SupportGUI to choose between Cases and priorities.
public class SupportCMD implements CommandExecutor {
    private String prefix = FreshTicket.messages.get("Prefix");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player) {
            if(args.length == 0) {
                new SupportGUI(FreshTicket.getPlayerMenuUtility(player)).open();
            } else {
                player.sendMessage(prefix + FreshTicket.messages.get("Usage") + "§c/support");
            }
        } else {
            sender.sendMessage(prefix + FreshTicket.messages.get("NotPlayer"));
        }
        return false;
    }
}
