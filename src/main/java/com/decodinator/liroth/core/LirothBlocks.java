package com.decodinator.liroth.core;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.BlockPileFeatureConfig;
import ru.bclib.blocks.BaseChestBlock;
import ru.bclib.blocks.BaseFurnaceBlock;
import ru.bclib.blocks.BasePathBlock;
import ru.bclib.registry.BaseBlockEntities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.blocks.CustomAzaleaBlock;
import com.decodinator.liroth.core.blocks.CustomCampfireBlock;
import com.decodinator.liroth.core.blocks.CustomCaveVinesBodyBlock;
import com.decodinator.liroth.core.blocks.CustomCaveVinesHeadBlock;
import com.decodinator.liroth.core.blocks.CustomCraftingTable;
import com.decodinator.liroth.core.blocks.CustomDeadWaterPlant;
import com.decodinator.liroth.core.blocks.CustomFungalPlant;
import com.decodinator.liroth.core.blocks.CustomFurnace;
import com.decodinator.liroth.core.blocks.CustomKelpBlock;
import com.decodinator.liroth.core.blocks.CustomKelpPlantBlock;
import com.decodinator.liroth.core.blocks.CustomPane;
import com.decodinator.liroth.core.blocks.CustomPortalFrameBlock;
import com.decodinator.liroth.core.blocks.CustomRod;
import com.decodinator.liroth.core.blocks.CustomSapling;
import com.decodinator.liroth.core.blocks.CustomTorch;
import com.decodinator.liroth.core.blocks.CustomWallTorch;
import com.decodinator.liroth.core.blocks.CustomWartBlock;
import com.decodinator.liroth.core.blocks.CustomWaterPlant;
import com.decodinator.liroth.core.blocks.CustomWeepingVinesBlock;
import com.decodinator.liroth.core.blocks.CustomWeepingVinesPlantBlock;
import com.decodinator.liroth.core.blocks.EnemyChestBlock;
import com.decodinator.liroth.core.blocks.FungalCampfireBlock;
import com.decodinator.liroth.core.blocks.LirothFarmlandBlock;
import com.decodinator.liroth.core.blocks.LirothGrassBlock;
import com.decodinator.liroth.core.blocks.LirothPathBlock;
import com.decodinator.liroth.core.blocks.LirothPortalBlock;
import com.decodinator.liroth.core.blocks.LirothSplitterBlock;
import com.decodinator.liroth.core.blocks.LirothianPetroleumCampfireBlock;
import com.decodinator.liroth.core.blocks.LockBlock;
import com.decodinator.liroth.core.blocks.PetrifiedCaveVinesBodyBlock;
import com.decodinator.liroth.core.blocks.PetrifiedCaveVinesHeadBlock;
import com.decodinator.liroth.core.blocks.PierFarmlandBlock;
import com.decodinator.liroth.core.blocks.PierGrassBlock;
import com.decodinator.liroth.core.blocks.PierPathBlock;
import com.decodinator.liroth.core.blocks.PointedJalsphireCrystal;
import com.decodinator.liroth.core.blocks.PointedPetrifiedCrystal;
import com.decodinator.liroth.core.blocks.QuantumExtractorBlock;
import com.decodinator.liroth.core.blocks.SpineriosFarmlandBlock;
import com.decodinator.liroth.core.blocks.SpineriosGrassBlock;
import com.decodinator.liroth.core.blocks.SpineriosPathBlock;
import com.decodinator.liroth.core.world.trees.DamnationTree;
import com.decodinator.liroth.core.world.trees.JapzTree;
import com.decodinator.liroth.core.world.trees.KoolawTree;
import com.decodinator.liroth.core.world.trees.LirothTree;
import com.decodinator.liroth.core.world.trees.PetrifiedDamnationTree;
import com.decodinator.liroth.core.world.trees.SpicedTree;
import com.decodinator.liroth.core.world.trees.TallpierTree;
import com.decodinator.liroth.mixin.access.DoorBlockAccess;
import com.decodinator.liroth.mixin.access.PressurePlateBlockAccess;
import com.decodinator.liroth.mixin.access.StairBlockAccess;
import com.decodinator.liroth.mixin.access.TrapDoorBlockAccess;
import com.decodinator.liroth.mixin.access.WoodButtonBlockAccess;

@SuppressWarnings("deprecation")
public class LirothBlocks {
    public static List<Block> BLOCKS = new ArrayList<>();
    
    public static List<Block> flowerPotBlocks = new ArrayList<>();
    public static List<Identifier> flowerIDs = new ArrayList<>();
    
    public static final Block ANOMALY = createAnomalyBlock("anomaly");
    public static final Block ANOMALY_BLOCK = createMetalBlock("anomaly_block");
    public static final Block BLUE_SAND = createSand(0, "blue_sand");
    public static final Block BLUE_SANDSTONE = createStone("blue_sandstone");
    public static final Block BLUE_SANDSTONE_SLAB = createStoneSlab("blue_sandstone_slab");
    public static final Block BLUE_SANDSTONE_STAIRS = createStoneStairs("blue_sandstone_stairs");
    public static final Block BLUE_SANDSTONE_WALL = createStoneWall("blue_sandstone_wall");
    public static final Block CARVED_BLUE_SANDSTONE = createStone("carved_blue_sandstone");
    public static final Block CHARRED_ACCESSWAY_BLOCK = createStone("charred_accessway_block");
    public static final Block CHARRED_LIROTH_COBBLESTONE = createStone("charred_liroth_cobblestone");
    public static final Block CHARRED_LIROTH_COBBLESTONE_WALL = createStoneWall("charred_liroth_cobblestone_wall");
    public static final Block CHARRED_LIROTH_COBBLESTONE_STAIRS = createStoneStairs("charred_liroth_cobblestone_stairs");
    public static final Block CHARRED_LIROTH_COBBLESTONE_SLAB = createStoneSlab("charred_liroth_cobblestone_slab");
    public static final Block CHARRED_LIROTH_GEM_ORE = createOre("charred_lirothian_liroth_gem_ore");
    public static final Block CHARRED_LIROTH_STONE_BLOCK = createStone("charred_liroth_stone");
    public static final Block CHARRED_LIROTH_STONE_WALL = createStoneWall("charred_liroth_stone_wall");
    public static final Block CHARRED_LIROTH_STONE_STAIRS = createStoneStairs("charred_liroth_stone_stairs");
    public static final Block CHARRED_LIROTH_STONE_SLAB = createStoneSlab("charred_liroth_stone_slab");
    public static final Block CHARRED_LIROTH_STONE_BRICKS = createStone("charred_liroth_stone_bricks");
    public static final Block CHARRED_LIROTH_STONE_BRICK_LOCK = createLockBlock("charred_liroth_stone_brick_lock");
    public static final Block CHARRED_LIROTH_STONE_BRICK_WALL = createStoneWall("charred_liroth_stone_brick_wall");
    public static final Block CHARRED_LIROTH_STONE_BRICK_STAIRS = createStoneStairs("charred_liroth_stone_brick_stairs");
    public static final Block CHARRED_LIROTH_STONE_BRICK_SLAB = createStoneSlab("charred_liroth_stone_brick_slab");
    public static final Block CHISELED_DEVASTATED_BRICKS = createStone("chiseled_devastated_bricks");
//    public static final Block CORRUPTED_BREWING_STAND = createBrewingStand("corrupted_brewing_stand");
//    public static final Block CORRUPTED_JALSPHIRE_GEM_BLOCK = createMetalBlock("corrupted_jalsphire_gem_block");
//    public static final Block CORRUPTED_JALSPHIRE_ORE = createOre("corrupted_jalsphire_ore");
//    public static final Block CORRUPTED_LIROTH_GEM_BLOCK = createPillarMetalBlock("corrupted_liroth_gem_block");
//    public static final Block CORRUPTED_LIROTH_GEM_ORE = createOre("corrupted_liroth_gem_ore");
    public static final Block DAMNATION_CRAFTING_TABLE = createCraftingTable("damnation_crafting_table");
    public static final Block DAMNATION_CHEST = createChest("damnation_chest");
    public static final Block DAMNATION_FENCE = createFence("damnation_fence");
    public static final Block DAMNATION_FUNGAL_CLUSTER = createFungusClusterPlant("damnation_fungal_cluster");
    public static final Block DAMNATION_FUNGUS = createFungusPlant("damnation_fungus");
    public static final Block DAMNATION_FUNGAL_CARPET = createMossCarpet("damnation_fungal_carpet");
    public static final Block DAMNATION_FUNGAL_HEAP = createFungalGrass("damnation_fungal_heap");
    public static final Block DAMNATION_FUNGAL_PATCH = createFungalGrass("damnation_fungal_patch");
    public static final Block DAMNATION_FUNGAL_FUSS = createFungalGrass("damnation_fungal_fuss");
    public static final Block DAMNATION_LEAVES = createLeaves("damnation_leaves");
    public static final Block DAMNATION_LOG = createDamnationLog("damnation_log");
    public static final Block DAMNATION_PLANKS = createPlanks("damnation_planks");
    public static final LirothPortalBlock DAMNATION_DIMENSION_PORTAL = createLirothPortal("damnation_portal");
    public static final Block DAMNATION_SOIL = createDamnationSoil("damnation_soil");
    public static final Block DAMNATION_DOOR = createDoor("damnation_door");
    public static final Block DAMNATION_SLAB = createWoodSlab("damnation_slab");
    public static final Block DAMNATION_STAIRS = createWoodStairs("damnation_stairs");
    public static final Block DAMNATION_TRAPDOOR = createTrapDoor("damnation_trapdoor");
    public static final Block DAMNATION_WART_BLOCK = createWartBlock("damnation_wart_block");
    public static final Block DAMNATION_WOOD = createWood("damnation_wood");
    public static final Block DAMNATION_VINES = createWeepingVinesHead("damnation_vines");
    public static final Block DAMNATION_VINES_PLANT = createWeepingVinesBody("damnation_vines_plant");
    public static final Block DAMNED_PASSAGEWAY = createStone("damned_passageway");
    public static final Block DEAD_SEA_EYE = createDeadWaterPlant("dead_sea_eye");
    public static final Block DEEPSLATE_LIROTH_ORE = createDeepslateOre("deepslate_liroth_gem_ore");
    public static final Block DEEPSLATE_TOURMALINE_ORE = createMetalBlock("deepslate_tourmaline_ore");
    public static final Block DEVASTATED_BRICKS = createStone("devastated_bricks");
    public static final Block DEVASTATED_BRICK_SLAB = createStoneSlab("devastated_brick_slab");
    public static final Block DEVASTATED_BRICK_STAIRS = createStoneStairs("devastated_brick_stairs");
    public static final Block DEVASTATED_BRICK_WALL = createStoneWall("devastated_brick_wall");
    public static final Block DEVASTATED_PILLAR_BLOCK = createPillarBlock("devastated_pillar_block");
    public static final LirothPortalBlock DEVASTATED_DIMENSION_PORTAL = createLirothPortal("devastated_plains_portal");
    public static final Block DIMENSIONAL_COMMUNICATOR = createPortalFrame("dimensional_communicator");
    public static final Block DIMENSIONAL_COMMUNICATOR_OFF = createMetalBlock("dimensional_communicator_off");
    public static final Block DIMENSIONAL_COMMUNICATOR_ON = createMetalBlock("dimensional_communicator_on");
    public static final Block END_LIROTH_GEM_ORE = createOre("end_liroth_gem_ore");
    public static final Block FORCEFIELD = createForcefieldPane("forcefield");
    public static final Block FUNGAL_CAMPFIRE = createCampfire("fungal_campfire");
    public static final Block FUNGAL_LANTERN = createLantern("fungal_lantern");
    public static final Block FUNGAL_TORCH = createTorch("fungal_torch");
    public static final Block FUNGAL_LIGHT = createShroomlightBlock("fungallight");
    public static final Block GATEWAY_BLOCK = createObsidianBlock("gateway_block");
    public static final Block GLEEMSTONE = createGleemStone("gleemstone");
    public static final Block HAUNTED_THROUGHFARE_BLOCK = createMetalBlock("haunted_throughfare_block");
    public static final Block HILIGHT = createShroomlightBlock("hilight");
    public static final Block JALSPHIRE_CRYSTAL_BLOCK = createCrystalBlock("jalsphire_crystal_block");
    public static final Block JALSPHIRE_ORE = createDirtOre("jalsphire_ore");
    public static final LirothPortalBlock JALSPHIRE_DIMENSION_PORTAL = createLirothPortal("jalsphire_plains_dimension_portal");
    public static final Block JALSPHIRE_GEM_BLOCK = createMetalBlock("jalsphire_gem_block");
    public static final Block JALSPHIRE_ORE_STONE = createOre("jalsphire_stone_ore");
    public static final Block JALSPHIRE_TRACKWAY = createStone("jalsphire_trackway");
    public static final LirothPortalBlock JANTIRO_DIMENSION_PORTAL = createLirothPortal("jantiro_escape_dimension_portal");
    public static final Block JAPZ_BLOSSOM = createSporeBlossom("japz_blossom");
    public static final Block JAPZ_CHEST = createChest("japz_chest");
    public static final Block JAPZ_CRAFTING_TABLE = createCraftingTable("japz_crafting_table");
    public static final Block JAPZ_FENCE = createFence("japz_fence");
    public static final Block JAPZ_LEAVES = createLeaves("japz_leaves");
    public static final Block JAPZ_LOG = createLog("japz_log");
    public static final Block JAPZ_MINI_TREE = createAzalea("japz_mini_tree");
    public static final Block JAPZ_MOSS = createMoss("japz_moss_block");
    public static final Block JAPZ_MOSS_CARPET = createMossCarpet("japz_moss_carpet");
    public static final Block JAPZ_PLANKS = createPlanks("japz_planks");
    public static final Block JAPZ_STAIRS = createWoodStairs("japz_stairs");
    public static final Block JAPZ_DOOR = createDoor("japz_door");
    public static final Block JAPZ_SLAB = createWoodSlab("japz_slab");
    public static final Block JAPZ_TRAPDOOR = createTrapDoor("japz_trapdoor");
    public static final Block JAPZ_VINES = createCaveVinesHead("japz_vines");
    public static final Block JAPZ_VINES_PLANT = createCaveVinesBody("japz_vines_plant");
    public static final Block JAPZ_WOOD = createWood("japz_wood");
    public static final Block KOOLAW_CHEST = createChest("koolaw_chest");
    public static final Block KOOLAW_CRAFTING_TABLE = createCraftingTable("koolaw_crafting_table");
    public static final Block KOOLAW_FENCE = createFence("koolaw_fence");
    public static final Block KOOLAW_LEAVES = createLeaves("koolaw_leaves");
    public static final Block KOOLAW_LOG = createLog("koolaw_log");
    public static final Block KOOLAW_PLANKS = createPlanks("koolaw_planks");
    public static final Block KOOLAW_STAIRS = createWoodStairs("koolaw_stairs");
    public static final Block KOOLAW_DOOR = createDoor("koolaw_door");
    public static final Block KOOLAW_SLAB = createWoodSlab("koolaw_slab");
    public static final Block KOOLAW_TRAPDOOR = createTrapDoor("koolaw_trapdoor");
    public static final Block KOOLAW_WOOD = createWood("koolaw_wood");
    public static final Block NETHER_LIROTH_GEM_ORE = createOre("nether_liroth_gem_ore");
    public static final Block LIROTH_BONE_BLOCK = createBoneBlock("liroth_bone_block");
    public static final Block LIROTH_CHEST = createChest("liroth_chest");
    public static final Block LIROTH_COBBLESTONE = createStone("liroth_cobblestone");
    public static final Block LIROTH_COBBLESTONE_WALL = createStoneWall("liroth_cobblestone_wall");
    public static final Block LIROTH_COBBLESTONE_STAIRS = createStoneStairs("liroth_cobblestone_stairs");
    public static final Block LIROTH_COBBLESTONE_SLAB = createStoneSlab("liroth_cobblestone_slab");
    public static final Block LIROTH_CRAFTING_TABLE = createCraftingTable("liroth_crafting_table");
    public static final Block LIROTH_DIRT = createDirt("liroth_dirt");
//    public static final Block LIROTH_END_STONE = createStone("liroth_end_stone");
    public static final Block LIROTH_FURNACE = createFurnace("liroth_furnace");
    public static final Block LIROTH_GEM_BLOCK = createPillarMetalBlock("liroth_gem_block");
    public static final Block LIROTH_GLASS_BLOCK = createGlassBlock("liroth_glass_block");
    public static final Block LIROTH_GRASS = createGrass("liroth_grass");
    public static final Block LIROTH_GRASS_BLOCK = createLirothGrassBlock("liroth_grass_block");
    public static final Block LIROTH_FARMLAND_BLOCK = createLirothFarmlandBlock("liroth_farmland");
    public static final Block LIROTH_PATH_BLOCK = createLirothPathBlock("liroth_grass_path");
    public static final Block LIROTH_LEAVES = createLeaves("liroth_leaves");
    public static final Block LIROTH_LOG = createLog("liroth_log");
    public static final Block LIROTHIAN_LIROTH_ORE = createOre("lirothian_liroth_ore");
    public static final Block LIROTH_ORE = createOre("liroth_gem_ore");
    public static final Block LIROTH_PLANKS = createPlanks("liroth_planks");
    public static final LirothPortalBlock LIROTH_DIMENSION_PORTAL = createLirothPortal("liroth_dimension_portal");
    public static final Block LIROTH_ROSE = createFlower("liroth_rose");
    public static final Block LIROTH_SOUL_SAND = createLirothSoulSand("liroth_soul_sand");
    public static final Block LIROTH_STONE_BLOCK = createStone("liroth_stone");
    public static final Block LIROTH_STONE_WALL = createStoneWall("liroth_stone_wall");
    public static final Block LIROTH_STONE_STAIRS = createStoneStairs("liroth_stone_stairs");
    public static final Block LIROTH_STONE_SLAB = createStoneSlab("liroth_stone_slab");
    public static final Block LIROTH_STONE_BRICKS = createStone("liroth_stone_bricks");
    public static final Block LIROTH_STONE_BRICK_WALL = createStoneWall("liroth_stone_brick_wall");
    public static final Block LIROTH_STONE_BRICK_STAIRS = createStoneStairs("liroth_stone_brick_stairs");
    public static final Block LIROTH_STONE_BRICK_SLAB = createStoneSlab("liroth_stone_brick_slab");
    public static final Block LIROTH_DOOR = createDoor("liroth_door");
    public static final Block LIROTH_FENCE = createFence("liroth_fence");
    public static final Block LIROTH_SLAB = createWoodSlab("liroth_slab");
    public static final Block LIROTH_STAIRS = createWoodStairs("liroth_stairs");
    public static final Block LIROTH_TRAPDOOR = createTrapDoor("liroth_trapdoor");
    public static final Block LIROTH_WOOD = createWood("liroth_wood");
    public static final Block LIROTHIAN_COBALT_BLOCK = createMetalBlock("lirothian_cobalt_block");
    public static final Block LIROTHIAN_COBALT_DOOR = createMetalDoor("lirothian_cobalt_door");
    public static final Block LIROTHIAN_COBALT_ORE = createOre("lirothian_cobalt_ore");
    public static final Block LIROTHIAN_COBALT_TRAPDOOR = createMetalTrapDoor("lirothian_cobalt_trapdoor");
    public static final Block LIROTHIAN_PETROLEUM_BLOCK = createCoalBlock("lirothian_petroleum_block");
    public static final Block LIROTHIAN_PETROLEUM_ORE = createOre("lirothian_petroleum_ore");
    public static final Block LIROTHIAN_PETROLEUM_TORCH = createPetroleumTorch("lirothian_petroleum_torch");
    public static final Block LIROTHIAN_PETROLEUM_LANTERN = createLantern("lirothian_petroleum_lantern");
    public static final Block LIROTHIAN_PETROLEUM_CAMPFIRE = createLirothianPetroleumCampfire("lirothian_petroleum_campfire");
    public static final Block OLDEN_LIROTH_GEM_BLOCK = createPillarMetalBlock("olden_liroth_gem_block");
    public static final Block PETRIFIED_DAMNATION_CRAFTING_TABLE = createCraftingTable("petrified_damnation_crafting_table");
    public static final Block PETRIFIED_DAMNATION_CHEST = createChest("petrified_damnation_chest");
    public static final Block PETRIFIED_DAMNATION_LOG = createLog("petrified_damnation_log");
    public static final Block PETRIFIED_DAMNATION_BRICKS = createStone("petrified_damnation_bricks");
    public static final Block PETRIFIED_DAMNATION_BRICK_STAIRS = createStoneStairs("petrified_damnation_brick_stairs");
    public static final Block PETRIFIED_DAMNATION_BRICK_SLAB = createStoneSlab("petrified_damnation_brick_slab");
    public static final Block PETRIFIED_DAMNATION_BRICK_WALL = createStoneWall("petrified_damnation_brick_wall");
    public static final Block PETRIFIED_DAMNATION_DOOR = createDoor("petrified_damnation_door");
    public static final Block PETRIFIED_DAMNATION_PLANKS = createPlanks("petrified_damnation_planks");
    public static final Block PETRIFIED_DAMNATION_STAIRS = createWoodStairs("petrified_damnation_stairs");
    public static final Block PETRIFIED_DAMNATION_SLAB = createWoodSlab("petrified_damnation_slab");
    public static final Block PETRIFIED_DAMNATION_TRAPDOOR = createTrapDoor("petrified_damnation_trapdoor");
    public static final Block PETRIFIED_DAMNATION_FENCE = createFence("petrified_damnation_fence");
    public static final Block PETRIFIED_DAMNATION_WOOD = createWood("petrified_damnation_wood");
    public static final Block PETRIFIED_CRYSTAL_BLOCK = createCrystalBlock("petrified_crystal_block");
    public static final Block PETRIFIED_MOSS_BLOCK = createMoss("petrified_moss_block");
    public static final Block PETRIFIED_MOSS_CARPET = createMossCarpet("petrified_moss_carpet");
    public static final Block PETRIFIED_VINES = createPetrifiedCaveVinesHead("petrified_vines");
    public static final Block PETRIFIED_VINES_PLANT = createPetrifiedCaveVinesBody("petrified_vines_plant");
//    public static final Block PETRIFIED_PLANT = createPetrifiedPlant("petrified_plant");
//    public static final Block PETRIFIED_FLOWER = createPetrifiedFlower("petrified_flower");
    public static final Block PIER_DIRT = createDirt("pier_dirt");
    public static final Block PIER_GRASS_BLOCK = createPierGrassBlock("pier_grass_block");
    public static final Block PIER_FARMLAND_BLOCK = createPierFarmlandBlock("pier_farmland");
    public static final Block PIER_PATH_BLOCK = createPierPathBlock("pier_grass_path");
    public static final Block POINTED_JALSPHIRE_CRYSTAL = createPointedCrystal("pointed_jalsphire_crystal");
    public static final Block POINTED_PETRIFIED_CRYSTAL = createPointedPetrifiedCrystal("pointed_petrified_crystal");
    public static final Block POTESTIUM_ORE = createSoilOre("potestium_ore");
    public static final Block POTESTIUM_BLOCK = createMetalBlock("potestium_block");
//    public static final Block REDSTONE_BROKEN_STAGE_1 = createMetalBlock("redstone_broken_stage_1");
//    public static final Block REDSTONE_BROKEN_STAGE_2 = createMetalBlock("redstone_broken_stage_2");
//    public static final Block REDSTONE_BROKEN_STAGE_3 = createMetalBlock("redstone_broken_stage_3");
    public static final Block RAW_LIROTHIAN_COBALT_BLOCK = createMetalBlock("raw_lirothian_cobalt_block");
    public static final Block RUBY_ORE = createSoilOre("ruby_ore");
    public static final Block RUBY_BLOCK = createMetalBlock("ruby_block");
    public static final Block QUANTUM_DIAMOND_ORE = createSoilOre("quantum_diamond_ore");
    public static final Block QUANTUM_PLATE_BLOCK = createMetalBlock("quantum_plate_block");
    public static final Block SEA_EYE = createWaterPlant("sea_eye");
    public static final Block SMOOTH_BLUE_SANDSTONE = createStone("smooth_blue_sandstone");
    public static final Block SMOOTH_BLUE_SANDSTONE_SLAB = createStoneSlab("smooth_blue_sandstone_slab");
    public static final Block SMOOTH_BLUE_SANDSTONE_STAIRS = createStoneStairs("smooth_blue_sandstone_stairs");
    public static final Block SMOOTH_BLUE_SANDSTONE_WALL = createStoneWall("smooth_blue_sandstone_wall");
//    public static final Block SOULLESS_FLAME = createFireBlock("soulless_flame");
    public static final Block SOULLESS_SOIL = createSoullessSoil("soulless_soil");
    public static final Block SOUL_ROD = createRod("soul_rod");
    public static final Block SPICED_CRAFTING_TABLE = createCraftingTable("spiced_crafting_table");
    public static final Block SPICED_CHEST = createChest("spiced_chest");
    public static final Block SPICED_LEAVES = createLeaves("spiced_leaves");
    public static final Block SPICED_LOG = createLog("spiced_log");
    public static final Block SPICED_PLANKS = createPlanks("spiced_planks");
    public static final Block SPICED_DOOR = createDoor("spiced_door");
    public static final Block SPICED_FENCE = createFence("spiced_fence");
    public static final Block SPICED_SLAB = createWoodSlab("spiced_slab");
    public static final Block SPICED_STAIRS = createWoodStairs("spiced_stairs");
    public static final Block SPICED_TRAPDOOR = createTrapDoor("spiced_trapdoor");
    public static final Block SPICED_WOOD = createWood("spiced_wood");
    public static final Block SPINERIOS_COAL_ORE = createDirtOre("spinerios_coal_ore");
    public static final Block SPINERIOS_COBBLESTONE = createStone("spinerios_cobblestone");
    public static final Block SPINERIOS_COBBLESTONE_WALL = createStoneWall("spinerios_cobblestone_wall");
    public static final Block SPINERIOS_COBBLESTONE_SLAB = createStoneSlab("spinerios_cobblestone_slab");
    public static final Block SPINERIOS_COBBLESTONE_STAIRS = createStoneStairs("spinerios_cobblestone_stairs");
    public static final Block SPINERIOS_COPPER_ORE = createDirtOre("spinerios_copper_ore");
    public static final Block SPINERIOS_DIAMOND_ORE = createDirtOre("spinerios_diamond_ore");
    public static final Block SPINERIOS_DIRT = createDirt("spinerios_dirt");
    public static final Block SPINERIOS_EMERALD_ORE = createDirtOre("spinerios_emerald_ore");
    public static final Block SPINERIOS_FURNACE = createFurnace("spinerios_furnace");
    public static final Block SPINERIOS_GOLD_ORE = createDirtOre("spinerios_gold_ore");
    public static final Block SPINERIOS_GRASS_BLOCK = createSpineriosGrassBlock("spinerios_grass_block");
    public static final Block SPINERIOS_FARMLAND_BLOCK = createSpineriosFarmlandBlock("spinerios_farmland");
    public static final Block SPINERIOS_PATH_BLOCK = createSpineriosPathBlock("spinerios_grass_path");
    public static final Block SPINERIOS_IRON_ORE = createDirtOre("spinerios_iron_ore");
    public static final Block SPINERIOS_LAPIS_ORE = createDirtOre("spinerios_lapis_ore");
    public static final Block SPINERIOS_LIROTH_ORE = createDirtOre("spinerios_liroth_ore");
    public static final Block SPINERIOS_QUARTZ_ORE = createDirtOre("spinerios_quartz_ore");
    public static final Block SPINERIOS_REDSTONE_ORE = createDirtOre("spinerios_redstone_ore");
    public static final Block SPINERIOS_ANCIENT_DEBRIS = createSpineriosAncientDebris("spinerios_ancient_debris");
    public static final Block SPINERIOS_STONE = createStone("spinerios_stone");
    public static final Block SPINERIOS_STONE_ORE = createDirtOre("spinerios_stone_ore");
    public static final Block SPINERIOS_STONE_WALL = createStoneWall("spinerios_stone_wall");
    public static final Block SPINERIOS_STONE_SLAB = createStoneSlab("spinerios_stone_slab");
    public static final Block SPINERIOS_STONE_STAIRS = createStoneStairs("spinerios_stone_stairs");
    public static final Block SPINERIOS_STONE_BRICKS = createStone("spinerios_stone_bricks");
    public static final Block SPINERIOS_STONE_BRICK_WALL = createStoneWall("spinerios_stone_brick_wall");
    public static final Block SPINERIOS_STONE_BRICK_SLAB = createStoneSlab("spinerios_stone_brick_slab");
    public static final Block SPINERIOS_STONE_BRICK_STAIRS = createStoneStairs("spinerios_stone_brick_stairs");
    public static final Block SPINERIOS_STONE_TOURMALINE_ORE = createOre("spinerios_stone_tourmaline_ore");
    public static final Block SPINERIOS_TOURMALINE_ORE = createDirtOre("spinerios_tourmaline_ore");
    public static final Block STRIPPED_LIROTH_LOG = createStrippedLog("stripped_liroth_log");
    public static final Block STRIPPED_SPICED_LOG = createStrippedLog("stripped_spiced_log");
    public static final Block STRIPPED_TALLPIER_LOG = createStrippedLog("stripped_tallpier_log");
    public static final Block STRIPPED_DAMNATION_LOG = createStrippedLog("stripped_damnation_log");
    public static final Block STRIPPED_JAPZ_LOG = createStrippedLog("stripped_japz_log");
    public static final Block STRIPPED_KOOLAW_LOG = createStrippedLog("stripped_koolaw_log");
    public static final Block STRIPPED_PETRIFIED_DAMNATION_LOG = createStrippedLog("stripped_petrified_damnation_log");
    public static final Block STRIPPED_LIROTH_WOOD = createWood("stripped_liroth_wood");
    public static final Block STRIPPED_SPICED_WOOD = createWood("stripped_spiced_wood");
    public static final Block STRIPPED_TALLPIER_WOOD = createWood("stripped_tallpier_wood");
    public static final Block STRIPPED_DAMNATION_WOOD = createWood("stripped_damnation_wood");
    public static final Block STRIPPED_JAPZ_WOOD = createWood("stripped_japz_wood");
    public static final Block STRIPPED_KOOLAW_WOOD = createWood("stripped_koolaw_wood");
    public static final Block STRIPPED_PETRIFIED_DAMNATION_WOOD = createWood("stripped_petrified_damnation_wood");
    public static final Block TALLPIER_CRAFTING_TABLE = createCraftingTable("tallpier_crafting_table");
    public static final Block TALLPIER_CHEST = createChest("tallpier_chest");
    public static final Block TALLPIER_LEAVES = createLeaves("tallpier_leaves");
    public static final Block TALLPIER_LOG = createLog("tallpier_log");
    public static final Block TALLPIER_PLANKS = createPlanks("tallpier_planks");
    public static final Block TALLPIER_DOOR = createDoor("tallpier_door");
    public static final Block TALLPIER_FENCE = createFence("tallpier_fence");
    public static final Block TALLPIER_SLAB = createWoodSlab("tallpier_slab");
    public static final Block TALLPIER_STAIRS = createWoodStairs("tallpier_stairs");
    public static final Block TALLPIER_TRAPDOOR = createTrapDoor("tallpier_trapdoor");
    public static final Block TALLPIER_WOOD = createWood("tallpier_wood");
    public static final Block TOURMALINE_GEM_BLOCK = createMetalBlock("tourmaline_gem_block");
    public static final Block TOURMALINE_ORE = createStone("tourmaline_ore");
    public static final Block VILE_TENTACLE_TIP = createUnderwaterReedTop("vile_tentacle_tip");
    public static final Block VILE_TENTACLE = createUnderwaterReed("vile_tentacle");
    public static final Block WALL_FUNGAL_TORCH = createWallTorch("wall_fungal_torch");
    public static final Block WALL_LIROTHIAN_PETROLEUM_TORCH = createWallPetroleumTorch("wall_lirothian_petroleum_torch");
    public static final Block WILITING_LIROTH_ROSE = createFlower("wilting_liroth_rose");

    
    // Block With Block Entities
//    public static final Block JALSPHIRE_COMPACTOR = createJalsphireCompactor("jalsphire_compactor");
//    public static final Block LIROTH_DUST_COMPACTOR = createLirothDustCompactor("liroth_dust_compactor");
    public static final Block LIROTH_SPLITTER = createLirothSplitter("liroth_splitter");
//    public static final Block LIROTHIAN_TRANSMUTATION_TABLE = createLirothianTransmutationTable("lirothian_transmutation_table");
    public static final Block QUANTUM_EXTRACTOR = createQuantumExtractor("quantum_extractor");
    
    // Saplings
    public static final Block LIROTH_SAPLING = createLirothSapling("liroth_sapling");
    public static final Block SPICED_SAPLING = createSpicedSapling("spiced_sapling");
    public static final Block TALLPIER_SAPLING = createTallpierSapling("tallpier_sapling");
    public static final Block DAMNATION_SAPLING = createDamnationSapling("damnation_sapling");
    public static final Block JAPZ_SAPLING = createJapzSapling("japz_sapling");
    public static final Block KOOLAW_SAPLING = createKoolawSapling("koolaw_sapling");
    public static final Block PETRIFIED_DAMNATION_SAPLING = createPetrifiedSapling("petrified_damnation_sapling");

    // Potted Plants
    public static final Block LIROTH_SAPLING_POT = createPottedBlock(LIROTH_SAPLING, "liroth_sapling");
    public static final Block SPICED_SAPLING_POT = createPottedBlock(SPICED_SAPLING, "spiced_sapling");
    public static final Block TALLPIER_SAPLING_POT = createPottedBlock(TALLPIER_SAPLING, "tallpier_sapling");
    public static final Block DAMNATION_SAPLING_POT = createPottedBlock(DAMNATION_SAPLING, "damnation_sapling");
    public static final Block JAPZ_SAPLING_POT = createPottedBlock(JAPZ_SAPLING, "japz_sapling");
    public static final Block KOOLAW_SAPLING_POT = createPottedBlock(KOOLAW_SAPLING, "koolaw_sapling");
    public static final Block PETRIFIED_DAMNATION_SAPLING_POT = createPottedBlock(PETRIFIED_DAMNATION_SAPLING, "petrified_damnation_sapling");
        
    // BlockStates
	   public static final class States {
		      public static final BlockState LIROTH_LOG = LirothBlocks.LIROTH_LOG.getDefaultState();
		      public static final BlockState LIROTH_LEAVES = LirothBlocks.LIROTH_LEAVES.getDefaultState();
		      public static final BlockState SPICED_LOG = LirothBlocks.SPICED_LOG.getDefaultState();
		      public static final BlockState SPICED_LEAVES = LirothBlocks.SPICED_LEAVES.getDefaultState();
		      public static final BlockState TALLPIER_LOG = LirothBlocks.TALLPIER_LOG.getDefaultState();
		      public static final BlockState TALLPIER_LEAVES = LirothBlocks.TALLPIER_LEAVES.getDefaultState();
		      public static final BlockState DAMNATION_LOG = LirothBlocks.DAMNATION_LOG.getDefaultState();
		      public static final BlockState DAMNATION_LEAVES = LirothBlocks.DAMNATION_LEAVES.getDefaultState();
		      public static final BlockState JAPZ_LOG = LirothBlocks.JAPZ_LOG.getDefaultState();
		      public static final BlockState JAPZ_LEAVES = LirothBlocks.JAPZ_LEAVES.getDefaultState();
		      public static final BlockState PETRIFIED_DAMNATION_LOG = LirothBlocks.PETRIFIED_DAMNATION_LOG.getDefaultState();
		      public static final BlockState KOOLAW_LOG = LirothBlocks.KOOLAW_LOG.getDefaultState();
		      public static final BlockState KOOLAW_LEAVES = LirothBlocks.KOOLAW_LEAVES.getDefaultState();
		      public static final BlockState LIROTH_GEM_BLOCK = LirothBlocks.LIROTH_GEM_BLOCK.getDefaultState();
		      public static final BlockState DEVASTATED_BRICKS = LirothBlocks.DEVASTATED_BRICKS.getDefaultState();
	   }
	   
    
   
    static Block createStone(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.STONE));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    

    
    static Block createGleemStone(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.GLOWSTONE).sounds(BlockSoundGroup.GLASS).luminance(state -> 15));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createLockBlock(String id) {
        Block createBlock = new LockBlock(FabricBlockSettings.copy(Blocks.STONE));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createCoalBlock(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.COAL_BLOCK));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createPetrifiedCrystalBlock(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.GLASS));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createPointedPetrifiedCrystal(String id) {
        Block createBlock = new PointedPetrifiedCrystal(FabricBlockSettings.copy(Blocks.GLASS).dynamicBounds());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createPetrifiedCaveVinesHead(String id) {
        Block createBlock = new PetrifiedCaveVinesHeadBlock(FabricBlockSettings.copy(Blocks.CAVE_VINES));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createPetrifiedCaveVinesBody(String id) {
        Block createBlock = new PetrifiedCaveVinesBodyBlock(FabricBlockSettings.copy(Blocks.CAVE_VINES_PLANT));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createPetrifiedPlant(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.STONE));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createPetrifiedFlower(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.STONE));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    public  static Block createFungalGrass(String id) {
        Block createBlock = new GrassBlock(FabricBlockSettings.copy(Blocks.CRIMSON_ROOTS).noCollision().emissiveLighting(LirothBlocks::always));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createMoss(String id) {
        Block createBlock = new MossBlock(FabricBlockSettings.copy(Blocks.MOSS_BLOCK));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createWeepingVinesHead(String id) {
        Block createBlock = new CustomWeepingVinesBlock(FabricBlockSettings.copy(Blocks.WEEPING_VINES).noCollision().emissiveLighting(LirothBlocks::always));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createWeepingVinesBody(String id) {
        Block createBlock = new CustomWeepingVinesPlantBlock(FabricBlockSettings.copy(Blocks.WEEPING_VINES_PLANT).noCollision().emissiveLighting(LirothBlocks::always));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createCaveVinesHead(String id) {
        Block createBlock = new CustomCaveVinesHeadBlock(FabricBlockSettings.copy(Blocks.CAVE_VINES));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createCaveVinesBody(String id) {
        Block createBlock = new CustomCaveVinesBodyBlock(FabricBlockSettings.copy(Blocks.CAVE_VINES_PLANT));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createSporeBlossom(String id) {
        Block createBlock = new SporeBlossomBlock(FabricBlockSettings.copy(Blocks.SPORE_BLOSSOM).luminance(state -> 8));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createAzalea(String id) {
        Block createBlock = new CustomAzaleaBlock(FabricBlockSettings.copy(Blocks.AZALEA));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createMossCarpet(String id) {
        Block createBlock = new CarpetBlock(FabricBlockSettings.copy(Blocks.MOSS_CARPET));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createCrystalBlock(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.GLASS).luminance(state -> 8));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createPointedCrystal(String id) {
        Block createBlock = new PointedJalsphireCrystal(FabricBlockSettings.copy(Blocks.GLASS).dynamicBounds().luminance(state -> 8));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    private static Block createLirothSplitter(String id) {
        Block createBlock = new LirothSplitterBlock(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5f).luminance(LirothBlocks.createLightLevelFromLitBlockState(13)));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
	}

    private static Block createQuantumExtractor(String id) {
        Block createBlock = new QuantumExtractorBlock(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5f).nonOpaque().luminance(LirothBlocks.createLightLevelFromLitBlockState(13)));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
	}
    
    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.get(Properties.LIT) != false ? litLevel : 0;
    }

	static Block createWaterPlant(String id) {
        Block createBlock = new CustomWaterPlant(DEAD_SEA_EYE, FabricBlockSettings.copy(Blocks.FIRE_CORAL_FAN));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createDeadWaterPlant(String id) {
        Block createBlock = new CustomDeadWaterPlant(FabricBlockSettings.copy(Blocks.DEAD_FIRE_CORAL_FAN));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createFungusPlant(String id) {
        Block createBlock = new CustomFungalPlant(FabricBlockSettings.copy(Blocks.CRIMSON_FUNGUS).noCollision().emissiveLighting(LirothBlocks::always), null);
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createWartBlock(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.NETHER_WART_BLOCK).emissiveLighting(LirothBlocks::always));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createShroomlightBlock(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.NETHER_WART_BLOCK).emissiveLighting(LirothBlocks::always).strength(1.0f).sounds(BlockSoundGroup.SHROOMLIGHT).luminance(state -> 15));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createCampfire(String id) {
        Block createBlock = new FungalCampfireBlock(false, 1, FabricBlockSettings.copy(Blocks.CAMPFIRE).luminance(LirothBlocks.createLightLevelFromLitBlockState(15)).nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createLirothianPetroleumCampfire(String id) {
        Block createBlock = new LirothianPetroleumCampfireBlock(false, 1, FabricBlockSettings.copy(Blocks.CAMPFIRE).luminance(LirothBlocks.createLightLevelFromLitBlockState(15)).nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createTorch(String id) {
        Block createBlock = new CustomTorch(FabricBlockSettings.copy(Blocks.TORCH).noCollision(), ParticleTypes.HAPPY_VILLAGER);
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createPetroleumTorch(String id) {
        Block createBlock = new CustomTorch(FabricBlockSettings.copy(Blocks.TORCH).noCollision(), ParticleTypes.PORTAL);
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createWallPetroleumTorch(String id) {
        Block createBlock = new CustomWallTorch(FabricBlockSettings.copy(Blocks.TORCH).noCollision().dropsLike(FUNGAL_TORCH), ParticleTypes.PORTAL);
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createLantern(String id) {
        Block createBlock = new LanternBlock(FabricBlockSettings.copy(Blocks.LANTERN));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createWallTorch(String id) {
        Block createBlock = new CustomWallTorch(FabricBlockSettings.copy(Blocks.TORCH).noCollision().dropsLike(FUNGAL_TORCH), ParticleTypes.HAPPY_VILLAGER);
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createFungusClusterPlant(String id) {
        Block createBlock = new TallFlowerBlock(FabricBlockSettings.copy(Blocks.CRIMSON_FUNGUS).noCollision().emissiveLighting(LirothBlocks::always));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createUnderwaterReedTop(String id) {
        Block createBlock = new CustomKelpBlock(FabricBlockSettings.copy(Blocks.KELP));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createUnderwaterReed(String id) {
        Block createBlock = new CustomKelpPlantBlock(FabricBlockSettings.copy(Blocks.KELP_PLANT));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createCraftingTable(String id) {
        Block createBlock = new CustomCraftingTable(FabricBlockSettings.copy(Blocks.CRAFTING_TABLE));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createBrewingStand(String id) {
        Block createBlock = new BrewingStandBlock(FabricBlockSettings.copy(Blocks.BREWING_STAND));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createFurnace(String id) {
        Block createBlock = new BaseFurnaceBlock(FabricBlockSettings.copy(Blocks.STONE).luminance(LirothBlocks.createLightLevelFromLitBlockState(13)));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createChest(String id) {
        Block createBlock = new BaseChestBlock(Blocks.CHEST);
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static LirothPortalBlock createLirothPortal(String id) {
    	LirothPortalBlock createBlock = new LirothPortalBlock(FabricBlockSettings.copy(Blocks.END_PORTAL));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createAnomalyBlock(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.IRON_BLOCK).nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createPortalFrame(String id) {
        Block createBlock = new CustomPortalFrameBlock(FabricBlockSettings.copy(Blocks.OBSIDIAN).nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createBoneBlock(String id) {
        Block createBlock = new PillarBlock(FabricBlockSettings.copy(Blocks.BONE_BLOCK));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createSpineriosAncientDebris(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.ANCIENT_DEBRIS));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
	}

	static Block createFireBlock(String id) {
        Block createBlock = new FireBlock(FabricBlockSettings.copy(Blocks.FIRE));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createRod(String id) {
        Block createBlock = new CustomRod(FabricBlockSettings.copy(Blocks.STONE));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createGlassBlock(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.GLASS));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createForcefieldPane(String id) {
        Block createBlock = new CustomPane(AbstractBlock.Settings.copy(Blocks.BARRIER).nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createObsidianBlock(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.OBSIDIAN));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createFence(String id) {
        Block createBlock = new FenceBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createFenceGate(String id) {
        Block createBlock = new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createSand(int dustColor, String id) {
        Block createBlock = new SandBlock(dustColor, FabricBlockSettings.of(Material.AGGREGATE).sounds(BlockSoundGroup.SAND).strength(0.2f).breakByTool(FabricToolTags.SHOVELS));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createNonFallingSand(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.DIRT).sounds(BlockSoundGroup.SAND).strength(0.2f).requiresTool());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createDamnationSoil(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.DIRT).sounds(BlockSoundGroup.SOUL_SAND).strength(0.2f).requiresTool());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createLirothSoulSand(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.DIRT).sounds(BlockSoundGroup.SOUL_SAND).strength(0.2f).requiresTool());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createSoullessSoil(String id) {
        Block createBlock = new Block(FabricBlockSettings.copy(Blocks.DIRT).sounds(BlockSoundGroup.SOUL_SOIL).strength(0.2f).requiresTool());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createWoodSlab(String id) {
        Block createBlock = new SlabBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createStoneSlab(String id) {
        Block createBlock = new SlabBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(2.0f, 6.0f).breakByTool(FabricToolTags.PICKAXES).requiresTool());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createStoneWall(String id) {
        Block createBlock = new WallBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).strength(2.0f, 6.0f).breakByTool(FabricToolTags.PICKAXES).requiresTool());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createWoodPressurePlate(String id) {
        Block createBlock = PressurePlateBlockAccess.create(PressurePlateBlock.ActivationRule.EVERYTHING, AbstractBlock.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).noCollision().strength(0.5F));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createWoodStairs(String id) {
        Block createBlock = StairBlockAccess.create(Registry.BLOCK.get(new Identifier(Liroth.MOD_ID, id.replace("_stairs", "planks"))).getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createStoneStairs(String id) {
        Block createBlock = StairBlockAccess.create(Registry.BLOCK.get(new Identifier(Liroth.MOD_ID, id.replace("_stairs", "planks"))).getDefaultState(), AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createTrapDoor(String id) {
        Block createBlock = TrapDoorBlockAccess.create(AbstractBlock.Settings.of(Material.WOOD, MapColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f).nonOpaque());
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createMetalTrapDoor(String id) {
        Block createBlock = TrapDoorBlockAccess.create(AbstractBlock.Settings.of(Material.METAL, MapColor.BLUE).sounds(BlockSoundGroup.METAL).strength(3.0f, 4.0f).nonOpaque());
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createWoodButton(String id) {
        Block createBlock = WoodButtonBlockAccess.create(AbstractBlock.Settings.of(Material.DECORATION).sounds(BlockSoundGroup.WOOD).noCollision().strength(0.5F));
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createDoor(String id) {
        Block createBlock = DoorBlockAccess.create(AbstractBlock.Settings.of(Material.WOOD, MapColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f).nonOpaque());
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createMetalDoor(String id) {
        Block createBlock = DoorBlockAccess.create(AbstractBlock.Settings.of(Material.METAL, MapColor.BLUE).sounds(BlockSoundGroup.METAL).strength(3.0f, 4.0f).nonOpaque());
        createBlock(createBlock, id);
        return createBlock;
    }

    static Block createPlanks(String id) {
        Block createBlock = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.BROWN).sounds(BlockSoundGroup.WOOD).strength(2.0f, 3.0f));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createWood(String id) {
        Block createBlock = new PillarBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createStrippedLog(String id) {
        Block createBlock = new PillarBlock(FabricBlockSettings.of(Material.WOOD, MapColor.BLACK).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createLog(String id) {
        Block createBlock = new PillarBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createDamnationLog(String id) {
        Block createBlock = new PillarBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(2.0f).emissiveLighting(LirothBlocks::always));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createFlower(String id) {
        Block createBlock = new FlowerBlock(StatusEffects.SATURATION, 7, FabricBlockSettings.of(Material.PLANT).sounds(BlockSoundGroup.GRASS).strength(0.0f).noCollision().nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        createPottedBlock(createBlock, id);
        BLOCKS.add(createBlock);
        flowerIDs.add(new Identifier(Liroth.MOD_ID, id));
        return createBlock;
    }

    static Block createTallFlower(String id) {
        Block createBlock = new TallFlowerBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).sounds(BlockSoundGroup.GRASS).strength(0.0f).noCollision().nonOpaque());
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        flowerIDs.add(new Identifier(Liroth.MOD_ID, id));
        return createBlock;
    }

    static Block createPottedBlock(Block blockForPot, String id) {
        Block createBlock = new FlowerPotBlock(blockForPot, FabricBlockSettings.of(Material.WOOD).breakInstantly().nonOpaque());
//        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, "potted_" + id), createBlock);
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, "potted_" + id), createBlock); //Forge
        flowerPotBlocks.add(createBlock);
//        BLOCKS.add(createBlock);
		return createBlock;
    }

    static Block createShroomlight(String id) {
        Block createBlock = new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.PURPLE).strength(1.0F).sounds(BlockSoundGroup.SHROOMLIGHT).breakByTool(FabricToolTags.HOES).luminance((state) -> 14));
        //Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);
        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createLeaves(String id) {
        Block createBlock = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().blockVision((state, world, pos) -> false).suffocates((state, world, pos) -> false).breakByTool(FabricToolTags.HOES));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createGlowingLeaves(String id) {
        return createGlowingLeaves(15, id);
    }

    static Block createGlowingLeaves(int lightLevel, String id) {
        Block createBlock = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().blockVision((state, world, pos) -> false).suffocates((state, world, pos) -> false).luminance((state) -> lightLevel).breakByTool(FabricToolTags.HOES));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createPetal(String id) {
        Block createBlock = new Block(FabricBlockSettings.of(Material.LEAVES).sounds(BlockSoundGroup.GRASS).strength(0.2f).nonOpaque().breakByTool(FabricToolTags.HOES));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }

    static Block createDirt(String id) {
        Block createBlock = new Block(FabricBlockSettings.of(Material.SOIL).sounds(BlockSoundGroup.GRAVEL).strength(0.2f).ticksRandomly().breakByTool(FabricToolTags.SHOVELS));
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), createBlock);

        BLOCKS.add(createBlock);
        return createBlock;
    }
    
    static Block createOre(String id) {
        Block createBlock = new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createSoilOre(String id) {
        Block createBlock = new Block(AbstractBlock.Settings.copy(Blocks.SOUL_SOIL));
        createBlock(createBlock, id);
        return createBlock;
    }


    static Block createDirtOre(String id) {
        Block createBlock = new Block(AbstractBlock.Settings.copy(Blocks.DIRT));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createDeepslateOre(String id) {
        Block createBlock = new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_DIAMOND_ORE));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createMetalBlock(String id) {
        Block createBlock = new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createPillarMetalBlock(String id) {
        Block createBlock = new PillarBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createPillarBlock(String id) {
        Block createBlock = new PillarBlock(AbstractBlock.Settings.copy(Blocks.STONE));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createGrassBlock(String id) {
        Block createBlock = new Block(FabricBlockSettings.of(Material.MOSS_BLOCK).sounds(BlockSoundGroup.GRASS).strength(0.2f).ticksRandomly().breakByTool(FabricToolTags.SHOVELS));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createLirothGrassBlock(String id) {
        Block createBlock = new LirothGrassBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createLirothFarmlandBlock(String id) {
        Block createBlock = new LirothFarmlandBlock(FabricBlockSettings.copy(Blocks.FARMLAND));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createLirothPathBlock(String id) {
        Block createBlock = new LirothPathBlock(FabricBlockSettings.copy(Blocks.DIRT_PATH));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createPierGrassBlock(String id) {
        Block createBlock = new PierGrassBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createPierFarmlandBlock(String id) {
        Block createBlock = new PierFarmlandBlock(FabricBlockSettings.copy(Blocks.FARMLAND));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createPierPathBlock(String id) {
        Block createBlock = new PierPathBlock(FabricBlockSettings.copy(Blocks.DIRT_PATH));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createSpineriosGrassBlock(String id) {
        Block createBlock = new SpineriosGrassBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createSpineriosFarmlandBlock(String id) {
        Block createBlock = new SpineriosFarmlandBlock(FabricBlockSettings.copy(Blocks.FARMLAND));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createSpineriosPathBlock(String id) {
        Block createBlock = new SpineriosPathBlock(FabricBlockSettings.copy(Blocks.DIRT_PATH));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public  static Block createGrass(String id) {
        Block createBlock = new GrassBlock(FabricBlockSettings.copy(Blocks.GRASS));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createLirothSapling(String id) {
        Block createBlock = new CustomSapling(new LirothTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createSpicedSapling(String id) {
        Block createBlock = new CustomSapling(new SpicedTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createTallpierSapling(String id) {
        Block createBlock = new CustomSapling(new TallpierTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createJapzSapling(String id) {
        Block createBlock = new CustomSapling(new JapzTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createKoolawSapling(String id) {
        Block createBlock = new CustomSapling(new KoolawTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createDamnationSapling(String id) {
        Block createBlock = new CustomSapling(new DamnationTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    public static Block createPetrifiedSapling(String id) {
        Block createBlock = new CustomSapling(new PetrifiedDamnationTree(), AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS));
        createBlock(createBlock, id);
        return createBlock;
    }
    
    static Block createBlock(Block block, String id) {
        Registry.register(Registry.BLOCK, new Identifier(Liroth.MOD_ID, id), block);
        BLOCKS.add(block);
        return block;
    }
    
    private static boolean always(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    public static void init() {
    }
}