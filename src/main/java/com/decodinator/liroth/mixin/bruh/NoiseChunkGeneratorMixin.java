package com.decodinator.liroth.mixin.bruh;

import com.decodinator.liroth.util.SeedSupplier;
import com.decodinator.liroth.world.generator.LirothFortressStructure;
import com.decodinator.liroth.world.generator.LirothStructures;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.PrimitiveCodec;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.world.gen.chunk.StructuresConfig;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NoiseChunkGenerator.class)
public abstract class NoiseChunkGeneratorMixin extends ChunkGenerator {
	@Unique private static long LAST_SEED = SeedSupplier.MARKER;

	public NoiseChunkGeneratorMixin(BiomeSource biomeSource, StructuresConfig structuresConfig) {
		super(biomeSource, structuresConfig);
	}

	@Redirect(
		method = "method_28550(Lcom/mojang/serialization/codecs/RecordCodecBuilder$Instance;)Lcom/mojang/datafixers/kinds/App;",
		at = @At(
			value = "INVOKE",
			target = "Lcom/mojang/serialization/codecs/PrimitiveCodec;fieldOf(Ljava/lang/String;)Lcom/mojang/serialization/MapCodec;",
			ordinal = 0
		)
	)
	private static MapCodec<Long> giveUsRandomSeeds(PrimitiveCodec<Long> codec, final String name) {
		return codec.fieldOf(name).orElseGet(SeedSupplier::getSeed);
	}

	@ModifyVariable(
		method = "<init>(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/world/biome/source/BiomeSource;Lnet/minecraft/world/biome/source/BiomeSource;JLjava/util/function/Supplier;)V",
		at = @At(
			value = "FIELD",
			target = "Lnet/minecraft/world/gen/chunk/NoiseChunkGenerator;seed:J",
			opcode = Opcodes.PUTFIELD,
			shift = At.Shift.AFTER
		),
		ordinal = 0,
		argsOnly = true
	)
	private long replaceSeed(long seed) {
		if (seed == SeedSupplier.MARKER) {
			return LAST_SEED;
		} else {
			LAST_SEED = seed;
		}

		return seed;
	}
	

    @Inject(
            method = "getEntitySpawnList(Lnet/minecraft/world/biome/Biome;Lnet/minecraft/world/gen/StructureAccessor;Lnet/minecraft/entity/SpawnGroup;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/collection/Pool;",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void structureMobs(Biome biome, StructureAccessor accessor, SpawnGroup group, BlockPos pos, CallbackInfoReturnable<Pool<SpawnSettings.SpawnEntry>> cir) {

        // Check if in our structure and grab mob list if so
        Pool<SpawnSettings.SpawnEntry> pool = getStructureSpawns(biome, accessor, group, pos);

        // If not null, it was in our structure. Return the mob list and exit the method now.
        if(pool != null) cir.setReturnValue(pool);
    }

    /**
     * This mixin hooks into NoiseChunkGenerator's getEntitySpawnList which is where vanilla does the
     * mob spawning in structures over time. We have to check what the spawn group is for the structure
     * and then see if it is inside the structure. Then we grab the list of mobs from the structure that can spawn.
     *
     * This way of doing structure mob spawning will prevent biome's mobs from spawning in the structure.
     */
    private static Pool<SpawnSettings.SpawnEntry> getStructureSpawns(Biome biome, StructureAccessor accessor, SpawnGroup group, BlockPos pos){

        if (group == SpawnGroup.MONSTER) {
            if (accessor.getStructureAt(pos, LirothStructures.LIROTH_FORTRESS).hasChildren()) {
                return LirothFortressStructure.STRUCTURE_MONSTERS;
            }
        }

        return null;
    }
}