package com.decodinator.liroth.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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
    public static final DamnationBoatItem DAMNATION_BOAT = new DamnationBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final SpicedBoatItem SPICED_BOAT = new SpicedBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final PierBoatItem PIER_BOAT = new PierBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final JapzBoatItem JAPZ_BOAT = new JapzBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final KoolawBoatItem KOOLAW_BOAT = new KoolawBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    public static final PetrifiedBoatItem PETRIFIED_BOAT = new PetrifiedBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).maxCount(1));
    
    public static final Item LIROTH_BONE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_bone");

    public static final Item LIROTH_DUST_ANSALUM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_dust_ansalum");
    public static final Item LIROTH_DUST_LUX = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_dust_lux");
    public static final Item LIROTH_DUST_SALEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_dust_salem");
    
    public static final Item LIROTH_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem");
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
        
    public static final Item PURPETUATED_AMETHYST_SHARD = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "purpetuated_amethyst_shard");
//    public static final Item PURPETUATED_SPYGLASS = createItem(new PurpetuatedSpyglassItem(new Item.Settings().group(LirothCreativeTab.creativeTab)), "purpetuated_spyglass");
    
    public static final Item QUANTUM_DIAMOND = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "quantum_diamond");
    
    public static final Item QUANTUM_PLATE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "quantum_plate");
    public static final Item RUBY = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "ruby");
    public static final Item POTESTIUM_SHARD = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "potestium_shard");
//    public static final Item SOUL_GLASS_BOTTLE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "soul_glass_bottle");
    public static final Item SPINERIOS_STONE_PEBBLE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "spinerios_stone_pebble");
    
    public static final Item TOURMALINE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "tourmaline");
        
    public static final Item LIROTH_HELMET = createArmorItem(new ArmorItem(Liroth.LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_helmet");
    public static final Item LIROTH_CHESTPLATE = createArmorItem(new ArmorItem(Liroth.LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_chestplate");
    public static final Item LIROTH_LEGGINGS = createArmorItem(new ArmorItem(Liroth.LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_leggings");
    public static final Item LIROTH_BOOTS = createArmorItem(new ArmorItem(Liroth.LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_boots");
    
    public static final Item LIROTHIAN_COBALT_HELMET = createArmorItem(new ArmorItem(Liroth.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_helmet");
    public static final Item LIROTHIAN_COBALT_CHESTPLATE = createArmorItem(new ArmorItem(Liroth.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_chestplate");
    public static final Item LIROTHIAN_COBALT_LEGGINGS = createArmorItem(new ArmorItem(Liroth.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_leggings");
    public static final Item LIROTHIAN_COBALT_BOOTS = createArmorItem(new ArmorItem(Liroth.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lirothian_cobalt_boots");
    
    public static final Item ANSALUM_LIROTH_HELMET = createArmorItem(new AnsalumArmorItem(Liroth.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ansalum_liroth_helmet");
    public static final Item ANSALUM_LIROTH_CHESTPLATE = createArmorItem(new AnsalumArmorItem(Liroth.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ansalum_liroth_chestplate");
    public static final Item ANSALUM_LIROTH_LEGGINGS = createArmorItem(new AnsalumArmorItem(Liroth.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ansalum_liroth_leggings");
    public static final Item ANSALUM_LIROTH_BOOTS = createArmorItem(new AnsalumArmorItem(Liroth.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "ansalum_liroth_boots");
    
    public static final Item ANSALUM_LIROTH_AXE = createToolItem(new CustomAxeItem(Liroth.ANSALUM_LIROTH_TOOL_MATERIAL, 7.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "ansalum_liroth_axe");
    public static final Item LUX_LIROTH_KATANA = createToolItem(new SwordItem(Liroth.LUX_LIROTH_TOOL_MATERIAL, 2, -1.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "lux_liroth_katana");
    public static final Item SALEM_LIROTH_FALCHION = createToolItem(new SwordItem(Liroth.SALEM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "salem_liroth_falchion");
    
    public static final Item QUANTUM_LIROTH_SWORD = createToolItem(new SwordItem(Liroth.QUANTUM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_sword");
    public static final Item QUANTUM_LIROTH_SHOVEL = createToolItem(new ShovelItem(Liroth.QUANTUM_LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_shovel");
    public static final Item QUANTUM_LIROTH_PICKAXE = createToolItem(new CustomPickaxeItem(Liroth.QUANTUM_LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_pickaxe");
    public static final Item QUANTUM_LIROTH_AXE = createToolItem(new CustomAxeItem(Liroth.QUANTUM_LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_axe");
    public static final Item QUANTUM_LIROTH_HOE = createToolItem(new CustomHoeItem(Liroth.QUANTUM_LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "quantum_liroth_hoe");
    
    public static final Item LUX_LIROTH_HELMET = createArmorItem(new LuxArmorItem(Liroth.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lux_liroth_helmet");
    public static final Item LUX_LIROTH_CHESTPLATE = createArmorItem(new LuxArmorItem(Liroth.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lux_liroth_chestplate");
    public static final Item LUX_LIROTH_LEGGINGS = createArmorItem(new LuxArmorItem(Liroth.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lux_liroth_leggings");
    public static final Item LUX_LIROTH_BOOTS = createArmorItem(new LuxArmorItem(Liroth.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "lux_liroth_boots");
    
    public static final Item SALEM_LIROTH_HELMET = createArmorItem(new SalemArmorItem(Liroth.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "salem_liroth_helmet");
    public static final Item SALEM_LIROTH_CHESTPLATE = createArmorItem(new SalemArmorItem(Liroth.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "salem_liroth_chestplate");
    public static final Item SALEM_LIROTH_LEGGINGS = createArmorItem(new SalemArmorItem(Liroth.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "salem_liroth_leggings");
    public static final Item SALEM_LIROTH_BOOTS = createArmorItem(new SalemArmorItem(Liroth.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "salem_liroth_boots");
    
    public static final Item QUANTUM_LIROTH_HELMET = createArmorItem(new QuantumArmorItem(Liroth.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "quantum_liroth_helmet");
    public static final Item QUANTUM_LIROTH_CHESTPLATE = createArmorItem(new QuantumArmorItem(Liroth.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "quantum_liroth_chestplate");
    public static final Item QUANTUM_LIROTH_LEGGINGS = createArmorItem(new QuantumArmorItem(Liroth.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "quantum_liroth_leggings");
    public static final Item QUANTUM_LIROTH_BOOTS = createArmorItem(new QuantumArmorItem(Liroth.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "quantum_liroth_boots");
    
    public static final Item POTESTIUM_LIROTH_HELMET = createArmorItem(new PotestiumHelmItem(Liroth.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "potestium_liroth_helmet");
    public static final Item POTESTIUM_LIROTH_CHESTPLATE = createArmorItem(new PotestiumArmorItem(Liroth.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "potestium_liroth_chestplate");
    public static final Item POTESTIUM_LIROTH_LEGGINGS = createArmorItem(new PotestiumArmorItem(Liroth.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "potestium_liroth_leggings");
    public static final Item POTESTIUM_LIROTH_BOOTS = createArmorItem(new PotestiumArmorItem(Liroth.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "potestium_liroth_boots");
    
    public static final Item POTESTIUM_SCYTHE = createToolItem(new CustomHoeItem(Liroth.QUANTUM_LIROTH_TOOL_MATERIAL, 3, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "potestium_scythe");
    
    public static final Item LIROTH_SWORD = createToolItem(new SwordItem(Liroth.LIROTH_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_sword");
    public static final Item LIROTH_SHOVEL = createToolItem(new ShovelItem(Liroth.LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_shovel");
    public static final Item LIROTH_PICKAXE = createToolItem(new CustomPickaxeItem(Liroth.LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_pickaxe");
    public static final Item LIROTH_AXE = createToolItem(new CustomAxeItem(Liroth.LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_axe");
    public static final Item LIROTH_HOE = createToolItem(new CustomHoeItem(Liroth.LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_hoe");
    
    public static final Item LIROTHIAN_COBALT_SWORD = createToolItem(new SwordItem(Liroth.LIROTHIAN_COBALT_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "lirothian_cobalt_sword");
    public static final Item LIROTHIAN_COBALT_SHOVEL = createToolItem(new ShovelItem(Liroth.LIROTHIAN_COBALT_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "lirothian_cobalt_shovel");
    public static final Item LIROTHIAN_COBALT_PICKAXE = createToolItem(new CustomPickaxeItem(Liroth.LIROTHIAN_COBALT_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "lirothian_cobalt_pickaxe");
    public static final Item LIROTHIAN_COBALT_AXE = createToolItem(new CustomAxeItem(Liroth.LIROTHIAN_COBALT_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "lirothian_cobalt_axe");
    public static final Item LIROTHIAN_COBALT_HOE = createToolItem(new CustomHoeItem(Liroth.LIROTHIAN_COBALT_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "lirothian_cobalt_hoe");
    
    public static final Item TOURMALINE_HELMET = createArmorItem(new ArmorItem(Liroth.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_helmet");
    public static final Item TOURMALINE_CHESTPLATE = createArmorItem(new ArmorItem(Liroth.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_chestplate");
    public static final Item TOURMALINE_LEGGINGS = createArmorItem(new ArmorItem(Liroth.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_leggings");
    public static final Item TOURMALINE_BOOTS = createArmorItem(new ArmorItem(Liroth.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_boots");
    
    public static final Item TOURMALINE_SWORD = createToolItem(new SwordItem(Liroth.TOURMALINE_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_sword");
    public static final Item TOURMALINE_SHOVEL = createToolItem(new ShovelItem(Liroth.TOURMALINE_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_shovel");
    public static final Item TOURMALINE_PICKAXE = createToolItem(new CustomPickaxeItem(Liroth.TOURMALINE_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_pickaxe");
    public static final Item TOURMALINE_AXE = createToolItem(new CustomAxeItem(Liroth.TOURMALINE_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_axe");
    public static final Item TOURMALINE_HOE = createToolItem(new CustomHoeItem(Liroth.TOURMALINE_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_hoe");
    


    private static Item createArmorItem(ArmorItem armorItem, String id) {
        Registry.register(Registry.ITEM, new Identifier(Liroth.MOD_ID, id), armorItem);
//      item.setRegistryName(new Identifier(BYG.MOD_ID, id)); //Forge
      itemsList.add(armorItem);
      return armorItem;
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

    public static void init() {

    }
}