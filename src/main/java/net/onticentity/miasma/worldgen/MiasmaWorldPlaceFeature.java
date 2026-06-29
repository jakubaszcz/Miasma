package net.onticentity.miasma.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.onticentity.miasma.Miasma;

import java.util.List;

public class MiasmaWorldPlaceFeature {

    public static final ResourceKey<PlacedFeature> MIASMA_ROOTS_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "miasma_roots_placed")
            );

    public static final ResourceKey<PlacedFeature> MIASMA_SPIRE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "miasma_spire_placed")
            );

    public static void configure(BootstrapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> eonDebrisModifiers = List.of(
                CountPlacement.of(UniformInt.of(3, 6)),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(40),
                        VerticalAnchor.absolute(90)
                ),
                BiomeFilter.biome()
        );

        List<PlacementModifier> miasmaRootsModifiers = List.of(
                CountPlacement.of(UniformInt.of(10, 20)),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome()
        );

        context.register(
                MIASMA_ROOTS_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MiasmaWorldConfigurationFeature.MIASMA_ROOTS_CONFIGURED_FEATURE_KEY),
                        miasmaRootsModifiers
                )
        );

        List<PlacementModifier> miasmaSpireModifiers = List.of(
                CountPlacement.of(UniformInt.of(0, 1)),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome()
        );

        context.register(
                MIASMA_SPIRE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MiasmaWorldConfigurationFeature.MIASMA_SPIRE_CONFIGURED_FEATURE_KEY),
                        miasmaSpireModifiers
                )
        );

    }
}
