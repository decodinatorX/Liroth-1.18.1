package com.decodinator.liroth.core;

import org.jetbrains.annotations.NotNull;

import com.decodinator.liroth.entities.boats.LirothBoatEntityRenderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class LirothEntityRenderers {

    public static <T extends Entity> void register(RegisterStrategy registerStrategy) {
        registerStrategy.register(LirothEntities.LIROTH_BOAT,(EntityRendererProvider.Context context) -> new LirothBoatEntityRenderer(context, false));
        registerStrategy.register(LirothEntities.CHEST_LIROTH_BOAT, (EntityRendererProvider.Context context) -> new LirothBoatEntityRenderer(context, true));
    }

    @FunctionalInterface
    public interface RegisterStrategy {
        <T extends Entity> void register(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider);
    }
}
