package net.onticentity.miasma.world.level.biome;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.ifTrue(
                SurfaceRules.isBiome(ModBiomes.MIASMA_WASTES),
                SurfaceRules.ifTrue(
                        SurfaceRules.ON_FLOOR,
                        SurfaceRules.state(Blocks.DIRT.defaultBlockState())
                )
        );
    }
}