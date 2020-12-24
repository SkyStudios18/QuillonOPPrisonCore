package me.cosmic;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.cosmic.Gamemodes.GamemodesInv;

public class OPPCoreCommands implements CommandExecutor {

    static String prefix = ChatColor.GRAY + "[" + ChatColor.GREEN + "Quillon " + ChatColor.BLUE + "Network" + ChatColor.GRAY + "] ";
    static String noperm = ChatColor.GRAY + "[" + ChatColor.RED + "WARNING" + ChatColor.GRAY + "] " + ChatColor.AQUA + "You do not have permission ";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        Player p = (Player) sender;


        if(cmd.getName().equalsIgnoreCase("gamemodegui")) {
            if(p.hasPermission("qn.opp.gamemodegui")) {
                p.openInventory(GamemodesInv);
            }
            else {
                p.sendMessage(prefix + noperm + ChatColor.GOLD + "qn.opp.gamemode");
            }
        }

        if(cmd.getName().equalsIgnoreCase("clearinv")) {
            if(p.hasPermission("qn.opp.clearinv")) {
                p.getInventory().clear();
                p.sendMessage(prefix + ChatColor.RED + "Inventory Cleared!");
            }
            else {
                p.sendMessage(prefix + noperm + ChatColor.GOLD + "qn.opp.clearinv");
            }
        }

        return false;
    }
}
