package net.onticentity.miasma.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.onticentity.miasma.Miasma;
import net.onticentity.miasma.blocks.ModBlocks;

import java.util.List;

public class MiasmaWorldConfigurationFeature {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MIASMA_SPIRE_CONFIGURED_FEATURE_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "miasma_spire_configured_feature")
            );

    public static final ResourceKey<ConfiguredFeature<?, ?>> MIASMA_ROOTS_CONFIGURED_FEATURE_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "miasma_roots_configured_feature")
            );

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        context.register(MIASMA_ROOTS_CONFIGURED_FEATURE_KEY, new ConfiguredFeature<>(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(
                        BlockStateProvider.simple(ModBlocks.MIASMA_ROOTS)
                )
        ));

        context.register(
                MIASMA_SPIRE_CONFIGURED_FEATURE_KEY,
                new ConfiguredFeature<>(
                        ModFeatures.MIASMA_SPIRE,
                        NoneFeatureConfiguration.INSTANCE
                )
        );

    }

}
