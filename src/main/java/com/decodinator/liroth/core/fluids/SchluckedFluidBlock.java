package com.decodinator.liroth.core.fluids;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class SchluckedFluidBlock extends FluidBlock {

	protected SchluckedFluidBlock(FlowableFluid fluid, Settings settings) {
		super(fluid, settings);
	}
	
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        LivingEntity livingEntity;
        if (world.isClient || world.getDifficulty() == Difficulty.PEACEFUL) {
            return;
        }
        if (entity instanceof LivingEntity && !(livingEntity = (LivingEntity)entity).hasVehicle()) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40));
        }
    }
}
