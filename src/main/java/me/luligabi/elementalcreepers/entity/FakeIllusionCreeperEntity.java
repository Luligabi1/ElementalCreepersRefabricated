package me.luligabi.elementalcreepers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;


public class FakeIllusionCreeperEntity extends ElementalCreeperEntity {

    public FakeIllusionCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        //TODO: Add white particle here.
        super.onExplode();
    }
}