package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.ForsakenCorpseEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ForsakenCorpseRenderer extends GeoEntityRenderer<ForsakenCorpseEntity> {
    public ForsakenCorpseRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ForsakenCorpseModel<ForsakenCorpseEntity>());
        this.addRenderLayer(new ForsakenCorpseGlowLayer(this));
    }
}
