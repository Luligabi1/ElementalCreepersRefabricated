package me.luligabi.elementalcreepers.common.entity.tnt;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class FakeIllusionTntEntity extends ElementalTntEntity {

    public FakeIllusionTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);

    }

    @Override
    public void explode() {
        world.createExplosion(this, getX(), getY(), getZ(), 2, Explosion.DestructionType.NONE);
    }
}