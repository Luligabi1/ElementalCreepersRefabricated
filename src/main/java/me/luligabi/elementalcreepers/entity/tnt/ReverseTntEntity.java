package me.luligabi.elementalcreepers.entity.tnt;

import me.luligabi.elementalcreepers.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class ReverseTntEntity extends ElementalTntEntity {

    public ReverseTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void explode() {
        new ExplosionEffects().reverseExplosionEffect(this, this.world, this.getX(), this.getY(), this.getZ());
    }

}