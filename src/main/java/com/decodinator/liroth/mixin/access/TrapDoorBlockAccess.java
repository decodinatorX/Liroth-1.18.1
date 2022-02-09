package com.decodinator.liroth.mixin.access;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.TrapdoorBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(TrapdoorBlock.class)
public interface TrapDoorBlockAccess {

    @Invoker("<init>")
    static TrapdoorBlock create(AbstractBlock.Settings properties) {
        throw new Error("Mixin did not apply!");
    }
}
