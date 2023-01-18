package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;

@Mixin(ButtonBlock.class)
public interface WoodButtonBlockAccess {

    @Invoker("<init>")
    static ButtonBlock create(Block.Properties settings, int pressTicks, boolean wooden, SoundEvent clickOffSound, SoundEvent clickOnSound) {
        throw new Error("Mixin did not apply!");
    }
}
