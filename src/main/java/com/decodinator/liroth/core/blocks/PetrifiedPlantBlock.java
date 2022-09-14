package com.decodinator.liroth.core.blocks;
/*package com.decodinator.liroth.core.blocks;

import java.util.Random;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ConnectingBlock;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class PetrifiedPlantBlock
extends ConnectingBlock {
    protected PetrifiedPlantBlock(AbstractBlock.Settings settings) {
        super(0.3125f, settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(NORTH, false)).with(EAST, false)).with(SOUTH, false)).with(WEST, false)).with(UP, false)).with(DOWN, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.withConnectionProperties(ctx.getWorld(), ctx.getBlockPos());
    }

    public BlockState withConnectionProperties(BlockView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        BlockState blockState2 = world.getBlockState(pos.up());
        BlockState blockState3 = world.getBlockState(pos.north());
        BlockState blockState4 = world.getBlockState(pos.east());
        BlockState blockState5 = world.getBlockState(pos.south());
        BlockState blockState6 = world.getBlockState(pos.west());
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.getDefaultState().with(DOWN, blockState.isOf(this) || blockState.isOf(LirothBlocks.PETRIFIED_FLOWER) || blockState.isOf(LirothBlocks.SOULLESS_SOIL))).with(UP, blockState2.isOf(this) || blockState2.isOf(LirothBlocks.PETRIFIED_FLOWER))).with(NORTH, blockState3.isOf(this) || blockState3.isOf(LirothBlocks.PETRIFIED_FLOWER))).with(EAST, blockState4.isOf(this) || blockState4.isOf(LirothBlocks.PETRIFIED_FLOWER))).with(SOUTH, blockState5.isOf(this) || blockState5.isOf(LirothBlocks.PETRIFIED_FLOWER))).with(WEST, blockState6.isOf(this) || blockState6.isOf(LirothBlocks.PETRIFIED_FLOWER));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            world.createAndScheduleBlockTick(pos, this, 1);
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
        boolean bl = neighborState.isOf(this) || neighborState.isOf(LirothBlocks.PETRIFIED_FLOWER) || direction == Direction.DOWN && neighborState.isOf(LirothBlocks.SOULLESS_SOIL);
        return (BlockState)state.with((Property)FACING_PROPERTIES.get(direction), bl);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        boolean bl = !world.getBlockState(pos.up()).isAir() && !blockState.isAir();
        for (Direction direction : Direction.Type.HORIZONTAL) {
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState2 = world.getBlockState(blockPos);
            if (!blockState2.isOf(this)) continue;
            if (bl) {
                return false;
            }
            BlockState blockState3 = world.getBlockState(blockPos.down());
            if (!blockState3.isOf(this) && !blockState3.isOf(LirothBlocks.SOULLESS_SOIL)) continue;
            return true;
        }
        return blockState.isOf(this) || blockState.isOf(LirothBlocks.SOULLESS_SOIL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}*/