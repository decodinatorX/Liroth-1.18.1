package com.decodinator.liroth.core;

import java.util.IdentityHashMap;
import java.util.Map;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.mixin.access.ShovelItemAccess;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LirothFlattenables {

    public static void addFlatfuckfridayevent() {
        Liroth.LOGGER.debug("Liroth: Registering flattenables...");
        Map<Block, BlockState> flattenables = new IdentityHashMap<>(ShovelItemAccess.getFlattenables());
        flattenables.put(LirothBlocks.LIROTH_GRASS_BLOCK, LirothBlocks.LIROTH_PATH_BLOCK.getDefaultState());
        flattenables.put(LirothBlocks.LIROTH_DIRT, LirothBlocks.LIROTH_PATH_BLOCK.getDefaultState());
        flattenables.put(LirothBlocks.PIER_GRASS_BLOCK, LirothBlocks.PIER_PATH_BLOCK.getDefaultState());
        flattenables.put(LirothBlocks.PIER_DIRT, LirothBlocks.PIER_PATH_BLOCK.getDefaultState());
        flattenables.put(LirothBlocks.SPINERIOS_GRASS_BLOCK, LirothBlocks.SPINERIOS_PATH_BLOCK.getDefaultState());
        flattenables.put(LirothBlocks.SPINERIOS_DIRT, LirothBlocks.SPINERIOS_PATH_BLOCK.getDefaultState());
        ShovelItemAccess.setFlattenables(flattenables);
        Liroth.LOGGER.info("Liroth: Flattenables registered!");
    }
}