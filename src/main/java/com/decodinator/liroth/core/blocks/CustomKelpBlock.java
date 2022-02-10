package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.KelpBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

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
    
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.slowMovement(state, new Vec3d(0.8f, 0.75, 0.8f));
        if (!(world.isClient || entity.lastRenderX == entity.getX() && entity.lastRenderZ == entity.getZ())) {
            double d = Math.abs(entity.getX() - entity.lastRenderX);
            double e = Math.abs(entity.getZ() - entity.lastRenderZ);
            if (d >= (double)0.003f || e >= (double)0.003f) {
                entity.damage(DamageSource.SWEET_BERRY_BUSH, 1.0f);
            }
        }
    }
}
