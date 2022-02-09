package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.fluids.LirothFluidRenderingModClient;
import com.decodinator.liroth.entities.ForsakenCorpseEntity;
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

public class ForsakenCorpseEntityRenderer extends MobEntityRenderer<ForsakenCorpseEntity, ForsakenCorpseModel<ForsakenCorpseEntity>> {

    public ForsakenCorpseEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ForsakenCorpseModel(context.getPart(LirothFluidRenderingModClient.MODEL_FORSAKEN_CORPSE_LAYER)), 0.5f);
        this.addFeature(new ForsakenCorpseFaceFeatureRenderer<ForsakenCorpseEntity>(this));
    }
 
    @Override
    public Identifier getTexture(ForsakenCorpseEntity entity) {
        return new Identifier("liroth", "textures/entity/forsaken_corpse/forsaken_corpse.png");
        
    }
}
