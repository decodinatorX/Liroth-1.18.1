package com.decodinator.liroth.core.world.dims;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.world.biomes.DamnationDimensionBiomeSource;
import com.decodinator.liroth.core.world.biomes.DevastatedDimensionBiomeSource;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class DimensionDevastated
{
    //public static final Identifier ATLANTIS_ID = new Identifier(Reference.MODID,  "atlantis");
    //public static final RegistryKey<DimensionType> ATLANTIS_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ATLANTIS_ID);
    //public static final RegistryKey<World> ATLANTIS_WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, ATLANTIS_ID);

    public static final RegistryKey<World> DEVASTATED_WORLD = RegistryKey.of(Registry.WORLD_KEY, new Identifier("liroth:devasted_plains"));
    public static final RegistryKey<DimensionType> DEVASTATED_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier("liroth:devasted_plains"));

    public static final Identifier DEVASTATED_DIMENSION_EFFECT = new Identifier("liroth:devasted_plains");

    public static DimensionType DEVASTATED_TYPE;

    public static ServerWorld DEVASTATED_DIMENSION;

    public static boolean isDamnationDimension(World world) {
        return world != null && world.getRegistryKey().equals(DEVASTATED_WORLD);
    }

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
        	DimensionDevastated.DEVASTATED_TYPE = server.getRegistryManager().get(Registry.DIMENSION_TYPE_KEY).get(DEVASTATED_DIMENSION_TYPE_KEY);
        	DimensionDevastated.DEVASTATED_DIMENSION = server.getWorld(DEVASTATED_WORLD);
        });
    }

    public static void registerBiomeSources() {
        Registry.register(Registry.BIOME_SOURCE, new Identifier(Liroth.MOD_ID, "devastated_biome_source"), DevastatedDimensionBiomeSource.CODEC);
    }
}