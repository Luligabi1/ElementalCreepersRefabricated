package me.luligabi.elementalcreepers.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class LightCreeperEntity extends ElementalCreeperEntity {

    public LightCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public void onExplode() {
        for(Entity entity : this.world.getOtherEntities(null, new Box(this.getX()-5, this.getY()-5, this.getZ()-5, this.getX()+5, this.getY()+5, this.getZ()+5))) {
            if(entity.isLiving()) {
                ((LivingEntity) entity).applyStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 60 * 20, 1));
            }
        }
        super.onExplode();
    }
}