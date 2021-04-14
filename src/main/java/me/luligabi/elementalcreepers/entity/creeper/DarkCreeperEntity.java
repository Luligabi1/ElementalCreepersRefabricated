package me.luligabi.elementalcreepers.entity.creeper;

import me.luligabi.elementalcreepers.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;


public class DarkCreeperEntity extends ElementalCreeperEntity {

    public DarkCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        new ExplosionEffects().darkExplosionEffect(this, this.world, this.getX(), this.getY(), this.getZ());
        super.onExplode();
    }
}