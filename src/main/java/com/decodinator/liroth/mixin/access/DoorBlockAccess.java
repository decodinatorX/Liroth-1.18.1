package com.decodinator.liroth.mixin.access;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.sound.SoundEvent;
import net.minecraft.block.DoorBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DoorBlock.class)
public interface DoorBlockAccess {

    @Invoker("<init>")
    static DoorBlock create(Settings properties, SoundEvent closeSound, SoundEvent openSound) {
        throw new Error("Mixin did not apply!");
    }
}