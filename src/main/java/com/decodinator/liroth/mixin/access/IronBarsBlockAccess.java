package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PaneBlock;

@Mixin(PaneBlock.class)
public interface IronBarsBlockAccess {

    @Invoker("<init>")
    static PaneBlock create(AbstractBlock.Settings properties) {
        throw new Error("Mixin did not apply!");
    }
}
