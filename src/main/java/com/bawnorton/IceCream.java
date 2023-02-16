package com.bawnorton;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IceCream implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("icecream");

	@Override
	public void onInitialize() {
		if (FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER) {
			LOGGER.error("IceCream is a client-side mod and should not be installed on a server!");
		}
	}
}