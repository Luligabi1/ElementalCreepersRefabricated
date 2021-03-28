package me.luligabi.elementalcreepers.entity.tnt;

import me.luligabi.elementalcreepers.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class CookieTntEntity extends ElementalTntEntity {

    public CookieTntEntity(EntityType<? extends ElementalTntEntity> entityEntityType, World world) {
        super(entityEntityType, world);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void explode() {
        new ExplosionEffects().cookieExplosionEffect(this, this.world, this.getX(), this.getY(), this.getZ());
        super.explode();
    }
}