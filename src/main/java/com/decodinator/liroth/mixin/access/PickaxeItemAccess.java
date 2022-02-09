package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

@Mixin(PickaxeItem.class)
public interface PickaxeItemAccess {

    @Invoker("<init>")
    static PickaxeItem create(ToolMaterial tier, int i, float f, Item.Settings properties) {
        throw new Error("Mixin did not apply");
    }
}
