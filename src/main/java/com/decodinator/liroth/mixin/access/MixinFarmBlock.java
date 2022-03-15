package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(FarmlandBlock.class)
public class MixinFarmBlock {

    // Is there a better way to do this?
	// Doesn't seem like it sadly :(
    @Inject(method = "setToDirt", at = @At("RETURN"))
    private static void turnFarmyShitToDaDirt(BlockState state, World level, BlockPos pos, CallbackInfo ci) {
        if (state.isOf(LirothBlocks.LIROTH_GRASS_BLOCK) ||state.isOf(LirothBlocks.LIROTH_FARMLAND_BLOCK)) {
            level.setBlockState(pos, Block.pushEntitiesUpBeforeBlockChange(state, LirothBlocks.LIROTH_DIRT.getDefaultState(), level, pos));
        } else if (state.isOf(LirothBlocks.PIER_GRASS_BLOCK) ||state.isOf(LirothBlocks.PIER_FARMLAND_BLOCK)) {
            level.setBlockState(pos, Block.pushEntitiesUpBeforeBlockChange(state, LirothBlocks.PIER_DIRT.getDefaultState(), level, pos));
        } else if (state.isOf(LirothBlocks.SPINERIOS_GRASS_BLOCK) ||state.isOf(LirothBlocks.SPINERIOS_FARMLAND_BLOCK)) {
            level.setBlockState(pos, Block.pushEntitiesUpBeforeBlockChange(state, LirothBlocks.SPINERIOS_DIRT.getDefaultState(), level, pos));
        }
    }
}