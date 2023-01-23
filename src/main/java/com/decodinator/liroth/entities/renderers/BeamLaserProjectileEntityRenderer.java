package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.projectiles.BeamLaserProjectileEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class BeamLaserProjectileEntityRenderer
extends ArrowRenderer<BeamLaserProjectileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("liroth", "textures/entity/beam.png");

    public BeamLaserProjectileEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(BeamLaserProjectileEntity arrowEntity) {
        return TEXTURE;
    }
}
