package com.decodinator.liroth.core.blocks;

import net.minecraft.util.math.random.Random;

import com.decodinator.liroth.core.LirothFluids;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class CustomWaterPlant extends CustomDeadWaterPlant {
    private final Block deadCoralBlock;

    public CustomWaterPlant(Block deadCoralBlock, AbstractBlock.Settings settings) {
        super(settings);
        this.deadCoralBlock = deadCoralBlock;
    }
    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        this.checkLivingConditions(state, world, pos);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!CustomWaterPlant.isInWater(state, world, pos)) {
            world.setBlockState(pos, (BlockState)this.deadCoralBlock.getDefaultState().with(WATERLOGGED, false), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN && !state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        this.checkLivingConditions(state, world, pos);
        if (state.get(WATERLOGGED).booleanValue()) {
            world.scheduleFluidTick(pos, LirothFluids.LIROTH_FLUID_STILL, LirothFluids.LIROTH_FLUID_STILL.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}