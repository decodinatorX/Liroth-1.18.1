package com.decodinator.liroth.core;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SmithingTemplateItem;
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
    
    public static final Item ANOMALY_CHARGE = createItem(new UnusedItem(new Item.Properties()), "anomaly_charge");
    
//    public static final Item TEMPLATE = createItem(new Item(new Item.Properties().group(LirothCreativeTab.creativeTab)), "template");
    
    public static final Item BLOODY_ENTRAILS = createItem(new Item(new Item.Properties().food(Foods.ROTTEN_FLESH)), "bloody_entrails");
    
    public static final Item COOL_BEAM = createItem(new BeamItem(new Item.Properties()), "cool_beam");
        
//    public static final Item CORRUPTED_JALSPHIRE_GEM = createItem(new Item(new Item.Properties()), "corrupted_jalsphire_gem");
    
//    public static final Item CORRUPTED_LIROTH_GEM = createItem(new Item(new Item.Properties()), "corrupted_liroth_gem");
    
//    public static final Item CORRUPTED_LIROTH_STAR = createItem(new Item(new Item.Properties()), "corrupted_liroth_star");
    
//    public static final Item CORRUPTED_ROD = createItem(new Item(new Item.Properties().group(LirothCreativeTab.creativeTab)), "corrupted_rod"); IS NOW THE COOL BEAM
    
    public static final Item DAMNATION_CHARGE = createItem(new UnusedItem(new Item.Properties()), "damnation_charge");
    
    public static final Item EMBUED_LIROTH_GEM = createItem(new Item(new Item.Properties()), "embued_liroth_gem");
    
    public static final Item GLEEMSTONE_DUST = createItem(new Item(new Item.Properties()), "gleemstone_dust");
   
    public static final Item JALSPHIRE_CHARGE = createItem(new UnusedItem(new Item.Properties()), "jalsphire_charge");
    public static final Item JALSPHIRE_DUST = createItem(new Item(new Item.Properties()), "jalsphire_dust");
    public static final Item JALSPHIRE_DUST_HEAP = createItem(new Item(new Item.Properties()), "jalsphire_dust_heap");
    public static final Item JALSPHIRE_GEM = createItem(new Item(new Item.Properties()), "jalsphire_gem");
    
    public static final Item JANTIRO_CHARGE = createItem(new UnusedItem(new Item.Properties()), "jantiro_charge");
    
    public static final Item LIROTH_GEM_ANSALUM = createItem(new Item(new Item.Properties()), "liroth_gem_ansalum");

    public static final Item LIROTH_BERRY = createItem(new Item(new Item.Properties().food(Foods.SUSPICIOUS_STEW)), "liroth_berry");

    public static final Item LIROTH_BLASTER = createRangedItem(new LirothBlaster(new Item.Properties().stacksTo(1)), "liroth_blaster");
    public static final Item LIROTH_CHARGE = createItem(new UnusedItem(new Item.Properties()), "liroth_charge");

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
   
    public static final Item LIROTH_BONE = createItem(new Item(new Item.Properties()), "liroth_bone");

    public static final Item LIROTH_DUST_ANSALUM = createItem(new Item(new Item.Properties()), "liroth_dust_ansalum");
    public static final Item LIROTH_DUST_LUX = createItem(new Item(new Item.Properties()), "liroth_dust_lux");
    public static final Item LIROTH_DUST_SALEM = createItem(new Item(new Item.Properties()), "liroth_dust_salem");
    
    public static final Item LIROTH_GEM = createItem(new Item(new Item.Properties()), "liroth_gem");
    public static final Item LIROTH_HORSE_ARMOR = createItem(new HorseArmorItem(9, "liroth", new Item.Properties()), "liroth_horse_armor");
    public static final Item LIROTH_GEM_DUST = createItem(new Item(new Item.Properties()), "liroth_gem_dust");
    public static final Item LIROTH_GEM_DUST_HEAP = createItem(new Item(new Item.Properties()), "liroth_gem_dust_heap");
    
    //It's got that extreme pulp of taking a big ass bite out of a lemon and the tanginess of blackberries while the taste itself is a strawberry metallic flavor
    public static final Item LIROTH_COATED_BREAD = createItem(new Item(new Item.Properties().food(Foods.BREAD)), "liroth_coated_bread");
    
    public static final Item LIROTH_GEM_LUX = createItem(new Item(new Item.Properties()), "liroth_gem_lux");

    // HMMMMMMMMMMM
    public static final Item LIROTHIAN_DUNGEON_KEY = createItem(new KeyItem(new Item.Properties().defaultDurability(1)), "lirothian_dungeon_key");
    
    public static final Item LIROTH_GEM_SALEM = createItem(new Item(new Item.Properties()), "liroth_gem_salem");
    
    public static final Item LIROTHIAN_COBALT_INGOT = createItem(new Item(new Item.Properties()), "lirothian_cobalt_ingot");
    public static final Item LIROTHIAN_COBALT_NUGGET = createItem(new Item(new Item.Properties()), "lirothian_cobalt_nugget");
    public static final Item LIROTHIAN_COBALT_HORSE_ARMOR = createItem(new HorseArmorItem(5, "lirothian_cobalt", new Item.Properties()), "lirothian_cobalt_horse_armor");
    public static final Item RAW_LIROTHIAN_COBALT = createItem(new Item(new Item.Properties()), "raw_lirothian_cobalt");

    public static final Item LIROTHIAN_PETROLEUM = createItem(new Item(new Item.Properties()), "lirothian_petroleum");
    
    public static final Item LIROTH_SHIELD = createShieldItem(new LirothShield(new Item.Properties().stacksTo(1)), "liroth_shield");
    public static final Item ANSALUM_LIROTH_SHIELD = createAnsalumShieldItem(new AnsalumLirothShield(new Item.Properties().stacksTo(1)), "ansalum_liroth_shield");
    public static final Item LUX_LIROTH_SHIELD = createLuxShieldItem(new LuxLirothShield(new Item.Properties().stacksTo(1)), "lux_liroth_shield");
    public static final Item SALEM_LIROTH_SHIELD = createSalemShieldItem(new SalemLirothShield(new Item.Properties().stacksTo(1)), "salem_liroth_shield");
    public static final Item QUANTUM_LIROTH_SHIELD = createQuantumShieldItem(new QuantumLirothShield(new Item.Properties().stacksTo(1)), "quantum_liroth_shield");
    
    public static final Item LIROTH_SMITHING_UPGRADE_TEMPLATE = createItem(new Item(new Item.Properties()), "liroth_upgrade_smithing_template");
    
    public static final Item LIROTH_SOUL_DUST = createItem(new Item(new Item.Properties()), "liroth_soul_dust");
    
//    public static final Item LIROTH_STAR = createItem(new Item(new Item.Properties()), "liroth_star");

    public static final Item LIROTH_TEAR = createItem(new Item(new Item.Properties()), "liroth_tear");
        
    public static final Item NETHERITE_HORSE_ARMOR = createItem(new HorseArmorItem(8, "netherite", new Item.Properties()), "netherite_horse_armor");
    
    public static final Item PURPETUATED_AMETHYST_SHARD = createItem(new Item(new Item.Properties()), "purpetuated_amethyst_shard");
//    public static final Item PURPETUATED_SPYGLASS = createItem(new PurpetuatedSpyglassItem(new Item.Properties().group(LirothCreativeTab.creativeTab)), "purpetuated_spyglass");
    
    public static final Item QUANTUM_DIAMOND = createItem(new Item(new Item.Properties()), "quantum_diamond");
    public static final Item QUANTUM_HORSE_ARMOR = createItem(new HorseArmorItem(10, "quantum", new Item.Properties()), "quantum_horse_armor");
    public static final Item QUANTUM_PLATE = createItem(new Item(new Item.Properties()), "quantum_plate");
    public static final Item RUBY = createItem(new Item(new Item.Properties()), "ruby");
    public static final Item RUBY_HORSE_ARMOR = createItem(new HorseArmorItem(7, "ruby", new Item.Properties()), "ruby_horse_armor");
    public static final Item POTESTIUM_SHARD = createItem(new Item(new Item.Properties()), "potestium_shard");
    public static final Item POTESTIUM_HORSE_ARMOR = createItem(new HorseArmorItem(10, "potestium", new Item.Properties()), "potestium_horse_armor");
    public static final Item POTESTIUM_PLATE = createItem(new Item(new Item.Properties()), "potestium_plate");
//    public static final Item SOUL_GLASS_BOTTLE = createItem(new Item(new Item.Properties()), "soul_glass_bottle");
    public static final Item SPINERIOS_STONE_PEBBLE = createItem(new Item(new Item.Properties()), "spinerios_stone_pebble");
    
    public static final Item SWAP_SMITHING_UPGRADE_TEMPLATE = createItem(new Item(new Item.Properties()), "swap_upgrade_smithing_template");
    
    public static final Item TOURMALINE = createItem(new Item(new Item.Properties()), "tourmaline");
    public static final Item TOURMALINE_HORSE_ARMOR = createItem(new HorseArmorItem(8, "tourmaline", new Item.Properties()), "tourmaline_horse_armor");

    public static final Item QUANTUM_SMITHING_UPGRADE_TEMPLATE = createItem(new Item(new Item.Properties()), "quantum_upgrade_smithing_template");
    
    public static final Item LIROTH_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()), "liroth_helmet");
    public static final Item LIROTH_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "liroth_chestplate");
    public static final Item LIROTH_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()), "liroth_leggings");
    public static final Item LIROTH_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()), "liroth_boots");
    
    public static final Item LIROTHIAN_COBALT_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()), "lirothian_cobalt_helmet");
    public static final Item LIROTHIAN_COBALT_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "lirothian_cobalt_chestplate");
    public static final Item LIROTHIAN_COBALT_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()), "lirothian_cobalt_leggings");
    public static final Item LIROTHIAN_COBALT_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()), "lirothian_cobalt_boots");
    
    public static final Item ANSALUM_LIROTH_HELMET = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()), "ansalum_liroth_helmet");
    public static final Item ANSALUM_LIROTH_CHESTPLATE = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "ansalum_liroth_chestplate");
    public static final Item ANSALUM_LIROTH_LEGGINGS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()), "ansalum_liroth_leggings");
    public static final Item ANSALUM_LIROTH_BOOTS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()), "ansalum_liroth_boots");
    
    public static final Item ANSALUM_LIROTH_AXE = createToolItem(new AxeItem(LirothToolMaterials.ANSALUM_LIROTH_TOOL_MATERIAL, 7.0f, -3.0f, new Item.Properties().fireResistant()), "ansalum_liroth_axe");
    public static final Item LUX_LIROTH_KATANA = createToolItem(new SwordItem(LirothToolMaterials.LUX_LIROTH_TOOL_MATERIAL, 2, -1.4f, new Item.Properties().fireResistant()), "lux_liroth_katana");
    public static final Item SALEM_LIROTH_FALCHION = createToolItem(new SwordItem(LirothToolMaterials.SALEM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Properties().fireResistant()), "salem_liroth_falchion");
    
    public static final Item QUANTUM_LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Properties().fireResistant()), "quantum_liroth_sword");
    public static final Item QUANTUM_LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().fireResistant()), "quantum_liroth_shovel");
    public static final Item QUANTUM_LIROTH_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().fireResistant()), "quantum_liroth_pickaxe");
    public static final Item QUANTUM_LIROTH_AXE = createToolItem(new AxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().fireResistant()), "quantum_liroth_axe");
    public static final Item QUANTUM_LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().fireResistant()), "quantum_liroth_hoe");
    
    public static final Item LUX_LIROTH_HELMET = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()), "lux_liroth_helmet");
    public static final Item LUX_LIROTH_CHESTPLATE = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "lux_liroth_chestplate");
    public static final Item LUX_LIROTH_LEGGINGS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()), "lux_liroth_leggings");
    public static final Item LUX_LIROTH_BOOTS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()), "lux_liroth_boots");
    
    public static final Item SALEM_LIROTH_HELMET = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()), "salem_liroth_helmet");
    public static final Item SALEM_LIROTH_CHESTPLATE = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "salem_liroth_chestplate");
    public static final Item SALEM_LIROTH_LEGGINGS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()), "salem_liroth_leggings");
    public static final Item SALEM_LIROTH_BOOTS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()), "salem_liroth_boots");
    
    public static final Item QUANTUM_LIROTH_HELMET = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()), "quantum_liroth_helmet");
    public static final Item QUANTUM_LIROTH_CHESTPLATE = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "quantum_liroth_chestplate");
    public static final Item QUANTUM_LIROTH_LEGGINGS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()), "quantum_liroth_leggings");
    public static final Item QUANTUM_LIROTH_BOOTS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()), "quantum_liroth_boots");
    
    public static final Item POTESTIUM_LIROTH_HELMET = createArmorItem(new PotestiumHelmItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()), "potestium_liroth_helmet");
    public static final Item POTESTIUM_LIROTH_CHESTPLATE = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "potestium_liroth_chestplate");
    public static final Item POTESTIUM_LIROTH_LEGGINGS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()), "potestium_liroth_leggings");
    public static final Item POTESTIUM_LIROTH_BOOTS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()), "potestium_liroth_boots");
    
    public static final Item POTESTIUM_SCYTHE = createToolItem(new CustomScytheItem(LirothToolMaterials.POTESTIUM_LIROTH_TOOL_MATERIAL, LirothItems.scytheDamage, 0.0f, new Item.Properties().fireResistant()), "potestium_scythe");
    
    public static final Item LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 3, -2.4f, new Item.Properties().fireResistant()), "liroth_sword");
    public static final Item LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().fireResistant()), "liroth_shovel");
    public static final Item LIROTH_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().fireResistant()), "liroth_pickaxe");
    public static final Item LIROTH_AXE = createToolItem(new AxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().fireResistant()), "liroth_axe");
    public static final Item LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().fireResistant()), "liroth_hoe");
    
    public static final Item LIROTHIAN_COBALT_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 3, -2.4f, new Item.Properties()), "lirothian_cobalt_sword");
    public static final Item LIROTHIAN_COBALT_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties()), "lirothian_cobalt_shovel");
    public static final Item LIROTHIAN_COBALT_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1, -2.8f, new Item.Properties()), "lirothian_cobalt_pickaxe");
    public static final Item LIROTHIAN_COBALT_AXE = createToolItem(new AxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties()), "lirothian_cobalt_axe");
    public static final Item LIROTHIAN_COBALT_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, -4, 0.0f, new Item.Properties()), "lirothian_cobalt_hoe");
    
    public static final Item TOURMALINE_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()), "tourmaline_helmet");
    public static final Item TOURMALINE_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "tourmaline_chestplate");
    public static final Item TOURMALINE_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()), "tourmaline_leggings");
    public static final Item TOURMALINE_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()), "tourmaline_boots");
    
    public static final Item TOURMALINE_SWORD = createToolItem(new SwordItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 3, -2.4f, new Item.Properties().fireResistant()), "tourmaline_sword");
    public static final Item TOURMALINE_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().fireResistant()), "tourmaline_shovel");
    public static final Item TOURMALINE_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().fireResistant()), "tourmaline_pickaxe");
    public static final Item TOURMALINE_AXE = createToolItem(new AxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().fireResistant()), "tourmaline_axe");
    public static final Item TOURMALINE_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().fireResistant()), "tourmaline_hoe");
    
    public static final Item RUBY_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties()), "ruby_helmet");
    public static final Item RUBY_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()), "ruby_chestplate");
    public static final Item RUBY_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()), "ruby_leggings");
    public static final Item RUBY_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()), "ruby_boots");
    
    public static final Item RUBY_SWORD = createToolItem(new SwordItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 3, -2.4f, new Item.Properties()), "ruby_sword");
    public static final Item RUBY_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties()), "ruby_shovel");
    public static final Item RUBY_PICKAXE = createToolItem(new PickaxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1, -2.8f, new Item.Properties()), "ruby_pickaxe");
    public static final Item RUBY_AXE = createToolItem(new AxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties()), "ruby_axe");
    public static final Item RUBY_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, -3, 0.0f, new Item.Properties()), "ruby_hoe");
    
    public static final Item UNOBTAINABLE_FORSAKEN_CORPSE_SPAWN_EGG = createUnusedItem(new SpawnEggItem(LirothEntities.FORSAKEN_CORPSE, 1842204, 10551525, new Item.Properties()), "unobtainable_forsaken_corpse_spawn_egg");
    
    private static Item createArmorItem(ArmorItem armorItem, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), armorItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(armorItem);
      return armorItem;
	}
    
    private static Item createShieldItem(LirothShield shieldItem, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createAnsalumShieldItem(AnsalumLirothShield shieldItem, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createLuxShieldItem(LuxLirothShield shieldItem, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createSalemShieldItem(SalemLirothShield shieldItem, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createQuantumShieldItem(QuantumLirothShield shieldItem, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), shieldItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(shieldItem);
      return shieldItem;
	}
    
    private static Item createToolItem(TieredItem toolItem, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), toolItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(toolItem);
      return toolItem;
	}
    
    private static Item createRangedItem(LirothBlaster blasterItem, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), blasterItem);
//      item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        COMBAT_ITEMS.add(blasterItem);
      return blasterItem;
	}
    
    static Item createBoatItem(String id, LirothBoat.LirothType type) {
		Item createItem = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), new LirothBoatItem(false, type, new Item.Properties()));
		ITEMS.add(createItem);
		return createItem;    
    }
    
    static Item createChestBoatItem(String id, LirothBoat.LirothType type) {
		Item createItem = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), new LirothBoatItem(true, type, new Item.Properties()));
		ITEMS.add(createItem);
		return createItem;    
    }

	public static Item createItem(Item item, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), item);
//        item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        ITEMS.add(item);
        return item;
    }
	
	public static Item createUnusedItem(Item item, String id) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, id), item);
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
		LIROTH_FLUID_BUCKET = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, "liroth_fluid_bucket"), new BucketItem(LirothFluids.LIROTH_FLUID_STILL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
		MOLTEN_SPINERIOS_BUCKET = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, "molten_spinerios_bucket"), new BucketItem(LirothFluids.MOLTEN_SPINERIOS_STILL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
	    Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, "fungal_torch"), new StandingAndWallBlockItem(LirothBlocks.FUNGAL_TORCH, LirothBlocks.WALL_FUNGAL_TORCH, new Item.Properties(), Direction.DOWN));
	    Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Liroth.MOD_ID, "lirothian_petroleum_torch"), new StandingAndWallBlockItem(LirothBlocks.LIROTHIAN_PETROLEUM_TORCH, LirothBlocks.WALL_LIROTHIAN_PETROLEUM_TORCH, new Item.Properties(), Direction.DOWN));
    }

	public static List<Item> getItems() {
		return ITEMS;
	}
	
	public static List<Item> getCombatItems() {
		return COMBAT_ITEMS;
	}
}