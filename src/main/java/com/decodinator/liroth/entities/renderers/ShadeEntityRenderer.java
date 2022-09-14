package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.ShadeEntity;
import com.decodinator.liroth.entities.WarpEntity;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.util.Identifier;

public class ShadeEntityRenderer extends MobEntityRenderer<ShadeEntity, ShadeModel<ShadeEntity>>{

	public ShadeEntityRenderer(Context context, ShadeModel<ShadeEntity> entityModel, float f) {
		super(context, new ShadeModel(context.getPart(LirothClient.MODEL_SHADE_LAYER)), 0.5f);
		this.addFeature(new ShadeShadedFeatureRenderer<ShadeEntity>(this));
	}

	@Override
	public Identifier getTexture(ShadeEntity abstractClientPlayerEntity) {
		MinecraftClient mc = MinecraftClient.getInstance();

		if (!(mc.getCameraEntity() instanceof AbstractClientPlayerEntity)) {
			return DefaultSkinHelper.getTexture(abstractClientPlayerEntity.getUuid());
		}

		return ((AbstractClientPlayerEntity) mc.getCameraEntity()).getSkinTexture();
	}
}
