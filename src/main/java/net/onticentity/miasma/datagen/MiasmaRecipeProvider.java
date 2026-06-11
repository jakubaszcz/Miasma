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

                shapeless(RecipeCategory.MISC, ModItems.MIASRITE_INGOT)
                        .requires(ModItems.MIASRITE_SCRAP, 4)
                        .requires(Items.DIAMOND, 4)
                        .unlockedBy(getHasName(ModItems.MIASRITE_SCRAP), has(Items.DIAMOND)).save(output);

                oreSmelting(
                        List.of(ModBlocks.EON_DEBRIS),
                        RecipeCategory.MISC,
                        CookingBookCategory.MISC,
                        ModItems.MIASRITE_SCRAP,
                        1f,
                        500,
                        "eon_miasma_smelting"
                );
            }
        };
    }

    @Override
    public String getName() {
        return "MiasmaRecipeProvider";
    }

}
