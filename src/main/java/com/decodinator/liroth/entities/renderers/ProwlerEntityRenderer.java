package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.ProwlerEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ProwlerEntityRenderer extends MobEntityRenderer<ProwlerEntity, ProwlerModel<ProwlerEntity>> {

    public ProwlerEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ProwlerModel<ProwlerEntity>(context.getPart(LirothClient.MODEL_PROWLER_LAYER)), 0.5f);
        this.addFeature(new ProwlerGlowFeatureRenderer<ProwlerEntity>(this));
    }
 
    @Override
    public Identifier getTexture(ProwlerEntity entity) {
        return new Identifier("liroth", "textures/entity/prowler/prowler.png");
        
    }
}
