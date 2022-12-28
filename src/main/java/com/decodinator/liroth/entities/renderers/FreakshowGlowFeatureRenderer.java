package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.FreakshowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class FreakshowGlowFeatureRenderer<T extends FreakshowEntity>
extends EyesFeatureRenderer<T, FreakshowModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("liroth", "textures/entity/freakshow/freakshow_glow.png"));

    public FreakshowGlowFeatureRenderer(FeatureRendererContext<T, FreakshowModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

