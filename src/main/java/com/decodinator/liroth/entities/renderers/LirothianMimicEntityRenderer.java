package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.LirothianMimicEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class LirothianMimicEntityRenderer extends MobRenderer<LirothianMimicEntity, LirothianMimicModel<LirothianMimicEntity>> {

    public LirothianMimicEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new LirothianMimicModel<LirothianMimicEntity>(context.bakeLayer(LirothClient.MODEL_LIROTHIAN_MIMIC_LAYER)), 0.5f);
    }
 
    @Override
    public ResourceLocation getTextureLocation(LirothianMimicEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/lirothian_mimic/lirothian_mimic.png");
        
    }
}
