package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.SoulArachnidEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SoulArachnidGlowFeatureRenderer
        extends GeoRenderLayer<SoulArachnidEntity> {
    private static final ResourceLocation SKIN = new ResourceLocation("liroth", "textures/entity/soul_arachnid/soul_arachnid_glow.png");

    public SoulArachnidGlowFeatureRenderer(GeoRenderer<SoulArachnidEntity> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(PoseStack poseStack, SoulArachnidEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType armorRenderType = RenderType.eyes(SKIN);
        if (animatable.isInvisible()) {
            return;
        }
        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, armorRenderType,
                bufferSource.getBuffer(armorRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY,
                1, 1, 1, 1);
    }

}

