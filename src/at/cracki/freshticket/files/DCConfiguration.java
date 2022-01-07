package at.cracki.freshticket.files;

import at.cracki.freshticket.main.FreshTicket;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/*

The 2nd Ultimate Class. The DCConfiguration. It saves every important value, which may be changed later.

*/
public class DCConfiguration {

    private static File file = new File("plugins/FreshTicket", "DCConfig.yml");

    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void saveCFG() {
        try {
            cfg.save(file);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void cfgConfig() {
        cfg.options().copyDefaults(true);
        cfg.options().header("==================== FreshTicket by CalledCracki ======================");

        cfg.addDefault("Discord.WebhookURL", "https://discord.com/api/webhooks/927616273850982421/FvHCXP2X54EGeH1HtStB2KD6t86odYg9s_VIMP-oDtYzKDSGprO-_cp0wGJOvmF1XdLF");

        cfg.addDefault("Support.Case1.Name", "General Help");
        cfg.addDefault("Support.Case2.Name", "Discord Related");
        cfg.addDefault("Support.Case3.Name", "Forum Related");
        cfg.addDefault("Support.Case4.Name", "Teamspeak Related");
        cfg.addDefault("Support.Case5.Name", "Rulebreaker Found");
        cfg.addDefault("Support.Case6.Name", "Feedback & Suggestions");
        cfg.addDefault("Support.Case7.Name", "I want to apply");

        cfg.addDefault("Support.Level1.Name", "Low priority");
        cfg.addDefault("Support.Level2.Name", "Medium priority");
        cfg.addDefault("Support.Level3.Name", "High Priority");
        cfg.addDefault("Support.Level4.Name", "Very high Priority");

        cfg.addDefault("Embed.Ticket.Title", "Ticket System Notification");
        cfg.addDefault("Embed.Ticket.Description", "A Ticket has been created!");
        cfg.addDefault("Embed.Ticket.Image.URL", "https://i.imgur.com/1MxIktF.png");
        cfg.addDefault("Embed.Ticket.Author.Name", "FreshTicket");
        cfg.addDefault("Embed.Ticket.Author.URL", " ");
        cfg.addDefault("Embed.Ticket.Avatar.URL", "https://i.imgur.com/4GP7kZ2.png");
        cfg.addDefault("Embed.Ticket.Author.ICON_URL", " ");
        cfg.addDefault("Embed.Ticket.Thumbnail.URL", "https://i.imgur.com/lSGOy57.png");
        cfg.addDefault("Embed.Ticket.Content", "**%player%** has created a ticket");
        cfg.addDefault("Embed.Ticket.Color.No1", 252);
        cfg.addDefault("Embed.Ticket.Color.No2", 32);
        cfg.addDefault("Embed.Ticket.Color.No3", 3);

        Bukkit.getConsoleSender().sendMessage(String.valueOf(FreshTicket.messages.get("Prefix").replaceAll("&", "§")) + "DCConfig.yml was configured successfully.");
        saveCFG();
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }

    public static void setCache() {
        FreshTicket.dcsettings.put("WebhookURL", cfg.getString("Discord.WebhookURL"));

        FreshTicket.dcsettings.put("SupportCase1Name", cfg.getString("Support.Case1.Name"));
        FreshTicket.dcsettings.put("SupportCase2Name", cfg.getString("Support.Case2.Name"));
        FreshTicket.dcsettings.put("SupportCase3Name", cfg.getString("Support.Case3.Name"));
        FreshTicket.dcsettings.put("SupportCase4Name", cfg.getString("Support.Case4.Name"));
        FreshTicket.dcsettings.put("SupportCase5Name", cfg.getString("Support.Case5.Name"));
        FreshTicket.dcsettings.put("SupportCase6Name", cfg.getString("Support.Case6.Name"));
        FreshTicket.dcsettings.put("SupportCase7Name", cfg.getString("Support.Case7.Name"));

        FreshTicket.dcsettings.put("SupportCase1Level", cfg.getString("Support.Case1.Level"));
        FreshTicket.dcsettings.put("SupportCase2Level", cfg.getString("Support.Case2.Level"));
        FreshTicket.dcsettings.put("SupportCase3Level", cfg.getString("Support.Case3.Level"));
        FreshTicket.dcsettings.put("SupportCase4Level", cfg.getString("Support.Case4.Level"));

        FreshTicket.stringsettings.put("EmbedTicketTitle", cfg.getString("Embed.Ticket.Title"));
        FreshTicket.stringsettings.put("EmbedTicketDesc", cfg.getString("Embed.Ticket.Description"));
        FreshTicket.stringsettings.put("EmbedTicketImageURL", cfg.getString("Embed.Ticket.Image.URL"));
        FreshTicket.stringsettings.put("EmbedTicketAuthorName", cfg.getString("Embed.Ticket.Author.Name"));
        FreshTicket.stringsettings.put("EmbedTicketAuthorURL", cfg.getString("Embed.Ticket.Author.URL"));
        FreshTicket.stringsettings.put("EmbedTicketAvatarURL", cfg.getString("Embed.Ticket.Avatar.URL"));
        FreshTicket.stringsettings.put("EmbedTicketAuthorICONURL", cfg.getString("Embed.Ticket.Author.ICON_URL"));
        FreshTicket.stringsettings.put("EmbedTicketThumbnailURL", cfg.getString("Embed.Ticket.Thumbnail.URL"));
        FreshTicket.stringsettings.put("EmbedTicketContent", cfg.getString("Embed.Ticket.Content"));
        FreshTicket.integer.put("EmbedTicketColor1", cfg.getInt("Embed.Ticket.Color.No1"));
        FreshTicket.integer.put("EmbedTicketColor2", cfg.getInt("Embed.Ticket.Color.No2"));
        FreshTicket.integer.put("EmbedTicketColor3", cfg.getInt("Embed.Ticket.Color.No3"));

        Bukkit.getConsoleSender().sendMessage((FreshTicket.messages.get("Prefix")) + "DCConfig.yml was successfully loaded!");
    }
}
