package com.decodinator.liroth.mixin.access;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

@Mixin(PressurePlateBlock.class)
public interface PressurePlateBlockAccess {

    @Invoker("<init>")
    static PressurePlateBlock create(PressurePlateBlock.Sensitivity sensitivity, BlockBehaviour.Properties properties, BlockSetType blockSetType) {
        throw new Error("Mixin did not apply!");
    }
}