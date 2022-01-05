package at.cracki.freshticket.files;

import at.cracki.freshticket.main.FreshTicket;
import at.cracki.freshticket.utils.ArraysManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

/*

    The Ultimate Class. The Configuration. It saves every important value, which may be changed later.

 */

public class Configuration {
    private static File file = new File("plugins/FreshTicket", "Config.yml");

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

        cfg.addDefault("Messages.Prefix", "&7[&a&lFreshTicket&7] ");
        cfg.addDefault("Messages.NoPerms", "&cYou don't have Permission!");
        cfg.addDefault("Messages.NotPlayer", "&cYou have to be a Player");
        cfg.addDefault("Messages.Usage", "&cUsage: ");
        cfg.addDefault("Message.Join.Use", Boolean.TRUE);
        cfg.addDefault("Messages.PlayerJoinMessage", "&a&l+ &f%player% &ejoined the game.");
        cfg.addDefault("Message.Quit.Use", Boolean.TRUE);
        cfg.addDefault("Messages.PlayerQuitMessage", "&c&l- &f%player% &eleft the game.");
        cfg.addDefault("Messages.LoggedInStaff", "&aYou have been successfully logged into the support system.");
        cfg.addDefault("Messages.LoggedOutStaff", "&cYou have been successfully logged out of the support system.");

        cfg.addDefault("Support.GUI.Title", "&b&lSupport GUI");
        cfg.addDefault("Support.Confirm.Title", "&f&lPlease confirm Ticket Creation!");
        cfg.addDefault("Support.Confirm.Name", "&a&lConfirm");
        cfg.addDefault("Support.Cancel.Name", "&c&lCancel");

        cfg.addDefault("Support.Case1.Name", "&f&lGeneral Help");
        cfg.addDefault("Support.Case2.Name", "&f&lDiscord Related");
        cfg.addDefault("Support.Case3.Name", "&f&lForum Related");
        cfg.addDefault("Support.Case4.Name", "&f&lTeamspeak Related");
        cfg.addDefault("Support.Case5.Name", "&f&lRulebreaker Found");
        cfg.addDefault("Support.Case6.Name", "&f&lFeedback & Suggestions");
        cfg.addDefault("Support.Case7.Name", "&f&lI want to apply");

        cfg.addDefault("Support.Case1.Lore", ArraysManager.returnCase1Lore());
        cfg.addDefault("Support.Case2.Lore", ArraysManager.returnCase2Lore());
        cfg.addDefault("Support.Case3.Lore", ArraysManager.returnCase3Lore());
        cfg.addDefault("Support.Case4.Lore", ArraysManager.returnCase4Lore());
        cfg.addDefault("Support.Case5.Lore", ArraysManager.returnCase5Lore());
        cfg.addDefault("Support.Case6.Lore", ArraysManager.returnCase6Lore());
        cfg.addDefault("Support.Case7.Lore", ArraysManager.returnCase7Lore());

        cfg.addDefault("Support.Level1.Name", "&a&lLow priority");
        cfg.addDefault("Support.Level2.Name", "&e&lMedium priority");
        cfg.addDefault("Support.Level3.Name", "&6&lHigh Priority");
        cfg.addDefault("Support.Level4.Name", "&c&lVery high Priority");

        cfg.addDefault("Support.Level1.Lore", ArraysManager.returnLevel1Lore());
        cfg.addDefault("Support.Level2.Lore", ArraysManager.returnLevel2Lore());
        cfg.addDefault("Support.Level3.Lore", ArraysManager.returnLevel3Lore());
        cfg.addDefault("Support.Level4.Lore", ArraysManager.returnLevel4Lore());

        cfg.addDefault("Title.Join.Use", Boolean.TRUE);
        cfg.addDefault("Title.Join.Title", "&cWelcome");
        cfg.addDefault("Title.Join.Subtitle", "&cto out server!");

        cfg.addDefault("Scoreboard.Normal.Use", Boolean.FALSE);
        cfg.addDefault("Scoreboard.Normal.Title", "  &a&lSERVER  ");

        cfg.addDefault("Scoreboard.Normal.Class1", "&f&lServer:");
        cfg.addDefault("Scoreboard.Normal.Class1Color", "&a");

        cfg.addDefault("Scoreboard.Normal.Class2", "&f&lTeamSpeak:");
        cfg.addDefault("Scoreboard.Normal.Class2Color", "&a");

        cfg.addDefault("Scoreboard.Normal.Class3", "&f&lDiscord:");
        cfg.addDefault("Scoreboard.Normal.Class3Color", "&a");


        cfg.addDefault("Scoreboard.Animated.Use", Boolean.TRUE);
        cfg.addDefault("Scoreboard.Animated.Title", ArraysManager.returnSBTitle());

        cfg.addDefault("Scoreboard.Animated.Class1", "&f&lServer:");
        cfg.addDefault("Scoreboard.Animated.Class1Color", "&a");

        cfg.addDefault("Scoreboard.Animated.Class2", "&f&lTeamSpeak:");
        cfg.addDefault("Scoreboard.Animated.Class2Color", "&a");

        cfg.addDefault("Scoreboard.Animated.Class3", "&f&lDiscord:");
        cfg.addDefault("Scoreboard.Animated.Class3Color", "&a");

        cfg.addDefault("ChatFormat.Use", Boolean.TRUE);
        cfg.addDefault("ChatFormat.Format", "&a%PLAYER&7 | &fMESSAGE%");

        Bukkit.getConsoleSender().sendMessage(String.valueOf(cfg.getString("Messages.Prefix").replaceAll("&", "§")) + "config.yml was configured successfully.");
        saveCFG();
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }

    // Saves everything written in the Config into the HashMaps in the FreshTicket Main Class.
    public static void setCache() {
        FreshTicket.stringsettings.put("WebhookURL", cfg.getString("Discord.WebhookURL"));

        FreshTicket.messages.put("Prefix", cfg.getString("Messages.Prefix").replace("&", "§"));
        FreshTicket.messages.put("NoPerms", cfg.getString("Messages.NoPerms").replace("&", "§"));
        FreshTicket.messages.put("NotPlayer", cfg.getString("Messages.NotPlayer").replace("&", "§"));
        FreshTicket.messages.put("Usage", cfg.getString("Messages.Usage").replace("&", "§"));
        FreshTicket.messages.put("PlayerJoinMessage", cfg.getString("Messages.PlayerJoinMessage").replace("&", "§"));
        FreshTicket.messages.put("PlayerQuitMessage", cfg.getString("Messages.PlayerQuitMessage").replace("&", "§"));
        FreshTicket.messages.put("LoggedInStaff", cfg.getString("Messages.LoggedInStaff").replace("&", "§"));
        FreshTicket.messages.put("LoggedOutStaff", cfg.getString("Messages.LoggedOutStaff").replace("&", "§"));

        FreshTicket.inventorytitles.put("SupportGUITitle", cfg.getString("Support.GUI.Title").replace("&", "§"));
        FreshTicket.inventorytitles.put("SupportConfirmTitle", cfg.getString("Support.Confirm.Title").replace("&", "§"));
        FreshTicket.itemnames.put("SupportConfirmName", cfg.getString("Support.Confirm.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCancelName", cfg.getString("Support.Cancel.Name").replace("&", "§"));

        FreshTicket.itemnames.put("SupportCase1Name", cfg.getString("Support.Case1.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase2Name", cfg.getString("Support.Case2.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase3Name", cfg.getString("Support.Case3.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase4Name", cfg.getString("Support.Case4.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase5Name", cfg.getString("Support.Case5.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase6Name", cfg.getString("Support.Case6.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase7Name", cfg.getString("Support.Case7.Name").replace("&", "§"));

        FreshTicket.itemnames.put("SupportCase1Lore", cfg.getString("Support.Case1.Lore").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase2Lore", cfg.getString("Support.Case2.Lore").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase3Lore", cfg.getString("Support.Case3.Lore").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase4Lore", cfg.getString("Support.Case4.Lore").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase5Lore", cfg.getString("Support.Case5.Lore").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase6Lore", cfg.getString("Support.Case6.Lore").replace("&", "§"));
        FreshTicket.itemnames.put("SupportCase7Lore", cfg.getString("Support.Case7.Lore").replace("&", "§"));

        FreshTicket.itemnames.put("SupportLevel1Name", cfg.getString("Support.Level1.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportLevel2Name", cfg.getString("Support.Level2.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportLevel3Name", cfg.getString("Support.Level3.Name").replace("&", "§"));
        FreshTicket.itemnames.put("SupportLevel4Name", cfg.getString("Support.Level4.Name").replace("&", "§"));

        FreshTicket.itemnames.put("SupportLevel1Lore", cfg.getString("Support.Level1.Lore").replace("&", "§"));
        FreshTicket.itemnames.put("SupportLevel2Lore", cfg.getString("Support.Level2.Lore").replace("&", "§"));
        FreshTicket.itemnames.put("SupportLevel3Lore", cfg.getString("Support.Level3.Lore").replace("&", "§"));
        FreshTicket.itemnames.put("SupportLevel4Lore", cfg.getString("Support.Level4.Lore").replace("&", "§"));

        FreshTicket.booleansettings.put("ChatFormat", cfg.getBoolean("ChatFormat.Use"));
        FreshTicket.stringsettings.put("ChatFormat", cfg.getString("ChatFormat.Format").replace("&", "§"));
        FreshTicket.booleansettings.put("TitleJoin", cfg.getBoolean("Title.Join.Use"));
        FreshTicket.booleansettings.put("JoinMessage", cfg.getBoolean("Message.Join.Use"));
        FreshTicket.booleansettings.put("QuitMessage", cfg.getBoolean("Message.Quit.Use"));

        FreshTicket.titles.put("Join", cfg.getString("Title.Join.Title").replace("&", "§")); FreshTicket.subtitles.put("Join", cfg.getString("Title.Join.Subtitle").replace("&", "§"));

        FreshTicket.booleansettings.put("Scoreboard.Normal", cfg.getBoolean("Scoreboard.Normal.Use"));
        FreshTicket.scoreboardnormal.put("SBNTitle", cfg.getString("Scoreboard.Normal.Title").replace("&", "§"));
        FreshTicket.scoreboardnormal.put("SBNClass1", cfg.getString("Scoreboard.Normal.Class1").replace("&", "§"));
        FreshTicket.scoreboardnormal.put("SBNClass1Color", cfg.getString("Scoreboard.Normal.Class1Color").replace("&", "§"));
        FreshTicket.scoreboardnormal.put("SBNClass2", cfg.getString("Scoreboard.Normal.Class2").replace("&", "§"));
        FreshTicket.scoreboardnormal.put("SBNClass2Color", cfg.getString("Scoreboard.Normal.Class2Color").replace("&", "§"));
        FreshTicket.scoreboardnormal.put("SBNClass3", cfg.getString("Scoreboard.Normal.Class3").replace("&", "§"));
        FreshTicket.scoreboardnormal.put("SBNClass3Color", cfg.getString("Scoreboard.Normal.Class3Color").replace("&", "§"));

        FreshTicket.booleansettings.put("Scoreboard.Animated", cfg.getBoolean("Scoreboard.Animated.Use"));

        List<String> list = cfg.getStringList("Scoreboard.Animated.Title");
        list.replaceAll(text -> org.bukkit.ChatColor.translateAlternateColorCodes('&', text));
        FreshTicket.scoreboardanimated.put("SBATitle", String.valueOf(list));

        FreshTicket.scoreboardanimated.put("SBAClass1", cfg.getString("Scoreboard.Animated.Class1").replace("&", "§"));
        FreshTicket.scoreboardanimated.put("SBAClass1Color", cfg.getString("Scoreboard.Animated.Class1Color").replace("&", "§"));
        FreshTicket.scoreboardanimated.put("SBAClass2", cfg.getString("Scoreboard.Animated.Class2").replace("&", "§"));
        FreshTicket.scoreboardanimated.put("SBAClass2Color", cfg.getString("Scoreboard.Animated.Class2Color").replace("&", "§"));
        FreshTicket.scoreboardanimated.put("SBAClass3", cfg.getString("Scoreboard.Animated.Class3").replace("&", "§"));
        FreshTicket.scoreboardanimated.put("SBAClass3Color", cfg.getString("Scoreboard.Animated.Class3Color").replace("&", "§"));

        Bukkit.getConsoleSender().sendMessage((FreshTicket.messages.get("Prefix")) + "Config.yml wurde geladen.");
    }
}
