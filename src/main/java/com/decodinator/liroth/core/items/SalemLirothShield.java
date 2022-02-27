package com.decodinator.liroth.core.items;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.block.DispenserBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BannerItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class SalemLirothShield
	extends Item {
	    public static final int field_30918 = 5;
	    public static final float field_30919 = 3.0f;
	    public static final String BASE_KEY = "Base";

	    public SalemLirothShield(Item.Settings settings) {
	        super(settings);
	        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
	    }

	    @Override
	    public String getTranslationKey(ItemStack stack) {
	        if (BlockItem.getBlockEntityNbt(stack) != null) {
	            return this.getTranslationKey() + "." + ShieldItem.getColor(stack).getName();
	        }
	        return super.getTranslationKey(stack);
	    }

	    @Override
	    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
	        BannerItem.appendBannerTooltip(stack, tooltip);
	    }

	    @Override
	    public UseAction getUseAction(ItemStack stack) {
	        return UseAction.BLOCK;
	    }

	    @Override
	    public int getMaxUseTime(ItemStack stack) {
	        return 72000;
	    }

	    @Override
	    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
	        ItemStack itemStack = user.getStackInHand(hand);
	        user.setCurrentHand(hand);
	        return TypedActionResult.consume(itemStack);
	    }

	    @Override
	    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
	        return ingredient.isOf(LirothItems.LIROTH_GEM_SALEM) || super.canRepair(stack, ingredient);
	    }
	}