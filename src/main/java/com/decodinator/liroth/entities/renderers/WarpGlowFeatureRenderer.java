package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.WarpEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class WarpGlowFeatureRenderer<T extends WarpEntity>
extends EyesFeatureRenderer<T, WarpModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("liroth", "textures/entity/warp/warp_glow.png"));

    public WarpGlowFeatureRenderer(FeatureRendererContext<T, WarpModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

