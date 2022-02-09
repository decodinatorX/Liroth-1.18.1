package com.decodinator.liroth.mixin.access;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.WoodenButtonBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodenButtonBlock.class)
public interface WoodButtonBlockAccess {

    @Invoker("<init>")
    static WoodenButtonBlock create(AbstractBlock.Settings properties) {
        throw new Error("Mixin did not apply!");
    }
}
