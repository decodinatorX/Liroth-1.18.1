package com.decodinator.liroth.mixin.access;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;

@Mixin(ClientWorld.class)
public interface ClientLevelAccess {


    @Invoker
    void invokeAddEntity(int i, Entity entity);
}
