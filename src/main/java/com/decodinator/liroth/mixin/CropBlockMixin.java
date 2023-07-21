package com.decodinator.liroth.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.decodinator.liroth.core.LirothTags;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(CropBlock.class)
public class CropBlockMixin {
    @Inject(at = @At("RETURN"), method = "mayPlaceOn", cancellable = true)
    private void isItTheFuckingFarmlandFromThisMod(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if (blockState.is(LirothTags.LIROTH_FARMLANDS)) {
            cir.setReturnValue(true);
        }
    }
}