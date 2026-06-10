package net.onticentity.miasma.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TexturedModel;
import net.onticentity.miasma.blocks.ModBlocks;

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

        blockStateModelGenerator.createTrivialBlock(
                ModBlocks.EON_DEBRIS,
                TexturedModel.COLUMN
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }

    @Override
    public String getName() {
        return "MiasmaModelProvider";
    }

}
