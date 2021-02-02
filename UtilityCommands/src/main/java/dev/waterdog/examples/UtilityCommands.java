package dev.waterdog.examples;

import dev.waterdog.examples.commands.*;
import pe.waterdog.plugin.Plugin;

public class UtilityCommands extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getCommandMap().registerCommand("goto", new GotoCommand());
        getProxy().getCommandMap().registerCommand("kick", new KickCommand());
        getProxy().getCommandMap().registerCommand("serverping", new ServerPingCommand());
        getProxy().getCommandMap().registerCommand("addserver", new AddServerCommand());
        getProxy().getCommandMap().registerCommand("removeserver", new RemoveServerCommand());
    }
}
