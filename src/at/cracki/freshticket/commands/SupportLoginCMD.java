package at.cracki.freshticket.commands;

import at.cracki.freshticket.main.FreshTicket;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Command which logs-in Staff Members to Support System to check tickets and chat with Ticket Creators.
public class SupportLoginCMD implements CommandExecutor {
    private String prefix = FreshTicket.messages.get("Prefix");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if(sender instanceof Player) {
            if(player.hasPermission("ticket.staff") || player.hasPermission("ticket.admin") || player.isOp()) {
                if(args.length == 0) {
                    if(FreshTicket.loggedInMembers.contains(player)) {
                        FreshTicket.loggedInMembers.remove(player);
                        player.sendMessage(prefix + FreshTicket.messages.get("LoggedOutStaff"));
                    } else {
                        FreshTicket.loggedInMembers.add(player);
                        player.sendMessage(prefix + FreshTicket.messages.get("LoggedInStaff"));
                    }
                } else {
                    player.sendMessage(prefix + FreshTicket.messages.get("Usage") + "§c/login");
                }
            } else {
                player.sendMessage(prefix + FreshTicket.messages.get("NoPerms"));
            }
        } else {
            sender.sendMessage(prefix + FreshTicket.messages.get("NotPlayer"));
        }
        return false;
    }
}
