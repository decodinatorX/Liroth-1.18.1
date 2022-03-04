package com.decodinator.liroth.core.blocks.entity;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Map;

import org.jetbrains.annotations.Nullable;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothItems;
import com.decodinator.liroth.core.blocks.LirothSplitterBlock;
import com.decodinator.liroth.core.blocks.QuantumExtractorBlock;
import com.google.common.collect.Maps;

public class QuantumExtractorBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(4, ItemStack.EMPTY);
	private static final Map<Item, Integer> AVAILABLE_FUELS = Maps.newHashMap();
    private int timer;
    int burnTime;
    int fuelTime;
    int cookTime;
    int cookTimeTotal = this.getCookTime();
    protected final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int get(int index) {
            switch (index) {
                case 0: {
                    return QuantumExtractorBlockEntity.this.burnTime;
                }
                case 1: {
                    return QuantumExtractorBlockEntity.this.fuelTime;
                }
                case 2: {
                    return QuantumExtractorBlockEntity.this.cookTime;
                }
                case 3: {
                    return QuantumExtractorBlockEntity.this.cookTimeTotal;
                }
            }
            return 0;
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0: {
                	QuantumExtractorBlockEntity.this.burnTime = value;
                    break;
                }
                case 1: {
                	QuantumExtractorBlockEntity.this.fuelTime = value;
                    break;
                }
                case 2: {
                	QuantumExtractorBlockEntity.this.cookTime = value;
                    break;
                }
                case 3: {
                	QuantumExtractorBlockEntity.this.cookTimeTotal = value;
                    break;
                }
            }
        }

        @Override
        public int size() {
            return 4;
        }
    };

	protected int processTime;
	protected int totalProcessTime;
	private int ticks;

	// uses for both tile entity and jei recipe viewer
	public static final int totalTime = 50;

	public int getField(int id) {
		switch (id) {
		case 0:
			return this.processTime;
		case 1:
			return this.totalProcessTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.processTime = value;
			break;
		case 1:
			this.totalProcessTime = value;
			break;
		}
	}

	public int getFieldCount() {
		return 2;
	}

    public QuantumExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(Liroth.QUANTUM_EXTRACTOR_BLOCK_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("container.quantum_extractor");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new QuantumExtractorScreenHandler(syncId, inv, this, propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        this.burnTime = nbt.getInt("BurnTime");
        this.cookTime = nbt.getInt("CookTime");
        this.cookTimeTotal = nbt.getInt("CookTimeTotal");
        this.timer = 0;
        this.fuelTime = getFuelTime(this.inventory.get(1));
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("BurnTime", this.burnTime);
        nbt.putInt("CookTime", this.cookTime);
        nbt.putInt("CookTimeTotal", this.cookTimeTotal);
        super.writeNbt(nbt);
		return;
    }
    
    public void forceUpdateAllStates() {
        BlockState state = world.getBlockState(pos);
        if (state.get(QuantumExtractorBlock.LIT) != burnTime > 0) {
            world.setBlockState(pos, state.with(QuantumExtractorBlock.LIT, burnTime > 0), 3);
        }
    }
    
    public static void playSound(World world, BlockPos pos, SoundEvent sound) {
        world.playSound(null, pos, sound, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }

    public static void tick(World world, BlockPos pos, BlockState state, QuantumExtractorBlockEntity entity) {
        boolean bl = entity.isBurning();
        boolean bl2 = false;
        if (entity.isBurning()) {
            --entity.burnTime;
        }
        ItemStack itemStack = entity.inventory.get(1);
        if (entity.isBurning() || !itemStack.isEmpty() && !entity.inventory.get(0).isEmpty()) {
            int i = entity.getMaxCountPerStack();
            if (!entity.isBurning()) {
                entity.fuelTime = entity.burnTime = entity.getFuelTime(itemStack);
                if (entity.isBurning() && QuantumExtractorBlockEntity.hasRecipe(entity)) {
                    bl2 = true;
                    if (!itemStack.isEmpty()) {
                        Item item = itemStack.getItem();
                        itemStack.decrement(1);
                        if (itemStack.isEmpty()) {
                            Item item2 = item.getRecipeRemainder();
                            entity.inventory.set(1, item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
                        }
                    }
                }
            }
            if (entity.isBurning() && QuantumExtractorBlockEntity.hasRecipe(entity)) {
                ++entity.cookTime;
                if (entity.cookTime == entity.cookTimeTotal) {
                    entity.cookTime = 0;
                    entity.cookTimeTotal = QuantumExtractorBlockEntity.getCookTime();
                    QuantumExtractorBlockEntity.craftItem(entity);
                    bl2 = true;
                }
            } else {
                entity.cookTime = 0;
            }
        } else if (!entity.isBurning() && entity.cookTime > 0) {
            entity.cookTime = MathHelper.clamp(entity.cookTime - 2, 0, entity.cookTimeTotal);
        }
        if (bl != entity.isBurning()) {
            bl2 = true;
            state = (BlockState)state.with(QuantumExtractorBlock.LIT, entity.isBurning());
            world.setBlockState(pos, state, Block.NOTIFY_ALL);
        }
        if (bl2) {
        	QuantumExtractorBlockEntity.markDirty(world, pos, state);
        }
    }

    private static void craftItem(QuantumExtractorBlockEntity entity) {
    	
        entity.removeStack(0, 1);
        
/*        if (entity.getStack(1).getItem() == Blocks.REDSTONE_BLOCK.asItem()) {
        	entity.removeStack(1, 1);
        	entity.setStack(2, new ItemStack(LirothBlocks.REDSTONE_BROKEN_STAGE_1.asItem(), entity.getStack(2).getCount() + 1));
        }
        if (entity.getStack(1).getItem() == LirothBlocks.REDSTONE_BROKEN_STAGE_1.asItem()) {
        	entity.removeStack(1, 1);
        	entity.setStack(2, new ItemStack(LirothBlocks.REDSTONE_BROKEN_STAGE_2.asItem(), entity.getStack(2).getCount() + 1));
        }
        if (entity.getStack(1).getItem() == LirothBlocks.REDSTONE_BROKEN_STAGE_2.asItem()) {
        	entity.removeStack(1, 1);
        	entity.setStack(2, new ItemStack(LirothBlocks.REDSTONE_BROKEN_STAGE_3.asItem(), entity.getStack(2).getCount() + 1));
        }
        if (entity.getStack(1).getItem() == LirothBlocks.REDSTONE_BROKEN_STAGE_3.asItem()) {
        	entity.removeStack(1, 1);
        }*/
        entity.setStack(2, new ItemStack(Items.DIAMOND, entity.getStack(2).getCount() + 1));
        entity.setStack(3, new ItemStack(LirothItems.QUANTUM_PLATE, entity.getStack(3).getCount() + 1));
        
        entity.ticks = 0;
    }

    private static boolean hasRecipe(QuantumExtractorBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == LirothItems.QUANTUM_DIAMOND;

        return hasItemInFirstSlot;
    }

    private static boolean hasNotReachedStackLimit(QuantumExtractorBlockEntity entity) {
        return /*entity.getStack(2).getCount() < entity.getStack(2).getMaxCount() ||*/
        	   entity.getStack(2).getCount() < entity.getStack(2).getMaxCount() ||
        	   entity.getStack(3).getCount() < entity.getStack(3).getMaxCount();
    }
    
    private static int getCookTime() {
        return (200);
    }
    
    public boolean isBurning() {
        return this.burnTime > 0;
    }
    
	protected int getFuelTime(ItemStack fuel) {
		if (fuel.isEmpty()) {
			return 0;
		} else if (fuel.isOf(Blocks.REDSTONE_BLOCK.asItem())) {
			return 600;
/*		} else if (fuel.isOf(LirothBlocks.REDSTONE_BROKEN_STAGE_1.asItem())) {
			return 16000;
		} else if (fuel.isOf(LirothBlocks.REDSTONE_BROKEN_STAGE_2.asItem())) {
			return 16000;
		} else if (fuel.isOf(LirothBlocks.REDSTONE_BROKEN_STAGE_3.asItem())) {
			return 16000;*/
		}
		return 0;
	}
    
    @Override
    public boolean isValid(int slot, ItemStack stack) {
        if (slot == 2 || slot == 3) {
            return false;
        }
        if (slot == 1) {
            ItemStack itemStack = this.inventory.get(1);
            return AbstractFurnaceBlockEntity.canUseAsFuel(stack) || stack.isOf(Items.BUCKET) && !itemStack.isOf(Items.BUCKET);
        }
        return true;
    }
	
	private static int getFabricFuel(ItemStack stack) {
		Integer ticks = FuelRegistry.INSTANCE.get(stack.getItem());
		return ticks == null ? 0 : ticks;
	}
    
    private static boolean tickReached100(QuantumExtractorBlockEntity entity) {
    	return entity.ticks <= getCookTime();
    }
}