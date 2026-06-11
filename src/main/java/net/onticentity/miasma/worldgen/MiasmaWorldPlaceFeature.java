package net.onticentity.miasma.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraft.world.level.levelgen.placement.*;
import net.onticentity.miasma.Miasma;

import java.util.List;

public class MiasmaWorldPlaceFeature {
    public static final ResourceKey<PlacedFeature> MIASMA_SPIRE_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "miasma_spire_placed")
            );

    public static void configure(BootstrapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        List<PlacementModifier> miasmaSpireModifiers = List.of(
                CountPlacement.of(6),
                BiomeFilter.biome(),
                InSquarePlacement.spread(),
                HeightRangePlacement.of(BiasedToBottomHeight.of(VerticalAnchor.BOTTOM, VerticalAnchor.absolute(0), 3))

        );

        context.register(
                MIASMA_SPIRE_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MiasmaWorldConfigurationFeature.MIASMA_SPIRE_CONFIGURED_KEY),
                        miasmaSpireModifiers
                )
        );
    }
}
