package com.decodinator.liroth.core;

import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeatures;

public class LirothConfiguredFeatures extends PlacedFeatures {  

	    public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);

		  @SuppressWarnings({ "unchecked", "rawtypes" })
		static ConfiguredFeature<?, ?> OVERWORLD_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
			          OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
			          LirothBlocks.TOURMALINE_ORE.getDefaultState(),
			          3)); // vein size
		  
		  @SuppressWarnings({ "unchecked", "rawtypes" })
		static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_LIROTH_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
				      LirothBlocks.DEEPSLATE_LIROTH_ORE.getDefaultState(),
				      2)); // vein size
		  
		  @SuppressWarnings({ "unchecked", "rawtypes" })
		static ConfiguredFeature<?, ?> NETHER_LIROTH_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      OreConfiguredFeatures.NETHERRACK,
				      LirothBlocks.NETHER_LIROTH_GEM_ORE.getDefaultState(),
				      4)); // vein size
		  
		  @SuppressWarnings({ "unchecked", "rawtypes" })
		static ConfiguredFeature<?, ?> END_LIROTH_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      LirothConfiguredFeatures.END_STONE,
				      LirothBlocks.END_LIROTH_GEM_ORE.getDefaultState(),
				      5)); // vein size
		  
		  @SuppressWarnings({ "unchecked", "rawtypes" })
		static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
				      LirothBlocks.DEEPSLATE_TOURMALINE_ORE.getDefaultState(),
				      4)); // vein size
}
