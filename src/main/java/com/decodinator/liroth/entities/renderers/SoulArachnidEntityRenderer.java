package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.entities.SoulArachnidEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class SoulArachnidEntityRenderer extends MobRenderer<SoulArachnidEntity, SoulArachnidModel<SoulArachnidEntity>> {

    public SoulArachnidEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new SoulArachnidModel(context.bakeLayer(LirothModelLayers.SOUL_ARACHNID)), 0.5f);
        this.addLayer(new SoulArachnidGlowFeatureRenderer<SoulArachnidEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(SoulArachnidEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/soul_arachnid/soul_arachnid.png");
        
    }
}
