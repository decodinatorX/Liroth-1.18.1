package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.List;
import java.util.function.Supplier;

@Mixin(GenerationSettings.class)
public interface BiomeGenerationSettingsAccess {

    @Accessor
    List<List<Supplier<ConfiguredFeature<?, ?>>>> getFeatures();

    @Accessor
    void setFeatures(List<List<Supplier<ConfiguredFeature<?, ?>>>> features);
}
