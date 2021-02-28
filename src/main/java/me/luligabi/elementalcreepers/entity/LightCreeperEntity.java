package me.luligabi.elementalcreepers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class LightCreeperEntity extends ElementalCreeperEntity {

    public LightCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public void onExplode() {
        super.onExplode();
    }
}