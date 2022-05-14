package com.decodinator.liroth;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothFlattenables;
import com.decodinator.liroth.core.LirothHoeables;
import com.decodinator.liroth.core.LirothItems;
import com.decodinator.liroth.core.LirothRenders;
import com.decodinator.liroth.core.LirothStrippables;
import com.decodinator.liroth.core.blocks.entity.FungalCampfireBlockEntity;
import com.decodinator.liroth.core.blocks.entity.LirothSplitterBlockEntity;
import com.decodinator.liroth.core.blocks.entity.LirothSplitterScreen;
import com.decodinator.liroth.core.blocks.entity.LirothSplitterScreenHandler;
import com.decodinator.liroth.core.blocks.entity.LirothianPetroleumCampfireBlockEntity;
import com.decodinator.liroth.core.blocks.entity.QuantumExtractorBlockEntity;
import com.decodinator.liroth.core.blocks.entity.QuantumExtractorScreen;
import com.decodinator.liroth.core.blocks.entity.QuantumExtractorScreenHandler;
import com.decodinator.liroth.core.features.DamnationVinesFeature;
import com.decodinator.liroth.core.features.JalsphireCrystalClusterFeature;
import com.decodinator.liroth.core.features.LirothBoneClawFeature;
import com.decodinator.liroth.core.features.LirothBoneMushroomFeature;
import com.decodinator.liroth.core.features.LirothBoneTreeFeature;
import com.decodinator.liroth.core.features.ObsidianSpikeFeature;
import com.decodinator.liroth.core.features.PetrifiedCrystalClusterFeature;
import com.decodinator.liroth.core.features.VileTentacleFeature;
import com.decodinator.liroth.core.fluids.LirothFluid;
import com.decodinator.liroth.core.fluids.LirothFluidRenderingModClient;
import com.decodinator.liroth.core.fluids.MoltenSpinerios;
import com.decodinator.liroth.core.fluids.SchluckedFluidBlock;
import com.decodinator.liroth.core.helpers.AnsalumLirothArmorMaterial;
import com.decodinator.liroth.core.helpers.AnsalumLirothToolMaterial;
import com.decodinator.liroth.core.helpers.LirothArmorMaterial;
import com.decodinator.liroth.core.helpers.LirothToolMaterial;
import com.decodinator.liroth.core.helpers.LirothianCobaltArmorMaterial;
import com.decodinator.liroth.core.helpers.LirothianCobaltToolMaterial;
import com.decodinator.liroth.core.helpers.LuxLirothArmorMaterial;
import com.decodinator.liroth.core.helpers.LuxLirothToolMaterial;
import com.decodinator.liroth.core.helpers.PotestiumLirothArmorMaterial;
import com.decodinator.liroth.core.helpers.QuantumLirothArmorMaterial;
import com.decodinator.liroth.core.helpers.QuantumLirothToolMaterial;
import com.decodinator.liroth.core.helpers.SalemLirothArmorMaterial;
import com.decodinator.liroth.core.helpers.SalemLirothToolMaterial;
import com.decodinator.liroth.core.helpers.TourmalineArmorMaterial;
import com.decodinator.liroth.core.helpers.TourmalineToolMaterial;
import com.decodinator.liroth.core.items.BeamItem;
import com.decodinator.liroth.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.entities.FreakshowEntity;
import com.decodinator.liroth.entities.FungalFiendEntity;
import com.decodinator.liroth.entities.LirothianMimicEntity;
import com.decodinator.liroth.entities.PierPeepEntity;
import com.decodinator.liroth.entities.ProwlerEntity;
import com.decodinator.liroth.entities.ShadeEntity;
import com.decodinator.liroth.entities.SkeletalFreakEntity;
import com.decodinator.liroth.entities.SoulArachnidEntity;
import com.decodinator.liroth.entities.VileSharkEntity;
import com.decodinator.liroth.entities.WarpEntity;
import com.decodinator.liroth.entities.projectiles.BeamLaserProjectileEntity;
import com.decodinator.liroth.mixin.access.ItemBlockRenderTypeAccess;
import com.decodinator.liroth.world.generator.LirothStructures;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.DripstoneClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.RandomPatchFeature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class Liroth implements ModInitializer {
	public static String MOD_ID = "liroth";
	public static final Logger LOGGER = LoggerFactory.getLogger("liroth");

	public static FlowableFluid LIROTH_FLUID_STILL;
	public static FlowableFluid LIROTH_FLUID_FLOWING;
	public static Item LIROTH_FLUID_BUCKET;
	public static Block LIROTH_FLUID;
	
	public static FlowableFluid MOLTEN_SPINERIOS_STILL;
	public static FlowableFluid MOLTEN_SPINERIOS_FLOWING;
	public static Item MOLTEN_SPINERIOS_BUCKET;
	public static Block MOLTEN_SPINERIOS;
	
    public static final ArmorMaterial LIROTH_ARMOR_MATERIAL = new LirothArmorMaterial();
    public static final ToolMaterial LIROTH_TOOL_MATERIAL = new LirothToolMaterial();
    public static final ArmorMaterial LIROTHIAN_COBALT_ARMOR_MATERIAL = new LirothianCobaltArmorMaterial();
    public static final ToolMaterial LIROTHIAN_COBALT_TOOL_MATERIAL = new LirothianCobaltToolMaterial();
    public static final ArmorMaterial TOURMALINE_ARMOR_MATERIAL = new TourmalineArmorMaterial();
    public static final ToolMaterial TOURMALINE_TOOL_MATERIAL = new TourmalineToolMaterial();
    public static final ArmorMaterial ANSALUM_LIROTH_ARMOR_MATERIAL = new AnsalumLirothArmorMaterial();
    public static final ToolMaterial ANSALUM_LIROTH_TOOL_MATERIAL = new AnsalumLirothToolMaterial();
    public static final ArmorMaterial LUX_LIROTH_ARMOR_MATERIAL = new LuxLirothArmorMaterial();
    public static final ToolMaterial LUX_LIROTH_TOOL_MATERIAL = new LuxLirothToolMaterial();
    public static final ArmorMaterial SALEM_LIROTH_ARMOR_MATERIAL = new SalemLirothArmorMaterial();
    public static final ToolMaterial SALEM_LIROTH_TOOL_MATERIAL = new SalemLirothToolMaterial();
    public static final ArmorMaterial QUANTUM_LIROTH_ARMOR_MATERIAL = new QuantumLirothArmorMaterial();
    public static final ToolMaterial QUANTUM_LIROTH_TOOL_MATERIAL = new QuantumLirothToolMaterial();
    public static final ArmorMaterial POTESTIUM_LIROTH_ARMOR_MATERIAL = new PotestiumLirothArmorMaterial();
    
    public static final Identifier LIROTH_BLASTER_FIRING_SOUND_ID = new Identifier("liroth:liroth_blaster_firing");
    public static SoundEvent LIROTH_BLASTER_FIRING_SOUND_EVENT = new SoundEvent(LIROTH_BLASTER_FIRING_SOUND_ID);
    
    // Fungal Fiend
    public static final Identifier FUNGAL_FIEND_DEATH_SOUND_ID = new Identifier("liroth:fungal_fiend_death");
    public static SoundEvent FUNGAL_FIEND_DEATH_SOUND_EVENT = new SoundEvent(FUNGAL_FIEND_DEATH_SOUND_ID);    
    public static final Identifier FUNGAL_FIEND_HURT_SOUND_ID = new Identifier("liroth:fungal_fiend_hurt");
    public static SoundEvent FUNGAL_FIEND_HURT_SOUND_EVENT = new SoundEvent(FUNGAL_FIEND_HURT_SOUND_ID);
    public static final Identifier FUNGAL_FIEND_FUSE_SOUND_ID = new Identifier("liroth:fungal_fiend_fuse");
    public static SoundEvent FUNGAL_FIEND_FUSE_SOUND_EVENT = new SoundEvent(FUNGAL_FIEND_FUSE_SOUND_ID);
    
    // Warp
    public static final Identifier WARP_DEATH_SOUND_ID = new Identifier("liroth:warp_death");
    public static SoundEvent WARP_DEATH_SOUND_EVENT = new SoundEvent(WARP_DEATH_SOUND_ID);    
    public static final Identifier WARP_HURT_SOUND_ID = new Identifier("liroth:warp_hurt");
    public static SoundEvent WARP_HURT_SOUND_EVENT = new SoundEvent(WARP_HURT_SOUND_ID);
    public static final Identifier WARP_IDLE_SOUND_ID = new Identifier("liroth:warp_idle");
    public static SoundEvent WARP_IDLE_SOUND_EVENT = new SoundEvent(WARP_IDLE_SOUND_ID);
    
    // Shade
    public static final Identifier SHADE_DEATH_SOUND_ID = new Identifier("liroth:shade_death");
    public static SoundEvent SHADE_DEATH_SOUND_EVENT = new SoundEvent(SHADE_DEATH_SOUND_ID);    
    public static final Identifier SHADE_HURT_SOUND_ID = new Identifier("liroth:shade_hurt");
    public static SoundEvent SHADE_HURT_SOUND_EVENT = new SoundEvent(SHADE_HURT_SOUND_ID);
    public static final Identifier SHADE_IDLE_SOUND_ID = new Identifier("liroth:shade_idle");
    public static SoundEvent SHADE_IDLE_SOUND_EVENT = new SoundEvent(SHADE_IDLE_SOUND_ID);
    
    // AMS - C418
    public static final Identifier LIROTH_BIOME_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.liroth_biome");
    public static SoundEvent LIROTH_BIOME_MUSIC_SOUND_EVENT = new SoundEvent(LIROTH_BIOME_MUSIC_SOUND_ID);
    
    // ATX - C418
    public static final Identifier TALLPIER_BIOME_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.tallpier_biome");
    public static SoundEvent TALLPIER_BIOME_MUSIC_SOUND_EVENT = new SoundEvent(TALLPIER_BIOME_MUSIC_SOUND_ID);
    
    // Fake Triplets - C418
    public static final Identifier SPICED_DESERT_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.spiced_desert");
    public static SoundEvent SPICED_DESERT_MUSIC_SOUND_EVENT = new SoundEvent(SPICED_DESERT_MUSIC_SOUND_ID);
    
    // Home - C418
    public static final Identifier DAMNATION_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.damnation");
    public static SoundEvent DAMNATION_MUSIC_SOUND_EVENT = new SoundEvent(DAMNATION_MUSIC_SOUND_ID);
    
    // Hope - C418
    public static final Identifier ESCAPE_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.escape");
    public static SoundEvent ESCAPE_MUSIC_SOUND_EVENT = new SoundEvent(ESCAPE_MUSIC_SOUND_ID);
    
    // Keighley - C418
    public static final Identifier JALSPHIRE_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.jalsphire");
    public static SoundEvent JALSPHIRE_MUSIC_SOUND_EVENT = new SoundEvent(JALSPHIRE_MUSIC_SOUND_ID);
    
    // Impostor Syndrome - C418
    public static final Identifier DESOLATE_MUSIC_SOUND_ID = new Identifier("liroth:music.liroth.desolate");
    public static SoundEvent DESOLATE_MUSIC_SOUND_EVENT = new SoundEvent(DESOLATE_MUSIC_SOUND_ID);
    
    public static final EntityType<FungalFiendEntity> FUNGAL_FIEND = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "fungal_fiend"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FungalFiendEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2f)).build()
    );
    
    public static final Item FUNGAL_FIEND_SPAWN_EGG = new SpawnEggItem(FUNGAL_FIEND, 1315860, 2031360, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
	
    public static final EntityType<ForsakenCorpseEntity> FORSAKEN_CORPSE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "forsaken_corpse"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ForsakenCorpseEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build()
    );
    
    public static final Item FORSAKEN_CORPSE_SPAWN_EGG = new SpawnEggItem(FORSAKEN_CORPSE, 1842204, 10551525, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
    public static final EntityType<SkeletalFreakEntity> SKELETAL_FREAK = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "skeletal_freak"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SkeletalFreakEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build()
    );
    
    public static final Item SKELETAL_FREAK_SPAWN_EGG = new SpawnEggItem(SKELETAL_FREAK, 1513239, 16711900, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
    public static final EntityType<WarpEntity> WARP = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "warp"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WarpEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final Item WARP_SPAWN_EGG = new SpawnEggItem(WARP, 524305, 4260003, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
    public static final EntityType<SoulArachnidEntity> SOUL_ARACHNID = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "soul_arachnid"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulArachnidEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final Item SOUL_ARACHNID_SPAWN_EGG = new SpawnEggItem(SOUL_ARACHNID, 73758, 5078138, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
    public static final EntityType<PierPeepEntity> PIER_PEEP = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "pier_peep"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PierPeepEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final Item PIER_PEEP_SPAWN_EGG = new SpawnEggItem(PIER_PEEP, 1638400, 11665663, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
    public static final EntityType<ShadeEntity> SHADE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "shade"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ShadeEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final Item SHADE_SPAWN_EGG = new SpawnEggItem(SHADE, 328965, 1579032, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
    public static final EntityType<ProwlerEntity> PROWLER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "prowler"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ProwlerEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final Item PROWLER_SPAWN_EGG = new SpawnEggItem(PROWLER, 16312063, 4260003, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
    public static final EntityType<FreakshowEntity> FREAKSHOW = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "freakshow"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FreakshowEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final Item FREAKSHOW_SPAWN_EGG = new SpawnEggItem(FREAKSHOW, 524305, 1579032, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
    public static final EntityType<VileSharkEntity> VILE_SHARK = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "vile_shark"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, VileSharkEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final Item VILE_SHARK_SPAWN_EGG = new SpawnEggItem(VILE_SHARK, 5963996, 7667865, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
    public static final EntityType<LirothianMimicEntity> LIROTHIAN_MIMIC = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "lirothian_mimic"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LirothianMimicEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final Item LIROTHIAN_MIMIC_SPAWN_EGG = new SpawnEggItem(LIROTHIAN_MIMIC, 41655, 10551525, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab));
    
	public static final EntityType<BeamLaserProjectileEntity> BEAM_LASER_PROJECTILE_ENTITY = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(MOD_ID, "beam_laser_projectile_entity"),
			FabricEntityTypeBuilder.<BeamLaserProjectileEntity>create(SpawnGroup.MISC, BeamLaserProjectileEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackable(4, 10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
			);
	
    public static BlockEntityType<LirothSplitterBlockEntity> LIROTH_SPLITTER_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "liroth_splitter"),
                    FabricBlockEntityTypeBuilder.create(LirothSplitterBlockEntity::new,
                            LirothBlocks.LIROTH_SPLITTER).build(null));
    public static ScreenHandlerType<LirothSplitterScreenHandler> LIROTH_SPLITTER_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "liroth_splitter"),
            		LirothSplitterScreenHandler::new);
    
    public static BlockEntityType<QuantumExtractorBlockEntity> QUANTUM_EXTRACTOR_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "quantum_extractor"),
                    FabricBlockEntityTypeBuilder.create(QuantumExtractorBlockEntity::new,
                            LirothBlocks.QUANTUM_EXTRACTOR).build(null));
    public static ScreenHandlerType<QuantumExtractorScreenHandler> QUANTUM_EXTRACTOR_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "quantum_extractor"),
            		QuantumExtractorScreenHandler::new);
    
    // IF THIS WORKS I'LL EAT MY OWN SANDAL!! update: it didn't... UPDATE: IT DOES NOW! SANDAL SPICES TIME!!!! :)
    public static BlockEntityType<FungalCampfireBlockEntity> FUNGAL_CAMPFIRE_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "fungal_campfire"),
                    FabricBlockEntityTypeBuilder.create(FungalCampfireBlockEntity::new,
                            LirothBlocks.FUNGAL_CAMPFIRE).build(null));
	
    public static BlockEntityType<LirothianPetroleumCampfireBlockEntity> LIROTHIAN_PETROLEUM_CAMPFIRE_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MOD_ID, "lirothian_petroleum_campfire"),
                    FabricBlockEntityTypeBuilder.create(LirothianPetroleumCampfireBlockEntity::new,
                            LirothBlocks.LIROTHIAN_PETROLEUM_CAMPFIRE).build(null));
    
	  public static final TagKey<Block> DIRT_ORE_REPLACEABLES = TagKey.of(Registry.BLOCK_KEY, new Identifier("liroth", "dirt_ore_replaceables"));
	  public static final TagKey<Block> LIROTH_FARMLANDS = TagKey.of(Registry.BLOCK_KEY, new Identifier("liroth", "liroth_farmlands"));
	  public static final TagKey<Biome> LIROTH_BIOMES = TagKey.of(Registry.BIOME_KEY, new Identifier("liroth", "liroth_biomes"));
	  public static final TagKey<Fluid> STICKY_FLUIDS = TagKey.of(Registry.FLUID_KEY, new Identifier("liroth", "sticky_fluids"));
	  public static final TagKey<Item> TORCHES = TagKey.of(Registry.ITEM_KEY, new Identifier("liroth", "torches"));
	  
	    public static PersistentProjectileEntity createBeamProjectile(LivingEntity entity, ItemStack stack, float damageModifier) {
	    	BeamItem beamItem = (BeamItem)(stack.getItem() instanceof BeamItem ? stack.getItem() : LirothItems.COOL_BEAM);
	        PersistentProjectileEntity persistentProjectileEntity = beamItem.createBeam(entity.world, stack, entity);
	        persistentProjectileEntity.applyEnchantmentEffects(entity, damageModifier);
	        return persistentProjectileEntity;
	    }
	    
	    public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);

		  private static ConfiguredFeature<?, ?> OVERWORLD_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
			          OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
			          LirothBlocks.TOURMALINE_ORE.getDefaultState(),
			          3)); // vein size
		  
		  private static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_LIROTH_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
				      LirothBlocks.DEEPSLATE_LIROTH_ORE.getDefaultState(),
				      2)); // vein size
		  
		  private static ConfiguredFeature<?, ?> NETHER_LIROTH_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      OreConfiguredFeatures.NETHERRACK,
				      LirothBlocks.NETHER_LIROTH_GEM_ORE.getDefaultState(),
				      4)); // vein size
		  
		  private static ConfiguredFeature<?, ?> END_LIROTH_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      Liroth.END_STONE,
				      LirothBlocks.END_LIROTH_GEM_ORE.getDefaultState(),
				      5)); // vein size
		  
		  private static ConfiguredFeature<?, ?> OVERWORLD_DEEPSLATE_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE = new ConfiguredFeature
				  (Feature.ORE, new OreFeatureConfig(
				      OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
				      LirothBlocks.DEEPSLATE_TOURMALINE_ORE.getDefaultState(),
				      4)); // vein size
		  
		  public static PlacedFeature OVERWORLD_TOURMALINE_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
			      RegistryEntry.of(OVERWORLD_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE),
			      Arrays.asList(
				  SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), BiomePlacementModifier.of()));
		  
		  public static PlacedFeature OVERWORLD_DEEPSLATE_LIROTH_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
			      RegistryEntry.of(OVERWORLD_DEEPSLATE_LIROTH_GEM_ORE_CONFIGURED_FEATURE),
			      Arrays.asList(
			      CountPlacementModifier.of(15), // number of veins per chunk
			      SquarePlacementModifier.of(), // spreading horizontally
			      HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)))); // height
		  
		  public static PlacedFeature NETHER_LIROTH_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
			      RegistryEntry.of(NETHER_LIROTH_GEM_ORE_CONFIGURED_FEATURE),(
				  Liroth.modifiersWithCount(5, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE)));
		  
		  public static PlacedFeature END_LIROTH_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
			      RegistryEntry.of(END_LIROTH_GEM_ORE_CONFIGURED_FEATURE),(
				  Liroth.modifiersWithCount(10, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE)));

		  public static PlacedFeature OVERWORLD_DEEPSLATE_TOURMALINE_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
			      RegistryEntry.of(OVERWORLD_DEEPSLATE_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE),
			      Arrays.asList(
				  SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), BiomePlacementModifier.of()));
		  
		    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
		        return Liroth.modifiers(CountPlacementModifier.of(count), heightModifier);
		    }
		    
		    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
		        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
		    }
		    
			  private static final Feature<DefaultFeatureConfig> OBSIDIAN_SPIKE = new ObsidianSpikeFeature(DefaultFeatureConfig.CODEC);
			  private static final Feature<DefaultFeatureConfig> VILE_TENTALCE = new VileTentacleFeature(DefaultFeatureConfig.CODEC);
			  private static final Feature<DefaultFeatureConfig> LIROTH_BONE_CLAW = new LirothBoneClawFeature(DefaultFeatureConfig.CODEC);
			  private static final Feature<DefaultFeatureConfig> LIROTH_BONE_MUSHROOM = new LirothBoneMushroomFeature(DefaultFeatureConfig.CODEC);
			  private static final Feature<DefaultFeatureConfig> LIROTH_BONE_TREE = new LirothBoneTreeFeature(DefaultFeatureConfig.CODEC);
			  private static final Feature<DripstoneClusterFeatureConfig> JALSPHIRE_CRYSTAL_CLUSTER = new JalsphireCrystalClusterFeature(DripstoneClusterFeatureConfig.CODEC);
			  private static final Feature<DripstoneClusterFeatureConfig> PETRIFIED_CRYSTAL_CLUSTER = new PetrifiedCrystalClusterFeature(DripstoneClusterFeatureConfig.CODEC);
			  private static final Feature<DefaultFeatureConfig> DAMNATION_VINES = new DamnationVinesFeature(DefaultFeatureConfig.CODEC);
			  private static final Feature<RandomPatchFeatureConfig> WILTING_LIROTH_ROSES = new RandomPatchFeature(RandomPatchFeatureConfig.CODEC);
	    
		@Override
		public void onInitialize() {
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(FUNGAL_FIEND, FungalFiendEntity.createFungalFiendAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(FORSAKEN_CORPSE, ForsakenCorpseEntity.createForsakenCorpseAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(SKELETAL_FREAK, SkeletalFreakEntity.createSkeletalFreakAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(WARP, WarpEntity.createWarpAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(SOUL_ARACHNID, SoulArachnidEntity.createSoulArachnidAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(PIER_PEEP, PierPeepEntity.createPierPeepAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(SHADE, ShadeEntity.createShadeAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(PROWLER, ProwlerEntity.createProwlerAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(FREAKSHOW, FreakshowEntity.createFreakshowAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(VILE_SHARK, VileSharkEntity.createVileSharkAttributes());
			net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(LIROTHIAN_MIMIC, LirothianMimicEntity.createLirothianMimicAttributes());

			LirothStructures.registerStructureFeatures();      
		    Registry.register(Registry.FEATURE, new Identifier("liroth", "obsidian_spike"), OBSIDIAN_SPIKE);
		    Registry.register(Registry.FEATURE, new Identifier("liroth", "vile_tentacle"), VILE_TENTALCE);
		    Registry.register(Registry.FEATURE, new Identifier("liroth", "liroth_bone_claw"), LIROTH_BONE_CLAW);
		    Registry.register(Registry.FEATURE, new Identifier("liroth", "liroth_bone_mushroom"), LIROTH_BONE_MUSHROOM);
		    Registry.register(Registry.FEATURE, new Identifier("liroth", "liroth_bone_tree"), LIROTH_BONE_TREE);
		    Registry.register(Registry.FEATURE, new Identifier("liroth", "jalsphire_crystal_cluster"), JALSPHIRE_CRYSTAL_CLUSTER);
		    Registry.register(Registry.FEATURE, new Identifier("liroth", "petrified_crystal_cluster"), PETRIFIED_CRYSTAL_CLUSTER);
		    Registry.register(Registry.FEATURE, new Identifier("liroth", "damnation_vines"), DAMNATION_VINES);
		    Registry.register(Registry.FEATURE, new Identifier("liroth", "wilting_liroth_roses"), WILTING_LIROTH_ROSES);

		    Registry.register(Registry.ITEM, new Identifier("liroth", "anomaly"), new BlockItem(LirothBlocks.ANOMALY, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "anomaly_block"), new BlockItem(LirothBlocks.ANOMALY_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "blue_sand"), new BlockItem(LirothBlocks.BLUE_SAND, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "blue_sandstone"), new BlockItem(LirothBlocks.BLUE_SANDSTONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "blue_sandstone_slab"), new BlockItem(LirothBlocks.BLUE_SANDSTONE_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "blue_sandstone_stairs"), new BlockItem(LirothBlocks.BLUE_SANDSTONE_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "blue_sandstone_wall"), new BlockItem(LirothBlocks.BLUE_SANDSTONE_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "carved_blue_sandstone"), new BlockItem(LirothBlocks.CARVED_BLUE_SANDSTONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_accessway_block"), new BlockItem(LirothBlocks.CHARRED_ACCESSWAY_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_cobblestone"), new BlockItem(LirothBlocks.CHARRED_LIROTH_COBBLESTONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_cobblestone_slab"), new BlockItem(LirothBlocks.CHARRED_LIROTH_COBBLESTONE_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_cobblestone_stairs"), new BlockItem(LirothBlocks.CHARRED_LIROTH_COBBLESTONE_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_cobblestone_wall"), new BlockItem(LirothBlocks.CHARRED_LIROTH_COBBLESTONE_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_gem_ore"), new BlockItem(LirothBlocks.CHARRED_LIROTH_GEM_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_stone"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_stone_slab"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_stone_stairs"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_stone_wall"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_stone_bricks"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_stone_brick_lock"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICK_LOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_stone_brick_slab"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICK_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_stone_brick_stairs"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICK_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "charred_liroth_stone_brick_wall"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICK_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "chiseled_devastated_bricks"), new BlockItem(LirothBlocks.CHISELED_DEVASTATED_BRICKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_brewing_stand"), new BlockItem(LirothBlocks.CORRUPTED_BREWING_STAND, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_jalsphire_gem_block"), new BlockItem(LirothBlocks.CORRUPTED_JALSPHIRE_GEM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_jalsphire_ore"), new BlockItem(LirothBlocks.CORRUPTED_JALSPHIRE_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_liroth_gem_block"), new BlockItem(LirothBlocks.CORRUPTED_LIROTH_GEM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_liroth_gem_ore"), new BlockItem(LirothBlocks.CORRUPTED_LIROTH_GEM_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_crafting_table"), new BlockItem(LirothBlocks.DAMNATION_CRAFTING_TABLE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_chest"), new BlockItem(LirothBlocks.DAMNATION_CHEST, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_door"), new BlockItem(LirothBlocks.DAMNATION_DOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_fence"), new BlockItem(LirothBlocks.DAMNATION_FENCE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_fungal_cluster"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_CLUSTER, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_fungus"), new BlockItem(LirothBlocks.DAMNATION_FUNGUS, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_fungal_carpet"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_CARPET, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_fungal_heap"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_HEAP, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_fungal_fuss"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_FUSS, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_fungal_patch"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_PATCH, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_leaves"), new BlockItem(LirothBlocks.DAMNATION_LEAVES, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_log"), new BlockItem(LirothBlocks.DAMNATION_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_wood"), new BlockItem(LirothBlocks.DAMNATION_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_planks"), new BlockItem(LirothBlocks.DAMNATION_PLANKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_sapling"), new BlockItem(LirothBlocks.DAMNATION_SAPLING, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_soil"), new BlockItem(LirothBlocks.DAMNATION_SOIL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_slab"), new BlockItem(LirothBlocks.DAMNATION_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_stairs"), new BlockItem(LirothBlocks.DAMNATION_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_trapdoor"), new BlockItem(LirothBlocks.DAMNATION_TRAPDOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_wart_block"), new BlockItem(LirothBlocks.DAMNATION_WART_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damnation_vines"), new BlockItem(LirothBlocks.DAMNATION_VINES, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "damned_passageway"), new BlockItem(LirothBlocks.DAMNED_PASSAGEWAY, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "deepslate_liroth_gem_ore"), new BlockItem(LirothBlocks.DEEPSLATE_LIROTH_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "devastated_brick_slab"), new BlockItem(LirothBlocks.DEVASTATED_BRICK_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "devastated_brick_stairs"), new BlockItem(LirothBlocks.DEVASTATED_BRICK_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "devastated_brick_wall"), new BlockItem(LirothBlocks.DEVASTATED_BRICK_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "devastated_bricks"), new BlockItem(LirothBlocks.DEVASTATED_BRICKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "devastated_pillar_block"), new BlockItem(LirothBlocks.DEVASTATED_PILLAR_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "dimensional_communicator"), new BlockItem(LirothBlocks.DIMENSIONAL_COMMUNICATOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "dimensional_communicator_off"), new BlockItem(LirothBlocks.DIMENSIONAL_COMMUNICATOR_OFF, new Item.Settings()));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "dimensional_communicator_on"), new BlockItem(LirothBlocks.DIMENSIONAL_COMMUNICATOR_ON, new Item.Settings()));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "end_liroth_gem_ore"), new BlockItem(LirothBlocks.END_LIROTH_GEM_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "forcefield"), new BlockItem(LirothBlocks.FORCEFIELD, new Item.Settings()));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "fungal_torch"), new WallStandingBlockItem(LirothBlocks.FUNGAL_TORCH, LirothBlocks.WALL_FUNGAL_TORCH, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "fungal_campfire"), new BlockItem(LirothBlocks.FUNGAL_CAMPFIRE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "fungal_lantern"), new BlockItem(LirothBlocks.FUNGAL_LANTERN, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "fungallight"), new BlockItem(LirothBlocks.FUNGAL_LIGHT, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "gateway_block"), new BlockItem(LirothBlocks.GATEWAY_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "gleemstone"), new BlockItem(LirothBlocks.GLEEMSTONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "haunted_throughfare_block"), new BlockItem(LirothBlocks.HAUNTED_THROUGHFARE_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "hilight"), new BlockItem(LirothBlocks.HILIGHT, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "jalsphire_gem_block"), new BlockItem(LirothBlocks.JALSPHIRE_GEM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "jalsphire_ore"), new BlockItem(LirothBlocks.JALSPHIRE_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "jalsphire_stone_ore"), new BlockItem(LirothBlocks.JALSPHIRE_ORE_STONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "jalsphire_trackway"), new BlockItem(LirothBlocks.JALSPHIRE_TRACKWAY, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_chest"), new BlockItem(LirothBlocks.JAPZ_CHEST, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_crafting_table"), new BlockItem(LirothBlocks.JAPZ_CRAFTING_TABLE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_door"), new BlockItem(LirothBlocks.JAPZ_DOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_fence"), new BlockItem(LirothBlocks.JAPZ_FENCE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_leaves"), new BlockItem(LirothBlocks.JAPZ_LEAVES, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_log"), new BlockItem(LirothBlocks.JAPZ_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_wood"), new BlockItem(LirothBlocks.JAPZ_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_planks"), new BlockItem(LirothBlocks.JAPZ_PLANKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_sapling"), new BlockItem(LirothBlocks.JAPZ_SAPLING, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_slab"), new BlockItem(LirothBlocks.JAPZ_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_stairs"), new BlockItem(LirothBlocks.JAPZ_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "japz_trapdoor"), new BlockItem(LirothBlocks.JAPZ_TRAPDOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_chest"), new BlockItem(LirothBlocks.KOOLAW_CHEST, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_crafting_table"), new BlockItem(LirothBlocks.KOOLAW_CRAFTING_TABLE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_door"), new BlockItem(LirothBlocks.KOOLAW_DOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_fence"), new BlockItem(LirothBlocks.KOOLAW_FENCE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_leaves"), new BlockItem(LirothBlocks.KOOLAW_LEAVES, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_log"), new BlockItem(LirothBlocks.KOOLAW_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_wood"), new BlockItem(LirothBlocks.KOOLAW_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_planks"), new BlockItem(LirothBlocks.KOOLAW_PLANKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_sapling"), new BlockItem(LirothBlocks.KOOLAW_SAPLING, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_slab"), new BlockItem(LirothBlocks.KOOLAW_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_stairs"), new BlockItem(LirothBlocks.KOOLAW_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "koolaw_trapdoor"), new BlockItem(LirothBlocks.KOOLAW_TRAPDOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_bone_block"), new BlockItem(LirothBlocks.LIROTH_BONE_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_chest"), new BlockItem(LirothBlocks.LIROTH_CHEST, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_cobblestone"), new BlockItem(LirothBlocks.LIROTH_COBBLESTONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_cobblestone_stairs"), new BlockItem(LirothBlocks.LIROTH_COBBLESTONE_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_cobblestone_wall"), new BlockItem(LirothBlocks.LIROTH_COBBLESTONE_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_cobblestone_slab"), new BlockItem(LirothBlocks.LIROTH_COBBLESTONE_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_crafting_table"), new BlockItem(LirothBlocks.LIROTH_CRAFTING_TABLE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_dirt"), new BlockItem(LirothBlocks.LIROTH_DIRT, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_door"), new BlockItem(LirothBlocks.LIROTH_DOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_end_stone"), new BlockItem(LirothBlocks.LIROTH_END_STONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_fence"), new BlockItem(LirothBlocks.LIROTH_FENCE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_furnace"), new BlockItem(LirothBlocks.LIROTH_FURNACE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_gem_block"), new BlockItem(LirothBlocks.LIROTH_GEM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_gem_ore"), new BlockItem(LirothBlocks.LIROTH_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_glass_block"), new BlockItem(LirothBlocks.LIROTH_GLASS_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_grass"), new BlockItem(LirothBlocks.LIROTH_GRASS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_grass_block"), new BlockItem(LirothBlocks.LIROTH_GRASS_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_grass_path"), new BlockItem(LirothBlocks.LIROTH_PATH_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_farmland"), new BlockItem(LirothBlocks.LIROTH_FARMLAND_BLOCK, new Item.Settings()));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_leaves"), new BlockItem(LirothBlocks.LIROTH_LEAVES, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_log"), new BlockItem(LirothBlocks.LIROTH_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_wood"), new BlockItem(LirothBlocks.LIROTH_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_planks"), new BlockItem(LirothBlocks.LIROTH_PLANKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_rose"), new BlockItem(LirothBlocks.LIROTH_ROSE, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_sapling"), new BlockItem(LirothBlocks.LIROTH_SAPLING, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_slab"), new BlockItem(LirothBlocks.LIROTH_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_soul_sand"), new BlockItem(LirothBlocks.LIROTH_SOUL_SAND, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_stairs"), new BlockItem(LirothBlocks.LIROTH_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_stone"), new BlockItem(LirothBlocks.LIROTH_STONE_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_stone_slab"), new BlockItem(LirothBlocks.LIROTH_STONE_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_stone_stairs"), new BlockItem(LirothBlocks.LIROTH_STONE_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_stone_wall"), new BlockItem(LirothBlocks.LIROTH_STONE_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_stone_bricks"), new BlockItem(LirothBlocks.LIROTH_STONE_BRICKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_stone_brick_slab"), new BlockItem(LirothBlocks.LIROTH_STONE_BRICK_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_stone_brick_stairs"), new BlockItem(LirothBlocks.LIROTH_STONE_BRICK_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_stone_brick_wall"), new BlockItem(LirothBlocks.LIROTH_STONE_BRICK_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_trapdoor"), new BlockItem(LirothBlocks.LIROTH_TRAPDOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_liroth_ore"), new BlockItem(LirothBlocks.LIROTHIAN_LIROTH_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_cobalt_block"), new BlockItem(LirothBlocks.LIROTHIAN_COBALT_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_cobalt_door"), new BlockItem(LirothBlocks.LIROTHIAN_COBALT_DOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_cobalt_ore"), new BlockItem(LirothBlocks.LIROTHIAN_COBALT_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_cobalt_trapdoor"), new BlockItem(LirothBlocks.LIROTHIAN_COBALT_TRAPDOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_petroleum_block"), new BlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_petroleum_ore"), new BlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_petroleum_torch"), new WallStandingBlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_TORCH, LirothBlocks.WALL_LIROTHIAN_PETROLEUM_TORCH, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_petroleum_lantern"), new BlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_LANTERN, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "lirothian_petroleum_campfire"), new BlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_CAMPFIRE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "nether_liroth_gem_ore"), new BlockItem(LirothBlocks.NETHER_LIROTH_GEM_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "olden_liroth_gem_block"), new BlockItem(LirothBlocks.OLDEN_LIROTH_GEM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_crafting_table"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_CRAFTING_TABLE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_chest"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_CHEST, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_brick_slab"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_BRICK_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_brick_stairs"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_BRICK_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_brick_wall"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_BRICK_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_bricks"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_BRICKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_door"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_DOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_log"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_wood"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_planks"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_PLANKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_sapling"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_SAPLING, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_slab"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_stairs"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_trapdoor"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_TRAPDOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_damnation_fence"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_FENCE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_flower"), new BlockItem(LirothBlocks.PETRIFIED_FLOWER, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "pier_dirt"), new BlockItem(LirothBlocks.PIER_DIRT, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "pier_grass_block"), new BlockItem(LirothBlocks.PIER_GRASS_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "pier_farmland"), new BlockItem(LirothBlocks.PIER_FARMLAND_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "pier_grass_path"), new BlockItem(LirothBlocks.PIER_PATH_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "potestium_ore"), new BlockItem(LirothBlocks.POTESTIUM_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "potestium_block"), new BlockItem(LirothBlocks.POTESTIUM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "quantum_diamond_ore"), new BlockItem(LirothBlocks.QUANTUM_DIAMOND_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "quantum_plate_block"), new BlockItem(LirothBlocks.QUANTUM_PLATE_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "redstone_broken_stage_1"), new BlockItem(LirothBlocks.REDSTONE_BROKEN_STAGE_1, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "redstone_broken_stage_2"), new BlockItem(LirothBlocks.REDSTONE_BROKEN_STAGE_2, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "redstone_broken_stage_3"), new BlockItem(LirothBlocks.REDSTONE_BROKEN_STAGE_3, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "raw_lirothian_cobalt_block"), new BlockItem(LirothBlocks.RAW_LIROTHIAN_COBALT_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "ruby_ore"), new BlockItem(LirothBlocks.RUBY_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "ruby_block"), new BlockItem(LirothBlocks.RUBY_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "smooth_blue_sandstone"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "smooth_blue_sandstone_slab"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "smooth_blue_sandstone_stairs"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "smooth_blue_sandstone_wall"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "soul_rod"), new BlockItem(LirothBlocks.SOUL_ROD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//		    Registry.register(Registry.ITEM, new Identifier("liroth", "soulless_flame"), new BlockItem(LirothBlocks.SOULLESS_FLAME, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "soulless_soil"), new BlockItem(LirothBlocks.SOULLESS_SOIL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_crafting_table"), new BlockItem(LirothBlocks.SPICED_CRAFTING_TABLE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_chest"), new BlockItem(LirothBlocks.SPICED_CHEST, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_door"), new BlockItem(LirothBlocks.SPICED_DOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_fence"), new BlockItem(LirothBlocks.SPICED_FENCE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_leaves"), new BlockItem(LirothBlocks.SPICED_LEAVES, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_log"), new BlockItem(LirothBlocks.SPICED_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_wood"), new BlockItem(LirothBlocks.SPICED_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_planks"), new BlockItem(LirothBlocks.SPICED_PLANKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_sapling"), new BlockItem(LirothBlocks.SPICED_SAPLING, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_slab"), new BlockItem(LirothBlocks.SPICED_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_stairs"), new BlockItem(LirothBlocks.SPICED_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spiced_trapdoor"), new BlockItem(LirothBlocks.SPICED_TRAPDOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_ancient_debris"), new BlockItem(LirothBlocks.SPINERIOS_ANCIENT_DEBRIS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_coal_ore"), new BlockItem(LirothBlocks.SPINERIOS_COAL_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_copper_ore"), new BlockItem(LirothBlocks.SPINERIOS_COPPER_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_cobblestone"), new BlockItem(LirothBlocks.SPINERIOS_COBBLESTONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_cobblestone_slab"), new BlockItem(LirothBlocks.SPINERIOS_COBBLESTONE_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_cobblestone_stairs"), new BlockItem(LirothBlocks.SPINERIOS_COBBLESTONE_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_cobblestone_wall"), new BlockItem(LirothBlocks.SPINERIOS_COBBLESTONE_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_diamond_ore"), new BlockItem(LirothBlocks.SPINERIOS_DIAMOND_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_dirt"), new BlockItem(LirothBlocks.SPINERIOS_DIRT, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_emerald_ore"), new BlockItem(LirothBlocks.SPINERIOS_EMERALD_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_furnace"), new BlockItem(LirothBlocks.SPINERIOS_FURNACE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_gold_ore"), new BlockItem(LirothBlocks.SPINERIOS_GOLD_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_grass_block"), new BlockItem(LirothBlocks.SPINERIOS_GRASS_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_farmland"), new BlockItem(LirothBlocks.SPINERIOS_FARMLAND_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_grass_path"), new BlockItem(LirothBlocks.SPINERIOS_PATH_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_iron_ore"), new BlockItem(LirothBlocks.SPINERIOS_IRON_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_lapis_ore"), new BlockItem(LirothBlocks.SPINERIOS_LAPIS_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_liroth_ore"), new BlockItem(LirothBlocks.SPINERIOS_LIROTH_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_quartz_ore"), new BlockItem(LirothBlocks.SPINERIOS_QUARTZ_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_redstone_ore"), new BlockItem(LirothBlocks.SPINERIOS_REDSTONE_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone"), new BlockItem(LirothBlocks.SPINERIOS_STONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone_ore"), new BlockItem(LirothBlocks.SPINERIOS_STONE_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone_slab"), new BlockItem(LirothBlocks.SPINERIOS_STONE_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone_stairs"), new BlockItem(LirothBlocks.SPINERIOS_STONE_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone_wall"), new BlockItem(LirothBlocks.SPINERIOS_STONE_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone_bricks"), new BlockItem(LirothBlocks.SPINERIOS_STONE_BRICKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone_brick_slab"), new BlockItem(LirothBlocks.SPINERIOS_STONE_BRICK_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone_brick_stairs"), new BlockItem(LirothBlocks.SPINERIOS_STONE_BRICK_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone_brick_wall"), new BlockItem(LirothBlocks.SPINERIOS_STONE_BRICK_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_liroth_log"), new BlockItem(LirothBlocks.STRIPPED_LIROTH_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_spiced_log"), new BlockItem(LirothBlocks.STRIPPED_SPICED_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_tallpier_log"), new BlockItem(LirothBlocks.STRIPPED_TALLPIER_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_damnation_log"), new BlockItem(LirothBlocks.STRIPPED_DAMNATION_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_japz_log"), new BlockItem(LirothBlocks.STRIPPED_JAPZ_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_koolaw_log"), new BlockItem(LirothBlocks.STRIPPED_KOOLAW_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_petrified_damnation_log"), new BlockItem(LirothBlocks.STRIPPED_PETRIFIED_DAMNATION_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_liroth_wood"), new BlockItem(LirothBlocks.STRIPPED_LIROTH_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_spiced_wood"), new BlockItem(LirothBlocks.STRIPPED_SPICED_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_tallpier_wood"), new BlockItem(LirothBlocks.STRIPPED_TALLPIER_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_damnation_wood"), new BlockItem(LirothBlocks.STRIPPED_DAMNATION_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_japz_wood"), new BlockItem(LirothBlocks.STRIPPED_JAPZ_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_koolaw_wood"), new BlockItem(LirothBlocks.STRIPPED_KOOLAW_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "stripped_petrified_damnation_wood"), new BlockItem(LirothBlocks.STRIPPED_PETRIFIED_DAMNATION_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));

		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_crafting_table"), new BlockItem(LirothBlocks.TALLPIER_CRAFTING_TABLE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_chest"), new BlockItem(LirothBlocks.TALLPIER_CHEST, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_door"), new BlockItem(LirothBlocks.TALLPIER_DOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_fence"), new BlockItem(LirothBlocks.TALLPIER_FENCE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_leaves"), new BlockItem(LirothBlocks.TALLPIER_LEAVES, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_log"), new BlockItem(LirothBlocks.TALLPIER_LOG, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_wood"), new BlockItem(LirothBlocks.TALLPIER_WOOD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_planks"), new BlockItem(LirothBlocks.TALLPIER_PLANKS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_sapling"), new BlockItem(LirothBlocks.TALLPIER_SAPLING, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_slab"), new BlockItem(LirothBlocks.TALLPIER_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_stairs"), new BlockItem(LirothBlocks.TALLPIER_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tallpier_trapdoor"), new BlockItem(LirothBlocks.TALLPIER_TRAPDOOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "vile_tentacle"), new BlockItem(LirothBlocks.VILE_TENTACLE, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "wilting_liroth_rose"), new BlockItem(LirothBlocks.WILITING_LIROTH_ROSE, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));

		    Registry.register(Registry.ITEM, new Identifier("liroth", "deepslate_tourmaline_ore"), new BlockItem(LirothBlocks.DEEPSLATE_TOURMALINE_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tourmaline_gem_block"), new BlockItem(LirothBlocks.TOURMALINE_GEM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "tourmaline_ore"), new BlockItem(LirothBlocks.TOURMALINE_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_tourmaline_ore"), new BlockItem(LirothBlocks.SPINERIOS_TOURMALINE_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "spinerios_stone_tourmaline_ore"), new BlockItem(LirothBlocks.SPINERIOS_STONE_TOURMALINE_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    
		    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_splitter"), new BlockItem(LirothBlocks.LIROTH_SPLITTER, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "quantum_extractor"), new BlockItem(LirothBlocks.QUANTUM_EXTRACTOR, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "jalsphire_crystal_block"), new BlockItem(LirothBlocks.JALSPHIRE_CRYSTAL_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    Registry.register(Registry.ITEM, new Identifier("liroth", "pointed_jalsphire_crystal"), new BlockItem(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
		    
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "fungal_fiend_spawn_egg"), FUNGAL_FIEND_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "forsaken_corpse_spawn_egg"), FORSAKEN_CORPSE_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "skeletal_freak_spawn_egg"), SKELETAL_FREAK_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "warp_spawn_egg"), WARP_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "soul_arachnid_spawn_egg"), SOUL_ARACHNID_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "pier_peep_spawn_egg"), PIER_PEEP_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "shade_spawn_egg"), SHADE_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "prowler_spawn_egg"), PROWLER_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "freakshow_spawn_egg"), FREAKSHOW_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "vile_shark_spawn_egg"), VILE_SHARK_SPAWN_EGG);
			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "lirothian_mimic_spawn_egg"), LIROTHIAN_MIMIC_SPAWN_EGG);
//			Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "butterfly_spawn_egg"), BUTTERFLY_SPAWN_EGG);
			
			EntityRendererRegistry.INSTANCE.register(Liroth.BEAM_LASER_PROJECTILE_ENTITY, (context) ->
				new FlyingItemEntityRenderer(context));
			LirothFluidRenderingModClient.receiveEntityPacket();

	        Registry.register(Registry.SOUND_EVENT, this.LIROTH_BLASTER_FIRING_SOUND_ID, LIROTH_BLASTER_FIRING_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.FUNGAL_FIEND_DEATH_SOUND_ID, FUNGAL_FIEND_DEATH_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.FUNGAL_FIEND_HURT_SOUND_ID, FUNGAL_FIEND_HURT_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.FUNGAL_FIEND_FUSE_SOUND_ID, FUNGAL_FIEND_FUSE_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.WARP_DEATH_SOUND_ID, WARP_DEATH_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.WARP_HURT_SOUND_ID, WARP_HURT_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.WARP_IDLE_SOUND_ID, WARP_IDLE_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.SHADE_DEATH_SOUND_ID, SHADE_DEATH_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.SHADE_HURT_SOUND_ID, SHADE_HURT_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.SHADE_IDLE_SOUND_ID, SHADE_IDLE_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.LIROTH_BIOME_MUSIC_SOUND_ID, LIROTH_BIOME_MUSIC_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.TALLPIER_BIOME_MUSIC_SOUND_ID, TALLPIER_BIOME_MUSIC_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.SPICED_DESERT_MUSIC_SOUND_ID, SPICED_DESERT_MUSIC_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.DAMNATION_MUSIC_SOUND_ID, DAMNATION_MUSIC_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.ESCAPE_MUSIC_SOUND_ID, ESCAPE_MUSIC_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.JALSPHIRE_MUSIC_SOUND_ID, JALSPHIRE_MUSIC_SOUND_EVENT);
	        Registry.register(Registry.SOUND_EVENT, this.DESOLATE_MUSIC_SOUND_ID, DESOLATE_MUSIC_SOUND_EVENT);
	        
		    
	/*        Registry.register(Registry.BLOCK, new Identifier("liroth", "liroth_dimension_portal"), LIROTH_DIMENSION_PORTAL);
			Registry.register(Registry.BLOCK, id("dimensional_communicator"), DIMENSIONAL_COMMUNICATOR);
			Registry.register(Registry.ITEM, id("dimensional_communicator"), DIMENSIONAL_COMMUNICATOR_ITEM);
			Registry.register(Registry.BLOCK_ENTITY_TYPE, id("dimensional_communicator"), DIMENSIONAL_COMMUNICATOR_ENTITY);*/
		    
	        LirothRenders.renderCutOuts(blockRenderTypeMap -> ItemBlockRenderTypeAccess.getTypeByBlock().putAll(blockRenderTypeMap));
		    LirothRegistries.registerItems();
		    LirothRegistries.registerFuels();
	        Liroth.threadSafeLoadFinish();

			LOGGER.info("Liroth is Loading...");
			
			LIROTH_FLUID_STILL = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "liroth_fluid_still"), new LirothFluid.Still());
			LIROTH_FLUID_FLOWING = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "liroth_fluid_flowing"), new LirothFluid.Flowing());
			LIROTH_FLUID_BUCKET = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "liroth_fluid_bucket"), 
		        new BucketItem(LIROTH_FLUID_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(LirothCreativeTab.creativeItemsTab)));
			LIROTH_FLUID = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "liroth_fluid"), new FluidBlock(LIROTH_FLUID_STILL, AbstractBlock.Settings.copy(Blocks.WATER)){});
					
			MOLTEN_SPINERIOS_STILL = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "molten_spinerios_still"), new MoltenSpinerios.Still());
			MOLTEN_SPINERIOS_FLOWING = Registry.register(Registry.FLUID, new Identifier(MOD_ID, "molten_spinerios_flowing"), new MoltenSpinerios.Flowing());
			MOLTEN_SPINERIOS_BUCKET = Registry.register(Registry.ITEM, new Identifier(MOD_ID, "molten_spinerios_bucket"), 
		        new BucketItem(MOLTEN_SPINERIOS_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(LirothCreativeTab.creativeItemsTab)));
			MOLTEN_SPINERIOS = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "molten_spinerios"), new SchluckedFluidBlock(MOLTEN_SPINERIOS_STILL, AbstractBlock.Settings.copy(Blocks.LAVA)){});
		
			FluidRenderHandlerRegistry.INSTANCE.register(Liroth.LIROTH_FLUID_STILL, Liroth.LIROTH_FLUID_FLOWING, new SimpleFluidRenderHandler(
					new Identifier("liroth:blocks/liroth_fluid_still"),
					new Identifier("liroth:blocks/liroth_fluid_flowing")
			));
			
			BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), Liroth.LIROTH_FLUID_STILL, Liroth.LIROTH_FLUID_FLOWING);

			
			FluidRenderHandlerRegistry.INSTANCE.register(Liroth.MOLTEN_SPINERIOS_STILL, Liroth.MOLTEN_SPINERIOS_FLOWING, new SimpleFluidRenderHandler(
					new Identifier("liroth:blocks/molten_spinerios_still"),
					new Identifier("liroth:blocks/molten_spinerios_flowing")
			));
			
			ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
				registry.register(new Identifier("liroth:blocks/liroth_fluid_still"));
				registry.register(new Identifier("liroth:blocks/liroth_fluid_flowing"));
				registry.register(new Identifier("liroth:blocks/molten_spinerios_still"));
				registry.register(new Identifier("liroth:blocks/molten_spinerios_flowing"));
			});
			
	        ScreenRegistry.register(LIROTH_SPLITTER_SCREEN_HANDLER, LirothSplitterScreen::new);
	        ScreenRegistry.register(QUANTUM_EXTRACTOR_SCREEN_HANDLER, QuantumExtractorScreen::new);
					
			CustomPortalBuilder.beginPortal()  
		    .frameBlock(LirothBlocks.DIMENSIONAL_COMMUNICATOR)
	        .customPortalBlock(LirothBlocks.LIROTH_DIMENSION_PORTAL)
		    .destDimID(new Identifier("liroth:liroth_dimension"))  
		    .tintColor(33, 0, 33)
		    .flatPortal()
		    .registerPortal();
			
			CustomPortalBuilder.beginPortal()  
		    .frameBlock(LirothBlocks.CHARRED_ACCESSWAY_BLOCK)
	        .customPortalBlock(LirothBlocks.DAMNATION_DIMENSION_PORTAL)
		    .destDimID(new Identifier("liroth:damnation"))  
		    .tintColor(38, 0, 9)
		    .flatPortal()
		    .registerPortal();
			
			CustomPortalBuilder.beginPortal()  
		    .frameBlock(LirothBlocks.DAMNED_PASSAGEWAY)
	        .customPortalBlock(LirothBlocks.JANTIRO_DIMENSION_PORTAL)
		    .destDimID(new Identifier("liroth:jantiros_escape_dimension"))  
		    .tintColor(0, 38, 38)
		    .flatPortal()
		    .registerPortal();
			
			CustomPortalBuilder.beginPortal()  
		    .frameBlock(LirothBlocks.HAUNTED_THROUGHFARE_BLOCK)
	        .customPortalBlock(LirothBlocks.JALSPHIRE_DIMENSION_PORTAL)
		    .destDimID(new Identifier("liroth:jalsphire_plains"))  
		    .tintColor(0, 0, 38)
		    .flatPortal()
		    .registerPortal();
			
			CustomPortalBuilder.beginPortal()  
		    .frameBlock(LirothBlocks.JALSPHIRE_TRACKWAY)
	        .customPortalBlock(LirothBlocks.DEVASTATED_DIMENSION_PORTAL)
		    .destDimID(new Identifier("liroth:devastated_plains"))  
		    .tintColor(38, 31, 0)
		    .flatPortal()
		    .registerPortal();
		
		}
		
	    public static class LirothRegistries {
	        public static void registerBlocks() {
	        	Liroth.LOGGER.debug("Liroth: Registering blocks...");
	        	LirothBlocks.init();
	    		BlockStateModelGenerator blockStateModelGenerator = new BlockStateModelGenerator(null, null, null);
				blockStateModelGenerator.registerTorch(LirothBlocks.FUNGAL_TORCH, LirothBlocks.WALL_FUNGAL_TORCH);
	            Liroth.LOGGER.info("Liroth: Blocks registered!");
	        }
	    	
	        public static void registerItems() {
	        	Liroth.LOGGER.debug("Liroth: Registering items...");
	        	LirothItems.init();
	            Liroth.LOGGER.info("Liroth: Items registered!");
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
	        LOGGER.debug("Liroth: \"Load Complete Event\" Starting...");
	        LirothStrippables.strippableLogsLiroth();
	        LirothHoeables.tillablesLiroth();
	        LirothFlattenables.addFlatfuckfridayevent();
	        LOGGER.info("Liroth: \"Load Complete\" Event Complete!");
	    }
}
