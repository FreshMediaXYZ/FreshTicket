package at.cracki.freshticket.main;

import at.cracki.freshticket.commands.SupportCMD;
import at.cracki.freshticket.commands.SupportLoginCMD;
import at.cracki.freshticket.files.Configuration;
import at.cracki.freshticket.listener.MenuListener;
import at.cracki.freshticket.listener.PlayerJoinQuitHandler;
import at.cracki.freshticket.utils.DiscordAdvertisement;
import at.cracki.freshticket.utils.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class FreshTicket extends JavaPlugin {
    ConsoleCommandSender cs = Bukkit.getConsoleSender();

    public static FreshTicket instance;

    /*
    Different Hashmaps which save different parameters.
     */

    // Saves messages like Join & Quit Messages or the Prefix.
    public static HashMap<String, String> messages = new HashMap<>();

    // Saves booleans like Usage of Join & Quit Messages
    public static HashMap<String, Boolean> booleansettings = new HashMap<>();

    // Saves String like the Discord WebhookURL or the Chat Format.
    public static HashMap<String, String> stringsettings = new HashMap<>();

    // Saves (Join) Titles.
    public static HashMap<String, String> titles = new HashMap<>();

    // Saves (Join) Subtitles.
    public static HashMap<String, String> subtitles = new HashMap<>();

    // Obviously saves titles of different inventories.
    public static HashMap<String, String> inventorytitles = new HashMap<>();

    // Saves parameters for the normal Scoreboard.
    public static HashMap<String, String> scoreboardnormal = new HashMap<>();

    // Saves parameters for the animated Scoreboard.
    public static HashMap<String, String> scoreboardanimated = new HashMap<>();

    // Saves the Names of items.
    public static HashMap<String, String> itemnames = new HashMap<>();

    // PlayerMenuUtility used for Menu Creation.
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    // ArrayList to save currently logged-in Staff Members.
    public static ArrayList<Player> loggedInMembers = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        Configuration.cfgConfig();
        Configuration.setCache();
        init();
        DiscordAdvertisement.startAds();

        // Method which announces the Start of the Plugin using a Discord Webhook.
/*      String webhookURL = stringsettings.get("WebhookURL");

        DiscordWebhook webhook = new DiscordWebhook(webhookURL);
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setDescription("System was started successfully!")
                .setAuthor("FreshTicket", "", "")
                .setColor(new Color(28, 212, 77))
                .setFooter("Developed by CalledCracki (CEO@FreshMedia)", ""));
        try {
            webhook.execute();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }*/

        this.cs.sendMessage(" ");
        this.cs.sendMessage("§7======================== §6§lFreshTicket §7==========================");
        this.cs.sendMessage(" ");
        this.cs.sendMessage("version: §e" + getDescription().getVersion());
        this.cs.sendMessage(" ");
        this.cs.sendMessage("§6§lFreshTicket §a§lwas successfully enabled!");
        this.cs.sendMessage(" ");
        this.cs.sendMessage("§7===============================================================");
    }

    @Override
    public void onDisable() {
        this.cs.sendMessage(" ");
        this.cs.sendMessage("§7======================== §6§lFreshTicket §7==========================");
        this.cs.sendMessage(" ");
        this.cs.sendMessage("version: §e" + getDescription().getVersion());
        this.cs.sendMessage(" ");
        this.cs.sendMessage("§6§lFreshTicket §c§lhas been disabled!");
        this.cs.sendMessage(" ");
        this.cs.sendMessage("§7===============================================================");
    }

    public void init() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinQuitHandler(), this);
        pm.registerEvents(new MenuListener(), this);

        getCommand("login").setExecutor(new SupportLoginCMD());
        getCommand("support").setExecutor(new SupportCMD());
    }

    public static FreshTicket getInstance() {
        return instance;
    }

    //Provide a player and return a menu system for that player
    //create one if they don't already have one
    public static PlayerMenuUtility getPlayerMenuUtility(Player player) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(player))) { //See if the player has a PlayerMenuUtility "saved" for them

            //This player doesn't. Make one for them add add it to the hashmap
            playerMenuUtility = new PlayerMenuUtility(player);
            playerMenuUtilityMap.put(player, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(player); //Return the object by using the provided player
        }
    }
}
