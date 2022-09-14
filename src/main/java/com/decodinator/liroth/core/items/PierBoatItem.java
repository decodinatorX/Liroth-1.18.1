package com.decodinator.liroth.core.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import com.decodinator.liroth.entities.boats.ChestPierBoatEntity;
import com.decodinator.liroth.entities.boats.PierBoatEntity;
import com.decodinator.liroth.entities.boats.PierBoatEntity;
import com.decodinator.liroth.entities.boats.PierBoatEntity;

public class PierBoatItem
extends Item {
    private static final Predicate<Entity> RIDERS = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::canHit);
    private final boolean chest;

    public PierBoatItem(boolean chest, Item.Settings settings) {
        super(settings);
        this.chest = chest;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult hitResult = PierBoatItem.raycast(world, user, RaycastContext.FluidHandling.ANY);
        if (((HitResult)hitResult).getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemStack);
        }
        Vec3d vec3d = user.getRotationVec(1.0f);
        double d = 5.0;
        List<Entity> list = world.getOtherEntities(user, user.getBoundingBox().stretch(vec3d.multiply(5.0)).expand(1.0), RIDERS);
        if (!list.isEmpty()) {
            Vec3d vec3d2 = user.getEyePos();
            for (Entity entity : list) {
                Box box = entity.getBoundingBox().expand(entity.getTargetingMargin());
                if (!box.contains(vec3d2)) continue;
                return TypedActionResult.pass(itemStack);
            }
        }
        if (((HitResult)hitResult).getType() == HitResult.Type.BLOCK) {
        	PierBoatEntity PierBoatEntity = this.createEntity(world, hitResult);
        	PierBoatEntity.setYaw(user.getYaw());
            if (!world.isSpaceEmpty(PierBoatEntity, PierBoatEntity.getBoundingBox())) {
                return TypedActionResult.fail(itemStack);
            }
            if (!world.isClient) {
                world.spawnEntity(PierBoatEntity);
                world.emitGameEvent((Entity)user, GameEvent.ENTITY_PLACE, hitResult.getPos());
                if (!user.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }
            }
            user.incrementStat(Stats.USED.getOrCreateStat(this));
            return TypedActionResult.success(itemStack, world.isClient());
        }
        return TypedActionResult.pass(itemStack);
    }

    private PierBoatEntity createEntity(World world, HitResult hitResult) {
        if (this.chest) {
            return new ChestPierBoatEntity(world, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z);
        }
        return new PierBoatEntity(world, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z);
    }
}