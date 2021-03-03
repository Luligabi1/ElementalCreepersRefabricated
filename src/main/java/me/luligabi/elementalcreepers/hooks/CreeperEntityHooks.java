package me.luligabi.elementalcreepers.hooks;

import me.luligabi.elementalcreepers.entity.AirCreeperEntity;
import me.luligabi.elementalcreepers.entity.ElementalCreeperEntity;
import me.luligabi.elementalcreepers.entity.FireCreeperEntity;
import me.luligabi.elementalcreepers.entity.MagmaCreeperEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


public class CreeperEntityHooks {

    public static void onExplode(CreeperEntity creeperEntity, CallbackInfo info) {
        if(!creeperEntity.world.isClient && creeperEntity instanceof ElementalCreeperEntity && !(creeperEntity instanceof AirCreeperEntity)) {
            ((ElementalCreeperEntity) creeperEntity).onExplode();
            info.cancel();
        }
        if(creeperEntity instanceof AirCreeperEntity) {
            ((ElementalCreeperEntity) creeperEntity).onExplode();
            info.cancel();
        }
    }
    public static void tick(CreeperEntity creeperEntity) {
        if(!creeperEntity.hasStatusEffect(StatusEffects.FIRE_RESISTANCE) && !creeperEntity.isDead() && creeperEntity instanceof FireCreeperEntity || creeperEntity instanceof MagmaCreeperEntity) {
            creeperEntity.applyStatusEffect(new StatusEffectInstance(
                    StatusEffects.FIRE_RESISTANCE, 9999*20, 0, true, false, false));
        }
    }
}
