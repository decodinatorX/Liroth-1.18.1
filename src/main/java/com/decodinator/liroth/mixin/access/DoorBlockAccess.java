package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.DoorBlock;

@Mixin(DoorBlock.class)
public interface DoorBlockAccess {

    @Invoker("<init>")
    static DoorBlock create(AbstractBlock.Settings properties) {
        throw new Error("Mixin did not apply!");
    }
}
