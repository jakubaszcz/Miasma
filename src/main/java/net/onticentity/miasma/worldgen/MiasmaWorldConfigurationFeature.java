package net.onticentity.miasma.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.onticentity.miasma.Miasma;

public class MiasmaWorldConfigurationFeature {
    public static final ResourceKey<ConfiguredFeature<?, ?>> MIASMA_SPIRE_CONFIGURED_KEY =
            ResourceKey.create(
                    Registries.CONFIGURED_FEATURE,
                    Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "miasma_spire")
            );

    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        context.register(MIASMA_SPIRE_CONFIGURED_KEY, new ConfiguredFeature<>(Feature.NO_OP, NoneFeatureConfiguration.INSTANCE));
    }

}
