package me.luligabi.elementalcreepers.entity;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.SimpleConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;


public class AirCreeperEntity extends ElementalCreeperEntity {

    public AirCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    SimpleConfig config = new ElementalCreepers().getConfig();

    @Override
    public void onExplode() {
        this.world.createExplosion(this,
                this.getX(), this.getY(), this.getZ(),
                0, Explosion.DestructionType.NONE);
        for(Entity entity : this.world.getOtherEntities(null, new Box(this.getX()-5, this.getY()-5, this.getZ()-5, this.getX()+5, this.getY()+5, this.getZ()+5))) {
            entity.setVelocity(0, !this.shouldRenderOverlay() ?
                    config.getOrDefault("airCreeperRadius", 1.75D) :
                    config.getOrDefault("airCreeperRadius", 1.75D)*1.5, 0);
        }
        super.onExplode();
    }
}