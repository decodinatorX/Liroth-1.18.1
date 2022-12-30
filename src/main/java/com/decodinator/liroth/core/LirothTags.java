package com.decodinator.liroth.core;

import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class LirothTags {
	  public static final TagKey<Block> DIRT_ORE_REPLACEABLES = TagKey.of(RegistryKeys.BLOCK, new Identifier("liroth", "dirt_ore_replaceables"));
	  public static final TagKey<Block> LIROTH_FARMLANDS = TagKey.of(RegistryKeys.BLOCK, new Identifier("liroth", "liroth_farmlands"));
	  public static final TagKey<Biome> LIROTH_BIOMES = TagKey.of(RegistryKeys.BIOME, new Identifier("liroth", "liroth_biomes"));
	  public static final TagKey<Fluid> STICKY_FLUIDS = TagKey.of(RegistryKeys.FLUID, new Identifier("liroth", "sticky_fluids"));
	  public static final TagKey<Item> TORCHES = TagKey.of(RegistryKeys.ITEM, new Identifier("liroth", "torches"));
	  public static final TagKey<Item> CHEST = TagKey.of(RegistryKeys.ITEM, new Identifier("minecraft", "chest"));
}
