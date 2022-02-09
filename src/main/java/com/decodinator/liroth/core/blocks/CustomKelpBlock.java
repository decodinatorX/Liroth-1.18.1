package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.KelpBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;

public class CustomKelpBlock extends KelpBlock {

	public CustomKelpBlock(Settings settings) {
		super(settings);
	}
	
    @Override
    protected Block getPlant() {
        return LirothBlocks.VILE_TENTACLE;
    }
    
    @Override
    public FluidState getFluidState(BlockState state) {
        return Liroth.LIROTH_FLUID_STILL.getStill(false);
    }
    
    @Override
    protected boolean chooseStemState(BlockState state) {
        return state.isOf(Liroth.LIROTH_FLUID);
    }
}
