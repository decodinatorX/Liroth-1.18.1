package com.decodinator.liroth.core.blocks;

import net.minecraft.block.DoorBlock;
import net.minecraft.sound.SoundEvents;

public class CustomDoorBlock extends DoorBlock {

	public CustomDoorBlock(Settings settings) {
		super(settings, SoundEvents.BLOCK_WOODEN_DOOR_OPEN, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE);
	}

}
