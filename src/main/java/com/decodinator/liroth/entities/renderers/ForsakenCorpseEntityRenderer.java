package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.entities.ForsakenCorpseEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class ForsakenCorpseEntityRenderer extends HumanoidMobRenderer<ForsakenCorpseEntity, ForsakenCorpseModel<ForsakenCorpseEntity>> {

    public ForsakenCorpseEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ForsakenCorpseModel<ForsakenCorpseEntity>(context.bakeLayer(LirothModelLayers.FORSAKEN_CORPSE)), 0.5f);
        this.addLayer(new ForsakenCorpseFaceFeatureRenderer<ForsakenCorpseEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(ForsakenCorpseEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/forsaken_corpse/forsaken_corpse.png");
        
    }
}
