package me.luligabi.elementalcreepers.common.entity.creeper;

import me.luligabi.elementalcreepers.common.entity.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;


public class MinerCreeperEntity extends ElementalCreeperEntity {

    public MinerCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        ExplosionEffects.minerExplosionEffect(this, world, getX(), getY(), getZ());
        super.onExplode();
    }
}