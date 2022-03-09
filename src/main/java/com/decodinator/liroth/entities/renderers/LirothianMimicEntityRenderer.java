package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.fluids.LirothFluidRenderingModClient;
import com.decodinator.liroth.entities.FungalFiendEntity;
import com.decodinator.liroth.entities.LirothianMimicEntity;
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

public class LirothianMimicEntityRenderer extends MobEntityRenderer<LirothianMimicEntity, LirothianMimicModel<LirothianMimicEntity>> {

    public LirothianMimicEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new LirothianMimicModel(context.getPart(LirothFluidRenderingModClient.MODEL_LIROTHIAN_MIMIC_LAYER)), 0.5f);
    }
 
    @Override
    public Identifier getTexture(LirothianMimicEntity entity) {
        return new Identifier("liroth", "textures/entity/lirothian_mimic/lirothian_mimic.png");
        
    }
}
