package dev.waterdog.examples.commands;

import com.nukkitx.network.raknet.RakNetPong;
import dev.waterdog.ProxyServer;
import dev.waterdog.command.Command;
import dev.waterdog.command.CommandSender;
import dev.waterdog.command.CommandSettings;
import dev.waterdog.network.ServerInfo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ServerPingCommand extends Command {

    public ServerPingCommand() {
        super("serverping", CommandSettings.builder()
                .setUsageMessage("Use /serverping <serverName>")
                .setPermission("waterdog.examples.serverping")
                .setDescription("Pings a downstream server to check if its online, and if it is, gets its latency").build());
    }

    @Override
    public boolean onExecute(CommandSender commandSender, String s, String[] strings) {
        if (strings.length > 0) {
            final String serverName = strings[0];
            final ServerInfo targetServer = ProxyServer.getInstance().getServer(serverName);
            if (targetServer != null) {
                CompletableFuture<RakNetPong> request = targetServer.ping(3, TimeUnit.SECONDS);
                request.whenComplete((response, t) -> {
                    if (t == null && response != null) {
                        commandSender.sendMessage("§cLatency to §e" + serverName + "§c: §e" + (response.getPongTime() - response.getPingTime()) + "ms");
                    } else if (t != null) {
                        commandSender.sendMessage("§cError while pinging §e" + serverName + "§c: " + t.getMessage());
                    } else {
                        commandSender.sendMessage("§cAn error occured while pinging " + serverName);
                    }
                });
                return true;
            } else {
                commandSender.sendMessage("A server with that name could not be found.");
            }
        } else {
            commandSender.sendMessage(getUsageMessage());
        }
        return false;
    }
}
