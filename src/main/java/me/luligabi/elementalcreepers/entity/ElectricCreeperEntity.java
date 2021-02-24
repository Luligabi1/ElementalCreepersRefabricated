package me.luligabi.elementalcreepers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class ElectricCreeperEntity extends CreeperEntity {

    public ElectricCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
}