package com.decodinator.liroth.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothSounds;
import com.decodinator.liroth.core.LirothTags;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

public class ShadeEntity extends ZombieEntity {

	public ShadeEntity(EntityType<? extends ZombieEntity> entityType, World world) {
		super(entityType, world);
	}

    public static DefaultAttributeContainer.Builder createShadeAttributes() {
        return HostileEntity.createHostileAttributes()
        		.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100.0)
        		.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.10f)
        		.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0)
        		.add(EntityAttributes.GENERIC_ARMOR, 1000.0)
        		.add(EntityAttributes.GENERIC_MAX_HEALTH, 1000.0)
        		.add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }
	
    @Override
    protected ActionResult interactMob(PlayerEntity player2, Hand hand) {
        ItemStack itemStack = player2.getStackInHand(hand);
        if (itemStack.isIn(LirothTags.TORCHES)) {
            this.world.playSound(player2, this.getX(), this.getY(), this.getZ(), SoundEvents.BLOCK_SOUL_SOIL_BREAK, this.getSoundCategory(), 1.0f, this.random.nextFloat() * 0.4f + 0.8f);
            if (!this.world.isClient) {
                this.poof();
            }
            return ActionResult.success(this.world.isClient);
        }
        return super.interactMob(player2, hand);
    }
    
    public void poof() {
        this.kill();
    }
    
    @Override
    protected void convertInWater() {
    	
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return LirothSounds.SHADE_IDLE_SOUND_EVENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return LirothSounds.SHADE_HURT_SOUND_EVENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return LirothSounds.SHADE_DEATH_SOUND_EVENT;
    }

    protected SoundEvent getStepSound() {
    	return SoundEvents.BLOCK_SOUL_SAND_STEP;
	}
}
