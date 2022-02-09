package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;

import java.util.Map;

@Mixin(RenderLayers.class)
public interface ItemBlockRenderTypeAccess {


    @Accessor("BLOCKS")
    static Map<Block, RenderLayer> getTypeByBlock() {
        throw new Error("Mixin did not apply");
    }
}