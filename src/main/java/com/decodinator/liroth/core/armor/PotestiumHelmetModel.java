package com.decodinator.liroth.core.armor;

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

public class PotestiumHelmetModel extends EntityModel {
	private final ModelPart Helm;

	public PotestiumHelmetModel(ModelPart root) {
		this.Helm = root.getChild("Helm");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData Helm = partdefinition.addChild("Helm", ModelPartBuilder.create().uv(0, 89).cuboid(-4.0F, -33.0F, -5.0F, 8.0F, 9.0F, 8.0F)
		.uv(0, 0).cuboid(-4.5F, -33.5F, -4.5F, 9.0F, 10.0F, 9.0F)
		.uv(36, 15).cuboid(-1.0F, -32.75F, -6.25F, 2.0F, 2.0F, 1.0F)
		.uv(49, 15).cuboid(1.5F, -33.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.uv(45, 15).cuboid(-3.5F, -33.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.uv(47, 15).cuboid(-4.5F, -34.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.uv(46, 15).cuboid(2.5F, -34.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.uv(46, 14).cuboid(-1.5F, -33.25F, -5.75F, 3.0F, 3.0F, 1.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = Helm.addChild("cube_r1", ModelPartBuilder.create().uv(0, 9).mirrored().cuboid(5.25F, -11.0F, 0.75F, 3.0F, 3.0F, 1.0F).mirrored(false), ModelTransform.of(-5.0F, -28.0F, -5.0F, 0.0873F, 0.0F, 1.0036F));

		ModelPartData cube_r2 = Helm.addChild("cube_r2", ModelPartBuilder.create().uv(0, 9).cuboid(-3.0F, -2.5F, 0.0F, 3.0F, 3.0F, 1.0F), ModelTransform.of(-5.0F, -28.0F, -5.0F, 0.0873F, 0.0F, -1.0036F));

		ModelPartData cube_r3 = Helm.addChild("cube_r3", ModelPartBuilder.create().uv(36, 9).cuboid(-6.5F, -4.75F, -8.5F, 5.0F, 1.0F, 9.0F), ModelTransform.of(4.0F, -27.0F, 0.0F, -1.5708F, 0.4363F, -1.5708F));

		ModelPartData cube_r4 = Helm.addChild("cube_r4", ModelPartBuilder.create().uv(36, 9).cuboid(-9.25F, -7.75F, -4.5F, 5.0F, 1.0F, 9.0F), ModelTransform.of(4.0F, -27.0F, 0.0F, 0.0F, 0.0F, -1.0036F));

		ModelPartData cube_r5 = Helm.addChild("cube_r5", ModelPartBuilder.create().uv(36, 9).mirrored().cuboid(0.0F, -1.0F, -4.5F, 5.0F, 1.0F, 9.0F).mirrored(false), ModelTransform.of(4.0F, -27.0F, 0.0F, 0.0F, 0.0F, 1.0036F));

		ModelPartData cube_r6 = Helm.addChild("cube_r6", ModelPartBuilder.create().uv(16, 106).cuboid(-1.0F, -28.5F, -5.0F, 2.0F, 2.0F, 4.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		ModelPartData cube_r7 = Helm.addChild("cube_r7", ModelPartBuilder.create().uv(0, 106).cuboid(-1.5F, -28.5F, -5.0F, 3.0F, 3.0F, 5.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 64, 128);
	}

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Helm.render(poseStack, buffer, packedLight, packedOverlay);
	}

	@Override
	public void setAngles(Entity var1, float var2, float var3, float var4, float var5, float var6) {	
	}
}