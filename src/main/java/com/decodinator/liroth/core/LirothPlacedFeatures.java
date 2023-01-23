package com.decodinator.liroth.core;

import java.util.List;

import com.decodinator.liroth.Liroth;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class LirothPlacedFeatures {
	   public static final Holder<PlacedFeature> OVERWORLD_LIROTH_ORE = PlacementUtils.register("liroth_ore", LirothConfiguredFeatures.OVERWORLD_LIROTH_ORE, commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
	   public static final Holder<PlacedFeature> NETHER_LIROTH_ORE = PlacementUtils.register("nether_liroth_ore", LirothConfiguredFeatures.NETHER_LIROTH_ORE, commonOrePlacement(10, PlacementUtils.RANGE_10_10));
	   public static final Holder<PlacedFeature> END_LIROTH_ORE = PlacementUtils.register("end_liroth_ore", LirothConfiguredFeatures.END_LIROTH_ORE, commonOrePlacement(10, PlacementUtils.RANGE_10_10));
	   public static final Holder<PlacedFeature> TOURMALINE_ORE = PlacementUtils.register("tourmaline_ore", LirothConfiguredFeatures.TOURMALINE_ORE, commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
	 
	   private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		      return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
		   }

		   private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		      return orePlacement(CountPlacement.of(p_195344_), p_195345_);
		   }
		   
	   public static void init() {}
}
