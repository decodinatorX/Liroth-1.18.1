package com.decodinator.liroth.core;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class LirothTags {
	  public static final TagKey<Block> DIRT_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("liroth", "dirt_ore_replaceables"));
	  public static final TagKey<Block> LIROTH_FARMLANDS = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("liroth", "liroth_farmlands"));
	  public static final TagKey<Biome> LIROTH_BIOMES = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("liroth", "liroth_biomes"));
	  public static final TagKey<Fluid> STICKY_FLUIDS = TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation("liroth", "sticky_fluids"));
	  public static final TagKey<Item> TORCHES = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("liroth", "torches"));
	  public static final TagKey<Item> CHEST = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("minecraft", "chest"));
}
