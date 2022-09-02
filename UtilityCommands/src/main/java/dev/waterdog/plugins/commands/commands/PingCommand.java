package dev.waterdog.plugins.commands.commands;

import dev.waterdog.waterdogpe.ProxyServer;
import dev.waterdog.waterdogpe.command.Command;
import dev.waterdog.waterdogpe.command.CommandSender;
import dev.waterdog.waterdogpe.command.CommandSettings;
import dev.waterdog.waterdogpe.network.serverinfo.BedrockServerInfo;
import dev.waterdog.waterdogpe.player.ProxiedPlayer;

import java.net.InetSocketAddress;

public class PingCommand extends Command {

    public PingCommand() {
        super("ping", CommandSettings.builder()
                .setDescription("Add a Server to the server list")
                .setUsageMessage("ping (name)")
                .setPermission("waterdog.example.ping").build());
    }

    @Override
    public boolean onExecute(CommandSender sender, String alias, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            if (args.length < 1) {
                sender.sendMessage("Your ping: " + ((ProxiedPlayer) sender).getPing() + "ms");
            } else {
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage("§cA player with that name is not online right now");
                } else {
                    sender.sendMessage("Ping of " + args[0] + ": " + target.getPing() + "ms");
                }
            }
        } else {
            ProxyServer.getInstance().getLogger().warning("§cUse this command ingame");
        }
        return true;
    }
}
