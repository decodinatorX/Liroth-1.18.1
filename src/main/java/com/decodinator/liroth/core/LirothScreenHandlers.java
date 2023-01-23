package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.blocks.entity.LirothSplitterScreenHandler;
import com.decodinator.liroth.core.blocks.entity.QuantumExtractorScreenHandler;

import net.minecraft.core.Registry;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.MenuType.MenuSupplier;

public class LirothScreenHandlers {

    public static final MenuType<LirothSplitterScreenHandler> LIROTH_SPLITTER_SCREEN_HANDLER = LirothScreenHandlers.register(Liroth.MOD_ID.toString() + ":liroth_splitter", LirothSplitterScreenHandler::new);
    public static final MenuType<QuantumExtractorScreenHandler> QUANTUM_EXTRACTOR_SCREEN_HANDLER = LirothScreenHandlers.register(Liroth.MOD_ID.toString() + ":quantum_extractor", QuantumExtractorScreenHandler::new);
    
    private static <T extends AbstractContainerMenu> MenuType<T> register(String string, MenuSupplier<T> menuSupplier) {
        return Registry.register(Registry.MENU, string, new MenuType<T>(menuSupplier));
    }
    
    public void init() {}
}
