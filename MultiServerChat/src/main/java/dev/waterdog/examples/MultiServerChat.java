package dev.waterdog.examples;

import pe.waterdog.event.defaults.PlayerChatEvent;
import pe.waterdog.player.ProxiedPlayer;
import pe.waterdog.plugin.Plugin;
import pe.waterdog.utils.Configuration;


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
            p.sendMessage(format.replace("{PLAYER}", p.getName()).replace("{MSG}", event.getMessage()));
        }
    }
}
