package dev.waterdog.examples.handler;

import com.google.common.collect.Iterables;
import dev.waterdog.network.ServerInfo;
import dev.waterdog.player.ProxiedPlayer;
import dev.waterdog.utils.types.IJoinHandler;

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
