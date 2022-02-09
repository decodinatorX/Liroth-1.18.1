package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.SkeletalFreakEntity;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CrossbowPosing;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;

public class SkeletalFreakModel<T extends SkeletalFreakEntity> extends EntityModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
    public float pissnshit;


	public SkeletalFreakModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData meshdefinition = new ModelData();
		ModelPartData partdefinition = meshdefinition.getRoot();

		ModelPartData body = partdefinition.addChild("body", ModelPartBuilder.create().uv(21, 10).cuboid(-3.0F, 6.0F, -2.0F, 6.0F, 1.0F, 1.0F)
		.uv(14, 12).cuboid(-4.0F, 2.0F, -2.0F, 8.0F, 3.0F, 1.0F)
		.uv(17, 14).cuboid(-4.0F, 10.0F, -2.0F, 8.0F, 2.0F, 1.0F)
		.uv(21, 12).cuboid(1.0F, 1.0F, -2.0F, 3.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(1.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(1.0F, 2.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(1.0F, 4.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(-4.0F, 4.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(-4.0F, 2.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(-4.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(-4.0F, 1.0F, -2.0F, 3.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(-1.0F, 9.0F, 1.0F, 2.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(2.0F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(-1.0F, 5.0F, -2.0F, 2.0F, 1.0F, 1.0F)
		.uv(21, 12).cuboid(-1.0F, 7.0F, -2.0F, 2.0F, 3.0F, 1.0F)
		.uv(27, 8).cuboid(-1.0F, 0.0F, 2.0F, 2.0F, 10.0F, 1.0F)
		.uv(15, 15).cuboid(-4.0F, 10.0F, 1.0F, 8.0F, 2.0F, 1.0F)
		.uv(10, 2).cuboid(4.0F, 10.0F, -1.0F, 1.0F, 2.0F, 2.0F)
		.uv(10, 2).cuboid(-5.0F, 10.0F, -1.0F, 1.0F, 2.0F, 2.0F)
		.uv(1, 5).cuboid(-5.0F, 4.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.uv(46, 10).cuboid(-5.0F, 2.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.uv(18, 22).cuboid(-5.0F, 0.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.uv(8, 19).cuboid(4.0F, 0.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.uv(21, 9).cuboid(4.0F, 4.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.uv(41, 20).cuboid(4.0F, 2.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.uv(58, 19).cuboid(0.0F, 0.0F, 3.0F, 0.0F, 10.0F, 3.0F)
		.uv(56, 8).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 14.0F, 0.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = partdefinition.addChild("head", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).mirrored(false)
		.uv(56, 8).cuboid(0.0F, -6.0F, 0.0F, 4.0F, 4.0F, 0.0F)
		.uv(56, 8).cuboid(-4.0F, -6.0F, 0.0F, 4.0F, 4.0F, 0.0F)
		.uv(56, 8).cuboid(-2.0F, -8.0F, 0.0F, 4.0F, 4.0F, 0.0F)
		.uv(56, 8).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F)
		.uv(48, 0).cuboid(-2.0F, -6.0F, -2.0F, 4.0F, 4.0F, 4.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(58, 19).cuboid(0.0F, -3.0F, 4.0F, 0.0F, 8.0F, 3.0F)
		.uv(64, 25).cuboid(0.0F, -3.0F, -4.0F, 0.0F, 8.0F, -3.0F), ModelTransform.of(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData rightArm = partdefinition.addChild("rightArm", ModelPartBuilder.create(), ModelTransform.pivot(8.0F, 2.0F, 0.0F));

		ModelPartData leftArm = partdefinition.addChild("leftArm", ModelPartBuilder.create(), ModelTransform.pivot(-8.0F, 2.0F, 0.0F));

		ModelPartData rightLeg = partdefinition.addChild("rightLeg", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(0.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F).mirrored(false), ModelTransform.pivot(2.0F, 12.0F, 0.0F));

		ModelPartData leftLeg = partdefinition.addChild("leftLeg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), ModelTransform.pivot(-2.0F, 12.0F, 0.0F));

		return TexturedModelData.of(meshdefinition, 64, 32);
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
        this.head.pitch = bl ? -0.7853982f : (this.pissnshit > 0.0f ? (bl2 ? this.lerpAngle(this.pissnshit, this.head.pitch, -0.7853982f) : this.lerpAngle(this.pissnshit, this.head.pitch, j * ((float)Math.PI / 180))) : j * ((float)Math.PI / 180));
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
            this.leftLeg.pitch = MathHelper.lerp(this.pissnshit, this.leftLeg.pitch, 0.3f * MathHelper.cos(f * 0.33333334f + (float)Math.PI));
            this.rightLeg.pitch = MathHelper.lerp(this.pissnshit, this.rightLeg.pitch, 0.3f * MathHelper.cos(f * 0.33333334f));
    }

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
		rightArm.render(poseStack, buffer, packedLight, packedOverlay);
		leftArm.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		leftLeg.render(poseStack, buffer, packedLight, packedOverlay);
	}
}