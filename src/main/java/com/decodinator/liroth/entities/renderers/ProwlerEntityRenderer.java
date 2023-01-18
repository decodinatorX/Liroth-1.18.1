package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.entities.ProwlerEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class ProwlerEntityRenderer extends MobRenderer<ProwlerEntity, ProwlerModel<ProwlerEntity>> {

    public ProwlerEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ProwlerModel(context.bakeLayer(LirothModelLayers.PROWLER)), 0.5f);
        this.addLayer(new ProwlerGlowFeatureRenderer<ProwlerEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(ProwlerEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/prowler/prowler.png");
        
    }
}
