package com.decodinator.liroth.core.blocks;

import net.minecraft.block.DoorBlock;
import net.minecraft.sound.SoundEvents;

public class CustomMetalDoorBlock extends DoorBlock {

	public CustomMetalDoorBlock(Settings settings) {
		super(settings, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundEvents.BLOCK_IRON_DOOR_CLOSE);
	}

}
