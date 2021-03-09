package me.luligabi.elementalcreepers.mixin;

import me.luligabi.elementalcreepers.ElementalCreepers;
import me.luligabi.elementalcreepers.hook.DefaultBiomeFeaturesHook;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {

    @Inject(at = @At("TAIL"), method = "addMonsters", cancellable = true)
    private static void injectAddMonsters(SpawnSettings.Builder builder, int i, int j, int k, CallbackInfo info) {
        new DefaultBiomeFeaturesHook().addMonsters(builder, info);
    }

    @Inject(at = @At("TAIL"), method = "addOceanMobs", cancellable = true)
    private static void injectAddOceanMobs(SpawnSettings.Builder builder, int i, int j, int k, CallbackInfo info) {
        new DefaultBiomeFeaturesHook().addOceanMobs(builder, info);
    }

    @Inject(at = @At("TAIL"), method = "addWarmOceanMobs", cancellable = true)
    private static void injectAddWarmOceanMobs(SpawnSettings.Builder builder, int i, int j, CallbackInfo info) {
        new DefaultBiomeFeaturesHook().addWarmOceanMobs(builder, info);
    }
    @Inject(at = @At("TAIL"), method = "addDesertMobs", cancellable = true)
    private static void injectAddDesertMobs(SpawnSettings.Builder builder, CallbackInfo info) {
        new DefaultBiomeFeaturesHook().addDesertMobs(builder, info);
    }
    @Inject(at = @At("TAIL"), method = "addSnowyMobs", cancellable = true)
    private static void injectAddSnowyMobs(SpawnSettings.Builder builder, CallbackInfo info) {
        new DefaultBiomeFeaturesHook().addSnowyMobs(builder, info);
    }
}
