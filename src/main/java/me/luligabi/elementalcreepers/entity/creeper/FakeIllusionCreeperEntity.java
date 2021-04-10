package me.luligabi.elementalcreepers.entity.creeper;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;


public class FakeIllusionCreeperEntity extends ElementalCreeperEntity {

    public FakeIllusionCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        super.onExplode();
    }
}