package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.sound.SoundEvent;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PressurePlateBlock;

@Mixin(PressurePlateBlock.class)
public interface PressurePlateBlockAccess {

    @Invoker("<init>")
    static PressurePlateBlock create(PressurePlateBlock.ActivationRule type, AbstractBlock.Settings settings, SoundEvent depressSound, SoundEvent pressSound) {
        throw new Error("Mixin did not apply!");
    }
}