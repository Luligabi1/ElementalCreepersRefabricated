package me.luligabi.elementalcreepers.common.entity.creeper;

import me.luligabi.elementalcreepers.common.entity.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class ElectricCreeperEntity extends ElementalCreeperEntity {

    public ElectricCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public void onExplode() {
        ExplosionEffects.electricExplosionEffect(getWorld(), getX(), getY(), getZ());
        super.onExplode();
    }
}