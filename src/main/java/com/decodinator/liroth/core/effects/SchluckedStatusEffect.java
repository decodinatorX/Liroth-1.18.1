package com.decodinator.liroth.core.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SchluckedStatusEffect extends StatusEffect {
	public SchluckedStatusEffect() {
		super(StatusEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return true;
	}
}
