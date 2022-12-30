package com.decodinator.liroth.core.fluids;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothFluids;
import com.decodinator.liroth.core.LirothItems;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.World;

public abstract class LirothFluid extends WaterTypeFluid {
	@Override
	public Fluid getStill() {
		return LirothFluids.LIROTH_FLUID_STILL;
	}
 
	@Override
	public Fluid getFlowing() {
		return LirothFluids.LIROTH_FLUID_FLOWING;
	}
 
	@Override
	public Item getBucketItem() {
		return LirothItems.LIROTH_FLUID_BUCKET;
	}
 
	@Override
	protected BlockState toBlockState(FluidState fluidState) {
		return LirothBlocks.LIROTH_FLUID.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
	}
 
	public static class Flowing extends LirothFluid {
		@Override
		protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
			super.appendProperties(builder);
			builder.add(LEVEL);
		}
 
		@Override
		public int getLevel(FluidState fluidState) {
			return fluidState.get(LEVEL);
		}
 
		@Override
		public boolean isStill(FluidState fluidState) {
			return false;
		}

		@Override
		protected boolean isInfinite(World var1) {
			return true;
		}
	}
 
	public static class Still extends LirothFluid {
		@Override
		public int getLevel(FluidState fluidState) {
			return 8;
		}
 
		@Override
		public boolean isStill(FluidState fluidState) {
			return true;
		}

		@Override
		protected boolean isInfinite(World var1) {
			return false;
		}
	}
}