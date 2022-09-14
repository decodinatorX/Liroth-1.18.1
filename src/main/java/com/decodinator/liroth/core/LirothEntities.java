package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.entities.boats.DamnationBoatEntity;
import com.decodinator.liroth.entities.boats.JapzBoatEntity;
import com.decodinator.liroth.entities.boats.KoolawBoatEntity;
import com.decodinator.liroth.entities.boats.LirothBoatEntity;
import com.decodinator.liroth.entities.boats.PetrifiedBoatEntity;
import com.decodinator.liroth.entities.boats.PierBoatEntity;
import com.decodinator.liroth.entities.boats.SpicedBoatEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LirothEntities {

    public static final EntityType<LirothBoatEntity> LIROTH_BOAT;
    public static final EntityType<DamnationBoatEntity> DAMNATION_BOAT;
    public static final EntityType<SpicedBoatEntity> SPICED_BOAT;
    public static final EntityType<PierBoatEntity> PIER_BOAT;
    public static final EntityType<JapzBoatEntity> JAPZ_BOAT;
    public static final EntityType<KoolawBoatEntity> KOOLAW_BOAT;
    public static final EntityType<PetrifiedBoatEntity> PETRIFIED_BOAT;

    static {
    	LIROTH_BOAT = FabricEntityTypeBuilder.<LirothBoatEntity>create(SpawnGroup.MISC, LirothBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	DAMNATION_BOAT = FabricEntityTypeBuilder.<DamnationBoatEntity>create(SpawnGroup.MISC, DamnationBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	SPICED_BOAT = FabricEntityTypeBuilder.<SpicedBoatEntity>create(SpawnGroup.MISC, SpicedBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	PIER_BOAT = FabricEntityTypeBuilder.<PierBoatEntity>create(SpawnGroup.MISC, PierBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	JAPZ_BOAT = FabricEntityTypeBuilder.<JapzBoatEntity>create(SpawnGroup.MISC, JapzBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	KOOLAW_BOAT = FabricEntityTypeBuilder.<KoolawBoatEntity>create(SpawnGroup.MISC, KoolawBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    	PETRIFIED_BOAT = FabricEntityTypeBuilder.<PetrifiedBoatEntity>create(SpawnGroup.MISC, PetrifiedBoatEntity::new).dimensions(EntityDimensions.fixed(1.375F, 0.5625F)).build();
    }

    public static void RegisterEntities() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "liroth_boat"), LIROTH_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "damnation_boat"), DAMNATION_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "spiced_boat"), SPICED_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "pier_boat"), PIER_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "japz_boat"), JAPZ_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "koolaw_boat"), KOOLAW_BOAT);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "petrified_boat"), PETRIFIED_BOAT);
    }
}
