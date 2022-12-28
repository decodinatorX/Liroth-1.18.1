package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.SoulArachnidEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class SoulArachnidEntityRenderer extends MobEntityRenderer<SoulArachnidEntity, SoulArachnidModel<SoulArachnidEntity>> {

    public SoulArachnidEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SoulArachnidModel<SoulArachnidEntity>(context.getPart(LirothClient.MODEL_SOUL_ARACHNID_LAYER)), 0.5f);
        this.addFeature(new SoulArachnidGlowFeatureRenderer<SoulArachnidEntity>(this));
    }
 
    @Override
    public Identifier getTexture(SoulArachnidEntity entity) {
        return new Identifier("liroth", "textures/entity/soul_arachnid/soul_arachnid.png");
        
    }
}
