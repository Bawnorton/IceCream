package com.bawnorton.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config {
    private static Config INSTANCE;
    @Expose
    @SerializedName("flavour")
    public Config.Flavour flavour = Config.Flavour.VANILLA;

    private Config() {
    }

    public static Config getInstance() {
        if (INSTANCE == null) INSTANCE = new Config();
        return INSTANCE;
    }

    public static void update(Config config) {
        INSTANCE = config;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    public enum Flavour {
        @Expose @SerializedName("vanilla")
        VANILLA("vanilla"),
        @Expose @SerializedName("fabric")
        FABRIC("fabric"),
        @Expose @SerializedName("forge")
        FORGE("forge"),
        @Expose @SerializedName("lunar")
        LUNAR("lunarclient:1.19.3"),
        @Expose @SerializedName("none")
        NONE(null);

        private final String brand;

        Flavour(String brand) {
            this.brand = brand;
        }

        public String brand() {
            return brand;
        }

        public Flavour next() {
            Flavour[] flavours = Flavour.values();
            return flavours[(this.ordinal() + 1) % flavours.length];
        }
    }
}
