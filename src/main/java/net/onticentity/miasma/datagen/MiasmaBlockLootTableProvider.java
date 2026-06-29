package net.onticentity.miasma.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.fabricmc.fabric.impl.loot.FabricLootTable;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.onticentity.miasma.blocks.ModBlocks;
import net.onticentity.miasma.items.ModItems;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class MiasmaBlockLootTableProvider extends FabricBlockLootSubProvider {
    protected MiasmaBlockLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.MOON_STONE);


        this.add(ModBlocks.MIASRITE_ORE,
                block -> createSingleItemTable(ModItems.MIASRITE_ECHO));

    }
}
