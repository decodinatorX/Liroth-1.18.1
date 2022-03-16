package com.decodinator.liroth.entities;

import com.decodinator.liroth.Liroth;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

public class FreakshowEntity extends ZombieEntity {

	public FreakshowEntity(EntityType<? extends ZombieEntity> entityType, World world) {
		super(entityType, world);
	}

    public static DefaultAttributeContainer.Builder createFreakshowAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 256.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20.0).add(EntityAttributes.GENERIC_ARMOR, 2.0).add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }
    
    @Override
    protected void convertInWater() {

    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return Liroth.WARP_IDLE_SOUND_EVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return Liroth.WARP_HURT_SOUND_EVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Liroth.WARP_DEATH_SOUND_EVENT;
    }
}
