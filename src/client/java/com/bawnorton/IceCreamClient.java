package com.bawnorton;

import com.bawnorton.config.Config;
import com.bawnorton.config.ConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IceCreamClient implements ClientModInitializer {
    public static final String MOD_ID = "icecream";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Config.Flavour FLAVOUR;

    @Override
    public void onInitializeClient() {
        ConfigManager.loadConfig();
        FLAVOUR = Config.getInstance().getFlavour();

        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            ConfigManager.saveConfig();
        });
    }
}