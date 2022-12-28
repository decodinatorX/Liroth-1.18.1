package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothBlocks;
import com.google.common.annotations.VisibleForTesting;
import java.util.Optional;
import net.minecraft.util.math.random.Random;
import java.util.function.Predicate;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LandingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.Thickness;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class PointedJalsphireCrystal
extends Block
implements LandingBlock,
Waterloggable {
    public static final DirectionProperty VERTICAL_DIRECTION = Properties.VERTICAL_DIRECTION;
    public static final EnumProperty<Thickness> THICKNESS = Properties.THICKNESS;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final VoxelShape TIP_MERGE_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 16.0, 11.0);
    private static final VoxelShape UP_TIP_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 11.0, 11.0);
    private static final VoxelShape DOWN_TIP_SHAPE = Block.createCuboidShape(5.0, 5.0, 5.0, 11.0, 16.0, 11.0);
    private static final VoxelShape BASE_SHAPE = Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
    private static final VoxelShape FRUSTUM_SHAPE = Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 16.0, 13.0);
    private static final VoxelShape MIDDLE_SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 16.0, 14.0);

    public PointedJalsphireCrystal(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(VERTICAL_DIRECTION, Direction.UP)).with(THICKNESS, Thickness.TIP)).with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VERTICAL_DIRECTION, THICKNESS, WATERLOGGED);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return PointedJalsphireCrystal.canPlaceAtWithDirection(world, pos, state.get(VERTICAL_DIRECTION));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED).booleanValue()) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        if (direction != Direction.UP && direction != Direction.DOWN) {
            return state;
        }
        Direction direction2 = state.get(VERTICAL_DIRECTION);
        if (direction2 == Direction.DOWN && world.getBlockTickScheduler().isQueued(pos, this)) {
            return state;
        }
        if (direction == direction2.getOpposite() && !this.canPlaceAt(state, world, pos)) {
            if (direction2 == Direction.DOWN) {
                this.scheduleFall(state, world, pos);
            } else {
                world.createAndScheduleBlockTick(pos, this, 1);
            }
            return state;
        }
        boolean bl = state.get(THICKNESS) == Thickness.TIP_MERGE;
        Thickness thickness = PointedJalsphireCrystal.getThickness(world, pos, direction2, bl);
        return (BlockState)state.with(THICKNESS, thickness);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        BlockPos blockPos = hit.getBlockPos();
        if (!world.isClient && projectile.canModifyAt(world, blockPos) && projectile instanceof TridentEntity && projectile.getVelocity().length() > 0.6) {
            world.breakBlock(blockPos, true);
        }
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (state.get(VERTICAL_DIRECTION) == Direction.UP && state.get(THICKNESS) == Thickness.TIP) {
            entity.handleFallDamage(fallDistance + 2.0f, 2.0f, DamageSource.STALAGMITE);
        } else {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!PointedJalsphireCrystal.canDrip(state)) {
            return;
        }
        float f = random.nextFloat();
        if (f > 0.12f) {
            return;
        }
        PointedJalsphireCrystal.getFluid(world, pos, state).filter(fluid -> f < 0.02f || PointedJalsphireCrystal.isFluidLiquid(fluid)).ifPresent(fluid -> PointedJalsphireCrystal.createParticle(world, pos, state, fluid));
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (PointedJalsphireCrystal.isPointingUp(state) && !this.canPlaceAt(state, world, pos)) {
            world.breakBlock(pos, true);
        } else {
            PointedJalsphireCrystal.spawnFallingBlock(state, world, pos);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextFloat() < 0.011377778f && PointedJalsphireCrystal.isHeldByPointedDripstone(state, world, pos)) {
            PointedJalsphireCrystal.tryGrow(state, world, pos, random);
        }
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos;
        World worldAccess = ctx.getWorld();
        Direction direction2 = PointedJalsphireCrystal.getDirectionToPlaceAt(worldAccess, blockPos = ctx.getBlockPos(), ctx.getVerticalPlayerLookDirection().getOpposite());
        if (direction2 == null) {
            return null;
        }
        boolean bl = !ctx.shouldCancelInteraction();
        Thickness thickness = PointedJalsphireCrystal.getThickness(worldAccess, blockPos, direction2, bl);
        if (thickness == null) {
            return null;
        }
        return (BlockState)((BlockState)((BlockState)this.getDefaultState().with(VERTICAL_DIRECTION, direction2)).with(THICKNESS, thickness)).with(WATERLOGGED, worldAccess.getFluidState(blockPos).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return super.getDefaultState().getFluidState();
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Thickness thickness = state.get(THICKNESS);
        VoxelShape voxelShape = thickness == Thickness.TIP_MERGE ? TIP_MERGE_SHAPE : (thickness == Thickness.TIP ? (state.get(VERTICAL_DIRECTION) == Direction.DOWN ? DOWN_TIP_SHAPE : UP_TIP_SHAPE) : (thickness == Thickness.FRUSTUM ? BASE_SHAPE : (thickness == Thickness.MIDDLE ? FRUSTUM_SHAPE : MIDDLE_SHAPE)));
        Vec3d vec3d = state.getModelOffset(world, pos);
        return voxelShape.offset(vec3d.x, 0.0, vec3d.z);
    }

    @Override
    public boolean isShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    @Override
    public float getMaxHorizontalModelOffset() {
        return 0.125f;
    }

    @Override
    public void onDestroyedOnLanding(World world, BlockPos pos, FallingBlockEntity fallingBlockEntity) {
        if (!fallingBlockEntity.isSilent()) {
            world.syncWorldEvent(WorldEvents.POINTED_DRIPSTONE_LANDS, pos, 0);
        }
    }

    @Override
    public DamageSource getDamageSource() {
        return DamageSource.FALLING_STALACTITE;
    }

    @Override
    public Predicate<Entity> getEntityPredicate() {
        return EntityPredicates.EXCEPT_CREATIVE_OR_SPECTATOR.and(EntityPredicates.VALID_LIVING_ENTITY);
    }

    private void scheduleFall(BlockState state, WorldAccess world, BlockPos pos) {
        BlockPos blockPos = PointedJalsphireCrystal.getTipPos(state, world, pos, Integer.MAX_VALUE, true);
        if (blockPos == null) {
            return;
        }
        BlockPos.Mutable mutable = blockPos.mutableCopy();
        mutable.move(Direction.DOWN);
        BlockState blockState = world.getBlockState(mutable);
        if (blockState.getCollisionShape(world, mutable, ShapeContext.absent()).getMax(Direction.Axis.Y) >= 1.0 || blockState.isOf(Blocks.POWDER_SNOW)) {
            world.breakBlock(blockPos, true);
            mutable.move(Direction.UP);
        }
        mutable.move(Direction.UP);
        while (PointedJalsphireCrystal.isPointingDown(world.getBlockState(mutable))) {
            world.createAndScheduleBlockTick(mutable, this, 2);
            mutable.move(Direction.UP);
        }
    }

    private static int getStalactiteSize(ServerWorld world, BlockPos pos, int range) {
        int i;
        BlockPos.Mutable mutable = pos.mutableCopy().move(Direction.UP);
        for (i = 1; i < range && PointedJalsphireCrystal.isPointingDown(world.getBlockState(mutable)); ++i) {
            mutable.move(Direction.UP);
        }
        return i;
    }

    private static void spawnFallingBlock(BlockState state, ServerWorld world, BlockPos pos) {
        Vec3d.ofBottomCenter(pos);
        BlockPos.Mutable mutable = pos.mutableCopy();
        BlockState blockState = state;
        FallingBlockEntity fallingBlockEntity = FallingBlockEntity.spawnFromBlock(world, mutable, blockState);
        if (PointedJalsphireCrystal.isTip(state, true)) {
            int i = PointedJalsphireCrystal.getStalactiteSize(world, pos, 6);
            float f = 1.0f * (float)i;
            fallingBlockEntity.setHurtEntities(f, 40);
        }
        world.spawnEntity(fallingBlockEntity);
    }

    @VisibleForTesting
    public static void tryGrow(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState blockState = world.getBlockState(pos.up(1));
        if (!PointedJalsphireCrystal.canGrow(blockState, world.getBlockState(pos.up(2)))) {
            return;
        }
        BlockPos blockPos = PointedJalsphireCrystal.getTipPos(state, world, pos, 7, false);
        if (blockPos == null) {
            return;
        }
        BlockState blockState3 = world.getBlockState(blockPos);
        if (!PointedJalsphireCrystal.canDrip(blockState3) || !PointedJalsphireCrystal.canGrow(blockState3, world, blockPos)) {
            return;
        }
        if (random.nextBoolean()) {
            PointedJalsphireCrystal.tryGrow(world, blockPos, Direction.DOWN);
        } else {
            PointedJalsphireCrystal.tryGrowStalagmite(world, blockPos);
        }
    }

    private static void tryGrowStalagmite(ServerWorld world, BlockPos pos) {
        BlockPos.Mutable mutable = pos.mutableCopy();
        for (int i = 0; i < 10; ++i) {
            mutable.move(Direction.DOWN);
            BlockState blockState = world.getBlockState(mutable);
            if (!blockState.getFluidState().isEmpty()) {
                return;
            }
            if (PointedJalsphireCrystal.isTip(blockState, Direction.UP) && PointedJalsphireCrystal.canGrow(blockState, world, mutable)) {
                PointedJalsphireCrystal.tryGrow(world, mutable, Direction.UP);
                return;
            }
            if (!PointedJalsphireCrystal.canPlaceAtWithDirection(world, mutable, Direction.UP) || world.isWater((BlockPos)mutable.down())) continue;
            PointedJalsphireCrystal.tryGrow(world, (BlockPos)mutable.down(), Direction.UP);
            return;
        }
    }

    private static void tryGrow(ServerWorld world, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        if (PointedJalsphireCrystal.isTip(blockState, direction.getOpposite())) {
            PointedJalsphireCrystal.growMerged(blockState, world, blockPos);
        } else if (blockState.isAir() || blockState.isOf(Blocks.WATER)) {
            PointedJalsphireCrystal.place(world, blockPos, direction, Thickness.TIP);
        }
    }

    private static void place(WorldAccess world, BlockPos pos, Direction direction, Thickness thickness) {
        BlockState blockState = (BlockState)((BlockState)((BlockState)LirothBlocks.POINTED_JALSPHIRE_CRYSTAL.getDefaultState().with(VERTICAL_DIRECTION, direction)).with(THICKNESS, thickness)).with(WATERLOGGED, world.getFluidState(pos).getFluid() == Fluids.WATER);
        world.setBlockState(pos, blockState, Block.NOTIFY_ALL);
    }

    private static void growMerged(BlockState state, WorldAccess world, BlockPos pos) {
        BlockPos blockPos2;
        BlockPos blockPos;
        if (state.get(VERTICAL_DIRECTION) == Direction.UP) {
            blockPos = pos;
            blockPos2 = pos.up();
        } else {
            blockPos2 = pos;
            blockPos = pos.down();
        }
        PointedJalsphireCrystal.place(world, blockPos2, Direction.DOWN, Thickness.TIP_MERGE);
        PointedJalsphireCrystal.place(world, blockPos, Direction.UP, Thickness.TIP_MERGE);
    }

    public static void createParticle(World world, BlockPos pos, BlockState state) {
        PointedJalsphireCrystal.getFluid(world, pos, state).ifPresent(fluid -> PointedJalsphireCrystal.createParticle(world, pos, state, fluid));
    }

    private static void createParticle(World world, BlockPos pos, BlockState state, Fluid fluid) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        double e = (double)pos.getX() + 0.5 + vec3d.x;
        double f = (double)((float)(pos.getY() + 1) - 0.6875f) - 0.0625;
        double g = (double)pos.getZ() + 0.5 + vec3d.z;
        Fluid fluid2 = PointedJalsphireCrystal.getDripFluid(world, fluid);
        DefaultParticleType particleEffect = fluid2.getDefaultState().isIn(FluidTags.LAVA) ? ParticleTypes.DRIPPING_DRIPSTONE_LAVA : ParticleTypes.DRIPPING_DRIPSTONE_WATER;
        world.addParticle(particleEffect, e, f, g, 0.0, 0.0, 0.0);
    }

    @Nullable
    private static BlockPos getTipPos(BlockState state2, WorldAccess world, BlockPos pos, int range, boolean allowMerged) {
        if (PointedJalsphireCrystal.isTip(state2, allowMerged)) {
            return pos;
        }
        Direction direction = state2.get(VERTICAL_DIRECTION);
        Predicate<BlockState> predicate = state -> state.isOf(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL) && state.get(VERTICAL_DIRECTION) == direction;
        return PointedJalsphireCrystal.searchInDirection(world, pos, direction.getDirection(), predicate, state -> PointedJalsphireCrystal.isTip(state, allowMerged), range).orElse(null);
    }

    @Nullable
    private static Direction getDirectionToPlaceAt(WorldView world, BlockPos pos, Direction direction) {
        Direction direction2;
        if (PointedJalsphireCrystal.canPlaceAtWithDirection(world, pos, direction)) {
            direction2 = direction;
        } else if (PointedJalsphireCrystal.canPlaceAtWithDirection(world, pos, direction.getOpposite())) {
            direction2 = direction.getOpposite();
        } else {
            return null;
        }
        return direction2;
    }

    private static Thickness getThickness(WorldView world, BlockPos pos, Direction direction, boolean tryMerge) {
        Direction direction2 = direction.getOpposite();
        BlockState blockState = world.getBlockState(pos.offset(direction));
        if (PointedJalsphireCrystal.isPointedDripstoneFacingDirection(blockState, direction2)) {
            if (tryMerge || blockState.get(THICKNESS) == Thickness.TIP_MERGE) {
                return Thickness.TIP_MERGE;
            }
            return Thickness.TIP;
        }
        if (!PointedJalsphireCrystal.isPointedDripstoneFacingDirection(blockState, direction)) {
            return Thickness.TIP;
        }
        Thickness thickness = blockState.get(THICKNESS);
        if (thickness == Thickness.TIP || thickness == Thickness.TIP_MERGE) {
            return Thickness.FRUSTUM;
        }
        BlockState blockState2 = world.getBlockState(pos.offset(direction2));
        if (!PointedJalsphireCrystal.isPointedDripstoneFacingDirection(blockState2, direction)) {
            return Thickness.BASE;
        }
        return Thickness.MIDDLE;
    }

    public static boolean canDrip(BlockState state) {
        return PointedJalsphireCrystal.isPointingDown(state) && state.get(THICKNESS) == Thickness.TIP && state.get(WATERLOGGED) == false;
    }

    private static boolean canGrow(BlockState state, ServerWorld world, BlockPos pos) {
        Direction direction = state.get(VERTICAL_DIRECTION);
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        if (!blockState.getFluidState().isEmpty()) {
            return false;
        }
        if (blockState.isAir()) {
            return true;
        }
        return PointedJalsphireCrystal.isTip(blockState, direction.getOpposite());
    }

    private static Optional<BlockPos> getSupportingPos(World world, BlockPos pos, BlockState state2, int range) {
        Direction direction = state2.get(VERTICAL_DIRECTION);
        Predicate<BlockState> predicate = state -> state.isOf(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL) && state.get(VERTICAL_DIRECTION) == direction;
        return PointedJalsphireCrystal.searchInDirection(world, pos, direction.getOpposite().getDirection(), predicate, state -> !state.isOf(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL), range);
    }

    private static boolean canPlaceAtWithDirection(WorldView world, BlockPos pos, Direction direction) {
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isSideSolidFullSquare(world, blockPos, direction) || PointedJalsphireCrystal.isPointedDripstoneFacingDirection(blockState, direction);
    }

    private static boolean isTip(BlockState state, boolean allowMerged) {
        if (!state.isOf(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL)) {
            return false;
        }
        Thickness thickness = state.get(THICKNESS);
        return thickness == Thickness.TIP || allowMerged && thickness == Thickness.TIP_MERGE;
    }

    private static boolean isTip(BlockState state, Direction direction) {
        return PointedJalsphireCrystal.isTip(state, false) && state.get(VERTICAL_DIRECTION) == direction;
    }

    private static boolean isPointingDown(BlockState state) {
        return PointedJalsphireCrystal.isPointedDripstoneFacingDirection(state, Direction.DOWN);
    }

    private static boolean isPointingUp(BlockState state) {
        return PointedJalsphireCrystal.isPointedDripstoneFacingDirection(state, Direction.UP);
    }

    private static boolean isHeldByPointedDripstone(BlockState state, WorldView world, BlockPos pos) {
        return PointedJalsphireCrystal.isPointingDown(state) && !world.getBlockState(pos.up()).isOf(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    private static boolean isPointedDripstoneFacingDirection(BlockState state, Direction direction) {
        return state.isOf(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL) && state.get(VERTICAL_DIRECTION) == direction;
    }

    @Nullable
    public static BlockPos getDripPos(World world, BlockPos pos) {
        return PointedJalsphireCrystal.searchInDirection(world, pos, Direction.UP.getDirection(), AbstractBlock.AbstractBlockState::isAir, PointedJalsphireCrystal::canDrip, 11).orElse(null);
    }

    public static Fluid getDripFluid(World world, BlockPos pos) {
        return PointedJalsphireCrystal.getFluid(world, pos, world.getBlockState(pos)).filter(PointedJalsphireCrystal::isFluidLiquid).orElse(Fluids.EMPTY);
    }

    private static Optional<Fluid> getFluid(World world, BlockPos pos2, BlockState state) {
        if (!PointedJalsphireCrystal.isPointingDown(state)) {
            return Optional.empty();
        }
        return PointedJalsphireCrystal.getSupportingPos(world, pos2, state, 11).map(pos -> world.getFluidState(pos.up()).getFluid());
    }

    /**
     * {@return whether the provided {@code fluid} is liquid, namely lava or water}
     */
    private static boolean isFluidLiquid(Fluid fluid) {
        return fluid == Fluids.LAVA || fluid == Fluids.WATER;
    }

    private static boolean canGrow(BlockState dripstoneBlockState, BlockState waterState) {
        return dripstoneBlockState.isOf(LirothBlocks.JALSPHIRE_CRYSTAL_BLOCK) && waterState.isOf(Blocks.WATER) && waterState.getFluidState().isStill();
    }

    private static Fluid getDripFluid(World world, Fluid fluid) {
        if (fluid.matchesType(Fluids.EMPTY)) {
            return world.getDimension().ultrawarm() ? Fluids.LAVA : Fluids.WATER;
        }
        return fluid;
    }

    private static Optional<BlockPos> searchInDirection(WorldAccess world, BlockPos pos, Direction.AxisDirection direction, Predicate<BlockState> continuePredicate, Predicate<BlockState> stopPredicate, int range) {
        Direction direction2 = Direction.get(direction, Direction.Axis.Y);
        BlockPos.Mutable mutable = pos.mutableCopy();
        for (int i = 1; i < range; ++i) {
            mutable.move(direction2);
            BlockState blockState = world.getBlockState(mutable);
            if (stopPredicate.test(blockState)) {
                return Optional.of(mutable.toImmutable());
            }
            if (!world.isOutOfHeightLimit(mutable.getY()) && continuePredicate.test(blockState)) continue;
            return Optional.empty();
        }
        return Optional.empty();
    }
}