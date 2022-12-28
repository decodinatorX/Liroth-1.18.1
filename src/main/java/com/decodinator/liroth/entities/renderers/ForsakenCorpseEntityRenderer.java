package com.decodinator.liroth.entities.renderers;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.entities.ForsakenCorpseEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class ForsakenCorpseEntityRenderer extends MobEntityRenderer<ForsakenCorpseEntity, ForsakenCorpseModel<ForsakenCorpseEntity>> {

    public ForsakenCorpseEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ForsakenCorpseModel<ForsakenCorpseEntity>(context.getPart(LirothClient.MODEL_FORSAKEN_CORPSE_LAYER)), 0.5f);
        this.addFeature(new ForsakenCorpseFaceFeatureRenderer<ForsakenCorpseEntity>(this));
    }
 
    @Override
    public Identifier getTexture(ForsakenCorpseEntity entity) {
        return new Identifier("liroth", "textures/entity/forsaken_corpse/forsaken_corpse.png");
        
    }
}
