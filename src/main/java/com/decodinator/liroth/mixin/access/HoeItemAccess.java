package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

import java.util.Map;

@Mixin(HoeItem.class)
public interface HoeItemAccess {

    @Invoker("<init>")
    static HoeItem create(ToolMaterial tier, int i, float f, Item.Settings properties) {
        throw new Error("Mixin did not apply");
    }

    @Accessor("TILLING_ACTIONS")
    static Map<Block, BlockState> getTillables() {
        throw new Error("Mixin did not apply");
    }

    @Accessor("TILLING_ACTIONS")
    @Mutable
    static void setTillables(Map<Block, BlockState> newMap) {
        throw new Error("Mixin did not apply");
    }
}
