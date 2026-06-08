package net.onticentity.miasma;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.onticentity.miasma.world.level.biome.ModBiomes;
import net.onticentity.miasma.world.level.biome.ModSurfaceRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Miasma implements ModInitializer {
	public static final String MOD_ID = "miasma";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		TheEndBiomes.addHighlandsBiome(ModBiomes.MIASMA_WASTES, 10);

		LOGGER.info("Hello Fabric world!");
	}
}