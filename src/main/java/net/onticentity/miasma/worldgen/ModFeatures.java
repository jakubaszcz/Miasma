package net.onticentity.miasma.worldgen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.onticentity.miasma.Miasma;

public class ModFeatures {

    public static final Feature<NoneFeatureConfiguration> MIASMA_SPIRE =
            Registry.register(
                    BuiltInRegistries.FEATURE,
                    Identifier.fromNamespaceAndPath(Miasma.MOD_ID, "miasma_spire"),
                    new MiasmaSpireFeatures(NoneFeatureConfiguration.CODEC)
            );

    public static void register() {

    }

}
