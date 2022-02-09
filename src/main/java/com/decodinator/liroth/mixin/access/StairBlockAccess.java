package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;

@Mixin(StairsBlock.class)
public interface StairBlockAccess {

    @Invoker("<init>")
    static StairsBlock create(BlockState state, AbstractBlock.Settings properties) {
        throw new Error("Mixin did not apply!");
    }
}
