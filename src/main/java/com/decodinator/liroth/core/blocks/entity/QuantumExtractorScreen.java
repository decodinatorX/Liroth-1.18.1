package com.decodinator.liroth.core.blocks.entity;

import com.decodinator.liroth.Liroth;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class QuantumExtractorScreen extends HandledScreen<QuantumExtractorScreenHandler> {
	private static final Identifier TEXTURE =
            new Identifier(Liroth.MOD_ID, "textures/gui/quantum_extractor_gui.png");

    public QuantumExtractorScreen(QuantumExtractorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        this.titleX = 42;
        this.titleY = 3;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
    	int k;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - this.backgroundWidth) / 2;
        int y = (height - this.backgroundHeight) / 2;
        int i = this.x;
        int j = this.y;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        if (((QuantumExtractorScreenHandler)this.handler).isBurning()) {
            k = ((QuantumExtractorScreenHandler)this.handler).getFuelProgress();
            this.drawTexture(matrices, i + 57, j + 33 + 12 - k, 176, 65 - k, 14, k + 1);
        }
        int s = ((QuantumExtractorScreenHandler)this.handler).getCookProgress(24);
        this.drawTexture(matrices, x + 80, y + 24, 176, 0, s + 1, 17);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}