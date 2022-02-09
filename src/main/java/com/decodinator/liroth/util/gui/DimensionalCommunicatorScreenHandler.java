package com.decodinator.liroth.util.gui;

import com.decodinator.liroth.Liroth;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.math.BlockPos;


public class DimensionalCommunicatorScreenHandler extends Generic3x3ContainerScreenHandler implements PositionedScreenHandler {
	private final BlockPos pos;

	public DimensionalCommunicatorScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
		super(syncId, playerInventory);
		this.pos = buf.readBlockPos();
	}

	public DimensionalCommunicatorScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(syncId, playerInventory, inventory);
		this.pos = BlockPos.ORIGIN;
	}

	@Override
	public BlockPos getPos() {
		return pos;
	}

	@Override
	public ScreenHandlerType<?> getType() {
		return Liroth.DIMENSIONAL_COMMUNICATOR_SCREEN_HANDLER;
	}
}