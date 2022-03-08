/*package com.decodinator.liroth.core.features;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.blocks.PetrifiedFlowerBlock;
import com.mojang.serialization.Codec;
import java.util.Random;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChorusFlowerBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class PetrifiedPlantFeature
extends Feature<DefaultFeatureConfig> {
    public PetrifiedPlantFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        if (structureWorldAccess.isAir(blockPos) && structureWorldAccess.getBlockState(blockPos.down()).isOf(LirothBlocks.SOULLESS_SOIL)) {
            PetrifiedFlowerBlock.generate(structureWorldAccess, blockPos, random, 8);
            return true;
        }
        return false;
    }
}*/