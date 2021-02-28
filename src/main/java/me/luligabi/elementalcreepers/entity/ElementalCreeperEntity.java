package me.luligabi.elementalcreepers.entity;

import me.luligabi.elementalcreepers.mixin.CreeperEntityInvoker;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

@SuppressWarnings("EntityConstructor")
public abstract class ElementalCreeperEntity extends CreeperEntity {

    public ElementalCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    public void onExplode() {
        this.dead = true;
        this.remove();
        ((CreeperEntityInvoker) this).invokeSpawnEffectsCloud();

    }
}
