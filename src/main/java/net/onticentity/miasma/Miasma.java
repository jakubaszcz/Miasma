package net.onticentity.miasma;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.onticentity.miasma.blocks.ModBlocks;
import net.onticentity.miasma.effects.ModEffects;
import net.onticentity.miasma.events.MiasmaServerTickEvents;
import net.onticentity.miasma.world.level.biome.ModBiomes;
import net.onticentity.miasma.worldgen.MiasmaWorldConfigurationFeature;
import net.onticentity.miasma.worldgen.MiasmaWorldPlaceFeature;
import net.onticentity.miasma.worldgen.ModFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Miasma implements ModInitializer {
	public static final String MOD_ID = "miasma";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModFeatures.register();
		ModEffects.register();
		TheEndBiomes.addHighlandsBiome(ModBiomes.MIASMA_WASTES, 10);

		MiasmaServerTickEvents.register();

		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(ModBiomes.MIASMA_WASTES),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				MiasmaWorldPlaceFeature.EON_DEBRIS_PLACED_KEY
		);

		BiomeModifications.addFeature(
				BiomeSelectors.includeByKey(ModBiomes.MIASMA_WASTES),
				GenerationStep.Decoration.VEGETAL_DECORATION,
				MiasmaWorldPlaceFeature.MIASMA_ROOTS_PLACED_KEY
		);

		LOGGER.info("Hello Fabric world!");
	}
}