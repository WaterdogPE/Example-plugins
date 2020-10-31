package pe.waterdog.examples;

import pe.waterdog.examples.handler.RandomServerJoinHandler;
import pe.waterdog.plugin.Plugin;

public class RandomServerJoin extends Plugin {
    @Override
    public void onEnable() {
        this.getProxy().setJoinHandler(new RandomServerJoinHandler());
    }
}
