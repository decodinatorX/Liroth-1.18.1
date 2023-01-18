package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.entities.SkeletalFreakEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class SkeletalFreakEntityRenderer extends MobRenderer<SkeletalFreakEntity, SkeletalFreakModel<SkeletalFreakEntity>> {

    public SkeletalFreakEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new SkeletalFreakModel(context.bakeLayer(LirothModelLayers.SKELETAL_FREAK)), 0.5f);
        this.addLayer(new SkeletalFreakFaceFeatureRenderer<SkeletalFreakEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(SkeletalFreakEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/skeletal_freak/skeletal_freak.png");
        
    }
}
