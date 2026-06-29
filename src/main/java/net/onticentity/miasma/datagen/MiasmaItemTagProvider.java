package net.onticentity.miasma.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.onticentity.miasma.items.ModItems;
import net.onticentity.miasma.tags.ModTags;

import java.util.concurrent.CompletableFuture;

public class MiasmaItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

    protected MiasmaItemTagProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        valueLookupBuilder(ModTags.Items.REPAIRS_MIASRITE_TOOL)
                .add(ModItems.MIASRITE_ECHO);
    }

}