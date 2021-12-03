package dev.waterdog.plugins.commands.commands;

import dev.waterdog.waterdogpe.command.Command;
import dev.waterdog.waterdogpe.command.CommandSender;
import dev.waterdog.waterdogpe.command.CommandSettings;
import dev.waterdog.waterdogpe.player.ProxiedPlayer;

public class GotoCommand extends Command {

    public GotoCommand() {
        super("goto", CommandSettings.builder().setPermission("waterdog.example.goto")
                .setUsageMessage("goto <name>")
                .setDescription("Teleport to another player on the proxy")
                .build());
    }

    @Override
    public boolean onExecute(CommandSender sender, String alias, String[] args) {
        if (!sender.isPlayer()) {
            sender.sendMessage("This command can only be ran by players");
            return false;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;
        if (args.length <= 0) {
            return false;
        }

        final String playerName = args[0];
        ProxiedPlayer target = player.getProxy().getPlayer(playerName);
        if (target == null) {
            player.sendMessage("§cA player with that name is not online right now");
            return true;
        }

        player.sendMessage("§cYou are being connected to §e" + target.getName() + " §con §e" + target.getServerInfo().getServerName() + "§c..");
        player.connect(target.getServerInfo());
        return true;
    }
}
