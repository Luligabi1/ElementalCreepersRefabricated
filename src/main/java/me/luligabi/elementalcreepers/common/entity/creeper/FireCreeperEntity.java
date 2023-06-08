package me.luligabi.elementalcreepers.common.entity.creeper;

import me.luligabi.elementalcreepers.common.entity.ExplosionEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class FireCreeperEntity extends ElementalCreeperEntity {

    public FireCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0F);
    }

    public boolean hurtByWater() {
        return true;
    }

    @Override
    public void onExplode() {
        ExplosionEffects.fireExplosionEffect(this, getWorld(), getX(),getY(), getZ());
        super.onExplode();
    }
}
