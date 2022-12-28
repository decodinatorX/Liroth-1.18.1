package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.PierPeepEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PierPeepEntityRenderer extends MobEntityRenderer<PierPeepEntity, PierPeepModel<PierPeepEntity>> {

    public PierPeepEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PierPeepModel<PierPeepEntity>(context.getPart(LirothClient.MODEL_PIER_PEEP_LAYER)), 0.5f);
        this.addFeature(new PierPeepGlowFeatureRenderer<PierPeepEntity>(this));
    }
 
    @Override
    public Identifier getTexture(PierPeepEntity entity) {
        return new Identifier("liroth", "textures/entity/pier_peep/pier_peep.png");
        
    }
}
