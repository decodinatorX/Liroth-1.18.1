package com.decodinator.liroth.core;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LirothParticles {
    public static final DefaultParticleType GREEN_SPORE = FabricParticleTypes.simple();
    public static final DefaultParticleType PURPLE_FLAME = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_FLAME = FabricParticleTypes.simple();
    public static final DefaultParticleType CLOAK = FabricParticleTypes.simple();

    public static void init() {
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("liroth", "green_spore"), GREEN_SPORE);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("liroth", "purple_flame"), PURPLE_FLAME);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("liroth", "green_flame"), GREEN_FLAME);
        Registry.register(Registry.PARTICLE_TYPE, new Identifier("liroth", "cloak"), CLOAK);
    }
}
