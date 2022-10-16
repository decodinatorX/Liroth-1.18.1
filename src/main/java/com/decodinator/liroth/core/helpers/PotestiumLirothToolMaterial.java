package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PotestiumLirothToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 4031;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 11.0f;
	}

	@Override
	public float getAttackDamage() {
		return 7.0f;
	}

	@Override
	public int getMiningLevel() {
		return 7;
	}

	@Override
	public int getEnchantability() {
		return 10;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(LirothItems.POTESTIUM_SHARD);
	}

}
