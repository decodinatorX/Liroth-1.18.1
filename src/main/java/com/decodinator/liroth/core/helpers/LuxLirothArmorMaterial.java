package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class LuxLirothArmorMaterial implements ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4}; 
	// In which A is helmet, B chestplate, C leggings and D boots. 
	// For reference, Leather uses {1, 2, 3, 1}, and Diamond/Netherite {3, 6, 8, 3}
	@Override
	public int getDurability(EquipmentSlot var1) {
		return BASE_DURABILITY[var1.getEntitySlotId()] * 37;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot var1) {
		return PROTECTION_VALUES[var1.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 17;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(LirothItems.LIROTH_GEM_LUX);

	}

	@Override
	public String getName() {
		return "lux_liroth";
	}

	@Override
	public float getToughness() {
		return 3.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.05F;
	}



}
