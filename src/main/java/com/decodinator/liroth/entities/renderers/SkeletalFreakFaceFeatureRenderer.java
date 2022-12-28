package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.SkeletalFreakEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class SkeletalFreakFaceFeatureRenderer<T extends SkeletalFreakEntity>
extends EyesFeatureRenderer<T, SkeletalFreakModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("liroth", "textures/entity/skeletal_freak/skeletal_freak_face.png"));

    public SkeletalFreakFaceFeatureRenderer(FeatureRendererContext<T, SkeletalFreakModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

