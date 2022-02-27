package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LuxLirothToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 1031;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 20.0f;
	}

	@Override
	public float getAttackDamage() {
		return 4.0f;
	}

	@Override
	public int getMiningLevel() {
		return 5;
	}

	@Override
	public int getEnchantability() {
		return 25;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(LirothItems.LIROTH_GEM_LUX);
	}

}
