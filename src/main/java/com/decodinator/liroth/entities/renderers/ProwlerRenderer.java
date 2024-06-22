package com.decodinator.liroth.entities.renderers;


import com.decodinator.liroth.entities.ProwlerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ProwlerRenderer extends GeoEntityRenderer<ProwlerEntity> {
    public ProwlerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ProwlerModel<ProwlerEntity>());
        this.addRenderLayer(new ProwlerGlowLayer(this));
    }
}
