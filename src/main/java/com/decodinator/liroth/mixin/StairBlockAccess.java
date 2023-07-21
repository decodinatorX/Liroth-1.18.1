package com.decodinator.liroth.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(StairBlock.class)
public interface StairBlockAccess {

    @Invoker("<init>")
    static StairBlock create(BlockState state, BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
