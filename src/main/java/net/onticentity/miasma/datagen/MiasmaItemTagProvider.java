package net.onticentity.miasma.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
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
                .add(ModItems.MIASRITE_CORE);

        valueLookupBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.MIASRITE_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.MIASRITE_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.MIASRITE_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.MIASRITE_BOOTS);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MIASRITE_HELMET)
                .add(ModItems.MIASRITE_CHESTPLATE)
                .add(ModItems.MIASRITE_LEGGINGS)
                .add(ModItems.MIASRITE_BOOTS);

        valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.MIASRITE_HELMET)
                .add(ModItems.MIASRITE_CHESTPLATE)
                .add(ModItems.MIASRITE_LEGGINGS)
                .add(ModItems.MIASRITE_BOOTS);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.MIASRITE_SWORD);

        valueLookupBuilder(ItemTags.SPEARS)
            .add(ModItems.MIASRITE_SPEAR);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.MIASRITE_AXE);

        valueLookupBuilder(ItemTags.SHOVELS)
            .add(ModItems.MIASRITE_SHOVEL);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.MIASRITE_PICKAXE);

        valueLookupBuilder(ItemTags.HOES)
            .add(ModItems.MIASRITE_HOE);
    }

}