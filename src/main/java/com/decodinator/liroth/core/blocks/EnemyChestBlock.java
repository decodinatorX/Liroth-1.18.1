package com.decodinator.liroth.core.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

import org.betterx.bclib.client.models.BasePatterns;
import org.betterx.bclib.client.models.ModelsHelper;
import org.betterx.bclib.client.models.PatternsHelper;
import org.betterx.bclib.interfaces.BlockModelProvider;
import org.betterx.bclib.registry.BaseBlockEntities;
import org.jetbrains.annotations.Nullable;


import java.util.List;
import java.util.Optional;

public class EnemyChestBlock extends ChestBlock implements BlockModelProvider {
	private final Block parent;
	
	public EnemyChestBlock(Block source) {
		super(FabricBlockSettings.copyOf(source).nonOpaque(), () -> BaseBlockEntities.CHEST);
		this.parent = source;
	}
	
	@Override
	public BlockEntity createBlockEntity(BlockPos blockPos, BlockState blockState) {
		return BaseBlockEntities.CHEST.instantiate(blockPos, blockState);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
		List<ItemStack> drop = super.getDroppedStacks(state, builder);
		drop.add(new ItemStack(this.asItem()));
		return drop;
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public JsonUnbakedModel getItemModel(Identifier blockId) {
		Optional<String> pattern = PatternsHelper.createJson(BasePatterns.ITEM_CHEST, blockId);
		return ModelsHelper.fromPattern(pattern);
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public @Nullable JsonUnbakedModel getBlockModel(Identifier resourceLocation, BlockState blockState) {
		Identifier parentId = Registry.BLOCK.getId(parent);
		return ModelsHelper.createBlockEmpty(parentId);
	}
}
