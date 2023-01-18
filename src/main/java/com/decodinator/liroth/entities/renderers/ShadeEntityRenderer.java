package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.entities.ShadeEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class ShadeEntityRenderer extends MobRenderer<ShadeEntity, ShadeModel<ShadeEntity>>{

	public ShadeEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ShadeModel(context.bakeLayer(LirothModelLayers.SHADE)), 0.5f);
		this.addLayer(new ShadeShadedFeatureRenderer<ShadeEntity>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(ShadeEntity entity) {
		Minecraft mc = Minecraft.getInstance();

		if (!(mc.getCameraEntity() instanceof AbstractClientPlayer)) {
			return DefaultPlayerSkin.getDefaultSkin(entity.getUUID());
		}

		return ((AbstractClientPlayer) mc.getCameraEntity()).getSkinTextureLocation();	}
}
