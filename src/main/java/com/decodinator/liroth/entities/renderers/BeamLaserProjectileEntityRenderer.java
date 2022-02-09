package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.projectiles.BeamLaserProjectileEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class BeamLaserProjectileEntityRenderer
extends ProjectileEntityRenderer<BeamLaserProjectileEntity> {
    public static final Identifier TEXTURE = new Identifier("liroth", "textures/entity/beam.png");

    public BeamLaserProjectileEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(BeamLaserProjectileEntity arrowEntity) {
        return TEXTURE;
    }
}
