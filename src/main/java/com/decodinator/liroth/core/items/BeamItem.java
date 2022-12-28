package com.decodinator.liroth.core.items;

import com.decodinator.liroth.entities.projectiles.BeamLaserProjectileEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BeamItem extends Item {

	public BeamItem(Settings settings) {
		super(settings);
	}
	
    public PersistentProjectileEntity createBeam(World world, ItemStack stack, LivingEntity shooter) {
        BeamLaserProjectileEntity beamEntity = new BeamLaserProjectileEntity(world, shooter);
        beamEntity.initFromStack(stack);
        return beamEntity;
    }
}
