package com.decodinator.liroth.core.world.dims;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.world.biomes.LirothDimensionBiomeSource;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class DimensionLiroth
{
    //public static final Identifier ATLANTIS_ID = new Identifier(Reference.MODID,  "atlantis");
    //public static final RegistryKey<DimensionType> ATLANTIS_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, ATLANTIS_ID);
    //public static final RegistryKey<World> ATLANTIS_WORLD_KEY = RegistryKey.of(Registry.WORLD_KEY, ATLANTIS_ID);

    public static final RegistryKey<World> LIROTH_WORLD = RegistryKey.of(Registry.WORLD_KEY, new Identifier("liroth:liroth_dimension"));
    public static final RegistryKey<DimensionType> LIROTH_DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier("liroth:liroth_dimension"));

    public static final Identifier LIROTH_DIMENSION_EFFECT = new Identifier("liroth:liroth_dimension");

    public static DimensionType LIROTH_TYPE;

    public static ServerWorld LIROTH_DIMENSION;

    public static boolean isLirothDimension(World world) {
        return world != null && world.getRegistryKey().equals(LIROTH_WORLD);
    }

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
        	DimensionLiroth.LIROTH_TYPE = server.getRegistryManager().get(Registry.DIMENSION_TYPE_KEY).get(LIROTH_DIMENSION_TYPE_KEY);
        	DimensionLiroth.LIROTH_DIMENSION = server.getWorld(LIROTH_WORLD);
        });
    }

    public static void registerBiomeSources() {
        Registry.register(Registry.BIOME_SOURCE, new Identifier(Liroth.MOD_ID, "liroth_biome_source"), LirothDimensionBiomeSource.CODEC);
    }
}