package com.decodinator.liroth.core.items;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class UnusedItem extends Item {

	public UnusedItem(Properties settings) {
		super(settings);
	}
	
	@Override
	public void appendHoverText(ItemStack itemStack, Level world, List<Component> tooltip, TooltipFlag tooltipContext) {
	    tooltip.add(Component.translatable("item.liroth.anomaly_charge.desc"));
	}
}
