package dev.waterdog.plugins.randomjoin.handler;

import com.google.common.collect.Iterables;
import dev.waterdog.waterdogpe.network.serverinfo.ServerInfo;
import dev.waterdog.waterdogpe.player.ProxiedPlayer;
import dev.waterdog.waterdogpe.utils.types.IJoinHandler;

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
