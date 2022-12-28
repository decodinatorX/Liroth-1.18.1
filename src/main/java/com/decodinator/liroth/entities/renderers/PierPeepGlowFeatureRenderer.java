package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.PierPeepEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class PierPeepGlowFeatureRenderer<T extends PierPeepEntity>
extends EyesFeatureRenderer<T, PierPeepModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("liroth", "textures/entity/pier_peep/pier_peep_glow.png"));

    public PierPeepGlowFeatureRenderer(FeatureRendererContext<T, PierPeepModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

