package me.luligabi.elementalcreepers.hook;

import me.luligabi.elementalcreepers.entity.creeper.AirCreeperEntity;
import me.luligabi.elementalcreepers.entity.creeper.ElementalCreeperEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


public class CreeperEntityHook {

    public static void onExplode(CreeperEntity creeperEntity, CallbackInfo info) {
        if(!creeperEntity.world.isClient && creeperEntity instanceof ElementalCreeperEntity && !(creeperEntity instanceof AirCreeperEntity)) {
            ((ElementalCreeperEntity) creeperEntity).onExplode();
            info.cancel();
        }
        if(creeperEntity instanceof AirCreeperEntity) {
            if(!creeperEntity.world.isClient) {
                creeperEntity.world.createExplosion(creeperEntity, creeperEntity.getX(), creeperEntity.getY(), creeperEntity.getZ(), 0, Explosion.DestructionType.NONE);
            }
            ((ElementalCreeperEntity) creeperEntity).onExplode();
            info.cancel();
        }
    }
}
