package com.decodinator.liroth.core;

import java.util.IdentityHashMap;
import java.util.Map;

import com.decodinator.liroth.mixin.access.ShovelItemAccess;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

public class LirothFlattenables {

    public static void addFlatfuckfridayevent() {
        Map<Block, BlockState> flattenables = new IdentityHashMap<>(ShovelItemAccess.getFlattenables());
        flattenables.put(LirothBlocks.LIROTH_GRASS_BLOCK, LirothBlocks.LIROTH_PATH_BLOCK.getDefaultState());
        flattenables.put(LirothBlocks.LIROTH_DIRT, LirothBlocks.LIROTH_PATH_BLOCK.getDefaultState());
        ShovelItemAccess.setFlattenables(flattenables);
    }
}