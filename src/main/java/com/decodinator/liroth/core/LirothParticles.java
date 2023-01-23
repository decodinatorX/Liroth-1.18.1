package com.decodinator.liroth.core;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;

public class LirothParticles {
    public static final SimpleParticleType GREEN_SPORE = FabricParticleTypes.simple();
    public static final SimpleParticleType PURPLE_FLAME = FabricParticleTypes.simple();
    public static final SimpleParticleType GREEN_FLAME = FabricParticleTypes.simple();
    public static final SimpleParticleType CLOAK = FabricParticleTypes.simple();

    public static void init() {
        Registry.register(Registry.PARTICLE_TYPE, new ResourceLocation("liroth", "green_spore"), GREEN_SPORE);
        Registry.register(Registry.PARTICLE_TYPE, new ResourceLocation("liroth", "purple_flame"), PURPLE_FLAME);
        Registry.register(Registry.PARTICLE_TYPE, new ResourceLocation("liroth", "green_flame"), GREEN_FLAME);
        Registry.register(Registry.PARTICLE_TYPE, new ResourceLocation("liroth", "cloak"), CLOAK);
    }
}
