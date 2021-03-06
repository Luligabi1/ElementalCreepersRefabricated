package me.luligabi.elementalcreepers.entity;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.SimpleConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class HydrogenCreeperEntity extends ElementalCreeperEntity {

    public HydrogenCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    SimpleConfig config = new ElementalCreepers().getConfig();

    @Override
    public void onExplode() {
        this.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(),
                (float) (!this.shouldRenderOverlay() ? config.getOrDefault("hydrogenCreeperRadius", 7F) : config.getOrDefault("hydrogenCreeperRadius", 7F)*1.5), this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ?
                        Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE);
        super.onExplode();
    }
}