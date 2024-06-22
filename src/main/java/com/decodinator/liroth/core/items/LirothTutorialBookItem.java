package com.decodinator.liroth.core.items;

import com.decodinator.liroth.core.LirothItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import vazkii.patchouli.api.PatchouliAPI;

public class LirothTutorialBookItem extends Item {
    public LirothTutorialBookItem(Properties properties) {
        super(properties);
    }

    public static boolean isOpen() {
        return BuiltInRegistries.ITEM.getKey(LirothItems.LIROTH_TUTORIAL_BOOK).equals(PatchouliAPI.get().getOpenBookGui());
    }
}
