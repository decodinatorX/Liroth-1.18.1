package com.decodinator.liroth.core.world.dims;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.world.biomes.DamnationDimensionBiomeSource;
import com.decodinator.liroth.core.world.biomes.JalsphireDimensionBiomeSource;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class DimensionJalsphire
{
    //public static final Identifier ATLANTIS_ID = new Identifier(Reference.MODID,  "atlantis");
    //public static final RegistryKey<DimensionType> ATLANTIS_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ATLANTIS_ID);
    //public static final RegistryKey<World> ATLANTIS_WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, ATLANTIS_ID);

    public static final RegistryKey<World> JALSPHIRE_WORLD = RegistryKey.of(Registry.WORLD_KEY, new Identifier("liroth:jalsphire_plains"));
    public static final RegistryKey<DimensionType> JALSPHIRE_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier("liroth:jalsphire_plains"));

    public static final Identifier JALSPHIRE_DIMENSION_EFFECT = new Identifier("liroth:jalsphire_plains");

    public static DimensionType JALSPHIRE_TYPE;

    public static ServerWorld JALSPHIRE_DIMENSION;

    public static boolean isJalsphireDimension(World world) {
        return world != null && world.getRegistryKey().equals(JALSPHIRE_WORLD);
    }

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
        	DimensionJalsphire.JALSPHIRE_TYPE = server.getRegistryManager().get(Registry.DIMENSION_TYPE_KEY).get(JALSPHIRE_DIMENSION_TYPE_KEY);
        	DimensionJalsphire.JALSPHIRE_DIMENSION = server.getWorld(JALSPHIRE_WORLD);
        });
    }

    public static void registerBiomeSources() {
        Registry.register(Registry.BIOME_SOURCE, new Identifier(Liroth.MOD_ID, "jalsphire_biome_source"), JalsphireDimensionBiomeSource.CODEC);
    }
}