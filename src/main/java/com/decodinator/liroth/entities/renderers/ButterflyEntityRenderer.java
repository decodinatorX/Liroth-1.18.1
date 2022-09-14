package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.ButterflyEntity;
import com.decodinator.liroth.entities.ForsakenCorpseEntity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ButterflyEntityRenderer extends MobEntityRenderer<ButterflyEntity, ButterflyModel<ButterflyEntity>> {

    public ButterflyEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ButterflyModel(context.getPart(LirothClient.MODEL_BUTTERFLY_LAYER)), 0.5f);
    }
 
    @Override
    public Identifier getTexture(ButterflyEntity entity) {
        return new Identifier("liroth", "textures/entity/butterfly/butterfly.png");
        
    }
}