package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.SoulArachnidEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SoulArachnidEntityRenderer extends GeoEntityRenderer<SoulArachnidEntity> {
    public SoulArachnidEntityRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SoulArachnidModel<SoulArachnidEntity>());
        this.addRenderLayer(new SoulArachnidGlowFeatureRenderer(this));
    }
}