package dev.waterdog.plugins.commands.commands;

import dev.waterdog.waterdogpe.ProxyServer;
import dev.waterdog.waterdogpe.command.Command;
import dev.waterdog.waterdogpe.command.CommandSender;
import dev.waterdog.waterdogpe.command.CommandSettings;

public class RemoveServerCommand extends Command {

    public RemoveServerCommand(){
        super("removeserver", CommandSettings.builder()
                .setPermission("waterdog.example.removeserver")
                .setDescription("Remove a server from the server list")
                .setUsageMessage("removeserver <name>").build());
    }
    @Override
    public boolean onExecute(CommandSender sender, String alias, String[] args) {
        if(args.length < 1){
            return false;
        }

        if(ProxyServer.getInstance().removeServerInfo(args[0]) == null) {
            sender.sendMessage("§cA server with that name could not be found");
            return true;
        }
        sender.sendMessage("Server removed successfully!");
        return false;
    }
}
