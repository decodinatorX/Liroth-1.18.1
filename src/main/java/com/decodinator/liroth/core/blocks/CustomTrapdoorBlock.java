package com.decodinator.liroth.core.blocks;

import net.minecraft.block.TrapdoorBlock;
import net.minecraft.sound.SoundEvents;

public class CustomTrapdoorBlock extends TrapdoorBlock {

	public CustomTrapdoorBlock(Settings settings) {
		super(settings, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN, SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE);
	}

}
