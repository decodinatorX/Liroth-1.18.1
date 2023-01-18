package com.decodinator.liroth.mixin.access;

import com.decodinator.liroth.core.LirothBoat;
import com.mojang.authlib.GameProfile;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayer {

	@Shadow
    private boolean handsBusy;

    @Shadow
    public Input input;

    public ClientPlayerEntityMixin(ClientLevel clientLevel, GameProfile gameProfile) {
		super(clientLevel, gameProfile);
	}

    @Inject(at = @At("HEAD"), method = "rideTick")
    public void rideTick(CallbackInfo ci) {
        this.handsBusy = false;
        if (this.getVehicle() instanceof LirothBoat) {
        	LirothBoat boatEntity = (LirothBoat)this.getVehicle();
            boatEntity.setInput(this.input.left, this.input.right, this.input.up, this.input.down);
            this.handsBusy |= this.input.left || this.input.right || this.input.up || this.input.down;
        }
    }
}