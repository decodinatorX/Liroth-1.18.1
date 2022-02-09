package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;

@Mixin(SaplingBlock.class)
public interface SaplingBlockAccess {

    @Invoker("<init>")
    static SaplingBlock create(SaplingGenerator generator, AbstractBlock.Settings settings) {
        throw new Error("Mixin did not apply!");
    }
}