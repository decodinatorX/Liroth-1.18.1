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

public class JalsphireDimensionBiomeSource extends BiomeSource {
    public static final Codec<JalsphireDimensionBiomeSource> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((biomeSource) ->
                    biomeSource.BIOME_REGISTRY), Codec.intRange(1, 20).fieldOf("biome_size").orElse(2).forGetter((biomeSource) ->
                    biomeSource.biomeSize), Codec.LONG.fieldOf("seed").stable().forGetter((biomeSource) ->
                    biomeSource.seed)).apply(instance, instance.stable(JalsphireDimensionBiomeSource::new)));

    public static final Identifier JALSPHIRE_PLAINS = new Identifier(Liroth.MOD_ID, "jalsphire_plains");
    private final Registry<Biome> BIOME_REGISTRY;
    public static Registry<Biome> LAYERS_BIOME_REGISTRY;
    private final long seed;
    private final int biomeSize;

    protected JalsphireDimensionBiomeSource(Registry<Biome> biomeRegistry, int biomeSize, long seed) {
        super(biomeRegistry.getEntries().stream()
                .filter(entry -> entry.getKey().getValue().getNamespace().equals(Liroth.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList()));
        this.BIOME_REGISTRY = biomeRegistry;
        JalsphireDimensionBiomeSource.LAYERS_BIOME_REGISTRY = biomeRegistry;
        this.biomeSize = biomeSize;
        this.seed = seed;
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new JalsphireDimensionBiomeSource(this.BIOME_REGISTRY, this.biomeSize, seed);
    }

    @Override
    public Biome getBiome(int x, int y, int z, MultiNoiseUtil.MultiNoiseSampler noise) {
        if ((int) noise.sample(x, y, z).temperatureNoise() > 1.00) {
            return BIOME_REGISTRY.get(JalsphireDimensionBiomeSource.JALSPHIRE_PLAINS);
        } else {
            return BIOME_REGISTRY.get(JalsphireDimensionBiomeSource.JALSPHIRE_PLAINS);
        }
    }
}