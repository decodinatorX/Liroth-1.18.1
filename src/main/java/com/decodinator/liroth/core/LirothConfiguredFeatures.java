package com.decodinator.liroth.core;

import java.util.OptionalInt;

import com.decodinator.liroth.Liroth;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.KelpFeature;
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
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.ForkingTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.minecraft.world.gen.trunk.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import ru.bclib.api.features.BCLCommonFeatures;
import ru.bclib.world.features.BCLFeature;

public class LirothConfiguredFeatures extends PlacedFeatures {
	
	   private static <FC extends DefaultFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
		      return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key, configuredFeature);
		   }
	   	
	    public static final ConfiguredFeature<TreeFeatureConfig, ?> LIROTH = ConfiguredFeatures.register("liroth", Feature.TREE.configure(lirothTree().build()));
	    
	    public static final ConfiguredFeature<TreeFeatureConfig, ?> SPICED = ConfiguredFeatures.register("spiced", Feature.TREE.configure(new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.SPICED_LOG), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.of(LirothBlocks.SPICED_LEAVES), new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
	    public static final ConfiguredFeature<TreeFeatureConfig, ?> TALLPIER = ConfiguredFeatures.register("tallpier", Feature.TREE.configure(new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.TALLPIER_LOG), new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.of(LirothBlocks.TALLPIER_LEAVES), new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, LeavesVineTreeDecorator.INSTANCE)).build()));

	    public static final ConfiguredFeature<TreeFeatureConfig, ?> DAMNATION = ConfiguredFeatures.register("damnation", Feature.TREE.configure(new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.DAMNATION_LOG), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.of(LirothBlocks.DAMNATION_LEAVES), new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build()));

	    public static final ConfiguredFeature<TreeFeatureConfig, ?> JAPZ = ConfiguredFeatures.register("japz", Feature.TREE.configure(new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.JAPZ_LOG), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.of(LirothBlocks.JAPZ_LEAVES), new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()));

	    public static final ConfiguredFeature<TreeFeatureConfig, ?> KOOLAW = ConfiguredFeatures.register("koolaw", Feature.TREE.configure(koolawTree().build()));

	    public static final ConfiguredFeature<TreeFeatureConfig, ?> PETRIFIED = ConfiguredFeatures.register("pretrified", Feature.TREE.configure(new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.PETRIFIED_DAMNATION_LOG), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.of(LirothBlocks.DAMNATION_LEAVES), new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
	   
	    private static TreeFeatureConfig.Builder lirothTree() {
	        return new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.LIROTH_LOG), new LargeOakTrunkPlacer(3, 11, 0), BlockStateProvider.of(LirothBlocks.LIROTH_LEAVES), new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines();
	    }
	    
	    private static TreeFeatureConfig.Builder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
	        return new TreeFeatureConfig.Builder(BlockStateProvider.of(log), new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight), BlockStateProvider.of(leaves), new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1));
	    }

	    private static TreeFeatureConfig.Builder koolawTree() {
	        return builder(LirothBlocks.KOOLAW_LOG, LirothBlocks.KOOLAW_LEAVES, 5, 2, 6, 2).ignoreVines();
	    }
	   
}
