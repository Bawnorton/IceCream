package com.bawnorton.config;

import com.bawnorton.IceCreamClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path configPath = FabricLoader.getInstance().getConfigDir().resolve(IceCreamClient.MOD_ID + ".json");

    public static void loadConfig() {
        Config config = load();

        if(config.flavour == null) config.flavour = Config.Flavour.VANILLA;

        Config.update(config);
        save();
        IceCreamClient.LOGGER.info("Loaded config");
    }

    private static Config load() {
        Config config = Config.getInstance();
        try {
            if (!Files.exists(configPath)) {
                Files.createDirectories(configPath.getParent());
                Files.createFile(configPath);
                return config;
            }
            try {
                config = GSON.fromJson(Files.newBufferedReader(configPath), Config.class);
            } catch (JsonSyntaxException e) {
                IceCreamClient.LOGGER.error("Failed to parse config file, using default config");
                config = Config.getInstance();
            }
        } catch (IOException e) {
            IceCreamClient.LOGGER.error("Failed to load config", e);
        }
        return config == null ? Config.getInstance() : config;
    }

    private static void save() {
        try {
            Files.write(configPath, GSON.toJson(Config.getInstance()).getBytes());
        } catch (IOException e) {
            IceCreamClient.LOGGER.error("Failed to save config", e);
        }
    }

    public static void saveConfig() {
        Config.getInstance().flavour = Config.Flavour.of(IceCreamClient.FLAVOUR);
        save();
        IceCreamClient.LOGGER.info("Saved config");
    }
}
