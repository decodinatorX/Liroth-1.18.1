package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.SkeletalFreakEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SkeletalFreakEntityRenderer extends MobEntityRenderer<SkeletalFreakEntity, SkeletalFreakModel<SkeletalFreakEntity>> {

    public SkeletalFreakEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SkeletalFreakModel<SkeletalFreakEntity>(context.getPart(LirothClient.MODEL_SKELETAL_FREAK_LAYER)), 0.5f);
        this.addFeature(new SkeletalFreakFaceFeatureRenderer<SkeletalFreakEntity>(this));
    }
 
    @Override
    public Identifier getTexture(SkeletalFreakEntity entity) {
        return new Identifier("liroth", "textures/entity/skeletal_freak/skeletal_freak.png");
        
    }
}
