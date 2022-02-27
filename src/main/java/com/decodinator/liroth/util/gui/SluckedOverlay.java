package com.decodinator.liroth.util.gui;



import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Matrix4f;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.util.TheBitchHasTheSchluck;
import com.google.common.eventbus.Subscribe;
import com.mojang.blaze3d.platform.GlStateManager;


public class SluckedOverlay {
	
    private static final Identifier SCHLUCKED_TEXTURE = new Identifier("liroth:textures/schlucked_outline.png");
	
    public static void renderSchluckedOverlay(MinecraftClient client, MatrixStack matrices) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.enableTexture();
		RenderSystem.setShaderTexture(0, SCHLUCKED_TEXTURE);
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        float f = client.player.getBrightnessAtEyes();
        PlayerEntity entity = MinecraftClient.getInstance().player;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderColor(f, f, f, 0.1f);
        float g = 4.0f;
        float h = -1.0f;
        float i = 1.0f;
        float j = -1.0f;
        float k = 1.0f;
        float l = -0.5f;
        float m = -client.player.getYaw() / 64.0f;
        float n = client.player.getPitch() / 64.0f;
        Matrix4f matrix4f = matrices.peek().getPositionMatrix();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrix4f, -1.0f, -1.0f, -0.5f).texture(4.0f + m, 4.0f + n).next();
        bufferBuilder.vertex(matrix4f, 1.0f, -1.0f, -0.5f).texture(0.0f + m, 4.0f + n).next();
        bufferBuilder.vertex(matrix4f, 1.0f, 1.0f, -0.5f).texture(0.0f + m, 0.0f + n).next();
        bufferBuilder.vertex(matrix4f, -1.0f, 1.0f, -0.5f).texture(4.0f + m, 0.0f + n).next();
        bufferBuilder.end();
        BufferRenderer.draw(bufferBuilder);
        RenderSystem.disableBlend();
    }
}
