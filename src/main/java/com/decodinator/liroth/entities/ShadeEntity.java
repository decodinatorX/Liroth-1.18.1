package com.decodinator.liroth.entities;

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
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ShadeEntity extends ZombieEntity {

	public ShadeEntity(EntityType<? extends ZombieEntity> entityType, World world) {
		super(entityType, world);
        this.isInvulnerableTo(DamageSource.mob(getAttacker()));
        this.isInvulnerableTo(DamageSource.player(attackingPlayer));
        this.isInvulnerableTo(DamageSource.DROWN);
        this.isInvulnerableTo(DamageSource.ANVIL);
        this.isInvulnerableTo(DamageSource.CACTUS);
        this.isInvulnerableTo(DamageSource.FALLING_BLOCK);
        this.isInvulnerableTo(DamageSource.FALLING_STALACTITE);
        this.isInvulnerableTo(DamageSource.FREEZE);
        this.isInvulnerableTo(DamageSource.IN_WALL);
        this.isInvulnerableTo(DamageSource.MAGIC);
        this.isInvulnerableTo(DamageSource.WITHER);
        this.isInvulnerableTo(DamageSource.SWEET_BERRY_BUSH);
        this.isInvulnerableTo(DamageSource.DRAGON_BREATH);
	}

    public static DefaultAttributeContainer.Builder createShadeAttributes() {
        return HostileEntity.createHostileAttributes()
        		.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100.0)
        		.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.10f)
        		.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 35.0)
        		.add(EntityAttributes.GENERIC_ARMOR, 1.0)
        		.add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0)
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
    protected ActionResult interactMob(PlayerEntity player2, Hand hand) {
        ItemStack itemStack = player2.getStackInHand(hand);
        if (itemStack.isIn(LirothTags.TORCHES)) {
            this.world.playSound(player2, this.getX(), this.getY(), this.getZ(), SoundEvents.BLOCK_SOUL_SOIL_BREAK, this.getSoundCategory(), 1.0f, this.random.nextFloat() * 0.4f + 0.8f);
            if (!this.world.isClient) {
                this.poof(player2);
            }
            return ActionResult.success(this.world.isClient);
        }
        return super.interactMob(player2, hand);
    }
    
    public void poof(PlayerEntity player) {
    	player.attack(this);
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
