package me.luligabi.elementalcreepers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class HydrogenCreeperEntity extends ElementalCreeperEntity {

    public HydrogenCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public void onExplode() {
        this.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(),
                9, this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ?
                        Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE);
        super.onExplode();
    }
}