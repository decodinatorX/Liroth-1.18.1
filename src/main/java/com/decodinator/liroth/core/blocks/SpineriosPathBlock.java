package com.decodinator.liroth.core.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.DirtPathBlock;
import net.minecraft.util.shape.VoxelShape;

public class SpineriosPathBlock
extends DirtPathBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);

    public SpineriosPathBlock(AbstractBlock.Settings settings) {
        super(settings);
    }
}

