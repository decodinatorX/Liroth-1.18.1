package com.decodinator.liroth.core.blocks;

import net.minecraft.util.math.random.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class LirothFarmlandBlock extends FarmlandBlock {
	
    public LirothFarmlandBlock(Settings properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState blockState, ServerWorld serverLevel, BlockPos blockPos, Random random) {
    	serverLevel.setBlockState(blockPos, blockState.with(MOISTURE, 7), 2);
    }

}
