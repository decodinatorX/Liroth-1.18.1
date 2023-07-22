package com.decodinator.liroth.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.decodinator.liroth.LirothClient;
import com.decodinator.liroth.core.helpers.LirothTitleScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;

// I STRAIGHT UP STOLE THIS FROM:
// https://git.oat.zone/oat/gmod-title-screen/src/branch/1.18/src/main/java/zone/oat/gmodtitlescreen/mixin/RedirectTitleScreenMixin.java

// this sucks. lmao.
@Mixin(value = Minecraft.class, priority = 1001)
@Environment(value= EnvType.CLIENT)
public class RedirectTitleScreenMixin {
    @Redirect(method = "setScreen", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;screen:Lnet/minecraft/client/gui/screens/Screen;", opcode = Opcodes.PUTFIELD))
    @Environment(value=EnvType.CLIENT)
    private void injected(Minecraft instance, Screen value) {
        if (value instanceof TitleScreen && LirothClient.config.titlescreen == true) {
            //instance.currentScreen = new CustomTitleScreen();
            // this causes a fabric api error of all things, so let's do a little redundancy, shall we?
            instance.setScreen(new LirothTitleScreen());
            // yes. Wonderful. let's fucking call it Twice.
            // (i genuinely could not find anything that Isn't this)
        } else {
            instance.screen = value;
        }
    }
}