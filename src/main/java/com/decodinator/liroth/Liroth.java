package com.decodinator.liroth;

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
import com.decodinator.liroth.core.LirothRecipeTypes;
import com.decodinator.liroth.core.LirothSounds;
import com.decodinator.liroth.core.LirothSpawnEggs;
import com.decodinator.liroth.core.LirothStrippables;
import com.decodinator.liroth.core.blocks.entity.FungalCampfireBlockEntity;
import com.decodinator.liroth.core.blocks.entity.LirothianPetroleumCampfireBlockEntity;
import com.decodinator.liroth.core.blocks.entity.QuantumBlockEntity;
import com.decodinator.liroth.core.blocks.entity.SplitterBlockEntity;
import com.decodinator.liroth.world.generator.LirothStructures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class Liroth implements ModInitializer {
	public static String MOD_ID = "liroth";
	public static final Logger LOGGER = LoggerFactory.getLogger("liroth");
	    
    // IF THIS WORKS I'LL EAT MY OWN SANDAL!! update: it didn't... UPDATE: IT DOES NOW! SANDAL SPICES TIME!!!! :)
    public static BlockEntityType<FungalCampfireBlockEntity> FUNGAL_CAMPFIRE_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Liroth.MOD_ID, "fungal_campfire"), FabricBlockEntityTypeBuilder.create(FungalCampfireBlockEntity::new, LirothBlocks.FUNGAL_CAMPFIRE).build(null));
    public static BlockEntityType<LirothianPetroleumCampfireBlockEntity> LIROTHIAN_PETROLEUM_CAMPFIRE_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Liroth.MOD_ID, "lirothian_petroleum_campfire"), FabricBlockEntityTypeBuilder.create(LirothianPetroleumCampfireBlockEntity::new, LirothBlocks.LIROTHIAN_PETROLEUM_CAMPFIRE).build(null));
    public static BlockEntityType<QuantumBlockEntity> QUANTUM_EXTRACTOR_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Liroth.MOD_ID, "quantum_extractor"), FabricBlockEntityTypeBuilder.create(QuantumBlockEntity::new, LirothBlocks.QUANTUM_EXTRACTOR).build(null));
    public static BlockEntityType<SplitterBlockEntity> LIROTH_SPLITTER_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Liroth.MOD_ID, "liroth_splitter"), FabricBlockEntityTypeBuilder.create(SplitterBlockEntity::new, LirothBlocks.LIROTH_SPLITTER).build(null));

    
//    public static ScreenHandlerType<LirothSplitterScreenHandler> LIROTH_SPLITTER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new ResourceLocation(Liroth.MOD_ID, "liroth_splitter"), LirothSplitterScreenHandler::new);
//    public static ScreenHandlerType<QuantumExtractorScreenHandler> QUANTUM_EXTRACTOR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new ResourceLocation(Liroth.MOD_ID, "quantum_extractor"), QuantumExtractorScreenHandler::new);
    
   	public static final ResourceKey<ConfiguredFeature<?, ?>> LIROTH = FeatureUtils.createKey("liroth");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPICED = FeatureUtils.createKey("spiced");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALLPIER = FeatureUtils.createKey("tallpier");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DAMNATION = FeatureUtils.createKey("damnation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JAPZ = FeatureUtils.createKey("japz");
    public static final ResourceKey<ConfiguredFeature<?, ?>> KOOLAW = FeatureUtils.createKey("koolaw");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PETRIFIED = FeatureUtils.createKey("pretrified"); 
    
    public static final CreativeModeTab creativeItemsTab = FabricItemGroup.builder(new ResourceLocation(Liroth.MOD_ID, "liroth_items")).icon(() -> new ItemStack(LirothItems.LIROTH_GEM))
        	.displayItems((enableFeatures, entries, operatorEnabled) -> {
                for (var supplier : LirothItems.getItems()) {
                	entries.accept(supplier);
                }
        	}
        ).build();
        public static final CreativeModeTab creativeBlocksTab = FabricItemGroup.builder(new ResourceLocation(Liroth.MOD_ID, "liroth_blocks")).icon(() -> new ItemStack(LirothBlocks.LIROTH_GEM_BLOCK.asItem()))
            .displayItems((enableFeatures, entries, operatorEnabled) -> {
                for (var supplier : LirothBlocks.getBlocks()) {
                    entries.accept(supplier);
                }
            }
        ).build();
        public static final CreativeModeTab creativeCombatTab = FabricItemGroup.builder(new ResourceLocation(Liroth.MOD_ID, "liroth_combat")).icon(() -> new ItemStack(LirothItems.LIROTH_SWORD))
            .displayItems((enableFeatures, entries, operatorEnabled) -> {
                for (var supplier : LirothItems.getCombatItems()) {
                    entries.accept(supplier);
                }
            }
        ).build();
        public static final CreativeModeTab creativePlantsTab = FabricItemGroup.builder(new ResourceLocation(Liroth.MOD_ID, "liroth_plants")).icon(() -> new ItemStack(LirothBlocks.LIROTH_ROSE.asItem()))
            .displayItems((enableFeatures, entries, operatorEnabled) -> {
                for (var supplier : LirothBlocks.getPlantBlocks()) {
                    entries.accept(supplier);
                }
            }
        ).build();
        public static final CreativeModeTab creativeEntitiesTab = FabricItemGroup.builder(new ResourceLocation(Liroth.MOD_ID, "liroth_entities")).icon(() -> new ItemStack(LirothItems.UNOBTAINABLE_FORSAKEN_CORPSE_SPAWN_EGG))
            .displayItems((enableFeatures, entries, operatorEnabled) -> {
            	if (!FabricLoader.getInstance().isModLoaded("liroth_addendum")) {
            		entries.accept(LirothSpawnEggs.FORSAKEN_CORPSE_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.FREAKSHOW_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.FUNGAL_FIEND_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.LIROTHIAN_MIMIC_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.PIER_PEEP_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.PROWLER_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.SHADE_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.SKELETAL_FREAK_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.SOUL_ARACHNID_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.VILE_SHARK_SPAWN_EGG);
            		entries.accept(LirothSpawnEggs.WARP_SPAWN_EGG);
            	}
            }
        ).build();  
    
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
		    LirothRegistries.registerRecipeTypes();
		    LirothRegistries.registerFuels();
	        Liroth.threadSafeLoadFinish();
			addClassicPack();
		      if(!FabricLoader.getInstance().isModLoaded("liroth_addendum")) {
		    	  LirothRegistries.registerSpawnEggItems();
		      }
		
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
	        
	        public static void registerSpawnEggItems() {
	        	Liroth.LOGGER.debug("Liroth: Registering spawn eggs...");
	        	LirothSpawnEggs.init();
	            Liroth.LOGGER.info("Liroth: Spawn Eggs registered!");
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
	        
	        public static void registerRecipeTypes() {
	        	Liroth.LOGGER.debug("Liroth: Registering Recipe Types...");
	        	LirothRecipeTypes.init();
	        	Liroth.LOGGER.info("Liroth: Recipe Types registered!");
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
	    
		@SuppressWarnings("deprecation")
		public static void addClassicPack() {
			ModContainer liroth = FabricLoader.getInstance().getModContainer(MOD_ID)
					.orElseThrow(() -> new IllegalStateException("Liroth's ModContainer couldn't be found!"));
			ResourceManagerHelper.registerBuiltinResourcePack(new ResourceLocation(MOD_ID, "classic"), liroth, "Liroth Legacy", ResourcePackActivationType.NORMAL);
		}
	    
	    public static void threadSafeLoadFinish() {
	        LOGGER.debug("Liroth: Loading almost done...");
	        LirothStrippables.strippableLogsLiroth();
	        LirothHoeables.tillablesLiroth();
	        LirothFlattenables.addFlatfuckfridayevent();
	        LOGGER.info("Liroth: Loading Success!");
	    }
}
