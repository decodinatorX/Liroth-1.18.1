package com.decodinator.liroth.core.blocks;

import net.minecraft.util.math.random.Random;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.world.trees.JapzTree;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class CustomAzaleaBlock
extends PlantBlock
implements Fertilizable {
    private static final JapzTree GENERATOR = new JapzTree();
    private static final VoxelShape SHAPE = VoxelShapes.union(Block.createCuboidShape(0.0, 8.0, 0.0, 16.0, 16.0, 16.0), Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 8.0, 10.0));

    public CustomAzaleaBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(LirothBlocks.SPINERIOS_DIRT) || super.canPlantOnTop(floor, world, pos);
    }

	@Override
	public boolean canGrow(World var1, Random var2, BlockPos var3, BlockState var4) {
		return (double)var1.random.nextFloat() < 0.45;
	}

	@Override
	public void grow(ServerWorld var1, Random var2, BlockPos var3, BlockState var4) {
        GENERATOR.generate(var1, var1.getChunkManager().getChunkGenerator(), var3, var4, var2);
	}

	@Override
	public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean bool) {
        return world.getFluidState(pos.up()).isEmpty();
	}
}