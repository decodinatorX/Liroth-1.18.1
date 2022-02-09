package com.decodinator.liroth.core.world.dims;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.world.biomes.DamnationDimensionBiomeSource;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class DimensionDamnation
{
    //public static final Identifier ATLANTIS_ID = new Identifier(Reference.MODID,  "atlantis");
    //public static final RegistryKey<DimensionType> ATLANTIS_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ATLANTIS_ID);
    //public static final RegistryKey<World> ATLANTIS_WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, ATLANTIS_ID);

    public static final RegistryKey<World> DAMNATION_WORLD = RegistryKey.of(Registry.WORLD_KEY, new Identifier("liroth:damnation"));
    public static final RegistryKey<DimensionType> DAMNATION_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier("liroth:damnation"));

    public static final Identifier DAMNATION_DIMENSION_EFFECT = new Identifier("liroth:damnation");

    public static DimensionType DAMNATION_TYPE;

    public static ServerWorld DAMNATION_DIMENSION;

    public static boolean isDamnationDimension(World world) {
        return world != null && world.getRegistryKey().equals(DAMNATION_WORLD);
    }

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
        	DimensionDamnation.DAMNATION_TYPE = server.getRegistryManager().get(Registry.DIMENSION_TYPE_KEY).get(DAMNATION_DIMENSION_TYPE_KEY);
        	DimensionDamnation.DAMNATION_DIMENSION = server.getWorld(DAMNATION_WORLD);
        });
    }

    public static void registerBiomeSources() {
        Registry.register(Registry.BIOME_SOURCE, new Identifier(Liroth.MOD_ID, "damnation_biome_source"), DamnationDimensionBiomeSource.CODEC);
    }
}