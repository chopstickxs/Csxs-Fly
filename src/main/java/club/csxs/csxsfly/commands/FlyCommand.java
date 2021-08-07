package club.csxs.csxsfly.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private ArrayList<Player> listofplayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("csxsfly.fly")) {
                    if (listofplayers.contains(player)) {
                        listofplayers.remove(player);
                        player.setAllowFlight(false);
                        player.sendMessage(ChatColor.AQUA + "You can't fly anymore");
                    } else if(!listofplayers.contains(player)) {
                        listofplayers.add(player);
                        player.setAllowFlight(true);
                        player.sendMessage(ChatColor.AQUA + "You can now fly! Go up into the sky!!");
                    }
                }
            }
        } else if(args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);

            if (sender.hasPermission("csxsfly.setOtherPlayerFly")) {
                if (listofplayers.contains(target)) {
                    listofplayers.remove(target);
                    target.setAllowFlight(false);
                    target.sendMessage(ChatColor.AQUA + "You can't fly anymore");
                } else if(!listofplayers.contains(target)) {
                    listofplayers.add(target);
                    target.setAllowFlight(true);
                    target.sendMessage(ChatColor.AQUA + "You can now fly! Go up into the sky!!");
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have permissions to execute this command");
                }
            }
        }


        return true;
    }
}
