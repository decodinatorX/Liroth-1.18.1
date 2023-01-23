package com.decodinator.liroth.core.fluids;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class SchluckedFluidBlock extends LiquidBlock {

	protected SchluckedFluidBlock(FlowingFluid fluid, Properties settings) {
		super(fluid, settings);
	}
	
    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        LivingEntity livingEntity;
        if (level.isClientSide || level.getDifficulty() == Difficulty.PEACEFUL) {
            return;
        }
        if (entity instanceof LivingEntity && !(livingEntity = (LivingEntity)entity).isPassenger()) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 40));
        }
    }
}
