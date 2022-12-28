package com.decodinator.liroth.core;

import java.util.Arrays;
import java.util.List;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class LirothPlacedFeatures {
	  public static PlacedFeature OVERWORLD_TOURMALINE_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
		      RegistryEntry.of(LirothConfiguredFeatures.OVERWORLD_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE),
		      Arrays.asList(
			  SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), BiomePlacementModifier.of()));
	  
	  public static PlacedFeature OVERWORLD_DEEPSLATE_LIROTH_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
		      RegistryEntry.of(LirothConfiguredFeatures.OVERWORLD_DEEPSLATE_LIROTH_GEM_ORE_CONFIGURED_FEATURE),
		      Arrays.asList(
		      CountPlacementModifier.of(15), // number of veins per chunk
		      SquarePlacementModifier.of(), // spreading horizontally
		      HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)))); // height
	  
	  public static PlacedFeature NETHER_LIROTH_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
		      RegistryEntry.of(LirothConfiguredFeatures.NETHER_LIROTH_GEM_ORE_CONFIGURED_FEATURE),(
		      LirothPlacedFeatures.modifiersWithCount(5, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE)));
	  
	  public static PlacedFeature END_LIROTH_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
		      RegistryEntry.of(LirothConfiguredFeatures.END_LIROTH_GEM_ORE_CONFIGURED_FEATURE),(
		      LirothPlacedFeatures.modifiersWithCount(10, PlacedFeatures.TEN_ABOVE_AND_BELOW_RANGE)));

	  public static PlacedFeature OVERWORLD_DEEPSLATE_TOURMALINE_GEM_ORE_PLACED_FEATURE =  new PlacedFeature(
		      RegistryEntry.of(LirothConfiguredFeatures.OVERWORLD_DEEPSLATE_TOURMALINE_GEM_ORE_CONFIGURED_FEATURE),
		      Arrays.asList(
			  SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.fixed(8), YOffset.fixed(24)), BiomePlacementModifier.of()));
	  
	    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
	        return LirothPlacedFeatures.modifiers(CountPlacementModifier.of(count), heightModifier);
	    }
	    
	    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
	        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
	    }
}
