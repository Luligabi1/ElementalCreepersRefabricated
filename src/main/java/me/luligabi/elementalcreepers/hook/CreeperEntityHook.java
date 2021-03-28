package me.luligabi.elementalcreepers.hook;

import me.luligabi.elementalcreepers.entity.creeper.AirCreeperEntity;
import me.luligabi.elementalcreepers.entity.creeper.ElementalCreeperEntity;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


public class CreeperEntityHook {

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
}
