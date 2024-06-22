package com.decodinator.liroth.entities.renderers;


import com.decodinator.liroth.entities.SkeletalFreakEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SkeletalFreakRenderer extends GeoEntityRenderer<SkeletalFreakEntity> {
    public SkeletalFreakRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SkeletalFreakModel<SkeletalFreakEntity>());
        this.addRenderLayer(new SkeletalFreakGlowLayer(this));
    }
}
