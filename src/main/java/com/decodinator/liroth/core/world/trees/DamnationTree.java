package com.decodinator.liroth.core.world.trees;

import java.util.Random;
import com.decodinator.liroth.core.LirothConfiguredFeatures;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class DamnationTree 
extends SaplingGenerator {
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        if (random.nextInt(10) == 0) {
            return bees ? LirothConfiguredFeatures.DAMNATION : LirothConfiguredFeatures.DAMNATION;
        }
        return bees ? LirothConfiguredFeatures.DAMNATION : LirothConfiguredFeatures.DAMNATION;
    }
}
