package com.decodinator.liroth.mixin.access;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;

@Mixin(DoorBlock.class)
public interface DoorBlockAccess {

    @Invoker("<init>")
    static DoorBlock create(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
        throw new Error("Mixin did not apply!");
    }
}