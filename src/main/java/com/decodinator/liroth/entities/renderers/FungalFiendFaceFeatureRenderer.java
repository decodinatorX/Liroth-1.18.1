package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.FungalFiendEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class FungalFiendFaceFeatureRenderer<T extends FungalFiendEntity>
extends EyesFeatureRenderer<T, FungalFiendModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("liroth", "textures/entity/fungal_fiend/fungal_fiend_face.png"));

    public FungalFiendFaceFeatureRenderer(FeatureRendererContext<T, FungalFiendModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

