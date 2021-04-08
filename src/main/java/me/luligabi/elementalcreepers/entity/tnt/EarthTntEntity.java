package me.luligabi.elementalcreepers.entity.tnt;

import me.luligabi.elementalcreepers.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class EarthTntEntity extends ElementalTntEntity {

    public EarthTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void explode() {
        new ExplosionEffects().earthExplosionEffect(this, this.world, this.getX(), this.getY(), this.getZ());
    }

}