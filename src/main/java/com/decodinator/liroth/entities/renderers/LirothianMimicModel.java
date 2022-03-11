package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.entities.LirothianMimicEntity;
import com.decodinator.liroth.entities.SoulArachnidEntity;

import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class LirothianMimicModel<T extends LirothianMimicEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
	private final ModelPart base;
	private final ModelPart lid;
//	private final ModelPart knob;
	private final ModelPart leg7;
	private final ModelPart leg6;
	private final ModelPart leg5;
	private final ModelPart leg4;
	private final ModelPart leg3;
	private final ModelPart leg2;
	private final ModelPart leg1;
	private final ModelPart leg0;
	private final ModelPart head;

	public LirothianMimicModel(ModelPart root) {
		this.root = root;
		this.base = root.getChild("base");
		this.lid = root.getChild("lid");
//		this.knob = root.getChild("knob");
		this.leg7 = root.getChild("leg7");
		this.leg6 = root.getChild("leg6");
		this.leg5 = root.getChild("leg5");
		this.leg4 = root.getChild("leg4");
		this.leg3 = root.getChild("leg3");
		this.leg2 = root.getChild("leg2");
		this.leg1 = root.getChild("leg1");
		this.leg0 = root.getChild("leg0");
		this.head = root.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData ModelData = new ModelData();
		ModelPartData ModelPartData = ModelData.getRoot();

		ModelPartData head = ModelPartData.addChild("head", ModelPartBuilder.create().uv(74, 0).cuboid(-4.0F, -8.0F, -3.0F, 8.0F, 5.0F, 6.0F), ModelTransform.pivot(0.0F, 11.0F, 0.0F));

		ModelPartData leg0 = ModelPartData.addChild("leg0", ModelPartBuilder.create().uv(74, 11).mirrored().cuboid(11.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirrored(false), ModelTransform.pivot(4.0F, 11.0F, 2.0F));

		ModelPartData leg1 = ModelPartData.addChild("leg1", ModelPartBuilder.create().uv(74, 11).mirrored().cuboid(-27.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirrored(false), ModelTransform.pivot(-4.0F, 11.0F, 2.0F));

		ModelPartData leg2 = ModelPartData.addChild("leg2", ModelPartBuilder.create().uv(74, 11).mirrored().cuboid(11.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirrored(false), ModelTransform.pivot(4.0F, 11.0F, 1.0F));

		ModelPartData leg3 = ModelPartData.addChild("leg3", ModelPartBuilder.create().uv(74, 11).mirrored().cuboid(-27.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirrored(false), ModelTransform.pivot(-4.0F, 11.0F, 1.0F));

		ModelPartData leg4 = ModelPartData.addChild("leg4", ModelPartBuilder.create().uv(74, 11).mirrored().cuboid(11.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirrored(false), ModelTransform.pivot(4.0F, 11.0F, 0.0F));

		ModelPartData leg5 = ModelPartData.addChild("leg5", ModelPartBuilder.create().uv(74, 12).mirrored().cuboid(-27.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirrored(false), ModelTransform.pivot(-4.0F, 11.0F, 0.0F));

		ModelPartData leg6 = ModelPartData.addChild("leg6", ModelPartBuilder.create().uv(74, 11).mirrored().cuboid(11.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirrored(false), ModelTransform.pivot(4.0F, 11.0F, -1.0F));

		ModelPartData leg7 = ModelPartData.addChild("leg7", ModelPartBuilder.create().uv(74, 11).mirrored().cuboid(-27.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirrored(false), ModelTransform.pivot(-4.0F, 11.0F, -1.0F));

//		ModelPartData knob = leg7.addChild("knob", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F)
//		.uv(0, 0).cuboid(-1.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F), ModelTransform.of(4.0F, -1.0F, 7.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData lid = ModelPartData.addChild("lid", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(0.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F).mirrored(false)
		.uv(0, 0).cuboid(-15.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F)
		.uv(0, 62).cuboid(-15.0F, -2.0F, 14.0F, 30.0F, 2.0F, 0.0F), ModelTransform.of(0.0F, 9.0F, 7.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData teeth_left_r1 = lid.addChild("teeth_left_r1", ModelPartBuilder.create().uv(2, 50).mirrored().cuboid(-15.0F, 10.0F, 2.0F, 0.0F, 1.0F, 13.0F).mirrored(false)
		.uv(2, 50).mirrored().cuboid(15.0F, 10.0F, 2.0F, 0.0F, 1.0F, 13.0F).mirrored(false), ModelTransform.of(0.0F, 10.0F, -1.0F, 0.0F, 0.0F, -3.1416F));

		ModelPartData base = ModelPartData.addChild("base", ModelPartBuilder.create().uv(0, 19).mirrored().cuboid(0.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F).mirrored(false)
		.uv(0, 19).cuboid(-15.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F)
		.uv(1, 49).mirrored().cuboid(-15.0F, 10.0F, 1.0F, 0.0F, 1.0F, 14.0F).mirrored(false)
		.uv(1, 49).mirrored().cuboid(15.0F, 10.0F, 1.0F, 0.0F, 1.0F, 14.0F).mirrored(false), ModelTransform.of(0.0F, 18.0F, 8.0F, 3.1416F, 0.0F, 0.0F));

		ModelPartData teeth_front_r1 = base.addChild("teeth_front_r1", ModelPartBuilder.create().uv(0, 62).cuboid(-15.0F, -12.0F, 15.0F, 30.0F, 2.0F, 0.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		return TexturedModelData.of(ModelData, 128, 64);
	}

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.yaw = headYaw * ((float)Math.PI / 180);
        this.head.pitch = headPitch * ((float)Math.PI / 180);
        float f = 0.7853982f;
        this.leg1.roll = -0.7853982f;
        this.leg0.roll = 0.7853982f;
        this.leg3.roll = -0.58119464f;
        this.leg2.roll = 0.58119464f;
        this.leg5.roll = -0.58119464f;
        this.leg4.roll = 0.58119464f;
        this.leg7.roll = -0.7853982f;
        this.leg6.roll = 0.7853982f;
        float g = -0.0f;
        float h = 0.3926991f;
        this.leg1.yaw = 0.7853982f;
        this.leg0.yaw = -0.7853982f;
        this.leg3.yaw = 0.3926991f;
        this.leg2.yaw = -0.3926991f;
        this.leg5.yaw = -0.3926991f;
        this.leg4.yaw = 0.3926991f;
        this.leg7.yaw = -0.7853982f;
        this.leg6.yaw = 0.7853982f;
        float i = -(MathHelper.cos(limbAngle * 0.6662f * 2.0f + 0.0f) * 0.4f) * limbDistance;
        float j = -(MathHelper.cos(limbAngle * 0.6662f * 2.0f + (float)Math.PI) * 0.4f) * limbDistance;
        float k = -(MathHelper.cos(limbAngle * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * limbDistance;
        float l = -(MathHelper.cos(limbAngle * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbDistance;
        float m = Math.abs(MathHelper.sin(limbAngle * 0.6662f + 0.0f) * 0.4f) * limbDistance;
        float n = Math.abs(MathHelper.sin(limbAngle * 0.6662f + (float)Math.PI) * 0.4f) * limbDistance;
        float o = Math.abs(MathHelper.sin(limbAngle * 0.6662f + 1.5707964f) * 0.4f) * limbDistance;
        float p = Math.abs(MathHelper.sin(limbAngle * 0.6662f + 4.712389f) * 0.4f) * limbDistance;
        this.leg1.yaw += i;
        this.leg0.yaw += -i;
        this.leg3.yaw += j;
        this.leg2.yaw += -j;
        this.leg5.yaw += k;
        this.leg4.yaw += -k;
        this.leg7.yaw += l;
        this.leg6.yaw += -l;
        this.leg1.roll += m;
        this.leg0.roll += -m;
        this.leg3.roll += n;
        this.leg2.roll += -n;
        this.leg5.roll += o;
        this.leg4.roll += -o;
        this.leg7.roll += p;
        this.leg6.roll += -p;
    }

	@Override
	public void render(MatrixStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, buffer, packedLight, packedOverlay);
		lid.render(poseStack, buffer, packedLight, packedOverlay);
//		knob.render(poseStack, buffer, packedLight, packedOverlay);
		leg7.render(poseStack, buffer, packedLight, packedOverlay);
		leg6.render(poseStack, buffer, packedLight, packedOverlay);
		leg5.render(poseStack, buffer, packedLight, packedOverlay);
		leg4.render(poseStack, buffer, packedLight, packedOverlay);
		leg3.render(poseStack, buffer, packedLight, packedOverlay);
		leg2.render(poseStack, buffer, packedLight, packedOverlay);
		leg1.render(poseStack, buffer, packedLight, packedOverlay);
		leg0.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
	}
	
    @Override
    public ModelPart getPart() {
        return this.root;
    }
}