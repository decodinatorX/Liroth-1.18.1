package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.FreakshowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class FreakshowTranslucentFeatureRenderer<T extends FreakshowEntity>
extends EyesFeatureRenderer<T, FreakshowModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEntityTranslucent(new Identifier("liroth", "textures/entity/freakshow/freakshow.png"));

    public FreakshowTranslucentFeatureRenderer(FeatureRendererContext<T, FreakshowModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

