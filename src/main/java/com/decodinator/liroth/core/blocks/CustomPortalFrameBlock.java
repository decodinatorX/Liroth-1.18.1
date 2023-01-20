package com.decodinator.liroth.core.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CustomPortalFrameBlock extends RailBlock {
    protected static final VoxelShape BASE_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

	public CustomPortalFrameBlock(Properties properties) {
		super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(SHAPE, RailShape.NORTH_SOUTH)).setValue(POWERED, false)).setValue(WATERLOGGED, false));
	}
	
    protected boolean findPoweredRailSignal(Level level, BlockPos blockPos, BlockState blockState, boolean bl, int i) {
        if (i >= 8) {
            return false;
        }
        int j = blockPos.getX();
        int k = blockPos.getY();
        int l = blockPos.getZ();
        boolean bl2 = true;
        RailShape railShape = blockState.getValue(SHAPE);
        switch (railShape) {
            case NORTH_SOUTH: {
                if (bl) {
                    ++l;
                    break;
                }
                --l;
                break;
            }
            case EAST_WEST: {
                if (bl) {
                    --j;
                    break;
                }
                ++j;
                break;
            }
            case NORTH_EAST: {
            	if (bl) {
            		--j;
                	break;
            	}
            	++j;
            	break;
            }
            case SOUTH_WEST: {
                if (bl) {
                    --j;
                    break;
                }
                ++j;
                break;
            }
            case NORTH_WEST: {
                if (bl) {
                    ++l;
                    break;
                }
                --l;
                break;
            }
            case SOUTH_EAST: {
                if (bl) {
                    ++l;
                    break;
                }
                --l;
                break;
            }
            case ASCENDING_EAST: {
                if (bl) {
                    --j;
                } else {
                    ++j;
                    ++k;
                    bl2 = false;
                }
                railShape = RailShape.EAST_WEST;
                break;
            }
            case ASCENDING_WEST: {
                if (bl) {
                    --j;
                    ++k;
                    bl2 = false;
                } else {
                    ++j;
                }
                railShape = RailShape.EAST_WEST;
                break;
            }
            case ASCENDING_NORTH: {
                if (bl) {
                    ++l;
                } else {
                    --l;
                    ++k;
                    bl2 = false;
                }
                railShape = RailShape.NORTH_SOUTH;
                break;
            }
            case ASCENDING_SOUTH: {
                if (bl) {
                    ++l;
                    ++k;
                    bl2 = false;
                } else {
                    --l;
                }
                railShape = RailShape.NORTH_SOUTH;
            }
        }
        if (this.isSameRailWithPower(level, new BlockPos(j, k, l), bl, i, railShape)) {
            return true;
        }
        return bl2 && this.isSameRailWithPower(level, new BlockPos(j, k - 1, l), bl, i, railShape);
    }
    
    protected boolean isSameRailWithPower(Level level, BlockPos blockPos, boolean bl, int i, RailShape railShape) {
        BlockState blockState = level.getBlockState(blockPos);
        if (!blockState.is(this)) {
            return false;
        }
        RailShape railShape2 = blockState.getValue(SHAPE);
        if (railShape == RailShape.EAST_WEST && (railShape2 == RailShape.NORTH_SOUTH || railShape2 == RailShape.ASCENDING_NORTH || railShape2 == RailShape.ASCENDING_SOUTH)) {
            return false;
        }
        if (railShape == RailShape.NORTH_SOUTH && (railShape2 == RailShape.EAST_WEST || railShape2 == RailShape.ASCENDING_EAST || railShape2 == RailShape.ASCENDING_WEST)) {
            return false;
        }
        if (blockState.getValue(POWERED).booleanValue()) {
            if (level.hasNeighborSignal(blockPos)) {
                return true;
            }
            return this.findPoweredRailSignal(level, blockPos, blockState, bl, i + 1);
        }
        return false;
    }
    
    @Override
    public void updateState(BlockState blockState, Level level, BlockPos blockPos, Block block) {
        boolean bl2;
        boolean bl = blockState.getValue(POWERED);
        boolean bl3 = bl2 = level.hasNeighborSignal(blockPos) || this.findPoweredRailSignal(level, blockPos, blockState, true, 0) || this.findPoweredRailSignal(level, blockPos, blockState, false, 0);
        if (bl2 != bl) {
            level.setBlock(blockPos, (BlockState)blockState.setValue(POWERED, bl2), 3);
            level.updateNeighborsAt(blockPos.below(), this);
            if (blockState.getValue(SHAPE).isAscending()) {
                level.updateNeighborsAt(blockPos.above(), this);
            }
        }
    }
    
    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, POWERED, WATERLOGGED);
    }
	
    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return BASE_SHAPE;
    }
}





















/* extends StairBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape BASE_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape TOP_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape BOTTOM_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape OCTET_NNN = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape OCTET_NNP = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape OCTET_NPN = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape OCTET_NPP = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape OCTET_PNN = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape OCTET_PNP = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape OCTET_PPN = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape OCTET_PPP = Block.box(0.0, 0.0, 0.0, 16.0, 13.0, 16.0);
    protected static final VoxelShape[] TOP_SHAPES = CustomPortalFrameBlock.makeShapes(TOP_AABB, OCTET_NNN, OCTET_PNN, OCTET_NNP, OCTET_PNP);
    protected static final VoxelShape[] BOTTOM_SHAPES = CustomPortalFrameBlock.makeShapes(BOTTOM_AABB, OCTET_NPN, OCTET_PPN, OCTET_NPP, OCTET_PPP);
    private static final int[] SHAPE_BY_STATE = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};

    private static VoxelShape[] makeShapes(VoxelShape voxelShape, VoxelShape voxelShape2, VoxelShape voxelShape3, VoxelShape voxelShape4, VoxelShape voxelShape5) {
        return (VoxelShape[])IntStream.range(0, 16).mapToObj(i -> CustomPortalFrameBlock.makeStairShape(i, voxelShape, voxelShape2, voxelShape3, voxelShape4, voxelShape5)).toArray(VoxelShape[]::new);
    }
    
    private static VoxelShape makeStairShape(int i, VoxelShape voxelShape, VoxelShape voxelShape2, VoxelShape voxelShape3, VoxelShape voxelShape4, VoxelShape voxelShape5) {
        VoxelShape voxelShape6 = voxelShape;
        if ((i & 1) != 0) {
            voxelShape6 = Shapes.or(voxelShape6, voxelShape2);
        }
        if ((i & 2) != 0) {
            voxelShape6 = Shapes.or(voxelShape6, voxelShape3);
        }
        if ((i & 4) != 0) {
            voxelShape6 = Shapes.or(voxelShape6, voxelShape4);
        }
        if ((i & 8) != 0) {
            voxelShape6 = Shapes.or(voxelShape6, voxelShape5);
        }
        return voxelShape6;
    }
    
    private int getShapeIndex(BlockState blockState) {
        return blockState.getValue(SHAPE).ordinal() * 4 + blockState.getValue(FACING).get2DDataValue();
    }
    
    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return (BOTTOM_SHAPES)[SHAPE_BY_STATE[this.getShapeIndex(blockState)]];
    }
    
	public CustomPortalFrameBlock(BlockState blockState, Properties settings) {
		super(blockState, settings);
	}
	
	   @Override
	    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
	        Direction direction = blockPlaceContext.getClickedFace();
	        BlockPos blockPos = blockPlaceContext.getClickedPos();
	        FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPos);
	        BlockState blockState = (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite())).setValue(HALF, direction == Direction.NORTH ? Half.TOP : Half.BOTTOM)).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
	        return (BlockState)blockState.setValue(SHAPE, CustomPortalFrameBlock.getStairsShape(blockState, blockPlaceContext.getLevel(), blockPos));
	    }
	   
	    private static StairsShape getStairsShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
	        Direction direction3;
	        Direction direction2;
	        Direction direction = blockState.getValue(FACING);
	        BlockState blockState2 = blockGetter.getBlockState(blockPos.relative(direction));
	        if (StairBlock.isStairs(blockState2) && blockState.getValue(HALF) == blockState2.getValue(HALF) && (direction2 = blockState2.getValue(FACING)).getAxis() != blockState.getValue(FACING).getAxis() && CustomPortalFrameBlock.canTakeShape(blockState, blockGetter, blockPos, direction2.getOpposite())) {
	            if (direction2 == direction.getCounterClockWise()) {
	                return StairsShape.OUTER_LEFT;
	            }
	            return StairsShape.OUTER_RIGHT;
	        }
	        BlockState blockState3 = blockGetter.getBlockState(blockPos.relative(direction.getOpposite()));
	        if (StairBlock.isStairs(blockState3) && blockState.getValue(HALF) == blockState3.getValue(HALF) && (direction3 = blockState3.getValue(FACING)).getAxis() != blockState.getValue(FACING).getAxis() && CustomPortalFrameBlock.canTakeShape(blockState, blockGetter, blockPos, direction3)) {
	            if (direction3 == direction.getCounterClockWise()) {
	                return StairsShape.INNER_LEFT;
	            }
	            return StairsShape.INNER_RIGHT;
	        }
	        return StairsShape.STRAIGHT;
	    }
	    

	    private static boolean canTakeShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
	        BlockState blockState2 = blockGetter.getBlockState(blockPos.relative(direction));
	        return !StairBlock.isStairs(blockState2) || blockState2.getValue(FACING) != blockState.getValue(FACING) || blockState2.getValue(HALF) != blockState.getValue(HALF);
	    }
	    
	    @Override
	    public BlockState mirror(BlockState blockState, Mirror mirror) {
	        Direction direction = blockState.getValue(FACING);
	        StairsShape stairsShape = blockState.getValue(SHAPE);
	        switch (mirror) {
	            case LEFT_RIGHT: {
	                if (direction.getAxis() != Direction.Axis.Z) break;
	                switch (stairsShape) {
	                    case INNER_LEFT: {
	                        return (BlockState)blockState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT).rotate(mirror.getRotation(blockState.getValue(FACING)));
	                    }
	                    case INNER_RIGHT: {
	                        return (BlockState)blockState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT).rotate(mirror.getRotation(blockState.getValue(FACING)));
	                    }
	                    case OUTER_LEFT: {
	                        return (BlockState)blockState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT).rotate(mirror.getRotation(blockState.getValue(FACING)));
	                    }
	                    case OUTER_RIGHT: {
	                        return (BlockState)blockState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT).rotate(mirror.getRotation(blockState.getValue(FACING)));
	                    }
	                }
	                return blockState.rotate(Rotation.CLOCKWISE_180).rotate(mirror.getRotation(blockState.getValue(FACING)));
	            }
	            case FRONT_BACK: {
	                if (direction.getAxis() != Direction.Axis.X) break;
	                switch (stairsShape) {
	                    case INNER_LEFT: {
	                        return (BlockState)blockState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT).rotate(mirror.getRotation(blockState.getValue(FACING)));
	                    }
	                    case INNER_RIGHT: {
	                        return (BlockState)blockState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT).rotate(mirror.getRotation(blockState.getValue(FACING)));
	                    }
	                    case OUTER_LEFT: {
	                        return (BlockState)blockState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT).rotate(mirror.getRotation(blockState.getValue(FACING)));
	                    }
	                    case OUTER_RIGHT: {
	                        return (BlockState)blockState.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT).rotate(mirror.getRotation(blockState.getValue(FACING)));
	                    }
	                    case STRAIGHT: {
	                        return blockState.rotate(Rotation.CLOCKWISE_180).rotate(mirror.getRotation(blockState.getValue(FACING)));
	                    }
	                }
	                break;
	            }
	        }
	        return super.mirror(blockState, mirror).rotate(mirror.getRotation(blockState.getValue(FACING)));
	    }
}*/
