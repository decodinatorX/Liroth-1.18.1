package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.entities.FungalFiendEntity;
import com.decodinator.liroth.entities.PierPeepEntity;
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

public class PierPeepEntityRenderer extends MobEntityRenderer<PierPeepEntity, PierPeepModel<PierPeepEntity>> {

    public PierPeepEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new PierPeepModel(context.getPart(LirothClient.MODEL_PIER_PEEP_LAYER)), 0.5f);
        this.addFeature(new PierPeepGlowFeatureRenderer<PierPeepEntity>(this));
    }
 
    @Override
    public Identifier getTexture(PierPeepEntity entity) {
        return new Identifier("liroth", "textures/entity/pier_peep/pier_peep.png");
        
    }
}
