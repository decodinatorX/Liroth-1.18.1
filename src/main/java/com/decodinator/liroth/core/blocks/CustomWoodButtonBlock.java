package com.decodinator.liroth.core.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.Direction;

public class CustomWoodButtonBlock extends ButtonBlock {
    public CustomWoodButtonBlock(AbstractBlock.Settings settings, int pressTicks, boolean wooden, SoundEvent clickOffSound, SoundEvent clickOnSound) {
		super(settings, pressTicks, wooden, clickOffSound, clickOffSound);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH)).with(POWERED, false)).with(FACE, WallMountLocation.WALL));
	}
}
