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
import net.minecraft.world.entity.player.Player;

@Environment(value= EnvType.CLIENT)
public class LirothSplitterScreen extends AbstractContainerScreen<LirothSplitterScreenHandler> {
	private Player entity;
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Liroth.MOD_ID, "textures/gui/liroth_splitter_gui.png");

    public LirothSplitterScreen(LirothSplitterScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        this.titleLabelX = 32;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float delta, int mouseX, int mouseY) {
        int k;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        int i = this.leftPos;
        int j = this.topPos;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        if (((LirothSplitterScreenHandler)this.menu).isBurning()) {
            k = ((LirothSplitterScreenHandler)this.menu).getFuelProgress();
            guiGraphics.blit(TEXTURE, i + 53, j + 36 + 12 - k, 176, 65 - k, 14, k + 1);
        }
        k = ((LirothSplitterScreenHandler)this.menu).getCookProgress(34);
        guiGraphics.blit(TEXTURE, i + 73, j + 15, 176, 0, k, 53);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}