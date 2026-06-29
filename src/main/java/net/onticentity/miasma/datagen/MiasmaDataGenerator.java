package net.onticentity.miasma.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.onticentity.miasma.blocks.ModBlocks;
import net.onticentity.miasma.worldgen.MiasmaWorldConfigurationFeature;
import net.onticentity.miasma.worldgen.MiasmaWorldPlaceFeature;

public class MiasmaDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(MiasmaWorldgenProvider::new);
        pack.addProvider(MiasmaEnglishLangProvider::new);
        pack.addProvider(MiasmaModelProvider::new);
        pack.addProvider(MiasmaBlockLootTableProvider::new);
        pack.addProvider(MiasmaRecipeProvider::new);
        pack.addProvider(MiasmaBlockTagProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, MiasmaWorldConfigurationFeature::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, MiasmaWorldPlaceFeature::configure);
    }
}
