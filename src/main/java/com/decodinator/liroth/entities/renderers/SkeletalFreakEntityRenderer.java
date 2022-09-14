package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.entities.FungalFiendEntity;
import com.decodinator.liroth.entities.SkeletalFreakEntity;
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

public class SkeletalFreakEntityRenderer extends MobEntityRenderer<SkeletalFreakEntity, SkeletalFreakModel<SkeletalFreakEntity>> {

    public SkeletalFreakEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SkeletalFreakModel(context.getPart(LirothClient.MODEL_SKELETAL_FREAK_LAYER)), 0.5f);
        this.addFeature(new SkeletalFreakFaceFeatureRenderer<SkeletalFreakEntity>(this));
    }
 
    @Override
    public Identifier getTexture(SkeletalFreakEntity entity) {
        return new Identifier("liroth", "textures/entity/skeletal_freak/skeletal_freak.png");
        
    }
}
