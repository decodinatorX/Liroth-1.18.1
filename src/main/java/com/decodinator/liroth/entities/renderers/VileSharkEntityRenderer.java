package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.FungalFiendEntity;
import com.decodinator.liroth.entities.VileSharkEntity;
import com.decodinator.liroth.entities.WarpEntity;
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

public class VileSharkEntityRenderer extends MobEntityRenderer<VileSharkEntity, VileSharkModel<VileSharkEntity>> {

    public VileSharkEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new VileSharkModel(context.getPart(LirothClient.MODEL_VILE_SHARK_LAYER)), 0.5f);
        this.addFeature(new VileSharkGlowFeatureRenderer<VileSharkEntity>(this));
    }
 
    @Override
    public Identifier getTexture(VileSharkEntity entity) {
        return new Identifier("liroth", "textures/entity/vile_shark/vile_shark.png");
        
    }
}
