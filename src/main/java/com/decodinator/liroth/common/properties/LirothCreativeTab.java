package com.decodinator.liroth.common.properties;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothItems;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class LirothCreativeTab {
    public static final ItemGroup creativeTab = FabricItemGroupBuilder.build(new Identifier(Liroth.MOD_ID, "liroth"), () -> new ItemStack(LirothItems.LIROTH_GEM));

    public static void init() {
        Liroth.LOGGER.debug("Liroth: Item Group Created!");
    }
}