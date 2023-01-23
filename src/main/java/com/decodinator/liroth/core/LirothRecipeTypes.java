package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.helpers.AbstractQuantumRecipe;
import com.decodinator.liroth.core.helpers.AbstractSplitterRecipe;
import com.decodinator.liroth.core.helpers.QuantumRecipe;
import com.decodinator.liroth.core.helpers.SimpleQuantumSerializer;
import com.decodinator.liroth.core.helpers.SimpleSplitterSerializer;
import com.decodinator.liroth.core.helpers.SplitterRecipe;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;

public class LirothRecipeTypes {
	public static RecipeType<AbstractQuantumRecipe> QUANTUM_EXTRACTION;
	public static SimpleQuantumSerializer<AbstractQuantumRecipe> QUANTUM_EXTRACTION_S;
	
	public static RecipeType<AbstractSplitterRecipe> LIROTH_SPLITTING;
	public static SimpleSplitterSerializer<AbstractSplitterRecipe> LIROTH_SPLITTING_S;
	
	public static void init() {
		QUANTUM_EXTRACTION = Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(Liroth.MOD_ID, "quantum_extraction"), new RecipeType<AbstractQuantumRecipe>() {});;
		QUANTUM_EXTRACTION_S = Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Liroth.MOD_ID, "quantum_extraction"), new SimpleQuantumSerializer<>(QuantumRecipe::new, 200));
		LIROTH_SPLITTING = Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(Liroth.MOD_ID, "liroth_splitting"), new RecipeType<AbstractSplitterRecipe>() {});;
		LIROTH_SPLITTING_S = Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(Liroth.MOD_ID, "liroth_splitting"), new SimpleSplitterSerializer<>(SplitterRecipe::new, 200));
		}
}
