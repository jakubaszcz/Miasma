package net.onticentity.miasma.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.onticentity.miasma.blocks.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class MiasmaBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    protected MiasmaBlockTagProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MIASRITE_ORE)
                .add(ModBlocks.MOON_STONE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MIASRITE_ORE)
                .add(ModBlocks.MOON_STONE);
        ;
    }

}
