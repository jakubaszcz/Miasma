package net.onticentity.miasma.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.onticentity.miasma.blocks.ModBlocks;

public class MiasmaSpireFeatures extends Feature<NoneFeatureConfiguration> {


    public MiasmaSpireFeatures(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        Direction[] directions = {
                Direction.NORTH,
                Direction.SOUTH,
                Direction.EAST,
                Direction.WEST
        };

        int tallestIndex = random.nextInt(directions.length);
        int smallestIndex;

        do {
            smallestIndex = random.nextInt(directions.length);
        } while (smallestIndex == tallestIndex);

        boolean placedAny = false;

        for (int i = 0; i < directions.length; i++) {
            Direction direction = directions[i];

            int heightAbove;
            int heightBelow;

            if (i == tallestIndex) {
                heightAbove = 8 + random.nextInt(4);
                heightBelow = 8 + random.nextInt(4);
            } else if (i == smallestIndex) {
                heightAbove = 2  + random.nextInt(4);
                heightBelow = 2  + random.nextInt(4);
            } else {
                heightAbove = 6 + random.nextInt(4);
                heightBelow = 6 + random.nextInt(4);
            }

            int center = random.nextInt(4);

            for (int y = -heightBelow - center; y < heightAbove + center; y++) {
                BlockPos pos = origin.above(y);

                if (level.isEmptyBlock(pos) || level.getBlockState(pos).is(Blocks.END_STONE)
                        || level.getBlockState(pos).is(ModBlocks.MIASMA_ENLIUM)
                        || level.getBlockState(pos).is(ModBlocks.MIASMA_ROOTS)) {
                    level.setBlock(pos, ModBlocks.MOON_STONE.defaultBlockState(), 2);
                    placedAny = true;
                }
            }

            for (int y = -heightBelow; y < heightAbove; y++) {
                BlockPos pos = origin.relative(direction).above(y);

                if (level.isEmptyBlock(pos) || level.getBlockState(pos).is(Blocks.END_STONE)
                        || level.getBlockState(pos).is(ModBlocks.MIASMA_ENLIUM)
                        || level.getBlockState(pos).is(ModBlocks.MIASMA_ROOTS)) {

                    if (random.nextFloat() < 0.05F) {
                        level.setBlock(pos, ModBlocks.MIASRITE_ORE.defaultBlockState(), 2);
                    }
                    else {
                        level.setBlock(pos, ModBlocks.MOON_STONE.defaultBlockState(), 2);
                    }
                    placedAny = true;
                }
            }
        }

        return placedAny;
    }

}
