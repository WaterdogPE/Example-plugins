package dev.waterdog.plugins.commands.commands;

import com.nukkitx.network.raknet.RakNetPong;
import dev.waterdog.waterdogpe.ProxyServer;
import dev.waterdog.waterdogpe.command.Command;
import dev.waterdog.waterdogpe.command.CommandSender;
import dev.waterdog.waterdogpe.command.CommandSettings;
import dev.waterdog.waterdogpe.network.serverinfo.ServerInfo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ServerPingCommand extends Command {

    public ServerPingCommand() {
        super("serverping", CommandSettings.builder()
                .setUsageMessage("serverping <serverName>")
                .setPermission("waterdog.examples.serverping")
                .setDescription("Pings a downstream server to check if its online, and if it is, gets its latency").build());
    }

    @Override
    public boolean onExecute(CommandSender sender, String alias, String[] args) {
        if (args.length < 1) {
            return false;
        }

        String serverName = args[0];
        ServerInfo targetServer = ProxyServer.getInstance().getServerInfo(serverName);
        if (targetServer == null) {
            sender.sendMessage("A server with that name could not be found.");
            return true;
        }

        CompletableFuture<RakNetPong> request = targetServer.ping(5, TimeUnit.SECONDS);
        request.whenComplete((response, t) -> {
            if (t == null && response != null) {
                sender.sendMessage("§cLatency to §e" + serverName + "§c: §e" + (response.getPongTime() - response.getPingTime()) + "ms");
            } else if (t != null) {
                sender.sendMessage("§cError while pinging §e" + serverName + "§c: " + t.getMessage());
            } else {
                sender.sendMessage("§cAn error occurred while pinging " + serverName);
            }
        });
        return true;
    }
}
