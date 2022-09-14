package com.decodinator.liroth.core.blocks;

import java.util.function.Supplier;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FungusBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

public class CustomFungalPlant extends FungusBlock {

	public CustomFungalPlant(Settings settings, Supplier<RegistryEntry<ConfiguredFeature<HugeFungusFeatureConfig, ?>>> feature) {
		super(settings, feature);
	}

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(LirothBlocks.DAMNATION_SOIL) || /* floor.isOf(Blocks.MYCELIUM) || floor.isOf(Blocks.SOUL_SOIL) ||*/ super.canPlantOnTop(floor, world, pos);
    }
	
}
