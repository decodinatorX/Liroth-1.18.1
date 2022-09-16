package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.fluids.LirothFluid;
import com.decodinator.liroth.core.fluids.MoltenSpinerios;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LirothFluids {
	public static FlowableFluid LIROTH_FLUID_STILL;
	public static FlowableFluid LIROTH_FLUID_FLOWING;
	public static FlowableFluid MOLTEN_SPINERIOS_STILL;
	public static FlowableFluid MOLTEN_SPINERIOS_FLOWING;

	
	public static void init() {
		LIROTH_FLUID_STILL = Registry.register(Registry.FLUID, new Identifier(Liroth.MOD_ID, "liroth_fluid_still"), new LirothFluid.Still());
		LIROTH_FLUID_FLOWING = Registry.register(Registry.FLUID, new Identifier(Liroth.MOD_ID, "liroth_fluid_flowing"), new LirothFluid.Flowing());
		MOLTEN_SPINERIOS_STILL = Registry.register(Registry.FLUID, new Identifier(Liroth.MOD_ID, "molten_spinerios_still"), new MoltenSpinerios.Still());
		MOLTEN_SPINERIOS_FLOWING = Registry.register(Registry.FLUID, new Identifier(Liroth.MOD_ID, "molten_spinerios_flowing"), new MoltenSpinerios.Flowing());
	}
}
