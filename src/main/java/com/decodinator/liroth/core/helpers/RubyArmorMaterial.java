package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class RubyArmorMaterial implements ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[] {3, 6, 8, 3}; 
	// In which A is helmet, B chestplate, C leggings and D boots. 
	// For reference, Leather uses {1, 2, 3, 1}, and Diamond/Netherite {3, 6, 8, 3}
	@Override
	public int getDurability(EquipmentSlot var1) {
		return BASE_DURABILITY[var1.getEntitySlotId()] * 33;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot var1) {
		return PROTECTION_VALUES[var1.getEntitySlotId()];
	}

	@Override
	public int getEnchantability() {
		return 10;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(LirothItems.RUBY);

	}

	@Override
	public String getName() {
		return "ruby";
	}

	@Override
	public float getToughness() {
		return 2.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.0F;
	}



}
