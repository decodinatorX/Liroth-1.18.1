package com.decodinator.liroth.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodConstants;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TieredItem;

import java.util.ArrayList;
import java.util.List;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.helpers.PotestiumHelmItem;
import com.decodinator.liroth.core.items.AnsalumArmorItem;
import com.decodinator.liroth.core.items.AnsalumLirothShield;
import com.decodinator.liroth.core.items.BeamItem;
import com.decodinator.liroth.core.items.CustomHoeItem;
import com.decodinator.liroth.core.items.CustomScytheItem;
import com.decodinator.liroth.core.items.KeyItem;
import com.decodinator.liroth.core.items.LirothBlaster;
import com.decodinator.liroth.core.items.LirothBoatItem;
import com.decodinator.liroth.core.items.LirothShield;
import com.decodinator.liroth.core.items.LuxArmorItem;
import com.decodinator.liroth.core.items.LuxLirothShield;
import com.decodinator.liroth.core.items.PotestiumArmorItem;
import com.decodinator.liroth.core.items.QuantumArmorItem;
import com.decodinator.liroth.core.items.QuantumLirothShield;
import com.decodinator.liroth.core.items.SalemArmorItem;
import com.decodinator.liroth.core.items.SalemLirothShield;
import com.decodinator.liroth.core.items.UnusedItem;

public class LirothItems {

	public static Item LIROTH_FLUID_BUCKET;
	public static Item MOLTEN_SPINERIOS_BUCKET;
	
	private static int scytheDamage = getScytheDamage();
	
    public static List<Item> ITEMS = new ArrayList<>();
    public static List<Item> UNUSED_ITEMS = new ArrayList<>();
    public static List<Item> COMBAT_ITEMS = new ArrayList<>();
    
    public static final Item ANOMALY_CHARGE = createItem(new UnusedItem(new Item.Properties().tab(Liroth.creativeItemsTab)), "anomaly_charge");
    
//    public static final Item TEMPLATE = createItem(new Item(new Item.Properties().tab(Liroth.creativeTab)), "template");
    
    public static final Item BLOODY_ENTRAILS = createItem(new Item(new Item.Properties().food(Foods.ROTTEN_FLESH).tab(Liroth.creativeItemsTab)), "bloody_entrails");
    
    public static final Item COOL_BEAM = createItem(new BeamItem(new Item.Properties().tab(Liroth.creativeCombatTab)), "cool_beam");
    
//    public static final Item CORRUPTED_JALSPHIRE_GEM = createItem(new Item(new Item.Properties()), "corrupted_jalsphire_gem");
    
//    public static final Item CORRUPTED_LIROTH_GEM = createItem(new Item(new Item.Properties()), "corrupted_liroth_gem");
    
//    public static final Item CORRUPTED_LIROTH_STAR = createItem(new Item(new Item.Properties()), "corrupted_liroth_star");
    
//    public static final Item CORRUPTED_ROD = createItem(new Item(new Item.Properties().tab(Liroth.creativeTab)), "corrupted_rod"); IS NOW THE COOL BEAM
    
    public static final Item DAMNATION_CHARGE = createItem(new UnusedItem(new Item.Properties().tab(Liroth.creativeItemsTab)), "damnation_charge");
    
    public static final Item EMBUED_LIROTH_GEM = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "embued_liroth_gem");
    
    public static final Item GLEEMSTONE_DUST = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "gleemstone_dust");
   
    public static final Item JALSPHIRE_CHARGE = createItem(new UnusedItem(new Item.Properties().tab(Liroth.creativeItemsTab)), "jalsphire_charge");
    public static final Item JALSPHIRE_DUST = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "jalsphire_dust");
    public static final Item JALSPHIRE_DUST_HEAP = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "jalsphire_dust_heap");
    public static final Item JALSPHIRE_GEM = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "jalsphire_gem");
    
    public static final Item JANTIRO_CHARGE = createItem(new UnusedItem(new Item.Properties().tab(Liroth.creativeItemsTab)), "jantiro_charge");
    
    public static final Item LIROTH_GEM_ANSALUM = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_gem_ansalum");

    public static final Item LIROTH_BERRY = createItem(new Item(new Item.Properties().food(Foods.SUSPICIOUS_STEW).tab(Liroth.creativeItemsTab)), "liroth_berry");

    public static final Item LIROTH_BLASTER = createRangedItem(new LirothBlaster(new Item.Properties().stacksTo(1).tab(Liroth.creativeCombatTab)), "liroth_blaster");
    public static final Item LIROTH_CHARGE = createItem(new UnusedItem(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_charge");

    public static final Item LIROTH_BOAT = createBoatItem("liroth_boat", LirothBoat.LirothType.LIROTH);
    public static final Item CHEST_LIROTH_BOAT = createChestBoatItem("chest_liroth_boat", LirothBoat.LirothType.LIROTH);
    public static final Item DAMNATION_BOAT = createBoatItem("damnation_boat", LirothBoat.LirothType.DAMNATION);
    public static final Item CHEST_DAMNATION_BOAT = createChestBoatItem("chest_damnation_boat", LirothBoat.LirothType.DAMNATION);
    public static final Item SPICED_BOAT = createBoatItem("spiced_boat", LirothBoat.LirothType.SPICED);
    public static final Item CHEST_SPICED_BOAT = createChestBoatItem("chest_spiced_boat", LirothBoat.LirothType.SPICED);
    public static final Item PIER_BOAT = createBoatItem("pier_boat", LirothBoat.LirothType.PIER);
    public static final Item CHEST_PIER_BOAT = createChestBoatItem("chest_pier_boat", LirothBoat.LirothType.PIER);
    public static final Item JAPZ_BOAT = createBoatItem("japz_boat", LirothBoat.LirothType.JAPZ);
    public static final Item CHEST_JAPZ_BOAT = createChestBoatItem("chest_japz_boat", LirothBoat.LirothType.JAPZ);
    public static final Item KOOLAW_BOAT = createBoatItem("koolaw_boat", LirothBoat.LirothType.KOOLAW);
    public static final Item CHEST_KOOLAW_BOAT = createChestBoatItem("chest_koolaw_boat", LirothBoat.LirothType.KOOLAW);
    public static final Item PETRIFIED_BOAT = createBoatItem("petrified_boat", LirothBoat.LirothType.PETRIFIED);
    public static final Item CHEST_PETRIFIED_BOAT = createChestBoatItem("chest_petrified_boat", LirothBoat.LirothType.PETRIFIED);
   
    public static final Item LIROTH_BONE = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_bone");

    public static final Item LIROTH_DUST_ANSALUM = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_dust_ansalum");
    public static final Item LIROTH_DUST_LUX = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_dust_lux");
    public static final Item LIROTH_DUST_SALEM = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_dust_salem");
    
    public static final Item LIROTH_GEM = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_gem");
    public static final Item LIROTH_HORSE_ARMOR = createItem(new HorseArmorItem(9, "liroth", new Item.Properties().tab(Liroth.creativeCombatTab)), "liroth_horse_armor");
    public static final Item LIROTH_GEM_DUST = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_gem_dust");
    public static final Item LIROTH_GEM_DUST_HEAP = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_gem_dust_heap");
    
    //It's got that extreme pulp of taking a big ass bite out of a lemon and the tanginess of blackberries while the taste itself is a strawberry metallic flavor
    public static final Item LIROTH_COATED_BREAD = createItem(new Item(new Item.Properties().food(Foods.BREAD).tab(Liroth.creativeItemsTab)), "liroth_coated_bread");
    
    public static final Item LIROTH_GEM_LUX = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_gem_lux");

    // HMMMMMMMMMMM
    public static final Item LIROTHIAN_DUNGEON_KEY = createItem(new KeyItem(new Item.Properties().defaultDurability(1).tab(Liroth.creativeItemsTab)), "lirothian_dungeon_key");
    
    public static final Item LIROTH_GEM_SALEM = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_gem_salem");
    
    public static final Item LIROTHIAN_COBALT_INGOT = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "lirothian_cobalt_ingot");
    public static final Item LIROTHIAN_COBALT_NUGGET = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "lirothian_cobalt_nugget");
    public static final Item LIROTHIAN_COBALT_HORSE_ARMOR = createItem(new HorseArmorItem(5, "lirothian_cobalt", new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_horse_armor");
    public static final Item RAW_LIROTHIAN_COBALT = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "raw_lirothian_cobalt");

    public static final Item LIROTHIAN_PETROLEUM = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "lirothian_petroleum");
    
    public static final Item LIROTH_SHIELD = createShieldItem(new LirothShield(new Item.Properties().stacksTo(1).tab(Liroth.creativeCombatTab)), "liroth_shield");
    public static final Item ANSALUM_LIROTH_SHIELD = createAnsalumShieldItem(new AnsalumLirothShield(new Item.Properties().stacksTo(1).tab(Liroth.creativeCombatTab)), "ansalum_liroth_shield");
    public static final Item LUX_LIROTH_SHIELD = createLuxShieldItem(new LuxLirothShield(new Item.Properties().stacksTo(1).tab(Liroth.creativeCombatTab)), "lux_liroth_shield");
    public static final Item SALEM_LIROTH_SHIELD = createSalemShieldItem(new SalemLirothShield(new Item.Properties().stacksTo(1).tab(Liroth.creativeCombatTab)), "salem_liroth_shield");
    public static final Item QUANTUM_LIROTH_SHIELD = createQuantumShieldItem(new QuantumLirothShield(new Item.Properties().stacksTo(1).tab(Liroth.creativeCombatTab)), "quantum_liroth_shield");
    
    public static final Item LIROTH_SOUL_DUST = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_soul_dust");
    
//    public static final Item LIROTH_STAR = createItem(new Item(new Item.Properties()), "liroth_star");

    public static final Item LIROTH_TEAR = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "liroth_tear");
        
    public static final Item NETHERITE_HORSE_ARMOR = createItem(new HorseArmorItem(8, "netherite", new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)), "netherite_horse_armor");
    
    public static final Item PURPETUATED_AMETHYST_SHARD = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "purpetuated_amethyst_shard");
//    public static final Item PURPETUATED_SPYGLASS = createItem(new PurpetuatedSpyglassItem(new Item.Properties().tab(Liroth.creativeTab)), "purpetuated_spyglass");
    
    public static final Item QUANTUM_DIAMOND = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "quantum_diamond");
    public static final Item QUANTUM_HORSE_ARMOR = createItem(new HorseArmorItem(10, "quantum", new Item.Properties().tab(Liroth.creativeCombatTab)), "quantum_horse_armor");
    public static final Item QUANTUM_PLATE = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "quantum_plate");
    public static final Item RUBY = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "ruby");
    public static final Item RUBY_HORSE_ARMOR = createItem(new HorseArmorItem(7, "ruby", new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_horse_armor");
    public static final Item POTESTIUM_SHARD = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "potestium_shard");
    public static final Item POTESTIUM_HORSE_ARMOR = createItem(new HorseArmorItem(10, "potestium", new Item.Properties().tab(Liroth.creativeCombatTab)), "potestium_horse_armor");
    public static final Item POTESTIUM_PLATE = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "potestium_plate");
//    public static final Item SOUL_GLASS_BOTTLE = createItem(new Item(new Item.Properties()), "soul_glass_bottle");
    public static final Item SPINERIOS_STONE_PEBBLE = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "spinerios_stone_pebble");
    
    public static final Item TOURMALINE = createItem(new Item(new Item.Properties().tab(Liroth.creativeItemsTab)), "tourmaline");
    public static final Item TOURMALINE_HORSE_ARMOR = createItem(new HorseArmorItem(8, "tourmaline", new Item.Properties().tab(Liroth.creativeCombatTab)), "tourmaline_horse_armor");

    public static final Item LIROTH_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.creativeCombatTab)), "liroth_helmet");
    public static final Item LIROTH_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.creativeCombatTab)), "liroth_chestplate");
    public static final Item LIROTH_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.creativeCombatTab)), "liroth_leggings");
    public static final Item LIROTH_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.creativeCombatTab)), "liroth_boots");
    
    public static final Item LIROTHIAN_COBALT_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_helmet");
    public static final Item LIROTHIAN_COBALT_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_chestplate");
    public static final Item LIROTHIAN_COBALT_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_leggings");
    public static final Item LIROTHIAN_COBALT_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_boots");
    
    public static final Item ANSALUM_LIROTH_HELMET = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.creativeCombatTab)), "ansalum_liroth_helmet");
    public static final Item ANSALUM_LIROTH_CHESTPLATE = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.creativeCombatTab)), "ansalum_liroth_chestplate");
    public static final Item ANSALUM_LIROTH_LEGGINGS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.creativeCombatTab)), "ansalum_liroth_leggings");
    public static final Item ANSALUM_LIROTH_BOOTS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.creativeCombatTab)), "ansalum_liroth_boots");
    
    public static final Item ANSALUM_LIROTH_AXE = createToolItem(new AxeItem(LirothToolMaterials.ANSALUM_LIROTH_TOOL_MATERIAL, 7.0f, -3.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "ansalum_liroth_axe");
    public static final Item LUX_LIROTH_KATANA = createToolItem(new SwordItem(LirothToolMaterials.LUX_LIROTH_TOOL_MATERIAL, 2, -1.4f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "lux_liroth_katana");
    public static final Item SALEM_LIROTH_FALCHION = createToolItem(new SwordItem(LirothToolMaterials.SALEM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "salem_liroth_falchion");
    
    public static final Item QUANTUM_LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "quantum_liroth_sword");
    public static final Item QUANTUM_LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "quantum_liroth_shovel");
    public static final Item QUANTUM_LIROTH_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "quantum_liroth_pickaxe");
    public static final Item QUANTUM_LIROTH_AXE = createToolItem(new AxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "quantum_liroth_axe");
    public static final Item QUANTUM_LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "quantum_liroth_hoe");
    
    public static final Item LUX_LIROTH_HELMET = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.creativeCombatTab)), "lux_liroth_helmet");
    public static final Item LUX_LIROTH_CHESTPLATE = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.creativeCombatTab)), "lux_liroth_chestplate");
    public static final Item LUX_LIROTH_LEGGINGS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.creativeCombatTab)), "lux_liroth_leggings");
    public static final Item LUX_LIROTH_BOOTS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.creativeCombatTab)), "lux_liroth_boots");
    
    public static final Item SALEM_LIROTH_HELMET = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.creativeCombatTab)), "salem_liroth_helmet");
    public static final Item SALEM_LIROTH_CHESTPLATE = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.creativeCombatTab)), "salem_liroth_chestplate");
    public static final Item SALEM_LIROTH_LEGGINGS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.creativeCombatTab)), "salem_liroth_leggings");
    public static final Item SALEM_LIROTH_BOOTS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.creativeCombatTab)), "salem_liroth_boots");
    
    public static final Item QUANTUM_LIROTH_HELMET = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.creativeCombatTab)), "quantum_liroth_helmet");
    public static final Item QUANTUM_LIROTH_CHESTPLATE = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.creativeCombatTab)), "quantum_liroth_chestplate");
    public static final Item QUANTUM_LIROTH_LEGGINGS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.creativeCombatTab)), "quantum_liroth_leggings");
    public static final Item QUANTUM_LIROTH_BOOTS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.creativeCombatTab)), "quantum_liroth_boots");
    
    public static final Item POTESTIUM_LIROTH_HELMET = createArmorItem(new PotestiumHelmItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.creativeCombatTab)), "potestium_liroth_helmet");
    public static final Item POTESTIUM_LIROTH_CHESTPLATE = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.creativeCombatTab)), "potestium_liroth_chestplate");
    public static final Item POTESTIUM_LIROTH_LEGGINGS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.creativeCombatTab)), "potestium_liroth_leggings");
    public static final Item POTESTIUM_LIROTH_BOOTS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.creativeCombatTab)), "potestium_liroth_boots");
    
    public static final Item POTESTIUM_SCYTHE = createToolItem(new CustomScytheItem(LirothToolMaterials.POTESTIUM_LIROTH_TOOL_MATERIAL, LirothItems.scytheDamage, 0.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "potestium_scythe");
    
    public static final Item LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 3, -2.4f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "liroth_sword");
    public static final Item LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "liroth_shovel");
    public static final Item LIROTH_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "liroth_pickaxe");
    public static final Item LIROTH_AXE = createToolItem(new AxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "liroth_axe");
    public static final Item LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "liroth_hoe");
    
    public static final Item LIROTHIAN_COBALT_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 3, -2.4f, new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_sword");
    public static final Item LIROTHIAN_COBALT_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_shovel");
    public static final Item LIROTHIAN_COBALT_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_pickaxe");
    public static final Item LIROTHIAN_COBALT_AXE = createToolItem(new AxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_axe");
    public static final Item LIROTHIAN_COBALT_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().tab(Liroth.creativeCombatTab)), "lirothian_cobalt_hoe");
    
    public static final Item TOURMALINE_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.creativeCombatTab)), "tourmaline_helmet");
    public static final Item TOURMALINE_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.creativeCombatTab)), "tourmaline_chestplate");
    public static final Item TOURMALINE_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.creativeCombatTab)), "tourmaline_leggings");
    public static final Item TOURMALINE_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.creativeCombatTab)), "tourmaline_boots");
    
    public static final Item TOURMALINE_SWORD = createToolItem(new SwordItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 3, -2.4f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "tourmaline_sword");
    public static final Item TOURMALINE_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "tourmaline_shovel");
    public static final Item TOURMALINE_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "tourmaline_pickaxe");
    public static final Item TOURMALINE_AXE = createToolItem(new AxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "tourmaline_axe");
    public static final Item TOURMALINE_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().fireResistant().tab(Liroth.creativeCombatTab)), "tourmaline_hoe");
    
    public static final Item RUBY_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_helmet");
    public static final Item RUBY_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_chestplate");
    public static final Item RUBY_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_leggings");
    public static final Item RUBY_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_boots");
    
    public static final Item RUBY_SWORD = createToolItem(new SwordItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 3, -2.4f, new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_sword");
    public static final Item RUBY_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_shovel");
    public static final Item RUBY_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_pickaxe");
    public static final Item RUBY_AXE = createToolItem(new AxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_axe");
    public static final Item RUBY_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, -3, 0.0f, new Item.Properties().tab(Liroth.creativeCombatTab)), "ruby_hoe");
    
    public static final Item UNOBTAINABLE_FORSAKEN_CORPSE_SPAWN_EGG = createUnusedItem(new SpawnEggItem(LirothEntities.FORSAKEN_CORPSE, 1842204, 10551525, new Item.Properties()), "unobtainable_forsaken_corpse_spawn_egg");
    
    private static Item createArmorItem(ArmorItem armorItem, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), armorItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(armorItem);
      return armorItem;
	}
    
    private static Item createShieldItem(LirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createAnsalumShieldItem(AnsalumLirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createLuxShieldItem(LuxLirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createSalemShieldItem(SalemLirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createQuantumShieldItem(QuantumLirothShield shieldItem, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createToolItem(TieredItem toolItem, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), toolItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(toolItem);
      return toolItem;
	}
    
    private static Item createRangedItem(LirothBlaster blasterItem, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), blasterItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(blasterItem);
      return blasterItem;
	}
    
    static Item createBoatItem(String id, LirothBoat.LirothType type) {
		Item createItem = Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), new LirothBoatItem(false, type, new Item.Properties().tab(Liroth.creativeItemsTab)));
		ITEMS.add(createItem);
		return createItem;    
    }
    
    static Item createChestBoatItem(String id, LirothBoat.LirothType type) {
		Item createItem = Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), new LirothBoatItem(true, type, new Item.Properties().tab(Liroth.creativeItemsTab)));
		ITEMS.add(createItem);
		return createItem;    
    }

	public static Item createItem(Item item, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), item);
//        item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        ITEMS.add(item);
        return item;
    }
	
	public static Item createUnusedItem(Item item, String id) {
        Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, id), item);
//        item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
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
		LIROTH_FLUID_BUCKET = Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, "liroth_fluid_bucket"), new BucketItem(LirothFluids.LIROTH_FLUID_STILL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(Liroth.creativeItemsTab)));
		MOLTEN_SPINERIOS_BUCKET = Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, "molten_spinerios_bucket"), new BucketItem(LirothFluids.MOLTEN_SPINERIOS_STILL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(Liroth.creativeItemsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, "fungal_torch"), new StandingAndWallBlockItem(LirothBlocks.FUNGAL_TORCH, LirothBlocks.WALL_FUNGAL_TORCH, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation(Liroth.MOD_ID, "lirothian_petroleum_torch"), new StandingAndWallBlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_TORCH, LirothBlocks.WALL_LIROTHIAN_PETROLEUM_TORCH, new Item.Properties().tab(Liroth.creativeBlocksTab)));
    
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "anomaly"), new BlockItem(LirothBlocks.ANOMALY, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "anomaly_block"), new BlockItem(LirothBlocks.ANOMALY_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "blue_sand"), new BlockItem(LirothBlocks.BLUE_SAND, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "blue_sandstone"), new BlockItem(LirothBlocks.BLUE_SANDSTONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "blue_sandstone_slab"), new BlockItem(LirothBlocks.BLUE_SANDSTONE_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "blue_sandstone_stairs"), new BlockItem(LirothBlocks.BLUE_SANDSTONE_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "blue_sandstone_wall"), new BlockItem(LirothBlocks.BLUE_SANDSTONE_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "carved_blue_sandstone"), new BlockItem(LirothBlocks.CARVED_BLUE_SANDSTONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_accessway_block"), new BlockItem(LirothBlocks.CHARRED_ACCESSWAY_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_cobblestone"), new BlockItem(LirothBlocks.CHARRED_LIROTH_COBBLESTONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_cobblestone_slab"), new BlockItem(LirothBlocks.CHARRED_LIROTH_COBBLESTONE_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_cobblestone_stairs"), new BlockItem(LirothBlocks.CHARRED_LIROTH_COBBLESTONE_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_cobblestone_wall"), new BlockItem(LirothBlocks.CHARRED_LIROTH_COBBLESTONE_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_lirothian_liroth_gem_ore"), new BlockItem(LirothBlocks.CHARRED_LIROTH_GEM_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_stone"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_stone_slab"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_stone_stairs"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_stone_wall"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_stone_bricks"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_stone_brick_lock"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICK_LOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_stone_brick_slab"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICK_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_stone_brick_stairs"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICK_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "charred_liroth_stone_brick_wall"), new BlockItem(LirothBlocks.CHARRED_LIROTH_STONE_BRICK_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "chiseled_devastated_bricks"), new BlockItem(LirothBlocks.CHISELED_DEVASTATED_BRICKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "corrupted_brewing_stand"), new BlockItem(LirothBlocks.CORRUPTED_BREWING_STAND, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "corrupted_jalsphire_gem_block"), new BlockItem(LirothBlocks.CORRUPTED_JALSPHIRE_GEM_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "corrupted_jalsphire_ore"), new BlockItem(LirothBlocks.CORRUPTED_JALSPHIRE_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "corrupted_liroth_gem_block"), new BlockItem(LirothBlocks.CORRUPTED_LIROTH_GEM_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "corrupted_liroth_gem_ore"), new BlockItem(LirothBlocks.CORRUPTED_LIROTH_GEM_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_crafting_table"), new BlockItem(LirothBlocks.DAMNATION_CRAFTING_TABLE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_chest"), new BlockItem(LirothBlocks.DAMNATION_CHEST, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_door"), new BlockItem(LirothBlocks.DAMNATION_DOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_fence"), new BlockItem(LirothBlocks.DAMNATION_FENCE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_fungal_cluster"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_CLUSTER, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_fungus"), new BlockItem(LirothBlocks.DAMNATION_FUNGUS, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_fungal_carpet"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_CARPET, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_fungal_heap"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_HEAP, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_fungal_fuss"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_FUSS, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_fungal_patch"), new BlockItem(LirothBlocks.DAMNATION_FUNGAL_PATCH, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_leaves"), new BlockItem(LirothBlocks.DAMNATION_LEAVES, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_log"), new BlockItem(LirothBlocks.DAMNATION_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_wood"), new BlockItem(LirothBlocks.DAMNATION_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_planks"), new BlockItem(LirothBlocks.DAMNATION_PLANKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_sapling"), new BlockItem(LirothBlocks.DAMNATION_SAPLING, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_soil"), new BlockItem(LirothBlocks.DAMNATION_SOIL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_slab"), new BlockItem(LirothBlocks.DAMNATION_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_stairs"), new BlockItem(LirothBlocks.DAMNATION_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_trapdoor"), new BlockItem(LirothBlocks.DAMNATION_TRAPDOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_wart_block"), new BlockItem(LirothBlocks.DAMNATION_WART_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damnation_vines"), new BlockItem(LirothBlocks.DAMNATION_VINES, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "damned_passageway"), new BlockItem(LirothBlocks.DAMNED_PASSAGEWAY, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "deepslate_liroth_gem_ore"), new BlockItem(LirothBlocks.DEEPSLATE_LIROTH_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "devastated_brick_slab"), new BlockItem(LirothBlocks.DEVASTATED_BRICK_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "devastated_brick_stairs"), new BlockItem(LirothBlocks.DEVASTATED_BRICK_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "devastated_brick_wall"), new BlockItem(LirothBlocks.DEVASTATED_BRICK_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "devastated_bricks"), new BlockItem(LirothBlocks.DEVASTATED_BRICKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "devastated_pillar_block"), new BlockItem(LirothBlocks.DEVASTATED_PILLAR_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "dimensional_communicator"), new BlockItem(LirothBlocks.DIMENSIONAL_COMMUNICATOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "dimensional_communicator_off"), new BlockItem(LirothBlocks.DIMENSIONAL_COMMUNICATOR_OFF, new Item.Properties()));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "dimensional_communicator_on"), new BlockItem(LirothBlocks.DIMENSIONAL_COMMUNICATOR_ON, new Item.Properties()));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "end_liroth_gem_ore"), new BlockItem(LirothBlocks.END_LIROTH_GEM_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "forcefield"), new BlockItem(LirothBlocks.FORCEFIELD, new Item.Properties()));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "fungal_campfire"), new BlockItem(LirothBlocks.FUNGAL_CAMPFIRE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "fungal_lantern"), new BlockItem(LirothBlocks.FUNGAL_LANTERN, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "fungallight"), new BlockItem(LirothBlocks.FUNGAL_LIGHT, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "gateway_block"), new BlockItem(LirothBlocks.GATEWAY_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "gleemstone"), new BlockItem(LirothBlocks.GLEEMSTONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "haunted_throughfare_block"), new BlockItem(LirothBlocks.HAUNTED_THROUGHFARE_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "hilight"), new BlockItem(LirothBlocks.HILIGHT, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "jalsphire_gem_block"), new BlockItem(LirothBlocks.JALSPHIRE_GEM_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "jalsphire_ore"), new BlockItem(LirothBlocks.JALSPHIRE_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "jalsphire_stone_ore"), new BlockItem(LirothBlocks.JALSPHIRE_ORE_STONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "jalsphire_trackway"), new BlockItem(LirothBlocks.JALSPHIRE_TRACKWAY, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_blossom"), new BlockItem(LirothBlocks.JAPZ_BLOSSOM, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_chest"), new BlockItem(LirothBlocks.JAPZ_CHEST, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_crafting_table"), new BlockItem(LirothBlocks.JAPZ_CRAFTING_TABLE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_door"), new BlockItem(LirothBlocks.JAPZ_DOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_fence"), new BlockItem(LirothBlocks.JAPZ_FENCE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_leaves"), new BlockItem(LirothBlocks.JAPZ_LEAVES, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_log"), new BlockItem(LirothBlocks.JAPZ_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_mini_tree"), new BlockItem(LirothBlocks.JAPZ_MINI_TREE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_moss"), new BlockItem(LirothBlocks.JAPZ_MOSS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_moss_carpet"), new BlockItem(LirothBlocks.JAPZ_MOSS_CARPET, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_wood"), new BlockItem(LirothBlocks.JAPZ_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_planks"), new BlockItem(LirothBlocks.JAPZ_PLANKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_sapling"), new BlockItem(LirothBlocks.JAPZ_SAPLING, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_slab"), new BlockItem(LirothBlocks.JAPZ_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_stairs"), new BlockItem(LirothBlocks.JAPZ_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_trapdoor"), new BlockItem(LirothBlocks.JAPZ_TRAPDOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "japz_vines"), new BlockItem(LirothBlocks.JAPZ_VINES, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_chest"), new BlockItem(LirothBlocks.KOOLAW_CHEST, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_crafting_table"), new BlockItem(LirothBlocks.KOOLAW_CRAFTING_TABLE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_door"), new BlockItem(LirothBlocks.KOOLAW_DOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_fence"), new BlockItem(LirothBlocks.KOOLAW_FENCE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_leaves"), new BlockItem(LirothBlocks.KOOLAW_LEAVES, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_log"), new BlockItem(LirothBlocks.KOOLAW_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_wood"), new BlockItem(LirothBlocks.KOOLAW_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_planks"), new BlockItem(LirothBlocks.KOOLAW_PLANKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_sapling"), new BlockItem(LirothBlocks.KOOLAW_SAPLING, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_slab"), new BlockItem(LirothBlocks.KOOLAW_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_stairs"), new BlockItem(LirothBlocks.KOOLAW_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "koolaw_trapdoor"), new BlockItem(LirothBlocks.KOOLAW_TRAPDOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_bone_block"), new BlockItem(LirothBlocks.LIROTH_BONE_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_chest"), new BlockItem(LirothBlocks.LIROTH_CHEST, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_cobblestone"), new BlockItem(LirothBlocks.LIROTH_COBBLESTONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_cobblestone_stairs"), new BlockItem(LirothBlocks.LIROTH_COBBLESTONE_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_cobblestone_wall"), new BlockItem(LirothBlocks.LIROTH_COBBLESTONE_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_cobblestone_slab"), new BlockItem(LirothBlocks.LIROTH_COBBLESTONE_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_crafting_table"), new BlockItem(LirothBlocks.LIROTH_CRAFTING_TABLE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_dirt"), new BlockItem(LirothBlocks.LIROTH_DIRT, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_door"), new BlockItem(LirothBlocks.LIROTH_DOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_end_stone"), new BlockItem(LirothBlocks.LIROTH_END_STONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_fence"), new BlockItem(LirothBlocks.LIROTH_FENCE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_furnace"), new BlockItem(LirothBlocks.LIROTH_FURNACE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_gem_block"), new BlockItem(LirothBlocks.LIROTH_GEM_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_gem_ore"), new BlockItem(LirothBlocks.LIROTH_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_glass_block"), new BlockItem(LirothBlocks.LIROTH_GLASS_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_grass"), new BlockItem(LirothBlocks.LIROTH_GRASS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_grass_block"), new BlockItem(LirothBlocks.LIROTH_GRASS_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_grass_path"), new BlockItem(LirothBlocks.LIROTH_PATH_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_farmland"), new BlockItem(LirothBlocks.LIROTH_FARMLAND_BLOCK, new Item.Properties()));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_leaves"), new BlockItem(LirothBlocks.LIROTH_LEAVES, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_log"), new BlockItem(LirothBlocks.LIROTH_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_wood"), new BlockItem(LirothBlocks.LIROTH_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_planks"), new BlockItem(LirothBlocks.LIROTH_PLANKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_rose"), new BlockItem(LirothBlocks.LIROTH_ROSE, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_sapling"), new BlockItem(LirothBlocks.LIROTH_SAPLING, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_slab"), new BlockItem(LirothBlocks.LIROTH_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_soul_sand"), new BlockItem(LirothBlocks.LIROTH_SOUL_SAND, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_stairs"), new BlockItem(LirothBlocks.LIROTH_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_stone"), new BlockItem(LirothBlocks.LIROTH_STONE_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_stone_slab"), new BlockItem(LirothBlocks.LIROTH_STONE_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_stone_stairs"), new BlockItem(LirothBlocks.LIROTH_STONE_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_stone_wall"), new BlockItem(LirothBlocks.LIROTH_STONE_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_stone_bricks"), new BlockItem(LirothBlocks.LIROTH_STONE_BRICKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_stone_brick_slab"), new BlockItem(LirothBlocks.LIROTH_STONE_BRICK_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_stone_brick_stairs"), new BlockItem(LirothBlocks.LIROTH_STONE_BRICK_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_stone_brick_wall"), new BlockItem(LirothBlocks.LIROTH_STONE_BRICK_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_trapdoor"), new BlockItem(LirothBlocks.LIROTH_TRAPDOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "lirothian_liroth_ore"), new BlockItem(LirothBlocks.LIROTHIAN_LIROTH_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "lirothian_cobalt_block"), new BlockItem(LirothBlocks.LIROTHIAN_COBALT_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "lirothian_cobalt_door"), new BlockItem(LirothBlocks.LIROTHIAN_COBALT_DOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "lirothian_cobalt_ore"), new BlockItem(LirothBlocks.LIROTHIAN_COBALT_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "lirothian_cobalt_trapdoor"), new BlockItem(LirothBlocks.LIROTHIAN_COBALT_TRAPDOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "lirothian_petroleum_block"), new BlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "lirothian_petroleum_ore"), new BlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "lirothian_petroleum_lantern"), new BlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_LANTERN, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "lirothian_petroleum_campfire"), new BlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_CAMPFIRE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "nether_liroth_gem_ore"), new BlockItem(LirothBlocks.NETHER_LIROTH_GEM_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "olden_liroth_gem_block"), new BlockItem(LirothBlocks.OLDEN_LIROTH_GEM_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_crafting_table"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_CRAFTING_TABLE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_chest"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_CHEST, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_brick_slab"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_BRICK_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_brick_stairs"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_BRICK_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_brick_wall"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_BRICK_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_bricks"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_BRICKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_door"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_DOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_log"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_wood"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_planks"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_PLANKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_sapling"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_SAPLING, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_slab"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_stairs"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_trapdoor"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_TRAPDOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_damnation_fence"), new BlockItem(LirothBlocks.PETRIFIED_DAMNATION_FENCE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_crystal_block"), new BlockItem(LirothBlocks.PETRIFIED_CRYSTAL_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_moss_block"), new BlockItem(LirothBlocks.PETRIFIED_MOSS_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_moss_carpet"), new BlockItem(LirothBlocks.PETRIFIED_MOSS_CARPET, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_vines"), new BlockItem(LirothBlocks.PETRIFIED_VINES, new Item.Properties().tab(Liroth.creativePlantsTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "petrified_flower"), new BlockItem(LirothBlocks.PETRIFIED_FLOWER, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "pier_dirt"), new BlockItem(LirothBlocks.PIER_DIRT, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "pier_grass_block"), new BlockItem(LirothBlocks.PIER_GRASS_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "pier_farmland"), new BlockItem(LirothBlocks.PIER_FARMLAND_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "pier_grass_path"), new BlockItem(LirothBlocks.PIER_PATH_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "potestium_ore"), new BlockItem(LirothBlocks.POTESTIUM_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "potestium_block"), new BlockItem(LirothBlocks.POTESTIUM_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "potestium_plate_block"), new BlockItem(LirothBlocks.POTESTIUM_PLATE_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "quantum_diamond_ore"), new BlockItem(LirothBlocks.QUANTUM_DIAMOND_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "quantum_plate_block"), new BlockItem(LirothBlocks.QUANTUM_PLATE_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "redstone_broken_stage_1"), new BlockItem(LirothBlocks.REDSTONE_BROKEN_STAGE_1, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "redstone_broken_stage_2"), new BlockItem(LirothBlocks.REDSTONE_BROKEN_STAGE_2, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "redstone_broken_stage_3"), new BlockItem(LirothBlocks.REDSTONE_BROKEN_STAGE_3, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "raw_lirothian_cobalt_block"), new BlockItem(LirothBlocks.RAW_LIROTHIAN_COBALT_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "ruby_ore"), new BlockItem(LirothBlocks.RUBY_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "ruby_block"), new BlockItem(LirothBlocks.RUBY_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "sea_eye"), new BlockItem(LirothBlocks.SEA_EYE, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "smooth_blue_sandstone"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "smooth_blue_sandstone_slab"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "smooth_blue_sandstone_stairs"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "smooth_blue_sandstone_wall"), new BlockItem(LirothBlocks.SMOOTH_BLUE_SANDSTONE_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "soul_rod"), new BlockItem(LirothBlocks.SOUL_ROD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
//	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "soulless_flame"), new BlockItem(LirothBlocks.SOULLESS_FLAME, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "soulless_soil"), new BlockItem(LirothBlocks.SOULLESS_SOIL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_crafting_table"), new BlockItem(LirothBlocks.SPICED_CRAFTING_TABLE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_chest"), new BlockItem(LirothBlocks.SPICED_CHEST, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_door"), new BlockItem(LirothBlocks.SPICED_DOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_fence"), new BlockItem(LirothBlocks.SPICED_FENCE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_leaves"), new BlockItem(LirothBlocks.SPICED_LEAVES, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_log"), new BlockItem(LirothBlocks.SPICED_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_wood"), new BlockItem(LirothBlocks.SPICED_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_planks"), new BlockItem(LirothBlocks.SPICED_PLANKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_sapling"), new BlockItem(LirothBlocks.SPICED_SAPLING, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_slab"), new BlockItem(LirothBlocks.SPICED_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_stairs"), new BlockItem(LirothBlocks.SPICED_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spiced_trapdoor"), new BlockItem(LirothBlocks.SPICED_TRAPDOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_ancient_debris"), new BlockItem(LirothBlocks.SPINERIOS_ANCIENT_DEBRIS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_coal_ore"), new BlockItem(LirothBlocks.SPINERIOS_COAL_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_copper_ore"), new BlockItem(LirothBlocks.SPINERIOS_COPPER_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_cobblestone"), new BlockItem(LirothBlocks.SPINERIOS_COBBLESTONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_cobblestone_slab"), new BlockItem(LirothBlocks.SPINERIOS_COBBLESTONE_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_cobblestone_stairs"), new BlockItem(LirothBlocks.SPINERIOS_COBBLESTONE_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_cobblestone_wall"), new BlockItem(LirothBlocks.SPINERIOS_COBBLESTONE_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_diamond_ore"), new BlockItem(LirothBlocks.SPINERIOS_DIAMOND_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_dirt"), new BlockItem(LirothBlocks.SPINERIOS_DIRT, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_emerald_ore"), new BlockItem(LirothBlocks.SPINERIOS_EMERALD_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_furnace"), new BlockItem(LirothBlocks.SPINERIOS_FURNACE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_gold_ore"), new BlockItem(LirothBlocks.SPINERIOS_GOLD_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_grass_block"), new BlockItem(LirothBlocks.SPINERIOS_GRASS_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_farmland"), new BlockItem(LirothBlocks.SPINERIOS_FARMLAND_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_grass_path"), new BlockItem(LirothBlocks.SPINERIOS_PATH_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_iron_ore"), new BlockItem(LirothBlocks.SPINERIOS_IRON_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_lapis_ore"), new BlockItem(LirothBlocks.SPINERIOS_LAPIS_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_liroth_ore"), new BlockItem(LirothBlocks.SPINERIOS_LIROTH_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_quartz_ore"), new BlockItem(LirothBlocks.SPINERIOS_QUARTZ_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_redstone_ore"), new BlockItem(LirothBlocks.SPINERIOS_REDSTONE_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone"), new BlockItem(LirothBlocks.SPINERIOS_STONE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone_ore"), new BlockItem(LirothBlocks.SPINERIOS_STONE_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone_slab"), new BlockItem(LirothBlocks.SPINERIOS_STONE_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone_stairs"), new BlockItem(LirothBlocks.SPINERIOS_STONE_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone_wall"), new BlockItem(LirothBlocks.SPINERIOS_STONE_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone_bricks"), new BlockItem(LirothBlocks.SPINERIOS_STONE_BRICKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone_brick_slab"), new BlockItem(LirothBlocks.SPINERIOS_STONE_BRICK_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone_brick_stairs"), new BlockItem(LirothBlocks.SPINERIOS_STONE_BRICK_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone_brick_wall"), new BlockItem(LirothBlocks.SPINERIOS_STONE_BRICK_WALL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_liroth_log"), new BlockItem(LirothBlocks.STRIPPED_LIROTH_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_spiced_log"), new BlockItem(LirothBlocks.STRIPPED_SPICED_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_tallpier_log"), new BlockItem(LirothBlocks.STRIPPED_TALLPIER_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_damnation_log"), new BlockItem(LirothBlocks.STRIPPED_DAMNATION_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_japz_log"), new BlockItem(LirothBlocks.STRIPPED_JAPZ_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_koolaw_log"), new BlockItem(LirothBlocks.STRIPPED_KOOLAW_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_petrified_damnation_log"), new BlockItem(LirothBlocks.STRIPPED_PETRIFIED_DAMNATION_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_liroth_wood"), new BlockItem(LirothBlocks.STRIPPED_LIROTH_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_spiced_wood"), new BlockItem(LirothBlocks.STRIPPED_SPICED_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_tallpier_wood"), new BlockItem(LirothBlocks.STRIPPED_TALLPIER_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_damnation_wood"), new BlockItem(LirothBlocks.STRIPPED_DAMNATION_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_japz_wood"), new BlockItem(LirothBlocks.STRIPPED_JAPZ_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_koolaw_wood"), new BlockItem(LirothBlocks.STRIPPED_KOOLAW_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "stripped_petrified_damnation_wood"), new BlockItem(LirothBlocks.STRIPPED_PETRIFIED_DAMNATION_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_crafting_table"), new BlockItem(LirothBlocks.TALLPIER_CRAFTING_TABLE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_chest"), new BlockItem(LirothBlocks.TALLPIER_CHEST, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_door"), new BlockItem(LirothBlocks.TALLPIER_DOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_fence"), new BlockItem(LirothBlocks.TALLPIER_FENCE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_leaves"), new BlockItem(LirothBlocks.TALLPIER_LEAVES, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_log"), new BlockItem(LirothBlocks.TALLPIER_LOG, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_wood"), new BlockItem(LirothBlocks.TALLPIER_WOOD, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_planks"), new BlockItem(LirothBlocks.TALLPIER_PLANKS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_sapling"), new BlockItem(LirothBlocks.TALLPIER_SAPLING, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_slab"), new BlockItem(LirothBlocks.TALLPIER_SLAB, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_stairs"), new BlockItem(LirothBlocks.TALLPIER_STAIRS, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tallpier_trapdoor"), new BlockItem(LirothBlocks.TALLPIER_TRAPDOOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "vile_tentacle_tip"), new BlockItem(LirothBlocks.VILE_TENTACLE, new Item.Properties().tab(Liroth.creativePlantsTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "wilting_liroth_rose"), new BlockItem(LirothBlocks.WILITING_LIROTH_ROSE, new Item.Properties().tab(Liroth.creativePlantsTab)));

	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "deepslate_tourmaline_ore"), new BlockItem(LirothBlocks.DEEPSLATE_TOURMALINE_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tourmaline_gem_block"), new BlockItem(LirothBlocks.TOURMALINE_GEM_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "tourmaline_ore"), new BlockItem(LirothBlocks.TOURMALINE_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_tourmaline_ore"), new BlockItem(LirothBlocks.SPINERIOS_TOURMALINE_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "spinerios_stone_tourmaline_ore"), new BlockItem(LirothBlocks.SPINERIOS_STONE_TOURMALINE_ORE, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "liroth_splitter"), new BlockItem(LirothBlocks.LIROTH_SPLITTER, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "quantum_extractor"), new BlockItem(LirothBlocks.QUANTUM_EXTRACTOR, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "jalsphire_crystal_block"), new BlockItem(LirothBlocks.JALSPHIRE_CRYSTAL_BLOCK, new Item.Properties().tab(Liroth.creativeBlocksTab)));
	    Registry.register(Registry.ITEM, new ResourceLocation("liroth", "pointed_jalsphire_crystal"), new BlockItem(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL, new Item.Properties().tab(Liroth.creativeBlocksTab)));
    }

	public static List<Item> getItems() {
		return ITEMS;
	}
	
	public static List<Item> getCombatItems() {
		return COMBAT_ITEMS;
	}
}