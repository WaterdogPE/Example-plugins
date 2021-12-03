package dev.waterdog.plugins.commands.commands;

import dev.waterdog.waterdogpe.ProxyServer;
import dev.waterdog.waterdogpe.command.Command;
import dev.waterdog.waterdogpe.command.CommandSender;
import dev.waterdog.waterdogpe.command.CommandSettings;
import dev.waterdog.waterdogpe.network.serverinfo.BedrockServerInfo;

import java.net.InetSocketAddress;

public class AddServerCommand extends Command {

    public AddServerCommand() {
        super("addserver", CommandSettings.builder()
                .setDescription("Add a Server to the server list")
                .setUsageMessage("addserver <Name> <IP> <Port>")
                .setPermission("waterdog.example.addserver").build());
    }

    @Override
    public boolean onExecute(CommandSender sender, String alias, String[] args) {
        if (args.length < 3) {
            return false;
        }
        BedrockServerInfo i = new BedrockServerInfo(args[0], new InetSocketAddress(args[1], Integer.parseInt(args[2])), null);
        ProxyServer.getInstance().registerServerInfo(i);
        sender.sendMessage("Server added successfully!");
        return true;
    }
}
