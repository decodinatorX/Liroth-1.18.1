package com.decodinator.liroth.core;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class LirothTags {
	  public static final TagKey<Block> DIRT_ORE_REPLACEABLES = TagKey.of(Registry.BLOCK_KEY, new Identifier("liroth", "dirt_ore_replaceables"));
	  public static final TagKey<Block> LIROTH_FARMLANDS = TagKey.of(Registry.BLOCK_KEY, new Identifier("liroth", "liroth_farmlands"));
	  public static final TagKey<Biome> LIROTH_BIOMES = TagKey.of(Registry.BIOME_KEY, new Identifier("liroth", "liroth_biomes"));
	  public static final TagKey<Fluid> STICKY_FLUIDS = TagKey.of(Registry.FLUID_KEY, new Identifier("liroth", "sticky_fluids"));
	  public static final TagKey<Item> TORCHES = TagKey.of(Registry.ITEM_KEY, new Identifier("liroth", "torches"));
}
