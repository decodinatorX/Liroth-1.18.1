package com.decodinator.liroth;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.WhiteAshParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.core.LirothFluids;
import com.decodinator.liroth.core.LirothItems;
import com.decodinator.liroth.core.LirothParticles;
import com.decodinator.liroth.core.LirothRenders;
import com.decodinator.liroth.core.LirothScreenHandlers;
import com.decodinator.liroth.core.helpers.PotestiumHelmetModel;
import com.decodinator.liroth.core.helpers.PotestiumHelmetRenderer;
import com.decodinator.liroth.core.blocks.entity.FungalCampfireBlockEntityRenderer;
import com.decodinator.liroth.core.blocks.entity.LirothSplitterScreen;
import com.decodinator.liroth.core.blocks.entity.LirothianPetroleumCampfireBlockEntityRenderer;
import com.decodinator.liroth.core.blocks.entity.QuantumExtractorScreen;
import com.decodinator.liroth.entities.renderers.BeamLaserProjectileEntityRenderer;
import com.decodinator.liroth.entities.renderers.ForsakenCorpseEntityRenderer;
import com.decodinator.liroth.entities.renderers.ForsakenCorpseModel;
import com.decodinator.liroth.entities.renderers.FreakshowEntityRenderer;
import com.decodinator.liroth.entities.renderers.FreakshowModel;
import com.decodinator.liroth.entities.renderers.FungalFiendEntityRenderer;
import com.decodinator.liroth.entities.renderers.FungalFiendModel;
import com.decodinator.liroth.entities.renderers.LirothianMimicEntityRenderer;
import com.decodinator.liroth.entities.renderers.LirothianMimicModel;
import com.decodinator.liroth.entities.renderers.PierPeepEntityRenderer;
import com.decodinator.liroth.entities.renderers.PierPeepModel;
import com.decodinator.liroth.entities.renderers.ProwlerEntityRenderer;
import com.decodinator.liroth.entities.renderers.ProwlerModel;
import com.decodinator.liroth.entities.renderers.ShadeEntityRenderer;
import com.decodinator.liroth.entities.renderers.ShadeModel;
import com.decodinator.liroth.entities.renderers.SkeletalFreakEntityRenderer;
import com.decodinator.liroth.entities.renderers.SkeletalFreakModel;
import com.decodinator.liroth.entities.renderers.SoulArachnidEntityRenderer;
import com.decodinator.liroth.entities.renderers.SoulArachnidModel;
import com.decodinator.liroth.entities.renderers.VileSharkEntityRenderer;
import com.decodinator.liroth.entities.renderers.VileSharkModel;
import com.decodinator.liroth.entities.renderers.WarpEntityRenderer;
import com.decodinator.liroth.entities.renderers.WarpModel;
import com.decodinator.liroth.mixin.access.ItemBlockRenderTypeAccess;
import com.decodinator.liroth.entities.ShadeEntity;
import com.decodinator.liroth.entities.boats.ChestDamnationBoatEntityModel;
import com.decodinator.liroth.entities.boats.ChestDamnationBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.ChestJapzBoatEntityModel;
import com.decodinator.liroth.entities.boats.ChestJapzBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.ChestKoolawBoatEntityModel;
import com.decodinator.liroth.entities.boats.ChestKoolawBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.ChestLirothBoatEntityModel;
import com.decodinator.liroth.entities.boats.ChestLirothBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.ChestPetrifiedBoatEntityModel;
import com.decodinator.liroth.entities.boats.ChestPetrifiedBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.ChestPierBoatEntityModel;
import com.decodinator.liroth.entities.boats.ChestPierBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.ChestSpicedBoatEntityModel;
import com.decodinator.liroth.entities.boats.ChestSpicedBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.DamnationBoatEntityModel;
import com.decodinator.liroth.entities.boats.DamnationBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.JapzBoatEntityModel;
import com.decodinator.liroth.entities.boats.JapzBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.KoolawBoatEntityModel;
import com.decodinator.liroth.entities.boats.KoolawBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.LirothBoatEntityModel;
import com.decodinator.liroth.entities.boats.LirothBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.PetrifiedBoatEntityModel;
import com.decodinator.liroth.entities.boats.PetrifiedBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.PierBoatEntityModel;
import com.decodinator.liroth.entities.boats.PierBoatEntityRenderer;
import com.decodinator.liroth.entities.boats.SpicedBoatEntityModel;
import com.decodinator.liroth.entities.boats.SpicedBoatEntityRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class LirothClient implements ClientModInitializer {
	public static final Identifier PacketID = new Identifier(Liroth.MOD_ID, "spawn_packet");

    public static final EntityModelLayer MODEL_LIROTH_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "liroth_boat"), "main");
    public static final EntityModelLayer MODEL_CHEST_LIROTH_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "chest_liroth_boat"), "main");
    public static final EntityModelLayer MODEL_DAMNATION_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "damnation_boat"), "main");
    public static final EntityModelLayer MODEL_CHEST_DAMNATION_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "chest_damnation_boat"), "main");
    public static final EntityModelLayer MODEL_JAPZ_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "japz_boat"), "main");
    public static final EntityModelLayer MODEL_CHEST_JAPZ_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "chest_japz_boat"), "main");
    public static final EntityModelLayer MODEL_KOOLAW_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "koolaw_boat"), "main");
    public static final EntityModelLayer MODEL_CHEST_KOOLAW_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "chest_koolaw_boat"), "main");
    public static final EntityModelLayer MODEL_PETRIFIED_DAMNATION_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "petrified_damnation_boat"), "main");
    public static final EntityModelLayer MODEL_CHEST_PETRIFIED_DAMNATION_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "chest_petrified_damnation_boat"), "main");
    public static final EntityModelLayer MODEL_SPICED_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "spiced_boat"), "main");
    public static final EntityModelLayer MODEL_CHEST_SPICED_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "chest_spiced_boat"), "main");
    public static final EntityModelLayer MODEL_TALLPIER_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "tallpier"), "main");
    public static final EntityModelLayer MODEL_CHEST_TALLPIER_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "chest_tallpier"), "main");
    public static final EntityModelLayer MODEL_FUNGAL_FIEND_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "fungal_fiend"), "main");
    public static final EntityModelLayer MODEL_FORSAKEN_CORPSE_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "forsaken_corpse"), "main");
    public static final EntityModelLayer MODEL_SKELETAL_FREAK_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "skeletal_freak"), "main");
    public static final EntityModelLayer MODEL_WARP_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "warp"), "main");
    public static final EntityModelLayer MODEL_SOUL_ARACHNID_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "soul_arachnid"), "main");
    public static final EntityModelLayer MODEL_PIER_PEEP_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "pier_peep"), "main");
    public static final EntityModelLayer MODEL_SHADE_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "shade"), "main");
    public static final EntityModelLayer MODEL_PROWLER_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "prowler"), "main");
    public static final EntityModelLayer MODEL_FREAKSHOW_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "freakshow"), "main");
    public static final EntityModelLayer MODEL_VILE_SHARK_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "vile_shark"), "main");
    public static final EntityModelLayer MODEL_LIROTHIAN_MIMIC_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "lirothian_mimic"), "main");
    public static final EntityModelLayer MODEL_BUTTERFLY_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "butterfly"), "main");
    public static final EntityModelLayer MODEL_POTESTIUM_HELMET_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "potestium_helmet"), "main");
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void onInitializeClient() {
 
        EntityRendererRegistry.register(LirothEntities.LIROTH_BOAT, LirothBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_LIROTH_BOAT_LAYER, LirothBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.CHEST_LIROTH_BOAT, ChestLirothBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHEST_LIROTH_BOAT_LAYER, ChestLirothBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.DAMNATION_BOAT, DamnationBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_DAMNATION_BOAT_LAYER, DamnationBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.CHEST_DAMNATION_BOAT, ChestDamnationBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHEST_DAMNATION_BOAT_LAYER, ChestDamnationBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.SPICED_BOAT, SpicedBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_SPICED_BOAT_LAYER, SpicedBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.CHEST_SPICED_BOAT, ChestSpicedBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHEST_SPICED_BOAT_LAYER, ChestSpicedBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.PIER_BOAT, PierBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_TALLPIER_BOAT_LAYER, PierBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.CHEST_PIER_BOAT, ChestPierBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHEST_TALLPIER_BOAT_LAYER, ChestPierBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.JAPZ_BOAT, JapzBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_JAPZ_BOAT_LAYER, JapzBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.CHEST_JAPZ_BOAT, ChestJapzBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHEST_JAPZ_BOAT_LAYER, ChestJapzBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.KOOLAW_BOAT, KoolawBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_KOOLAW_BOAT_LAYER, KoolawBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.CHEST_KOOLAW_BOAT, ChestKoolawBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHEST_KOOLAW_BOAT_LAYER, ChestKoolawBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.PETRIFIED_BOAT, PetrifiedBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_PETRIFIED_DAMNATION_BOAT_LAYER, PetrifiedBoatEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(LirothEntities.CHEST_PETRIFIED_BOAT, ChestPetrifiedBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHEST_PETRIFIED_DAMNATION_BOAT_LAYER, ChestPetrifiedBoatEntityModel::getTexturedModelData);

		FluidRenderHandlerRegistry.INSTANCE.register(LirothFluids.LIROTH_FLUID_STILL, LirothFluids.LIROTH_FLUID_FLOWING, new SimpleFluidRenderHandler(
				new Identifier("liroth:blocks/liroth_fluid_still"),
				new Identifier("liroth:blocks/liroth_fluid_flowing")
		));
		
		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), LirothFluids.LIROTH_FLUID_STILL, LirothFluids.LIROTH_FLUID_FLOWING);

		
		FluidRenderHandlerRegistry.INSTANCE.register(LirothFluids.MOLTEN_SPINERIOS_STILL, LirothFluids.MOLTEN_SPINERIOS_FLOWING, new SimpleFluidRenderHandler(
				new Identifier("liroth:blocks/molten_spinerios_still"),
				new Identifier("liroth:blocks/molten_spinerios_flowing")
		));
        
        LirothRenders.renderCutOuts(blockRenderTypeMap -> ItemBlockRenderTypeAccess.getTypeByBlock().putAll(blockRenderTypeMap));
		
        HandledScreens.register(LirothScreenHandlers.LIROTH_SPLITTER_SCREEN_HANDLER, LirothSplitterScreen::new);
        HandledScreens.register(LirothScreenHandlers.QUANTUM_EXTRACTOR_SCREEN_HANDLER, QuantumExtractorScreen::new);
        
		EntityRendererRegistry.register(LirothEntities.BEAM_LASER_PROJECTILE_ENTITY, context -> new FlyingItemEntityRenderer(context, 3.0f, true));
        
        // In 1.17, use EntityRendererRegistry.register (seen below) instead of EntityRendererRegistry.INSTANCE.register (seen above)
        EntityRendererRegistry.register(LirothEntities.FUNGAL_FIEND, (context) -> {
            return new FungalFiendEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_FUNGAL_FIEND_LAYER, FungalFiendModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.FORSAKEN_CORPSE, (context) -> {
            return new ForsakenCorpseEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_FORSAKEN_CORPSE_LAYER, ForsakenCorpseModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.SKELETAL_FREAK, (context) -> {
            return new SkeletalFreakEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_SKELETAL_FREAK_LAYER, SkeletalFreakModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.BEAM_LASER_PROJECTILE_ENTITY, (context) -> {
            return new BeamLaserProjectileEntityRenderer(context);
        });
        
        EntityRendererRegistry.register(LirothEntities.WARP, (context) -> {
            return new WarpEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_WARP_LAYER, WarpModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.SOUL_ARACHNID, (context) -> {
            return new SoulArachnidEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_SOUL_ARACHNID_LAYER, SoulArachnidModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.PIER_PEEP, (context) -> {
            return new PierPeepEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_PIER_PEEP_LAYER, PierPeepModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.SHADE, (context) -> {
            return new ShadeEntityRenderer(context, new ShadeModel<ShadeEntity>(context.getPart(LirothClient.MODEL_SHADE_LAYER)), 0.5f);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_SHADE_LAYER, ShadeModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.PROWLER, (context) -> {
            return new ProwlerEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_PROWLER_LAYER, ProwlerModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.FREAKSHOW, (context) -> {
            return new FreakshowEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_FREAKSHOW_LAYER, FreakshowModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.VILE_SHARK, (context) -> {
            return new VileSharkEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_VILE_SHARK_LAYER, VileSharkModel::getTexturedModelData);
        
        EntityRendererRegistry.register(LirothEntities.LIROTHIAN_MIMIC, (context) -> {
            return new LirothianMimicEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_LIROTHIAN_MIMIC_LAYER, LirothianMimicModel::getTexturedModelData);
        
        ParticleFactoryRegistry.getInstance().register(LirothParticles.CLOAK, EndRodParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(LirothParticles.GREEN_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(LirothParticles.PURPLE_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(LirothParticles.GREEN_SPORE, WhiteAshParticle.Factory::new);
        
        BlockEntityRendererRegistry.register(Liroth.FUNGAL_CAMPFIRE_BLOCK_ENTITY, FungalCampfireBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(Liroth.LIROTHIAN_PETROLEUM_CAMPFIRE_BLOCK_ENTITY, LirothianPetroleumCampfireBlockEntityRenderer::new);
        
        EntityModelLayerRegistry.registerModelLayer(MODEL_POTESTIUM_HELMET_LAYER, PotestiumHelmetModel::getTexturedModelData);

        ArmorRenderer.register(new PotestiumHelmetRenderer(), LirothItems.POTESTIUM_LIROTH_HELMET);
        
	}
}