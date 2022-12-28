package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.WarpEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class WarpEntityRenderer extends MobEntityRenderer<WarpEntity, WarpModel<WarpEntity>> {

    public WarpEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new WarpModel<WarpEntity>(context.getPart(LirothClient.MODEL_WARP_LAYER)), 0.5f);
        this.addFeature(new WarpGlowFeatureRenderer<WarpEntity>(this));
    }
 
    @Override
    public Identifier getTexture(WarpEntity entity) {
        return new Identifier("liroth", "textures/entity/warp/warp.png");
        
    }
}
