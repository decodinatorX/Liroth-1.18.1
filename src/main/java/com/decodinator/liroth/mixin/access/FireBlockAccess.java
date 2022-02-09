package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.Block;
import net.minecraft.block.FireBlock;

@Mixin(FireBlock.class)
public interface FireBlockAccess {
    @Invoker("registerFlammableBlock")
    void liroth_registerFlammableBlock(Block block, int flameOdds, int burnOdds);
}
