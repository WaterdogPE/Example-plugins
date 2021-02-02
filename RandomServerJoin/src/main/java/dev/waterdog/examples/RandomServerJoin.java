package dev.waterdog.examples;

import dev.waterdog.examples.handler.RandomServerJoinHandler;
import pe.waterdog.plugin.Plugin;

public class RandomServerJoin extends Plugin {
    @Override
    public void onEnable() {
        this.getProxy().setJoinHandler(new RandomServerJoinHandler());
    }
}
