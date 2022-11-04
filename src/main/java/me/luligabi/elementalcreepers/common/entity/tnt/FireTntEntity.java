package me.luligabi.elementalcreepers.common.entity.tnt;

import me.luligabi.elementalcreepers.common.entity.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class FireTntEntity extends ElementalTntEntity {

    public FireTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);

    }

    @Override
    public void explode() {
        ExplosionEffects.fireExplosionEffect(this, world, getX(), getY(), getZ());
    }

}