package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.fluids.LirothFluidRenderingModClient;
import com.decodinator.liroth.entities.FungalFiendEntity;
import com.decodinator.liroth.entities.SoulArachnidEntity;
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

public class SoulArachnidEntityRenderer extends MobEntityRenderer<SoulArachnidEntity, SoulArachnidModel<SoulArachnidEntity>> {

    public SoulArachnidEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SoulArachnidModel(context.getPart(LirothFluidRenderingModClient.MODEL_SOUL_ARACHNID_LAYER)), 0.5f);
        this.addFeature(new SoulArachnidGlowFeatureRenderer<SoulArachnidEntity>(this));
    }
 
    @Override
    public Identifier getTexture(SoulArachnidEntity entity) {
        return new Identifier("liroth", "textures/entity/soul_arachnid/soul_arachnid.png");
        
    }
}
