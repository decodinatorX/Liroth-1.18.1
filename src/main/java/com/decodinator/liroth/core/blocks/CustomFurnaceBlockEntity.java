package com.decodinator.liroth.core.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class CustomFurnaceBlockEntity extends AbstractFurnaceBlockEntity {

    public CustomFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityType.FURNACE, pos, state, RecipeType.SMELTING);
    }

	@Override
	protected Text getContainerName() {
        return Text.translatable("container.furnace");
	}

	@Override
	protected ScreenHandler createScreenHandler(int var1, PlayerInventory var2) {
        return new FurnaceScreenHandler(var1, var2, this, this.propertyDelegate);
	}

}
