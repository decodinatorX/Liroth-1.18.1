package com.decodinator.liroth.core;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.mixin.access.HoeItemAccess;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemUsageContext;

public class LirothHoeables {
    public static void tillablesLiroth() {
        Liroth.LOGGER.debug("Liroth: Adding tillables...");
        Map<Block, Pair<Predicate<ItemUsageContext>, Consumer<ItemUsageContext>>> tillables = new IdentityHashMap<>(HoeItemAccess.getTillables());
        tillables.put(LirothBlocks.LIROTH_GRASS_BLOCK, Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(LirothBlocks.LIROTH_FARMLAND_BLOCK.getDefaultState())));
        tillables.put(LirothBlocks.LIROTH_DIRT, Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(LirothBlocks.LIROTH_FARMLAND_BLOCK.getDefaultState())));
        tillables.put(LirothBlocks.PIER_GRASS_BLOCK, Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(LirothBlocks.PIER_FARMLAND_BLOCK.getDefaultState())));
        tillables.put(LirothBlocks.PIER_DIRT, Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(LirothBlocks.PIER_FARMLAND_BLOCK.getDefaultState())));
        tillables.put(LirothBlocks.SPINERIOS_GRASS_BLOCK, Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(LirothBlocks.SPINERIOS_FARMLAND_BLOCK.getDefaultState())));
        tillables.put(LirothBlocks.SPINERIOS_DIRT, Pair.of(HoeItem::canTillFarmland, HoeItem.createTillAction(LirothBlocks.SPINERIOS_FARMLAND_BLOCK.getDefaultState())));
        HoeItemAccess.setTillables(tillables);
        Liroth.LOGGER.info("Liroth: Added tillables!");
    }
}