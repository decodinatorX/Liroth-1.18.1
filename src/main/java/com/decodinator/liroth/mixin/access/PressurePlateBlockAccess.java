package com.decodinator.liroth.mixin.access;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PressurePlateBlock;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PressurePlateBlock.class)
public interface PressurePlateBlockAccess {

    @Invoker("<init>")
    static PressurePlateBlock create(net.minecraft.block.PressurePlateBlock.ActivationRule sensitivity, AbstractBlock.Settings properties) {
        throw new Error("Mixin did not apply!");
    }
}