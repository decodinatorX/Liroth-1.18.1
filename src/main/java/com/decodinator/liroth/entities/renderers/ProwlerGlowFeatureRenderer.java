package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.ProwlerEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class ProwlerGlowFeatureRenderer<T extends ProwlerEntity>
extends EyesLayer<T, ProwlerModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/prowler/prowler_glow.png"));

    public ProwlerGlowFeatureRenderer(RenderLayerParent<T, ProwlerModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

