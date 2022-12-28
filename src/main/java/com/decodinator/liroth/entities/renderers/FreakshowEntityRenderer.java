package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.FreakshowEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FreakshowEntityRenderer extends MobEntityRenderer<FreakshowEntity, FreakshowModel<FreakshowEntity>> {

    public FreakshowEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FreakshowModel<FreakshowEntity>(context.getPart(LirothClient.MODEL_FREAKSHOW_LAYER)), 0.5f);
        this.addFeature(new FreakshowGlowFeatureRenderer<FreakshowEntity>(this));
        this.addFeature(new FreakshowTranslucentFeatureRenderer<FreakshowEntity>(this));
    }
 
    @Override
    public Identifier getTexture(FreakshowEntity entity) {
        return new Identifier("liroth", "textures/entity/freakshow/nothing.png");
        
    }
}
