package net.onticentity.miasma.world.level.biome;

import net.minecraft.resources.ResourceKey;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;


public class ModBiomes {
    public static final ResourceKey<Biome> MIASMA_WASTES = ResourceKey.create(
            Registries.BIOME,
            Identifier.fromNamespaceAndPath("miasma", "miasma_wastes")
    );
}
