package me.luligabi.elementalcreepers.common.entity.creeper;

import me.luligabi.elementalcreepers.common.entity.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class HydrogenCreeperEntity extends ElementalCreeperEntity {

    public HydrogenCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        ExplosionEffects.hydrogenExplosionEffect(this, getWorld(), getX(), getY(), getZ());
        super.onExplode();
    }
}