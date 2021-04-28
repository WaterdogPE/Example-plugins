package dev.waterdog.plugins.randomjoin;

import dev.waterdog.plugins.randomjoin.handler.RandomServerJoinHandler;
import dev.waterdog.waterdogpe.plugin.Plugin;

public class RandomServerJoin extends Plugin {

    @Override
    public void onEnable() {
        this.getProxy().setJoinHandler(new RandomServerJoinHandler());
    }
}
