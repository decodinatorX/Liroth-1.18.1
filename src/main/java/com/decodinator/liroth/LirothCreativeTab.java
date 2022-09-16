package com.decodinator.liroth;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothItems;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class LirothCreativeTab {
    public static final ItemGroup creativeItemsTab = FabricItemGroupBuilder.build(new Identifier(Liroth.MOD_ID, "liroth_items"), () -> new ItemStack(LirothItems.LIROTH_GEM));
    public static final ItemGroup creativeBlocksTab = FabricItemGroupBuilder.build(new Identifier(Liroth.MOD_ID, "liroth_blocks"), () -> new ItemStack(LirothBlocks.LIROTH_GEM_BLOCK));
    public static final ItemGroup creativeCombatTab = FabricItemGroupBuilder.build(new Identifier(Liroth.MOD_ID, "liroth_combat"), () -> new ItemStack(LirothItems.LIROTH_SWORD));
    public static final ItemGroup creativeEntitiesTab = FabricItemGroupBuilder.build(new Identifier(Liroth.MOD_ID, "liroth_entities"), () -> new ItemStack(LirothItems.FORSAKEN_CORPSE_SPAWN_EGG));
    public static final ItemGroup creativePlantsTab = FabricItemGroupBuilder.build(new Identifier(Liroth.MOD_ID, "liroth_plants"), () -> new ItemStack(LirothBlocks.LIROTH_ROSE));

    public static void init() {
        Liroth.LOGGER.debug("Liroth: Item Groups Created!");
    }
}