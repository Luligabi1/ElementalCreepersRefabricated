package me.luligabi.elementalcreepers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;


public class IllusionCreeperEntity extends ElementalCreeperEntity {

    public IllusionCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(),
                3, Explosion.DestructionType.NONE);
        super.onExplode();
    }
}