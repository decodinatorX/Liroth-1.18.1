package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.entities.WarpEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class WarpEntityRenderer extends MobRenderer<WarpEntity, WarpModel<WarpEntity>> {

    public WarpEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new WarpModel(context.bakeLayer(LirothModelLayers.WARP)), 0.5f);
        this.addLayer(new WarpGlowFeatureRenderer<WarpEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(WarpEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/warp/warp.png");
        
    }
}
