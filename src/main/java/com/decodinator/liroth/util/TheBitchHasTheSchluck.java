package com.decodinator.liroth.util;

import com.decodinator.liroth.Liroth;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;

public class TheBitchHasTheSchluck {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof LivingEntity _livEnt ? _livEnt.hasStatusEffect(Liroth.SCHLUCKED) : false;
	}
}
