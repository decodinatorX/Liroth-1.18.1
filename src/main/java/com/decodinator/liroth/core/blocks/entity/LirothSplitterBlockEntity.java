package com.decodinator.liroth.core.blocks.entity;

import javax.annotation.Nullable;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothItems;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.tag.ItemTags;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LirothSplitterBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(5, ItemStack.EMPTY);

    public LirothSplitterBlockEntity(BlockPos pos, BlockState state) {
        super(Liroth.LIROTH_SPLITTER_BLOCK_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Liroth Splitter"); //CHANGE THIS TO TRANSLATEABLE TEXT LATER CODY!
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new LirothSplitterScreenHandler(syncId, inv, this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    // Serialize the BlockEntity
    @Override
    public void writeNbt(NbtCompound nbt) {
        // Save the current value of the number to the tag
    	Inventories.writeNbt(nbt, inventory);
 
        super.writeNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, LirothSplitterBlockEntity entity) {
        if(hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);
        }
    }

    private static void craftItem(LirothSplitterBlockEntity entity) {
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);

        entity.setStack(2, new ItemStack(LirothItems.LIROTH_DUST_ANSALUM, entity.getStack(2).getCount() + 1));
        entity.setStack(3, new ItemStack(LirothItems.LIROTH_DUST_LUX, entity.getStack(3).getCount() + 1));
        entity.setStack(4, new ItemStack(LirothItems.LIROTH_GEM_SALEM, entity.getStack(4).getCount() + 1));
    }

    private static boolean hasRecipe(LirothSplitterBlockEntity entity) {
       boolean hasItemInFirstSlot = entity.getStack(0).getItem() == LirothItems.LIROTH_GEM;
       boolean hasItemInSecondSlot = entity.getStack(1).getItem() == ItemTags.COALS;

        return hasItemInFirstSlot && hasItemInSecondSlot;
    }

    private static boolean hasNotReachedStackLimit(LirothSplitterBlockEntity entity) {
        return entity.getStack(2).getCount() < entity.getStack(2).getMaxCount() ||
        entity.getStack(3).getCount() < entity.getStack(3).getMaxCount() ||
        entity.getStack(4).getCount() < entity.getStack(4).getMaxCount();
    }
}