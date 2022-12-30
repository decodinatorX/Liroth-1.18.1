package com.decodinator.liroth.mixin.access;

import com.decodinator.liroth.entities.boats.DamnationBoatEntity;
import com.decodinator.liroth.entities.boats.JapzBoatEntity;
import com.decodinator.liroth.entities.boats.KoolawBoatEntity;
import com.decodinator.liroth.entities.boats.LirothBoatEntity;
import com.decodinator.liroth.entities.boats.PetrifiedBoatEntity;
import com.decodinator.liroth.entities.boats.PierBoatEntity;
import com.decodinator.liroth.entities.boats.SpicedBoatEntity;
import com.mojang.authlib.GameProfile;

import net.minecraft.client.input.Input;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.encryption.PlayerPublicKey;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
	
    @Shadow
    private boolean riding;

    @Shadow
    public Input input;

    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile, PlayerPublicKey publicKey) {
        super(world, profile);
    }


    @Inject(at = @At("HEAD"), method = "tickRiding")
    public void tickRiding(CallbackInfo ci) {
        this.riding = false;
        if (this.getVehicle() instanceof LirothBoatEntity) {
        	LirothBoatEntity boatEntity = (LirothBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        } else if (this.getVehicle() instanceof DamnationBoatEntity) {
        	DamnationBoatEntity boatEntity = (DamnationBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        } else if (this.getVehicle() instanceof JapzBoatEntity) {
        	JapzBoatEntity boatEntity = (JapzBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        } else if (this.getVehicle() instanceof KoolawBoatEntity) {
        	KoolawBoatEntity boatEntity = (KoolawBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        } else if (this.getVehicle() instanceof PetrifiedBoatEntity) {
        	PetrifiedBoatEntity boatEntity = (PetrifiedBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        } else if (this.getVehicle() instanceof SpicedBoatEntity) {
        	SpicedBoatEntity boatEntity = (SpicedBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        } else if (this.getVehicle() instanceof PierBoatEntity) {
        	PierBoatEntity boatEntity = (PierBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        }
    }
}