package com.decodinator.liroth.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.decodinator.liroth.Liroth;

@Mixin(TitleScreen.class)
public class LirothMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		Liroth.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
