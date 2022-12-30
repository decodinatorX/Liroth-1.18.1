package com.decodinator.liroth.core.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class UnusedSpawnEggItem extends SpawnEggItem {

	public UnusedSpawnEggItem(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Item.Settings settings) {
		super(type, 0, 0, settings);
	}
	
	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
	    tooltip.add(Text.translatable("item.liroth.anomaly_charge.desc"));
	}
}
