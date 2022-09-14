package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.FungalFiendEntity;
import com.decodinator.liroth.entities.renderers.FungalFiendModel;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.DrownedOverlayFeatureRenderer;
import net.minecraft.client.render.entity.feature.EndermanEyesFeatureRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.util.Identifier;

public class FungalFiendEntityRenderer extends MobEntityRenderer<FungalFiendEntity, FungalFiendModel<FungalFiendEntity>> {

    public FungalFiendEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FungalFiendModel(context.getPart(LirothClient.MODEL_FUNGAL_FIEND_LAYER)), 0.5f);
        this.addFeature(new FungalFiendFaceFeatureRenderer<FungalFiendEntity>(this));
    }
 
    @Override
    public Identifier getTexture(FungalFiendEntity entity) {
        return new Identifier("liroth", "textures/entity/fungal_fiend/fungal_fiend.png");
        
    }
}
