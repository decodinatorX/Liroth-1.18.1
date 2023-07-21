package com.decodinator.liroth.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

@Mixin(DirtPathBlock.class)
public interface DirtPathBlockAccess {

    @Invoker("<init>")
    static DirtPathBlock create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
