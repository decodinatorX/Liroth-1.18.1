package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.SkeletalFreakEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class SkeletalFreakFaceFeatureRenderer<T extends SkeletalFreakEntity>
extends EyesLayer<T, SkeletalFreakModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/skeletal_freak/skeletal_freak_face.png"));

    public SkeletalFreakFaceFeatureRenderer(RenderLayerParent<T, SkeletalFreakModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

