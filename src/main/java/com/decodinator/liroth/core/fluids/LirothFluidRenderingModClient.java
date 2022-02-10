package com.decodinator.liroth.core.fluids;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.entities.boat.CustomBoatEntityModel;
import com.decodinator.liroth.entities.boat.CustomBoatEntityRenderer;
import com.decodinator.liroth.entities.renderers.BeamLaserProjectileEntityRenderer;
import com.decodinator.liroth.entities.renderers.ForsakenCorpseEntityRenderer;
import com.decodinator.liroth.entities.renderers.ForsakenCorpseModel;
import com.decodinator.liroth.entities.renderers.FreakshowEntityRenderer;
import com.decodinator.liroth.entities.renderers.FreakshowModel;
import com.decodinator.liroth.entities.renderers.FungalFiendEntityRenderer;
import com.decodinator.liroth.entities.renderers.FungalFiendModel;
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
import com.decodinator.liroth.entities.renderers.WarpEntityRenderer;
import com.decodinator.liroth.entities.renderers.WarpModel;
import com.decodinator.liroth.util.EntitySpawnPacket;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

public class LirothFluidRenderingModClient implements ClientModInitializer {
	public static final Identifier PacketID = new Identifier(Liroth.MOD_ID, "spawn_packet");

    public static final EntityModelLayer MODEL_LIROTH_BOAT_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "liroth_boat"), "main");
    public static final EntityModelLayer MODEL_FUNGAL_FIEND_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "fungal_fiend"), "main");
    public static final EntityModelLayer MODEL_FORSAKEN_CORPSE_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "forsaken_corpse"), "main");
    public static final EntityModelLayer MODEL_SKELETAL_FREAK_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "skeletal_freak"), "main");
    public static final EntityModelLayer MODEL_WARP_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "warp"), "main");
    public static final EntityModelLayer MODEL_SOUL_ARACHNID_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "soul_arachnid"), "main");
    public static final EntityModelLayer MODEL_PIER_PEEP_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "pier_peep"), "main");
    public static final EntityModelLayer MODEL_SHADE_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "shade"), "main");
    public static final EntityModelLayer MODEL_PROWLER_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "prowler"), "main");
    public static final EntityModelLayer MODEL_FREAKSHOW_LAYER = new EntityModelLayer(new Identifier(Liroth.MOD_ID, "freakshow"), "main");
    
	@Override
	public void onInitializeClient() {

		FluidRenderHandlerRegistry.INSTANCE.register(Liroth.LIROTH_FLUID_STILL, Liroth.LIROTH_FLUID_FLOWING, new SimpleFluidRenderHandler(
				new Identifier("liroth:blocks/liroth_fluid_still"),
				new Identifier("liroth:blocks/liroth_fluid_flowing")
		));
		
		FluidRenderHandlerRegistry.INSTANCE.register(Liroth.MOLTEN_SPINERIOS_STILL, Liroth.MOLTEN_SPINERIOS_FLOWING, new SimpleFluidRenderHandler(
				new Identifier("liroth:blocks/molten_spinerios_still"),
				new Identifier("liroth:blocks/molten_spinerios_flowing")
		));
		
		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
			registry.register(new Identifier("liroth:blocks/liroth_fluid_still"));
			registry.register(new Identifier("liroth:blocks/liroth_fluid_flowing"));
			registry.register(new Identifier("liroth:blocks/molten_spinerios_still"));
			registry.register(new Identifier("liroth:blocks/molten_spinerios_flowing"));
		});
		
        EntityRendererRegistry.register(LirothEntities.LIROTH_BOAT, CustomBoatEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MODEL_LIROTH_BOAT_LAYER, CustomBoatEntityModel::getTexturedModelData);
        
        // In 1.17, use EntityRendererRegistry.register (seen below) instead of EntityRendererRegistry.INSTANCE.register (seen above)
        EntityRendererRegistry.register(Liroth.FUNGAL_FIEND, (context) -> {
            return new FungalFiendEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_FUNGAL_FIEND_LAYER, FungalFiendModel::getTexturedModelData);
        
        EntityRendererRegistry.register(Liroth.FORSAKEN_CORPSE, (context) -> {
            return new ForsakenCorpseEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_FORSAKEN_CORPSE_LAYER, ForsakenCorpseModel::getTexturedModelData);
        
        EntityRendererRegistry.register(Liroth.SKELETAL_FREAK, (context) -> {
            return new SkeletalFreakEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_SKELETAL_FREAK_LAYER, SkeletalFreakModel::getTexturedModelData);
        
        EntityRendererRegistry.register(Liroth.BEAM_LASER_PROJECTILE_ENTITY, (context) -> {
            return new BeamLaserProjectileEntityRenderer(context);
        });
        
        EntityRendererRegistry.register(Liroth.WARP, (context) -> {
            return new WarpEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_WARP_LAYER, WarpModel::getTexturedModelData);
        
        EntityRendererRegistry.register(Liroth.SOUL_ARACHNID, (context) -> {
            return new SoulArachnidEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_SOUL_ARACHNID_LAYER, SoulArachnidModel::getTexturedModelData);
        
        EntityRendererRegistry.register(Liroth.PIER_PEEP, (context) -> {
            return new PierPeepEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_PIER_PEEP_LAYER, PierPeepModel::getTexturedModelData);
        
        EntityRendererRegistry.register(Liroth.SHADE, (context) -> {
            return new ShadeEntityRenderer(context, new ShadeModel(context.getPart(LirothFluidRenderingModClient.MODEL_SHADE_LAYER)), 0.5f);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_SHADE_LAYER, ShadeModel::getTexturedModelData);
        
        EntityRendererRegistry.register(Liroth.PROWLER, (context) -> {
            return new ProwlerEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_PROWLER_LAYER, ProwlerModel::getTexturedModelData);
        
        EntityRendererRegistry.register(Liroth.FREAKSHOW, (context) -> {
            return new FreakshowEntityRenderer(context);
        });
 
        EntityModelLayerRegistry.registerModelLayer(MODEL_FREAKSHOW_LAYER, FreakshowModel::getTexturedModelData);
	}
	
	@SuppressWarnings("deprecation")
	public static void receiveEntityPacket() {
		ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
			EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
			UUID uuid = byteBuf.readUuid();
			int entityId = byteBuf.readVarInt();
			Vec3d pos = EntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
			float pitch = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
			float yaw = EntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
			ctx.getTaskQueue().execute(() -> {
				if (MinecraftClient.getInstance().world == null)
					throw new IllegalStateException("Tried to spawn entity in a null world!");
				Entity e = et.create(MinecraftClient.getInstance().world);
				if (e == null)
					throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
				e.updateTrackedPosition(pos);
				e.setPos(pos.x, pos.y, pos.z);
				e.prevPitch = pitch;
				e.prevYaw = yaw;
				e.setId(entityId);
				e.setUuid(uuid);
				MinecraftClient.getInstance().world.addEntity(entityId, e);
			});
		});
	}
}