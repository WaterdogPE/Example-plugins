package dev.waterdog.examples.commands;

import pe.waterdog.ProxyServer;
import pe.waterdog.command.Command;
import pe.waterdog.command.CommandSender;
import pe.waterdog.command.CommandSettings;
import pe.waterdog.player.ProxiedPlayer;

public class KickCommand extends Command {

    public KickCommand() {
        super("kick", CommandSettings.builder()
                .setDescription("Kick a player from the server")
                .setPermission("waterdog.example.kick")
                .setUsageMessage("Please use /kick <Player> <Reason>").build());
    }

    @Override
    public boolean onExecute(CommandSender commandSender, String s, String[] strings) {
        if (strings.length >= 2) {
            final String playerName = strings[0];
            final ProxiedPlayer p = ProxyServer.getInstance().getPlayer(playerName);
            if (p != null) {
                p.disconnect(strings[1]);
                commandSender.sendMessage("§aPlayer kicked successfully.");
                return true;
            } else {
                commandSender.sendMessage("§cA player with the name §e" + strings[0] + " §ccould not be found");
            }
        } else {
            commandSender.sendMessage(getUsageMessage());
        }
        return false;
    }
}
