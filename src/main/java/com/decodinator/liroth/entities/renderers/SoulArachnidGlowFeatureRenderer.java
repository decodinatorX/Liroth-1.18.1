package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.entities.FungalFiendEntity;
import com.decodinator.liroth.entities.SoulArachnidEntity;
import com.decodinator.liroth.entities.WarpEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.render.entity.model.PhantomEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class SoulArachnidGlowFeatureRenderer<T extends SoulArachnidEntity>
extends EyesFeatureRenderer<T, SoulArachnidModel<T>> {
    private static final RenderLayer SKIN = RenderLayer.getEyes(new Identifier("liroth", "textures/entity/soul_arachnid/soul_arachnid_glow.png"));

    public SoulArachnidGlowFeatureRenderer(FeatureRendererContext<T, SoulArachnidModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}

