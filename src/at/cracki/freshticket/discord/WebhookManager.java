package at.cracki.freshticket.discord;

import java.awt.*;
import java.io.IOException;

/**
 * Easily create webhooks, without messing your hands.
 * <i>Note that if you do use this in one of your projects, leave this notice.</i>
 * <i>Please do credit me if you do use this in one of your projects.</i>
 * @author CalledCracki
 */

public class WebhookManager {
    private final DiscordWebhook webhook;
    private final DiscordWebhook.EmbedObject embedObject = new DiscordWebhook.EmbedObject();

    /**
     * Create a new WebhookManager from scratch
     * @param webhook The Class to create the WebhookManager with.
     */
    public WebhookManager(DiscordWebhook webhook) {
        this.webhook = webhook;
    }

    /**
     * Creates a new Embed Object
     */
    public WebhookManager setEmbed() {
        webhook.addEmbed(embedObject);
        return this;
    }

    /**
     * Set the description of the Embed
     * @param description The description to set it to.
     */
    public WebhookManager setDescription(String description) {
        embedObject.setDescription(description);
        return this;
    }


    /**
     * Set the author of the embed
     * @param author The author to set it to.
     * @param url url of author. If name was used, it becomes a hyperlink
     * @param icon_url The url to the icon of the author.
     */
    public WebhookManager setAuthor(String author, String url, String icon_url) {
        embedObject.setAuthor(author, url, icon_url);
        return this;
    }

    /**
     * Color code of the embed
     * You have to use Decimal numeral system, not Hexadecimal!
     * @param color1 First value of the color.
     * @param color2 Second value of the color.
     * @param color3 Third value of the color.
     */
    public WebhookManager setColor(int color1, int color2, int color3) {
        embedObject.setColor(new Color(color1, color2, color3));
        return this;
    }

    /**
     * Set the footer of the Embed
     * @param footer footer text, doesn't support Markdown.
     * @param icon_url url of footer icon.
     */
    public WebhookManager setFooter(String footer, String icon_url) {
        embedObject.setFooter(footer, icon_url);
        return this;
    }

    public WebhookManager addField(String name, String field, boolean inline) {
        embedObject.addField(name, field, inline);
        return this;
    }

    /**
     * Set the image of the Embed
     * <b>* Notice that this sets the Image in the upper right corner.</b>
     * @param url url of the image.
     */
    public WebhookManager setImage(String url) {
        embedObject.setImage(url);
        return this;
    }

    /**
     * Set the thumbnail of the Embed
     * <b>* Notice that this sets the Image above the footer.</b>
     * @param url url of the thumbnail.
     */
    public WebhookManager setThumbnail(String url) {
        embedObject.setThumbnail(url);
        return this;
    }

    /**
     * Set the title of the Embed.
     * @param title text you want to set the title to.
     */
    public WebhookManager setTitle(String title) {
        embedObject.setTitle(title);
        return this;
    }

    /**
     * Method used to execute the Webhook Creation
     * @throws IllegalArgumentException when no Embed has been created.
     * @see DiscordWebhook@execute
     */
    public WebhookManager execute() {
        try {
            webhook.execute();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return this;
    }

    /**
     * Retrieves the webhook from the WebhookManager.
     * @return The webhook created/modified by the WebhookManager instance.
     */
    public DiscordWebhook toWebhook() {
        return webhook;
    }
}
