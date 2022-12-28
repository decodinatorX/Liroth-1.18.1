package com.decodinator.liroth.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.LirothCreativeTab;
import com.decodinator.liroth.core.helpers.PotestiumHelmItem;
import com.decodinator.liroth.core.items.AnsalumArmorItem;
import com.decodinator.liroth.core.items.AnsalumLirothShield;
import com.decodinator.liroth.core.items.BeamItem;
import com.decodinator.liroth.core.items.CustomAxeItem;
import com.decodinator.liroth.core.items.CustomHoeItem;
import com.decodinator.liroth.core.items.CustomPickaxeItem;
import com.decodinator.liroth.core.items.CustomScytheItem;
import com.decodinator.liroth.core.items.DamnationBoatItem;
import com.decodinator.liroth.core.items.JapzBoatItem;
import com.decodinator.liroth.core.items.KeyItem;
import com.decodinator.liroth.core.items.KoolawBoatItem;
import com.decodinator.liroth.core.items.LirothBlaster;
import com.decodinator.liroth.core.items.LirothBoatItem;
import com.decodinator.liroth.core.items.LirothShield;
import com.decodinator.liroth.core.items.LuxArmorItem;
import com.decodinator.liroth.core.items.LuxLirothShield;
import com.decodinator.liroth.core.items.PetrifiedBoatItem;
import com.decodinator.liroth.core.items.PierBoatItem;
import com.decodinator.liroth.core.items.PotestiumArmorItem;
import com.decodinator.liroth.core.items.QuantumArmorItem;
import com.decodinator.liroth.core.items.QuantumLirothShield;
import com.decodinator.liroth.core.items.SalemArmorItem;
import com.decodinator.liroth.core.items.SalemLirothShield;
import com.decodinator.liroth.core.items.SpicedBoatItem;

public class LirothItems {
	
	public static Item LIROTH_FLUID_BUCKET;
	public static Item MOLTEN_SPINERIOS_BUCKET;
	
	private static int scytheDamage = getScytheDamage();
	
    public static List<Item> itemsList = new ArrayList<>();
    
//    public static final Item TEMPLATE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeTab)), "template");
    
    public static final Item BLOODY_ENTRAILS = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab).food(FoodComponents.ROTTEN_FLESH)), "bloody_entrails");
    
    public static final Item COOL_BEAM = createItem(new BeamItem(new Item.Settings()), "cool_beam");
    
//    public static final Item CORRUPTED_JALSPHIRE_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "corrupted_jalsphire_gem");
    
//    public static final Item CORRUPTED_LIROTH_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "corrupted_liroth_gem");
    
//    public static final Item CORRUPTED_LIROTH_STAR = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "corrupted_liroth_star");
    
//    public static final Item CORRUPTED_ROD = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeTab)), "corrupted_rod"); IS NOW THE COOL BEAM
    
    
//    public static final Item EMBUED_LIROTH_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "embued_liroth_gem");
    
    public static final Item GLEEMSTONE_DUST = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "gleemstone_dust");
    
    public static final Item JALSPHIRE_DUST = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "jalsphire_dust");
    public static final Item JALSPHIRE_DUST_HEAP = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "jalsphire_dust_heap");
    public static final Item JALSPHIRE_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "jalsphire_gem");
    
    public static final Item LIROTH_GEM_ANSALUM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem_ansalum");

    public static final Item LIROTH_BERRY = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab).food(FoodComponents.SUSPICIOUS_STEW)), "liroth_berry");

    public static final Item LIROTH_BLASTER = createRangedItem(new LirothBlaster(new Item.Settings().group(LirothCreativeTab.creativeCombatTab).maxCount(1)), "liroth_blaster");
    
    public static final LirothBoatItem LIROTH_BOAT = new LirothBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final LirothBoatItem CHEST_LIROTH_BOAT = new LirothBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final DamnationBoatItem DAMNATION_BOAT = new DamnationBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final DamnationBoatItem CHEST_DAMNATION_BOAT = new DamnationBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final SpicedBoatItem SPICED_BOAT = new SpicedBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final SpicedBoatItem CHEST_SPICED_BOAT = new SpicedBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final PierBoatItem PIER_BOAT = new PierBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final PierBoatItem CHEST_PIER_BOAT = new PierBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final JapzBoatItem JAPZ_BOAT = new JapzBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final JapzBoatItem CHEST_JAPZ_BOAT = new JapzBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final KoolawBoatItem KOOLAW_BOAT = new KoolawBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final KoolawBoatItem CHEST_KOOLAW_BOAT = new KoolawBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final PetrifiedBoatItem PETRIFIED_BOAT = new PetrifiedBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final PetrifiedBoatItem CHEST_PETRIFIED_BOAT = new PetrifiedBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    
    public static final Item LIROTH_BONE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_bone");

    public static final Item LIROTH_DUST_ANSALUM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_dust_ansalum");
    public static final Item LIROTH_DUST_LUX = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_dust_lux");
    public static final Item LIROTH_DUST_SALEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_dust_salem");
    
    public static final Item LIROTH_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem");
    public static final Item LIROTH_HORSE_ARMOR = createItem(new HorseArmorItem(9, "liroth", new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_horse_armor");
    public static final Item LIROTH_GEM_DUST = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem_dust");
    public static final Item LIROTH_GEM_DUST_HEAP = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem_dust_heap");
    
    //It's got that extreme pulp of taking a big ass bite out of a lemon and the tanginess of blackberries while the taste itself is a strawberry metallic flavor
    public static final Item LIROTH_COATED_BREAD = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab).food(FoodComponents.BREAD)), "liroth_coated_bread");
    
    public static final Item LIROTH_GEM_LUX = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem_lux");

    // HMMMMMMMMMMM
    public static final Item LIROTHIAN_DUNGEON_KEY = createItem(new KeyItem(new Item.Settings().group(LirothCreativeTab.creativeItemsTab).maxDamage(1)), "lirothian_dungeon_key");
    
    public static final Item LIROTH_GEM_SALEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem_salem");
    
    public static final Item LIROTHIAN_COBALT_INGOT = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "lirothian_cobalt_ingot");
    public static final Item LIROTHIAN_COBALT_NUGGET = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "lirothian_cobalt_nugget");
    public static final Item LIROTHIAN_COBALT_HORSE_ARMOR = createItem(new HorseArmorItem(5, "lirothian_cobalt", new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_horse_armor");
    public static final Item RAW_LIROTHIAN_COBALT = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "raw_lirothian_cobalt");

    public static final Item LIROTHIAN_PETROLEUM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "lirothian_petroleum");
    
    public static final Item LIROTH_SHIELD = createShieldItem(new LirothShield(new Item.Settings().group(LirothCreativeTab.creativeCombatTab).maxCount(1)), "liroth_shield");
    public static final Item ANSALUM_LIROTH_SHIELD = createAnsalumShieldItem(new AnsalumLirothShield(new Item.Settings().group(LirothCreativeTab.creativeCombatTab).maxCount(1)), "ansalum_liroth_shield");
    public static final Item LUX_LIROTH_SHIELD = createLuxShieldItem(new LuxLirothShield(new Item.Settings().group(LirothCreativeTab.creativeCombatTab).maxCount(1)), "lux_liroth_shield");
    public static final Item SALEM_LIROTH_SHIELD = createSalemShieldItem(new SalemLirothShield(new Item.Settings().group(LirothCreativeTab.creativeCombatTab).maxCount(1)), "salem_liroth_shield");
    public static final Item QUANTUM_LIROTH_SHIELD = createQuantumShieldItem(new QuantumLirothShield(new Item.Settings().group(LirothCreativeTab.creativeCombatTab).maxCount(1)), "quantum_liroth_shield");
    
    public static final Item LIROTH_SOUL_DUST = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_soul_dust");
    
//    public static final Item LIROTH_STAR = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_star");

    public static final Item LIROTH_TEAR = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_tear");
        
    public static final Item NETHERITE_HORSE_ARMOR = createItem(new HorseArmorItem(8, "netherite", new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "netherite_horse_armor");
    
    public static final Item PURPETUATED_AMETHYST_SHARD = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "purpetuated_amethyst_shard");
//    public static final Item PURPETUATED_SPYGLASS = createItem(new PurpetuatedSpyglassItem(new Item.Settings().group(LirothCreativeTab.creativeTab)), "purpetuated_spyglass");
    
    public static final Item QUANTUM_DIAMOND = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "quantum_diamond");
    public static final Item QUANTUM_HORSE_ARMOR = createItem(new HorseArmorItem(10, "quantum", new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "quantum_horse_armor");
    public static final Item QUANTUM_PLATE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "quantum_plate");
    public static final Item RUBY = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "ruby");
    public static final Item RUBY_HORSE_ARMOR = createItem(new HorseArmorItem(7, "ruby", new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_horse_armor");
    public static final Item POTESTIUM_SHARD = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "potestium_shard");
    public static final Item POTESTIUM_HORSE_ARMOR = createItem(new HorseArmorItem(10, "potestium", new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "potestium_horse_armor");
    public static final Item POTESTIUM_PLATE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "potestium_plate");
//    public static final Item SOUL_GLASS_BOTTLE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "soul_glass_bottle");
    public static final Item SPINERIOS_STONE_PEBBLE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "spinerios_stone_pebble");
    
    public static final Item TOURMALINE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "tourmaline");
    public static final Item TOURMALINE_HORSE_ARMOR = createItem(new HorseArmorItem(8, "tourmaline", new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_horse_armor");

    public static final Item LIROTH_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_helmet");
    public static final Item LIROTH_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_chestplate");
    public static final Item LIROTH_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_leggings");
    public static final Item LIROTH_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_boots");
    
    public static final Item LIROTHIAN_COBALT_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_helmet");
    public static final Item LIROTHIAN_COBALT_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_chestplate");
    public static final Item LIROTHIAN_COBALT_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_leggings");
    public static final Item LIROTHIAN_COBALT_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_boots");
    
    public static final Item ANSALUM_LIROTH_HELMET = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ansalum_liroth_helmet");
    public static final Item ANSALUM_LIROTH_CHESTPLATE = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ansalum_liroth_chestplate");
    public static final Item ANSALUM_LIROTH_LEGGINGS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ansalum_liroth_leggings");
    public static final Item ANSALUM_LIROTH_BOOTS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ansalum_liroth_boots");
    
    public static final Item ANSALUM_LIROTH_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.ANSALUM_LIROTH_TOOL_MATERIAL, 7.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "ansalum_liroth_axe");
    public static final Item LUX_LIROTH_KATANA = createToolItem(new SwordItem(LirothToolMaterials.LUX_LIROTH_TOOL_MATERIAL, 2, -1.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "lux_liroth_katana");
    public static final Item SALEM_LIROTH_FALCHION = createToolItem(new SwordItem(LirothToolMaterials.SALEM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "salem_liroth_falchion");
    
    public static final Item QUANTUM_LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_sword");
    public static final Item QUANTUM_LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_shovel");
    public static final Item QUANTUM_LIROTH_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_pickaxe");
    public static final Item QUANTUM_LIROTH_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_axe");
    public static final Item QUANTUM_LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_hoe");
    
    public static final Item LUX_LIROTH_HELMET = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lux_liroth_helmet");
    public static final Item LUX_LIROTH_CHESTPLATE = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lux_liroth_chestplate");
    public static final Item LUX_LIROTH_LEGGINGS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lux_liroth_leggings");
    public static final Item LUX_LIROTH_BOOTS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lux_liroth_boots");
    
    public static final Item SALEM_LIROTH_HELMET = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "salem_liroth_helmet");
    public static final Item SALEM_LIROTH_CHESTPLATE = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "salem_liroth_chestplate");
    public static final Item SALEM_LIROTH_LEGGINGS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "salem_liroth_leggings");
    public static final Item SALEM_LIROTH_BOOTS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "salem_liroth_boots");
    
    public static final Item QUANTUM_LIROTH_HELMET = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "quantum_liroth_helmet");
    public static final Item QUANTUM_LIROTH_CHESTPLATE = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "quantum_liroth_chestplate");
    public static final Item QUANTUM_LIROTH_LEGGINGS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "quantum_liroth_leggings");
    public static final Item QUANTUM_LIROTH_BOOTS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "quantum_liroth_boots");
    
    public static final Item POTESTIUM_LIROTH_HELMET = createArmorItem(new PotestiumHelmItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "potestium_liroth_helmet");
    public static final Item POTESTIUM_LIROTH_CHESTPLATE = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "potestium_liroth_chestplate");
    public static final Item POTESTIUM_LIROTH_LEGGINGS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "potestium_liroth_leggings");
    public static final Item POTESTIUM_LIROTH_BOOTS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "potestium_liroth_boots");
    
    public static final Item POTESTIUM_SCYTHE = createToolItem(new CustomScytheItem(LirothToolMaterials.POTESTIUM_LIROTH_TOOL_MATERIAL, LirothItems.scytheDamage, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "potestium_scythe");
    
    public static final Item LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_sword");
    public static final Item LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_shovel");
    public static final Item LIROTH_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_pickaxe");
    public static final Item LIROTH_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_axe");
    public static final Item LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_hoe");
    
    public static final Item LIROTHIAN_COBALT_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_sword");
    public static final Item LIROTHIAN_COBALT_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_shovel");
    public static final Item LIROTHIAN_COBALT_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_pickaxe");
    public static final Item LIROTHIAN_COBALT_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_axe");
    public static final Item LIROTHIAN_COBALT_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_hoe");
    
    public static final Item TOURMALINE_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_helmet");
    public static final Item TOURMALINE_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_chestplate");
    public static final Item TOURMALINE_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_leggings");
    public static final Item TOURMALINE_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_boots");
    
    public static final Item TOURMALINE_SWORD = createToolItem(new SwordItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_sword");
    public static final Item TOURMALINE_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_shovel");
    public static final Item TOURMALINE_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_pickaxe");
    public static final Item TOURMALINE_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_axe");
    public static final Item TOURMALINE_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_hoe");
    
    public static final Item RUBY_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_helmet");
    public static final Item RUBY_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_chestplate");
    public static final Item RUBY_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_leggings");
    public static final Item RUBY_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_boots");
    
    public static final Item RUBY_SWORD = createToolItem(new SwordItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_sword");
    public static final Item RUBY_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_shovel");
    public static final Item RUBY_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_pickaxe");
    public static final Item RUBY_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_axe");
    public static final Item RUBY_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, -3, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ruby_hoe");
    
    public static final Item FUNGAL_FIEND_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.FUNGAL_FIEND, 1315860, 2031360, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "fungal_fiend_spawn_egg");
    public static final Item FORSAKEN_CORPSE_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.FORSAKEN_CORPSE, 1842204, 10551525, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "forsaken_corpse_spawn_egg");
    public static final Item SKELETAL_FREAK_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.SKELETAL_FREAK, 1513239, 16711900, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "skeletal_freak_spawn_egg");
    public static final Item WARP_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.WARP, 524305, 4260003, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "warp_spawn_egg");
    public static final Item SOUL_ARACHNID_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.SOUL_ARACHNID, 73758, 5078138, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "soul_arachnid_spawn_egg");
    public static final Item PIER_PEEP_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.PIER_PEEP, 1638400, 11665663, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "pier_peep_spawn_egg");
    public static final Item SHADE_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.SHADE, 328965, 1579032, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "shade_spawn_egg");
    public static final Item PROWLER_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.PROWLER, 16312063, 4260003, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "prowler_spawn_egg");
    public static final Item FREAKSHOW_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.FREAKSHOW, 524305, 1579032, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "freakshow_spawn_egg");
    public static final Item VILE_SHARK_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.VILE_SHARK, 5963996, 7667865, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "vile_shark_spawn_egg");
    public static final Item LIROTHIAN_MIMIC_SPAWN_EGG = createSpawnEggItem(new SpawnEggItem(LirothEntities.LIROTHIAN_MIMIC, 41655, 10551525, new Item.Settings().group(LirothCreativeTab.creativeEntitiesTab)), "lirothian_mimic_spawn_egg");


    private static Item createArmorItem(ArmorItem armorItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), armorItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(armorItem);
      return armorItem;
	}
    
    private static Item createSpawnEggItem(SpawnEggItem spawnEggItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), spawnEggItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(spawnEggItem);
      if(!FabricLoader.getInstance().isModLoaded("liroth_addendum")) {
    	  return spawnEggItem;
      }
      return null;
	}
    
    private static Item createShieldItem(LirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createAnsalumShieldItem(AnsalumLirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createLuxShieldItem(LuxLirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createSalemShieldItem(SalemLirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createQuantumShieldItem(QuantumLirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createToolItem(ToolItem toolItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), toolItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(toolItem);
      return toolItem;
	}
    
    private static Item createRangedItem(LirothBlaster blasterItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), blasterItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(blasterItem);
      return blasterItem;
	}

	public static Item createItem(Item item, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), item);
//        item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        itemsList.add(item);
        return item;
    }
	
	public static int getScytheDamage() {
		if (FabricLoader.getInstance().isModLoaded("bettercombat")) {
			return 1;
		} else {
			return 3;
		}
	}

    public static void init() {
		LIROTH_FLUID_BUCKET = Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "liroth_fluid_bucket"), new BucketItem(LirothFluids.LIROTH_FLUID_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(LirothCreativeTab.creativeItemsTab)));
		MOLTEN_SPINERIOS_BUCKET = Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "molten_spinerios_bucket"), new BucketItem(LirothFluids.MOLTEN_SPINERIOS_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(LirothCreativeTab.creativeItemsTab)));

        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "liroth_boat"), LirothItems.LIROTH_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "chest_liroth_boat"), LirothItems.CHEST_LIROTH_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "damnation_boat"), LirothItems.DAMNATION_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "chest_damnation_boat"), LirothItems.CHEST_DAMNATION_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "spiced_boat"), LirothItems.SPICED_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "chest_spiced_boat"), LirothItems.CHEST_SPICED_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "pier_boat"), LirothItems.PIER_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "chest_pier_boat"), LirothItems.CHEST_PIER_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "japz_boat"), LirothItems.JAPZ_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "chest_japz_boat"), LirothItems.CHEST_JAPZ_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "koolaw_boat"), LirothItems.KOOLAW_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "chest_koolaw_boat"), LirothItems.CHEST_KOOLAW_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "petrified_boat"), LirothItems.PETRIFIED_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, "chest_petrified_boat"), LirothItems.CHEST_PETRIFIED_BOAT);
        
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
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_brewing_stand"), new BlockItem(LirothBlocks.CORRUPTED_BREWING_STAND, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_jalsphire_gem_block"), new BlockItem(LirothBlocks.CORRUPTED_JALSPHIRE_GEM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_jalsphire_ore"), new BlockItem(LirothBlocks.CORRUPTED_JALSPHIRE_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_liroth_gem_block"), new BlockItem(LirothBlocks.CORRUPTED_LIROTH_GEM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "corrupted_liroth_gem_ore"), new BlockItem(LirothBlocks.CORRUPTED_LIROTH_GEM_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
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
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_end_stone"), new BlockItem(LirothBlocks.LIROTH_END_STONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_fence"), new BlockItem(LirothBlocks.LIROTH_FENCE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_furnace"), new BlockItem(LirothBlocks.LIROTH_FURNACE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_gem_block"), new BlockItem(LirothBlocks.LIROTH_GEM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_gem_ore"), new BlockItem(LirothBlocks.LIROTH_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_glass_block"), new BlockItem(LirothBlocks.LIROTH_GLASS_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "liroth_grass"), new BlockItem(LirothBlocks.LIROTH_GRASS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
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
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "petrified_flower"), new BlockItem(LirothBlocks.PETRIFIED_FLOWER, new Item.Settings().group(LirothCreativeTab.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "pier_dirt"), new BlockItem(LirothBlocks.PIER_DIRT, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "pier_grass_block"), new BlockItem(LirothBlocks.PIER_GRASS_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "pier_farmland"), new BlockItem(LirothBlocks.PIER_FARMLAND_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "pier_grass_path"), new BlockItem(LirothBlocks.PIER_PATH_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "potestium_ore"), new BlockItem(LirothBlocks.POTESTIUM_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "potestium_block"), new BlockItem(LirothBlocks.POTESTIUM_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "potestium_plate_block"), new BlockItem(LirothBlocks.POTESTIUM_PLATE_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "quantum_diamond_ore"), new BlockItem(LirothBlocks.QUANTUM_DIAMOND_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "quantum_plate_block"), new BlockItem(LirothBlocks.QUANTUM_PLATE_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "redstone_broken_stage_1"), new BlockItem(LirothBlocks.REDSTONE_BROKEN_STAGE_1, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "redstone_broken_stage_2"), new BlockItem(LirothBlocks.REDSTONE_BROKEN_STAGE_2, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "redstone_broken_stage_3"), new BlockItem(LirothBlocks.REDSTONE_BROKEN_STAGE_3, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "raw_lirothian_cobalt_block"), new BlockItem(LirothBlocks.RAW_LIROTHIAN_COBALT_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "ruby_ore"), new BlockItem(LirothBlocks.RUBY_ORE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "ruby_block"), new BlockItem(LirothBlocks.RUBY_BLOCK, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "smooth_blue_sandstone"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "smooth_blue_sandstone_slab"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE_SLAB, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "smooth_blue_sandstone_stairs"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE_STAIRS, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "smooth_blue_sandstone_wall"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE_WALL, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new Identifier("liroth", "soul_rod"), new BlockItem(LirothBlocks.SOUL_ROD, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new Identifier("liroth", "soulless_flame"), new BlockItem(LirothBlocks.SOULLESS_FLAME, new Item.Settings().group(LirothCreativeTab.creativeBlocksTab)));
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
    }
}