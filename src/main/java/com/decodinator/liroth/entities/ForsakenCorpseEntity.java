package com.decodinator.liroth.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ForsakenCorpseEntity extends ZombieEntity {

	public ForsakenCorpseEntity(EntityType<? extends ZombieEntity> entityType, World world) {
		super(entityType, world);
		this.experiencePoints = 20;
	}

    public static DefaultAttributeContainer.Builder createForsakenCorpseAttributes() {
        return HostileEntity.createHostileAttributes()
        		.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0)
        		.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f)
        		.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0)
        		.add(EntityAttributes.GENERIC_ARMOR, 4.0)
        		.add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }
    
    @Override
    public int getLimitPerChunk() {
        return 2;
    }

    @Override
    protected boolean canConvertInWater() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_DROWNED_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_DROWNED_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DROWNED_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_DROWNED_STEP;
    }
}
