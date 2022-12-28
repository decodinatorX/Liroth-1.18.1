package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.PierPeepEntity;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class PierPeepModel<T extends PierPeepEntity> extends EntityModel<T> {
	private final ModelPart head;

	public PierPeepModel(ModelPart root) {
		this.head = root.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).mirrored(false)
		.uv(0, 14).cuboid(0.0F, -6.0F, 4.0F, 0.0F, 4.0F, 8.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		head.addChild("cube_r1", ModelPartBuilder.create().uv(0, 14).cuboid(-4.0F, -2.0F, 4.0F, 0.0F, 4.0F, 8.0F), 
				ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		return TexturedModelData.of(meshdefinition, 32, 32);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.yaw = netHeadYaw * ((float)Math.PI / 180);
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
	}
}