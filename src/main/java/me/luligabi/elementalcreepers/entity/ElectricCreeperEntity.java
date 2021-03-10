package me.luligabi.elementalcreepers.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class ElectricCreeperEntity extends ElementalCreeperEntity {

    public ElectricCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
    @Override
    public void onExplode() {
        LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(this.world);
        lightningEntity.setCosmetic(!this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING));
        lightningEntity.refreshPositionAfterTeleport(this.getX(), this.getY(), this.getZ());
        this.getEntityWorld().spawnEntity(lightningEntity);
        super.onExplode();
    }
}