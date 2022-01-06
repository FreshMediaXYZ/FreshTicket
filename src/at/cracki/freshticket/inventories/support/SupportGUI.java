package at.cracki.freshticket.inventories.support;

import at.cracki.freshticket.discord.DiscordWebhook;
import at.cracki.freshticket.discord.WebhookManager;
import at.cracki.freshticket.main.FreshTicket;
import at.cracki.freshticket.utils.Item;
import at.cracki.freshticket.utils.Menu;
import at.cracki.freshticket.utils.PlayerMenuUtility;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.io.IOException;

public class SupportGUI extends Menu {

    /*

        Class which creates the SupportGUI using the Menu and PlayerMenuUtility Classes.

     */

    private String webhookURL = FreshTicket.stringsettings.get("WebhookURL");

    public SupportGUI(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return FreshTicket.inventorytitles.get("SupportGUITitle");
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent event) {
        ItemStack i = event.getCurrentItem();
        ItemMeta im = i.getItemMeta();
        Player player = (Player) event.getWhoClicked();
        if(i.getItemMeta() == null) return;
        if(i.getItemMeta().getDisplayName().equals(FreshTicket.itemnames.get("SupportCase1Name"))) {
            im.addEnchant(Enchantment.DURABILITY, 1, true);
            im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            i.setItemMeta(im);
/*            String webhookURL = FreshTicket.stringsettings.get("WebhookURL");
            DiscordWebhook webhook = new WebhookManager(new DiscordWebhook(webhookURL))
                    .setEmbed()
                    .setDescription("A Ticket has been created!")
                    .setTitle("Ticket System Notification")
                    .addField("Case", "Case1", true)
                    .addField("Priority", "Case2", true)
                    .setImage("https://i.imgur.com/1MxIktF.png")
                    .setAuthor("FreshTicket", "", "")
                    .setColor(252, 32, 3)
                    .setThumbnail("https://i.imgur.com/lSGOy57.png")
                    .setFooter("Developed by CalledCracki & JamesLikesIDE (@FreshMedia)",
                                "https://i.imgur.com/lSGOy57.png").execute().toWebhook();
            webhook.setContent("@Cracki **" + player.getName() + "** has created a Ticket!");
            webhook.setAvatarUrl("https://i.imgur.com/4GP7kZ2.png");
            webhook.setUsername("FreshTicket System");
            */
        }
    }

    @Override
    public void setMenuItems() {
        addMenuBorder();

        ItemStack i1 = new Item(Material.BOOK).setName(FreshTicket.itemnames.get("SupportCase1Name"))
                .setLore(FreshTicket.itemnames.get("SupportCase1Lore")).toItemStack();
        ItemStack i2 = new Item(Material.BOOK).setName(FreshTicket.itemnames.get("SupportCase2Name"))
                .setLore(FreshTicket.itemnames.get("SupportCase2Lore")).toItemStack();
        ItemStack i3 = new Item(Material.BOOK).setName(FreshTicket.itemnames.get("SupportCase3Name"))
                .setLore(FreshTicket.itemnames.get("SupportCase3Lore")).toItemStack();
        ItemStack i4 = new Item(Material.BOOK).setName(FreshTicket.itemnames.get("SupportCase4Name"))
                .setLore(FreshTicket.itemnames.get("SupportCase4Lore")).toItemStack();

        ItemStack i5 = new Item(Material.BOOK).setName(FreshTicket.itemnames.get("SupportCase5Name"))
                .setLore(FreshTicket.itemnames.get("SupportCase5Lore")).toItemStack();
        ItemStack i6 = new Item(Material.BOOK).setName(FreshTicket.itemnames.get("SupportCase6Name"))
                .setLore(FreshTicket.itemnames.get("SupportCase6Lore")).toItemStack();
        ItemStack i7 = new Item(Material.BOOK).setName(FreshTicket.itemnames.get("SupportCase7Name"))
                .setLore(FreshTicket.itemnames.get("SupportCase7Lore")).toItemStack();

        ItemStack p1 = new Item(Material.GREEN_DYE).setName(FreshTicket.itemnames.get("SupportLevel1Name"))
                .setLore(FreshTicket.itemnames.get("SupportLevel1Lore")).toItemStack();
        ItemStack p2 = new Item(Material.YELLOW_DYE).setName(FreshTicket.itemnames.get("SupportLevel2Name"))
                .setLore(FreshTicket.itemnames.get("SupportLevel2Lore")).toItemStack();
        ItemStack p3 = new Item(Material.ORANGE_DYE).setName(FreshTicket.itemnames.get("SupportLevel3Name"))
                .setLore(FreshTicket.itemnames.get("SupportLevel3Lore")).toItemStack();
        ItemStack p4 = new Item(Material.RED_DYE).setName(FreshTicket.itemnames.get("SupportLevel4Name"))
                .setLore(FreshTicket.itemnames.get("SupportLevel4Lore")).toItemStack();

        inventory.setItem(10, i1);
        inventory.setItem(12, i2);
        inventory.setItem(14, i3);
        inventory.setItem(16, i4);

        inventory.setItem(20, i5);
        inventory.setItem(22, i6);
        inventory.setItem(24, i7);

        inventory.setItem(37, p1);
        inventory.setItem(39, p2);
        inventory.setItem(41, p3);
        inventory.setItem(43, p4);
    }

    // unnecessary - just leave it as it is.
/*    public void openSupportGUI(Player player) {



        ItemMeta i1m = i1.getItemMeta();
        ItemMeta i2m = i2.getItemMeta();
        ItemMeta i3m = i3.getItemMeta();
        ItemMeta i4m = i4.getItemMeta();

        ItemMeta i5m = i5.getItemMeta();
        ItemMeta i6m = i6.getItemMeta();
        ItemMeta i7m = i7.getItemMeta();

        ItemMeta p1m = p1.getItemMeta();
        ItemMeta p2m = p2.getItemMeta();
        ItemMeta p3m = p3.getItemMeta();
        ItemMeta p4m = p4.getItemMeta();



        player.openInventory(gui);
    }*/
}
