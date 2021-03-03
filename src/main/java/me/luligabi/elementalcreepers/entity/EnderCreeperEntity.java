package me.luligabi.elementalcreepers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class EnderCreeperEntity extends ElementalCreeperEntity {

    public EnderCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(),
                0, Explosion.DestructionType.NONE);
        for(int i = 0; i < 5; ++i) {
            this.world.spawnEntity(new ShulkerBulletEntity(this.world, this, this.getTarget(), Direction.Axis.X));
        }
        super.onExplode();
    }
}