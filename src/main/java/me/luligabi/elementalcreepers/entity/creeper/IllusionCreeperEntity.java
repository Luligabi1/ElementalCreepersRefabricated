package me.luligabi.elementalcreepers.entity.creeper;

import me.luligabi.elementalcreepers.registry.CreeperRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class IllusionCreeperEntity extends ElementalCreeperEntity {

    boolean hasDuplicated = false;

    public IllusionCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new CreeperIgniteGoal(this));
        this.goalSelector.add(3, new FleeEntityGoal(this, OcelotEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.add(3, new FleeEntityGoal(this, CatEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(1, new IllusionCreeperFollowTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new RevengeGoal(this, new Class[0]));
    }

    @Override
    public void onExplode() {
        this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(),
                3,  this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ?
                Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE);
        super.onExplode();
        hasDuplicated = false;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound compoundTag) {
        super.writeCustomDataToNbt(compoundTag);
        compoundTag.putBoolean("hasDuplicated", hasDuplicated);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound compoundTag) {
        super.readCustomDataFromNbt(compoundTag);
        this.hasDuplicated = compoundTag.getBoolean("hasDuplicated");
    }

    public boolean hasDuplicated() { return hasDuplicated; }
    public void setHasDuplicated(boolean hasDuplicated) { this.hasDuplicated = hasDuplicated; }

    static class IllusionCreeperFollowTargetGoal extends FollowTargetGoal {

        public IllusionCreeperFollowTargetGoal(MobEntity mobEntity, Class class_, boolean bl) {
            super(mobEntity, class_, bl);
        }

        @Override
        public void start() {
            this.mob.setTarget(this.targetEntity);
            if(!((IllusionCreeperEntity) this.mob).hasDuplicated()) {
                for (int i = 0; i < 4; ++i) {
                    FakeIllusionCreeperEntity fakeIllusionCreeperEntity = new FakeIllusionCreeperEntity(CreeperRegistry.FAKE_ILLUSION_CREEPER, this.mob.world);
                    fakeIllusionCreeperEntity.refreshPositionAfterTeleport(this.mob.getX(), this.mob.getY(), this.mob.getZ());
                    this.mob.world.spawnEntity(fakeIllusionCreeperEntity);
                    fakeIllusionCreeperEntity.setVelocity(0, 0.5D, 0);
                }
                this.mob.setVelocity(0, 0.5D, 0);
                ((IllusionCreeperEntity) this.mob).setHasDuplicated(true);
            }
            super.start();
        }
    }


}