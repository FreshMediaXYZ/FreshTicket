package at.cracki.freshticket.utils;

import at.cracki.freshticket.discord.DiscordWebhook;
import at.cracki.freshticket.main.FreshTicket;
import org.bukkit.Bukkit;

import java.awt.*;
import java.io.IOException;

public class DiscordAdvertisement {

    public static void startAds() {
        Bukkit.getScheduler().runTaskTimer(FreshTicket.getInstance(), new Runnable() {
            @Override
            public void run() {
                String webhookURL = FreshTicket.stringsettings.get("WebhookURL");

                DiscordWebhook webhook = new DiscordWebhook(webhookURL);
                webhook.setAvatarUrl("https://i.imgur.com/4GP7kZ2.png");
                webhook.setUsername("FreshTicket System");
                webhook.addEmbed(new DiscordWebhook.EmbedObject()
                        .setTitle("Ticket System Advertisement")
                        .setDescription("Remove ads by purchasing FT Premium")
                        .addField("Premium URL", "https://fresh-media.xyz", true)
                        .setImage("https://i.imgur.com/1MxIktF.png")
                        .setAuthor("FreshTicket", "", "")
                        .setColor(new Color(252, 32, 3))
                        .setThumbnail("https://i.imgur.com/lSGOy57.png")
                        .setFooter("Developed by CalledCracki & JamesLikesIDE (@FreshMedia)", "https://i.imgur.com/lSGOy57.png"));
                try {
                    webhook.execute();
                }
                catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }, 0, 20 * 3600);
    }

}
