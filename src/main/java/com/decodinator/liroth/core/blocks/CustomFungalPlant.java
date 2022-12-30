package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FungusBlock;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class CustomFungalPlant extends FungusBlock {

	public CustomFungalPlant(Settings settings, RegistryKey<ConfiguredFeature<?, ?>> feature, Block block) {
		super(settings, feature, block);
	}

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(LirothBlocks.DAMNATION_SOIL) || /* floor.isOf(Blocks.MYCELIUM) || floor.isOf(Blocks.SOUL_SOIL) ||*/ super.canPlantOnTop(floor, world, pos);
    }
	
}
