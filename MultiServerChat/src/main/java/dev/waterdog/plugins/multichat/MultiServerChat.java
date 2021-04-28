package dev.waterdog.plugins.multichat;

import dev.waterdog.waterdogpe.event.defaults.PlayerChatEvent;
import dev.waterdog.waterdogpe.player.ProxiedPlayer;
import dev.waterdog.waterdogpe.plugin.Plugin;

public class MultiServerChat extends Plugin {

    private String format;

    public void onEnable() {
        this.format = this.getConfig().getString("chat_format");
        this.getProxy().getEventManager().subscribe(PlayerChatEvent.class, this::onChat);
    }

    public void onChat(PlayerChatEvent event) {
        for (ProxiedPlayer player : this.getProxy().getPlayers().values()) {
            player.sendMessage(this.format.replace("{PLAYER}", event.getPlayer().getName()).replace("{MSG}", event.getMessage()));
        }
        event.setCancelled(true);
    }
}
