package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.WarpEntity;

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
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

public class WarpModel<T extends WarpEntity> extends EntityModel<T> {
    public boolean carryingBlock;
    public boolean angry;
    public float leaningPitch;

	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart hat;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;

	public WarpModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.hat = root.getChild("hat");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData meshdefinition = new ModelData();
		ModelPartData ModelPartData = meshdefinition.getRoot();

		ModelPartData body = ModelPartData.addChild("body", ModelPartBuilder.create().uv(28, 14).cuboid(-4.0F, 4.0F, -2.0F, 8.0F, 8.0F, 4.0F)
		.uv(8, 34).cuboid(-0.5F, 0.0F, -2.0F, 6.0F, 4.0F, 4.0F)
		.uv(24, 0).cuboid(-5.5F, 0.0F, -2.0F, 6.0F, 4.0F, 4.0F), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData head = ModelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F)
		.uv(52, 28).cuboid(2.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(24, 34).cuboid(3.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(32, 8).cuboid(5.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(0, 22).cuboid(6.0F, -16.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(0, 18).cuboid(5.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(0, 4).cuboid(5.0F, -18.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(0, 0).cuboid(3.0F, -18.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(32, 12).cuboid(4.0F, -6.0F, 0.0F, 4.0F, 1.0F, 1.0F)
		.uv(40, 0).cuboid(4.0F, -7.0F, 0.0F, 5.0F, 1.0F, 1.0F)
		.uv(40, 0).cuboid(4.0F, -5.0F, 0.0F, 5.0F, 1.0F, 1.0F)
		.uv(40, 0).mirrored().cuboid(-9.0F, -5.0F, 0.0F, 5.0F, 1.0F, 1.0F).mirrored(false)
		.uv(32, 12).mirrored().cuboid(-8.0F, -6.0F, 0.0F, 4.0F, 1.0F, 1.0F).mirrored(false)
		.uv(40, 0).mirrored().cuboid(-9.0F, -7.0F, 0.0F, 5.0F, 1.0F, 1.0F).mirrored(false), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(0, 4).cuboid(5.0F, -18.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(0, 18).cuboid(5.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(0, 22).cuboid(6.0F, -16.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(32, 8).cuboid(5.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(24, 34).cuboid(3.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(52, 28).cuboid(2.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.uv(0, 0).cuboid(3.0F, -18.0F, -1.0F, 2.0F, 2.0F, 2.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData hat = ModelPartData.addChild("hat", ModelPartBuilder.create().uv(0, 18).cuboid(-4.0F, -7.5F, -4.0F, 8.0F, 8.0F, 8.0F), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData rightArm = ModelPartData.addChild("rightArm", ModelPartBuilder.create().uv(20, 42).cuboid(0.0F, -2.0F, -1.0F, 2.0F, 17.0F, 2.0F)
		.uv(10, 43).cuboid(0.0F, 15.0F, -0.5F, 2.0F, 13.0F, 2.0F), ModelTransform.pivot(5.5F, -16.0F, 0.0F));

		ModelPartData leftArm = ModelPartData.addChild("leftArm", ModelPartBuilder.create().uv(20, 42).cuboid(-2.0F, -2.0F, -1.0F, 2.0F, 17.0F, 2.0F)
		.uv(10, 43).mirrored().cuboid(-2.0F, 15.0F, -0.5F, 2.0F, 13.0F, 2.0F).mirrored(false), ModelTransform.pivot(-5.5F, -16.0F, 0.0F));

		ModelPartData rightLeg = ModelPartData.addChild("rightLeg", ModelPartBuilder.create().uv(0, 34).cuboid(0.0F, 5.0F, -1.0F, 2.0F, 25.0F, 2.0F)
		.uv(41, 5).cuboid(-0.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), ModelTransform.pivot(2.0F, -6.0F, 0.0F));

		ModelPartData leftLeg = ModelPartData.addChild("leftLeg", ModelPartBuilder.create().uv(0, 34).cuboid(-2.0F, 5.0F, -1.0F, 2.0F, 25.0F, 2.0F)
		.uv(41, 5).cuboid(-2.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), ModelTransform.pivot(-2.0F, -6.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 64, 64);
	}
	
    protected float lerpAngle(float angleOne, float angleTwo, float magnitude) {
        float f = (magnitude - angleTwo) % ((float)Math.PI * 2);
        if (f < (float)(-Math.PI)) {
            f += (float)Math.PI * 2;
        }
        if (f >= (float)Math.PI) {
            f -= (float)Math.PI * 2;
        }
        return angleTwo + angleOne * f;
    }

    private float method_2807(float f) {
        return -65.0f * f + f * f;
    }

    @Override
    public void setAngles(T livingEntity, float f, float g, float h, float i, float j) {
        boolean bl3;
        boolean bl = ((LivingEntity)livingEntity).getRoll() > 4;
        boolean bl2 = ((LivingEntity)livingEntity).isInSwimmingPose();
        this.head.yaw = i * ((float)Math.PI / 180);
        this.head.pitch = bl ? -0.7853982f : (this.leaningPitch > 0.0f ? (bl2 ? this.lerpAngle(this.leaningPitch, this.head.pitch, -0.7853982f) : this.lerpAngle(this.leaningPitch, this.head.pitch, j * ((float)Math.PI / 180))) : j * ((float)Math.PI / 180));
        this.body.yaw = 0.0f;
        this.rightArm.pivotZ = 0.0f;
        this.leftArm.pivotZ = 0.0f;
        float k = 1.0f;
        if (bl) {
            k = (float)((Entity)livingEntity).getVelocity().lengthSquared();
            k /= 0.2f;
            k *= k * k;
        }
        if (k < 1.0f) {
            k = 1.0f;
        }
        if (this.carryingBlock) {
            this.rightArm.pitch = -0.5f;
            this.leftArm.pitch = -0.5f;
            this.rightArm.roll = 0.05f;
            this.leftArm.roll = -0.05f;
        }
        if (this.angry) {
            float m = 1.0f;
            this.head.pivotY -= 5.0f;
        }
        this.rightArm.pitch = MathHelper.cos(f * 0.6662f + (float)Math.PI) * 2.0f * g * 0.5f / k;
        this.leftArm.pitch = MathHelper.cos(f * 0.6662f) * 2.0f * g * 0.5f / k;
        this.rightArm.roll = 0.0f;
        this.leftArm.roll = 0.0f;
        this.rightLeg.pitch = MathHelper.cos(f * 0.6662f) * 1.4f * g / k;
        this.leftLeg.pitch = MathHelper.cos(f * 0.6662f + (float)Math.PI) * 1.4f * g / k;
        this.rightLeg.yaw = 0.0f;
        this.leftLeg.yaw = 0.0f;
        this.rightLeg.roll = 0.0f;
        this.leftLeg.roll = 0.0f;
        if (this.riding) {
            this.rightArm.pitch += -0.62831855f;
            this.leftArm.pitch += -0.62831855f;
            this.rightLeg.pitch = -1.4137167f;
            this.rightLeg.yaw = 0.31415927f;
            this.rightLeg.roll = 0.07853982f;
            this.leftLeg.pitch = -1.4137167f;
            this.leftLeg.yaw = -0.31415927f;
            this.leftLeg.roll = -0.07853982f;
        }
        this.rightArm.yaw = 0.0f;
        this.leftArm.yaw = 0.0f;
            float p = 0.33333334f;
            this.leftLeg.pitch = MathHelper.lerp(this.leaningPitch, this.leftLeg.pitch, 0.3f * MathHelper.cos(f * 0.33333334f + (float)Math.PI));
            this.rightLeg.pitch = MathHelper.lerp(this.leaningPitch, this.rightLeg.pitch, 0.3f * MathHelper.cos(f * 0.33333334f));
            
    }

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
		hat.render(poseStack, buffer, packedLight, packedOverlay);
		rightArm.render(poseStack, buffer, packedLight, packedOverlay);
		leftArm.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		leftLeg.render(poseStack, buffer, packedLight, packedOverlay);
	}
}