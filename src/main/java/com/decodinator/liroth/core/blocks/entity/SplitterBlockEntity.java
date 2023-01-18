package com.decodinator.liroth.core.blocks.entity;

import com.decodinator.liroth.core.LirothRecipeTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SplitterBlockEntity extends LirothSplitterBlockEntity {
	public SplitterBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state, LirothRecipeTypes.LIROTH_SPLITTING);
	}
}