package com.decodinator.liroth.core.world.biomes;

import com.decodinator.liroth.Liroth;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.RegistryLookupCodec;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;

import java.util.Map;
import java.util.stream.Collectors;

public class JantiroDimensionBiomeSource extends BiomeSource {
    public static final Codec<JantiroDimensionBiomeSource> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((biomeSource) ->
                    biomeSource.BIOME_REGISTRY), Codec.intRange(1, 20).fieldOf("biome_size").orElse(2).forGetter((biomeSource) ->
                    biomeSource.biomeSize), Codec.LONG.fieldOf("seed").stable().forGetter((biomeSource) ->
                    biomeSource.seed)).apply(instance, instance.stable(JantiroDimensionBiomeSource::new)));

    public static final Identifier JANTIROS_BIOME = new Identifier(Liroth.MOD_ID, "jantiros_biome");
    public static final Identifier PETRIFIED_DESERT = new Identifier(Liroth.MOD_ID, "petrified_desert");
    private final Registry<Biome> BIOME_REGISTRY;
    public static Registry<Biome> LAYERS_BIOME_REGISTRY;
    private final long seed;
    private final int biomeSize;

    protected JantiroDimensionBiomeSource(Registry<Biome> biomeRegistry, int biomeSize, long seed) {
        super(biomeRegistry.getEntries().stream()
                .filter(entry -> entry.getKey().getValue().getNamespace().equals(Liroth.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList()));
        this.BIOME_REGISTRY = biomeRegistry;
        JantiroDimensionBiomeSource.LAYERS_BIOME_REGISTRY = biomeRegistry;
        this.biomeSize = biomeSize;
        this.seed = seed;
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new JantiroDimensionBiomeSource(this.BIOME_REGISTRY, this.biomeSize, seed);
    }

    @Override
    public Biome getBiome(int x, int y, int z, MultiNoiseUtil.MultiNoiseSampler noise) {
        if ((int) noise.sample(x, y, z).temperatureNoise() > 0.70 && noise.sample(x, y, z).temperatureNoise() < 1.00) {
            return BIOME_REGISTRY.get(JantiroDimensionBiomeSource.PETRIFIED_DESERT);
        } else {
            return BIOME_REGISTRY.get(JantiroDimensionBiomeSource.JANTIROS_BIOME);
        }
    }
}