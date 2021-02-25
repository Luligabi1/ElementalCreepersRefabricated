package me.luligabi.elementalcreepers.mixin;

import net.minecraft.entity.*;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.GameRules;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {

    CreeperEntity creeperEntity = ((CreeperEntity) (Object) this);
    //CreeperEntityRenderer creeperEntityRenderer = new CreeperEntityRenderer(creeperEntity)
    LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(creeperEntity.world);
    /**
     * @author Luligabi
     */
    @Overwrite
    private void explode() {
        if(creeperEntity.getEntityWorld().isClient) return;
        //((CreeperEntityRendererInvoker) creeperEntityRenderer).invokerScale(creeperEntity, new MatrixStack(), 0.5F);
        switch(this.getClass().getSimpleName()) {
            case "ElectricCreeperEntity":
                lightningEntity.refreshPositionAfterTeleport(
                        creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ());
                creeperEntity.getEntityWorld().spawnEntity(lightningEntity);
                break;
            case "HydrogenCreeperEntity":
                creeperEntity.getEntityWorld().createExplosion(creeperEntity,
                        creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ(),
                        9, Explosion.DestructionType.DESTROY);
                break;
            case "CookieCreeperEntity":
                creeperEntity.getEntityWorld().createExplosion(creeperEntity,
                        creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ(),
                        0, Explosion.DestructionType.NONE);
                creeperEntity.getEntityWorld().spawnEntity(new ItemEntity(creeperEntity.getEntityWorld(),
                        creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ(), new ItemStack(Items.COOKIE, new Random().nextInt(4 - 2 + 1) + 2)));
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
