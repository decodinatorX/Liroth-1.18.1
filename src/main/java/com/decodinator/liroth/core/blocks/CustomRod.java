package com.decodinator.liroth.core.blocks;

import net.minecraft.util.math.random.Random;

import com.decodinator.liroth.core.LirothParticles;

import net.minecraft.block.BlockState;
import net.minecraft.block.EndRodBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class CustomRod extends EndRodBlock {

	public CustomRod(Settings settings) {
		super(settings);
	}
	
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = state.get(FACING);
        double d = (double)pos.getX() + 0.55 - (double)(random.nextFloat() * 0.1f);
        double e = (double)pos.getY() + 0.55 - (double)(random.nextFloat() * 0.1f);
        double f = (double)pos.getZ() + 0.55 - (double)(random.nextFloat() * 0.1f);
        double g = 0.4f - (random.nextFloat() + random.nextFloat()) * 0.4f;
        if (random.nextInt(5) == 0) {
            world.addParticle(LirothParticles.CLOAK, d + (double)direction.getOffsetX() * g, e + (double)direction.getOffsetY() * g, f + (double)direction.getOffsetZ() * g, random.nextGaussian() * 0.005, random.nextGaussian() * 0.005, random.nextGaussian() * 0.005);
        }
    }

}
