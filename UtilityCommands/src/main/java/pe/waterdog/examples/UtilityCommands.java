package pe.waterdog.examples;

import pe.waterdog.examples.commands.AddServerCommand;
import pe.waterdog.examples.commands.GotoCommand;
import pe.waterdog.examples.commands.KickCommand;
import pe.waterdog.examples.commands.ServerPingCommand;
import pe.waterdog.plugin.Plugin;

public class UtilityCommands extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getCommandMap().registerCommand("goto", new GotoCommand());
        getProxy().getCommandMap().registerCommand("kick", new KickCommand());
        getProxy().getCommandMap().registerCommand("serverping", new ServerPingCommand());
        getProxy().getCommandMap().registerCommand("addserver", new AddServerCommand());
    }
}
