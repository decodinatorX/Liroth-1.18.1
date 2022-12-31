package com.decodinator.liroth.entities.boats;

import org.joml.Quaternionf;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.LirothClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class ChestLirothBoatEntityRenderer extends EntityRenderer<ChestLirothBoatEntity> {

    private final ChestLirothBoatEntityModel model;
    private final Identifier texture;


    public ChestLirothBoatEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.shadowRadius = 0.8F;
        this.model = new ChestLirothBoatEntityModel(ctx.getPart(LirothClient.MODEL_CHEST_LIROTH_BOAT_LAYER), true);
        this.texture = new Identifier(Liroth.MOD_ID, "textures/entity/chest_boat/liroth.png");
    }

    public void render(ChestLirothBoatEntity boatEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.translate(0.0f, 0.375f, 0.0f);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f - f));
        float h = (float)boatEntity.getDamageWobbleTicks() - g;
        float j = boatEntity.getDamageWobbleStrength() - g;
        if (j < 0.0f) {
            j = 0.0f;
        }
        if (h > 0.0f) {
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(MathHelper.sin(h) * h * j / 10.0f * (float)boatEntity.getDamageWobbleSide()));
        }
        if (!MathHelper.approximatelyEquals(boatEntity.interpolateBubbleWobble(g), 0.0f)) {
            matrixStack.multiply(new Quaternionf().setAngleAxis(boatEntity.interpolateBubbleWobble(g) * ((float)Math.PI / 180), 1.0f, 0.0f, 1.0f));
        }
        Identifier texture = this.texture;
        ChestLirothBoatEntityModel model = this.model;
        Identifier identifier = texture;
        ChestLirothBoatEntityModel boatEntityModel = model;
        matrixStack.scale(-1.0F, -1.0F, 1.0F);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0F));
        boatEntityModel.setAngles(boatEntity, g, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(boatEntityModel.getLayer(identifier));
        boatEntityModel.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!boatEntity.isSubmergedInWater()) {
            VertexConsumer vertexConsumer2 = vertexConsumerProvider.getBuffer(RenderLayer.getWaterMask());
            boatEntityModel.getWaterPatch().render(matrixStack, vertexConsumer2, i, OverlayTexture.DEFAULT_UV);
        }

        matrixStack.pop();
        super.render(boatEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(ChestLirothBoatEntity entity) {
        return this.texture;
    }

}