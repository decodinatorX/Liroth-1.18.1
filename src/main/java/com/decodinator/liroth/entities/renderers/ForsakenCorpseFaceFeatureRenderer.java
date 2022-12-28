package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.ForsakenCorpseEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class ForsakenCorpseFaceFeatureRenderer<T extends ForsakenCorpseEntity>
extends EyesFeatureRenderer<T, ForsakenCorpseModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("liroth", "textures/entity/forsaken_corpse/forsaken_corpse_face.png"));

    public ForsakenCorpseFaceFeatureRenderer(FeatureRendererContext<T, ForsakenCorpseModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

