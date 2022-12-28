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
import com.decodinator.liroth.entities.boats.ChestDamnationBoatEntity;
import com.decodinator.liroth.entities.boats.ChestJapzBoatEntity;
import com.decodinator.liroth.entities.boats.ChestKoolawBoatEntity;
import com.decodinator.liroth.entities.boats.ChestLirothBoatEntity;
import com.decodinator.liroth.entities.boats.ChestPetrifedBoatEntity;
import com.decodinator.liroth.entities.boats.ChestPierBoatEntity;
import com.decodinator.liroth.entities.boats.ChestSpicedBoatEntity;
import com.decodinator.liroth.entities.boats.DamnationBoatEntity;
import com.decodinator.liroth.entities.boats.JapzBoatEntity;
import com.decodinator.liroth.entities.boats.KoolawBoatEntity;
import com.decodinator.liroth.entities.boats.LirothBoatEntity;
import com.decodinator.liroth.entities.boats.PetrifiedBoatEntity;
import com.decodinator.liroth.entities.boats.PierBoatEntity;
import com.decodinator.liroth.entities.boats.SpicedBoatEntity;
import com.decodinator.liroth.entities.projectiles.BeamLaserProjectileEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LirothEntities {

    public static final EntityType<LirothBoatEntity> LIROTH_BOAT;
    public static final EntityType<ChestLirothBoatEntity> CHEST_LIROTH_BOAT;
    public static final EntityType<DamnationBoatEntity> DAMNATION_BOAT;
    public static final EntityType<ChestDamnationBoatEntity> CHEST_DAMNATION_BOAT;
    public static final EntityType<SpicedBoatEntity> SPICED_BOAT;
    public static final EntityType<ChestSpicedBoatEntity> CHEST_SPICED_BOAT;
    public static final EntityType<PierBoatEntity> PIER_BOAT;
    public static final EntityType<ChestPierBoatEntity> CHEST_PIER_BOAT;
    public static final EntityType<JapzBoatEntity> JAPZ_BOAT;
    public static final EntityType<ChestJapzBoatEntity> CHEST_JAPZ_BOAT;
    public static final EntityType<KoolawBoatEntity> KOOLAW_BOAT;
    public static final EntityType<ChestKoolawBoatEntity> CHEST_KOOLAW_BOAT;
    public static final EntityType<PetrifiedBoatEntity> PETRIFIED_BOAT;
    public static final EntityType<ChestPetrifedBoatEntity> CHEST_PETRIFIED_BOAT;
    
    public static final EntityType<FungalFiendEntity> FUNGAL_FIEND = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "fungal_fiend"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FungalFiendEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2f)).build()
    );
    
    public static final EntityType<ForsakenCorpseEntity> FORSAKEN_CORPSE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "forsaken_corpse"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ForsakenCorpseEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build()
    );
    
    public static final EntityType<SkeletalFreakEntity> SKELETAL_FREAK = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "skeletal_freak"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SkeletalFreakEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build()
    );
    
    public static final EntityType<WarpEntity> WARP = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "warp"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WarpEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<SoulArachnidEntity> SOUL_ARACHNID = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "soul_arachnid"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SoulArachnidEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<PierPeepEntity> PIER_PEEP = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "pier_peep"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PierPeepEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<ShadeEntity> SHADE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "shade"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ShadeEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<ProwlerEntity> PROWLER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "prowler"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ProwlerEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<FreakshowEntity> FREAKSHOW = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "freakshow"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FreakshowEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<VileSharkEntity> VILE_SHARK = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "vile_shark"),
            FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, VileSharkEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
    public static final EntityType<LirothianMimicEntity> LIROTHIAN_MIMIC = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("liroth", "lirothian_mimic"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LirothianMimicEntity::new).dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build()
    );
    
	public static final EntityType<BeamLaserProjectileEntity> BEAM_LASER_PROJECTILE_ENTITY = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(Liroth.MOD_ID, "beam_laser_projectile_entity"),
			FabricEntityTypeBuilder.<BeamLaserProjectileEntity>create(SpawnGroup.MISC, BeamLaserProjectileEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	);
	
    public static PersistentProjectileEntity createBeamProjectile(LivingEntity entity, ItemStack stack, float damageModifier) {
    	BeamItem beamItem = (BeamItem)(stack.getItem() instanceof BeamItem ? stack.getItem() : LirothItems.COOL_BEAM);
        PersistentProjectileEntity persistentProjectileEntity = beamItem.createBeam(entity.world, stack, entity);
        persistentProjectileEntity.applyEnchantmentEffects(entity, damageModifier);
        return persistentProjectileEntity;
    }

    static {
    	LIROTH_BOAT = FabricEntityTypeBuilder.<LirothBoatEntity>create(SpawnGroup.MISC, LirothBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	CHEST_LIROTH_BOAT = FabricEntityTypeBuilder.<ChestLirothBoatEntity>create(SpawnGroup.MISC, ChestLirothBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	DAMNATION_BOAT = FabricEntityTypeBuilder.<DamnationBoatEntity>create(SpawnGroup.MISC, DamnationBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	CHEST_DAMNATION_BOAT = FabricEntityTypeBuilder.<ChestDamnationBoatEntity>create(SpawnGroup.MISC, ChestDamnationBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	SPICED_BOAT = FabricEntityTypeBuilder.<SpicedBoatEntity>create(SpawnGroup.MISC, SpicedBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	CHEST_SPICED_BOAT = FabricEntityTypeBuilder.<ChestSpicedBoatEntity>create(SpawnGroup.MISC, ChestSpicedBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	PIER_BOAT = FabricEntityTypeBuilder.<PierBoatEntity>create(SpawnGroup.MISC, PierBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	CHEST_PIER_BOAT = FabricEntityTypeBuilder.<ChestPierBoatEntity>create(SpawnGroup.MISC, ChestPierBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	JAPZ_BOAT = FabricEntityTypeBuilder.<JapzBoatEntity>create(SpawnGroup.MISC, JapzBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	CHEST_JAPZ_BOAT = FabricEntityTypeBuilder.<ChestJapzBoatEntity>create(SpawnGroup.MISC, ChestJapzBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	KOOLAW_BOAT = FabricEntityTypeBuilder.<KoolawBoatEntity>create(SpawnGroup.MISC, KoolawBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	CHEST_KOOLAW_BOAT = FabricEntityTypeBuilder.<ChestKoolawBoatEntity>create(SpawnGroup.MISC, ChestKoolawBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	PETRIFIED_BOAT = FabricEntityTypeBuilder.<PetrifiedBoatEntity>create(SpawnGroup.MISC, PetrifiedBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	CHEST_PETRIFIED_BOAT = FabricEntityTypeBuilder.<ChestPetrifedBoatEntity>create(SpawnGroup.MISC, ChestPetrifedBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
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
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "liroth_boat"), LIROTH_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "chest_liroth_boat"), CHEST_LIROTH_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "damnation_boat"), DAMNATION_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "chest_damnation_boat"), CHEST_DAMNATION_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "spiced_boat"), SPICED_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "chest_spiced_boat"), CHEST_SPICED_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "pier_boat"), PIER_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "chest_pier_boat"), CHEST_PIER_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "japz_boat"), JAPZ_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "chest_japz_boat"), CHEST_JAPZ_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "koolaw_boat"), KOOLAW_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "chest_koolaw_boat"), CHEST_KOOLAW_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "petrified_boat"), PETRIFIED_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "chest_petrified_boat"), CHEST_PETRIFIED_BOAT);
    }
}
