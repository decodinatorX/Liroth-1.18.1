package com.decodinator.liroth.mixin;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;

@Mixin(ButtonBlock.class)
public interface WoodButtonBlockAccess {

    @Invoker("<init>")
    static ButtonBlock create(BlockBehaviour.Properties properties, BlockSetType blockSetType, int i, boolean bl) {
        throw new Error("Mixin did not apply!");
    }
}
