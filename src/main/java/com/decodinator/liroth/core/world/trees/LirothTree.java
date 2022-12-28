package com.decodinator.liroth.core.world.trees;

import net.minecraft.util.math.random.Random;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import com.decodinator.liroth.Liroth;

public class LirothTree 
extends SaplingGenerator {
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return Liroth.LIROTH;
    }
}
