package com.decodinator.liroth.core.features;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.BlockState;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class LirothBoneClawFeature
extends LirothSkeletonFeature {
    public LirothBoneClawFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    protected boolean generateCoral(WorldAccess world, Random random, BlockPos pos, BlockState state) {
        if (!this.generateCoralPiece(world, random, pos, state)) {
            return false;
        }
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        int i = random.nextInt(2) + 2;
        ArrayList<Direction> list = Lists.newArrayList(direction, direction.rotateYClockwise(), direction.rotateYCounterclockwise());
        Collections.shuffle(list);
        List<Direction> list2 = list.subList(0, i);
        block0: for (Direction direction2 : list2) {
            int l;
            int k;
            Direction direction3;
            BlockPos.Mutable mutable = pos.mutableCopy();
            int j = random.nextInt(2) + 1;
            mutable.move(direction2);
            if (direction2 == direction) {
                direction3 = direction;
                k = random.nextInt(3) + 2;
            } else {
                mutable.move(Direction.UP);
                Direction[] directions = new Direction[]{direction2, Direction.UP};
                direction3 = Util.getRandom(directions, random);
                k = random.nextInt(3) + 3;
            }
            for (l = 0; l < j && this.generateCoralPiece(world, random, mutable, state); ++l) {
                mutable.move(direction3);
            }
            mutable.move(direction3.getOpposite());
            mutable.move(Direction.UP);
            for (l = 0; l < k; ++l) {
                mutable.move(direction);
                if (!this.generateCoralPiece(world, random, mutable, state)) continue block0;
                if (!(random.nextFloat() < 0.25f)) continue;
                mutable.move(Direction.UP);
            }
        }
        return true;
    }
}
