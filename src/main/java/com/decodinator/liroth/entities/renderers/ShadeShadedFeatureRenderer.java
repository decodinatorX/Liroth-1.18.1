package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.ShadeEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class ShadeShadedFeatureRenderer<T extends ShadeEntity>
extends EyesFeatureRenderer<T, ShadeModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEntityTranslucent(new Identifier("liroth", "textures/entity/shade/shade_shaded.png"));

    public ShadeShadedFeatureRenderer(FeatureRendererContext<T, ShadeModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

