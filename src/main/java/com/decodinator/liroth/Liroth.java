package com.decodinator.liroth;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.core.LirothFeatures;
import com.decodinator.liroth.core.LirothFlattenables;
import com.decodinator.liroth.core.LirothFluids;
import com.decodinator.liroth.core.LirothHoeables;
import com.decodinator.liroth.core.LirothItems;
import com.decodinator.liroth.core.LirothParticles;
import com.decodinator.liroth.core.LirothPortalBuilders;
import com.decodinator.liroth.core.LirothSounds;
import com.decodinator.liroth.core.LirothStrippables;
import com.decodinator.liroth.core.blocks.entity.FungalCampfireBlockEntity;
import com.decodinator.liroth.core.blocks.entity.LirothSplitterBlockEntity;
import com.decodinator.liroth.core.blocks.entity.LirothSplitterScreenHandler;
import com.decodinator.liroth.core.blocks.entity.LirothianPetroleumCampfireBlockEntity;
import com.decodinator.liroth.core.blocks.entity.QuantumExtractorBlockEntity;
import com.decodinator.liroth.core.blocks.entity.QuantumExtractorScreenHandler;
import com.decodinator.liroth.world.generator.LirothStructures;
import com.google.common.collect.ImmutableList;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PropaguleBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
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

@SuppressWarnings("deprecation")
public class Liroth implements ModInitializer {
	public static String MOD_ID = "liroth";
	public static final Logger LOGGER = LoggerFactory.getLogger("liroth");
	    
    // IF THIS WORKS I'LL EAT MY OWN SANDAL!! update: it didn't... UPDATE: IT DOES NOW! SANDAL SPICES TIME!!!! :)
    public static BlockEntityType<FungalCampfireBlockEntity> FUNGAL_CAMPFIRE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "fungal_campfire"), FabricBlockEntityTypeBuilder.create(FungalCampfireBlockEntity::new, LirothBlocks.FUNGAL_CAMPFIRE).build(null));
    public static BlockEntityType<LirothianPetroleumCampfireBlockEntity> LIROTHIAN_PETROLEUM_CAMPFIRE_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "lirothian_petroleum_campfire"), FabricBlockEntityTypeBuilder.create(LirothianPetroleumCampfireBlockEntity::new, LirothBlocks.LIROTHIAN_PETROLEUM_CAMPFIRE).build(null));
    public static BlockEntityType<QuantumExtractorBlockEntity> QUANTUM_EXTRACTOR_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "quantum_extractor"), FabricBlockEntityTypeBuilder.create(QuantumExtractorBlockEntity::new, LirothBlocks.QUANTUM_EXTRACTOR).build(null));
    public static BlockEntityType<LirothSplitterBlockEntity> LIROTH_SPLITTER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "liroth_splitter"), FabricBlockEntityTypeBuilder.create(LirothSplitterBlockEntity::new, LirothBlocks.LIROTH_SPLITTER).build(null));
    
    public static ScreenHandlerType<LirothSplitterScreenHandler> LIROTH_SPLITTER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Liroth.MOD_ID, "liroth_splitter"), LirothSplitterScreenHandler::new);
    public static ScreenHandlerType<QuantumExtractorScreenHandler> QUANTUM_EXTRACTOR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Liroth.MOD_ID, "quantum_extractor"), QuantumExtractorScreenHandler::new);
    
   	public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> LIROTH = ConfiguredFeatures.register("liroth", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.LIROTH_LOG), new LargeOakTrunkPlacer(3, 11, 0), BlockStateProvider.of(LirothBlocks.LIROTH_LEAVES), new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> SPICED = ConfiguredFeatures.register("spiced", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.SPICED_LOG), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.of(LirothBlocks.SPICED_LEAVES), new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> TALLPIER = ConfiguredFeatures.register("tallpier", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.TALLPIER_LOG), new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.of(LirothBlocks.TALLPIER_LEAVES), new JungleFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25f))).build());
    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> DAMNATION = ConfiguredFeatures.register("damnation", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.DAMNATION_LOG), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.of(LirothBlocks.DAMNATION_LEAVES), new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build());
    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> JAPZ = ConfiguredFeatures.register("japz", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.JAPZ_LOG), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.of(LirothBlocks.JAPZ_LEAVES), new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> KOOLAW = ConfiguredFeatures.register("koolaw", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.KOOLAW_LOG), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.of(LirothBlocks.KOOLAW_LEAVES), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), new TwoLayersFeatureSize(1, 0, 1)).build());
    public static final RegistryEntry<? extends ConfiguredFeature<?, ?>> PETRIFIED = ConfiguredFeatures.register("petrified", Feature.TREE, new TreeFeatureConfig.Builder(BlockStateProvider.of(LirothBlocks.PETRIFIED_DAMNATION_LOG), new UpwardsBranchingTrunkPlacer(2, 1, 4, UniformIntProvider.create(1, 4), 0.5f, UniformIntProvider.create(0, 1), Registry.BLOCK.getOrCreateEntryList(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)), BlockStateProvider.of(LirothBlocks.DAMNATION_LEAVES), new RandomSpreadFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(2), 70), Optional.of(new MangroveRootPlacer(UniformIntProvider.create(1, 3), BlockStateProvider.of(LirothBlocks.PETRIFIED_DAMNATION_LOG), Optional.of(new AboveRootPlacement(BlockStateProvider.of(LirothBlocks.PETRIFIED_MOSS_CARPET), 0.5f)), new MangroveRootPlacement(Registry.BLOCK.getOrCreateEntryList(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), RegistryEntryList.of(Block::getRegistryEntry, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS), BlockStateProvider.of(Blocks.MUDDY_MANGROVE_ROOTS), 8, 15, 0.2f))), new TwoLayersFeatureSize(2, 0, 2)).decorators(List.of(new LeavesVineTreeDecorator(0.125f), new AttachedToLeavesTreeDecorator(0.14f, 1, 0, new RandomizedIntBlockStateProvider((BlockStateProvider)BlockStateProvider.of((BlockState)Blocks.MANGROVE_PROPAGULE.getDefaultState().with(PropaguleBlock.HANGING, true)), PropaguleBlock.AGE, (IntProvider)UniformIntProvider.create(0, 4)), 2, List.of(Direction.DOWN)))).ignoreVines().build()); 
    
		@Override
		public void onInitialize() {

			LOGGER.info("Liroth: Begin Loading...");
			LirothRegistries.registerFluids();
			LirothRegistries.registerBlocks();
		    LirothRegistries.registerItems();
		    LirothRegistries.registerEntities();
		    LirothRegistries.registerPortals();
		    LirothRegistries.registerParticles();
		    LirothRegistries.registerSounds();
		    LirothRegistries.registerFeatures();
		    LirothRegistries.registerStructures();
		    LirothRegistries.registerFuels();
	        Liroth.threadSafeLoadFinish();
		
		}
		
	    public static class LirothRegistries {
	        public static void registerBlocks() {
	        	Liroth.LOGGER.debug("Liroth: Registering blocks...");
	        	LirothBlocks.init();
	            Liroth.LOGGER.info("Liroth: Blocks registered!");
	        }
	        
	        public static void registerFluids() {
	        	Liroth.LOGGER.debug("Liroth: Registering fluids...");
	        	LirothFluids.init();
	            Liroth.LOGGER.info("Liroth: Fluids registered!");
	        }
	    	
	        public static void registerItems() {
	        	Liroth.LOGGER.debug("Liroth: Registering items...");
	        	LirothItems.init();
	            Liroth.LOGGER.info("Liroth: Items registered!");
	        }
	        
	        public static void registerEntities() {
	        	Liroth.LOGGER.debug("Liroth: Registering entities...");
	        	LirothEntities.init();
	            Liroth.LOGGER.info("Liroth: Entities registered!");
	        }
	        
	        public static void registerPortals() {
	        	Liroth.LOGGER.debug("Liroth: Registering portals...");
	        	LirothPortalBuilders.init();
	            Liroth.LOGGER.info("Liroth: Portals registered!");
	        }
	        
	        public static void registerParticles() {
	        	Liroth.LOGGER.debug("Liroth: Registering particles...");
	        	LirothParticles.init();
	            Liroth.LOGGER.info("Liroth: Particles registered!");
	        }
	        
	        public static void registerSounds() {
	        	Liroth.LOGGER.debug("Liroth: Registering sounds...");
	        	LirothSounds.init();
	            Liroth.LOGGER.info("Liroth: Sounds registered!");
	        }
	        
	        public static void registerFeatures() {
	        	Liroth.LOGGER.debug("Liroth: Registering features...");
				LirothFeatures.init();      
				Liroth.LOGGER.info("Liroth: Features registered!");
	        }
	        
	        public static void registerStructures() {
	        	Liroth.LOGGER.debug("Liroth: Registering structures...");
				LirothStructures.init();      
				Liroth.LOGGER.info("Liroth: Structures registered!");
	        }
	        
	        public static void registerFuels() {
	        	Liroth.LOGGER.debug("Liroth: Registering fuels...");
	        	FuelRegistry registry = FuelRegistry.INSTANCE;
	        	registry.add(LirothBlocks.DAMNATION_FUNGAL_CLUSTER, 3200);
	        	registry.add(LirothBlocks.DAMNATION_FUNGUS, 1600);
	        	registry.add(LirothItems.LIROTHIAN_PETROLEUM, 1600);
	        	registry.add(LirothBlocks.LIROTHIAN_PETROLEUM_BLOCK, 16000);
	        	Liroth.LOGGER.info("Liroth: Fuels registered!");
	        }
	    }
	    
	    public static void threadSafeLoadFinish() {
	        LOGGER.debug("Liroth: Loading almost done...");
	        LirothStrippables.strippableLogsLiroth();
	        LirothHoeables.tillablesLiroth();
	        LirothFlattenables.addFlatfuckfridayevent();
	        LOGGER.info("Liroth: Loading Success!");
	    }
}
