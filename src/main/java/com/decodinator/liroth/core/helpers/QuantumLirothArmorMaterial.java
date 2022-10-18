package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class QuantumLirothArmorMaterial implements ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[] {15, 17, 18, 13};
	private static final int[] PROTECTION_VALUES = new int[] {6, 9, 11, 6}; 
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
		return 14;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(LirothItems.QUANTUM_DIAMOND);

	}

	@Override
	public String getName() {
		return "quantum_liroth";
	}

	@Override
	public float getToughness() {
		return 4.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.25F;
	}



}
