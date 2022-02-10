package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.fluids.LirothFluidRenderingModClient;
import com.decodinator.liroth.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.entities.FreakshowEntity;
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

public class FreakshowEntityRenderer extends MobEntityRenderer<FreakshowEntity, FreakshowModel<FreakshowEntity>> {

    public FreakshowEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new FreakshowModel(context.getPart(LirothFluidRenderingModClient.MODEL_FREAKSHOW_LAYER)), 0.5f);
        this.addFeature(new FreakshowGlowFeatureRenderer<FreakshowEntity>(this));
        this.addFeature(new FreakshowTranslucentFeatureRenderer<FreakshowEntity>(this));
    }
 
    @Override
    public Identifier getTexture(FreakshowEntity entity) {
        return new Identifier("liroth", "textures/entity/freakshow/nothing.png");
        
    }
}
