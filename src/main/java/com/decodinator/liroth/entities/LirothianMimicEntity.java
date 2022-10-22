package com.decodinator.liroth.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothSounds;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

public class LirothianMimicEntity extends SpiderEntity {

	public LirothianMimicEntity(EntityType<? extends SpiderEntity> entityType, World world) {
		super(entityType, world);
	}
	
    public static DefaultAttributeContainer.Builder createLirothianMimicAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
    }
    
    @Override
    public int getLimitPerChunk() {
        return 1;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return LirothSounds.SHADE_IDLE_SOUND_EVENT;
    }
}
