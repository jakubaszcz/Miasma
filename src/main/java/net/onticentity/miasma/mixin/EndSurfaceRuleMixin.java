package net.onticentity.miasma.mixin;

import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.block.Blocks;
import net.onticentity.miasma.blocks.ModBlocks;
import net.onticentity.miasma.world.level.biome.ModBiomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(NoiseBasedChunkGenerator.class)
public class EndSurfaceRuleMixin {

    @ModifyArg(
            method = "buildSurface(Lnet/minecraft/world/level/chunk/ChunkAccess;Lnet/minecraft/world/level/levelgen/WorldGenerationContext;Lnet/minecraft/world/level/levelgen/RandomState;Lnet/minecraft/world/level/StructureManager;Lnet/minecraft/world/level/biome/BiomeManager;Lnet/minecraft/core/Registry;Lnet/minecraft/world/level/levelgen/blending/Blender;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/levelgen/SurfaceSystem;buildSurface(Lnet/minecraft/world/level/levelgen/RandomState;Lnet/minecraft/world/level/biome/BiomeManager;Lnet/minecraft/core/Registry;ZLnet/minecraft/world/level/levelgen/WorldGenerationContext;Lnet/minecraft/world/level/chunk/ChunkAccess;Lnet/minecraft/world/level/levelgen/NoiseChunk;Lnet/minecraft/world/level/levelgen/SurfaceRules$RuleSource;)V"
            ),
            index = 7
    )
    private SurfaceRules.RuleSource injectMiasmaRules(SurfaceRules.RuleSource original) {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(ModBiomes.MIASMA_WASTES),
                        SurfaceRules.ifTrue(
                                SurfaceRules.ON_FLOOR,
                                SurfaceRules.state(ModBlocks.MIASMA_ENLIUM.defaultBlockState())
                        )
                ),
                original
        );
    }
}