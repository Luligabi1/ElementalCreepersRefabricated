package me.luligabi.elementalcreepers.common.entity.tnt;

import me.luligabi.elementalcreepers.common.entity.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class IllusionTntEntity extends ElementalTntEntity {

    public IllusionTntEntity(EntityType<? extends ElementalTntEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void explode() {
        ExplosionEffects.illusionTNTExplosionEffect(this, world, getX(), getY(), getZ());
    }

}