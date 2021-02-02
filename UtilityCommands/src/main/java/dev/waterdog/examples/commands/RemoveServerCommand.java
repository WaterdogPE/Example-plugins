package dev.waterdog.examples.commands;

import pe.waterdog.ProxyServer;
import pe.waterdog.command.Command;
import pe.waterdog.command.CommandSender;
import pe.waterdog.command.CommandSettings;

public class RemoveServerCommand extends Command {

    public RemoveServerCommand(){
        super("removeserver", CommandSettings.builder()
                .setPermission("waterdog.example.removeserver")
                .setDescription("Remove a server from the server list")
                .setUsageMessage("/removeserver <Name>").build());
    }
    @Override
    public boolean onExecute(CommandSender commandSender, String s, String[] strings) {
        if(strings.length == 0){
            commandSender.sendMessage(this.getUsageMessage());
            return false;
        }

        if( ProxyServer.getInstance().removeServerInfo(strings[0]) != null ) {
            commandSender.sendMessage("Server removed successfully!");
            return true;
        }else {
            commandSender.sendMessage("§cA server with that name could not be found");
        }

        return false;
    }
}
