package me.luligabi.elementalcreepers.mixin;

import me.luligabi.elementalcreepers.hooks.CreeperEntityHooks;
import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {

    @Inject(at = @At("HEAD"), method="explode", cancellable = true)
    private void injectExplode(CallbackInfo info) {
        CreeperEntity creeperEntity = ((CreeperEntity) (Object) this);
        CreeperEntityHooks.onExplode(creeperEntity, info);
    }
    @Inject(at = @At("HEAD"), method="tick", cancellable = true)
    public void injectTick(CallbackInfo info) {
        CreeperEntity creeperEntity = ((CreeperEntity) (Object) this);
        CreeperEntityHooks.tick(creeperEntity);
    }
}
