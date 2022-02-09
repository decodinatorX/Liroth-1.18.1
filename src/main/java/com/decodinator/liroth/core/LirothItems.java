package com.decodinator.liroth.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.common.properties.LirothCreativeTab;
import com.decodinator.liroth.core.items.BeamItem;
import com.decodinator.liroth.core.items.CustomAxeItem;
import com.decodinator.liroth.core.items.CustomBoatItem;
import com.decodinator.liroth.core.items.CustomHoeItem;
import com.decodinator.liroth.core.items.CustomPickaxeItem;
import com.decodinator.liroth.core.items.LirothBlaster;
import com.decodinator.liroth.core.items.LirothShield;
import com.decodinator.liroth.core.items.PurpetuatedSpyglassItem;
import com.decodinator.liroth.entities.boat.CustomBoatEntity;

@SuppressWarnings("deprecation")
public class LirothItems {
	
    private ItemModels models;

    public static List<Item> itemsList = new ArrayList<>();
    
//    public static final Item TEMPLATE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeTab)), "template");
    
    public static final Item BLOODY_ENTRAILS = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab).food(FoodComponents.ROTTEN_FLESH)), "bloody_entrails");
    
    public static final Item COOL_BEAM = createItem(new BeamItem(new Item.Settings()), "cool_beam");
    
    public static final Item CORRUPTED_JALSPHIRE_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "corrupted_jalsphire_gem");
    
    public static final Item CORRUPTED_LIROTH_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "corrupted_liroth_gem");
    
    public static final Item CORRUPTED_LIROTH_STAR = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "corrupted_liroth_star");
    
//    public static final Item CORRUPTED_ROD = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeTab)), "corrupted_rod"); IS NOW THE COOL BEAM
    
    public static final Item EMBUED_LIROTH_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "embued_liroth_gem");
    
    public static final Item JALSPHIRE_DUST = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "jalsphire_dust");
    public static final Item JALSPHIRE_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "jalsphire_gem");
    
    public static final Item LIROTH_GEM_ANSALUM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem_ansalum");

    public static final Item LIROTH_BERRY = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab).food(FoodComponents.SUSPICIOUS_STEW)), "liroth_berry");

    public static final Item LIROTH_BLASTER = createRangedItem(new LirothBlaster(new Item.Settings().group(LirothCreativeTab.creativeCombatTab).maxCount(1)), "liroth_blaster");
    
    public static final CustomBoatItem LIROTH_BOAT = new CustomBoatItem(new FabricItemSettings().group(LirothCreativeTab.creativeItemsTab).maxCount(1));
    
    public static final Item LIROTH_BONE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_bone");

    public static final Item LIROTH_DUST_ANSALUM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_dust_ansalum");
    public static final Item LIROTH_DUST_LUX = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_dust_lux");
    public static final Item LIROTH_DUST_SALEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_dust_salem");
    
    public static final Item LIROTH_GEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem");
    
    public static final Item LIROTH_GEM_LUX = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem_lux");

    public static final Item LIROTH_GEM_SALEM = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_gem_salem");

    public static final Item LIROTH_SHIELD = createShieldItem(new LirothShield(new Item.Settings().group(LirothCreativeTab.creativeItemsTab).maxCount(1)), "liroth_shield");
    
    public static final Item LIROTH_SOUL_DUST = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_soul_dust");
    
    public static final Item LIROTH_STAR = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_star");

    public static final Item LIROTH_TEAR = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "liroth_tear");
        
    public static final Item PURPETUATED_AMETHYST_SHARD = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "purpetuated_amethyst_shard");
//    public static final Item PURPETUATED_SPYGLASS = createItem(new PurpetuatedSpyglassItem(new Item.Settings().group(LirothCreativeTab.creativeTab)), "purpetuated_spyglass");
    
    public static final Item QUANTUM_DIAMOND = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "quantum_diamond");
    
    public static final Item QUANTUM_PLATE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "quantum_plate");
    public static final Item RUBY = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "ruby");
    public static final Item SOUL_GLASS_BOTTLE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "soul_glass_bottle");
    public static final Item SPINERIOS_STONE_PEBBLE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "spinerios_stone_pebble");
    
    public static final Item TOURMALINE = createItem(new Item(new Item.Settings().group(LirothCreativeTab.creativeItemsTab)), "tourmaline");
        
    public static final Item LIROTH_HELMET = createArmorItem(new ArmorItem(Liroth.LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_helmet");
    public static final Item LIROTH_CHESTPLATE = createArmorItem(new ArmorItem(Liroth.LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_chestplate");
    public static final Item LIROTH_LEGGINGS = createArmorItem(new ArmorItem(Liroth.LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_leggings");
    public static final Item LIROTH_BOOTS = createArmorItem(new ArmorItem(Liroth.LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "liroth_boots");
    
    public static final Item LIROTH_SWORD = createToolItem(new SwordItem(Liroth.LIROTH_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_sword");
    public static final Item LIROTH_SHOVEL = createToolItem(new ShovelItem(Liroth.LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_shovel");
    public static final Item LIROTH_PICKAXE = createToolItem(new CustomPickaxeItem(Liroth.LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_pickaxe");
    public static final Item LIROTH_AXE = createToolItem(new CustomAxeItem(Liroth.LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_axe");
    public static final Item LIROTH_HOE = createToolItem(new CustomHoeItem(Liroth.LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "liroth_hoe");
    
    public static final Item TOURMALINE_HELMET = createArmorItem(new ArmorItem(Liroth.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_helmet");
    public static final Item TOURMALINE_CHESTPLATE = createArmorItem(new ArmorItem(Liroth.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_chestplate");
    public static final Item TOURMALINE_LEGGINGS = createArmorItem(new ArmorItem(Liroth.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_leggings");
    public static final Item TOURMALINE_BOOTS = createArmorItem(new ArmorItem(Liroth.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(LirothCreativeTab.creativeCombatTab)), "tourmaline_boots");
    
    public static final Item TOURMALINE_SWORD = createToolItem(new SwordItem(Liroth.TOURMALINE_TOOL_MATERIAL, 3, -2.4f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_sword");
    public static final Item TOURMALINE_SHOVEL = createToolItem(new ShovelItem(Liroth.TOURMALINE_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_shovel");
    public static final Item TOURMALINE_PICKAXE = createToolItem(new CustomPickaxeItem(Liroth.TOURMALINE_TOOL_MATERIAL, 1, -2.8f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_pickaxe");
    public static final Item TOURMALINE_AXE = createToolItem(new CustomAxeItem(Liroth.TOURMALINE_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_axe");
    public static final Item TOURMALINE_HOE = createToolItem(new CustomHoeItem(Liroth.TOURMALINE_TOOL_MATERIAL, -4, 0.0f, new Item.Settings().group(LirothCreativeTab.creativeCombatTab).fireproof()), "tourmaline_hoe");
    
    public static Item createItem(Item item, Identifier id) {
        if (id != null && !id.equals(new Identifier("minecraft:air"))) {
            Registry.register(Registry.ITEM, id, item);
//            item.setRegistryName(id); //Forge
            itemsList.add(item);
            return item;
        } else {
            return null;
        }
    }

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