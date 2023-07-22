package com.decodinator.liroth;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.particle.WhiteAshParticle;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Map;
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
import com.decodinator.liroth.entities.boats.LirothBoatEntityModel;
import com.decodinator.liroth.entities.boats.LirothBoatEntityRenderer;
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
import com.google.common.collect.Maps;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class LirothClient implements ClientModInitializer {
	public static final ResourceLocation PacketID = new ResourceLocation(Liroth.MOD_ID, "spawn_packet");
    private static final Map<EntityType<?>, EntityRendererProvider<?>> PROVIDERS = Maps.newHashMap();
    private static final Map<BlockEntityType<?>, BlockEntityRendererProvider<?>> PROVIDERS2 = Maps.newHashMap();

    public static LirothConfig config;
    public static final ModelLayerLocation MODEL_LIROTH_BOAT_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "liroth_boat"), "main");
    public static final ModelLayerLocation MODEL_CHEST_LIROTH_BOAT_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "chest_liroth_boat"), "main");
    public static final ModelLayerLocation MODEL_FUNGAL_FIEND_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "fungal_fiend"), "main");
    public static final ModelLayerLocation MODEL_FORSAKEN_CORPSE_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "forsaken_corpse"), "main");
    public static final ModelLayerLocation MODEL_SKELETAL_FREAK_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "skeletal_freak"), "main");
    public static final ModelLayerLocation MODEL_WARP_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "warp"), "main");
    public static final ModelLayerLocation MODEL_SOUL_ARACHNID_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "soul_arachnid"), "main");
    public static final ModelLayerLocation MODEL_PIER_PEEP_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "pier_peep"), "main");
    public static final ModelLayerLocation MODEL_SHADE_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "shade"), "main");
    public static final ModelLayerLocation MODEL_PROWLER_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "prowler"), "main");
    public static final ModelLayerLocation MODEL_FREAKSHOW_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "freakshow"), "main");
    public static final ModelLayerLocation MODEL_VILE_SHARK_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "vile_shark"), "main");
    public static final ModelLayerLocation MODEL_LIROTHIAN_MIMIC_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "lirothian_mimic"), "main");
    public static final ModelLayerLocation MODEL_BUTTERFLY_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "butterfly"), "main");
    public static final ModelLayerLocation MODEL_POTESTIUM_HELMET_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "potestium_helmet"), "main");
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void onInitializeClient() {

        AutoConfig.register(LirothConfigWrapper.class, PartitioningSerializer.wrap(JanksonConfigSerializer::new));
        config = AutoConfig.getConfigHolder(LirothConfigWrapper.class).getConfig().client;

		FluidRenderHandlerRegistry.INSTANCE.register(LirothFluids.LIROTH_FLUID_STILL, LirothFluids.LIROTH_FLUID_FLOWING, new SimpleFluidRenderHandler(
				new ResourceLocation("liroth:blocks/liroth_fluid_still"),
				new ResourceLocation("liroth:blocks/liroth_fluid_flowing")
		));
		
		BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), LirothFluids.LIROTH_FLUID_STILL, LirothFluids.LIROTH_FLUID_FLOWING);

		
		FluidRenderHandlerRegistry.INSTANCE.register(LirothFluids.MOLTEN_SPINERIOS_STILL, LirothFluids.MOLTEN_SPINERIOS_FLOWING, new SimpleFluidRenderHandler(
				new ResourceLocation("liroth:blocks/molten_spinerios_still"),
				new ResourceLocation("liroth:blocks/molten_spinerios_flowing")
		));
        
        LirothRenders.renderCutOuts(blockRenderTypeMap -> ItemBlockRenderTypeAccess.getTypeByBlock().putAll(blockRenderTypeMap));
		
        MenuScreens.register(LirothScreenHandlers.LIROTH_SPLITTER_SCREEN_HANDLER, LirothSplitterScreen::new);
        MenuScreens.register(LirothScreenHandlers.QUANTUM_EXTRACTOR_SCREEN_HANDLER, QuantumExtractorScreen::new);
        
		EntityRendererRegistry.register(LirothEntities.BEAM_LASER_PROJECTILE_ENTITY, context -> new BeamLaserProjectileEntityRenderer(context));
        
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
            return new ShadeEntityRenderer(context);
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
        
        ParticleFactoryRegistry.getInstance().register(LirothParticles.CLOAK, EndRodParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(LirothParticles.GREEN_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(LirothParticles.PURPLE_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(LirothParticles.GREEN_SPORE, WhiteAshParticle.Provider::new);
        
        registerBR(Liroth.FUNGAL_CAMPFIRE_BLOCK_ENTITY, FungalCampfireBlockEntityRenderer::new);
        registerBR(Liroth.LIROTHIAN_PETROLEUM_CAMPFIRE_BLOCK_ENTITY, LirothianPetroleumCampfireBlockEntityRenderer::new);
        
        EntityModelLayerRegistry.registerModelLayer(MODEL_POTESTIUM_HELMET_LAYER, PotestiumHelmetModel::getTexturedModelData);

        ArmorRenderer.register(new PotestiumHelmetRenderer(), LirothItems.POTESTIUM_LIROTH_HELMET);
        
        EntityRendererRegistry.register(LirothEntities.LIROTH_BOAT, context -> new LirothBoatEntityRenderer(context, false));
        EntityRendererRegistry.register(LirothEntities.CHEST_LIROTH_BOAT, context -> new LirothBoatEntityRenderer(context, true));
        EntityModelLayerRegistry.registerModelLayer(MODEL_LIROTH_BOAT_LAYER, () -> LirothBoatEntityModel.createBodyModel(false));
        EntityModelLayerRegistry.registerModelLayer(MODEL_CHEST_LIROTH_BOAT_LAYER, () -> LirothBoatEntityModel.createBodyModel(true));
	}
	

    private static <T extends BlockEntity> void registerBR(BlockEntityType<? extends T> blockEntityType, BlockEntityRendererProvider<T> blockEntityRendererProvider) {
        PROVIDERS2.put(blockEntityType, blockEntityRendererProvider);
    }
}