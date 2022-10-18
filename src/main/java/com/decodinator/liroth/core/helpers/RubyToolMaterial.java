package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 1561;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 8.0f;
	}

	@Override
	public float getAttackDamage() {
		return 3.0f;
	}

	@Override
	public int getMiningLevel() {
		return MiningLevels.DIAMOND;
	}

	@Override
	public int getEnchantability() {
		return 10;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(LirothItems.RUBY);
	}

}
