package com.decodinator.liroth.core;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class LirothParticles {
    public static final DefaultParticleType GREEN_SPORE = FabricParticleTypes.simple();
    public static final DefaultParticleType PURPLE_FLAME = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_FLAME = FabricParticleTypes.simple();
    public static final DefaultParticleType CLOAK = FabricParticleTypes.simple();

    public static void init() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier("liroth", "green_spore"), GREEN_SPORE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier("liroth", "purple_flame"), PURPLE_FLAME);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier("liroth", "green_flame"), GREEN_FLAME);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier("liroth", "cloak"), CLOAK);
    }
}
