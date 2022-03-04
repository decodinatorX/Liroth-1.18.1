package com.decodinator.liroth.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.decodinator.liroth.Liroth;

import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class LirothRenders {
    public static void renderCutOuts(Consumer<Map<Block, RenderLayer>> mapConsumer) {
        Liroth.LOGGER.debug("Liroth: Rendering Texture Shits...");
        Map<Block, RenderLayer> map = new HashMap<>();
        
        map.put(LirothBlocks.DAMNATION_SAPLING, RenderLayer.getCutout());
        map.put(LirothBlocks.JAPZ_SAPLING, RenderLayer.getCutout());
        map.put(LirothBlocks.KOOLAW_SAPLING, RenderLayer.getCutout());
        map.put(LirothBlocks.LIROTH_SAPLING, RenderLayer.getCutout());
        map.put(LirothBlocks.PETRIFIED_DAMNATION_SAPLING, RenderLayer.getCutout());
        map.put(LirothBlocks.SPICED_SAPLING, RenderLayer.getCutout());
        map.put(LirothBlocks.TALLPIER_SAPLING, RenderLayer.getCutout());
        map.put(LirothBlocks.LIROTH_GRASS, RenderLayer.getCutout());

        map.put(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL, RenderLayer.getCutout());
        
        map.put(LirothBlocks.DAMNATION_VINES_PLANT, RenderLayer.getCutout());
        map.put(LirothBlocks.DAMNATION_VINES, RenderLayer.getCutout());
        map.put(LirothBlocks.DAMNATION_FUNGAL_FUSS, RenderLayer.getCutout());
        map.put(LirothBlocks.DAMNATION_FUNGAL_HEAP, RenderLayer.getCutout());
        map.put(LirothBlocks.DAMNATION_FUNGAL_PATCH, RenderLayer.getCutout());
        map.put(LirothBlocks.FUNGAL_LANTERN, RenderLayer.getCutout());
        
        map.put(LirothBlocks.LIROTH_ROSE, RenderLayer.getCutout());
        map.put(LirothBlocks.WILITING_LIROTH_ROSE, RenderLayer.getCutout());
        map.put(LirothBlocks.VILE_TENTACLE, RenderLayer.getCutout());
        map.put(LirothBlocks.VILE_TENTACLE_TIP, RenderLayer.getCutout());
        map.put(LirothBlocks.DAMNATION_FUNGAL_CLUSTER, RenderLayer.getCutout());
        map.put(LirothBlocks.DAMNATION_FUNGUS, RenderLayer.getCutout());
        map.put(LirothBlocks.SEA_EYE, RenderLayer.getCutout());
        
//        map.put(LirothBlocks.CORRUPTED_BREWING_STAND, RenderLayer.getCutout());
        
        map.put(LirothBlocks.FUNGAL_TORCH, RenderLayer.getCutout());
        map.put(LirothBlocks.WALL_FUNGAL_TORCH, RenderLayer.getCutout());
//        map.put(LirothBlocks.FUNGAL_CAMPFIRE, RenderLayer.getCutout());
        
        map.put(LirothBlocks.DAMNATION_TRAPDOOR, RenderLayer.getCutoutMipped());
        map.put(LirothBlocks.JAPZ_TRAPDOOR, RenderLayer.getCutoutMipped());
        map.put(LirothBlocks.KOOLAW_TRAPDOOR, RenderLayer.getCutoutMipped());
        map.put(LirothBlocks.LIROTH_TRAPDOOR, RenderLayer.getCutoutMipped());
        map.put(LirothBlocks.PETRIFIED_DAMNATION_TRAPDOOR, RenderLayer.getCutoutMipped());
        map.put(LirothBlocks.SPICED_TRAPDOOR, RenderLayer.getCutoutMipped());
        map.put(LirothBlocks.TALLPIER_TRAPDOOR, RenderLayer.getCutoutMipped());
        
        map.put(LirothBlocks.DAMNATION_DOOR, RenderLayer.getCutout());
        map.put(LirothBlocks.JAPZ_DOOR, RenderLayer.getCutout());
        map.put(LirothBlocks.KOOLAW_DOOR, RenderLayer.getCutout());
        map.put(LirothBlocks.LIROTH_DOOR, RenderLayer.getCutout());
        map.put(LirothBlocks.PETRIFIED_DAMNATION_DOOR, RenderLayer.getCutout());
        map.put(LirothBlocks.SPICED_DOOR, RenderLayer.getCutout());
        map.put(LirothBlocks.TALLPIER_DOOR, RenderLayer.getCutout());
        
        map.put(LirothBlocks.LIROTH_DIMENSION_PORTAL, RenderLayer.getTranslucent());
        map.put(LirothBlocks.DAMNATION_DIMENSION_PORTAL, RenderLayer.getTranslucent());
        map.put(LirothBlocks.JANTIRO_DIMENSION_PORTAL, RenderLayer.getTranslucent());
        map.put(LirothBlocks.JALSPHIRE_DIMENSION_PORTAL, RenderLayer.getTranslucent());
        map.put(LirothBlocks.DEVASTATED_DIMENSION_PORTAL, RenderLayer.getTranslucent());

        map.put(Liroth.LIROTH_FLUID, RenderLayer.getTranslucent());
        
        map.put(LirothBlocks.LIROTH_GLASS_BLOCK, RenderLayer.getTranslucent());
        map.put(LirothBlocks.FORCEFIELD, RenderLayer.getTranslucent());
        
        for (Block potBlock : LirothBlocks.flowerPotBlocks)
            map.put(potBlock, RenderLayer.getCutout());
        
        Liroth.LOGGER.debug("Liroth: Texture Shits Rendered!");

        mapConsumer.accept(map);
    }
}