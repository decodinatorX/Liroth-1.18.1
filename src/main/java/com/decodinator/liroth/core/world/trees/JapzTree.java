package com.decodinator.liroth.core.world.trees;

import com.decodinator.liroth.Liroth;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class JapzTree 
extends SaplingGenerator {
	@Override
	protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(
			Random var1, boolean var2) {
		return Liroth.JAPZ;
	}
}
