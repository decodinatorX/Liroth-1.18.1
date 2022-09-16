package com.decodinator.liroth.core;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.decodinator.liroth.Liroth;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PropaguleBlock;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.root.AboveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacement;
import net.minecraft.world.gen.root.MangroveRootPlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.RandomizedIntBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLeavesTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.UpwardsBranchingTrunkPlacer;

public class LirothConfiguredFeatures extends PlacedFeatures {  

	    public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);

		  static ConfiguredFeature<?, ?> OVERWORLD_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
			          OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
			          LirothBlocks.TOURMALINE_ORE.getDefaultState(),
			          3)); // vein size
		  
		  static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_LIROTH_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
				      LirothBlocks.DEEPSLATE_LIROTH_ORE.getDefaultState(),
				      2)); // vein size
		  
		  static ConfiguredFeature<?, ?> NETHER_LIROTH_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      OreConfiguredFeatures.NETHERRACK,
				      LirothBlocks.NETHER_LIROTH_GEM_ORE.getDefaultState(),
				      4)); // vein size
		  
		  static ConfiguredFeature<?, ?> END_LIROTH_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      LirothConfiguredFeatures.END_STONE,
				      LirothBlocks.END_LIROTH_GEM_ORE.getDefaultState(),
				      5)); // vein size
		  
		  static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
				      LirothBlocks.DEEPSLATE_TOURMALINE_ORE.getDefaultState(),
				      4)); // vein size
}
