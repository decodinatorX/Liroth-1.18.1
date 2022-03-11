package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.ButterflyEntity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ParrotEntityModel;
import net.minecraft.client.render.entity.model.ParrotEntityModel.Pose;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.ParrotEntity;

public class ButterflyModel<T extends ButterflyEntity> extends EntityModel<T> {
	
	private final ModelPart left_w;
	private final ModelPart right_w;

	public ButterflyModel(ModelPart root) {
		this.left_w = root.getChild("left_w");
		this.right_w = root.getChild("right_w");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData left_w = partdefinition.addChild("left_w", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData cube_r1 = left_w.addChild("cube_r1", ModelPartBuilder.create().uv(0, -8).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 8.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.7854F));

		ModelPartData right_w = partdefinition.addChild("right_w", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData cube_r2 = right_w.addChild("cube_r2", ModelPartBuilder.create().uv(0, -8).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 8.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, -0.7854F));

		return TexturedModelData.of(meshdefinition, 16, 16);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
	
    @Override
    public void animateModel(ButterflyEntity parrotEntity, float f, float g, float h) {
        this.animateModel(ButterflyModel.getPose(parrotEntity));
    }
	
    private void animateModel(Pose pose) {
        this.left_w.pitch = -0.6981f;
        this.left_w.yaw = (float)(-Math.PI);
        this.right_w.pitch = -0.6981f;
        this.right_w.yaw = (float)(-Math.PI);
    }

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_w.render(poseStack, buffer, packedLight, packedOverlay);
		right_w.render(poseStack, buffer, packedLight, packedOverlay);
	}
	
    private static Pose getPose(ButterflyEntity parrot) {
        return Pose.STANDING;
    }

    @Environment(value=EnvType.CLIENT)
    public static enum Pose {
        FLYING,
        STANDING,
        SITTING,
        PARTY,
        ON_SHOULDER;

    }
}