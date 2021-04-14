package me.luligabi.elementalcreepers.entity.tnt;

import me.luligabi.elementalcreepers.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class FireTntEntity extends ElementalTntEntity {

    public FireTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);

    }

    @Override
    public void explode() {
        new ExplosionEffects().fireExplosionEffect(this, this.world, this.getX(), this.getY(), this.getZ());
    }

}