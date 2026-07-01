package net.onticentity.miasma.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.onticentity.miasma.blocks.ModBlocks;
import net.onticentity.miasma.items.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MiasmaRecipeProvider extends FabricRecipeProvider {

    public MiasmaRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                shaped(RecipeCategory.MISC, ModItems.MIASRITE_CORE)
                        .pattern("EEE")
                        .pattern("EPD")
                        .pattern("DDD")
                        .define('E', ModItems.MIASRITE_ECHO)
                        .define('P', Items.ENDER_PEARL)
                        .define('D', Items.DIAMOND)
                        .unlockedBy(getHasName(ModItems.MIASRITE_ECHO), has(ModItems.MIASRITE_ECHO))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "MiasmaRecipeProvider";
    }

}
