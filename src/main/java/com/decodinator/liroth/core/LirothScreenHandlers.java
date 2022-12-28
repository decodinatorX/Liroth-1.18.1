package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.blocks.entity.LirothSplitterScreenHandler;
import com.decodinator.liroth.core.blocks.entity.QuantumExtractorScreenHandler;

import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.ScreenHandlerType.Factory;
import net.minecraft.util.registry.Registry;

public class LirothScreenHandlers<T extends ScreenHandler> {

    public static final ScreenHandlerType<LirothSplitterScreenHandler> LIROTH_SPLITTER_SCREEN_HANDLER = LirothScreenHandlers.register(Liroth.MOD_ID.toString() + ":liroth_splitter", LirothSplitterScreenHandler::new);
    public static final ScreenHandlerType<QuantumExtractorScreenHandler> QUANTUM_EXTRACTOR_SCREEN_HANDLER = LirothScreenHandlers.register(Liroth.MOD_ID.toString() + ":quantum_extractor", QuantumExtractorScreenHandler::new);
    
    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, Factory<T> factory) {
        return Registry.register(Registry.SCREEN_HANDLER, id, new ScreenHandlerType<T>(factory));
    }
    public void init() {}
}
