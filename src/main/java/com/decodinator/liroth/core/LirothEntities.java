package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.entities.boat.CustomBoatEntity;
import com.decodinator.liroth.entities.boat.DamnationBoatEntity;
import com.decodinator.liroth.entities.boat.JapzBoatEntity;
import com.decodinator.liroth.entities.boat.KoolawBoatEntity;
import com.decodinator.liroth.entities.boat.PetrifiedDamnationBoatEntity;
import com.decodinator.liroth.entities.boat.SpicedBoatEntity;
import com.decodinator.liroth.entities.boat.TallpierBoatEntity;

import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LirothEntities {

    public static EntityType<CustomBoatEntity> LIROTH_BOAT;
    public static EntityType<DamnationBoatEntity> DAMNATION_BOAT;
    public static EntityType<JapzBoatEntity> JAPZ_BOAT;
    public static EntityType<KoolawBoatEntity> KOOLAW_BOAT;
    public static EntityType<PetrifiedDamnationBoatEntity> PETRIFIED_DAMNATION_BOAT;
    public static EntityType<SpicedBoatEntity> SPICED_BOAT;
    public static EntityType<TallpierBoatEntity> TALLPIER_BOAT;

    public static void RegisterEntities() {
        LIROTH_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "liroth_boat"), FabricEntityTypeBuilder.<CustomBoatEntity>create(SpawnGroup.MISC, CustomBoatEntity::new).size(EntityDimensions.fixed(1.375F, 0.5625F)).build());
        DAMNATION_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "damnation_boat"), FabricEntityTypeBuilder.<DamnationBoatEntity>create(SpawnGroup.MISC, DamnationBoatEntity::new).size(EntityDimensions.fixed(1.375F, 0.5625F)).build());
        JAPZ_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "japz_boat"), FabricEntityTypeBuilder.<JapzBoatEntity>create(SpawnGroup.MISC, JapzBoatEntity::new).size(EntityDimensions.fixed(1.375F, 0.5625F)).build());
        KOOLAW_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "koolaw_boat"), FabricEntityTypeBuilder.<KoolawBoatEntity>create(SpawnGroup.MISC, KoolawBoatEntity::new).size(EntityDimensions.fixed(1.375F, 0.5625F)).build());
        PETRIFIED_DAMNATION_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "petrified_damnation_boat"), FabricEntityTypeBuilder.<PetrifiedDamnationBoatEntity>create(SpawnGroup.MISC, PetrifiedDamnationBoatEntity::new).size(EntityDimensions.fixed(1.375F, 0.5625F)).build());
        SPICED_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "spiced_boat"), FabricEntityTypeBuilder.<SpicedBoatEntity>create(SpawnGroup.MISC, SpicedBoatEntity::new).size(EntityDimensions.fixed(1.375F, 0.5625F)).build());
        TALLPIER_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "tallpier_boat"), FabricEntityTypeBuilder.<TallpierBoatEntity>create(SpawnGroup.MISC, TallpierBoatEntity::new).size(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    }
}
