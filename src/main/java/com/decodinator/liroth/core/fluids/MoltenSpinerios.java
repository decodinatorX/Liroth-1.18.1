package com.decodinator.liroth.core.fluids;

import com.decodinator.liroth.Liroth;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class MoltenSpinerios extends LavaTypeFluid {
	@Override
	public Fluid getStill() {
		return Liroth.MOLTEN_SPINERIOS_STILL;
	}
 
	@Override
	public Fluid getFlowing() {
		return Liroth.MOLTEN_SPINERIOS_FLOWING;
	}
 
	@Override
	public Item getBucketItem() {
		return Liroth.MOLTEN_SPINERIOS_BUCKET;
	}
 
	@Override
	protected BlockState toBlockState(FluidState fluidState) {
		return Liroth.MOLTEN_SPINERIOS.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
	}
 
	public static class Flowing extends MoltenSpinerios {
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
	}
 
	public static class Still extends MoltenSpinerios {
		@Override
		public int getLevel(FluidState fluidState) {
			return 8;
		}
 
		@Override
		public boolean isStill(FluidState fluidState) {
			return true;
		}
	}
}