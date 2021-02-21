package me.luligabi.elementalcreepers.entity.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.sound.SoundEvents;

import java.util.EnumSet;

public class CookieCreeperIgniteGoal extends Goal {

    private final CreeperEntity creeper;
    private LivingEntity target;

    public CookieCreeperIgniteGoal(CreeperEntity creeperEntity) {
        this.creeper = creeperEntity;
        this.setControls(EnumSet.of(Goal.Control.MOVE));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.creeper.getTarget();
        return this.creeper.getFuseSpeed() > 0 || livingEntity != null && this.creeper.squaredDistanceTo(livingEntity) < 9.0D;
    }

    public void start() {
        this.creeper.getNavigation().stop();
        this.target = this.creeper.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public void ignite() {
        System.out.println("test");
    }

    public void tick() {
        if (this.target == null) {
            //this.creeper.setFuseSpeed(-1);
            this.creeper.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
        } else if (this.creeper.squaredDistanceTo(this.target) > 49.0D) {
            //this.creeper.setFuseSpeed(-1);
            this.creeper.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
        } else if (!this.creeper.getVisibilityCache().canSee(this.target)) {
            //this.creeper.setFuseSpeed(-1);
            this.creeper.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0f, 0.5f);
        } else {
            //this.creeper.setFuseSpeed(1);
            ignite();
        }
    }
}
