package com.decodinator.liroth.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

import com.decodinator.liroth.Liroth;
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
import com.decodinator.liroth.core.items.UnusedItem;

public class LirothItems {

	public static Item LIROTH_FLUID_BUCKET;
	public static Item MOLTEN_SPINERIOS_BUCKET;
	
	private static int scytheDamage = getScytheDamage();
	
    public static List<Item> ITEMS = new ArrayList<>();
    public static List<Item> UNUSED_ITEMS = new ArrayList<>();
    public static List<Item> COMBAT_ITEMS = new ArrayList<>();
    
    public static final Item ANOMALY_CHARGE = createItem(new UnusedItem(new Item.Settings()), "anomaly_charge");
    
//    public static final Item TEMPLATE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeTab)), "template");
    
    public static final Item BLOODY_ENTRAILS = createItem(new Item(new Item.Settings().food(FoodComponents.ROTTEN_FLESH)), "bloody_entrails");
    
    public static final Item COOL_BEAM = createItem(new BeamItem(new Item.Settings()), "cool_beam");
    
//    public static final Item CORRUPTED_JALSPHIRE_GEM = createItem(new Item(new Item.Settings()), "corrupted_jalsphire_gem");
    
//    public static final Item CORRUPTED_LIROTH_GEM = createItem(new Item(new Item.Settings()), "corrupted_liroth_gem");
    
//    public static final Item CORRUPTED_LIROTH_STAR = createItem(new Item(new Item.Settings()), "corrupted_liroth_star");
    
//    public static final Item CORRUPTED_ROD = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeTab)), "corrupted_rod"); IS NOW THE COOL BEAM
    
    public static final Item DAMNATION_CHARGE = createItem(new UnusedItem(new Item.Settings()), "damnation_charge");
    
    public static final Item EMBUED_LIROTH_GEM = createItem(new Item(new Item.Settings()), "embued_liroth_gem");
    
    public static final Item GLEEMSTONE_DUST = createItem(new Item(new Item.Settings()), "gleemstone_dust");
   
    public static final Item JALSPHIRE_CHARGE = createItem(new UnusedItem(new Item.Settings()), "jalsphire_charge");
    public static final Item JALSPHIRE_DUST = createItem(new Item(new Item.Settings()), "jalsphire_dust");
    public static final Item JALSPHIRE_DUST_HEAP = createItem(new Item(new Item.Settings()), "jalsphire_dust_heap");
    public static final Item JALSPHIRE_GEM = createItem(new Item(new Item.Settings()), "jalsphire_gem");
    
    public static final Item JANTIRO_CHARGE = createItem(new UnusedItem(new Item.Settings()), "jantiro_charge");
    
    public static final Item LIROTH_GEM_ANSALUM = createItem(new Item(new Item.Settings()), "liroth_gem_ansalum");

    public static final Item LIROTH_BERRY = createItem(new Item(new Item.Settings().food(FoodComponents.SUSPICIOUS_STEW)), "liroth_berry");

    public static final Item LIROTH_BLASTER = createRangedItem(new LirothBlaster(new Item.Settings().maxCount(1)), "liroth_blaster");
    public static final Item LIROTH_CHARGE = createItem(new UnusedItem(new Item.Settings()), "liroth_charge");

    public static final LirothBoatItem LIROTH_BOAT = new LirothBoatItem(false, new FabricItemSettings().maxCount(1));
    public static final LirothBoatItem CHEST_LIROTH_BOAT = new LirothBoatItem(true, new FabricItemSettings().maxCount(1));
    public static final DamnationBoatItem DAMNATION_BOAT = new DamnationBoatItem(false, new FabricItemSettings().maxCount(1));
    public static final DamnationBoatItem CHEST_DAMNATION_BOAT = new DamnationBoatItem(true, new FabricItemSettings().maxCount(1));
    public static final SpicedBoatItem SPICED_BOAT = new SpicedBoatItem(false, new FabricItemSettings().maxCount(1));
    public static final SpicedBoatItem CHEST_SPICED_BOAT = new SpicedBoatItem(true, new FabricItemSettings().maxCount(1));
    public static final PierBoatItem PIER_BOAT = new PierBoatItem(false, new FabricItemSettings().maxCount(1));
    public static final PierBoatItem CHEST_PIER_BOAT = new PierBoatItem(true, new FabricItemSettings().maxCount(1));
    public static final JapzBoatItem JAPZ_BOAT = new JapzBoatItem(false, new FabricItemSettings().maxCount(1));
    public static final JapzBoatItem CHEST_JAPZ_BOAT = new JapzBoatItem(true, new FabricItemSettings().maxCount(1));
    public static final KoolawBoatItem KOOLAW_BOAT = new KoolawBoatItem(false, new FabricItemSettings().maxCount(1));
    public static final KoolawBoatItem CHEST_KOOLAW_BOAT = new KoolawBoatItem(true, new FabricItemSettings().maxCount(1));
    public static final PetrifiedBoatItem PETRIFIED_BOAT = new PetrifiedBoatItem(false, new FabricItemSettings().maxCount(1));
    public static final PetrifiedBoatItem CHEST_PETRIFIED_BOAT = new PetrifiedBoatItem(true, new FabricItemSettings().maxCount(1));
    
    public static final Item LIROTH_BONE = createItem(new Item(new Item.Settings()), "liroth_bone");

    public static final Item LIROTH_DUST_ANSALUM = createItem(new Item(new Item.Settings()), "liroth_dust_ansalum");
    public static final Item LIROTH_DUST_LUX = createItem(new Item(new Item.Settings()), "liroth_dust_lux");
    public static final Item LIROTH_DUST_SALEM = createItem(new Item(new Item.Settings()), "liroth_dust_salem");
    
    public static final Item LIROTH_GEM = createItem(new Item(new Item.Settings()), "liroth_gem");
    public static final Item LIROTH_HORSE_ARMOR = createItem(new HorseArmorItem(9, "liroth", new Item.Settings()), "liroth_horse_armor");
    public static final Item LIROTH_GEM_DUST = createItem(new Item(new Item.Settings()), "liroth_gem_dust");
    public static final Item LIROTH_GEM_DUST_HEAP = createItem(new Item(new Item.Settings()), "liroth_gem_dust_heap");
    
    //It's got that extreme pulp of taking a big ass bite out of a lemon and the tanginess of blackberries while the taste itself is a strawberry metallic flavor
    public static final Item LIROTH_COATED_BREAD = createItem(new Item(new Item.Settings().food(FoodComponents.BREAD)), "liroth_coated_bread");
    
    public static final Item LIROTH_GEM_LUX = createItem(new Item(new Item.Settings()), "liroth_gem_lux");

    // HMMMMMMMMMMM
    public static final Item LIROTHIAN_DUNGEON_KEY = createItem(new KeyItem(new Item.Settings().maxDamage(1)), "lirothian_dungeon_key");
    
    public static final Item LIROTH_GEM_SALEM = createItem(new Item(new Item.Settings()), "liroth_gem_salem");
    
    public static final Item LIROTHIAN_COBALT_INGOT = createItem(new Item(new Item.Settings()), "lirothian_cobalt_ingot");
    public static final Item LIROTHIAN_COBALT_NUGGET = createItem(new Item(new Item.Settings()), "lirothian_cobalt_nugget");
    public static final Item LIROTHIAN_COBALT_HORSE_ARMOR = createItem(new HorseArmorItem(5, "lirothian_cobalt", new Item.Settings()), "lirothian_cobalt_horse_armor");
    public static final Item RAW_LIROTHIAN_COBALT = createItem(new Item(new Item.Settings()), "raw_lirothian_cobalt");

    public static final Item LIROTHIAN_PETROLEUM = createItem(new Item(new Item.Settings()), "lirothian_petroleum");
    
    public static final Item LIROTH_SHIELD = createShieldItem(new LirothShield(new Item.Settings().maxCount(1)), "liroth_shield");
    public static final Item ANSALUM_LIROTH_SHIELD = createAnsalumShieldItem(new AnsalumLirothShield(new Item.Settings().maxCount(1)), "ansalum_liroth_shield");
    public static final Item LUX_LIROTH_SHIELD = createLuxShieldItem(new LuxLirothShield(new Item.Settings().maxCount(1)), "lux_liroth_shield");
    public static final Item SALEM_LIROTH_SHIELD = createSalemShieldItem(new SalemLirothShield(new Item.Settings().maxCount(1)), "salem_liroth_shield");
    public static final Item QUANTUM_LIROTH_SHIELD = createQuantumShieldItem(new QuantumLirothShield(new Item.Settings().maxCount(1)), "quantum_liroth_shield");
    
    public static final Item LIROTH_SOUL_DUST = createItem(new Item(new Item.Settings()), "liroth_soul_dust");
    
//    public static final Item LIROTH_STAR = createItem(new Item(new Item.Settings()), "liroth_star");

    public static final Item LIROTH_TEAR = createItem(new Item(new Item.Settings()), "liroth_tear");
        
    public static final Item NETHERITE_HORSE_ARMOR = createItem(new HorseArmorItem(8, "netherite", new Item.Settings()), "netherite_horse_armor");
    
    public static final Item PURPETUATED_AMETHYST_SHARD = createItem(new Item(new Item.Settings()), "purpetuated_amethyst_shard");
//    public static final Item PURPETUATED_SPYGLASS = createItem(new PurpetuatedSpyglassItem(new Item.Settings().group(LirothCreativeTab.creativeTab)), "purpetuated_spyglass");
    
    public static final Item QUANTUM_DIAMOND = createItem(new Item(new Item.Settings()), "quantum_diamond");
    public static final Item QUANTUM_HORSE_ARMOR = createItem(new HorseArmorItem(10, "quantum", new Item.Settings()), "quantum_horse_armor");
    public static final Item QUANTUM_PLATE = createItem(new Item(new Item.Settings()), "quantum_plate");
    public static final Item RUBY = createItem(new Item(new Item.Settings()), "ruby");
    public static final Item RUBY_HORSE_ARMOR = createItem(new HorseArmorItem(7, "ruby", new Item.Settings()), "ruby_horse_armor");
    public static final Item POTESTIUM_SHARD = createItem(new Item(new Item.Settings()), "potestium_shard");
    public static final Item POTESTIUM_HORSE_ARMOR = createItem(new HorseArmorItem(10, "potestium", new Item.Settings()), "potestium_horse_armor");
    public static final Item POTESTIUM_PLATE = createItem(new Item(new Item.Settings()), "potestium_plate");
//    public static final Item SOUL_GLASS_BOTTLE = createItem(new Item(new Item.Settings()), "soul_glass_bottle");
    public static final Item SPINERIOS_STONE_PEBBLE = createItem(new Item(new Item.Settings()), "spinerios_stone_pebble");
    
    public static final Item TOURMALINE = createItem(new Item(new Item.Settings()), "tourmaline");
    public static final Item TOURMALINE_HORSE_ARMOR = createItem(new HorseArmorItem(8, "tourmaline", new Item.Settings()), "tourmaline_horse_armor");

    public static final Item LIROTH_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()), "liroth_helmet");
    public static final Item LIROTH_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()), "liroth_chestplate");
    public static final Item LIROTH_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()), "liroth_leggings");
    public static final Item LIROTH_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()), "liroth_boots");
    
    public static final Item LIROTHIAN_COBALT_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()), "lirothian_cobalt_helmet");
    public static final Item LIROTHIAN_COBALT_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()), "lirothian_cobalt_chestplate");
    public static final Item LIROTHIAN_COBALT_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()), "lirothian_cobalt_leggings");
    public static final Item LIROTHIAN_COBALT_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()), "lirothian_cobalt_boots");
    
    public static final Item ANSALUM_LIROTH_HELMET = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()), "ansalum_liroth_helmet");
    public static final Item ANSALUM_LIROTH_CHESTPLATE = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()), "ansalum_liroth_chestplate");
    public static final Item ANSALUM_LIROTH_LEGGINGS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()), "ansalum_liroth_leggings");
    public static final Item ANSALUM_LIROTH_BOOTS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()), "ansalum_liroth_boots");
    
    public static final Item ANSALUM_LIROTH_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.ANSALUM_LIROTH_TOOL_MATERIAL, 7.0f, -3.0f, new Item.Settings().fireproof()), "ansalum_liroth_axe");
    public static final Item LUX_LIROTH_KATANA = createToolItem(new SwordItem(LirothToolMaterials.LUX_LIROTH_TOOL_MATERIAL, 2, -1.4f, new Item.Settings().fireproof()), "lux_liroth_katana");
    public static final Item SALEM_LIROTH_FALCHION = createToolItem(new SwordItem(LirothToolMaterials.SALEM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Settings().fireproof()), "salem_liroth_falchion");
    
    public static final Item QUANTUM_LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Settings().fireproof()), "quantum_liroth_sword");
    public static final Item QUANTUM_LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().fireproof()), "quantum_liroth_shovel");
    public static final Item QUANTUM_LIROTH_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().fireproof()), "quantum_liroth_pickaxe");
    public static final Item QUANTUM_LIROTH_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().fireproof()), "quantum_liroth_axe");
    public static final Item QUANTUM_LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().fireproof()), "quantum_liroth_hoe");
    
    public static final Item LUX_LIROTH_HELMET = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()), "lux_liroth_helmet");
    public static final Item LUX_LIROTH_CHESTPLATE = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()), "lux_liroth_chestplate");
    public static final Item LUX_LIROTH_LEGGINGS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()), "lux_liroth_leggings");
    public static final Item LUX_LIROTH_BOOTS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()), "lux_liroth_boots");
    
    public static final Item SALEM_LIROTH_HELMET = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()), "salem_liroth_helmet");
    public static final Item SALEM_LIROTH_CHESTPLATE = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()), "salem_liroth_chestplate");
    public static final Item SALEM_LIROTH_LEGGINGS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()), "salem_liroth_leggings");
    public static final Item SALEM_LIROTH_BOOTS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()), "salem_liroth_boots");
    
    public static final Item QUANTUM_LIROTH_HELMET = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()), "quantum_liroth_helmet");
    public static final Item QUANTUM_LIROTH_CHESTPLATE = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()), "quantum_liroth_chestplate");
    public static final Item QUANTUM_LIROTH_LEGGINGS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()), "quantum_liroth_leggings");
    public static final Item QUANTUM_LIROTH_BOOTS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()), "quantum_liroth_boots");
    
    public static final Item POTESTIUM_LIROTH_HELMET = createArmorItem(new PotestiumHelmItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()), "potestium_liroth_helmet");
    public static final Item POTESTIUM_LIROTH_CHESTPLATE = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()), "potestium_liroth_chestplate");
    public static final Item POTESTIUM_LIROTH_LEGGINGS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()), "potestium_liroth_leggings");
    public static final Item POTESTIUM_LIROTH_BOOTS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()), "potestium_liroth_boots");
    
    public static final Item POTESTIUM_SCYTHE = createToolItem(new CustomScytheItem(LirothToolMaterials.POTESTIUM_LIROTH_TOOL_MATERIAL, LirothItems.scytheDamage, 0.0f, new Item.Settings().fireproof()), "potestium_scythe");
    
    public static final Item LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().fireproof()), "liroth_sword");
    public static final Item LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().fireproof()), "liroth_shovel");
    public static final Item LIROTH_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().fireproof()), "liroth_pickaxe");
    public static final Item LIROTH_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().fireproof()), "liroth_axe");
    public static final Item LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().fireproof()), "liroth_hoe");
    
    public static final Item LIROTHIAN_COBALT_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 3, -2.4f, new Item.Settings()), "lirothian_cobalt_sword");
    public static final Item LIROTHIAN_COBALT_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings()), "lirothian_cobalt_shovel");
    public static final Item LIROTHIAN_COBALT_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1, -2.8f, new Item.Settings()), "lirothian_cobalt_pickaxe");
    public static final Item LIROTHIAN_COBALT_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings()), "lirothian_cobalt_axe");
    public static final Item LIROTHIAN_COBALT_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, -4, 0.0f, new Item.Settings()), "lirothian_cobalt_hoe");
    
    public static final Item TOURMALINE_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()), "tourmaline_helmet");
    public static final Item TOURMALINE_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()), "tourmaline_chestplate");
    public static final Item TOURMALINE_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()), "tourmaline_leggings");
    public static final Item TOURMALINE_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()), "tourmaline_boots");
    
    public static final Item TOURMALINE_SWORD = createToolItem(new SwordItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().fireproof()), "tourmaline_sword");
    public static final Item TOURMALINE_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().fireproof()), "tourmaline_shovel");
    public static final Item TOURMALINE_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().fireproof()), "tourmaline_pickaxe");
    public static final Item TOURMALINE_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().fireproof()), "tourmaline_axe");
    public static final Item TOURMALINE_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().fireproof()), "tourmaline_hoe");
    
    public static final Item RUBY_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()), "ruby_helmet");
    public static final Item RUBY_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()), "ruby_chestplate");
    public static final Item RUBY_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()), "ruby_leggings");
    public static final Item RUBY_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()), "ruby_boots");
    
    public static final Item RUBY_SWORD = createToolItem(new SwordItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 3, -2.4f, new Item.Settings()), "ruby_sword");
    public static final Item RUBY_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings()), "ruby_shovel");
    public static final Item RUBY_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1, -2.8f, new Item.Settings()), "ruby_pickaxe");
    public static final Item RUBY_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings()), "ruby_axe");
    public static final Item RUBY_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, -3, 0.0f, new Item.Settings()), "ruby_hoe");
    
    public static final Item UNOBTAINABLE_FORSAKEN_CORPSE_SPAWN_EGG = createUnusedItem(new SpawnEggItem(LirothEntities.FORSAKEN_CORPSE, 1842204, 10551525, new Item.Settings()), "unobtainable_forsaken_corpse_spawn_egg");
    
    private static Item createArmorItem(ArmorItem armorItem, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), armorItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(armorItem);
      return armorItem;
	}
    
    private static Item createShieldItem(LirothShield shieldItem, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createAnsalumShieldItem(AnsalumLirothShield shieldItem, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createLuxShieldItem(LuxLirothShield shieldItem, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createSalemShieldItem(SalemLirothShield shieldItem, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createQuantumShieldItem(QuantumLirothShield shieldItem, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createToolItem(ToolItem toolItem, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), toolItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(toolItem);
      return toolItem;
	}
    
    private static Item createRangedItem(LirothBlaster blasterItem, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), blasterItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(blasterItem);
      return blasterItem;
	}

	public static Item createItem(Item item, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), item);
//        item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        ITEMS.add(item);
        return item;
    }
	
	public static Item createUnusedItem(Item item, String id) {
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, id), item);
//        item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
        UNUSED_ITEMS.add(item);
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
		LIROTH_FLUID_BUCKET = Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "liroth_fluid_bucket"), new BucketItem(LirothFluids.LIROTH_FLUID_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
		MOLTEN_SPINERIOS_BUCKET = Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "molten_spinerios_bucket"), new BucketItem(LirothFluids.MOLTEN_SPINERIOS_STILL, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "liroth_boat"), LirothItems.LIROTH_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "chest_liroth_boat"), LirothItems.CHEST_LIROTH_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "damnation_boat"), LirothItems.DAMNATION_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "chest_damnation_boat"), LirothItems.CHEST_DAMNATION_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "spiced_boat"), LirothItems.SPICED_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "chest_spiced_boat"), LirothItems.CHEST_SPICED_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "pier_boat"), LirothItems.PIER_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "chest_pier_boat"), LirothItems.CHEST_PIER_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "japz_boat"), LirothItems.JAPZ_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "chest_japz_boat"), LirothItems.CHEST_JAPZ_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "koolaw_boat"), LirothItems.KOOLAW_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "chest_koolaw_boat"), LirothItems.CHEST_KOOLAW_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "petrified_boat"), LirothItems.PETRIFIED_BOAT);
        Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "chest_petrified_boat"), LirothItems.CHEST_PETRIFIED_BOAT);
	    Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "fungal_torch"), new VerticallyAttachableBlockItem(LirothBlocks.FUNGAL_TORCH, LirothBlocks.WALL_FUNGAL_TORCH, new Item.Settings(), Direction.DOWN));
	    Registry.register(Registries.ITEM, new Identifier(Liroth.MOD_ID, "lirothian_petroleum_torch"), new VerticallyAttachableBlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_TORCH, LirothBlocks.WALL_LIROTHIAN_PETROLEUM_TORCH, new Item.Settings(), Direction.DOWN));
    }

	public static List<Item> getItems() {
		return ITEMS;
	}
	
	public static List<Item> getCombatItems() {
		return COMBAT_ITEMS;
	}
}