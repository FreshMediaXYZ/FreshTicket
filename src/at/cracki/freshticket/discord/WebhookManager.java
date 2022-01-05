package at.cracki.freshticket.discord;

import java.awt.*;
import java.io.IOException;

public class WebhookManager {
/*

    Class which is supposed to be used to simply create Webhook Embeds

 */
    public static void sendWebhookMessage(String webhookURL, String text, String author, int color1, int color2, int color3) {
        DiscordWebhook webhook = new DiscordWebhook(webhookURL);
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setDescription(text)
                .setAuthor(author, "", "")
                .setColor(new Color(color1, color2, color3))
                .setFooter("Developed by CalledCracki (CEO@FreshMedia)", ""));
        try {
            webhook.execute();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
