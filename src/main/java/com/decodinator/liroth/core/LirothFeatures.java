package com.decodinator.liroth.core;

import com.decodinator.liroth.core.features.DamnationVinesFeature;
import com.decodinator.liroth.core.features.JalsphireCrystalClusterFeature;
import com.decodinator.liroth.core.features.LirothBoneClawFeature;
import com.decodinator.liroth.core.features.LirothBoneMushroomFeature;
import com.decodinator.liroth.core.features.LirothBoneTreeFeature;
import com.decodinator.liroth.core.features.ObsidianSpikeFeature;
import com.decodinator.liroth.core.features.PetrifiedCrystalClusterFeature;
import com.decodinator.liroth.core.features.VileTentacleFeature;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.PointedDripstoneConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

public class LirothFeatures {
	
	  private static final Feature<NoneFeatureConfiguration> OBSIDIAN_SPIKE = new ObsidianSpikeFeature(NoneFeatureConfiguration.CODEC);
	  private static final Feature<NoneFeatureConfiguration> VILE_TENTALCE = new VileTentacleFeature(NoneFeatureConfiguration.CODEC);
	  private static final Feature<NoneFeatureConfiguration> LIROTH_BONE_CLAW = new LirothBoneClawFeature(NoneFeatureConfiguration.CODEC);
	  private static final Feature<NoneFeatureConfiguration> LIROTH_BONE_MUSHROOM = new LirothBoneMushroomFeature(NoneFeatureConfiguration.CODEC);
	  private static final Feature<NoneFeatureConfiguration> LIROTH_BONE_TREE = new LirothBoneTreeFeature(NoneFeatureConfiguration.CODEC);
	  private static final Feature<PointedDripstoneConfiguration> JALSPHIRE_CRYSTAL_CLUSTER = new JalsphireCrystalClusterFeature(PointedDripstoneConfiguration.CODEC);
	  private static final Feature<PointedDripstoneConfiguration> PETRIFIED_CRYSTAL_CLUSTER = new PetrifiedCrystalClusterFeature(PointedDripstoneConfiguration.CODEC);
	  private static final Feature<NoneFeatureConfiguration> DAMNATION_VINES = new DamnationVinesFeature(NoneFeatureConfiguration.CODEC);
	  private static final Feature<RandomPatchConfiguration> WILTING_LIROTH_ROSES = new RandomPatchFeature(RandomPatchConfiguration.CODEC);
	
	public static void init() {
	    Registry.register(Registry.FEATURE, new ResourceLocation("liroth", "obsidian_spike"), OBSIDIAN_SPIKE);
	    Registry.register(Registry.FEATURE, new ResourceLocation("liroth", "vile_tentacle"), VILE_TENTALCE);
	    Registry.register(Registry.FEATURE, new ResourceLocation("liroth", "liroth_bone_claw"), LIROTH_BONE_CLAW);
	    Registry.register(Registry.FEATURE, new ResourceLocation("liroth", "liroth_bone_mushroom"), LIROTH_BONE_MUSHROOM);
	    Registry.register(Registry.FEATURE, new ResourceLocation("liroth", "liroth_bone_tree"), LIROTH_BONE_TREE);
	    Registry.register(Registry.FEATURE, new ResourceLocation("liroth", "jalsphire_crystal_cluster"), JALSPHIRE_CRYSTAL_CLUSTER);
	    Registry.register(Registry.FEATURE, new ResourceLocation("liroth", "petrified_crystal_cluster"), PETRIFIED_CRYSTAL_CLUSTER);
	    Registry.register(Registry.FEATURE, new ResourceLocation("liroth", "damnation_vines"), DAMNATION_VINES);
	    Registry.register(Registry.FEATURE, new ResourceLocation("liroth", "wilting_liroth_roses"), WILTING_LIROTH_ROSES);
	}

}
