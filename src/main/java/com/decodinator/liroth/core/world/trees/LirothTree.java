package com.decodinator.liroth.core.world.trees;

import net.minecraft.util.math.random.Random;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import com.decodinator.liroth.Liroth;

public class LirothTree 
extends SaplingGenerator {
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return Liroth.LIROTH;
    }
}
