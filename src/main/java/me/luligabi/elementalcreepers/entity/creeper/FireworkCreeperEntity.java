package me.luligabi.elementalcreepers.entity.creeper;

import me.luligabi.elementalcreepers.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class FireworkCreeperEntity extends ElementalCreeperEntity {

    public FireworkCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        new ExplosionEffects().fireworkExplosionEffect(this.world, this.getX(), this.getY(), this.getZ());
        super.onExplode();
    }
}