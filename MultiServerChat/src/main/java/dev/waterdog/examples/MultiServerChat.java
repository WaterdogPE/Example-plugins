package dev.waterdog.examples;

import dev.waterdog.event.defaults.PlayerChatEvent;
import dev.waterdog.player.ProxiedPlayer;
import dev.waterdog.plugin.Plugin;
import dev.waterdog.utils.Configuration;


public class MultiServerChat extends Plugin {

    private String format;

    public void onEnable() {
        saveResource("config.yml");
        Configuration cfg = getConfig();
        format = cfg.getString("chat_format");
        this.getProxy().getEventManager().subscribe(PlayerChatEvent.class, this::onChat);
    }

    public void onChat(PlayerChatEvent event) {
        event.setCancelled();
        for (ProxiedPlayer p : getProxy().getPlayers().values()) {
            p.sendMessage(format.replace("{PLAYER}", event.getPlayer().getName()).replace("{MSG}", event.getMessage()));
        }
    }
}
