package com.decodinator.liroth.core.features;

import java.util.function.Consumer;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.blocks.PointedPetrifiedCrystal;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Thickness;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;

public class PetrifiedCrystalHelper {
    protected static double scaleHeightFromRadius(double radius, double scale, double heightScale, double bluntness) {
        if (radius < bluntness) {
            radius = bluntness;
        }
        double e = radius / scale * 0.384;
        double f = 0.75 * Math.pow(e, 1.3333333333333333);
        double g = Math.pow(e, 0.6666666666666666);
        double h = 0.3333333333333333 * Math.log(e);
        double i = heightScale * (f - g - h);
        i = Math.max(i, 0.0);
        return i / 0.384 * scale;
    }

    protected static boolean canGenerateBase(StructureWorldAccess world, BlockPos pos, int height) {
        if (PetrifiedCrystalHelper.canGenerateOrLava(world, pos)) {
            return false;
        }
        float g = 6.0f / (float)height;
        for (float h = 0.0f; h < (float)Math.PI * 2; h += g) {
            int i = (int)(MathHelper.cos(h) * (float)height);
            if (!PetrifiedCrystalHelper.canGenerateOrLava(world, pos.add(i, 0, (int)(MathHelper.sin(h) * (float)height)))) continue;
            return false;
        }
        return true;
    }

    protected static boolean canGenerate(WorldAccess world, BlockPos pos) {
        return world.testBlockState(pos, PetrifiedCrystalHelper::canGenerate);
    }

    protected static boolean canGenerateOrLava(WorldAccess world, BlockPos pos) {
        return world.testBlockState(pos, PetrifiedCrystalHelper::canGenerateOrLava);
    }

    protected static void getDripstoneThickness(Direction direction, int height, boolean merge, Consumer<BlockState> callback) {
        if (height >= 3) {
            callback.accept(PetrifiedCrystalHelper.getState(direction, Thickness.BASE));
            for (int i = 0; i < height - 3; ++i) {
                callback.accept(PetrifiedCrystalHelper.getState(direction, Thickness.MIDDLE));
            }
        }
        if (height >= 2) {
            callback.accept(PetrifiedCrystalHelper.getState(direction, Thickness.FRUSTUM));
        }
        if (height >= 1) {
            callback.accept(PetrifiedCrystalHelper.getState(direction, merge ? Thickness.TIP_MERGE : Thickness.TIP));
        }
    }

    protected static void generatePointedDripstone(WorldAccess world, BlockPos pos, Direction direction, int height, boolean merge) {
        if (!PetrifiedCrystalHelper.canReplace(world.getBlockState(pos.offset(direction.getOpposite())))) {
            return;
        }
        BlockPos.Mutable mutable = pos.mutableCopy();
        PetrifiedCrystalHelper.getDripstoneThickness(direction, height, merge, state -> {
            if (state.isOf(LirothBlocks.POINTED_PETRIFIED_CRYSTAL)) {
                state = (BlockState)state.with(PointedPetrifiedCrystal.WATERLOGGED, world.isWater(mutable));
            }
            world.setBlockState(mutable, (BlockState)state, Block.NOTIFY_LISTENERS);
            mutable.move(direction);
        });
    }

    protected static boolean generateDripstoneBlock(WorldAccess world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.isIn(BlockTags.DRIPSTONE_REPLACEABLE_BLOCKS)) {
            world.setBlockState(pos, LirothBlocks.PETRIFIED_CRYSTAL_BLOCK.getDefaultState(), Block.NOTIFY_LISTENERS);
            return true;
        }
        return false;
    }

    private static BlockState getState(Direction direction, Thickness thickness) {
        return (BlockState)((BlockState)LirothBlocks.POINTED_PETRIFIED_CRYSTAL.getDefaultState().with(PointedPetrifiedCrystal.VERTICAL_DIRECTION, direction)).with(PointedPetrifiedCrystal.THICKNESS, thickness);
    }

    public static boolean canReplaceOrLava(BlockState state) {
        return PetrifiedCrystalHelper.canReplace(state) || state.isOf(Blocks.LAVA);
    }

    public static boolean canReplace(BlockState state) {
        return state.isOf(LirothBlocks.PETRIFIED_CRYSTAL_BLOCK) || state.isIn(BlockTags.DRIPSTONE_REPLACEABLE_BLOCKS);
    }

    public static boolean canGenerate(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER);
    }

    public static boolean canGenerateOrLava(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) || state.isOf(Blocks.LAVA);
    }
}