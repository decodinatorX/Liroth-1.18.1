package com.decodinator.liroth.core.world.trees;

import java.util.Random;
import com.decodinator.liroth.core.LirothConfiguredFeatures;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class SpicedTree 
extends SaplingGenerator {
    @Override
    protected ConfiguredFeature<?, ?> getTreeFeature(Random random, boolean bees) {
        if (random.nextInt(10) == 0) {
            return bees ? LirothConfiguredFeatures.SPICED : LirothConfiguredFeatures.SPICED;
        }
        return bees ? LirothConfiguredFeatures.SPICED : LirothConfiguredFeatures.SPICED;
    }
}
