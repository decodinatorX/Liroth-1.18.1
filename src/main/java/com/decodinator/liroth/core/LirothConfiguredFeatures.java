package com.decodinator.liroth.core;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PropaguleBlock;
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
	
	   	public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> LIROTH = ConfiguredFeatures.register("liroth", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.LIROTH_LOG), new LargeOakTrunkPlacer(3, 11, 0), BlockStateProvider.of(LirothBlocks.LIROTH_LEAVES), new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
	    
	    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> SPICED = ConfiguredFeatures.register("spiced", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.SPICED_LOG), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.of(LirothBlocks.SPICED_LEAVES), new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
	    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> TALLPIER = ConfiguredFeatures.register("tallpier", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.TALLPIER_LOG), new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.of(LirothBlocks.TALLPIER_LEAVES), new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25f))).build());

	    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> DAMNATION = ConfiguredFeatures.register("damnation", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.DAMNATION_LOG), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.of(LirothBlocks.DAMNATION_LEAVES), new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build());

	    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> JAPZ = ConfiguredFeatures.register("japz", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.JAPZ_LOG), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.of(LirothBlocks.JAPZ_LEAVES), new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());

	    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> KOOLAW = ConfiguredFeatures.register("koolaw", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.KOOLAW_LOG), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.of(LirothBlocks.KOOLAW_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1)).build());

	    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> PETRIFIED = ConfiguredFeatures.register("petrified", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.PETRIFIED_DAMNATION_LOG), new UpwardsBranchingTrunkPlacer(2, 1, 4, UniformIntProvider.create(1, 4), 0.5f, UniformIntProvider.create(0, 1), Registry.BLOCK.getOrCreateEntryList(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)), BlockStateProvider.of(LirothBlocks.DAMNATION_LEAVES), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 70), Optional.of(new MangroveRootPlacer(UniformIntProvider.create(1, 3), BlockStateProvider.of(LirothBlocks.PETRIFIED_DAMNATION_LOG), Optional.of(new AboveRootPlacement(BlockStateProvider.of(LirothBlocks.PETRIFIED_MOSS_CARPET), 0.5f)), new MangroveRootPlacement(Registry.BLOCK.getOrCreateEntryList(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), RegistryEntryList.of(Block::getRegistryEntry, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS), BlockStateProvider.of(Blocks.MUDDY_MANGROVE_ROOTS), 8, 15, 0.2f))), new TwoLayersFeatureSize(2, 0, 2)).decorators(List.of(new LeavesVineTreeDecorator(0.125f), new AttachedToLeavesTreeDecorator(0.14f, 1, 0, new RandomizedIntBlockStateProvider((BlockStateProvider)BlockStateProvider.of((BlockState)Blocks.MANGROVE_PROPAGULE.getDefaultState().with(PropaguleBlock.HANGING, true)), PropaguleBlock.AGE, (IntProvider)UniformIntProvider.create(0, 4)), 2, List.of(Direction.DOWN)))).ignoreVines().build());   
}
