package com.decodinator.liroth.core.features;

import com.decodinator.liroth.core.LirothBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class LirothSkeletonFeature
extends Feature<DefaultFeatureConfig> {
    public LirothSkeletonFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockState blockState = (BlockState)LirothBlocks.LIROTH_BONE_BLOCK.getDefaultState();
        return this.generateCoral(structureWorldAccess, random, blockPos, blockState);
    }

    protected abstract boolean generateCoral(WorldAccess var1, Random var2, BlockPos var3, BlockState var4);

    protected boolean generateCoralPiece(WorldAccess world, Random random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(pos);
        if (!blockState.isOf(LirothBlocks.LIROTH_FLUID) && !blockState.isOf(LirothBlocks.LIROTH_BONE_BLOCK) || !world.getBlockState(blockPos).isOf(LirothBlocks.LIROTH_FLUID)) {
            return false;
        }
        world.setBlockState(pos, state, Block.NOTIFY_ALL);
        if (random.nextFloat() < 0.25f) {
            world.setBlockState(blockPos, (BlockState)LirothBlocks.LIROTH_BONE_BLOCK.getDefaultState(), Block.NOTIFY_LISTENERS);
        } else if (random.nextFloat() < 0.05f) {
            world.setBlockState(blockPos, (BlockState)LirothBlocks.SEA_EYE.getDefaultState(), Block.NOTIFY_LISTENERS);
        }
        return true;
    }
}