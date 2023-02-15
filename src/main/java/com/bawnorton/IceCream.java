package com.bawnorton;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IceCream implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("icecream");

	@Override
	public void onInitialize() {
		LOGGER.error("This is a client-side mod and has no server-side functionality.");
	}
}