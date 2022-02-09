package com.decodinator.liroth.util.gui;

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

import com.decodinator.liroth.Liroth;

import net.fabricmc.api.ClientModInitializer;

public class ClientScreenHandlerTest implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ScreenRegistry.register(Liroth.DIMENSIONAL_COMMUNICATOR_SCREEN_HANDLER, PositionedScreen::new);
	}
}