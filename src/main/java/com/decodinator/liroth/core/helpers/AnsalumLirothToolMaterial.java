package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AnsalumLirothToolMaterial implements ToolMaterial {

	@Override
	public int getDurability() {
		return 3031;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 10.0f;
	}

	@Override
	public float getAttackDamage() {
		return 6.0f;
	}

	@Override
	public int getMiningLevel() {
		return 5;
	}

	@Override
	public int getEnchantability() {
		return 15;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(LirothItems.LIROTH_GEM_ANSALUM);
	}

}
