package com.decodinator.liroth.core.blocks;

import net.minecraft.block.PressurePlateBlock;
import net.minecraft.sound.SoundEvents;

public class CustomPressurePlateBlock extends PressurePlateBlock {

	public CustomPressurePlateBlock(ActivationRule type, Settings settings) {
		super(type, settings, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF);
	}

}
