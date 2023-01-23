package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.entities.FreakshowEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class FreakshowEntityRenderer extends MobRenderer<FreakshowEntity, FreakshowModel<FreakshowEntity>> {

    public FreakshowEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new FreakshowModel(context.bakeLayer(LirothModelLayers.FREAKSHOW)), 0.5f);
        this.addLayer(new FreakshowGlowFeatureRenderer<FreakshowEntity>(this));
        this.addLayer(new FreakshowTranslucentFeatureRenderer<FreakshowEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(FreakshowEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/freakshow/nothing.png");
        
    }
}
