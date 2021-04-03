package me.luligabi.elementalcreepers.entity.tnt;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class FakeIllusionTntEntity extends ElementalTntEntity {

    public FakeIllusionTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);

    }

    @Override
    public void explode() {
    }
}