package com.decodinator.liroth.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class WarpEntity extends EndermanEntity {

	public WarpEntity(EntityType<? extends EndermanEntity> entityType, World world) {
		super(entityType, world);
	}

    public static DefaultAttributeContainer.Builder createWarpAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0);
    }
	
}
