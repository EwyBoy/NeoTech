package com.ewyboy.neotech.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class BaseBlockEntity <T extends BlockEntity> extends Block implements EntityBlock {

    public BaseBlockEntity(Properties properties) {
        super(properties);
    }

    protected abstract BlockEntityType.BlockEntitySupplier<T> getTileSupplier();

    protected T getBlockEntity(Level world, BlockPos pos) {
        return (T) world.getBlockEntity(pos);
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return getTileSupplier().create(blockPos, blockState);
    }

}
