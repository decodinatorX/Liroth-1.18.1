package com.decodinator.liroth.core.helpers;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.entity.LivingEntity;

public class PotestiumHelmetModel extends BipedEntityModel<LivingEntity> {
	
	public PotestiumHelmetModel(ModelPart root) {
		super(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = getModelData(Dilation.NONE, 0);
		ModelPartData head = modelData.getRoot().getChild(EntityModelPartNames.HEAD);

		ModelPartData Helm = head.addChild("Helm", ModelPartBuilder.create().uv(0, 10).cuboid(-4.0F, -33.0F, -5.0F, 8.0F, 9.0F, 8.0F)
		.uv(0, 0).cuboid(-4.5F, -33.5F, -4.5F, 9.0F, 10.0F, 9.0F)
		.uv(36, 15).cuboid(-1.0F, -32.75F, -6.25F, 2.0F, 2.0F, 1.0F)
		.uv(49, 15).cuboid(1.5F, -33.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.uv(45, 15).cuboid(-3.5F, -33.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.uv(47, 15).cuboid(-4.5F, -34.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.uv(46, 15).cuboid(2.5F, -34.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.uv(46, 14).cuboid(-1.5F, -33.25F, -5.75F, 3.0F, 3.0F, 1.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		Helm.addChild("cube_r1", ModelPartBuilder.create().uv(0, 9).mirrored().cuboid(5.25F, -11.0F, 0.75F, 3.0F, 3.0F, 1.0F).mirrored(false), ModelTransform.of(-5.0F, -28.0F, -5.0F, 0.0873F, 0.0F, 1.0036F));

		Helm.addChild("cube_r2", ModelPartBuilder.create().uv(0, 9).cuboid(-3.0F, -2.5F, 0.0F, 3.0F, 3.0F, 1.0F), ModelTransform.of(-5.0F, -28.0F, -5.0F, 0.0873F, 0.0F, -1.0036F));

		Helm.addChild("cube_r3", ModelPartBuilder.create().uv(36, 9).cuboid(-6.5F, -4.75F, -8.5F, 5.0F, 1.0F, 9.0F), ModelTransform.of(4.0F, -27.0F, 0.0F, -1.5708F, 0.4363F, -1.5708F));

		Helm.addChild("cube_r4", ModelPartBuilder.create().uv(36, 9).cuboid(-9.25F, -7.75F, -4.5F, 5.0F, 1.0F, 9.0F), ModelTransform.of(4.0F, -27.0F, 0.0F, 0.0F, 0.0F, -1.0036F));

		Helm.addChild("cube_r5", ModelPartBuilder.create().uv(36, 9).mirrored().cuboid(0.0F, -1.0F, -4.5F, 5.0F, 1.0F, 9.0F).mirrored(false), ModelTransform.of(4.0F, -27.0F, 0.0F, 0.0F, 0.0F, 1.0036F));

		Helm.addChild("cube_r6", ModelPartBuilder.create().uv(38, 19).cuboid(-1.0F, -28.5F, -5.0F, 2.0F, 2.0F, 4.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		Helm.addChild("cube_r7", ModelPartBuilder.create().uv(22, 19).cuboid(-1.5F, -28.5F, -5.0F, 3.0F, 3.0F, 5.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
		
		return TexturedModelData.of(modelData, 64, 32);
	}
}