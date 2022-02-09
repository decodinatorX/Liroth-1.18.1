package com.decodinator.liroth.util.gui;

import java.util.Optional;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class PositionedScreen extends HandledScreen<ScreenHandler> {
	private static final Identifier TEXTURE = new Identifier("liroth", "textures/gui/container/dimensional_communicator.png");

	public PositionedScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, getPositionText(handler).orElse(title));
	}

	private static Optional<Text> getPositionText(ScreenHandler handler) {
		if (handler instanceof PositionedScreenHandler) {
			BlockPos pos = ((PositionedScreenHandler) handler).getPos();
			return pos != null ? Optional.of(new LiteralText("(" + pos.toShortString() + ")")) : Optional.empty();
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		renderBackground(matrices);
		super.render(matrices, mouseX, mouseY, delta);
		drawMouseoverTooltip(matrices, mouseX, mouseY);
	}

	@Override
	protected void init() {
		super.init();
		// Center the title
		titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
	}

	@Override
	protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - backgroundWidth) / 2;
		int y = (height - backgroundHeight) / 2;
		drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
	}
}