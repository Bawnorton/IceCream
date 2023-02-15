package com.bawnorton.config;

import com.bawnorton.flavour.Flavour;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import net.minecraft.util.Identifier;

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

    public enum Flavour {
        @Expose @SerializedName("vanilla")
        VANILLA(CustomPayloadC2SPacket.BRAND, "vanilla"),
        @Expose @SerializedName("fabric")
        FABRIC(CustomPayloadC2SPacket.BRAND, "fabric"),
        @Expose @SerializedName("forge")
        FORGE(CustomPayloadC2SPacket.BRAND, "forge"),
        @Expose @SerializedName("lunar")
        LUNAR(CustomPayloadC2SPacket.BRAND, "lunarclient:1.19.3");

        private final PacketByteBuf data;
        private final Identifier brand;

        Flavour(Identifier brand, String data) {
            this.brand = brand;
            this.data = new PacketByteBuf(Unpooled.buffer()).writeString(data);
        }

        public static Flavour of(com.bawnorton.flavour.Flavour flavour) {
            for (Flavour value : Flavour.values()) {
                if (value.name().equalsIgnoreCase(flavour.getName())) return value;
            }
            return VANILLA;
        }

        public PacketByteBuf data() {
            return data;
        }

        public Identifier brand() {
            return brand;
        }

        public Flavour next() {
            Flavour[] flavours = Flavour.values();
            return flavours[(this.ordinal() + 1) % flavours.length];
        }
    }
}
