package com.decodinator.liroth.mixin;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

@Mixin(TrapDoorBlock.class)
public interface TrapDoorBlockAccess {

    @Invoker("<init>")
    static TrapDoorBlock create(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
        throw new Error("Mixin did not apply!");
    }
}
