package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.VileSharkEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class VileSharkGlowFeatureRenderer<T extends VileSharkEntity>
extends EyesFeatureRenderer<T, VileSharkModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("liroth", "textures/entity/vile_shark/vile_shark_glow.png"));

    public VileSharkGlowFeatureRenderer(FeatureRendererContext<T, VileSharkModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

