package com.decodinator.liroth.core.fluids;

import com.decodinator.liroth.Liroth;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SchluckedFluidBlock extends FluidBlock {

	protected SchluckedFluidBlock(FlowableFluid fluid, Settings settings) {
		super(fluid, settings);
	}
	
	@Override
	public void onEntityCollision(BlockState blockstate, World world, BlockPos pos, Entity entity) {
		super.onEntityCollision(blockstate, world, pos, entity);
		if (entity instanceof LivingEntity _entity)
			_entity.addStatusEffect(new StatusEffectInstance(Liroth.SCHLUCKED, 20, 1, (false), (false)));
	}
}
