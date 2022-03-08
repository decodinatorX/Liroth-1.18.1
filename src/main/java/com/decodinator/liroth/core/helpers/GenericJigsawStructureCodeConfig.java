package com.decodinator.liroth.core.helpers;

import java.util.Set;

import com.decodinator.liroth.world.generator.LirothStructures;

import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class GenericJigsawStructureCodeConfig {

    public final Identifier startPool;
    public final int structureSize;
    public final int centerOffset;
    public final int biomeRange;
    public final int structureBlacklistRange;
    public final int allowTerrainHeightRange;
    public final int terrainHeightRadius;
    public final int minHeightLimit;
    public final int fixedYSpawn;
    public final boolean useHeightmap;
    public final boolean cannotSpawnInWater;
    public final Set<Identifier> poolsThatIgnoreBounds;

    public GenericJigsawStructureCodeConfig(Identifier poolID, int structureSize, int centerOffset, int biomeRange,
                                            int structureBlacklistRange,
                                            int allowTerrainHeightRange, int terrainHeightRadius, int minHeightLimit,
                                            int fixedYSpawn, boolean useHeightmap, boolean cannotSpawnInWater,
                                            Set<Identifier> poolsThatIgnoreBounds)
    {
        this.startPool = poolID;
        this.structureSize = structureSize;
        this.centerOffset = centerOffset;
        this.biomeRange = biomeRange;
        this.structureBlacklistRange = structureBlacklistRange;
        this.allowTerrainHeightRange = allowTerrainHeightRange;
        this.terrainHeightRadius = terrainHeightRadius;
        this.minHeightLimit = minHeightLimit;
        this.fixedYSpawn = fixedYSpawn;
        this.useHeightmap = useHeightmap;
        this.cannotSpawnInWater = cannotSpawnInWater;
        this.poolsThatIgnoreBounds = poolsThatIgnoreBounds;

        LirothStructures.LIROTH_STRUCTURE_START_PIECES.add(startPool);
    }

    public static class Builder<T extends Builder<T>> {
        protected final Identifier startPool;
        protected int structureSize = 1;
        protected int centerOffset = 0;
        protected int biomeRange = 0;
        protected int structureBlacklistRange = 0;
        protected int allowTerrainHeightRange = -1;
        protected int terrainHeightRadius = 0;
        protected int minHeightLimit = Integer.MIN_VALUE;
        protected int fixedYSpawn = 0;
        protected boolean useHeightmap = true;
        protected boolean cannotSpawnInWater = false;
        protected Set<Identifier> poolsThatIgnoreBounds;

        public Builder(Identifier startPool) {
            this.startPool = startPool;
        }

        @SuppressWarnings("unchecked")
        protected T getThis() {
            return (T) this;
        }

        public T setStructureSize(int structureSize) {
            this.structureSize = structureSize;
            return getThis();
        }

        public T setCenterOffset(int centerOffset) {
            this.centerOffset = centerOffset;
            return getThis();
        }

        public T setBiomeRange(int biomeRange) {
            this.biomeRange = biomeRange;
            return getThis();
        }

        public T setStructureBlacklistRange(int structureBlacklistRange) {
            this.structureBlacklistRange = structureBlacklistRange;
            return getThis();
        }

        public T setAllowTerrainHeightRange(int allowTerrainHeightRange) {
            this.allowTerrainHeightRange = allowTerrainHeightRange;
            return getThis();
        }

        public T setTerrainHeightRadius(int terrainHeightRadius) {
            this.terrainHeightRadius = terrainHeightRadius;
            return getThis();
        }

        public T setMinHeightLimit(int minHeightLimit) {
            this.minHeightLimit = minHeightLimit;
            return getThis();
        }

        public T setFixedYSpawn(int fixedYSpawn) {
            this.fixedYSpawn = fixedYSpawn;
            return getThis();
        }

        public T doNotUseHeightmap() {
            this.useHeightmap = false;
            return getThis();
        }

        public T cannotSpawnInWater() {
            this.cannotSpawnInWater = true;
            return getThis();
        }

        public T setPoolsThatIgnoreBounds(Set<Identifier> poolsThatIgnoreBounds) {
            this.poolsThatIgnoreBounds = poolsThatIgnoreBounds;
            return getThis();
        }

        public GenericJigsawStructureCodeConfig build() {
            return new GenericJigsawStructureCodeConfig(
                    startPool,
                    structureSize,
                    centerOffset,
                    biomeRange,
                    structureBlacklistRange,
                    allowTerrainHeightRange,
                    terrainHeightRadius,
                    minHeightLimit,
                    fixedYSpawn,
                    useHeightmap,
                    cannotSpawnInWater,
                    poolsThatIgnoreBounds
            );
        }
    }

	public ConfiguredStructureFeature<DefaultFeatureConfig, ? extends StructureFeature<DefaultFeatureConfig>> configured(
			DefaultFeatureConfig default1) {
		// TODO Auto-generated method stub
		return null;
	}
}