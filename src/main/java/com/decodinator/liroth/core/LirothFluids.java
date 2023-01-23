package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.fluids.LirothFluid;
import com.decodinator.liroth.core.fluids.MoltenSpinerios;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;

public class LirothFluids {
	public static FlowingFluid LIROTH_FLUID_STILL;
	public static FlowingFluid LIROTH_FLUID_FLOWING;
	public static FlowingFluid MOLTEN_SPINERIOS_STILL;
	public static FlowingFluid MOLTEN_SPINERIOS_FLOWING;

	
	public static void init() {
		LIROTH_FLUID_STILL = Registry.register(Registry.FLUID, new ResourceLocation(Liroth.MOD_ID, "liroth_fluid_still"), new LirothFluid.Still());
		LIROTH_FLUID_FLOWING = Registry.register(Registry.FLUID, new ResourceLocation(Liroth.MOD_ID, "liroth_fluid_flowing"), new LirothFluid.Flowing());
		MOLTEN_SPINERIOS_STILL = Registry.register(Registry.FLUID, new ResourceLocation(Liroth.MOD_ID, "molten_spinerios_still"), new MoltenSpinerios.Still());
		MOLTEN_SPINERIOS_FLOWING = Registry.register(Registry.FLUID, new ResourceLocation(Liroth.MOD_ID, "molten_spinerios_flowing"), new MoltenSpinerios.Flowing());
	}
}
