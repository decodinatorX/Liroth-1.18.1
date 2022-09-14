package com.decodinator.liroth.core.features;

import net.minecraft.util.math.random.Random;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.blocks.CustomKelpBlock;
import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.KelpBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class VileTentacleFeature 
extends Feature<DefaultFeatureConfig> {
    public VileTentacleFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        int i = 0;
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        int j = structureWorldAccess.getTopY(Heightmap.Type.OCEAN_FLOOR, blockPos.getX(), blockPos.getZ());
        BlockPos blockPos2 = new BlockPos(blockPos.getX(), j, blockPos.getZ());
        if (structureWorldAccess.getBlockState(blockPos2).isOf(Liroth.LIROTH_FLUID)) {
            BlockState blockState = LirothBlocks.VILE_TENTACLE_TIP.getDefaultState();
            BlockState blockState2 = LirothBlocks.VILE_TENTACLE.getDefaultState();
            int k = 1 + random.nextInt(10);
            for (int l = 0; l <= k; ++l) {
                if (structureWorldAccess.getBlockState(blockPos2).isOf(Liroth.LIROTH_FLUID) && structureWorldAccess.getBlockState(blockPos2.up()).isOf(Liroth.LIROTH_FLUID) && blockState2.canPlaceAt(structureWorldAccess, blockPos2)) {
                    if (l == k) {
                        structureWorldAccess.setBlockState(blockPos2, (BlockState)blockState.with(CustomKelpBlock.AGE, random.nextInt(4) + 20), Block.NOTIFY_LISTENERS);
                        ++i;
                    } else {
                        structureWorldAccess.setBlockState(blockPos2, blockState2, Block.NOTIFY_LISTENERS);
                    }
                } else if (l > 0) {
                    BlockPos blockPos3 = blockPos2.down();
                    if (!blockState.canPlaceAt(structureWorldAccess, blockPos3) || structureWorldAccess.getBlockState(blockPos3.down()).isOf(LirothBlocks.VILE_TENTACLE_TIP)) break;
                    structureWorldAccess.setBlockState(blockPos3, (BlockState)blockState.with(CustomKelpBlock.AGE, random.nextInt(4) + 20), Block.NOTIFY_LISTENERS);
                    ++i;
                    break;
                }
                blockPos2 = blockPos2.up();
            }
        }
        return i > 0;
    }
}