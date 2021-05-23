package me.luligabi.elementalcreepers.entity.tnt;

import me.luligabi.elementalcreepers.entity.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class WaterTntEntity extends ElementalTntEntity {

    public WaterTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void explode() {
        new ExplosionEffects().waterExplosionEffect(this, this.world, this.getX(), this.getY(), this.getZ());
    }

}