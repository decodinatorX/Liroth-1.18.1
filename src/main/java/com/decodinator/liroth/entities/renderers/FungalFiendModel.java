package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.FungalFiendEntity;
import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class FungalFiendModel<T extends FungalFiendEntity>
extends SinglePartEntityModel<T> {
    private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
    private static final int HEAD_AND_BODY_Y_PIVOT = 6;

	public FungalFiendModel(ModelPart root) {
        this.root = root;
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(16, 16).mirrored().cuboid(-4.0F, -18.0F, -2.0F, 8.0F, 12.0F, 4.0F).mirrored(false)
		.uv(16, 16).mirrored().cuboid(-3.0F, -22.0F, -2.0F, 6.0F, 4.0F, 4.0F).mirrored(false)
		.uv(50, 27).cuboid(-4.0F, -17.0F, 0.0F, -5.0F, 5.0F, 0.0F)
		.uv(40, 27).cuboid(3.0F, -23.0F, 0.0F, 5.0F, 5.0F, 0.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F).mirrored(false), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

		ModelPartData leg0 = partdefinition.addChild("leg0", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).mirrored(false), ModelTransform.pivot(3.0F, 18.0F, 4.0F));

		ModelPartData leg1 = partdefinition.addChild("leg1", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).mirrored(false), ModelTransform.pivot(-3.0F, 18.0F, 4.0F));

		ModelPartData leg2 = partdefinition.addChild("leg2", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).mirrored(false), ModelTransform.pivot(3.0F, 18.0F, -4.0F));

		ModelPartData leg3 = partdefinition.addChild("leg3", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).mirrored(false), ModelTransform.pivot(-3.0F, 18.0F, -4.0F));

		return TexturedModelData.of(meshdefinition, 64, 32);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yaw = netHeadYaw * ((float)Math.PI / 180);
        this.head.pitch = headPitch * ((float)Math.PI / 180);
        this.leg0.pitch = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leg1.pitch = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.leg2.pitch = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.leg3.pitch = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
		leg0.render(poseStack, buffer, packedLight, packedOverlay);
		leg1.render(poseStack, buffer, packedLight, packedOverlay);
		leg2.render(poseStack, buffer, packedLight, packedOverlay);
		leg3.render(poseStack, buffer, packedLight, packedOverlay);
	}

    @Override
    public ModelPart getPart() {
        return this.root;
    }
}