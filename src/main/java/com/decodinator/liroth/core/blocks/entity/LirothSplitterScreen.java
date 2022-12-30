package com.decodinator.liroth.core.blocks.entity;

import com.decodinator.liroth.Liroth;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class LirothSplitterScreen extends HandledScreen<LirothSplitterScreenHandler> {
	private static final Identifier TEXTURE =
            new Identifier(Liroth.MOD_ID, "textures/gui/liroth_splitter_gui.png");

    public LirothSplitterScreen(LirothSplitterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        this.titleX = 32;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        int k;
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        int i = this.x;
        int j = this.y;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
        if (((LirothSplitterScreenHandler)this.handler).isBurning()) {
            k = ((LirothSplitterScreenHandler)this.handler).getFuelProgress();
            this.drawTexture(matrices, i + 53, j + 36 + 12 - k, 176, 65 - k, 14, k + 1);
        }
        k = ((LirothSplitterScreenHandler)this.handler).getCookProgress(34);
        this.drawTexture(matrices, i + 73, j + 15, 176, 0, k, 53);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}