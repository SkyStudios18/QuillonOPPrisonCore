package me.cosmic;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Bukkit.getServer;

public class Gamemodes implements Listener {
    static String prefix = ChatColor.GREEN + "Quillon " + ChatColor.BLUE + "Network ";
    static String GamemodesInvDisplay = prefix + ChatColor.AQUA + "Gamemodes";

    final String CreativeISDisplay = ChatColor.GOLD + "Creative";
    final String SurvivalISDisplay = ChatColor.GOLD + "Survival";
    final String AdventurerISDisplay = ChatColor.GOLD + "Adventurer";
    final String SpectatorISDisplay = ChatColor.GOLD + "Spectator";
    final String EmptyISDisplay = ChatColor.AQUA + "-";

    static Inventory GamemodesInv = getServer().createInventory(null, 9, GamemodesInvDisplay);

    @EventHandler
    public void onInvClick (InventoryClickEvent e) {

        if(e.getView().getTitle().equals(GamemodesInvDisplay)) {
            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
            }
        }

        Player p = (Player) e.getWhoClicked();


        ItemStack CreativeIS = new ItemStack(Material.FEATHER, 1);
        ItemMeta CreativeISMeta = CreativeIS.getItemMeta();
        if (CreativeISMeta != null) {
            CreativeISMeta.setDisplayName(CreativeISDisplay);
            CreativeISMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            CreativeISMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            CreativeISMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            CreativeIS.setItemMeta(CreativeISMeta);
        }

        ItemStack SurvivalIS = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta SurvivalISMeta = SurvivalIS.getItemMeta();
        if (SurvivalISMeta != null) {
            SurvivalISMeta.setDisplayName(SurvivalISDisplay);
            SurvivalISMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            SurvivalISMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            SurvivalISMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            SurvivalIS.setItemMeta(SurvivalISMeta);
        }

        ItemStack AdventurerIS = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta AdventurerISMeta = AdventurerIS.getItemMeta();
        if (AdventurerISMeta != null) {
            AdventurerISMeta.setDisplayName(AdventurerISDisplay);
            AdventurerISMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            AdventurerISMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            AdventurerISMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            AdventurerIS.setItemMeta(AdventurerISMeta);
        }

        ItemStack SpectatorIS = new ItemStack(Material.IRON_BARS, 1);
        ItemMeta SpectatorISMeta = SpectatorIS.getItemMeta();
        if (SpectatorISMeta != null) {
            SpectatorISMeta.setDisplayName(SpectatorISDisplay);
            SpectatorISMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            SpectatorISMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            SpectatorISMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            SpectatorIS.setItemMeta(SpectatorISMeta);
        }

        ItemStack EmptyIS = new ItemStack(Material.GLASS_PANE, 1);
        ItemMeta EmptyISMeta = EmptyIS.getItemMeta();
        if (EmptyISMeta != null) {
            EmptyISMeta.setDisplayName(EmptyISDisplay);
            EmptyISMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            EmptyISMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            EmptyISMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            EmptyIS.setItemMeta(EmptyISMeta);
        }


        GamemodesInv.setItem(0, EmptyIS);
        GamemodesInv.setItem(2, EmptyIS);
        GamemodesInv.setItem(4, EmptyIS);
        GamemodesInv.setItem(6, EmptyIS);
        GamemodesInv.setItem(8, EmptyIS);

        GamemodesInv.setItem(1, CreativeIS);
        GamemodesInv.setItem(3, SurvivalIS);
        GamemodesInv.setItem(5, AdventurerIS);
        GamemodesInv.setItem(7, SpectatorIS);


        ClickType click = e.getClick();
        Inventory open = e.getClickedInventory();
        ItemStack item = e.getCurrentItem();

        if(open == null) {
            return;
        }
        if(e.getView().getTitle().equals(GamemodesInvDisplay)) {

            e.setCancelled(true);

            if(item == (null) || !item.hasItemMeta()) {
                return;
            }

            if(item.getItemMeta() != null && item.getItemMeta().getDisplayName().equals(CreativeISDisplay)) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage("Gamemode Updated to Creative");
            }
            else if(item.getItemMeta() != null && item.getItemMeta().getDisplayName().equals(SurvivalISDisplay)) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage("Gamemode Updated to Survival");
            }
            else if(item.getItemMeta() != null && item.getItemMeta().getDisplayName().equals(AdventurerISDisplay)) {
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage("Gamemode Updated to Adventurer");
            }
            else if(item.getItemMeta() != null && item.getItemMeta().getDisplayName().equals(SpectatorISDisplay)) {
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage("Gamemode Updated to Spectator");
            }
        }
    }
}
