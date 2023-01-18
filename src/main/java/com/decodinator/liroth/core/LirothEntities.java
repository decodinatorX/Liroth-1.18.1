package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.items.BeamItem;
import com.decodinator.liroth.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.entities.FreakshowEntity;
import com.decodinator.liroth.entities.FungalFiendEntity;
import com.decodinator.liroth.entities.LirothianMimicEntity;
import com.decodinator.liroth.entities.PierPeepEntity;
import com.decodinator.liroth.entities.ProwlerEntity;
import com.decodinator.liroth.entities.ShadeEntity;
import com.decodinator.liroth.entities.SkeletalFreakEntity;
import com.decodinator.liroth.entities.SoulArachnidEntity;
import com.decodinator.liroth.entities.VileSharkEntity;
import com.decodinator.liroth.entities.WarpEntity;
import com.decodinator.liroth.entities.projectiles.BeamLaserProjectileEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;

public class LirothEntities {

    public static final EntityType<LirothBoat> LIROTH_BOAT;
    public static final EntityType<LirothChestBoat> CHEST_LIROTH_BOAT;
    
    public static final EntityType<FungalFiendEntity> FUNGAL_FIEND = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "fungal_fiend"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, FungalFiendEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2f)).build()
    );
    
    public static final EntityType<ForsakenCorpseEntity> FORSAKEN_CORPSE = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "forsaken_corpse"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, ForsakenCorpseEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build()
    );
    
    public static final EntityType<SkeletalFreakEntity> SKELETAL_FREAK = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "skeletal_freak"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, SkeletalFreakEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build()
    );
    
    public static final EntityType<WarpEntity> WARP = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "warp"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, WarpEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<SoulArachnidEntity> SOUL_ARACHNID = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "soul_arachnid"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, SoulArachnidEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<PierPeepEntity> PIER_PEEP = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "pier_peep"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, PierPeepEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<ShadeEntity> SHADE = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "shade"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, ShadeEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<ProwlerEntity> PROWLER = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "prowler"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, ProwlerEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<FreakshowEntity> FREAKSHOW = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "freakshow"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, FreakshowEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<VileSharkEntity> VILE_SHARK = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "vile_shark"),
            FabricEntityTypeBuilder.create(MobCategory.WATER_CREATURE, VileSharkEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<LirothianMimicEntity> LIROTHIAN_MIMIC = Registry.register(
    		BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation("liroth", "lirothian_mimic"),
            FabricEntityTypeBuilder.create(MobCategory.MONSTER, LirothianMimicEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
	public static final EntityType<BeamLaserProjectileEntity> BEAM_LASER_PROJECTILE_ENTITY = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			new ResourceLocation(Liroth.MOD_ID, "beam_laser_projectile_entity"),
			FabricEntityTypeBuilder.<BeamLaserProjectileEntity>create(MobCategory.MISC, BeamLaserProjectileEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	);
	
    public static AbstractArrow createBeamProjectile(LivingEntity entity, ItemStack stack, float damageModifier) {
    	BeamItem beamItem = (BeamItem)(stack.getItem() instanceof BeamItem ? stack.getItem() : LirothItems.COOL_BEAM);
    	AbstractArrow persistentProjectileEntity = beamItem.createBeam(entity.level, stack, entity);
        persistentProjectileEntity.setEnchantmentEffectsFromEntity(entity, damageModifier);
        return persistentProjectileEntity;
    }

    static {
    	LIROTH_BOAT = FabricEntityTypeBuilder.<LirothBoat>create(MobCategory.MISC, LirothBoat::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	CHEST_LIROTH_BOAT = FabricEntityTypeBuilder.<LirothChestBoat>create(MobCategory.MISC, LirothChestBoat::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(FUNGAL_FIEND, FungalFiendEntity.createFungalFiendAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(FORSAKEN_CORPSE, ForsakenCorpseEntity.createForsakenCorpseAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(SKELETAL_FREAK, SkeletalFreakEntity.createSkeletalFreakAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(WARP, WarpEntity.createWarpAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(SOUL_ARACHNID, SoulArachnidEntity.createSoulArachnidAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(PIER_PEEP, PierPeepEntity.createPierPeepAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(SHADE, ShadeEntity.createShadeAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(PROWLER, ProwlerEntity.createProwlerAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(FREAKSHOW, FreakshowEntity.createFreakshowAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(VILE_SHARK, VileSharkEntity.createVileSharkAttributes());
		net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry.register(LIROTHIAN_MIMIC, LirothianMimicEntity.createLirothianMimicAttributes());
    }

    public static void init() {
        Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(Liroth.MOD_ID, "liroth_boat"), LIROTH_BOAT);
        Registry.register(BuiltInRegistries.ENTITY_TYPE, new ResourceLocation(Liroth.MOD_ID, "chest_liroth_boat"), CHEST_LIROTH_BOAT);
    }
}
