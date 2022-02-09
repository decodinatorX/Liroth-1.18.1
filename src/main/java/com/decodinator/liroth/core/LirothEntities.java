package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.entities.boat.CustomBoatEntity;

import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LirothEntities {

    public static EntityType<CustomBoatEntity> LIROTH_BOAT;

    public static void RegisterEntities() {
        LIROTH_BOAT = Registry.register(Registry.ENTITY_TYPE, new Identifier(Liroth.MOD_ID, "liroth_boat"), FabricEntityTypeBuilder.<CustomBoatEntity>create(SpawnGroup.CREATURE, CustomBoatEntity::new).size(EntityDimensions.fixed(1.375F, 0.5625F)).build());
    }
}
