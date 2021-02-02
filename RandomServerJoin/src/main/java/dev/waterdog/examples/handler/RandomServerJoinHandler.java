package dev.waterdog.examples.handler;

import com.google.common.collect.Iterables;
import pe.waterdog.network.ServerInfo;
import pe.waterdog.player.ProxiedPlayer;
import pe.waterdog.utils.types.IJoinHandler;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class RandomServerJoinHandler implements IJoinHandler {
    @Override
    public ServerInfo determineServer(ProxiedPlayer proxiedPlayer) {
        Collection<ServerInfo> servers = proxiedPlayer.getProxy().getServers();
        if (servers.size() > 0) {
            return Iterables.get(servers, ThreadLocalRandom.current().nextInt(servers.size()));
        }
        return null;
    }
}
