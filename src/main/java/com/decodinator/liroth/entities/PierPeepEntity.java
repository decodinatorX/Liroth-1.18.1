package com.decodinator.liroth.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.world.World;

public class PierPeepEntity extends VexEntity {

	public PierPeepEntity(EntityType<? extends VexEntity> entityType, World world) {
		super(entityType, world);
	}

    public static DefaultAttributeContainer.Builder createPierPeepAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 14.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0);
    }
	
}
