package com.decodinator.liroth.entities;

import com.decodinator.liroth.core.LirothSounds;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class FungalFiendEntity extends CreeperEntity {

	public FungalFiendEntity(EntityType<? extends CreeperEntity> entityType, World world) {
		super(entityType, world);
		this.experiencePoints = 20;
	}

	public static DefaultAttributeContainer.Builder createFungalFiendAttributes() {
		return HostileEntity.createHostileAttributes()
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
	}
	
    @Override
    public int getLimitPerChunk() {
        return 2;
    }
	
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return LirothSounds.FUNGAL_FIEND_HURT_SOUND_EVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return LirothSounds.FUNGAL_FIEND_DEATH_SOUND_EVENT;
    }

}
