package net.onticentity.miasma.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.onticentity.miasma.Miasma;
import net.onticentity.miasma.blocks.ModBlocks;

import java.util.List;

public class MiasmaWorldConfigurationFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> EON_DEBRIS_CONFIGURED_FEATURE_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "eon_debris_configured_feature")
            );

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        List<OreConfiguration.TargetBlockState> targets = List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.EON_DEBRIS.defaultBlockState())
        );

        context.register(EON_DEBRIS_CONFIGURED_FEATURE_KEY, new ConfiguredFeature<>(
                Feature.ORE,
                new OreConfiguration(targets, 3)
        ));
    }

}
