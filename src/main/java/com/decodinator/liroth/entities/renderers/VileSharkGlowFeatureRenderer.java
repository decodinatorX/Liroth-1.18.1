package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.VileSharkEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(value=EnvType.CLIENT)
public class VileSharkGlowFeatureRenderer<T extends VileSharkEntity>
extends EyesLayer<T, VileSharkModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/vile_shark/vile_shark_glow.png"));

    public VileSharkGlowFeatureRenderer(RenderLayerParent<T, VileSharkModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}
