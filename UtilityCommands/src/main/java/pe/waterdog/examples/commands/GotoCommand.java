package pe.waterdog.examples.commands;

import pe.waterdog.command.Command;
import pe.waterdog.command.CommandSender;
import pe.waterdog.command.CommandSettings;
import pe.waterdog.player.ProxiedPlayer;

public class GotoCommand extends Command {

    public GotoCommand() {
        super("goto", CommandSettings.builder().setPermission("waterdog.example.goto")
                .setUsageMessage("Use /goto <Name>")
                .setDescription("Teleport to another player on the proxy")
                .build());
    }

    @Override
    public boolean onExecute(CommandSender commandSender, String s, String[] strings) {
        if (commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) commandSender;
            if (strings.length > 0) {
                final String playerName = strings[0];
                ProxiedPlayer target = player.getProxy().getPlayer(playerName);
                if (target != null) {
                    player.sendMessage("§cYou are being connected to §e" + target.getName() + " §con §e" + target.getServer().getInfo().getServerName() + "§c..");
                    player.connect(target.getServer().getInfo());
                    return true;
                } else {
                    player.sendMessage("§cA player with that name is not online right now");
                }
            } else {
                player.sendMessage(this.getUsageMessage());
            }
        } else {
            commandSender.sendMessage("This command can only be ran by players");
        }
        return false;
    }
}
