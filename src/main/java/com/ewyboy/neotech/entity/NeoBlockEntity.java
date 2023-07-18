package com.ewyboy.neotech.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;

public class NeoBlockEntity extends BlockEntity {

	private EnergyStorage energyStorage;

    private CompoundTag energyTag;

    private final LazyOptional<EnergyStorage> energy = LazyOptional.of(() -> energyStorage);


    public NeoBlockEntity(BlockEntityType<?> entityType, BlockPos pos, BlockState state) {
        super(entityType, pos, state);
    }




}
