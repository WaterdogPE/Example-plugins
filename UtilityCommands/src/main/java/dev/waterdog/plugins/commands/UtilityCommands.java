package dev.waterdog.plugins.commands;

import dev.waterdog.plugins.commands.commands.*;
import dev.waterdog.waterdogpe.plugin.Plugin;

public class UtilityCommands extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().getCommandMap().registerCommand(new GotoCommand());
        this.getProxy().getCommandMap().registerCommand(new KickCommand());
        this.getProxy().getCommandMap().registerCommand(new ServerPingCommand());
        this.getProxy().getCommandMap().registerCommand(new AddServerCommand());
        this.getProxy().getCommandMap().registerCommand(new RemoveServerCommand());
    }
}
