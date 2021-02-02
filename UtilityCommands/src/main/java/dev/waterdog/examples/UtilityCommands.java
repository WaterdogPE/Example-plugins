package dev.waterdog.examples;

import dev.waterdog.examples.commands.GotoCommand;
import dev.waterdog.examples.commands.ServerPingCommand;
import dev.waterdog.examples.commands.AddServerCommand;
import dev.waterdog.examples.commands.KickCommand;
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
