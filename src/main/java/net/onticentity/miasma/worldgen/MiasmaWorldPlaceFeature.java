package net.onticentity.miasma.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.onticentity.miasma.Miasma;

import java.util.List;

public class MiasmaWorldPlaceFeature {
    public static final ResourceKey<PlacedFeature> EON_DEBRIS_PLACED_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "eon_debris_placed")
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

        context.register(
                EON_DEBRIS_PLACED_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(MiasmaWorldConfigurationFeature.EON_DEBRIS_CONFIGURED_FEATURE_KEY),
                        eonDebrisModifiers
                )
        );
    }
}
