package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.util.gui.DimensionalCommunicatorScreenHandler;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class DimensionalCommunicatorEntity extends LootableContainerBlockEntity implements ExtendedScreenHandlerFactory {
	private DefaultedList<ItemStack> items = DefaultedList.ofSize(size(), ItemStack.EMPTY);

	public DimensionalCommunicatorEntity(BlockPos blockPos, BlockState blockState) {
		super(Liroth.DIMENSIONAL_COMMUNICATOR_ENTITY, blockPos, blockState);
	}

	@Override
	protected DefaultedList<ItemStack> getInvStackList() {
		return items;
	}

	@Override
	protected void setInvStackList(DefaultedList<ItemStack> list) {
		this.items = list;
	}

	@Override
	protected Text getContainerName() {
		return new TranslatableText(getCachedState().getBlock().getTranslationKey());
	}

	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new DimensionalCommunicatorScreenHandler(syncId, playerInventory, this);
	}

	@Override
	public int size() {
		return 9;
	}

	@Override
	public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
		buf.writeBlockPos(pos);
	}
}