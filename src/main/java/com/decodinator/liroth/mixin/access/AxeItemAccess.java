package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

import java.util.Map;

@Mixin(AxeItem.class)
public interface AxeItemAccess {

    @Invoker("<init>")
    static AxeItem create(ToolMaterial tier, float f, float g, Item.Settings properties) {
        throw new Error("Mixin did not apply");
    }

    @Accessor("STRIPPED_BLOCKS")
    static Map<Block, Block> getStripables() {
        throw new Error("Mixin did not apply");
    }

    @Accessor("STRIPPED_BLOCKS")
    @Mutable
    static void setStripables(Map<Block, Block> newMap) {
        throw new Error("Mixin did not apply");
    }
}
