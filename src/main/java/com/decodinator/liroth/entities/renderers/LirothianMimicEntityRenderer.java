package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.LirothianMimicEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class LirothianMimicEntityRenderer extends MobEntityRenderer<LirothianMimicEntity, LirothianMimicModel<LirothianMimicEntity>> {

    public LirothianMimicEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new LirothianMimicModel<LirothianMimicEntity>(context.getPart(LirothClient.MODEL_LIROTHIAN_MIMIC_LAYER)), 0.5f);
    }
 
    @Override
    public Identifier getTexture(LirothianMimicEntity entity) {
        return new Identifier("liroth", "textures/entity/lirothian_mimic/lirothian_mimic.png");
        
    }
}
