package com.decodinator.liroth.core.items;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class LirothShield
	extends Item {
	    public static final int field_30918 = 5;
	    public static final float field_30919 = 3.0f;
	    public static final String BASE_KEY = "Base";

	    public LirothShield(Item.Properties settings) {
	        super(settings);
	        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
	    }

	    @Override
	    public String getDescriptionId(ItemStack itemStack) {
	        if (BlockItem.getBlockEntityData(itemStack) != null) {
	            return this.getDescriptionId() + "." + ShieldItem.getColor(itemStack).getName();
	        }
	        return super.getDescriptionId(itemStack);
	    }

	    @Override
	    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
	        BannerItem.appendHoverTextFromBannerBlockEntityTag(itemStack, list);
	    }

	    @Override
	    public UseAnim getUseAnimation(ItemStack itemStack) {
	        return UseAnim.BLOCK;
	    }

	    @Override
	    public int getUseDuration(ItemStack itemStack) {
	        return 72000;
	    }

	    @Override
	    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
	        ItemStack itemStack = player.getItemInHand(interactionHand);
	        player.startUsingItem(interactionHand);
	        return InteractionResultHolder.consume(itemStack);
	    }

	    @Override
	    public boolean isValidRepairItem(ItemStack stack, ItemStack ingredient) {
	        return ingredient.is(LirothItems.LIROTH_GEM) || super.isValidRepairItem(stack, ingredient);
	    }
	}