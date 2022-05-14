package com.decodinator.liroth.core.blocks;

import java.util.Random;

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
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getFluidState(pos.up()).isEmpty();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double)world.random.nextFloat() < 0.45;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        GENERATOR.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
    }
}