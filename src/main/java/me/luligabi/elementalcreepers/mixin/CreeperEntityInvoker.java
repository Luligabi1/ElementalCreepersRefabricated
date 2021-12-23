package me.luligabi.elementalcreepers.mixin;

import net.minecraft.entity.mob.CreeperEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CreeperEntity.class)
public interface CreeperEntityInvoker {

    @Invoker("spawnEffectsCloud")
    void invokeSpawnEffectsCloud();
}