package com.decodinator.liroth.core.blocks.entity;

import com.decodinator.liroth.Liroth;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

@Environment(value= EnvType.CLIENT)
public class QuantumExtractorScreen extends AbstractContainerScreen<QuantumExtractorScreenHandler> {
	private static final ResourceLocation TEXTURE =
            new ResourceLocation(Liroth.MOD_ID, "textures/gui/quantum_extractor_gui.png");

    public QuantumExtractorScreen(QuantumExtractorScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        this.titleLabelX = 42;
        this.titleLabelY = 3;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float delta, int mouseX, int mouseY) {
    	int k;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - this.imageWidth) / 2;
        int y = (height - this.imageHeight) / 2;
        int i = this.leftPos;
        int j = this.topPos;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        if (((QuantumExtractorScreenHandler)this.menu).isBurning()) {
            k = ((QuantumExtractorScreenHandler)this.menu).getFuelProgress();
            guiGraphics.blit(TEXTURE, i + 57, j + 33 + 12 - k, 176, 65 - k, 14, k + 1);
        }
        int s = ((QuantumExtractorScreenHandler)this.menu).getCookProgress(24);
        guiGraphics.blit(TEXTURE, x + 80, y + 24, 176, 0, s + 1, 17);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}