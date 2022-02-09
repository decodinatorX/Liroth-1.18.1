package com.decodinator.liroth.core.world.dims;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.world.biomes.JantiroDimensionBiomeSource;
import com.decodinator.liroth.core.world.biomes.LirothDimensionBiomeSource;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class DimensionJantiro
{
    //public static final Identifier ATLANTIS_ID = new Identifier(Reference.MODID,  "atlantis");
    //public static final RegistryKey<DimensionType> ATLANTIS_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ATLANTIS_ID);
    //public static final RegistryKey<World> ATLANTIS_WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, ATLANTIS_ID);

    public static final RegistryKey<World> JANTIRO_WORLD = RegistryKey.of(Registry.WORLD_KEY, new Identifier("liroth:jantiros_escape_dimension"));
    public static final RegistryKey<DimensionType> JANTIRO_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier("liroth:jantiros_escape_dimension"));

    public static final Identifier JANTIRO_DIMENSION_EFFECT = new Identifier("liroth:jantiros_escape_dimension");

    public static DimensionType JANTIRO_TYPE;

    public static ServerWorld JANTIRO_DIMENSION;

    public static boolean isJantiroDimension(World world) {
        return world != null && world.getRegistryKey().equals(JANTIRO_WORLD);
    }

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
        	DimensionJantiro.JANTIRO_TYPE = server.getRegistryManager().get(Registry.DIMENSION_TYPE_KEY).get(JANTIRO_DIMENSION_TYPE_KEY);
        	DimensionJantiro.JANTIRO_DIMENSION = server.getWorld(JANTIRO_WORLD);
        });
    }

    public static void registerBiomeSources() {
        Registry.register(Registry.BIOME_SOURCE, new Identifier(Liroth.MOD_ID, "jantiro_biome_source"), JantiroDimensionBiomeSource.CODEC);
    }
}