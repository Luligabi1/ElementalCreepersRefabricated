package me.luligabi.elementalcreepers.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {

    CreeperEntity creeperEntity = ((CreeperEntity) (Object) this);

    /**
     * @author Luligabi
     */
    @Overwrite
    private void explode() {
        switch(this.getClass().getSimpleName()) {
            case "CookieCreeperEntity":
                System.out.println("test");
                break;
            default:
                Explosion.DestructionType destructionType = creeperEntity.getEntityWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE;
                float f = creeperEntity.shouldRenderOverlay() ? 2.0F : 1.0F;
                creeperEntity.getEntityWorld().createExplosion(creeperEntity, creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ(), (float) 3*f, destructionType);
                System.out.println(this.getClass().getSimpleName());
                break;
        }
        ((LivingEntityAccessor) creeperEntity).setDead(true);
        creeperEntity.remove();
        ((CreeperEntityInvoker) creeperEntity).invokeSpawnEffectsCloud();
    }
}
