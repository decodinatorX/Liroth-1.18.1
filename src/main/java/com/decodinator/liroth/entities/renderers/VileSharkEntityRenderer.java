package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.VileSharkEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class VileSharkEntityRenderer extends MobEntityRenderer<VileSharkEntity, VileSharkModel<VileSharkEntity>> {

    public VileSharkEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new VileSharkModel<VileSharkEntity>(context.getPart(LirothClient.MODEL_VILE_SHARK_LAYER)), 0.5f);
        this.addFeature(new VileSharkGlowFeatureRenderer<VileSharkEntity>(this));
    }
 
    @Override
    public Identifier getTexture(VileSharkEntity entity) {
        return new Identifier("liroth", "textures/entity/vile_shark/vile_shark.png");
        
    }
}
