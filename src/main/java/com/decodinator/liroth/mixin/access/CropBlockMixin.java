package com.decodinator.liroth.mixin.access;

import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.decodinator.liroth.core.LirothTags;

@Mixin(CropBlock.class)
public class CropBlockMixin {
    @Inject(at = @At("RETURN"), method = "canPlantOnTop", cancellable = true)
    private void isItTheFuckingFarmlandFromThisMod(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (floor.isIn(LirothTags.LIROTH_FARMLANDS)) {
            cir.setReturnValue(true);
        }
    }
}