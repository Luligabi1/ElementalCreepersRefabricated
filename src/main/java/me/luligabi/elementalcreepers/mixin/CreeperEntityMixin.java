package me.luligabi.elementalcreepers.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
        if(creeperEntity.getEntityWorld().isClient) return;
        switch(this.getClass().getSimpleName()) {
            case "CookieCreeperEntity":
                creeperEntity.getEntityWorld().createExplosion(creeperEntity,
                        creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ(),
                        0, Explosion.DestructionType.NONE);
                creeperEntity.getEntityWorld().spawnEntity(new ItemEntity(creeperEntity.getEntityWorld(),
                        creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ(), new ItemStack(Items.COOKIE, 1)));
                break;
            default:
                Explosion.DestructionType destructionType = creeperEntity.getEntityWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING) ? Explosion.DestructionType.DESTROY : Explosion.DestructionType.NONE;
                creeperEntity.getEntityWorld().createExplosion(creeperEntity,
                        creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ(),
                        (float) 3*(creeperEntity.shouldRenderOverlay() ? 2.0F : 1.0F), destructionType);
                break;
        }
        ((LivingEntityAccessor) creeperEntity).setDead(true);
        creeperEntity.remove();
        ((CreeperEntityInvoker) creeperEntity).invokeSpawnEffectsCloud();
    }
}
