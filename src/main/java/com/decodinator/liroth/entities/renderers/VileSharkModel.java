package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.VileSharkEntity;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class VileSharkModel<T extends VileSharkEntity> extends EntityModel<T> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart tail_fin;
	private final ModelPart back_fin;
	private final ModelPart left_fin;
	private final ModelPart right_fin;
	private final ModelPart nose;

	public VileSharkModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.tail = root.getChild("tail");
		this.tail_fin = root.getChild("tail_fin");
		this.back_fin = root.getChild("back_fin");
		this.left_fin = root.getChild("left_fin");
		this.right_fin = root.getChild("right_fin");
		this.nose = root.getChild("nose");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		partdefinition.addChild("head", ModelPartBuilder.create().uv(26, 28).cuboid(-5.0F, -4.0F, -8.0F, 10.0F, 5.0F, 8.0F)
		.uv(33, 0).cuboid(-5.0F, 2.0F, -6.0F, 10.0F, 1.0F, 6.0F), ModelTransform.pivot(0.0F, 20.0F, -3.0F));

		partdefinition.addChild("body", ModelPartBuilder.create().uv(0, 42).cuboid(-6.0F, -5.0F, 0.0F, 12.0F, 9.0F, 13.0F), ModelTransform.pivot(0.0F, 20.0F, -3.0F));

		partdefinition.addChild("tail", ModelPartBuilder.create().uv(0, 20).cuboid(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 11.0F), ModelTransform.pivot(0.0F, 20.5F, 10.0F));

		partdefinition.addChild("tail_fin", ModelPartBuilder.create().uv(23, 20).cuboid(-6.0F, -0.5F, -1.0F, 12.0F, 1.0F, 6.0F), ModelTransform.pivot(0.0F, 20.5F, 20.0F));

		ModelPartData back_fin = partdefinition.addChild("back_fin", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 5.0F));

		back_fin.addChild("back_fin_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -12.0F, 3.0F, 1.0F, 5.0F, 4.0F), ModelTransform.of(0.0F, 7.0F, -5.0F, -0.1745F, 0.0F, 0.0F));

		partdefinition.addChild("left_fin", ModelPartBuilder.create().uv(0, 36).cuboid(-8.0F, -1.0F, -1.0F, 8.0F, 1.0F, 4.0F), ModelTransform.pivot(-6.0F, 22.0F, -1.0F));

		partdefinition.addChild("right_fin", ModelPartBuilder.create().uv(33, 7).cuboid(0.0F, -1.0F, -1.0F, 8.0F, 1.0F, 4.0F), ModelTransform.pivot(6.0F, 22.0F, -1.0F));

		partdefinition.addChild("nose", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 20.0F, -11.0F));

		return TexturedModelData.of(meshdefinition, 64, 64);
	}

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
//        this.body.pitch = headPitch * ((float)Math.PI / 180);
//        this.body.yaw = headYaw * ((float)Math.PI / 180);
        if (((Entity)entity).getVelocity().horizontalLengthSquared() > 1.0E-7) {
//            this.body.pitch += -0.05f - 0.05f * MathHelper.cos(animationProgress * 0.3f);
            this.tail.pitch = -0.1f * MathHelper.cos(animationProgress * 0.3f);
            this.tail_fin.pitch = -0.2f * MathHelper.cos(animationProgress * 0.3f);
        }
    }

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		tail.render(poseStack, buffer, packedLight, packedOverlay);
		tail_fin.render(poseStack, buffer, packedLight, packedOverlay);
		back_fin.render(poseStack, buffer, packedLight, packedOverlay);
		left_fin.render(poseStack, buffer, packedLight, packedOverlay);
		right_fin.render(poseStack, buffer, packedLight, packedOverlay);
		nose.render(poseStack, buffer, packedLight, packedOverlay);
	}
}