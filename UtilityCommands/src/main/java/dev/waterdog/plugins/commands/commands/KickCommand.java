package dev.waterdog.plugins.commands.commands;

import dev.waterdog.waterdogpe.ProxyServer;
import dev.waterdog.waterdogpe.command.Command;
import dev.waterdog.waterdogpe.command.CommandSender;
import dev.waterdog.waterdogpe.command.CommandSettings;
import dev.waterdog.waterdogpe.player.ProxiedPlayer;

import java.util.Arrays;

public class KickCommand extends Command {

    public KickCommand() {
        super("kick", CommandSettings.builder()
                .setDescription("Kick a player from the server")
                .setPermission("waterdog.example.kick")
                .setUsageMessage("kick <player> <reason>").build());
    }

    @Override
    public boolean onExecute(CommandSender sender, String alias, String[] args) {
        if (args.length < 2) {
            return false;
        }

        String playerName = args[0];
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(playerName);
        if (player == null) {
            sender.sendMessage("§cA player with the name §e" + args[0] + " §ccould not be found");
            return true;
        }

        sender.sendMessage("§aPlayer kicked successfully.");
        player.disconnect(String.join(" ", Arrays.copyOfRange(args, 1, args.length)));
        return false;
    }
}
