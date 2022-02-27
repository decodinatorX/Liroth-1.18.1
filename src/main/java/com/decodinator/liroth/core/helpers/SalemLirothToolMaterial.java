package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class SalemLirothToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 2531;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 10.0f;
	}

	@Override
	public float getAttackDamage() {
		return 5.0f;
	}

	@Override
	public int getMiningLevel() {
		return 5;
	}

	@Override
	public int getEnchantability() {
		return 20;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(LirothItems.LIROTH_GEM_SALEM);
	}

}
