package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class LirothianCobaltToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 250;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 6.0f;
	}

	@Override
	public float getAttackDamage() {
		return 2.0f;
	}

	@Override
	public int getMiningLevel() {
		return MiningLevels.IRON;
	}

	@Override
	public int getEnchantability() {
		return 14;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(LirothItems.LIROTHIAN_COBALT_INGOT);
	}

}
