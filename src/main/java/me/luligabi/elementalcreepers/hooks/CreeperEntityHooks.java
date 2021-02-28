package me.luligabi.elementalcreepers.hooks;

import me.luligabi.elementalcreepers.entity.ElementalCreeperEntity;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


public class CreeperEntityHooks {

    public static void onExplode(CreeperEntity creeperEntity, CallbackInfo info) {
        if(!creeperEntity.world.isClient && creeperEntity instanceof ElementalCreeperEntity) {
            ((ElementalCreeperEntity) creeperEntity).onExplode();
            info.cancel();
        }
    }
}
