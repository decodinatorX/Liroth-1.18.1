package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.ProwlerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class ProwlerGlowFeatureRenderer<T extends ProwlerEntity>
extends EyesFeatureRenderer<T, ProwlerModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("liroth", "textures/entity/prowler/prowler_glow.png"));

    public ProwlerGlowFeatureRenderer(FeatureRendererContext<T, ProwlerModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

