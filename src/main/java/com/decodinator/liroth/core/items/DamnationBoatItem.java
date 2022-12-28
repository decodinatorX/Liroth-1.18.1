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
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.List;
import java.util.function.Predicate;

import com.decodinator.liroth.entities.boats.ChestDamnationBoatEntity;
import com.decodinator.liroth.entities.boats.DamnationBoatEntity;

public class DamnationBoatItem
extends Item {
    private static final Predicate<Entity> RIDERS = EntityPredicates.EXCEPT_SPECTATOR.and(Entity::canHit);
    private final boolean chest;

    public DamnationBoatItem(boolean chest, Item.Settings settings) {
        super(settings);
        this.chest = chest;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult hitResult = DamnationBoatItem.raycast(world, user, RaycastContext.FluidHandling.ANY);
        if (((HitResult)hitResult).getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemStack);
        }
        Vec3d vec3d = user.getRotationVec(1.0f);
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
        	DamnationBoatEntity DamnationBoatEntity = this.createEntity(world, hitResult);
        	DamnationBoatEntity.setYaw(user.getYaw());
            if (!world.isSpaceEmpty(DamnationBoatEntity, DamnationBoatEntity.getBoundingBox())) {
                return TypedActionResult.fail(itemStack);
            }
            if (!world.isClient) {
                world.spawnEntity(DamnationBoatEntity);
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

    private DamnationBoatEntity createEntity(World world, HitResult hitResult) {
        if (this.chest) {
            return new ChestDamnationBoatEntity(world, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z);
        }
        return new DamnationBoatEntity(world, hitResult.getPos().x, hitResult.getPos().y, hitResult.getPos().z);
    }
}
