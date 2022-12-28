package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.FungalFiendEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FungalFiendEntityRenderer extends MobEntityRenderer<FungalFiendEntity, FungalFiendModel<FungalFiendEntity>> {

    public FungalFiendEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FungalFiendModel<FungalFiendEntity>(context.getPart(LirothClient.MODEL_FUNGAL_FIEND_LAYER)), 0.5f);
        this.addFeature(new FungalFiendFaceFeatureRenderer<FungalFiendEntity>(this));
    }
 
    @Override
    public Identifier getTexture(FungalFiendEntity entity) {
        return new Identifier("liroth", "textures/entity/fungal_fiend/fungal_fiend.png");
        
    }
}
