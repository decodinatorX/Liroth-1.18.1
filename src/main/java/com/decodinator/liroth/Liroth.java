package com.decodinator.liroth;

import net.fabricmc.fabric.impl.biome.modification.BuiltInRegistryKeys;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;

import java.util.Map;
import java.util.Optional;

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
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.armortrim.TrimMaterial;
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

	public static final ResourceKey<CreativeModeTab> creativeItemsTab = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(MOD_ID, "liroth_items"));
	public static final ResourceKey<CreativeModeTab> creativeBlocksTab = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(MOD_ID, "liroth_blocks"));
	public static final ResourceKey<CreativeModeTab> creativeCombatTab = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(MOD_ID, "liroth_combat"));
	public static final ResourceKey<CreativeModeTab> creativePlantsTab = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(MOD_ID, "liroth_plants"));
	public static final ResourceKey<CreativeModeTab> creativeEntitiesTab = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), new ResourceLocation(MOD_ID, "liroth_entities"));
    
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

			Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, creativeItemsTab, FabricItemGroup.builder().icon(() -> new ItemStack(LirothItems.LIROTH_GEM))
					.displayItems((itemDisplayParameters, output) -> {
								for (var supplier : LirothItems.getItems()) {
									output.accept(supplier);
								}
							}
					).title(Component.translatable("itemGroup.liroth.liroth_items")
					).build());

			Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, creativeBlocksTab, FabricItemGroup.builder().icon(() -> new ItemStack(LirothBlocks.LIROTH_GEM_BLOCK.asItem()))
					.displayItems((itemDisplayParameters, output) -> {
								for (var supplier : LirothBlocks.getBlocks()) {
									output.accept(supplier);
								}
							}
					).title(Component.translatable("itemGroup.liroth.liroth_blocks")
					).build());

			Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, creativeCombatTab, FabricItemGroup.builder().icon(() -> new ItemStack(LirothItems.LIROTH_SWORD))
					.displayItems((itemDisplayParameters, output) -> {
								for (var supplier : LirothItems.getCombatItems()) {
									output.accept(supplier);
								}
							}
					).title(Component.translatable("itemGroup.liroth.liroth_combat")
					).build());

			Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, creativePlantsTab, FabricItemGroup.builder().icon(() -> new ItemStack(LirothBlocks.LIROTH_ROSE.asItem()))
					.displayItems((itemDisplayParameters, output) -> {
								for (var supplier : LirothBlocks.getPlantBlocks()) {
									output.accept(supplier);
								}
							}
					).title(Component.translatable("itemGroup.liroth.liroth_plants")
					).build());

			Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, creativeEntitiesTab, FabricItemGroup.builder().icon(() -> new ItemStack(LirothItems.UNOBTAINABLE_FORSAKEN_CORPSE_SPAWN_EGG))
					.displayItems((itemDisplayParameters, output) -> {
								for (var supplier : LirothSpawnEggs.getSpawnEggs()) {
									output.accept(supplier);
								}
							}
					).title(Component.translatable("itemGroup.liroth.liroth_entities")
					).build());
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
