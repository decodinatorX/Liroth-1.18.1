package com.decodinator.liroth.core;

import com.decodinator.liroth.core.features.DamnationVinesFeature;
import com.decodinator.liroth.core.features.JalsphireCrystalClusterFeature;
import com.decodinator.liroth.core.features.LirothBoneClawFeature;
import com.decodinator.liroth.core.features.LirothBoneMushroomFeature;
import com.decodinator.liroth.core.features.LirothBoneTreeFeature;
import com.decodinator.liroth.core.features.ObsidianSpikeFeature;
import com.decodinator.liroth.core.features.PetrifiedCrystalClusterFeature;
import com.decodinator.liroth.core.features.VileTentacleFeature;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.DripstoneClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;

public class LirothFeatures {
	
	  private static final Feature<DefaultFeatureConfig> OBSIDIAN_SPIKE = new ObsidianSpikeFeature(DefaultFeatureConfig.CODEC);
	  private static final Feature<DefaultFeatureConfig> VILE_TENTALCE = new VileTentacleFeature(DefaultFeatureConfig.CODEC);
	  private static final Feature<DefaultFeatureConfig> LIROTH_BONE_CLAW = new LirothBoneClawFeature(DefaultFeatureConfig.CODEC);
	  private static final Feature<DefaultFeatureConfig> LIROTH_BONE_MUSHROOM = new LirothBoneMushroomFeature(DefaultFeatureConfig.CODEC);
	  private static final Feature<DefaultFeatureConfig> LIROTH_BONE_TREE = new LirothBoneTreeFeature(DefaultFeatureConfig.CODEC);
	  private static final Feature<DripstoneClusterFeatureConfig> JALSPHIRE_CRYSTAL_CLUSTER = new JalsphireCrystalClusterFeature(DripstoneClusterFeatureConfig.CODEC);
	  private static final Feature<DripstoneClusterFeatureConfig> PETRIFIED_CRYSTAL_CLUSTER = new PetrifiedCrystalClusterFeature(DripstoneClusterFeatureConfig.CODEC);
	  private static final Feature<DefaultFeatureConfig> DAMNATION_VINES = new DamnationVinesFeature(DefaultFeatureConfig.CODEC);
	  private static final Feature<RandomPatchFeatureConfig> WILTING_LIROTH_ROSES = new RandomPatchFeature(RandomPatchFeatureConfig.CODEC);
	
	public static void init() {
	    Registry.register(Registry.FEATURE, new Identifier("liroth", "obsidian_spike"), OBSIDIAN_SPIKE);
	    Registry.register(Registry.FEATURE, new Identifier("liroth", "vile_tentacle"), VILE_TENTALCE);
	    Registry.register(Registry.FEATURE, new Identifier("liroth", "liroth_bone_claw"), LIROTH_BONE_CLAW);
	    Registry.register(Registry.FEATURE, new Identifier("liroth", "liroth_bone_mushroom"), LIROTH_BONE_MUSHROOM);
	    Registry.register(Registry.FEATURE, new Identifier("liroth", "liroth_bone_tree"), LIROTH_BONE_TREE);
	    Registry.register(Registry.FEATURE, new Identifier("liroth", "jalsphire_crystal_cluster"), JALSPHIRE_CRYSTAL_CLUSTER);
	    Registry.register(Registry.FEATURE, new Identifier("liroth", "petrified_crystal_cluster"), PETRIFIED_CRYSTAL_CLUSTER);
	    Registry.register(Registry.FEATURE, new Identifier("liroth", "damnation_vines"), DAMNATION_VINES);
	    Registry.register(Registry.FEATURE, new Identifier("liroth", "wilting_liroth_roses"), WILTING_LIROTH_ROSES);
	}

}
