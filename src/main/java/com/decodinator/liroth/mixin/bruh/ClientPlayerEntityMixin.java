package com.decodinator.liroth.mixin.bruh;

import com.decodinator.liroth.entities.boat.CustomBoatEntity;
import com.decodinator.liroth.entities.boat.DamnationBoatEntity;
import com.decodinator.liroth.entities.boat.JapzBoatEntity;
import com.decodinator.liroth.entities.boat.KoolawBoatEntity;
import com.decodinator.liroth.entities.boat.PetrifiedDamnationBoatEntity;
import com.decodinator.liroth.entities.boat.SpicedBoatEntity;
import com.decodinator.liroth.entities.boat.TallpierBoatEntity;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {

    private double time;

    @Shadow
    private boolean riding;

    @Shadow
    public Input input;

    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }


    @Inject(at = @At("HEAD"), method = "tickRiding")
    public void tickRiding(CallbackInfo ci) {
        this.riding = false;
        if (this.getVehicle() instanceof CustomBoatEntity) {
        	CustomBoatEntity boatEntity = (CustomBoatEntity)this.getVehicle();
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
        } else if (this.getVehicle() instanceof PetrifiedDamnationBoatEntity) {
        	PetrifiedDamnationBoatEntity boatEntity = (PetrifiedDamnationBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        } else if (this.getVehicle() instanceof SpicedBoatEntity) {
        	SpicedBoatEntity boatEntity = (SpicedBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        } else if (this.getVehicle() instanceof TallpierBoatEntity) {
        	TallpierBoatEntity boatEntity = (TallpierBoatEntity)this.getVehicle();
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        }
    }
}