package net.onticentity.miasma.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class MiasmaEnglishLangProvider extends FabricLanguageProvider {

    protected MiasmaEnglishLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("block.miasma.miasma_enlium", "Miasma Enlium");
        translationBuilder.add("block.miasma.eon_debris", "Eon Debris");
        translationBuilder.add("effect.miasma.miasma_effect", "Miasma");
    }
}
