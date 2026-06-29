package net.onticentity.miasma.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.onticentity.miasma.blocks.ModBlocks;
import net.onticentity.miasma.items.ModItems;

public class MiasmaModelProvider extends FabricModelProvider {

    public MiasmaModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialBlock(
                ModBlocks.MIASMA_ENLIUM,
                TexturedModel.CUBE_TOP_BOTTOM
        );

        blockStateModelGenerator.createCrossBlock(
                ModBlocks.MIASMA_ROOTS,
                BlockModelGenerators.PlantType.NOT_TINTED
        );
        blockStateModelGenerator.createTrivialBlock(
                ModBlocks.MIASRITE_ORE,
                TexturedModel.CUBE
        );

        blockStateModelGenerator.createTrivialBlock(
                ModBlocks.MOON_STONE,
                TexturedModel.CUBE
        );

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    itemModelGenerator.generateFlatItem(ModItems.MIASRITE_ECHO, ModelTemplates.FLAT_ITEM);

    }

    @Override
    public String getName() {
        return "MiasmaModelProvider";
    }

}
