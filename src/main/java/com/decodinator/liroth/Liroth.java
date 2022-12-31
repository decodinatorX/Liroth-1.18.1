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
//import com.decodinator.liroth.core.LirothPortalBuilders;
import com.decodinator.liroth.core.LirothSounds;
import com.decodinator.liroth.core.LirothSpawnEggs;
import com.decodinator.liroth.core.LirothStrippables;
import com.decodinator.liroth.core.blocks.entity.FungalCampfireBlockEntity;
import com.decodinator.liroth.core.blocks.entity.LirothSplitterBlockEntity;
import com.decodinator.liroth.core.blocks.entity.LirothianPetroleumCampfireBlockEntity;
import com.decodinator.liroth.core.blocks.entity.QuantumExtractorBlockEntity;
import com.decodinator.liroth.world.generator.LirothStructures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;

public class Liroth implements ModInitializer {
	public static String MOD_ID = "liroth";
	public static final Logger LOGGER = LoggerFactory.getLogger("liroth");
	    
    // IF THIS WORKS I'LL EAT MY OWN SANDAL!! update: it didn't... UPDATE: IT DOES NOW! SANDAL SPICES TIME!!!! :)
    public static BlockEntityType<FungalCampfireBlockEntity> FUNGAL_CAMPFIRE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "fungal_campfire"), FabricBlockEntityTypeBuilder.create(FungalCampfireBlockEntity::new, LirothBlocks.FUNGAL_CAMPFIRE).build(null));
    public static BlockEntityType<LirothianPetroleumCampfireBlockEntity> LIROTHIAN_PETROLEUM_CAMPFIRE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "lirothian_petroleum_campfire"), FabricBlockEntityTypeBuilder.create(LirothianPetroleumCampfireBlockEntity::new, LirothBlocks.LIROTHIAN_PETROLEUM_CAMPFIRE).build(null));
    public static BlockEntityType<QuantumExtractorBlockEntity> QUANTUM_EXTRACTOR_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "quantum_extractor"), FabricBlockEntityTypeBuilder.create(QuantumExtractorBlockEntity::new, LirothBlocks.QUANTUM_EXTRACTOR).build(null));
    public static BlockEntityType<LirothSplitterBlockEntity> LIROTH_SPLITTER_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "liroth_splitter"), FabricBlockEntityTypeBuilder.create(LirothSplitterBlockEntity::new, LirothBlocks.LIROTH_SPLITTER).build(null));

    
//    public static ScreenHandlerType<LirothSplitterScreenHandler> LIROTH_SPLITTER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Liroth.MOD_ID, "liroth_splitter"), LirothSplitterScreenHandler::new);
//    public static ScreenHandlerType<QuantumExtractorScreenHandler> QUANTUM_EXTRACTOR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Liroth.MOD_ID, "quantum_extractor"), QuantumExtractorScreenHandler::new);
    
   	public static final RegistryKey<ConfiguredFeature<?, ?>> LIROTH = ConfiguredFeatures.of("liroth");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SPICED = ConfiguredFeatures.of("spiced");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALLPIER = ConfiguredFeatures.of("tallpier");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DAMNATION = ConfiguredFeatures.of("damnation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> JAPZ = ConfiguredFeatures.of("japz");
    public static final RegistryKey<ConfiguredFeature<?, ?>> KOOLAW = ConfiguredFeatures.of("koolaw");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED = ConfiguredFeatures.of("pretrified"); 
    
    public static final ItemGroup creativeItemsTab = FabricItemGroup.builder(new Identifier(Liroth.MOD_ID, "liroth_items")).icon(() -> new ItemStack(LirothItems.LIROTH_GEM))
        	.entries((enableFeatures, entries, operatorEnabled) -> {
                for (var supplier : LirothItems.getItems()) {
                	entries.add(supplier);
                }
        	}
        ).build();
        public static final ItemGroup creativeBlocksTab = FabricItemGroup.builder(new Identifier(Liroth.MOD_ID, "liroth_blocks")).icon(() -> new ItemStack(LirothBlocks.LIROTH_GEM_BLOCK.asItem()))
            .entries((enableFeatures, entries, operatorEnabled) -> {
                for (var supplier : LirothBlocks.getBlocks()) {
                    entries.add(supplier);
                }
            }
        ).build();
        public static final ItemGroup creativeCombatTab = FabricItemGroup.builder(new Identifier(Liroth.MOD_ID, "liroth_combat")).icon(() -> new ItemStack(LirothItems.LIROTH_SWORD))
            .entries((enableFeatures, entries, operatorEnabled) -> {
                for (var supplier : LirothItems.getCombatItems()) {
                    entries.add(supplier);
                }
            }
        ).build();
        public static final ItemGroup creativePlantsTab = FabricItemGroup.builder(new Identifier(Liroth.MOD_ID, "liroth_plants")).icon(() -> new ItemStack(LirothBlocks.LIROTH_ROSE.asItem()))
            .entries((enableFeatures, entries, operatorEnabled) -> {
                for (var supplier : LirothBlocks.getPlantBlocks()) {
                    entries.add(supplier);
                }
            }
        ).build();
        public static final ItemGroup creativeEntitiesTab = FabricItemGroup.builder(new Identifier(Liroth.MOD_ID, "liroth_entities")).icon(() -> new ItemStack(LirothItems.UNOBTAINABLE_FORSAKEN_CORPSE_SPAWN_EGG))
            .entries((enableFeatures, entries, operatorEnabled) -> {
            	if (!FabricLoader.getInstance().isModLoaded("liroth_addendum")) {
            		entries.add(LirothSpawnEggs.FORSAKEN_CORPSE_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.FREAKSHOW_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.FUNGAL_FIEND_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.LIROTHIAN_MIMIC_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.PIER_PEEP_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.PROWLER_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.SHADE_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.SKELETAL_FREAK_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.SOUL_ARACHNID_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.VILE_SHARK_SPAWN_EGG);
            		entries.add(LirothSpawnEggs.WARP_SPAWN_EGG);
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
			ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MOD_ID, "classic"), liroth, "Liroth Legacy", ResourcePackActivationType.NORMAL);
		}
	    
	    public static void threadSafeLoadFinish() {
	        LOGGER.debug("Liroth: Loading almost done...");
	        LirothStrippables.strippableLogsLiroth();
	        LirothHoeables.tillablesLiroth();
	        LirothFlattenables.addFlatfuckfridayevent();
	        LOGGER.info("Liroth: Loading Success!");
	    }
}
