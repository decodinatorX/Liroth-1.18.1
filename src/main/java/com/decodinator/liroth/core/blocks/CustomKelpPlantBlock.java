package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.KelpBlock;
import net.minecraft.block.KelpPlantBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;

public class CustomKelpPlantBlock extends KelpPlantBlock {

	public CustomKelpPlantBlock(Settings settings) {
		super(settings);
	}

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock)LirothBlocks.VILE_TENTACLE_TIP;
    }
    
    @Override
    public FluidState getFluidState(BlockState state) {
        return Liroth.LIROTH_FLUID_STILL.getStill(false);
    }
}
