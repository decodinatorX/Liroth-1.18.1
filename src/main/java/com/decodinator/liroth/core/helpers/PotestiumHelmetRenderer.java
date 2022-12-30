package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.LirothClient;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class PotestiumHelmetRenderer implements ArmorRenderer {
    private static final Identifier TEXTURE = new Identifier("liroth", "textures/models/armor/potestium_armor_helm.png");
    private static PotestiumHelmetModel potestiumHelmetModel;
    public PotestiumHelmetRenderer() {

    }
    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, BipedEntityModel<LivingEntity> contextModel) {
        if (potestiumHelmetModel == null) {
        	potestiumHelmetModel = new PotestiumHelmetModel(MinecraftClient.getInstance().getEntityModelLoader().getModelPart(LirothClient.MODEL_POTESTIUM_HELMET_LAYER));;
        }

        contextModel.copyBipedStateTo(potestiumHelmetModel);
        potestiumHelmetModel.setVisible(false);
        potestiumHelmetModel.head.visible = slot == EquipmentSlot.HEAD;
            ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, potestiumHelmetModel, TEXTURE);
    }
}